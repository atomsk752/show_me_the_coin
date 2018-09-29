package org.coin.coin.tongin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import org.coin.coin.MainActivity;
import org.coin.coin.R;
import org.coin.coin.SubMainActivity;
import org.coin.coin.data.Store;
import org.coin.coin.data.StoreDAO;
import org.coin.coin.eunpyeong.E_MainActivity;
import org.coin.coin.information.I_MainActivity;
import org.coin.coin.moa.M_MainActivity;
import org.coin.coin.nowon.N_MainActivity;
import org.coin.coin.onnuri.O_MainActivity;
import org.coin.coin.search.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

public class T_SearchActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Store> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private SearchAdapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<Store> arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_serach);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true); //커스터마이징 하기 위해 필요
        actionBar.setDisplayShowTitleEnabled(false);//기본 타이틀 보여줄지 말지 설정
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back_white_24dp);
        toolbar.setBackgroundColor(Color.BLACK);
        toolbar.setTitleTextColor(Color.WHITE);


        ImageButton flour = (ImageButton) findViewById(R.id.t_imageButton1);
        ImageButton meat = (ImageButton) findViewById(R.id.t_imageButton2);
        ImageButton side = (ImageButton) findViewById(R.id.t_imageButton3);
        ImageButton clothes = (ImageButton) findViewById(R.id.t_imageButton4);
        ImageButton restaurant = (ImageButton) findViewById(R.id.t_imageButton5);
        ImageButton h_btn= (ImageButton) findViewById(R.id.h_btn);

        h_btn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                }
        );

        listView = (ListView) findViewById(R.id.list);

        // 리스트를 생성한다.
        list = StoreDAO.getTongin();

        // 검색에 사용할 데이터을 미리 저장한다.
        settingList();

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<Store>();
        arraylist.addAll(list);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new SearchAdapter(list, this);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        // 버튼 눌렀을 때 변하도록 한다.
        flour.setOnClickListener(this);
        meat.setOnClickListener(this);
        side.setOnClickListener(this);
        clothes.setOnClickListener(this);
        restaurant.setOnClickListener(this);

        editSearch = (EditText) findViewById(R.id.Edt);


        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                // search 메소드를 호출한다.
                String text = editSearch.getText().toString();
                search(text);
            }
        });

        // listView의 ItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * ListView의 Item을 Click 할 때 수행할 동작
             * @param parent 클릭이 발생한 AdapterView.
             * @param view 클릭 한 AdapterView 내의 View(Adapter에 의해 제공되는 View).
             * @param position 클릭 한 Item의 position
             * @param id 클릭 된 Item의 Id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Double lat = ((Store)adapter.getItem(position)).getLat();
                Double lng = ((Store)adapter.getItem(position)).getLng();

                // new Intent(현재 Activity의 Context, 시작할 Activity 클래스)
                Intent intent = new Intent(T_SearchActivity.this, T_MapActivity.class);
                // putExtra(key, value)
                intent.putExtra("lat", lat);
                intent.putExtra("lng", lng);


                startActivity(intent);
            }
        });

    }


    // 검색을 수행하는 메소드
    public void search(String charText) {

        // 문자 입력시마다 리스트를 지우고 새로 뿌려준다.
        list.clear();

        // 문자 입력이 없을때는 모든 데이터를 보여준다.
        if (charText.length() == 0) {
            list.addAll(arraylist);
        }
        // 문자 입력을 할때..
        else
        {
            // 리스트의 모든 데이터를 검색한다.
            for(int i = 0;i < arraylist.size(); i++)
            {
                // arraylist의 모든 데이터에 입력받은 단어(charText)가 포함되어 있으면 true를 반환한다.
                if (arraylist.get(i).getName().toLowerCase().contains(charText))
                {
                    // 검색된 데이터를 리스트에 추가한다.
                    list.add(arraylist.get(i));
                }
            }
        }
        // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
        adapter.notifyDataSetChanged();
    }

    // 검색에 사용될 데이터를 리스트에 추가한다.
    private void settingList(){

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

    @Override
    public void onClick(View v) {

        list.clear();

        if(v.getId() == R.id.t_imageButton1){
            for(Store s: arraylist){
                if(s.getCateg().contains("분식")){
                    list.add(s);
                }
            }
        }else if(v.getId() == R.id.t_imageButton2){
            for(Store s: arraylist){
                if(s.getCateg().contains("정육")){
                    list.add(s);
                }
            }
        }else if(v.getId() == R.id.t_imageButton3){
            for(Store s: arraylist){
                if(s.getCateg().contains("반찬")){
                    list.add(s);
                }
            }
        }else if(v.getId() == R.id.t_imageButton4){
            for(Store s: arraylist){
                if(s.getCateg().contains("의류")){
                    list.add(s);
                }
            }
        }else if(v.getId() == R.id.t_imageButton5){
            for(Store s: arraylist){
                if(s.getCateg().contains("식당")){
                    list.add(s);
                }
            }
        }
        adapter.notifyDataSetChanged();

    }

}

