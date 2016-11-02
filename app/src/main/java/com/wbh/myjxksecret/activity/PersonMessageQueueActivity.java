package com.wbh.myjxksecret.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.wbh.myjxksecret.R;

/**
 * Created by Administrator on 2016/10/26 0026.
 */
public class PersonMessageQueueActivity extends Activity{
    public PersonMessageQueueActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.person_message_queue);

    }
}
