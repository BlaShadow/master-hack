package com.obrero.cmycountry.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import com.obrero.cmycountry.R;
import com.obrero.cmycountry.fragments.PathDetails;

/**
 * Created by BlackShadow on 3/2/14.
 */
public class PathDetailsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.path_details_layout);

        Fragment fragment = new PathDetails();
        getFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
    }
}