package com.svalero.ecorepairmobile.model;

import com.svalero.ecorepairmobile.api.DeviceApi;
import com.svalero.ecorepairmobile.api.DeviceApiInterface;
import com.svalero.ecorepairmobile.contract.DeviceListContract;
import com.svalero.ecorepairmobile.domain.Device;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviceListModel implements DeviceListContract.Model {

    @Override
    public void loadDevices(OnLoadListener listener) {
        DeviceApiInterface api = DeviceApi.buildInstance();
        api.getDevices().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Device>> call, Response<List<Device>> response) {
                if (response.code() == 200) {
                    listener.onLoadSuccess(response.body());
                } else {
                    listener.onLoadError("Error al cargar dispositivos (" + response.code() + ")");
                }
            }

            @Override
            public void onFailure(Call<List<Device>> call, Throwable t) {
                listener.onLoadError("No se ha podido conectar con el servidor");
            }
        });
    }

    @Override
    public void deleteDevice(long id, OnDeleteListener listener) {
        DeviceApiInterface api = DeviceApi.buildInstance();
        api.deleteDevice(id).enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 204 || response.code() == 200) {
                    listener.onDeleteSuccess();
                } else {
                    listener.onDeleteError("No se ha podido borrar");
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onDeleteError("No se ha podido conectar con el servidor");
            }
        });
    }
}