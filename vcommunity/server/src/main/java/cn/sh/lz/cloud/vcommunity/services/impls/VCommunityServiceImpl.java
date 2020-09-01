package cn.sh.lz.cloud.vcommunity.services.impls;

import cn.sh.lz.cloud.house.clients.HouseClient;
import cn.sh.lz.cloud.house.common.entities.House;
import cn.sh.lz.cloud.house.common.inputs.HouseInput;
import cn.sh.lz.cloud.house.common.outputs.HouseOutput;
import cn.sh.lz.cloud.house.common.vos.HouseFindVO;
import cn.sh.lz.cloud.house.common.vos.HouseVO;
import cn.sh.lz.cloud.vcommunity.common.dtos.VCommunityFindDTO;
import cn.sh.lz.cloud.vcommunity.common.entities.VCommunity;
import cn.sh.lz.cloud.vcommunity.common.utils.ConvertUtil;
import cn.sh.lz.cloud.vcommunity.repositories.VCommunityRepository;
import cn.sh.lz.cloud.vcommunity.services.VCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Link at 17:24 on 5/30/19.
 */
@Service
public class VCommunityServiceImpl implements VCommunityService {
    private final VCommunityRepository vCommunityRepository;

    private final HouseClient houseClient;

    @Autowired
    public VCommunityServiceImpl(VCommunityRepository vCommunityRepository, HouseClient houseClient) {
        this.vCommunityRepository = vCommunityRepository;
        this.houseClient = houseClient;
    }

    // todo: method too complex
    private Specification<VCommunity> getVCommunitySpecification(VCommunityFindDTO vCommunityFindDTO) {
        Assert.notNull(vCommunityFindDTO, "The given vCommunityFindDTO must not be null!");
        Double ceilAvgTotalPrice = Optional.ofNullable(vCommunityFindDTO.getLeAvgTotalPrice()).filter(i -> i > 0).orElse(null);
        Double floorAvgTotalPrice = Optional.ofNullable(vCommunityFindDTO.getGeAvgTotalPrice()).filter(i -> i > 0).orElse(null);
        Double ceilAvgUnitPrice = Optional.ofNullable(vCommunityFindDTO.getLeAvgUnitPrice()).filter(i -> i > 0).orElse(null);
        Double floorAvgUnitPrice = Optional.ofNullable(vCommunityFindDTO.getGeAvgUnitPrice()).filter(i -> i > 0).orElse(null);
        Double ceilMaxTotalPrice = Optional.ofNullable(vCommunityFindDTO.getLeMaxTotalPrice()).filter(i -> i > 0).orElse(null);
        Double floorMaxTotalPrice = Optional.ofNullable(vCommunityFindDTO.getGeMaxTotalPrice()).filter(i -> i > 0).orElse(null);
        Double ceilMaxStructureArea = Optional.ofNullable(vCommunityFindDTO.getLeMaxStructureArea()).filter(i -> i > 0).orElse(null);
        Double floorMaxStructureArea = Optional.ofNullable(vCommunityFindDTO.getGeMaxStructureArea()).filter(i -> i > 0).orElse(null);
        Long ceilMaxDownPayment = Optional.ofNullable(vCommunityFindDTO.getLeMaxDownPayment()).filter(i -> i > 0).orElse(null);
        Long floorMaxDownPayment = Optional.ofNullable(vCommunityFindDTO.getGeMaxDownPayment()).filter(i -> i > 0).orElse(null);
        Long ceilMinUnitPrice = Optional.ofNullable(vCommunityFindDTO.getLeMinUnitPrice()).filter(i -> i > 0).orElse(null);
        Long floorMinUnitPrice = Optional.ofNullable(vCommunityFindDTO.getGeMinUnitPrice()).filter(i -> i > 0).orElse(null);
        Double ceilMinTotalPrice = Optional.ofNullable(vCommunityFindDTO.getLeMinTotalPrice()).filter(i -> i > 0).orElse(null);
        Double floorMinTotalPrice = Optional.ofNullable(vCommunityFindDTO.getGeMinTotalPrice()).filter(i -> i > 0).orElse(null);
        Double ceilMinStructureArea = Optional.ofNullable(vCommunityFindDTO.getLeMinStructureArea()).filter(i -> i > 0).orElse(null);
        Double floorMinStructureArea = Optional.ofNullable(vCommunityFindDTO.getGeMinStructureArea()).filter(i -> i > 0).orElse(null);
        Long ceilMinDownPayment = Optional.ofNullable(vCommunityFindDTO.getLeMinDownPayment()).filter(i -> i > 0).orElse(null);
        Long floorMinDownPayment = Optional.ofNullable(vCommunityFindDTO.getGeMinDownPayment()).filter(i -> i > 0).orElse(null);
        Long ceilMaxUnitPrice = Optional.ofNullable(vCommunityFindDTO.getLeMaxUnitPrice()).filter(i -> i > 0).orElse(null);
        Long floorMaxUnitPrice = Optional.ofNullable(vCommunityFindDTO.getGeMaxUnitPrice()).filter(i -> i > 0).orElse(null);
        return (Specification<VCommunity>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (!StringUtils.isEmpty(vCommunityFindDTO.getDistrict())) {
                predicateList.add(criteriaBuilder.like(root.get("communityDistrict").as(String.class), "%" + vCommunityFindDTO.getDistrict().trim() + "%"));
            }
            if (!StringUtils.isEmpty(vCommunityFindDTO.getName())) {
                predicateList.add(criteriaBuilder.like(root.get("communityName").as(String.class), "%" + vCommunityFindDTO.getName().trim() + "%"));
            }
            if (!StringUtils.isEmpty(vCommunityFindDTO.getHouseCount())) {
                predicateList.add(criteriaBuilder.equal(root.get("communityHouseCount").as(BigInteger.class), vCommunityFindDTO.getHouseCount()));
            }
            if (null != ceilAvgTotalPrice) {
                predicateList.add(criteriaBuilder.le(root.get("communityAvgTotalPrice").as(Double.class), ceilAvgTotalPrice));
            }
            if (null != floorAvgTotalPrice) {
                predicateList.add(criteriaBuilder.ge(root.get("communityAvgTotalPrice").as(Double.class), floorAvgTotalPrice));
            }
            if (null != ceilAvgUnitPrice) {
                predicateList.add(criteriaBuilder.le(root.get("communityAvgUnitPrice").as(Double.class), ceilAvgUnitPrice));
            }
            if (null != floorAvgUnitPrice) {
                predicateList.add(criteriaBuilder.ge(root.get("communityAvgUnitPrice").as(Double.class), floorAvgUnitPrice));
            }
            if (null != ceilMaxTotalPrice) {
                predicateList.add(criteriaBuilder.le(root.get("communityMaxTotalPrice").as(Double.class), ceilMaxTotalPrice));
            }
            if (null != floorMaxTotalPrice) {
                predicateList.add(criteriaBuilder.ge(root.get("communityMaxTotalPrice").as(Double.class), floorMaxTotalPrice));
            }
            if (null != ceilMaxStructureArea) {
                predicateList.add(criteriaBuilder.le(root.get("communityMaxStructureArea").as(Double.class), ceilMaxStructureArea));
            }
            if (null != floorMaxStructureArea) {
                predicateList.add(criteriaBuilder.ge(root.get("communityMaxStructureArea").as(Double.class), floorMaxStructureArea));
            }
            if (null != ceilMaxDownPayment) {
                predicateList.add(criteriaBuilder.le(root.get("communityMaxDownPayment").as(Long.class), ceilMaxDownPayment));
            }
            if (null != floorMaxDownPayment) {
                predicateList.add(criteriaBuilder.ge(root.get("communityMaxDownPayment").as(Long.class), floorMaxDownPayment));
            }
            if (null != ceilMinUnitPrice) {
                predicateList.add(criteriaBuilder.le(root.get("communityMinUnitPrice").as(Long.class), ceilMinUnitPrice));
            }
            if (null != floorMinUnitPrice) {
                predicateList.add(criteriaBuilder.ge(root.get("communityMinUnitPrice").as(Long.class), floorMinUnitPrice));
            }
            if (null != ceilMinTotalPrice) {
                predicateList.add(criteriaBuilder.le(root.get("communityMinTotalPrice").as(Double.class), ceilMinTotalPrice));
            }
            if (null != floorMinTotalPrice) {
                predicateList.add(criteriaBuilder.ge(root.get("communityMinTotalPrice").as(Double.class), floorMinTotalPrice));
            }
            if (null != ceilMinStructureArea) {
                predicateList.add(criteriaBuilder.le(root.get("communityMinStructureArea").as(Double.class), ceilMinStructureArea));
            }
            if (null != floorMinStructureArea) {
                predicateList.add(criteriaBuilder.ge(root.get("communityMinStructureArea").as(Double.class), floorMinStructureArea));
            }
            if (null != ceilMinDownPayment) {
                predicateList.add(criteriaBuilder.le(root.get("communityMinDownPayment").as(Long.class), ceilMinDownPayment));
            }
            if (null != floorMinDownPayment) {
                predicateList.add(criteriaBuilder.ge(root.get("communityMinDownPayment").as(Long.class), floorMinDownPayment));
            }
            if (null != ceilMaxUnitPrice) {
                predicateList.add(criteriaBuilder.le(root.get("communityMaxUnitPrice").as(Long.class), ceilMaxUnitPrice));
            }
            if (null != floorMaxUnitPrice) {
                predicateList.add(criteriaBuilder.ge(root.get("communityMaxUnitPrice").as(Long.class), floorMaxUnitPrice));
            }
            Predicate[] predicate = new Predicate[predicateList.size()];
            return criteriaBuilder.and(predicateList.toArray(predicate));
        };
    }

    @Transactional(readOnly = true)
    @Override
    public Page<VCommunity> findAllPaginated(VCommunityFindDTO vCommunityFindDTO, Pageable pageable) {
        Assert.notNull(pageable, "The given pageable must not be null!");
        if (Optional.ofNullable(vCommunityFindDTO).isPresent()) {
            return vCommunityRepository.findAll(getVCommunitySpecification(vCommunityFindDTO), pageable);
        } else {
            return vCommunityRepository.findAll(pageable);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<House> findHouseByCommunityId(BigInteger id) {
        Assert.notNull(id, "The given id must not be null!");
        HouseFindVO houseFindVO = new HouseFindVO();
        houseFindVO.setHouseCommunityId(id);
        HouseInput houseInput = new HouseInput();
        houseInput.setLimit(Integer.MAX_VALUE);
        houseInput.setHouseFindVO(houseFindVO);
        HouseOutput houseOutput = houseClient.find(houseInput);
        List<HouseVO> list = new ArrayList<>();
        if (Optional.ofNullable(houseOutput).isPresent()) {
            list = houseOutput.getHouseVOList();
        }
        ConvertUtil<HouseVO, House> convertUtil = new ConvertUtil<>();
        return convertUtil.convert(list, House.class);
    }
}
