package cn.sh.lz.cloud.house.feign.controller;

import cn.sh.lz.cloud.house.clients.HouseClient;
import cn.sh.lz.cloud.house.common.inputs.*;
import cn.sh.lz.cloud.house.common.outputs.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Link at 14:51 on 6/4/19.
 */
@CrossOrigin(origins = "*", allowCredentials = "true")
@RequestMapping("/feign/house")
@RestController
public class FeignController {
    private final DiscoveryClient discoveryClient;

    private final HouseClient houseClient;

    @Autowired
    public FeignController(DiscoveryClient discoveryClient, HouseClient houseClient) {
        this.discoveryClient = discoveryClient;
        this.houseClient = houseClient;
    }

    @ApiOperation(value = "房屋", notes = "获取房屋(默认10条)")
    @GetMapping(value = "/")
    public HouseOutput find(HouseInput houseInput) {
        return houseClient.find(houseInput);
    }

    @ApiOperation(value = "房屋微服务实例", notes = "获取房屋微服务实例")
    @GetMapping(value = "/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances("house");
    }

    @ApiOperation(value = "房屋微服务测试", notes = "进行房屋微服务测试")
    @GetMapping(value = "/hello")
    public String hello() {
        return houseClient.hello();
    }

    @ApiOperation(value = "指定ID房屋的历史价格", notes = "获取指定ID房屋的历史价格")
    @GetMapping(value = "/{id}/history")
    public HouseHistoryByIdOutput findHistoryByHouseId(@PathVariable(value = "id") BigInteger id) {
        return houseClient.findHistoryByHouseId(id);
    }
}
