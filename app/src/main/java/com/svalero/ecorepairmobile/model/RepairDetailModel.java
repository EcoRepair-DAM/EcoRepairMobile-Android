package com.svalero.ecorepairmobile.model;

import com.svalero.ecorepairmobile.api.RepairApi;
import com.svalero.ecorepairmobile.api.RepairApiInterface;
import com.svalero.ecorepairmobile.contract.RepairDetailContract;
import com.svalero.ecorepairmobile.domain.Repair;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepairDetailModel implements RepairDetailContract.Model {

    @Override
    public void loadRepair(long repairId, OnLoadListener listener) {
        RepairApiInterface api = RepairApi.buildInstance();
        api.getRepair(repairId).enqueue(new Callback<Repair>() {
            @Override
            public void onResponse(Call<Repair> call, Response<Repair> response) {
                if (response.code() == 200) {
                    listener.onLoadSuccess(response.body());
                } else {
                    listener.onLoadError("Error al cargar reparación (" + response.code() + ")");
                }
            }

            @Override
            public void onFailure(Call<Repair> call, Throwable t) {
                listener.onLoadError("No se ha podido conectar con el servidor");
            }
        });
    }
}
