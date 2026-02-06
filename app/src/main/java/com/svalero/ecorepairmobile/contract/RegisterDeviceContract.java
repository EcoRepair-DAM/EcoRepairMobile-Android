package com.svalero.ecorepairmobile.contract;

import com.svalero.ecorepairmobile.domain.Device;

public interface RegisterDeviceContract {

    interface Model {
        interface OnSaveListener {
            void onSaveSuccess();
            void onSaveError(String message);
        }

        void saveDevice(Device device, OnSaveListener listener);
        void updateDevice(Device device, OnSaveListener listener);
    }

    interface View {
        void showError(String message);
        void showSuccess(String message);
        void finishActivity();
    }

    interface Presenter {
        void saveDevice(String name, String brand, String type, String date, boolean reusable);
        void updateDevice(long id, String name, String brand, String type, String date, boolean reusable);
    }
}