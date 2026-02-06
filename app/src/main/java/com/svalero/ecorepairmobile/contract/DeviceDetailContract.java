package com.svalero.ecorepairmobile.contract;

import com.svalero.ecorepairmobile.domain.Device;

public interface DeviceDetailContract {

    interface Model {
        interface OnLoadListener {
            void onLoadSuccess(Device device);
            void onLoadError(String message);
        }

        void loadDevice(long deviceId, OnLoadListener listener);
    }

    interface View {
        void showDevice(Device device);
        void showError(String message);
    }

    interface Presenter {
        void loadDevice(long deviceId);
    }
}