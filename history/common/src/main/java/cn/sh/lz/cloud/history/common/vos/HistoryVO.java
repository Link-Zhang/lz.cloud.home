package cn.sh.lz.cloud.history.common.vos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by Link at 17:22 on 5/20/19.
 */
@Data
public class HistoryVO {
    @JsonProperty("updateTime")
    @ApiModelProperty(notes = "更新时间", example = "2020-09-01 12:00:00")
    private Date historyUpdateTime;

    @JsonProperty("oldHouseTotalPrice")
    @ApiModelProperty(notes = "原房屋总价", position = 1, example = "300")
    private Double historyOldHouseTotalPrice;

    @JsonProperty("oldHouseUnitPrice")
    @ApiModelProperty(notes = "原房屋单价", position = 2, example = "37903")
    private Long historyOldHouseUnitPrice;

    @JsonProperty("newHouseTotalPrice")
    @ApiModelProperty(notes = "新房屋总价", position = 3, example = "298")
    private Double historyNewHouseTotalPrice;

    @JsonProperty("newHouseUnitPrice")
    @ApiModelProperty(notes = "新房屋单价", position = 4, example = "37651")
    private Long historyNewHouseUnitPrice;
}
