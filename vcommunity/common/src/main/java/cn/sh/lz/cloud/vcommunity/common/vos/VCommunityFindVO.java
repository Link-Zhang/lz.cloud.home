package cn.sh.lz.cloud.vcommunity.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 09:36 on 5/31/19.
 */
@Data
public class VCommunityFindVO {
    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区")
    private String district;

    @JsonProperty("name")
    @ApiModelProperty(notes = "社区名称")
    private String name;

    @JsonProperty("houseCount")
    @ApiModelProperty(notes = "房屋数量")
    private BigInteger houseCount;

    @JsonProperty("leAvgTotalPrice")
    @ApiModelProperty(notes = "最大平均总价")
    private Double leAvgTotalPrice;

    @JsonProperty("geAvgTotalPrice")
    @ApiModelProperty(notes = "最小平均总价")
    private Double geAvgTotalPrice;

    @JsonProperty("leAvgUnitPrice")
    @ApiModelProperty(notes = "最大平均单价")
    private Double leAvgUnitPrice;

    @JsonProperty("geAvgUnitPrice")
    @ApiModelProperty(notes = "最小平均单价")
    private Double geAvgUnitPrice;

    @JsonProperty("leMaxTotalPrice")
    @ApiModelProperty(notes = "最大最高总价")
    private Double leMaxTotalPrice;

    @JsonProperty("geMaxTotalPrice")
    @ApiModelProperty(notes = "最小最高总价")
    private Double geMaxTotalPrice;

    @JsonProperty("leMaxStructureArea")
    @ApiModelProperty(notes = "最高最大建筑面积")
    private Double leMaxStructureArea;

    @JsonProperty("geMaxStructureArea")
    @ApiModelProperty(notes = "最低最大建筑面积")
    private Double geMaxStructureArea;

    @JsonProperty("leMaxDownPayment")
    @ApiModelProperty(notes = "最大最高首付")
    private Long leMaxDownPayment;

    @JsonProperty("geMaxDownPayment")
    @ApiModelProperty(notes = "最小最高首付")
    private Long geMaxDownPayment;

    @JsonProperty("leMinUnitPrice")
    @ApiModelProperty(notes = "最大最低单价")
    private Long leMinUnitPrice;

    @JsonProperty("geMinUnitPrice")
    @ApiModelProperty(notes = "最小最低单价")
    private Long geMinUnitPrice;

    @JsonProperty("leMinTotalPrice")
    @ApiModelProperty(notes = "最大最低总价")
    private Double leMinTotalPrice;

    @JsonProperty("geMinTotalPrice")
    @ApiModelProperty(notes = "最小最低总价")
    private Double geMinTotalPrice;

    @JsonProperty("leMinStructureArea")
    @ApiModelProperty(notes = "最高最小建筑面积")
    private Double leMinStructureArea;

    @JsonProperty("geMinStructureArea")
    @ApiModelProperty(notes = "最低最小建筑面积")
    private Double geMinStructureArea;

    @JsonProperty("leMinDownPayment")
    @ApiModelProperty(notes = "最大最低首付")
    private Long leMinDownPayment;

    @JsonProperty("geMinDownPayment")
    @ApiModelProperty(notes = "最小最低首付")
    private Long geMinDownPayment;

    @JsonProperty("leMaxUnitPrice")
    @ApiModelProperty(notes = "最大最高单价")
    private Long leMaxUnitPrice;

    @JsonProperty("geMaxUnitPrice")
    @ApiModelProperty(notes = "最小最高单价")
    private Long geMaxUnitPrice;
}
