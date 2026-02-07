package com.svalero.ecorepairmobile.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import com.svalero.ecorepairmobile.R;
import com.svalero.ecorepairmobile.view.DeviceListView;
import com.svalero.ecorepairmobile.view.RepairListView;

public class MenuUtils {

    public static boolean onCreateOptionsMenu(Activity activity, Menu menu) {
        activity.getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public static boolean onOptionsItemSelected(Activity activity, MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_devices) {
            activity.startActivity(new Intent(activity, DeviceListView.class));
            return true;
        }

        if (id == R.id.menu_repairs) {
            activity.startActivity(new Intent(activity, RepairListView.class));
            return true;
        }

        return false;
    }
}