package cn.sh.lz.cloud.history.services.impls;

import cn.sh.lz.cloud.history.common.dtos.HistoryFindDTO;
import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.history.repositories.HistoryRepository;
import cn.sh.lz.cloud.history.services.HistoryService;
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
 * Created by Link at 14:02 on 5/23/19.
 */

@Service
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public Page<History> findAllPaginated(HistoryFindDTO historyFindDTO, Pageable pageable) {
        Assert.notNull(pageable, "The given pageable must not be null!");
        if (Optional.ofNullable(historyFindDTO).isPresent()) {
            Double downRangeHouseTotalPrice = Optional.ofNullable(historyFindDTO.getDownRangeHouseTotalPrice()).filter(i -> i > 0).orElse(null);
            Long downRangeHouseDownPayment = Optional.ofNullable(historyFindDTO.getDownRangeHouseDownPayment()).filter(i -> i > 0).orElse(null);
            Long downRangeHouseUnitPrice = Optional.ofNullable(historyFindDTO.getDownRangeHouseUnitPrice()).filter(i -> i > 0).orElse(null);
            Specification<History> specification = (Specification<History>) (root, criteriaQuery, criteriaBuilder) -> {
                List<Predicate> predicateList = new ArrayList<>();
                if (!StringUtils.isEmpty(historyFindDTO.getHistoryHouseId())) {
                    predicateList.add(criteriaBuilder.equal(root.get("historyHouseId").as(BigInteger.class), historyFindDTO.getHistoryHouseId()));
                }
                if (!StringUtils.isEmpty(historyFindDTO.getHistoryHouseDistrict())) {
                    predicateList.add(criteriaBuilder.like(root.get("historyHouseDistrict").as(String.class), "%" + historyFindDTO.getHistoryHouseDistrict().trim() + "%"));
                }
                if (null != downRangeHouseTotalPrice) {
                    predicateList.add(criteriaBuilder.ge(criteriaBuilder.diff(root.get("historyOldHouseTotalPrice").as(Double.class), root.get("historyNewHouseTotalPrice").as(Double.class)), downRangeHouseTotalPrice));
                }
                if (null != downRangeHouseDownPayment) {
                    predicateList.add(criteriaBuilder.ge(criteriaBuilder.diff(root.get("historyOldHouseDownPayment").as(Long.class), root.get("historyNewHouseDownPayment").as(Long.class)), downRangeHouseDownPayment));
                }
                if (null != downRangeHouseUnitPrice) {
                    predicateList.add(criteriaBuilder.ge(criteriaBuilder.diff(root.get("historyOldHouseUnitPrice").as(Long.class), root.get("historyNewHouseUnitPrice").as(Long.class)), downRangeHouseUnitPrice));
                }
                Predicate[] predicate = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(predicate));
            };
            return historyRepository.findAll(specification, pageable);
        } else {
            return historyRepository.findAll(pageable);
        }
    }
}
