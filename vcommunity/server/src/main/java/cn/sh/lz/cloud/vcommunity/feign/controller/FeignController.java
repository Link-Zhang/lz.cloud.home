package cn.sh.lz.cloud.vcommunity.feign.controller;

import cn.sh.lz.cloud.vcommunity.clients.VCommunityClient;
import cn.sh.lz.cloud.vcommunity.common.inputs.VCommunityInput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityHouseByIdOutput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityOutput;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Link at 09:31 on 6/4/19.
 */
@CrossOrigin(origins = "*", allowCredentials = "true")
@RequestMapping("/feign/vcommunity")
@RestController
public class FeignController {
    private final DiscoveryClient discoveryClient;

    private final VCommunityClient vcommunityClient;

    @Autowired
    public FeignController(DiscoveryClient discoveryClient, VCommunityClient vcommunityClient) {
        this.discoveryClient = discoveryClient;
        this.vcommunityClient = vcommunityClient;
    }

    @ApiOperation(value = "社区", notes = "获取社区(默认10条)")
    @GetMapping(path = "/")
    public VCommunityOutput findAll(VCommunityInput vCommunityInput) {
        return vcommunityClient.findAll(vCommunityInput);
    }

    @ApiOperation(value = "社区微服务测试", notes = "进行社区微服务测试")
    @GetMapping(path = "/hello")
    public String hello() {
        return vcommunityClient.hello();
    }

    @ApiOperation(value = "社区微服务实例", notes = "获取社区微服务实例")
    @GetMapping(path = "/instances")
    public List<ServiceInstance> instances() {
        return discoveryClient.getInstances("vcommunity");
    }


    @ApiOperation(value = "指定社区的房屋", notes = "获取指定ID社区的房屋")
    @GetMapping(path = "/{id}/house")
    public VCommunityHouseByIdOutput findHouseByCommunityId(@PathVariable("id") BigInteger id) {
        return vcommunityClient.findHouseByCommunityId(id);
    }
}
