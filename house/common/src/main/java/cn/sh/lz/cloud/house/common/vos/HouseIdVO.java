package cn.sh.lz.cloud.house.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by Link at 09:58 on 4/12/19.
 */
@Data
public class HouseIdVO {
    @JsonProperty("district")
    @ApiModelProperty(value = "市辖区")
    private String houseDistrict;

    @JsonProperty("communityName")
    @ApiModelProperty(value = "小区名称")
    private String houseCommunityName;

    @JsonProperty("usage")
    @ApiModelProperty(value = "房屋用途")
    private String houseUsage;

    @JsonProperty("tradingSituation")
    @ApiModelProperty(value = "交易情况")
    private String houseTradingSituation;

    @JsonProperty("isUnique")
    @ApiModelProperty(value = "是否唯一")
    private String houseIsUnique;

    @JsonProperty("leStructureArea")
    @ApiModelProperty(value = "最大建筑面积")
    private Double houseLeStructureArea;

    @JsonProperty("geStructureArea")
    @ApiModelProperty(value = "最小建筑面积")
    private Double houseGeStructureArea;

    @JsonProperty("leTotalPrice")
    @ApiModelProperty(value = "最高房屋总价")
    private Double houseLeTotalPrice;

    @JsonProperty("geTotalPrice")
    @ApiModelProperty(value = "最低房屋总价")
    private Double houseGeTotalPrice;

    @JsonProperty("leDownPayment")
    @ApiModelProperty(value = "最高房屋首付")
    private Long houseLeDownPayment;

    @JsonProperty("geDownPayment")
    @ApiModelProperty(value = "最低房屋首付")
    private Long houseGeDownPayment;

    @JsonProperty("leUnitPrice")
    @ApiModelProperty(value = "最高房屋单价")
    private Long houseLeUnitPrice;

    @JsonProperty("geUnitPrice")
    @ApiModelProperty(value = "最低房屋单价")
    private Long houseGeUnitPrice;

    @JsonProperty("type")
    @ApiModelProperty(value = "房屋户型")
    private String houseType;

    @JsonProperty("floor")
    @ApiModelProperty(value = "房屋楼层")
    private String houseFloor;

    @JsonProperty("direction")
    @ApiModelProperty(value = "房屋朝向")
    private String houseDirection;

    @JsonProperty("decoration")
    @ApiModelProperty(value = "装修情况")
    private String houseDecoration;

    @JsonProperty("hasElevator")
    @ApiModelProperty(value = "配备电梯")
    private String houseHasElevator;

    @JsonProperty("age")
    @ApiModelProperty(value = "楼龄情况")
    private String houseAge;

    @JsonProperty("tradingOwnership")
    @ApiModelProperty(value = "交易权属")
    private String houseTradingOwnership;

    @JsonProperty("propertyOwnership")
    @ApiModelProperty(value = "产权所属")
    private String housePropertyOwnership;

    @JsonProperty("mortgage")
    @ApiModelProperty(value = "抵押情况")
    private String houseMortgage;

    @JsonProperty("certificate")
    @ApiModelProperty(value = "房本备件")
    private String houseCertificate;

    @JsonProperty("communityId")
    @ApiModelProperty(value = "小区Id")
    private String houseCommunityId;
}
