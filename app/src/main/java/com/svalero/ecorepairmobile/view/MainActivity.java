package com.svalero.ecorepairmobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.ecorepairmobile.R;
import com.svalero.ecorepairmobile.utils.MenuUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_devices).setOnClickListener(v -> {
            startActivity(new Intent(this, DeviceListView.class));
        });

        findViewById(R.id.btn_repairs).setOnClickListener(v -> {
            startActivity(new Intent(this, RepairListView.class));
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return MenuUtils.onCreateOptionsMenu(this, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuUtils.onOptionsItemSelected(this, item);
    }
}