package cn.sh.lz.cloud.history.feign.controller;

import cn.sh.lz.cloud.history.clients.HistoryClient;
import cn.sh.lz.cloud.history.common.inputs.HistoryInput;
import cn.sh.lz.cloud.history.common.outputs.HistoryOutput;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Link at 14:05 on 6/4/19.
 */
@CrossOrigin(origins = "*", allowCredentials = "true")
@RequestMapping("/feign/history")
@RestController
public class FeignController {
    private final DiscoveryClient discoveryClient;

    private final HistoryClient historyClient;

    @Autowired
    public FeignController(DiscoveryClient discoveryClient, HistoryClient historyClient) {
        this.discoveryClient = discoveryClient;
        this.historyClient = historyClient;
    }

    @ApiOperation(value = "历史价格", notes = "获取历史价格(默认10条)")
    @GetMapping(value = "/")
    public HistoryOutput find(HistoryInput historyInput) {
        return historyClient.find(historyInput);
    }

    @ApiOperation(value = "历史微服务测试", notes = "进行历史微服务测试")
    @GetMapping(value = "/hello")
    public String hello() {
        return historyClient.hello();
    }

    @ApiOperation(value = "历史微服务实例", notes = "获取历史微服务实例")
    @GetMapping(value = "/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances("history");
    }
}
