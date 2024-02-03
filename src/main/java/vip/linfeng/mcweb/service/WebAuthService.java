package vip.linfeng.mcweb.service;

import org.springframework.stereotype.Service;
import vip.linfeng.mcweb.pojo.User;

import java.util.List;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 10:01
 * @apiNote
 */
public interface WebAuthService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 返回玩家的uuid
     */
    String login(String username, String password);

    /**
     * 根据uuid获取玩家基本信息
     * @param uuid 玩家的uuid
     * @return 返回玩家的web端基本信息
     */
    User getUserInfoByUuid(String uuid);

    /**
     * 获取玩家列表信息
     * @return 获取玩家基本信息
     */
    List<User> getUserInfoList();
}
