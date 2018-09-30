package org.coin.coin;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.coin.coin.c_eunpyeong.CE_MainActivity;
import org.coin.coin.c_information.CI_MainActivity;
import org.coin.coin.c_moa.CM_MainActivity;
import org.coin.coin.c_nowon.CN_MainActivity;
import org.coin.coin.c_onnuri.CO_MainActivity;
import org.coin.coin.c_tongin.CT_MainActivity;

public class C_MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_main);
        ImageButton cn_btn0 = (ImageButton) findViewById(R.id.cn_button0);
        ImageButton cm_btn0 = (ImageButton) findViewById(R.id.cm_button0);
        ImageButton co_btn0 = (ImageButton) findViewById(R.id.co_button0);
        ImageButton ce_btn0 = (ImageButton) findViewById(R.id.ce_button0);
        ImageButton ct_btn0 = (ImageButton) findViewById(R.id.ct_button0);
        ImageButton ci_btn0 = (ImageButton) findViewById(R.id.ci_button0);

        setPermission();

        cn_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CN_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        cm_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CM_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        co_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CO_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        ce_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CE_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        ct_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CT_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        ci_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), CI_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
    }

    private void setPermission(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            return;
        }
    }
}