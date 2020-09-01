package cn.sh.lz.cloud.history.services;

import cn.sh.lz.cloud.history.common.dtos.HistoryFindDTO;
import cn.sh.lz.cloud.history.common.entities.History;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Link at 14:02 on 5/23/19.
 */
public interface HistoryService {
    Page<History> findAllPaginated(HistoryFindDTO historyFindDTO, Pageable pageable);
}
