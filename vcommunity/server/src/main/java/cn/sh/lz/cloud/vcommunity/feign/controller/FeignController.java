package cn.sh.lz.cloud.vcommunity.feign.controller;

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

import cn.sh.lz.cloud.vcommunity.clients.VCommunityClient;
import cn.sh.lz.cloud.vcommunity.common.inputs.VCommunityCountInput;
import cn.sh.lz.cloud.vcommunity.common.inputs.VCommunityInput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityByIdOutput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityCountOutput;
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
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private VCommunityClient vcommunityClient;

    @ApiOperation(value = "社区", notes = "获取社区(默认10条)")
    @GetMapping(path = "/")
    public VCommunityOutput findAll(VCommunityInput vCommunityInput) {
        return vcommunityClient.findAll(vCommunityInput);
    }

    @ApiOperation(value = "各辖区社区数量", notes = "获取各辖区社区数量")
    @GetMapping(path = "/count")
    public VCommunityCountOutput findCount(VCommunityCountInput vCommunityCountInput) {
        return vcommunityClient.findCount(vCommunityCountInput);
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

    @ApiOperation(value = "指定社区", notes = "获取指定ID的社区")
    @GetMapping(path = "/{id}")
    public VCommunityByIdOutput findById(@PathVariable("id") BigInteger id) {
        return vcommunityClient.findById(id);
    }

    @ApiOperation(value = "指定社区的房屋", notes = "获取指定ID社区的房屋")
    @GetMapping(path = "/{id}/house")
    public VCommunityHouseByIdOutput findHouseByCommunityId(@PathVariable("id") BigInteger id) {
        return vcommunityClient.findHouseByCommunityId(id);
    }
}
