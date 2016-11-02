package com.wbh.myjxksecret.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.ShoppingCarAdapter;
import com.wbh.myjxksecret.javabean.ShoppingGoodsBean;
import com.wbh.myjxksecret.myinterface.MyOnItemSelect;
import com.wbh.myjxksecret.myinterface.MyOnItemSelectLinstener;
import com.wbh.myjxksecret.mysql.ShoppingDBManager;
import com.wbh.myjxksecret.utils.OrderInfoUtil2_0;
import com.wbh.myjxksecret.utils.PayResult;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//APPID: 2016110202475078
public class ShoppingCarActivity extends AppCompatActivity {

    @BindView(R.id.pull_shop_listView)
    PullToRefreshListView pull_shop_listView;
    @BindView(R.id.cb_goods_all)
    CheckBox cb_goods_all;
    @BindView(R.id.tv_shoppingPrice)
    TextView tv_shoppingPrice;
    @BindView(R.id.btn_counts)
    Button btn_counts;
    private ShoppingCarAdapter adapter;
    //总价钱
    private double totalPrice;
    List<ShoppingGoodsBean> shoppingGoodsBeen;
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * 支付宝支付业务：入参app_id
     */
    public static final String APPID = "2088111278561763";

    /**
     * 支付宝账户登录授权业务：入参pid值
     */
    public static final String PID = "gaoyandingzhi@126.com";
    /**
     * 支付宝账户登录授权业务：入参target_id值
     */
    public static final String TARGET_ID = "";

    /**
     * 商户私钥，pkcs8格式
     */
    public static final String RSA_PRIVATE = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBANEClM9ja39OuhbiFcPYG8nUt19TIGvnBjC2CGMV3BKY2pTolVuicMfM0yyxvwtewe7Wkk+06Zl8fjgIWZS8SsfOeznQZbJq236CbcFYIhDsorDllDwQ0Uk409WSjaOCDJamOjGeQjYqy3D7v+z+Z48ZvCOPleX2h415mHQeHWVdAgMBAAECgYB6FrHqOr7uTIRzHXltPu1shi7fJeWIYhjBl3NqvbghvNvho8KrFkYez8yDDQj1kVJjOz+YA6t4lrn77RS2xw4+fRJgBy/LD9ILectaThysuFt84yKooSuFAv1AQKMeVXkpnFuzzBFtxyuRPtPUYXftSvEm/9BapFHGEVCuT7RvAQJBAP9yq18VFhPQAfngld9n0NwmCO33kdbFYqVIWBNKZdvVZIqwIvnmTqsgQacrvWutsWauukKT7VzySkht/uE63j0CQQDRdjgqx4H7SfMjkaZK5nJ6ptuFgR19HkakOJZSIM78Ot3PzfHcnfYuCRjs8lIEWmhYqj2FE+BcZ9cejphGuTWhAkB0XimBXBq9ldGAonXD2whDcbQ5q8EtJKgmgUlWKFs0hQaTQ1/7lZYa0Mv3uq5EwlCBZXGGaNsFr351dl5Y/jdFAkA6D2DmSsL22rqwo1DK9jHJWbMDwJRh+CBwqNbSERIOzGprjZR7KLXycMcd9tVRK5Y87YN7/dR1CLuSVshS4kfBAkAW6ls9/RlBA6gOpDuq+Qn4CZUng3h7OJsDgzCY95RtuMISJNuVFcGC/XVKB+urkyfhR/H7I8HIPXQtNJenH9f2";

    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                String code = payResult.getResultStatus();
                // 判断resultStatus 为9000则代表支付成功
                if ("9000".equals(code)) {
                    Toast.makeText(ShoppingCarActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(ShoppingCarActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_car);
        ButterKnife.bind(this);
        initListView();
    }

    @OnClick(R.id.btn_counts)
    public void clickPay(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                /**
                 * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
                 * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
                 * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
                 *
                 * orderInfo的获取必须来自服务端；
                 */
                Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID);
                String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
                String sign = OrderInfoUtil2_0.getSign(params, RSA_PRIVATE);
                final String orderInfo = orderParam + "&" + sign;

                //构造支付类的对象
                PayTask task = new PayTask(ShoppingCarActivity.this);
                //参数1:订单信息 参数2:
                Map<String, String> result = task.payV2(orderInfo, true);
                //发送结果
                handler.obtainMessage(0, result);
            }
        }).start();

    }

    private void initListView() {
        shoppingGoodsBeen = ShoppingDBManager.newShoppingCarInstance(this).queryAllGoods(null);
        Log.e("Bing", "******旅行便笺中的数量: ******" + shoppingGoodsBeen.size());
        adapter = new ShoppingCarAdapter(map, this, cb_goods_all);
        adapter.setList(shoppingGoodsBeen);
        pull_shop_listView.setAdapter(adapter);
        initCount(adapter);
        initAllSelect(adapter);
        adapter.setMyOnItemSelect(new MyOnItemSelect() {
            @Override
            public void myOnItemSelect(int pos, boolean isChecked) {
                if (isChecked == true) {
                    adapter.getItem(pos).setCount(adapter.getItem(pos).getCount() + 1);
                    double price = adapter.getItem(pos).getLowestPrice();
                    totalPrice += price;
                    DecimalFormat df = new DecimalFormat("0.00");
                    String result = df.format(totalPrice);
                    tv_shoppingPrice.setText(result + "元");
                    adapter.notifyDataSetChanged();
                } else {
                    if (adapter.getItem(pos).getCount() > 0) {
                        adapter.getItem(pos).setCount(adapter.getItem(pos).getCount() - 1);
                        double price = adapter.getItem(pos).getLowestPrice();
                        totalPrice -= price;
                        DecimalFormat df = new DecimalFormat("0.00");
                        String result = df.format(totalPrice);
                        tv_shoppingPrice.setText(result);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    //点击全选
    private void initAllSelect(final ShoppingCarAdapter adapter) {
        cb_goods_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //全选添加到map中
                if (cb_goods_all.isChecked()) {
                    for (int i = 0; i < shoppingGoodsBeen.size(); i++) {
                        map.put(i, i);
                        adapter.getItem(i).setCount(adapter.getItem(i).getCount() + 1);

                        double lowestPrice = adapter.getItem(i).getLowestPrice();
                        totalPrice += lowestPrice;
                        DecimalFormat df = new DecimalFormat("0.00");
                        String result = df.format(totalPrice);
                        tv_shoppingPrice.setText(result + "元");
                    }
                } else {
                    //一个都不选清除map中数据
                    map.clear();
                    for (int i = 0; i < shoppingGoodsBeen.size(); i++) {
                        int count = adapter.getItem(i).getCount() - 1;
                        if (count >= 0) {
                            adapter.getItem(i).setCount(count);
                        }
                        double lowestPrice = adapter.getItem(i).getLowestPrice();
                        totalPrice -= lowestPrice;
                        DecimalFormat df = new DecimalFormat("0.00");
                        String result = df.format(totalPrice);
                        tv_shoppingPrice.setText(result + "元");
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    //改变结算商品数量
    private void initCount(final ShoppingCarAdapter adapter) {
        adapter.setMyOnItemSelectLinstener(new MyOnItemSelectLinstener() {
            @Override
            public void myOnItemSelectLinstener(int position, boolean isChecked) {
                if (isChecked) {
                    // 添加
                    adapter.getItem(position).setCount(adapter.getItem(position).getCount() + 1);
                    double price = adapter.getItem(position).getLowestPrice();
                    totalPrice += price;
                    DecimalFormat df = new DecimalFormat("0.00");
                    String result = df.format(totalPrice);
                    tv_shoppingPrice.setText(String.valueOf(result));
                    adapter.notifyDataSetChanged();
                } else {
                    // 减
                    if (adapter.getItem(position).getCount() > 0) {
                        adapter.getItem(position).setCount(adapter.getItem(position).getCount() - 1);
                        double price = adapter.getItem(position).getLowestPrice();
                        totalPrice -= price;
                        DecimalFormat df = new DecimalFormat("0.00");
                        String result = df.format(totalPrice);
                        tv_shoppingPrice.setText(String.valueOf(result));
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

}
