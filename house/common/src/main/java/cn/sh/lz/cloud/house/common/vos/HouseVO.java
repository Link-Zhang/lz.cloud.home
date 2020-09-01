package cn.sh.lz.cloud.house.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 09:58 on 4/12/19.
 */
@Data
public class HouseVO {
    @JsonProperty("id")
    @ApiModelProperty(notes = "房屋ID", example = "107102472292")
    private BigInteger houseId;

    @JsonProperty("district")
    @ApiModelProperty(notes = "市辖区", position = 1, example = "浦东")
    private String houseDistrict;

    @JsonProperty("communityName")
    @ApiModelProperty(notes = "小区名称", position = 2, example = "晶波坊")
    private String houseCommunityName;

    @JsonProperty("structureArea")
    @ApiModelProperty(notes = "建筑面积", position = 3, example = "78.7")
    private Double houseStructureArea;

    @JsonProperty("totalPrice")
    @ApiModelProperty(notes = "房屋总价", position = 4, example = "370")
    private Double houseTotalPrice;

    @JsonProperty("downPayment")
    @ApiModelProperty(notes = "房屋首付", position = 5, example = "130")
    private Long houseDownPayment;

    @JsonProperty("unitPrice")
    @ApiModelProperty(notes = "房屋单价", position = 6, example = "47014")
    private Long houseUnitPrice;

    @JsonProperty("type")
    @ApiModelProperty(notes = "房屋户型", position = 7, example = "3室2厅")
    private String houseType;

    @JsonProperty("url")
    @ApiModelProperty(notes = "房屋URL", position = 8, example = "https://m.ke.com/sh/ershoufang/107102472292.html")
    private String houseUrl;

    @JsonProperty("communityId")
    @ApiModelProperty(notes = "小区ID", position = 9, example = "5011000004005")
    private BigInteger houseCommunityId;

    @JsonProperty("state")
    @ApiModelProperty(notes = "房屋状态", position = 10, example = "已更新")
    private String houseState;
}
