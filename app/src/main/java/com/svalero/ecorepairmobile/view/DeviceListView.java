package com.svalero.ecorepairmobile.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.ecorepairmobile.R;
import com.svalero.ecorepairmobile.adapter.DeviceAdapter;
import com.svalero.ecorepairmobile.contract.DeviceListContract;
import com.svalero.ecorepairmobile.domain.Device;
import com.svalero.ecorepairmobile.presenter.DeviceListPresenter;
import com.svalero.ecorepairmobile.utils.MenuUtils;

import java.util.ArrayList;
import java.util.List;

public class DeviceListView extends AppCompatActivity implements DeviceListContract.View {

    private DeviceListPresenter presenter;
    private DeviceAdapter adapter;
    private final List<Device> devices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        presenter = new DeviceListPresenter(this);

        RecyclerView rv = findViewById(R.id.device_list);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DeviceAdapter(devices,
                device -> {
                    Intent i = new Intent(DeviceListView.this, DeviceDetailView.class);
                    i.putExtra(DeviceDetailView.EXTRA_ID, device.getId());
                    startActivity(i);
                },
                device -> showDeleteConfirmation(device)
        );

        rv.setAdapter(adapter);

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
    protected void onResume() {
        super.onResume();
        presenter.loadDevices();
    }

    @Override
    public void showDevices(List<Device> deviceList) {
        devices.clear();
        devices.addAll(deviceList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showDeleteConfirmation(Device device) {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Delete Device")
                .setMessage("¿Are you sure you want to delete?")
                .setPositiveButton("Delete", (dialog, which) ->
                        presenter.deleteDevice(device.getId())
                )
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }
}