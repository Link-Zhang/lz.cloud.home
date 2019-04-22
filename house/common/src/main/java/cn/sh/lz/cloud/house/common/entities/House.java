package cn.sh.lz.cloud.house.common.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Link at 16:37 on 4/12/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel()
@Table(name = "house")
public class House {
    @javax.persistence.Id
    @Column(nullable = false, name = "house_id")
    @ApiModelProperty(value = "房屋ID", example = "107000005011", required = true)
    private BigInteger houseId;

    @Column(nullable = false, name = "house_district")
    @ApiModelProperty(value = "市辖区", position = 1, example = "浦东", required = true)
    private String houseDistrict;

    @Column(nullable = false, name = "house_community_name")
    @ApiModelProperty(value = "小区名称", position = 2, example = "西门锦绣苑", required = true)
    private String houseCommunityName;

    @Column(nullable = false, name = "house_usage")
    @ApiModelProperty(value = "房屋用途", position = 3, example = "普通住宅", required = true)
    private String houseUsage;

    @Column(nullable = false, name = "house_trading_situation")
    @ApiModelProperty(value = "交易情况", position = 4, example = "暂无数据", required = true)
    private String houseTradingSituation;

    @Column(nullable = false, name = "house_is_unique")
    @ApiModelProperty(value = "唯一情况", position = 5, example = "不唯一", required = true)
    private String houseIsUnique;

    @Column(nullable = false, name = "house_structure_area")
    @ApiModelProperty(value = "建筑面积", position = 6, example = "108.76", required = true)
    private Double houseStructureArea;

    @Column(nullable = false, name = "house_total_price")
    @ApiModelProperty(value = "房屋总价", position = 7, example = "295", required = true)
    private Double houseTotalPrice;

    @Column(nullable = false, name = "house_down_payment")
    @ApiModelProperty(value = "房屋首付", position = 8, example = "104", required = true)
    private Long houseDownPayment;

    @Column(nullable = false, name = "house_unit_price")
    @ApiModelProperty(value = "房屋单价", position = 9, example = "27124", required = true)
    private Long houseUnitPrice;

    @Column(nullable = false, name = "house_type")
    @ApiModelProperty(value = "房屋户型", position = 10, example = "2室2厅1厨1卫", required = true)
    private String houseType;

    @Column(nullable = false, name = "house_floor")
    @ApiModelProperty(value = "房屋楼层", position = 11, example = "中楼层 (共12层)", required = true)
    private String houseFloor;

    @Column(nullable = false, name = "house_direction")
    @ApiModelProperty(value = "房屋朝向", position = 12, example = "南", required = true)
    private String houseDirection;

    @Column(nullable = false, name = "house_decoration")
    @ApiModelProperty(value = "装修情况", position = 13, example = "毛坯", required = true)
    private String houseDecoration;

    @Column(nullable = false, name = "house_has_elevator")
    @ApiModelProperty(value = "配备电梯", position = 14, example = "有", required = true)
    private String houseHasElevator;

    @Column(nullable = false, name = "house_age")
    @ApiModelProperty(value = "楼龄情况", position = 15, example = "2008年建/板楼", required = true)
    private String houseAge;

    @Column(nullable = false, name = "house_trading_ownership")
    @ApiModelProperty(value = "交易权属", position = 16, example = "动迁安置房", required = true)
    private String houseTradingOwnership;

    @Column(nullable = false, name = "house_property_ownership")
    @ApiModelProperty(value = "产权所属", position = 17, example = "非共有", required = true)
    private String housePropertyOwnership;

    @Column(nullable = false, name = "house_mortgage")
    @ApiModelProperty(value = "抵押情况", position = 18, example = "无抵押", required = true)
    private String houseMortgage;

    @Column(nullable = false, name = "house_certificate")
    @ApiModelProperty(value = "房本备件", position = 19, example = "未上传房本照片", required = true)
    private String houseCertificate;

    @Column(nullable = false, name = "house_url")
    @ApiModelProperty(value = "房屋URL", position = 20, example = "https://sh.lianjia.com/ershoufang/107000005011.html", required = true)
    private String houseUrl;

    @Column(nullable = false, name = "house_community_id")
    @ApiModelProperty(value = "小区ID", position = 21, example = "5011000010458", required = true)
    private BigInteger houseCommunityId;

    @Column(nullable = false, name = "house_community_longitude")
    @ApiModelProperty(value = "小区经度", position = 22, example = "121.7457808", required = true)
    private BigDecimal houseCommunityLongitude;

    @Column(nullable = false, name = "house_community_latitude")
    @ApiModelProperty(value = "小区经度", position = 23, example = "31.052967", required = true)
    private BigDecimal houseCommunityLatitude;

    @Column(nullable = false, name = "house_agent_name")
    @ApiModelProperty(value = "房屋经纪人", position = 24, example = "姜贞玲", required = true)
    private String houseAgentName;

    @Column(nullable = false, name = "house_agent_phone")
    @ApiModelProperty(value = "经纪人电话", position = 25, example = "13641928757", required = true)
    private String houseAgentPhone;

    @Column(nullable = false, name = "house_state")
    @ApiModelProperty(value = "房屋状态", position = 26, example = "有效", required = true)
    private String houseState;

    @Column(nullable = false, name = "first_update")
    @ApiModelProperty(value = "首次更新时间", position = 27, example = "2019-03-30 01:38:25", required = true)
    private Date firstUpdate;

    @Column(nullable = false, name = "last_update")
    @ApiModelProperty(value = "上次更新时间", position = 28, example = "2019-04-11 01:37:34", required = true)
    private Date lastUpdate;
}
