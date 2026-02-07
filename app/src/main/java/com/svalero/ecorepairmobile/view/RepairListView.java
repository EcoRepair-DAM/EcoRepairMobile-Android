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
import com.svalero.ecorepairmobile.adapter.RepairAdapter;
import com.svalero.ecorepairmobile.contract.RepairListContract;
import com.svalero.ecorepairmobile.domain.Repair;
import com.svalero.ecorepairmobile.presenter.RepairListPresenter;
import com.svalero.ecorepairmobile.utils.MenuUtils;

import java.util.ArrayList;
import java.util.List;

public class RepairListView extends AppCompatActivity implements RepairListContract.View {

    private RepairListPresenter presenter;
    private RepairAdapter adapter;
    private final List<Repair> repairs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_list);

        presenter = new RepairListPresenter(this);

        RecyclerView rv = findViewById(R.id.repair_list);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RepairAdapter(repairs,
                repair -> {
                    Intent i = new Intent(RepairListView.this, RepairDetailView.class);
                    i.putExtra(RepairDetailView.EXTRA_ID, repair.getId());
                    startActivity(i);
                },
                repair -> showDeleteConfirmation(repair));

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
        presenter.loadRepairs();
    }

    @Override
    public void showRepairs(List<Repair> repairList) {
        repairs.clear();
        repairs.addAll(repairList);
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

    private void showDeleteConfirmation(Repair repair) {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("Eliminar reparación")
                .setMessage("¿Seguro que lo quieres eliminar?")
                .setPositiveButton("Eliminar", (dialog, which) -> presenter.deleteRepair(repair.getId()))
                .setNegativeButton("Cancelar", (dialog, which) -> dialog.dismiss())
                .show();
    }
}
