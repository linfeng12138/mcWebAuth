package vip.linfeng.mcweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vip.linfeng.mcweb.pojo.mpdb.Economy;
import vip.linfeng.mcweb.pojo.mpdb.Exp;
import vip.linfeng.mcweb.pojo.mpdb.HealthFoodAir;
import vip.linfeng.mcweb.pojo.mpdb.Inventory;

import java.io.Serializable;
import java.util.Date;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 8:26
 * @apiNote
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer authId;
    private String name;
    private String uuid;
    private String pwd;
    private Date authCreateDate;
    private Economy economy;
    private Exp exp;
    private HealthFoodAir healthFoodAir;
    private Inventory inventory;
}
