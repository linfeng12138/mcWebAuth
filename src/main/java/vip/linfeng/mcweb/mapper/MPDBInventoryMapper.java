package vip.linfeng.mcweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import vip.linfeng.mcweb.pojo.mpdb.Inventory;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 16:21
 * @apiNote
 */
@Mapper
public interface MPDBInventoryMapper {
    Inventory selectInventoryByUserUuid(String uuid);
}
