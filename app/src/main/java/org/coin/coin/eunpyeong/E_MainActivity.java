package org.coin.coin.eunpyeong;

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

import org.coin.coin.SubMainActivity;
import org.coin.coin.information.I_MainActivity;
import org.coin.coin.MainActivity;
import org.coin.coin.R;
import org.coin.coin.data.JSONService;
import org.coin.coin.data.Store;
import org.coin.coin.moa.M_MainActivity;
import org.coin.coin.nowon.N_MainActivity;
import org.coin.coin.onnuri.O_MainActivity;
import org.coin.coin.tongin.T_MainActivity;

import java.util.List;

import retrofit2.Retrofit;

public class E_MainActivity extends AppCompatActivity {

    private static List<Store> stores;
    private static String str;
    private Retrofit retrofit;
    private JSONService jsonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_e_main);

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


        ImageButton e_btn = (ImageButton) findViewById(R.id.e_button1);
        ImageButton e_btn2 = (ImageButton) findViewById(R.id.e_button2);
        ImageButton e_btn3= (ImageButton) findViewById(R.id.e_button3);
        ImageButton h_btn= (ImageButton) findViewById(R.id.h_btn);

        h_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                }
        );


        e_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), E_WebActivity.class);
                        startActivity(intent);
                    }

                }
        );
        e_btn2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), E_MapActivity.class);
                        startActivity(intent);
                    }

                }
        );
        e_btn3.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), E_SearchActivity.class);
                        startActivity(intent);
                    }

                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //finish();
                onBackPressed();
                return true;
            case R.id.first:
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.second:
                Intent intent2 = new Intent(getApplicationContext(), N_MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.third:
                Intent intent3 = new Intent(getApplicationContext(), M_MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.fourth:
                Intent intent4 = new Intent(getApplicationContext(), O_MainActivity.class);
                startActivity(intent4);
                break;
            case R.id.fifth:
                Intent intent5 = new Intent(getApplicationContext(), E_MainActivity.class);
                startActivity(intent5);
                break;
            case R.id.sixth:
                Intent intent6 = new Intent(getApplicationContext(), T_MainActivity.class);
                startActivity(intent6);
                break;
            case R.id.seventh:
                Intent intent7 = new Intent(getApplicationContext(), I_MainActivity.class);
                startActivity(intent7);
                break;
            case R.id.eighth:
                Intent intent8 = new Intent(getApplicationContext(), SubMainActivity.class);
                startActivity(intent8);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

