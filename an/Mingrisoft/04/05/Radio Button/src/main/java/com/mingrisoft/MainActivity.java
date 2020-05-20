package com.mingrisoft;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt;                                              //定义提交按钮
    RadioGroup rg;                                         //定义单选按钮组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button) findViewById(R.id.bt);                //通过ID获取布局提交按钮
        rg = (RadioGroup) findViewById(R.id.rg);           //通过ID获取布局单选按钮组
        bt.setOnClickListener(new View.OnClickListener() {  //为提交按钮设置单击事件监听器
            @Override
            public void onClick(View v) {
                for (int i = 0; i < rg.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) rg.getChildAt(i);  //根据索引值获取单选按钮
                    if (radioButton.isChecked()) {                           //判断单选按钮是否被选中
                        if (radioButton.getText().equals("B:100")) {           //判断答案是否正确
                            Toast.makeText(MainActivity.this,
                                    "回答正确", Toast.LENGTH_LONG).show();
                        } else {
                            //错误消息提示框
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("回答错误，下面请看解析：当张山换完零钱之后，" +
                                    "给了顾客75还有价值25元的商品，自己还剩下了25元。这时，" +
                                    "李石来找张山要钱，张山把自己剩下的相当于是李石的25元给了李石，" +
                                    "另外自己掏了75元。这样张山赔了一个25元的商品和75元的人民币，" +
                                    "总共价值100元。");
                            builder.setPositiveButton("确定", null).show();    //单击确定消失
                        }
                        break;                                           //跳出for循环
                    }
                }
            }
        });
    }
}
