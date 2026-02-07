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

import java.text.SimpleDateFormat;
import java.util.Locale;

public class DeviceDetailView extends AppCompatActivity implements DeviceDetailContract.View {

    public static final String EXTRA_ID = "deviceId";

    private DeviceDetailPresenter presenter;

    private TextView tvName, tvBrand, tvType, tvDate, tvReusable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detail);

        tvName = findViewById(R.id.tv_name);
        tvBrand = findViewById(R.id.tv_brand);
        tvType = findViewById(R.id.tv_type);
        tvDate = findViewById(R.id.tv_date);
        tvReusable = findViewById(R.id.tv_reusable);

        presenter = new DeviceDetailPresenter(this);

        long deviceId = getIntent().getLongExtra(EXTRA_ID, -1);
        if (deviceId != -1) presenter.loadDevice(deviceId);
        else { showError("ID de dispositivo no válido"); finish(); }

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
        tvName.setText("Nombre: " + device.getName());
        tvBrand.setText("Marca: " + device.getBrand());
        tvType.setText("Tipo: " + device.getType());
        if (device.getPurchaseDate() != null) {
            String fecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    .format(device.getPurchaseDate());
            tvDate.setText("Fecha fabricación: " + fecha);
        } else tvDate.setText("Fecha fabricación: -");
        tvReusable.setText("Reutilizable: " + (device.isReusable() ? "Sí" : "No"));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}