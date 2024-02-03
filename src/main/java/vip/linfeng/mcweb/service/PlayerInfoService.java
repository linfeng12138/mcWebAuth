package vip.linfeng.mcweb.service;

import org.springframework.stereotype.Service;
import vip.linfeng.mcweb.pojo.Player;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 16:28
 * @apiNote
 */
public interface PlayerInfoService {
    /**
     * 根据uuid获取玩家信息
     * @param uuid 玩家的uuid
     * @return 返回玩家在游戏内的所有可显示信息
     */
    Player getUserInfoByUuid(String uuid);

    /**
     * 根据uuid购买最大生命值
     * @param uuid 玩家的uuid
     * @return 返回是否购买成功
     */
    Boolean buyMaxHealthByUuid(String uuid);

    /**
     * 根据uuid查看购买两个最大生命值所需的金额
     * @param uuid 玩家的uuid
     * @return 返回所需金额
     */
    Double getBuyMaxHealthMoneyByUuid(String uuid);

}
