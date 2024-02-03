package vip.linfeng.mcweb.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 8:45
 * @apiNote
 */
@Data
public class BaseMPDB implements Serializable {
    private Integer id;
    private String uuid;
    private String name;
    private Boolean syncComplete;
    private String lastSeen;
}
