package cn.sh.lz.cloud.house.common.dtos;

import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 10:05 on 4/12/19.
 */
@Data
public class HouseDTO {
    private String houseDistrict;

    private String houseCommunityName;

    private Double houseLeStructureArea;

    private Double houseGeStructureArea;

    private Double houseLeTotalPrice;

    private Double houseGeTotalPrice;

    private Long houseLeDownPayment;

    private Long houseGeDownPayment;

    private Long houseLeUnitPrice;

    private Long houseGeUnitPrice;

    private String houseType;

    private BigInteger houseCommunityId;

    private String houseState;
}
