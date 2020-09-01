package cn.sh.lz.cloud.house.services.impls;

import cn.sh.lz.cloud.history.clients.HistoryClient;
import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.history.common.inputs.HistoryInput;
import cn.sh.lz.cloud.history.common.outputs.HistoryOutput;
import cn.sh.lz.cloud.history.common.vos.HistoryFindVO;
import cn.sh.lz.cloud.history.common.vos.HistoryVO;
import cn.sh.lz.cloud.house.common.dtos.HouseDTO;
import cn.sh.lz.cloud.house.common.entities.House;
import cn.sh.lz.cloud.house.common.utils.ConvertUtil;
import cn.sh.lz.cloud.house.repositories.HouseRepository;
import cn.sh.lz.cloud.house.services.HouseService;
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
 * Created by Link at 16:48 on 4/11/19.
 */
@Service
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;

    private final HistoryClient historyClient;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository, HistoryClient historyClient) {
        this.houseRepository = houseRepository;
        this.historyClient = historyClient;
    }

    // todo: method too complex
    private Specification<House> getHouseSpecification(HouseDTO houseDTO) {
        Assert.notNull(houseDTO, "The given houseDTO must not be null!");
        Double ceilStructureArea = Optional.ofNullable(houseDTO.getHouseLeStructureArea()).filter(i -> i > 0).orElse(null);
        Double floorStructureArea = Optional.ofNullable(houseDTO.getHouseGeStructureArea()).filter(i -> i > 0).orElse(null);
        Double ceilTotalPrice = Optional.ofNullable(houseDTO.getHouseLeTotalPrice()).filter(i -> i > 0).orElse(null);
        Double floorTotalPrice = Optional.ofNullable(houseDTO.getHouseGeTotalPrice()).filter(i -> i > 0).orElse(null);
        Long ceilDownPayment = Optional.ofNullable(houseDTO.getHouseLeDownPayment()).filter(i -> i > 0).orElse(null);
        Long floorDownPayment = Optional.ofNullable(houseDTO.getHouseGeDownPayment()).filter(i -> i > 0).orElse(null);
        Long ceilUnitPrice = Optional.ofNullable(houseDTO.getHouseLeUnitPrice()).filter(i -> i > 0).orElse(null);
        Long floorUnitPrice = Optional.ofNullable(houseDTO.getHouseGeUnitPrice()).filter(i -> i > 0).orElse(null);
        return (Specification<House>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (!StringUtils.isEmpty(houseDTO.getHouseDistrict())) {
                predicateList.add(criteriaBuilder.like(root.get("houseDistrict").as(String.class), "%" + houseDTO.getHouseDistrict().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseCommunityId())) {
                predicateList.add(criteriaBuilder.equal(root.get("houseCommunityId").as(BigInteger.class), houseDTO.getHouseCommunityId()));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseCommunityName())) {
                predicateList.add(criteriaBuilder.like(root.get("houseCommunityName").as(String.class), "%" + houseDTO.getHouseCommunityName().trim() + "%"));
            }
            if (null != ceilStructureArea) {
                predicateList.add(criteriaBuilder.le(root.get("houseStructureArea").as(Double.class), ceilStructureArea));
            }
            if (null != floorStructureArea) {
                predicateList.add(criteriaBuilder.ge(root.get("houseStructureArea").as(Double.class), floorStructureArea));
            }
            if (null != ceilTotalPrice) {
                predicateList.add(criteriaBuilder.le(root.get("houseTotalPrice").as(Double.class), ceilTotalPrice));
            }
            if (null != floorTotalPrice) {
                predicateList.add(criteriaBuilder.ge(root.get("houseTotalPrice").as(Double.class), floorTotalPrice));
            }
            if (null != ceilDownPayment) {
                predicateList.add(criteriaBuilder.le(root.get("houseDownPayment").as(Long.class), ceilDownPayment));
            }
            if (null != floorDownPayment) {
                predicateList.add(criteriaBuilder.ge(root.get("houseDownPayment").as(Long.class), floorDownPayment));
            }
            if (null != ceilUnitPrice) {
                predicateList.add(criteriaBuilder.le(root.get("houseUnitPrice").as(Long.class), ceilUnitPrice));
            }
            if (null != floorUnitPrice) {
                predicateList.add(criteriaBuilder.ge(root.get("houseUnitPrice").as(Long.class), floorUnitPrice));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseType())) {
                predicateList.add(criteriaBuilder.like(root.get("houseType").as(String.class), "%" + houseDTO.getHouseType().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseState())) {
                predicateList.add(criteriaBuilder.like(root.get("houseState").as(String.class), "%" + houseDTO.getHouseState().trim() + "%"));
            }
            Predicate[] predicate = new Predicate[predicateList.size()];
            return criteriaBuilder.and(predicateList.toArray(predicate));
        };
    }

    @Transactional(readOnly = true)
    @Override
    public Page<House> findAllPaginated(HouseDTO houseDTO, Pageable pageable) {
        Assert.notNull(pageable, "The given pageable must not be null!");
        if (Optional.ofNullable(houseDTO).isPresent()) {
            return houseRepository.findAll(getHouseSpecification(houseDTO), pageable);
        } else {
            HouseDTO emptyHouseDTO = new HouseDTO();
            emptyHouseDTO.setHouseState("已更新");
            return houseRepository.findAll(getHouseSpecification(emptyHouseDTO), pageable);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<History> findHistoryByHouseId(BigInteger id) {
        Assert.notNull(id, "The given id must not be null!");
        HistoryFindVO historyFindVO = new HistoryFindVO();
        historyFindVO.setHistoryHouseId(id);
        HistoryInput historyInput = new HistoryInput();
        historyInput.setLimit(Integer.MAX_VALUE);
        historyInput.setHistoryFindVO(historyFindVO);
        HistoryOutput historyOutput = historyClient.find(historyInput);
        List<HistoryVO> list = new ArrayList<>();
        if (Optional.ofNullable(historyOutput).isPresent()) {
            list = historyOutput.getHistoryVOList();
        }
        ConvertUtil<HistoryVO, History> convertUtil = new ConvertUtil<>();
        return convertUtil.convert(list, History.class);
    }
}
