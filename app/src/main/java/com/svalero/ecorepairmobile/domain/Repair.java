package com.svalero.ecorepairmobile.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Repair {
    private long id;
    private String description;
    private double cost;
    private Date repairDate;
    private boolean repair;
    private long deviceId;
}