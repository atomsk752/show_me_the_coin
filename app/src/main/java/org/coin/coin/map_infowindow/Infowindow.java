package org.coin.coin.map_infowindow;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import org.coin.coin.R;
import org.coin.coin.data.Store;

public class Infowindow implements GoogleMap.InfoWindowAdapter{


    private Context context;

    public Infowindow(Context ctx){
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

        TextView tel = view.findViewById(R.id.info_tel);
        TextView addr = view.findViewById(R.id.info_addr);
        TextView categ = view.findViewById(R.id.info_categ);

        name.setText(marker.getTitle());

        Store data = (Store) marker.getTag();

        tel.setText(data.getTel());
        addr.setText(data.getAddr());
        categ.setText(data.getCateg());

        return view;

    }

}
