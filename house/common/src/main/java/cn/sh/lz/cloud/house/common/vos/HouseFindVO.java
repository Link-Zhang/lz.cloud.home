package cn.sh.lz.cloud.house.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 09:58 on 4/12/19.
 */
@Data
public class HouseFindVO {
    @JsonProperty("houseDistrict")
    @ApiModelProperty(notes = "市辖区")
    private String houseDistrict;

    @JsonProperty("houseCommunityName")
    @ApiModelProperty(notes = "社区名称")
    private String houseCommunityName;

    @JsonProperty("houseLeStructureArea")
    @ApiModelProperty(notes = "最大建筑面积")
    private Double houseLeStructureArea;

    @JsonProperty("houseGeStructureArea")
    @ApiModelProperty(notes = "最小建筑面积")
    private Double houseGeStructureArea;

    @JsonProperty("houseLeTotalPrice")
    @ApiModelProperty(notes = "最高房屋总价")
    private Double houseLeTotalPrice;

    @JsonProperty("houseGeTotalPrice")
    @ApiModelProperty(notes = "最低房屋总价")
    private Double houseGeTotalPrice;

    @JsonProperty("houseLeDownPayment")
    @ApiModelProperty(notes = "最高房屋首付")
    private Long houseLeDownPayment;

    @JsonProperty("houseGeDownPayment")
    @ApiModelProperty(notes = "最低房屋首付")
    private Long houseGeDownPayment;

    @JsonProperty("houseLeUnitPrice")
    @ApiModelProperty(notes = "最高房屋单价")
    private Long houseLeUnitPrice;

    @JsonProperty("houseGeUnitPrice")
    @ApiModelProperty(notes = "最低房屋单价")
    private Long houseGeUnitPrice;

    @JsonProperty("houseType")
    @ApiModelProperty(notes = "房屋户型")
    private String houseType;

    @JsonProperty("houseCommunityId")
    @ApiModelProperty(notes = "小区Id")
    private BigInteger houseCommunityId;

    @JsonProperty("houseState")
    @ApiModelProperty(notes = "房屋状态")
    private String houseState = "已更新";
}
