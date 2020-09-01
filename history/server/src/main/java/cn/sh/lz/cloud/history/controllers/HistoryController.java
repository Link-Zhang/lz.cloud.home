package cn.sh.lz.cloud.history.controllers;

import cn.sh.lz.cloud.history.common.dtos.HistoryFindDTO;
import cn.sh.lz.cloud.history.common.entities.History;
import cn.sh.lz.cloud.history.common.inputs.HistoryInput;
import cn.sh.lz.cloud.history.common.outputs.HistoryOutput;
import cn.sh.lz.cloud.history.common.utils.ConvertUtil;
import cn.sh.lz.cloud.history.common.vos.HistoryFindVO;
import cn.sh.lz.cloud.history.common.vos.HistoryVO;
import cn.sh.lz.cloud.history.services.HistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * Created by Link at 14:03 on 5/23/19.
 */
@RestController
@RequestMapping(path = "/api/v1/history")
@Api(value = "历史微服务", consumes = "application/json")
public class HistoryController {
    @Value("${cn.sh.lz.cloud.history.default.size}")
    private Integer DEFAULT_SIZE;

    @Value("${spring.application.name}")
    private String springApplicationName;

    private final HttpServletRequest request;

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HttpServletRequest request, HistoryService historyService) {
        this.request = request;
        this.historyService = historyService;
    }

    @ApiOperation(value = "获取历史价格", notes = "获取历史价格(默认10条)")
    @GetMapping(path = "/")
    public @ResponseBody
    HistoryOutput find(HistoryInput historyInput) {
        Integer page = historyInput.getPage();
        Integer size = Optional.ofNullable(historyInput.getLimit()).filter(i -> i > 0).orElse(DEFAULT_SIZE);
        Sort sort = Sort.by(historyInput.getSortDirection(), historyInput.getSortProperties());
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        ConvertUtil<HistoryFindVO, HistoryFindDTO> convertUtilIn = new ConvertUtil<>();
        HistoryFindDTO historyFindDTO = convertUtilIn.convert(historyInput.getHistoryFindVO(), HistoryFindDTO.class);
        Page<History> historyPage = historyService.findAllPaginated(historyFindDTO, pageRequest);
        ConvertUtil<History, HistoryVO> convertUtilOut = new ConvertUtil<>();
        List<HistoryVO> historyVOList = convertUtilOut.convert(historyPage.getContent(), HistoryVO.class);
        return new HistoryOutput(historyVOList);
    }

    @ApiOperation(value = "历史微服务测试", notes = "历史微服务测试")
    @GetMapping(path = "/hello")
    public @ResponseBody
    String hello() {
        return springApplicationName + "-" + request.getLocalAddr() + "-" + request.getLocalPort();
    }
}
