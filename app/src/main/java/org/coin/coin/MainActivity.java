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

import org.coin.coin.eunpyeong.E_MainActivity;
import org.coin.coin.information.I_MainActivity;
import org.coin.coin.moa.M_MainActivity;
import org.coin.coin.onnuri.O_MainActivity;
import org.coin.coin.tongin.T_MainActivity;
import org.coin.coin.nowon.N_MainActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton n_btn0 = (ImageButton) findViewById(R.id.n_button0);
        ImageButton m_btn0 = (ImageButton) findViewById(R.id.m_button0);
        ImageButton o_btn0 = (ImageButton) findViewById(R.id.o_button0);
        ImageButton e_btn0 = (ImageButton) findViewById(R.id.e_button0);
        ImageButton t_btn0 = (ImageButton) findViewById(R.id.t_button0);
        ImageButton i_btn0 = (ImageButton) findViewById(R.id.i_button0);

        setPermission();

        n_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), N_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        m_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), M_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        o_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), O_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        e_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), E_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        t_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), T_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        i_btn0.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), I_MainActivity.class);
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
