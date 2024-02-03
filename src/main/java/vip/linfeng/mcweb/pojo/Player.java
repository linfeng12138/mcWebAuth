package vip.linfeng.mcweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 11:30
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player implements Serializable {
    /**
     * 玩家id
     */
    private Integer id;
    /**
     * 玩家uuid
     */
    private String uuid;
    /**
     * 玩家姓名
     */
    private String name;
    /**
     * 玩家金币数量
     */
    private Double money;
    /**
     * 玩家等级
     */
    private Integer lv;
    /**
     * 玩家当前生命值
     */
    private Double health;
    /**
     * 玩家最大生命值
     * 死后不变
     */
    private Double maxHealth;
    /**
     * 玩家饱食度
     */
    private Integer food;
    /**
     * 当前空气值
     */
    private Integer air;
    /**
     * 最大空气值
     */
    private Integer maxAir;
    /**
     * 游戏模式
     */
    private Integer gamemode;
}
