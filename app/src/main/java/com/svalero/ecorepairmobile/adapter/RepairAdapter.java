package com.svalero.ecorepairmobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.ecorepairmobile.R;
import com.svalero.ecorepairmobile.domain.Repair;

import java.util.List;

public class RepairAdapter extends RecyclerView.Adapter<RepairAdapter.RepairViewHolder> {

    public interface OnRepairClick {
        void onClick(Repair repair);
    }

    public interface OnRepairDelete {
        void onDelete(Repair repair);
    }

    private final List<Repair> repairs;
    private final OnRepairClick onClick;
    private final OnRepairDelete onDelete;

    public RepairAdapter(List<Repair> repairs, OnRepairClick onClick, OnRepairDelete onDelete) {
        this.repairs = repairs;
        this.onClick = onClick;
        this.onDelete = onDelete;
    }

    @NonNull
    @Override
    public RepairViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.repair_item, parent, false);
        return new RepairViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RepairViewHolder holder, int position) {
        Repair r = repairs.get(position);
        holder.description.setText(r.getDescription());
        holder.cost.setText(String.valueOf(r.getCost()));
        holder.date.setText(r.getRepairDate() != null ? r.getRepairDate().toString() : "");

        holder.itemView.setOnClickListener(v -> onClick.onClick(r));
        holder.btnDelete.setOnClickListener(v -> onDelete.onDelete(r));
    }

    @Override
    public int getItemCount() {
        return repairs.size();
    }

    static class RepairViewHolder extends RecyclerView.ViewHolder {
        TextView description, cost, date;
        ImageButton btnDelete;

        public RepairViewHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.repair_description);
            cost = itemView.findViewById(R.id.repair_cost);
            date = itemView.findViewById(R.id.repair_date);
            btnDelete = itemView.findViewById(R.id.btn_delete_repair);
        }
    }
}

