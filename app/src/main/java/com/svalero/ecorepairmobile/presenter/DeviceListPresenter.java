package com.svalero.ecorepairmobile.presenter;

import com.svalero.ecorepairmobile.contract.DeviceListContract;
import com.svalero.ecorepairmobile.domain.Device;
import com.svalero.ecorepairmobile.model.DeviceListModel;


import java.util.List;

public class DeviceListPresenter implements DeviceListContract.Presenter,
        DeviceListContract.Model.OnLoadListener,
        DeviceListContract.Model.OnDeleteListener {

    private final DeviceListContract.Model model;
    private final DeviceListContract.View view;

    public DeviceListPresenter(DeviceListContract.View view) {
        this.view = view;
        this.model = new DeviceListModel();
    }

    @Override
    public void loadDevices() {
        model.loadDevices(this);
    }

    @Override
    public void deleteDevice(long id) {
        model.deleteDevice(id, this);
    }

    @Override
    public void onLoadSuccess(List<Device> devices) {
        view.showDevices(devices);
        view.showMessage("Dispositivos cargados");
    }

    @Override
    public void onLoadError(String message) {
        view.showError(message);
    }

    @Override
    public void onDeleteSuccess() {
        view.showMessage("Dispositivo eliminado");
        loadDevices();
    }

    @Override
    public void onDeleteError(String message) {
        view.showError(message);
    }
}