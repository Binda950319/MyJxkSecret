package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.myfragment.BournFragment;
import com.wbh.myjxksecret.myfragment.GlobalFragment;
import com.wbh.myjxksecret.myfragment.HomeFragment;
import com.wbh.myjxksecret.myfragment.PersonFragment;
import com.wbh.myjxksecret.myfragment.SecretFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    RelativeLayout container;
    @BindView(R.id.group)
    RadioGroup group;
    private List<Fragment> fragmentList = new ArrayList<>();
    private int prePosition;
    @BindView(R.id.bourn_rb)
    RadioButton bourn_rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();
        initRadioButton();
        Intent intent = getIntent();
        String contoryid = intent.getStringExtra("contoryid");
        Log.e("mainmainmain", "onCreate: "+contoryid );
        if (contoryid!=null){
            BournFragment bournFragment = new BournFragment();
            Bundle bundle = new Bundle();
            bundle.putString("contoryid",contoryid);
            bournFragment.setArguments(bundle);
            replaceFragment(1);
            bourn_rb.setChecked(true);
        }


    }

    //RadioButton操作
    private void initRadioButton() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.global_rb:
                        replaceFragment(0);
                        break;
                    case R.id.bourn_rb:
                        replaceFragment(1);
                        break;
                    case R.id.home_rb:
                        replaceFragment(2);
                        break;
                    case R.id.secret_rb:
                        replaceFragment(3);
                        break;
                    case R.id.person_rb:
                        replaceFragment(4);
                        break;
                }
            }
        });
    }

    //点击RadioButton切换Fragment
    private void replaceFragment(int i) {
        //获得事物
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment currFragment = fragmentList.get(i);
        Fragment preFragment = fragmentList.get(prePosition);
        if (currFragment.isAdded()) {
            transaction.show(currFragment).hide(preFragment).commit();
        } else {
            transaction.add(R.id.container, currFragment).hide(preFragment).commit();
        }
        prePosition = i;
    }

    //Fragment操作
    private void initFragment() {
        GlobalFragment gloablFragment = new GlobalFragment();
        BournFragment bournFragment = new BournFragment();
        HomeFragment homeFragment = new HomeFragment();
        SecretFragment secretFragment = new SecretFragment();
        PersonFragment personFragment = new PersonFragment();
        fragmentList.add(gloablFragment);
        fragmentList.add(bournFragment);
        fragmentList.add(homeFragment);
        fragmentList.add(secretFragment);
        fragmentList.add(personFragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragmentList.get(2)).commit();
        prePosition = 2;
    }



    //统计功能:统计用户使用时长或者活跃度, 打开次数(必须添加)
    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }
}
