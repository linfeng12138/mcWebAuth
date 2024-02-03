package vip.linfeng.mcweb.pojo.mpdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import vip.linfeng.mcweb.common.pojo.BaseMPDB;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 8:48
 * @apiNote
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exp extends BaseMPDB {
    private Double exp;
    private Integer expToLevel;
    private Integer totalExp;
    private Integer expLvl;
}
