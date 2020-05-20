package com.mingrisoft;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取密码编辑框
        final EditText editText = (EditText) findViewById(R.id.editText);
        //获取登录按钮
        final Button button = (Button) findViewById(R.id.btn_login);
        //为编辑框设置监听事件
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editText.length() > 0) {            // 判断编辑框内输入文字时
                    button.setEnabled(true);            //登录按钮为可用状态
                } else {                                //编辑框内没有文字时
                    button.setEnabled(false);           //登录按钮为不可用状态
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }
}