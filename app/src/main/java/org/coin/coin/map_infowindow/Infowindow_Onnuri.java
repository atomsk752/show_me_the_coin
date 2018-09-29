package org.coin.coin.map_infowindow;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.coin.coin.R;
import org.coin.coin.data.Store;

public class Infowindow_Onnuri implements GoogleMap.InfoWindowAdapter{


    private Context context;

    public Infowindow_Onnuri(Context ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View view = ((Activity)context).getLayoutInflater()
                .inflate(R.layout.info_layout, null);

        TextView name = view.findViewById(R.id.name);
        TextView addr = view.findViewById(R.id.info_addr);
        ImageView img = view.findViewById(R.id.pic);


        name.setText(marker.getTitle());

        Store data = (Store) marker.getTag();

        int id = context.getResources().getIdentifier("o"+data.getMarket_id(), "drawable", context.getPackageName());

        img.setImageResource(id);
        addr.setText(data.getAddr());


        return view;

    }

}
