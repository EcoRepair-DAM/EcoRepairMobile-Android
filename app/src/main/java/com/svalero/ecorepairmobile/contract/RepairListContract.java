package com.svalero.ecorepairmobile.contract;

import com.svalero.ecorepairmobile.domain.Repair;
import java.util.List;

public interface RepairListContract {

    interface Model {
        interface OnLoadListener {
            void onLoadSuccess(List<Repair> repairs);

            void onLoadError(String message);
        }

        interface OnDeleteListener {
            void onDeleteSuccess();

            void onDeleteError(String message);
        }

        void loadRepairs(OnLoadListener listener);

        void deleteRepair(long id, OnDeleteListener listener);
    }

    interface View {
        void showRepairs(List<Repair> repairs);

        void showMessage(String message);

        void showError(String message);
    }

    interface Presenter {
        void loadRepairs();

        void deleteRepair(long id);
    }
}
