package vip.linfeng.mcweb.pojo.mpdb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import vip.linfeng.mcweb.common.pojo.BaseMPDB;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 8:35
 * @apiNote
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Economy extends BaseMPDB {
    private Double money;
    private Double offlineMoney;
}
