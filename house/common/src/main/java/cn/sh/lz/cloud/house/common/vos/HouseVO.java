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

    @JsonProperty("communityName")
    @ApiModelProperty(notes = "小区名称", position = 1, example = "晶波坊")
    private String houseCommunityName;

    @JsonProperty("structureArea")
    @ApiModelProperty(notes = "建筑面积", position = 2, example = "78.7")
    private Double houseStructureArea;

    @JsonProperty("totalPrice")
    @ApiModelProperty(notes = "房屋总价", position = 3, example = "370")
    private Double houseTotalPrice;

    @JsonProperty("unitPrice")
    @ApiModelProperty(notes = "房屋单价", position = 4, example = "47014")
    private Long houseUnitPrice;

    @JsonProperty("type")
    @ApiModelProperty(notes = "房屋户型", position = 5, example = "3室2厅")
    private String houseType;

    @JsonProperty("url")
    @ApiModelProperty(notes = "房屋URL", position = 6, example = "https://m.ke.com/sh/ershoufang/107102472292.html")
    private String houseUrl;
}
