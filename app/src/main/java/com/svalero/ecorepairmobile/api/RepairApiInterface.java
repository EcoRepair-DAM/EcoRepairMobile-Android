package com.svalero.ecorepairmobile.api;

import com.svalero.ecorepairmobile.domain.Repair;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface RepairApiInterface {

    @GET("repairs")
    Call<List<Repair>> getRepairs();

    @GET("repairs/{id}")
    Call<Repair> getRepair(@Path("id") long id);

    @GET("devices/{deviceId}/repairs")
    Call<List<Repair>> getRepairsByDevice(@Path("deviceId") long deviceId);

    @POST("repairs")
    Call<Repair> createRepair(@Body Repair repair);

    @PUT("repairs/{id}")
    Call<Repair> updateRepair(@Path("id") long id, @Body Repair repair);

    @DELETE("repairs/{id}")
    Call<Void> deleteRepair(@Path("id") long id);
}