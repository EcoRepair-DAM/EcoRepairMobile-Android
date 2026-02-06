package com.svalero.ecorepairmobile.contract;

import com.svalero.ecorepairmobile.domain.Device;
import java.util.List;

public interface DeviceListContract {

    interface Model {
        interface OnLoadListener {
            void onLoadSuccess(List<Device> devices);
            void onLoadError(String message);
        }

        interface OnDeleteListener {
            void onDeleteSuccess();
            void onDeleteError(String message);
        }

        void loadDevices(OnLoadListener listener);
        void deleteDevice(long id, OnDeleteListener listener);
    }

    interface View {
        void showDevices(List<Device> devices);
        void showMessage(String message);
        void showError(String message);
    }

    interface Presenter {
        void loadDevices();
        void deleteDevice(long id);
    }
}