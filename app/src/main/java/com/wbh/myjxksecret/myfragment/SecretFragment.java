package com.wbh.myjxksecret.myfragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wbh.myjxksecret.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecretFragment extends Fragment {

    @BindView(R.id.iv_secret_homebar)
    ImageView iv_secret_homebar;

    @BindView(R.id.secret_group)
    RadioGroup secret_group;

    @BindView(R.id.rb_secret_select)
    RadioButton rb_secret_select;

    @BindView(R.id.rb_secret_focus)
    RadioButton rb_secret_focus;

    @BindView(R.id.rb_secret_square)
    RadioButton rb_secret_square;
    @BindView(R.id.secret_container)
    FrameLayout secret_container;
    private Context context;
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<RadioButton> buttonList = new ArrayList<>();
    private int prePosition;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secret, container, false);
        ButterKnife.bind(this, view);
        initFragment();
        initRadioButton();
        return view;
    }

    private void initFragment() {
        Secret_FocusFragment focusFragment = new Secret_FocusFragment();
        Secret_SelectFragment selectFragment = new Secret_SelectFragment();
        Secret_SquareFragment squareFragment = new Secret_SquareFragment();
        fragmentList.add(selectFragment);
        fragmentList.add(focusFragment);
        fragmentList.add(squareFragment);
        getChildFragmentManager().beginTransaction().add(R.id.secret_container, fragmentList.get(0)).commit();
        prePosition = 0;
    }

    //RadioButton点击
    private void initRadioButton() {
        buttonList.add(rb_secret_select);
        buttonList.add(rb_secret_focus);
        buttonList.add(rb_secret_square);
        secret_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_secret_select:
                        replaceFragment(0);
                        break;
                    case R.id.rb_secret_focus:
                        replaceFragment(1);
                        break;
                    case R.id.rb_secret_square:
                        replaceFragment(2);
                        break;
                }
            }
        });
//        rb_secret_select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    rb_secret_select.setTextSize(18);
//                    rb_secret_select.setTextColor(getResources().getColor(R.color.colorBlue));
//                } else {
//                    rb_secret_select.setTextSize(15);
//                    rb_secret_select.setTextColor(Color.BLACK);
//                }
//            }
//        });
//        rb_secret_focus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    rb_secret_focus.setTextSize(18);
//                    rb_secret_focus.setTextColor(getResources().getColor(R.color.colorBlue));
//                } else {
//                    rb_secret_focus.setTextSize(15);
//                    rb_secret_focus.setTextColor(Color.BLACK);
//                }
//            }
//        });
//        rb_secret_square.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    rb_secret_square.setTextSize(18);
//                    rb_secret_square.setTextColor(getResources().getColor(R.color.colorBlue));
//                } else {
//                    rb_secret_square.setTextSize(15);
//                    rb_secret_square.setTextColor(Color.BLACK);
//                }
//            }
//        });
    }

    //点击RadioButton切换Fragment
    private void replaceFragment(int i) {
        //获得事物
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        Fragment currFragment = fragmentList.get(i);
        Fragment preFragment = fragmentList.get(prePosition);
        if (currFragment.isAdded()) {
            transaction.show(currFragment).hide(preFragment).commit();
        } else {
            transaction.add(R.id.secret_container, currFragment).hide(preFragment).commit();
        }
        prePosition = i;
    }

}
