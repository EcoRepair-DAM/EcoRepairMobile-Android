package com.svalero.ecorepairmobile.presenter;

import com.svalero.ecorepairmobile.contract.DeviceDetailContract;
import com.svalero.ecorepairmobile.domain.Device;
import com.svalero.ecorepairmobile.model.DeviceDetailModel;

public class DeviceDetailPresenter implements DeviceDetailContract.Presenter,
        DeviceDetailContract.Model.OnLoadListener {

    private final DeviceDetailContract.Model model;
    private final DeviceDetailContract.View view;

    public DeviceDetailPresenter(DeviceDetailContract.View view) {
        this.view = view;
        this.model = new DeviceDetailModel();
    }

    @Override
    public void loadDevice(long deviceId) {
        model.loadDevice(deviceId, this);
    }

    @Override
    public void onLoadSuccess(Device device) {
        view.showDevice(device);
    }

    @Override
    public void onLoadError(String message) {
        view.showError(message);
    }
}