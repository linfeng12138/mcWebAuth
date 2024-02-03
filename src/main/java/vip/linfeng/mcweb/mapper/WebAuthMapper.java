package vip.linfeng.mcweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import vip.linfeng.mcweb.pojo.User;

import java.util.List;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 8:22
 * @apiNote
 */
@Mapper
public interface WebAuthMapper {
    /**
     * 根据name查询用户认证信息
     * @param name 需要查询的玩家名
     * @return 返回用户认证信息
     */
    User selectUserWebAuthInfoByName(String name);

    /**
     * 根据uuid获取用户信息（一般用于检查玩家是否存在）
     * @param uuid 玩家的uuid
     * @return 返回玩家基本信息
     */
    User selectUserWebAuthInfoByUuid(String uuid);

    /**
     * 获取玩家列表
     * @return 返回玩家基本信息
     */
    List<User> selectUserWebAuthInfoList();
}
