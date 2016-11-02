package com.wbh.myjxksecret.myfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wbh.myjxksecret.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GlobalFragment extends Fragment {
    private Context context;
    @BindView(R.id.global_rg)
    RadioGroup global_rg;
    @BindView(R.id.global_classify_btn)
    RadioButton global_classify_btn;
    @BindView(R.id.global_brand_btn)
    RadioButton global_brand_btn;

    private List<Fragment> globalList = new ArrayList<>();
    private int prePosition;



    public GlobalFragment() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_global, container, false);
        ButterKnife.bind(this,view);
        initFragment();
        radioOnClick();
        return view;
    }

    private void radioOnClick() {
        global_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.global_classify_btn:
                        replaceFragment(0);
                        break;
                    case R.id.global_brand_btn:
                        replaceFragment(1);
                        break;
                }
            }
        });
    }

    public void replaceFragment(int i){

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        Fragment currFragment = globalList.get(i);
        Fragment preFragment = globalList.get(prePosition);
        if (currFragment.isAdded()) {
            transaction.show(currFragment).hide(preFragment).commit();
        } else {
            transaction.add(R.id.global_container, currFragment).hide(preFragment).commit();
        }
        prePosition = i;
    }


    private void initFragment() {
        ClassifyFragment classifyFragment = new ClassifyFragment();
        BrandFragment brandFragment = new BrandFragment();
        globalList.add(classifyFragment);
        globalList.add(brandFragment);
        getChildFragmentManager().beginTransaction().replace(R.id.global_container, globalList.get(0)).commit();

        prePosition = 0;
    }
}
