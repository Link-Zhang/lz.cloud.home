package cn.sh.lz.cloud.vcommunity.services.impls;

/***
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 */

/***
 *  佛曰:
 *          写字楼里写字间，写字间里程序员；
 *          程序人员写程序，又拿程序换酒钱。
 *          酒醒只在网上坐，酒醉还来网下眠；
 *          酒醉酒醒日复日，网上网下年复年。
 *          但愿老死电脑间，不愿鞠躬老板前；
 *          奔驰宝马贵者趣，公交自行程序员。
 *          别人笑我忒疯癫，我笑自己命太贱；
 *          不见满街漂亮妹，哪个归得程序员？
 */

/***
 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
 * │Esc│! 1│@ 2│# 3│$ 4│% 5│^ 6│& 7│* 8│( 9│) 0│_ -│+ =│| \│~ `│
 * ├───┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴───┤
 * │ Tab │ Q │ W │ E │ R │ T │ Y │ U │ I │ O │ P │{ [│} ]│ Del │
 * ├─────┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴─────┤
 * │ Ctrl │ A │ S │ D │ F │ G │ H │ J │ K │ L │: ;│" '│ Return │
 * ├──────┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴───┬────┤
 * │ Shift  │ Z │ X │ C │ V │ B │ N │ M │< ,│> .│? /│Shift│ Fn │
 * └─────┬──┴─┬─┴──┬┴───┴───┴───┴───┴───┴──┬┴───┼───┴┬────┴────┘
 *       │ Alt│ ⌘ ◇│                       │◇ ⌘ │ Alt│
 *       └────┴────┴───────────────────────┴────┴────┘
 *
 *                  Happy Hacking Key Board
 */

import cn.sh.lz.cloud.vcommunity.common.dos.VCommunityCountDO;
import cn.sh.lz.cloud.vcommunity.common.dtos.VCommunityCountDTO;
import cn.sh.lz.cloud.vcommunity.common.dtos.VCommunityDTO;
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
    @Autowired
    private VCommunityRepository vCommunityRepository;

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
    public List<VCommunityCountDTO> findCount(String district) {
        List<VCommunityCountDO> list;
        if (StringUtils.isEmpty(district)) {
            list = vCommunityRepository.findCount();
        } else {
            list = vCommunityRepository.findDistrictCount("%" + district.trim() + "%");
        }
        List<VCommunityCountDTO> rList = new ArrayList<>();
        for (VCommunityCountDO item : list) {
            if (Optional.ofNullable(item.getDistrict()).isPresent() && Optional.ofNullable(item.getCount()).isPresent()) {
                rList.add(new VCommunityCountDTO(item.getDistrict(), item.getCount()));
            }
        }
        return rList;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<VCommunityDTO> findByVCommunityId(BigInteger id) {
        Assert.notNull(id, "The given id must not be null!");
        ConvertUtil<VCommunity, VCommunityDTO> convertUtil = new ConvertUtil<>();
        return Optional.ofNullable(convertUtil.convert(vCommunityRepository.findById(id).orElse(null), VCommunityDTO.class));
    }
}
