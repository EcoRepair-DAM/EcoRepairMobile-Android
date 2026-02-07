package com.svalero.ecorepairmobile.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.ecorepairmobile.R;
import com.svalero.ecorepairmobile.domain.Device;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

    public interface OnDeviceClick { void onClick(Device device); }
    public interface OnDeviceDelete { void onDelete(Device device); }

    private final List<Device> devices;
    private final OnDeviceClick onClick;
    private final OnDeviceDelete onDelete;

    public DeviceAdapter(List<Device> devices, OnDeviceClick onClick, OnDeviceDelete onDelete) {
        this.devices = devices;
        this.onClick = onClick;
        this.onDelete = onDelete;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_item, parent, false);
        return new DeviceViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
        Device d = devices.get(position);
        holder.name.setText(d.getName());
        holder.brand.setText(d.getBrand());
        holder.type.setText(d.getType());

        holder.itemView.setOnClickListener(v -> onClick.onClick(d));
        holder.btnDelete.setOnClickListener(v -> onDelete.onDelete(d));
    }

    @Override
    public int getItemCount() {
        return devices.size();
    }

    static class DeviceViewHolder extends RecyclerView.ViewHolder {
        TextView name, brand, type;
        ImageButton btnDelete;

        public DeviceViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.device_name);
            brand = itemView.findViewById(R.id.device_brand);
            type = itemView.findViewById(R.id.device_type);
            btnDelete = itemView.findViewById(R.id.btn_delete_device);
        }
    }
}