package org.coin.coin.c_moa;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import org.coin.coin.C_MainActivity;
import org.coin.coin.MainActivity;
import org.coin.coin.R;
import org.coin.coin.SubMainActivity;
import org.coin.coin.c_eunpyeong.CE_MainActivity;
import org.coin.coin.c_information.CI_MainActivity;
import org.coin.coin.c_nowon.CN_MainActivity;
import org.coin.coin.c_onnuri.CO_MainActivity;
import org.coin.coin.c_tongin.CT_MainActivity;
import org.coin.coin.data.Store;
import org.coin.coin.data.StoreDAO;
import org.coin.coin.eunpyeong.E_MainActivity;
import org.coin.coin.information.I_MainActivity;
import org.coin.coin.map_infowindow.Infowindow;
import org.coin.coin.moa.M_MainActivity;
import org.coin.coin.nowon.N_MainActivity;
import org.coin.coin.onnuri.O_MainActivity;
import org.coin.coin.tongin.T_MainActivity;

import java.util.List;

public class CM_MapActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener{

    private List<Store> stores;
    private Intent intent;


    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    // 위치 정보 얻는 객체
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StoreDAO storeDAO = new StoreDAO();
        storeDAO.MoaData();

        stores = StoreDAO.getMoa();

        setContentView(R.layout.activity_cm_map);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

        // GoogleAPIClient의 인스턴스 생성
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.current_location);
        mapFragment.getMapAsync(this);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Infowindow infowindow = new Infowindow(this);
        mMap.setInfoWindowAdapter(infowindow);

        //지역화폐 가게 위경도 넣기
        if (stores != null) {
            for (Store store : stores) {
                MarkerOptions markerOptions = new MarkerOptions();
                LatLng addstore = new LatLng(store.getLat(), store.getLng());

                markerOptions.position(addstore).title(store.getName());
                Marker m = mMap.addMarker(markerOptions);
                m.setTag(store);
                m.showInfoWindow();
                mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
            }
        }

        mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
        enableMyLocationIfPermitted();


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {

                    // 현재 위치
                    LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());

                    intent = getIntent();
                    Double lat = intent.getDoubleExtra("lat", 0);
                    Double lng = intent.getDoubleExtra("lng", 0);
                    LatLng search = new LatLng(lat, lng);

                    if (lat == 0) {
                        // 카메라 내 위치로
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
                    } else {
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(search));
                    }
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
                }
            }
        });


    }

    private void enableMyLocationIfPermitted() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else if (mMap != null) {
            mMap.setMyLocationEnabled(true);
        }
    }

    private void showDefaultLocation() {
        Toast.makeText(this, "Location permission not granted, " +
                        "showing default location",
                Toast.LENGTH_SHORT).show();
        LatLng redmond = new LatLng(126.985, 37.5704);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redmond));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    enableMyLocationIfPermitted();
                } else {
                    showDefaultLocation();
                }
                return;
            }

        }
    }

    private GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    mMap.setMinZoomPreference(15);
                    return false;
                }
            };

    @Override
    public void onConnected(@Nullable Bundle bundle) {}
    @Override
    public void onConnectionSuspended(int i) {}
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {}

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
                Intent intent1 = new Intent(getApplicationContext(), C_MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.second:
                Intent intent2 = new Intent(getApplicationContext(), CN_MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.third:
                Intent intent3 = new Intent(getApplicationContext(), CM_MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.fourth:
                Intent intent4 = new Intent(getApplicationContext(), CO_MainActivity.class);
                startActivity(intent4);
                break;
            case R.id.fifth:
                Intent intent5 = new Intent(getApplicationContext(), CE_MainActivity.class);
                startActivity(intent5);
                break;
            case R.id.sixth:
                Intent intent6 = new Intent(getApplicationContext(), CT_MainActivity.class);
                startActivity(intent6);
                break;
            case R.id.seventh:
                Intent intent7 = new Intent(getApplicationContext(), CI_MainActivity.class);
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