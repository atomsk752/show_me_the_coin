package org.coin.coin;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SubMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_main);


        ImageButton k_btn = findViewById(R.id.k_btn);
        ImageButton c_btn = findViewById(R.id.c_btn);

        k_btn.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                }
        );
        c_btn.setOnClickListener(
                new Button.OnClickListener() {
                   public void onClick(View v) {
                       Intent intent = new Intent(getApplicationContext(), C_MainActivity.class);
                       startActivity(intent);
                    }

                }
        );
    }
}