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

public class Device {
    private long id;
    private String name;
    private String type;
    private String brand;
    private Date PurchaseDate;
    private boolean reusable;

}
