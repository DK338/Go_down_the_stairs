package com.example.user.go_down_the_stairs;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game_over_view extends AppCompatActivity {

    TextView tv_g_o;
    Button btG_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //把藍藍的標題去掉
        ActionBar bar = getSupportActionBar();
        bar.hide();
        setContentView(R.layout.game_over_view);
        tv_g_o=(TextView)findViewById(R.id.tv_g_o);
        btG_back=(Button)findViewById(R.id.btG_back);

        Bundle bundle=getIntent().getExtras();



        String text="您的分數為:";
        int score=bundle.getInt("score");



        tv_g_o.setText(text+score);




        btG_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
