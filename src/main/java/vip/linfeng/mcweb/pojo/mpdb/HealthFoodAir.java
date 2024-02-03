package vip.linfeng.mcweb.pojo.mpdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import vip.linfeng.mcweb.common.pojo.BaseMPDB;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 8:52
 * @apiNote
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthFoodAir extends BaseMPDB {
    private Double health;
    private Double healthScale;
    private Double maxHealth;
    private Integer food;
    private String saturation;
    private Integer air;
    private Integer maxAir;
}
