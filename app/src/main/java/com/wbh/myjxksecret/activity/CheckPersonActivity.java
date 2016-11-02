package com.wbh.myjxksecret.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.wbh.myjxksecret.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CheckPersonActivity extends AppCompatActivity {

    @BindView(R.id.iv_usercheck_back)
    ImageView iv_usercheck_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_person);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_usercheck_back)
    public void clickBack(View view) {
        finish();
    }
}
