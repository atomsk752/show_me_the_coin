package org.coin.coin.c_tongin;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.coin.coin.C_MainActivity;
import org.coin.coin.R;
import org.coin.coin.SubMainActivity;
import org.coin.coin.c_eunpyeong.CE_MainActivity;
import org.coin.coin.c_information.CI_MainActivity;
import org.coin.coin.c_moa.CM_MainActivity;
import org.coin.coin.c_nowon.CN_MainActivity;
import org.coin.coin.c_onnuri.CO_MainActivity;

public class CT_MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
// Get the ActionBar here to configure the way it behaves.
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 하기 위해 필요
        actionBar.setDisplayShowTitleEnabled(false);//기본 타이틀 보여줄지 말지 설정
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back_white_24dp);
        toolbar.setBackgroundColor(Color.BLACK);
        toolbar.setTitleTextColor(Color.WHITE);

        ImageButton ct_btn = (ImageButton) findViewById(R.id.ct_button1);
        ImageButton ct_btn2 = (ImageButton) findViewById(R.id.ct_button2);
        ImageButton ct_btn3= (ImageButton) findViewById(R.id.ct_button3);
        ImageButton ch_btn= (ImageButton) findViewById(R.id.ch_btn);

        ch_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), C_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );

        ct_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CT_WebActivity.class);
                        startActivity(intent);
                    }

                }
        );
        ct_btn2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CT_MapActivity.class);
                        startActivity(intent);
                    }

                }
        );
        ct_btn3.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CT_SearchActivity.class);
                        startActivity(intent);
                    }

                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.c_menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //finish();
                onBackPressed();
                return true;
            case R.id.c_first:
                Intent c_intent1 = new Intent(getApplicationContext(), C_MainActivity.class);
                startActivity(c_intent1);
                break;
            case R.id.c_second:
                Intent c_intent2 = new Intent(getApplicationContext(), CN_MainActivity.class);
                startActivity(c_intent2);
                break;
            case R.id.c_third:
                Intent c_intent3 = new Intent(getApplicationContext(), CM_MainActivity.class);
                startActivity(c_intent3);
                break;
            case R.id.c_fourth:
                Intent c_intent4 = new Intent(getApplicationContext(), CO_MainActivity.class);
                startActivity(c_intent4);
                break;
            case R.id.c_fifth:
                Intent c_intent5 = new Intent(getApplicationContext(), CE_MainActivity.class);
                startActivity(c_intent5);
                break;
            case R.id.c_sixth:
                Intent c_intent6 = new Intent(getApplicationContext(), CT_MainActivity.class);
                startActivity(c_intent6);
                break;
            case R.id.c_seventh:
                Intent c_intent7 = new Intent(getApplicationContext(), CI_MainActivity.class);
                startActivity(c_intent7);
                break;
            case R.id.c_eighth:
                Intent c_intent8 = new Intent(getApplicationContext(), SubMainActivity.class);
                startActivity(c_intent8);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}