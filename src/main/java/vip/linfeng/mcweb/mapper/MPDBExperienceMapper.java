package vip.linfeng.mcweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import vip.linfeng.mcweb.pojo.mpdb.Exp;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 15:23
 * @apiNote
 */
@Mapper
public interface MPDBExperienceMapper {
    Exp selectExpByUserUuid(String uuid);
}
