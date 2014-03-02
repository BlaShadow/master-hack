package com.obrero.cmycountry.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/1/14
 * Time: 11:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomeBroadcast extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Nice",0).show();
    }
}
