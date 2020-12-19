package com.example.user.go_down_the_stairs;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Interpolator;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class GameActivity extends AppCompatActivity {

    TextView tvG_score;
    ImageButton imgbG_return;
    Button btG_left, btG_right;
    //Drawable img_people=getDrawable(R.drawable.img_people);
    int peopleX,peopleY;
    boolean gameOver=false;

    ImageButton broad_array[][]=new ImageButton [20][16];
    int content[][]=new int[20][16];


        ImageButton broad1, broad2, broad3, broad4, broad5, broad6, broad7, broad8, broad9, broad10, broad11, broad12, broad13, broad14, broad15, broad16, broad17,
                broad18, broad19, broad20, broad21, broad22, broad23, broad24, broad25, broad26, broad27, broad28, broad29, broad30, broad31, broad32, broad33, broad34,
                broad35, broad36, broad37, broad38, broad39, broad40, broad41, broad42, broad43, broad44, broad45, broad46, broad47, broad48, broad49, broad50, broad51,
                broad52, broad53, broad54, broad55, broad56, broad57, broad58, broad59, broad60, broad61, broad62, broad63, broad64, broad65, broad66, broad67, broad68,
                broad69, broad70, broad71, broad72, broad73, broad74, broad75, broad76, broad77, broad78, broad79, broad80, broad81, broad82, broad83, broad84, broad85,
                broad86, broad87, broad88, broad89, broad90, broad91, broad92, broad93, broad94, broad95, broad96, broad97, broad98, broad99, broad100, broad101, broad102,
                broad103, broad104, broad105, broad106, broad107, broad108, broad109, broad110, broad111, broad112, broad113, broad114, broad115, broad116, broad117, broad118, broad119,
                broad120, broad121, broad122, broad123, broad124, broad125, broad126, broad127, broad128, broad129, broad130, broad131, broad132, broad133, broad134, broad135, broad136,
                broad137, broad138, broad139, broad140, broad141, broad142, broad143, broad144, broad145, broad146, broad147, broad148, broad149, broad150, broad151, broad152, broad153,
                broad154, broad155, broad156, broad157, broad158, broad159, broad160, broad161, broad162, broad163, broad164, broad165, broad166, broad167, broad168, broad169, broad170,
                broad171, broad172, broad173, broad174, broad175, broad176, broad177, broad178, broad179, broad180, broad181, broad182, broad183, broad184, broad185, broad186, broad187,
                broad188, broad189, broad190, broad191, broad192, broad193, broad194, broad195, broad196, broad197, broad198, broad199, broad200, broad201, broad202, broad203, broad204,
                broad205, broad206, broad207, broad208, broad209, broad210, broad211, broad212, broad213, broad214, broad215, broad216, broad217, broad218, broad219, broad220, broad221,
                broad222, broad223, broad224, broad225, broad226, broad227, broad228, broad229, broad230, broad231, broad232, broad233, broad234, broad235, broad236, broad237, broad238,
                broad239, broad240, broad241, broad242, broad243, broad244, broad245, broad246, broad247, broad248, broad249, broad250, broad251, broad252, broad253, broad254, broad255,
                broad256, broad257, broad258, broad259, broad260, broad261, broad262, broad263, broad264, broad265, broad266, broad267, broad268, broad269, broad270, broad271, broad272,
                broad273, broad274, broad275, broad276, broad277, broad278, broad279, broad280, broad281, broad282, broad283, broad284, broad285, broad286, broad287, broad288, broad289,
                broad290, broad291, broad292, broad293, broad294, broad295, broad296, broad297, broad298, broad299, broad300, broad301, broad302, broad303, broad304, broad305, broad306,
                broad307, broad308, broad309, broad310, broad311, broad312, broad313, broad314, broad315, broad316, broad317, broad318, broad319, broad320, broad321, broad322, broad323,
                broad324, broad325, broad326, broad327, broad328, broad329, broad330, broad331, broad332, broad333, broad334, broad335, broad336, broad337, broad338, broad339, broad340,
                broad341, broad342, broad343, broad344, broad345, broad346, broad347, broad348, broad349, broad350, broad351, broad352, broad353, broad354, broad355, broad356, broad357,
                broad358, broad359, broad360, broad361, broad362, broad363, broad364, broad365, broad366, broad367, broad368, broad369, broad370, broad371, broad372, broad373, broad374,
                broad375, broad376, broad377, broad378, broad379, broad380, broad381, broad382, broad383, broad384, broad385, broad386, broad387, broad388, broad389, broad390, broad391,
                broad392, broad393, broad394, broad395, broad396, broad397, broad398, broad399, broad400, broad401, broad402, broad403, broad404, broad405, broad406, broad407, broad408;



    private Handler mHandlerTime = new Handler();
    int second=0;
    Random ran;
    int score=0;
    int life = 10;
    String text_score="score:",text_life="life:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //把藍藍的標題去掉
        ActionBar bar = getSupportActionBar();
        bar.hide();
        ran=new Random();
        setContentView(R.layout.activity_game);



        setGame_view();
        broad_f();

        btG_left = (Button) findViewById(R.id.btG_left);
        btG_right = (Button) findViewById(R.id.btG_right);



        btG_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(peopleY>0)
                {
                   if (content[peopleX+1][peopleY-1]==0)
                   {
                       content[peopleX][peopleY] = 0;
                       peopleY--;
                       content[peopleX][peopleY] = 2;
                       reDraw();
                       for(int i=peopleX;i<19;i++)
                       {
                           if(content[peopleX+1][peopleY]==1)
                           {
                               content[peopleX][peopleY]=2;
                               reDraw();
                               score++;
                               tvG_score.setText(text_score + score);
                               break;
                           }
                           else
                           {
                               if(content[18][peopleY]==2)
                               {
                                   content[peopleX][peopleY]=0;
                                   reDraw();
                                   gameOver=true;
                                   mHandlerTime.removeCallbacks(timerRun);
                                   Bundle bundle=new Bundle();
                                   bundle.putInt("score",score);
                                   Intent intent=new Intent();
                                   intent.putExtras(bundle);
                                   intent.setClass(GameActivity.this,Game_over_view.class);
                                   startActivity(intent);
                                   finish();
                                   break;
                               }
                               else
                               {
                                   content[peopleX][peopleY]=0;
                                   peopleX++;
                                   content[peopleX][peopleY]=2;
                                   reDraw();
                               }
                       }

                   }

                    }
                    else
                    {
                        content[peopleX][peopleY] = 0;
                        peopleY--;
                        content[peopleX][peopleY] = 2;
                        reDraw();
                    }


                }


            }
        });

        btG_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (peopleY<14)
                {
                   if(content[peopleX+1][peopleY+1]==0)
                   {
                       content[peopleX][peopleY] = 0;
                       peopleY++;
                       content[peopleX][peopleY] = 2;
                       reDraw();
                       for(int i=peopleX;i<19;i++)
                       {
                           if (content[peopleX+1][peopleY]==1)
                           {
                               content[peopleX][peopleY]=2;
                               reDraw();
                               score++;
                               tvG_score.setText(text_score + score);
                               break;
                           }
                           else
                           {
                               if(content[18][peopleY]==2)
                               {
                                   content[peopleX][peopleY]=0;
                                   reDraw();
                                   gameOver=true;
                                   mHandlerTime.removeCallbacks(timerRun);
                                   Bundle bundle=new Bundle();
                                   bundle.putInt("score",score);
                                   Intent intent=new Intent();
                                   intent.putExtras(bundle);
                                   intent.setClass(GameActivity.this,Game_over_view.class);
                                   startActivity(intent);
                                   finish();
                                   break;
                               }
                               else
                               {
                                   content[peopleX][peopleY] = 0;
                                   peopleX++;
                                   content[peopleX][peopleY] = 2;
                                   reDraw();
                               }
                           }

                       }
                   }
                   else
                   {
                        content[peopleX][peopleY] = 0;
                        peopleY++;
                        content[peopleX][peopleY] = 2;
                        reDraw();
                   }

                }

            }
        });






        mHandlerTime.postDelayed(timerRun, 1000);

    }

    private final Runnable timerRun = new Runnable()
    {
        public void run() {
            ++second; // 經過的秒數 + 1
            //tvG_score.setText(Integer.toString(second));

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 16; j++) {
                    if (i < 19) {
                        content[i][j] = content[i + 1][j];
                        content[0][j] = 3;
                    } else {
                        if (second % 4 == 0) {
                            newBoard(second);
                        } else
                            content[i][j] = 0;
                    }
                }
            }
            peopleX--;
            reDraw();


                if (content[peopleX][peopleY] == 3)
                {
                   // content[peopleX][peopleY] = 3;
                   // reDraw();
                    gameOver=true;

                    Bundle bundle = new Bundle();
                    bundle.putInt("score", score);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(GameActivity.this, Game_over_view.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    reDraw();
                }

           /* else
            {
                if (content[peopleX][peopleY] == 3)
                {
                    content[peopleX][peopleY] = 3;
                    reDraw();

                    mHandlerTime.removeCallbacks(timerRun);
                    Bundle bundle = new Bundle();
                    bundle.putInt("score", score);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(GameActivity.this, Game_over_view.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    reDraw();
                }
            }*/






        if(!gameOver)
            mHandlerTime.postDelayed(this, 500);

            // 若要取消可以寫一個判斷在這決定是否啟動下一次即可
        }
    };

    void reDraw()
    {
        for(int i=0;i<20;i++)
        {
            for(int j=0;j<16;j++)
            {
                if(content[i][j]==0)
                    broad_array[i][j].setBackgroundColor(Color.BLACK);
                else if(content[i][j]==1)
                    broad_array[i][j].setBackgroundColor(Color.BLUE);
                else if (content[i][j]==2)
                {
                    broad_array[i][j].setBackgroundResource(R.drawable.img_people);
                }

                else
                    broad_array[0][j].setBackgroundColor(Color.RED);
            }
        }
    }

    public void setGame_view() {
        tvG_score = (TextView) findViewById(R.id.tvG_score);


        imgbG_return = (ImageButton) findViewById(R.id.imgbG_return);
        imgbG_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameOver=true;
                mHandlerTime.removeCallbacks(timerRun);
                finish();
            }
        });



        tvG_score.setText(text_score + score);


    }

    public void contact() {


    }




    public void broad_f() {
        broad_array[0][0]=(ImageButton)findViewById(R.id.broad1);
        broad_array[0][1]=(ImageButton)findViewById(R.id.broad2);
        broad_array[0][2]=(ImageButton)findViewById(R.id.broad3);
        broad_array[0][3]=(ImageButton)findViewById(R.id.broad4);
        broad_array[0][4]=(ImageButton)findViewById(R.id.broad5);
        broad_array[0][5]=(ImageButton)findViewById(R.id.broad6);
        broad_array[0][6]=(ImageButton)findViewById(R.id.broad7);
        broad_array[0][7]=(ImageButton)findViewById(R.id.broad8);
        broad_array[0][8]=(ImageButton)findViewById(R.id.broad9);
        broad_array[0][9]=(ImageButton)findViewById(R.id.broad10);
        broad_array[0][10]=(ImageButton)findViewById(R.id.broad11);
        broad_array[0][11]=(ImageButton)findViewById(R.id.broad12);
        broad_array[0][12]=(ImageButton)findViewById(R.id.broad13);
        broad_array[0][13]=(ImageButton)findViewById(R.id.broad14);
        broad_array[0][14]=(ImageButton)findViewById(R.id.broad15);
        broad_array[0][15]=(ImageButton)findViewById(R.id.broad16);

        broad_array[1][0]=(ImageButton)findViewById(R.id.broad17);
        broad_array[1][1]=(ImageButton)findViewById(R.id.broad18);
        broad_array[1][2]=(ImageButton)findViewById(R.id.broad19);
        broad_array[1][3]=(ImageButton)findViewById(R.id.broad20);
        broad_array[1][4]=(ImageButton)findViewById(R.id.broad21);
        broad_array[1][5]=(ImageButton)findViewById(R.id.broad22);
        broad_array[1][6]=(ImageButton)findViewById(R.id.broad23);
        broad_array[1][7]=(ImageButton)findViewById(R.id.broad24);
        broad_array[1][8]=(ImageButton)findViewById(R.id.broad25);
        broad_array[1][9]=(ImageButton)findViewById(R.id.broad26);
        broad_array[1][10]=(ImageButton)findViewById(R.id.broad27);
        broad_array[1][11]=(ImageButton)findViewById(R.id.broad28);
        broad_array[1][12]=(ImageButton)findViewById(R.id.broad29);
        broad_array[1][13]=(ImageButton)findViewById(R.id.broad30);
        broad_array[1][14]=(ImageButton)findViewById(R.id.broad31);
        broad_array[1][15]=(ImageButton)findViewById(R.id.broad32);

        broad_array[2][0]=(ImageButton)findViewById(R.id.broad33);
        broad_array[2][1]=(ImageButton)findViewById(R.id.broad34);
        broad_array[2][2]=(ImageButton)findViewById(R.id.broad35);
        broad_array[2][3]=(ImageButton)findViewById(R.id.broad36);
        broad_array[2][4]=(ImageButton)findViewById(R.id.broad37);
        broad_array[2][5]=(ImageButton)findViewById(R.id.broad38);
        broad_array[2][6]=(ImageButton)findViewById(R.id.broad39);
        broad_array[2][7]=(ImageButton)findViewById(R.id.broad40);
        broad_array[2][8]=(ImageButton)findViewById(R.id.broad41);
        broad_array[2][9]=(ImageButton)findViewById(R.id.broad42);
        broad_array[2][10]=(ImageButton)findViewById(R.id.broad43);
        broad_array[2][11]=(ImageButton)findViewById(R.id.broad44);
        broad_array[2][12]=(ImageButton)findViewById(R.id.broad45);
        broad_array[2][13]=(ImageButton)findViewById(R.id.broad46);
        broad_array[2][14]=(ImageButton)findViewById(R.id.broad47);
        broad_array[2][15]=(ImageButton)findViewById(R.id.broad48);

        broad_array[3][0]=(ImageButton)findViewById(R.id.broad49);
        broad_array[3][1]=(ImageButton)findViewById(R.id.broad50);
        broad_array[3][2]=(ImageButton)findViewById(R.id.broad51);
        broad_array[3][3]=(ImageButton)findViewById(R.id.broad52);
        broad_array[3][4]=(ImageButton)findViewById(R.id.broad53);
        broad_array[3][5]=(ImageButton)findViewById(R.id.broad54);
        broad_array[3][6]=(ImageButton)findViewById(R.id.broad55);
        broad_array[3][7]=(ImageButton)findViewById(R.id.broad56);
        broad_array[3][8]=(ImageButton)findViewById(R.id.broad57);
        broad_array[3][9]=(ImageButton)findViewById(R.id.broad58);
        broad_array[3][10]=(ImageButton)findViewById(R.id.broad59);
        broad_array[3][11]=(ImageButton)findViewById(R.id.broad60);
        broad_array[3][12]=(ImageButton)findViewById(R.id.broad61);
        broad_array[3][13]=(ImageButton)findViewById(R.id.broad62);
        broad_array[3][14]=(ImageButton)findViewById(R.id.broad63);
        broad_array[3][15]=(ImageButton)findViewById(R.id.broad64);

        broad_array[4][0]=(ImageButton)findViewById(R.id.broad65);
        broad_array[4][1]=(ImageButton)findViewById(R.id.broad66);
        broad_array[4][2]=(ImageButton)findViewById(R.id.broad67);
        broad_array[4][3]=(ImageButton)findViewById(R.id.broad68);
        broad_array[4][4]=(ImageButton)findViewById(R.id.broad69);
        broad_array[4][5]=(ImageButton)findViewById(R.id.broad70);
        broad_array[4][6]=(ImageButton)findViewById(R.id.broad71);
        broad_array[4][7]=(ImageButton)findViewById(R.id.broad72);
        broad_array[4][8]=(ImageButton)findViewById(R.id.broad73);
        broad_array[4][9]=(ImageButton)findViewById(R.id.broad74);
        broad_array[4][10]=(ImageButton)findViewById(R.id.broad75);
        broad_array[4][11]=(ImageButton)findViewById(R.id.broad76);
        broad_array[4][12]=(ImageButton)findViewById(R.id.broad77);
        broad_array[4][13]=(ImageButton)findViewById(R.id.broad78);
        broad_array[4][14]=(ImageButton)findViewById(R.id.broad79);
        broad_array[4][15]=(ImageButton)findViewById(R.id.broad80);

        broad_array[5][0]=(ImageButton)findViewById(R.id.broad81);
        broad_array[5][1]=(ImageButton)findViewById(R.id.broad82);
        broad_array[5][2]=(ImageButton)findViewById(R.id.broad83);
        broad_array[5][3]=(ImageButton)findViewById(R.id.broad84);
        broad_array[5][4]=(ImageButton)findViewById(R.id.broad85);
        broad_array[5][5]=(ImageButton)findViewById(R.id.broad86);
        broad_array[5][6]=(ImageButton)findViewById(R.id.broad87);
        broad_array[5][7]=(ImageButton)findViewById(R.id.broad88);
        broad_array[5][8]=(ImageButton)findViewById(R.id.broad89);
        broad_array[5][9]=(ImageButton)findViewById(R.id.broad90);
        broad_array[5][10]=(ImageButton)findViewById(R.id.broad91);
        broad_array[5][11]=(ImageButton)findViewById(R.id.broad92);
        broad_array[5][12]=(ImageButton)findViewById(R.id.broad93);
        broad_array[5][13]=(ImageButton)findViewById(R.id.broad94);
        broad_array[5][14]=(ImageButton)findViewById(R.id.broad95);
        broad_array[5][15]=(ImageButton)findViewById(R.id.broad96);

        broad_array[6][0]=(ImageButton)findViewById(R.id.broad97);
        broad_array[6][1]=(ImageButton)findViewById(R.id.broad98);
        broad_array[6][2]=(ImageButton)findViewById(R.id.broad99);
        broad_array[6][3]=(ImageButton)findViewById(R.id.broad100);
        broad_array[6][4]=(ImageButton)findViewById(R.id.broad101);
        broad_array[6][5]=(ImageButton)findViewById(R.id.broad102);
        broad_array[6][6]=(ImageButton)findViewById(R.id.broad103);
        broad_array[6][7]=(ImageButton)findViewById(R.id.broad104);
        broad_array[6][8]=(ImageButton)findViewById(R.id.broad105);
        broad_array[6][9]=(ImageButton)findViewById(R.id.broad106);
        broad_array[6][10]=(ImageButton)findViewById(R.id.broad107);
        broad_array[6][11]=(ImageButton)findViewById(R.id.broad108);
        broad_array[6][12]=(ImageButton)findViewById(R.id.broad109);
        broad_array[6][13]=(ImageButton)findViewById(R.id.broad110);
        broad_array[6][14]=(ImageButton)findViewById(R.id.broad111);
        broad_array[6][15]=(ImageButton)findViewById(R.id.broad112);

        broad_array[7][0]=(ImageButton)findViewById(R.id.broad113);
        broad_array[7][1]=(ImageButton)findViewById(R.id.broad114);
        broad_array[7][2]=(ImageButton)findViewById(R.id.broad115);
        broad_array[7][3]=(ImageButton)findViewById(R.id.broad116);
        broad_array[7][4]=(ImageButton)findViewById(R.id.broad117);
        broad_array[7][5]=(ImageButton)findViewById(R.id.broad118);
        broad_array[7][6]=(ImageButton)findViewById(R.id.broad119);
        broad_array[7][7]=(ImageButton)findViewById(R.id.broad120);
        broad_array[7][8]=(ImageButton)findViewById(R.id.broad121);
        broad_array[7][9]=(ImageButton)findViewById(R.id.broad122);
        broad_array[7][10]=(ImageButton)findViewById(R.id.broad123);
        broad_array[7][11]=(ImageButton)findViewById(R.id.broad124);
        broad_array[7][12]=(ImageButton)findViewById(R.id.broad125);
        broad_array[7][13]=(ImageButton)findViewById(R.id.broad126);
        broad_array[7][14]=(ImageButton)findViewById(R.id.broad127);
        broad_array[7][15]=(ImageButton)findViewById(R.id.broad128);

        broad_array[8][0]=(ImageButton)findViewById(R.id.broad129);
        broad_array[8][1]=(ImageButton)findViewById(R.id.broad130);
        broad_array[8][2]=(ImageButton)findViewById(R.id.broad131);
        broad_array[8][3]=(ImageButton)findViewById(R.id.broad132);
        broad_array[8][4]=(ImageButton)findViewById(R.id.broad133);
        broad_array[8][5]=(ImageButton)findViewById(R.id.broad134);
        broad_array[8][6]=(ImageButton)findViewById(R.id.broad135);
        broad_array[8][7]=(ImageButton)findViewById(R.id.broad136);
        broad_array[8][8]=(ImageButton)findViewById(R.id.broad137);
        broad_array[8][9]=(ImageButton)findViewById(R.id.broad138);
        broad_array[8][10]=(ImageButton)findViewById(R.id.broad139);
        broad_array[8][11]=(ImageButton)findViewById(R.id.broad140);
        broad_array[8][12]=(ImageButton)findViewById(R.id.broad141);
        broad_array[8][13]=(ImageButton)findViewById(R.id.broad142);
        broad_array[8][14]=(ImageButton)findViewById(R.id.broad143);
        broad_array[8][15]=(ImageButton)findViewById(R.id.broad144);

        broad_array[9][0]=(ImageButton)findViewById(R.id.broad145);
        broad_array[9][1]=(ImageButton)findViewById(R.id.broad146);
        broad_array[9][2]=(ImageButton)findViewById(R.id.broad147);
        broad_array[9][3]=(ImageButton)findViewById(R.id.broad148);
        broad_array[9][4]=(ImageButton)findViewById(R.id.broad149);
        broad_array[9][5]=(ImageButton)findViewById(R.id.broad150);
        broad_array[9][6]=(ImageButton)findViewById(R.id.broad151);
        broad_array[9][7]=(ImageButton)findViewById(R.id.broad152);
        broad_array[9][8]=(ImageButton)findViewById(R.id.broad153);
        broad_array[9][9]=(ImageButton)findViewById(R.id.broad154);
        broad_array[9][10]=(ImageButton)findViewById(R.id.broad155);
        broad_array[9][11]=(ImageButton)findViewById(R.id.broad156);
        broad_array[9][12]=(ImageButton)findViewById(R.id.broad157);
        broad_array[9][13]=(ImageButton)findViewById(R.id.broad158);
        broad_array[9][14]=(ImageButton)findViewById(R.id.broad159);
        broad_array[9][15]=(ImageButton)findViewById(R.id.broad160);

        broad_array[10][0]=(ImageButton)findViewById(R.id.broad161);
        broad_array[10][1]=(ImageButton)findViewById(R.id.broad162);
        broad_array[10][2]=(ImageButton)findViewById(R.id.broad163);
        broad_array[10][3]=(ImageButton)findViewById(R.id.broad164);
        broad_array[10][4]=(ImageButton)findViewById(R.id.broad165);
        broad_array[10][5]=(ImageButton)findViewById(R.id.broad166);
        broad_array[10][6]=(ImageButton)findViewById(R.id.broad167);
        broad_array[10][7]=(ImageButton)findViewById(R.id.broad168);
        broad_array[10][8]=(ImageButton)findViewById(R.id.broad169);
        broad_array[10][9]=(ImageButton)findViewById(R.id.broad170);
        broad_array[10][10]=(ImageButton)findViewById(R.id.broad171);
        broad_array[10][11]=(ImageButton)findViewById(R.id.broad172);
        broad_array[10][12]=(ImageButton)findViewById(R.id.broad173);
        broad_array[10][13]=(ImageButton)findViewById(R.id.broad174);
        broad_array[10][14]=(ImageButton)findViewById(R.id.broad175);
        broad_array[10][15]=(ImageButton)findViewById(R.id.broad176);

        broad_array[11][0]=(ImageButton)findViewById(R.id.broad177);
        broad_array[11][1]=(ImageButton)findViewById(R.id.broad178);
        broad_array[11][2]=(ImageButton)findViewById(R.id.broad179);
        broad_array[11][3]=(ImageButton)findViewById(R.id.broad180);
        broad_array[11][4]=(ImageButton)findViewById(R.id.broad181);
        broad_array[11][5]=(ImageButton)findViewById(R.id.broad182);
        broad_array[11][6]=(ImageButton)findViewById(R.id.broad183);
        broad_array[11][7]=(ImageButton)findViewById(R.id.broad184);
        broad_array[11][8]=(ImageButton)findViewById(R.id.broad185);
        broad_array[11][9]=(ImageButton)findViewById(R.id.broad186);
        broad_array[11][10]=(ImageButton)findViewById(R.id.broad187);
        broad_array[11][11]=(ImageButton)findViewById(R.id.broad188);
        broad_array[11][12]=(ImageButton)findViewById(R.id.broad189);
        broad_array[11][13]=(ImageButton)findViewById(R.id.broad190);
        broad_array[11][14]=(ImageButton)findViewById(R.id.broad191);
        broad_array[11][15]=(ImageButton)findViewById(R.id.broad192);

        broad_array[12][0]=(ImageButton)findViewById(R.id.broad193);
        broad_array[12][1]=(ImageButton)findViewById(R.id.broad194);
        broad_array[12][2]=(ImageButton)findViewById(R.id.broad195);
        broad_array[12][3]=(ImageButton)findViewById(R.id.broad196);
        broad_array[12][4]=(ImageButton)findViewById(R.id.broad197);
        broad_array[12][5]=(ImageButton)findViewById(R.id.broad198);
        broad_array[12][6]=(ImageButton)findViewById(R.id.broad199);
        broad_array[12][7]=(ImageButton)findViewById(R.id.broad200);
        broad_array[12][8]=(ImageButton)findViewById(R.id.broad201);
        broad_array[12][9]=(ImageButton)findViewById(R.id.broad202);
        broad_array[12][10]=(ImageButton)findViewById(R.id.broad203);
        broad_array[12][11]=(ImageButton)findViewById(R.id.broad204);
        broad_array[12][12]=(ImageButton)findViewById(R.id.broad205);
        broad_array[12][13]=(ImageButton)findViewById(R.id.broad206);
        broad_array[12][14]=(ImageButton)findViewById(R.id.broad207);
        broad_array[12][15]=(ImageButton)findViewById(R.id.broad208);

        broad_array[13][0]=(ImageButton)findViewById(R.id.broad209);
        broad_array[13][1]=(ImageButton)findViewById(R.id.broad210);
        broad_array[13][2]=(ImageButton)findViewById(R.id.broad211);
        broad_array[13][3]=(ImageButton)findViewById(R.id.broad212);
        broad_array[13][4]=(ImageButton)findViewById(R.id.broad213);
        broad_array[13][5]=(ImageButton)findViewById(R.id.broad214);
        broad_array[13][6]=(ImageButton)findViewById(R.id.broad215);
        broad_array[13][7]=(ImageButton)findViewById(R.id.broad216);
        broad_array[13][8]=(ImageButton)findViewById(R.id.broad217);
        broad_array[13][9]=(ImageButton)findViewById(R.id.broad218);
        broad_array[13][10]=(ImageButton)findViewById(R.id.broad219);
        broad_array[13][11]=(ImageButton)findViewById(R.id.broad220);
        broad_array[13][12]=(ImageButton)findViewById(R.id.broad221);
        broad_array[13][13]=(ImageButton)findViewById(R.id.broad222);
        broad_array[13][14]=(ImageButton)findViewById(R.id.broad223);
        broad_array[13][15]=(ImageButton)findViewById(R.id.broad224);

        broad_array[14][0]=(ImageButton)findViewById(R.id.broad225);
        broad_array[14][1]=(ImageButton)findViewById(R.id.broad226);
        broad_array[14][2]=(ImageButton)findViewById(R.id.broad227);
        broad_array[14][3]=(ImageButton)findViewById(R.id.broad228);
        broad_array[14][4]=(ImageButton)findViewById(R.id.broad229);
        broad_array[14][5]=(ImageButton)findViewById(R.id.broad230);
        broad_array[14][6]=(ImageButton)findViewById(R.id.broad231);
        broad_array[14][7]=(ImageButton)findViewById(R.id.broad232);
        broad_array[14][8]=(ImageButton)findViewById(R.id.broad233);
        broad_array[14][9]=(ImageButton)findViewById(R.id.broad234);
        broad_array[14][10]=(ImageButton)findViewById(R.id.broad235);
        broad_array[14][11]=(ImageButton)findViewById(R.id.broad236);
        broad_array[14][12]=(ImageButton)findViewById(R.id.broad237);
        broad_array[14][13]=(ImageButton)findViewById(R.id.broad238);
        broad_array[14][14]=(ImageButton)findViewById(R.id.broad239);
        broad_array[14][15]=(ImageButton)findViewById(R.id.broad240);

        broad_array[15][0]=(ImageButton)findViewById(R.id.broad241);
        broad_array[15][1]=(ImageButton)findViewById(R.id.broad242);
        broad_array[15][2]=(ImageButton)findViewById(R.id.broad243);
        broad_array[15][3]=(ImageButton)findViewById(R.id.broad244);
        broad_array[15][4]=(ImageButton)findViewById(R.id.broad245);
        broad_array[15][5]=(ImageButton)findViewById(R.id.broad246);
        broad_array[15][6]=(ImageButton)findViewById(R.id.broad247);
        broad_array[15][7]=(ImageButton)findViewById(R.id.broad248);
        broad_array[15][8]=(ImageButton)findViewById(R.id.broad249);
        broad_array[15][9]=(ImageButton)findViewById(R.id.broad250);
        broad_array[15][10]=(ImageButton)findViewById(R.id.broad251);
        broad_array[15][11]=(ImageButton)findViewById(R.id.broad252);
        broad_array[15][12]=(ImageButton)findViewById(R.id.broad253);
        broad_array[15][13]=(ImageButton)findViewById(R.id.broad254);
        broad_array[15][14]=(ImageButton)findViewById(R.id.broad255);
        broad_array[15][15]=(ImageButton)findViewById(R.id.broad256);

        broad_array[16][0]=(ImageButton)findViewById(R.id.broad257);
        broad_array[16][1]=(ImageButton)findViewById(R.id.broad258);
        broad_array[16][2]=(ImageButton)findViewById(R.id.broad259);
        broad_array[16][3]=(ImageButton)findViewById(R.id.broad260);
        broad_array[16][4]=(ImageButton)findViewById(R.id.broad261);
        broad_array[16][5]=(ImageButton)findViewById(R.id.broad262);
        broad_array[16][6]=(ImageButton)findViewById(R.id.broad263);
        broad_array[16][7]=(ImageButton)findViewById(R.id.broad264);
        broad_array[16][8]=(ImageButton)findViewById(R.id.broad265);
        broad_array[16][9]=(ImageButton)findViewById(R.id.broad266);
        broad_array[16][10]=(ImageButton)findViewById(R.id.broad267);
        broad_array[16][11]=(ImageButton)findViewById(R.id.broad268);
        broad_array[16][12]=(ImageButton)findViewById(R.id.broad269);
        broad_array[16][13]=(ImageButton)findViewById(R.id.broad270);
        broad_array[16][14]=(ImageButton)findViewById(R.id.broad271);
        broad_array[16][15]=(ImageButton)findViewById(R.id.broad272);

        broad_array[17][0]=(ImageButton)findViewById(R.id.broad273);
        broad_array[17][1]=(ImageButton)findViewById(R.id.broad274);
        broad_array[17][2]=(ImageButton)findViewById(R.id.broad275);
        broad_array[17][3]=(ImageButton)findViewById(R.id.broad276);
        broad_array[17][4]=(ImageButton)findViewById(R.id.broad277);
        broad_array[17][5]=(ImageButton)findViewById(R.id.broad278);
        broad_array[17][6]=(ImageButton)findViewById(R.id.broad279);
        broad_array[17][7]=(ImageButton)findViewById(R.id.broad280);
        broad_array[17][8]=(ImageButton)findViewById(R.id.broad281);
        broad_array[17][9]=(ImageButton)findViewById(R.id.broad282);
        broad_array[17][10]=(ImageButton)findViewById(R.id.broad283);
        broad_array[17][11]=(ImageButton)findViewById(R.id.broad284);
        broad_array[17][12]=(ImageButton)findViewById(R.id.broad285);
        broad_array[17][13]=(ImageButton)findViewById(R.id.broad286);
        broad_array[17][14]=(ImageButton)findViewById(R.id.broad287);
        broad_array[17][15]=(ImageButton)findViewById(R.id.broad288);

        broad_array[18][0]=(ImageButton)findViewById(R.id.broad289);
        broad_array[18][1]=(ImageButton)findViewById(R.id.broad290);
        broad_array[18][2]=(ImageButton)findViewById(R.id.broad291);
        broad_array[18][3]=(ImageButton)findViewById(R.id.broad292);
        broad_array[18][4]=(ImageButton)findViewById(R.id.broad293);
        broad_array[18][5]=(ImageButton)findViewById(R.id.broad294);
        broad_array[18][6]=(ImageButton)findViewById(R.id.broad295);
        broad_array[18][7]=(ImageButton)findViewById(R.id.broad296);
        broad_array[18][8]=(ImageButton)findViewById(R.id.broad297);
        broad_array[18][9]=(ImageButton)findViewById(R.id.broad298);
        broad_array[18][10]=(ImageButton)findViewById(R.id.broad299);
        broad_array[18][11]=(ImageButton)findViewById(R.id.broad300);
        broad_array[18][12]=(ImageButton)findViewById(R.id.broad301);
        broad_array[18][13]=(ImageButton)findViewById(R.id.broad302);
        broad_array[18][14]=(ImageButton)findViewById(R.id.broad303);
        broad_array[18][15]=(ImageButton)findViewById(R.id.broad304);

        broad_array[19][0]=(ImageButton)findViewById(R.id.broad305);
        broad_array[19][1]=(ImageButton)findViewById(R.id.broad306);
        broad_array[19][2]=(ImageButton)findViewById(R.id.broad307);
        broad_array[19][3]=(ImageButton)findViewById(R.id.broad308);
        broad_array[19][4]=(ImageButton)findViewById(R.id.broad309);
        broad_array[19][5]=(ImageButton)findViewById(R.id.broad310);
        broad_array[19][6]=(ImageButton)findViewById(R.id.broad311);
        broad_array[19][7]=(ImageButton)findViewById(R.id.broad312);
        broad_array[19][8]=(ImageButton)findViewById(R.id.broad313);
        broad_array[19][9]=(ImageButton)findViewById(R.id.broad314);
        broad_array[19][10]=(ImageButton)findViewById(R.id.broad315);
        broad_array[19][11]=(ImageButton)findViewById(R.id.broad316);
        broad_array[19][12]=(ImageButton)findViewById(R.id.broad317);
        broad_array[19][13]=(ImageButton)findViewById(R.id.broad318);
        broad_array[19][14]=(ImageButton)findViewById(R.id.broad319);
        broad_array[19][15]=(ImageButton)findViewById(R.id.broad320);





        for (int i=0;i<20;i++)
        {
            for (int j=0;j<16;j++)
            {
                content[i][j]=0;
            }
        }

        newBoard(second);
        //reDraw();

    }

    void newBoard(int s)
    {
        int start=ran.nextInt(12);
        for(int i=0;i<16;i++)
        {
            if(i>=start && i<start+5)
                content[19][i] = 1;
            else
                content[19][i]=0;
        }



        if(s==0)
        {
            content[18][start+2]=2;
            peopleX=18;
            peopleY=start+2;
        }

    }





}
