package cn.sh.lz.cloud.vcommunity.clients;

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

import cn.sh.lz.cloud.vcommunity.common.inputs.VCommunityCountInput;
import cn.sh.lz.cloud.vcommunity.common.inputs.VCommunityInput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityByIdOutput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityCountOutput;
import cn.sh.lz.cloud.vcommunity.common.outputs.VCommunityOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

/**
 * Created by Link at 09:24 on 6/4/19.
 */
@FeignClient(name = "vcommunity", fallback = VCommunityClient.VCommunityClientFallback.class)
public interface VCommunityClient {
    @GetMapping(value = "/api/v1/vcommunity/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    VCommunityOutput findAll(VCommunityInput vCommunityInput);

    @GetMapping(value = "/api/v1/vcommunity/count", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    VCommunityCountOutput findCount(VCommunityCountInput vCommunityCountInput);

    @GetMapping(value = "/api/v1/vcommunity/hello", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String hello();

    @GetMapping(value = "/api/v1/vcommunity/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    VCommunityByIdOutput findById(@PathVariable("id") BigInteger id);

    @Component
    static class VCommunityClientFallback implements VCommunityClient {
        @Override
        public VCommunityOutput findAll(VCommunityInput vCommunityInput) {
            return null;
        }

        @Override
        public VCommunityCountOutput findCount(VCommunityCountInput vCommunityCountInput) {
            return null;
        }

        @Override
        public String hello() {
            return "服务降级!";
        }

        @Override
        public VCommunityByIdOutput findById(BigInteger id) {
            return null;
        }
    }
}
