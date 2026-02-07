package com.svalero.ecorepairmobile.presenter;

import com.svalero.ecorepairmobile.contract.RepairDetailContract;
import com.svalero.ecorepairmobile.domain.Repair;
import com.svalero.ecorepairmobile.model.RepairDetailModel;

public class RepairDetailPresenter implements RepairDetailContract.Presenter,
        RepairDetailContract.Model.OnLoadListener {

    private final RepairDetailContract.Model model;
    private final RepairDetailContract.View view;

    public RepairDetailPresenter(RepairDetailContract.View view) {
        this.view = view;
        this.model = new RepairDetailModel();
    }

    @Override
    public void loadRepair(long repairId) {
        model.loadRepair(repairId, this);
    }

    @Override
    public void onLoadSuccess(Repair repair) {
        view.showRepair(repair);
    }

    @Override
    public void onLoadError(String message) {
        view.showError(message);
    }
}
