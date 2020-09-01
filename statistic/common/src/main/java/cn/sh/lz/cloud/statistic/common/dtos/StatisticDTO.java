package cn.sh.lz.cloud.statistic.common.dtos;

import lombok.Data;

import java.util.Date;

/**
 * Created by Link at 19:44 on 6/10/19.
 */
@Data
public class StatisticDTO {
    private String statisticHouseDistrict;

    private Date startUpdateTime;

    private Date endUpdateTime;
}
