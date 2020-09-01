package cn.sh.lz.cloud.vcommunity.common.dtos;

import lombok.Data;

import java.math.BigInteger;

/**
 * Created by Link at 10:02 on 5/31/19.
 */
@Data
public class VCommunityFindDTO {
    private String district;

    private String name;

    private BigInteger houseCount;

    private Double leAvgTotalPrice;

    private Double geAvgTotalPrice;

    private Double leAvgUnitPrice;

    private Double geAvgUnitPrice;

    private Double leMaxTotalPrice;

    private Double geMaxTotalPrice;

    private Double leMaxStructureArea;

    private Double geMaxStructureArea;

    private Long leMaxDownPayment;

    private Long geMaxDownPayment;

    private Long leMinUnitPrice;

    private Long geMinUnitPrice;

    private Double leMinTotalPrice;

    private Double geMinTotalPrice;

    private Double leMinStructureArea;

    private Double geMinStructureArea;

    private Long leMinDownPayment;

    private Long geMinDownPayment;

    private Long leMaxUnitPrice;

    private Long geMaxUnitPrice;
}
