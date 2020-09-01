package cn.sh.lz.cloud.statistic.common.utils;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Link at 19:19 on 6/10/19.
 */
public class ConvertUtil<S, D> {
    private void convert(S src, D dst) {
        BeanUtil.copyProperties(src, dst);
    }

    public D convert(S src, Class<D> dstClazz) {
        if (null == src) {
            return null;
        }
        D dst = null;
        try {
            dst = dstClazz.newInstance();
        } catch (Exception ignored) {
        }
        convert(src, dst);
        return dst;
    }

    public List<D> convert(List<S> srcList, Class<D> dstClazz) {
        if (CollectionUtils.isEmpty(srcList)) {
            return new ArrayList<>();
        }
        List<D> dstList = new ArrayList<>();
        for (S src : srcList) {
            dstList.add(convert(src, dstClazz));
        }
        return dstList;
    }
}
