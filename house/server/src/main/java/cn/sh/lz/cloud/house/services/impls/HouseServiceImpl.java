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
import org.springframework.beans.factory.annotation.Value;
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

/**
 * Created by Link at 16:48 on 4/11/19.
 */
@Service
public class


HouseServiceImpl implements HouseService {
    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HistoryClient historyClient;

    @Value("${cn.sh.lz.cloud.house.default.size}")
    private Integer DEFAULT_SIZE;

    @Value("${cn.sh.lz.cloud.house.default.page}")
    private Integer DEFAULT_PAGE;

    @Value("${cn.sh.lz.cloud.house.default.price}")
    private Double DEFAULT_PRICE;

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
            if (!StringUtils.isEmpty(houseDTO.getHouseUsage())) {
                predicateList.add(criteriaBuilder.like(root.get("houseUsage").as(String.class), "%" + houseDTO.getHouseUsage().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseTradingSituation())) {
                predicateList.add(criteriaBuilder.like(root.get("houseTradingSituation").as(String.class), "%" + houseDTO.getHouseTradingSituation().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseIsUnique())) {
                predicateList.add(criteriaBuilder.equal(root.get("houseIsUnique").as(String.class), houseDTO.getHouseIsUnique().trim()));
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
            if (!StringUtils.isEmpty(houseDTO.getHouseFloor())) {
                predicateList.add(criteriaBuilder.like(root.get("house_floor").as(String.class), "%" + houseDTO.getHouseFloor().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseDirection())) {
                predicateList.add(criteriaBuilder.like(root.get("houseDirection").as(String.class), "%" + houseDTO.getHouseDirection().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseDecoration())) {
                predicateList.add(criteriaBuilder.like(root.get("houseDecoration").as(String.class), "%" + houseDTO.getHouseDecoration().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseHasElevator())) {
                predicateList.add(criteriaBuilder.like(root.get("houseHasElevator").as(String.class), "%" + houseDTO.getHouseHasElevator().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseAge())) {
                predicateList.add(criteriaBuilder.like(root.get("houseAge").as(String.class), "%" + houseDTO.getHouseAge().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseTradingOwnership())) {
                predicateList.add(criteriaBuilder.like(root.get("houseTradingOwnership").as(String.class), "%" + houseDTO.getHouseTradingOwnership().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHousePropertyOwnership())) {
                predicateList.add(criteriaBuilder.like(root.get("housePropertyOwnership").as(String.class), "%" + houseDTO.getHousePropertyOwnership().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseMortgage())) {
                predicateList.add(criteriaBuilder.like(root.get("houseMortgage").as(String.class), "%" + houseDTO.getHouseMortgage().trim() + "%"));
            }
            if (!StringUtils.isEmpty(houseDTO.getHouseCertificate())) {
                predicateList.add(criteriaBuilder.like(root.get("houseCertificate").as(String.class), "%" + houseDTO.getHouseCertificate().trim() + "%"));
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
            return houseRepository.findAll(pageable);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<History> findHistoryByHouseId(BigInteger id) {
        Assert.notNull(id, "The given id must not be null!");
        HistoryFindVO historyFindVO = new HistoryFindVO();
        historyFindVO.setHistoryHouseId(id);
        HistoryInput historyInput = new HistoryInput();
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
