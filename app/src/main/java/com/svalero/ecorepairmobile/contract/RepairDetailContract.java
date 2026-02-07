package com.svalero.ecorepairmobile.contract;

import com.svalero.ecorepairmobile.domain.Repair;

public interface RepairDetailContract {

    interface Model {
        interface OnLoadListener {
            void onLoadSuccess(Repair repair);

            void onLoadError(String message);
        }

        void loadRepair(long repairId, OnLoadListener listener);
    }

    interface View {
        void showRepair(Repair repair);

        void showError(String message);
    }

    interface Presenter {
        void loadRepair(long repairId);
    }
}
