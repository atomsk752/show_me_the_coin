package org.coin.coin.c_eunpyeong;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import org.coin.coin.C_MainActivity;
import org.coin.coin.R;
import org.coin.coin.SubMainActivity;
import org.coin.coin.c_information.CI_MainActivity;
import org.coin.coin.c_moa.CM_MainActivity;
import org.coin.coin.c_nowon.CN_MainActivity;
import org.coin.coin.c_onnuri.CO_MainActivity;
import org.coin.coin.c_tongin.CT_MainActivity;

public class CE_WebActivity extends AppCompatActivity {

    private EditText mAddressEdit;
    private WebView mWebView;
    private Button mMoveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ce_web);

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
        ImageButton ch_btn= (ImageButton) findViewById(R.id.ch_btn);

        ch_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), C_MainActivity.class);
                        startActivity(intent);
                    }

                }
        );

        mWebView = findViewById(R.id.web_view);
        mMoveButton = findViewById(R.id.move_button);

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // 안하면 naver는 보이지 않음. 기본적으로 여기까지----



        mWebView.setWebViewClient(new WebViewClient() {// 웹뷰에 표시가 잘됨(필수) 재정의 가능

//            @Override
//            public void onPageFinished(WebView view, String url) {
//                Toast.makeText(MainActivity.this,"로딩 끝", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//
//            }

        });
        mWebView.loadUrl("file:///android_asset/c_ep.html");
    }

    public void onClick(View view) {
        String address = mAddressEdit.getText().toString();

        if (address.startsWith("http://") == false) {
            address = "http://" + address;
        }

        mWebView.loadUrl(address);
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        }
        super.onBackPressed();
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
