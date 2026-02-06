package com.svalero.ecorepairmobile.api;

import com.svalero.ecorepairmobile.domain.Device;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface DeviceApiInterface {

    @GET("devices")
    Call<List<Device>> getDevices();

    @GET("devices/{id}")
    Call<Device> getDevice(@Path("id") long id);

    @POST("devices")
    Call<Device> createDevice(@Body Device device);

    @PUT("devices/{id}")
    Call<Device> updateDevice(@Path("id") long id, @Body Device device);

    @DELETE("devices/{id}")
    Call<Void> deleteDevice(@Path("id") long id);

}