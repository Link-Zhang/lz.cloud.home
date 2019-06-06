package cn.sh.lz.cloud.history.feign.interceptor;

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

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

/**
 * Created by Link at 13:46 on 6/5/19.
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    private static final Logger log = LoggerFactory.getLogger(FeignRequestInterceptor.class);
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void apply(RequestTemplate template) {
        if (HttpMethod.GET.name().equals(template.method())
                && null != template.body()) {
            try {
                JsonNode jsonNode = objectMapper.readTree(template.body());
                template.body(null);
                Map<String, Collection<String>> queries = new HashMap<>();
                buildQuery(jsonNode, "", queries);
                template.queries(queries);
            } catch (IOException e) {
                log.error("【拦截GET请求POJO方式】-出错了：{}", JSON.toJSONString(e));
                throw new RuntimeException();
            }
        }
    }

    private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
        if (!jsonNode.isContainerNode()) {
            if (jsonNode.isNull()) {
                return;
            }
            Collection<String> values = queries.get(path);
            if (null == values) {
                values = new ArrayList<>();
                queries.put(path, values);
            }
            values.add(jsonNode.asText());
            return;
        }
        if (jsonNode.isArray()) {
            Iterator<JsonNode> it = jsonNode.elements();
            while (it.hasNext()) {
                buildQuery(it.next(), path, queries);
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                if (StringUtils.hasText(path)) {
                    buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
                } else {
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                }
            }
        }
    }
}
