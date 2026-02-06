package com.svalero.ecorepairmobile.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.ecorepairmobile.R;
import com.svalero.ecorepairmobile.contract.DeviceDetailContract;
import com.svalero.ecorepairmobile.domain.Device;
import com.svalero.ecorepairmobile.presenter.DeviceDetailPresenter;
import com.svalero.ecorepairmobile.utils.MenuUtils;

public class DeviceDetailView extends AppCompatActivity implements DeviceDetailContract.View {

    public static final String EXTRA_ID = "deviceId";

    private DeviceDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        presenter = new DeviceDetailPresenter(this);

        long deviceId = getIntent().getLongExtra(EXTRA_ID, -1);

        if (deviceId != -1) {
            presenter.loadDevice(deviceId);
        } else {
            showError("ID de dispositivo no válido");
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return MenuUtils.onCreateOptionsMenu(this, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuUtils.onOptionsItemSelected(this, item);
    }

    @Override
    public void showDevice(Device device) {


    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "-" : s;
    }

}