package vip.linfeng.mcweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import vip.linfeng.mcweb.pojo.mpdb.HealthFoodAir;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 15:53
 * @apiNote
 */
@Mapper
public interface MPDBHealthFoodAirMapper {
    HealthFoodAir selectHealthFoodAirByUserUuid(String uuid);

    /**
     * 根据uuid修改玩家生命值
     * @param uuid 玩家uuid
     * @param num 修改后的生命值
     * @return 返回受影响的条数
     */
    int setMaxHealthByUserUuid(String uuid, double num);

}
