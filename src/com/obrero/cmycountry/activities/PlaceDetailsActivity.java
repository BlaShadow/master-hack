package com.obrero.cmycountry.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.dto.Place;
import com.obrero.cmycountry.services.ServiceData;

/**
 * Created by BlackShadow on 3/1/14.
 */
public class PlaceDetailsActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_details_fragment);

        TextView title = (TextView)findViewById(R.id.txt_name_details_place);
        TextView details = (TextView)findViewById(R.id.txt_details_details_place);
        TextView moreInfo = (TextView)findViewById(R.id.txt_more_details_place);

        Place itemPlace = ServiceData.getCurrentPlace();

        title.setText(itemPlace.getName());
        details.setText(ServiceData.detailsExample);
        moreInfo.setText( Html.fromHtml("<a href='http://google.com'>Mas Informacion</a>") );

        moreInfo.setClickable(true);
        moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://google.com";
                Intent tmpIntent = new Intent(Intent.ACTION_VIEW);
                tmpIntent.setData(Uri.parse(url));
                startActivity(tmpIntent);
            }
        });
    }

    public void toMap(View btn){
        Intent tmpIntent = new Intent(this,MapActivity.class);
        startActivity(tmpIntent);
    }
}
