package cn.sh.lz.cloud.house.common.dtos;

import lombok.Data;

/**
 * Created by Link at 10:05 on 4/12/19.
 */
@Data
public class HouseDTO {
    private String houseDistrict;

    private String houseCommunityName;

    private String houseUsage;

    private String houseTradingSituation;

    private String houseIsUnique;

    private Double houseLeStructureArea;

    private Double houseGeStructureArea;

    private Double houseLeTotalPrice;

    private Double houseGeTotalPrice;

    private Long houseLeDownPayment;

    private Long houseGeDownPayment;

    private Long houseLeUnitPrice;

    private Long houseGeUnitPrice;

    private String houseType;

    private String houseFloor;

    private String houseDirection;

    private String houseDecoration;

    private String houseHasElevator;

    private String houseAge;

    private String houseTradingOwnership;

    private String housePropertyOwnership;

    private String houseMortgage;

    private String houseCertificate;

    private String houseCommunityId;
}
