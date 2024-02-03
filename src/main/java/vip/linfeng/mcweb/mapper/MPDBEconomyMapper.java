package vip.linfeng.mcweb.mapper;

import org.apache.ibatis.annotations.Mapper;
import vip.linfeng.mcweb.pojo.mpdb.Economy;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 11:24
 * @apiNote
 */
@Mapper
public interface MPDBEconomyMapper {
    Economy selectEconomyByUserUuid(String uuid);

    /**
     * 根据uuid获取玩家金钱余额
     * @param uuid 玩家uuid
     * @return 返回玩家金钱余额
     */
    double selectMoneyByUserUuid(String uuid);

    /**
     * 根据uuid删除玩家金币，不做金币是否足够检测
     * @param uuid 玩家的uuid
     * @param layOutMoney 需要删除玩家的金币数量
     * @return 返回操作的条数
     */
    int layOutMoneyByUserUuid(String uuid, double layOutMoney);

    /**
     * 根据uuid设置玩家金币
     * @param uuid 玩家的uuid
     * @param money 修改后的金额
     * @return 返回受影响条数
     */
    int setMoneyByUserUuid(String uuid, double money);
}
