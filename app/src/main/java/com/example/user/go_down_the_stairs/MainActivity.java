package com.example.user.go_down_the_stairs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt1_start;
    Button bt1_over;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //把藍藍的標題去掉
        android.support.v7.app.ActionBar bar=getSupportActionBar();
        bar.hide();
        setContentView(R.layout.activity_main);

        bt1_start=(Button)findViewById(R.id.bt1_start);
        bt1_over=(Button)findViewById(R.id.bt1_over);

        bt1_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,GameActivity.class);
                startActivity(intent);

            }
        });

        bt1_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }
}
