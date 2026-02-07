package com.svalero.ecorepairmobile.presenter;

import com.svalero.ecorepairmobile.contract.RepairListContract;
import com.svalero.ecorepairmobile.domain.Repair;
import com.svalero.ecorepairmobile.model.RepairListModel;

import java.util.List;

public class RepairListPresenter implements RepairListContract.Presenter,
        RepairListContract.Model.OnLoadListener,
        RepairListContract.Model.OnDeleteListener {

    private final RepairListContract.Model model;
    private final RepairListContract.View view;

    public RepairListPresenter(RepairListContract.View view) {
        this.view = view;
        this.model = new RepairListModel();
    }

    @Override
    public void loadRepairs() {
        model.loadRepairs(this);
    }

    @Override
    public void deleteRepair(long id) {
        model.deleteRepair(id, this);
    }

    @Override
    public void onLoadSuccess(List<Repair> repairs) {
        view.showRepairs(repairs);
        view.showMessage("Reparaciones cargadas");
    }

    @Override
    public void onLoadError(String message) {
        view.showError(message);
    }

    @Override
    public void onDeleteSuccess() {
        view.showMessage("Reparación eliminada");
        loadRepairs();
    }

    @Override
    public void onDeleteError(String message) {
        view.showError(message);
    }
}
