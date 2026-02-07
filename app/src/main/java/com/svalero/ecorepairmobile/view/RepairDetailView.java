package com.svalero.ecorepairmobile.view;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.svalero.ecorepairmobile.R;
import com.svalero.ecorepairmobile.contract.RepairDetailContract;
import com.svalero.ecorepairmobile.domain.Repair;
import com.svalero.ecorepairmobile.presenter.RepairDetailPresenter;
import com.svalero.ecorepairmobile.utils.MenuUtils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RepairDetailView extends AppCompatActivity implements RepairDetailContract.View {

    public static final String EXTRA_ID = "repairId";

    private RepairDetailPresenter presenter;

    private TextView tvDescription, tvCost, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_detail);

        tvDescription = findViewById(R.id.tv_description);
        tvCost = findViewById(R.id.tv_cost);
        tvDate = findViewById(R.id.tv_date);

        presenter = new RepairDetailPresenter(this);

        long repairId = getIntent().getLongExtra(EXTRA_ID, -1);
        if (repairId != -1)
            presenter.loadRepair(repairId);
        else {
            showError("ID de reparación no válido");
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
    public void showRepair(Repair repair) {
        tvDescription.setText("Descripción: " + repair.getDescription());
        tvCost.setText("Coste: " + repair.getCost());
        if (repair.getRepairDate() != null) {
            String fecha = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                    .format(repair.getRepairDate());
            tvDate.setText("Fecha: " + fecha);
        } else
            tvDate.setText("Fecha: -");
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
