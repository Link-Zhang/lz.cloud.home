package cn.sh.lz.cloud.history.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Link at 17:22 on 5/20/19.
 */
@Data
public class HistoryVO {
    @JsonProperty("id")
    @ApiModelProperty(notes = "历史ID", example = "4")
    private BigInteger historyId;

    @JsonProperty("houseId")
    @ApiModelProperty(notes = "房屋ID", position = 1, example = "107102760430")
    private BigInteger historyHouseId;

    @JsonProperty("houseDistrict")
    @ApiModelProperty(notes = "市辖区", position = 2, example = "浦东")
    private String historyHouseDistrict;

    @JsonProperty("houseUrl")
    @ApiModelProperty(notes = "房屋URL", position = 3, example = "https://m.ke.com/sh/ershoufang/107102760430.html")
    private String historyHouseUrl;

    @JsonProperty("oldHouseTotalPrice")
    @ApiModelProperty(notes = "原房屋总价", position = 4, example = "300")
    private Double historyOldHouseTotalPrice;

    @JsonProperty("oldHouseDownPayment")
    @ApiModelProperty(notes = "原房屋首付", position = 5, example = "105")
    private Long historyOldHouseDownPayment;

    @JsonProperty("oldHouseUnitPrice")
    @ApiModelProperty(notes = "原房屋单价", position = 6, example = "37903")
    private Long historyOldHouseUnitPrice;

    @JsonProperty("newHouseTotalPrice")
    @ApiModelProperty(notes = "新房屋总价", position = 7, example = "298")
    private Double historyNewHouseTotalPrice;

    @JsonProperty("newHouseDownPayment")
    @ApiModelProperty(notes = "新房屋首付", position = 8, example = "105")
    private Long historyNewHouseDownPayment;

    @JsonProperty("newHouseUnitPrice")
    @ApiModelProperty(notes = "新房屋单价", position = 9, example = "37651")
    private Long historyNewHouseUnitPrice;

    @JsonProperty("updateTime")
    @ApiModelProperty(notes = "更新时间", position = 10, example = "2020-09-01 12:00:00")
    private Date historyUpdateTime;
}
