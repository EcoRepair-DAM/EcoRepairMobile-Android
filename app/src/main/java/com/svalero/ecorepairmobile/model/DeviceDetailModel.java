package com.svalero.ecorepairmobile.model;

import com.svalero.ecorepairmobile.api.DeviceApi;
import com.svalero.ecorepairmobile.api.DeviceApiInterface;
import com.svalero.ecorepairmobile.contract.DeviceDetailContract;
import com.svalero.ecorepairmobile.domain.Device;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeviceDetailModel implements DeviceDetailContract.Model {

    @Override
    public void loadDevice(long deviceId, OnLoadListener listener) {
        DeviceApiInterface api = DeviceApi.buildInstance();
        api.getDevice(deviceId).enqueue(new Callback<Device>() {
            @Override
            public void onResponse(Call<Device> call, Response<Device> response) {
                if (response.code() == 200) {
                    listener.onLoadSuccess(response.body());
                } else {
                    listener.onLoadError("Error al cargar dispositivo (" + response.code() + ")");
                }
            }

            @Override
            public void onFailure(Call<Device> call, Throwable t) {
                listener.onLoadError("No se ha podido conectar con el servidor");
            }
        });
    }
}