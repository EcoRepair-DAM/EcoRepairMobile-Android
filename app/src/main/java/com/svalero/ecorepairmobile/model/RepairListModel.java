package com.svalero.ecorepairmobile.model;

import com.svalero.ecorepairmobile.api.RepairApi;
import com.svalero.ecorepairmobile.api.RepairApiInterface;
import com.svalero.ecorepairmobile.contract.RepairListContract;
import com.svalero.ecorepairmobile.domain.Repair;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RepairListModel implements RepairListContract.Model {

    @Override
    public void loadRepairs(OnLoadListener listener) {
        RepairApiInterface api = RepairApi.buildInstance();
        api.getRepairs().enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<List<Repair>> call, Response<List<Repair>> response) {
                if (response.code() == 200) {
                    listener.onLoadSuccess(response.body());
                } else {
                    listener.onLoadError("Error al cargar reparaciones (" + response.code() + ")");
                }
            }

            @Override
            public void onFailure(Call<List<Repair>> call, Throwable t) {
                listener.onLoadError("No se ha podido conectar con el servidor");
            }
        });
    }

    @Override
    public void deleteRepair(long id, OnDeleteListener listener) {
        RepairApiInterface api = RepairApi.buildInstance();
        api.deleteRepair(id).enqueue(new Callback<>() {
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
