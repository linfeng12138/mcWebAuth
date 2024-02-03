package vip.linfeng.mcweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.linfeng.mcweb.common.utils.BaseResult;
import vip.linfeng.mcweb.pojo.Player;
import vip.linfeng.mcweb.service.PlayerInfoService;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 16:35
 * @apiNote
 */
//@CrossOrigin
@RestController
@RequestMapping("/player")
public class PlayerInfoController {
    private PlayerInfoService playerInfoService;

    @Autowired
    public void setPlayerInfoService(PlayerInfoService playerInfoService) {
        this.playerInfoService = playerInfoService;
    }

    @PostMapping("/getInfo")
    public BaseResult getPlayerInfo(String uuid){
        if(uuid == null){
            return BaseResult.err("uuid不可为空");
        }
        Player userInfoByUuid = playerInfoService.getUserInfoByUuid(uuid);
        return BaseResult.ok(userInfoByUuid);
    }

    @PostMapping("/cat/maxHealth")
    public BaseResult getMaxHealthMoney(String uuid){
        if(uuid == null){
            return BaseResult.err("uuid不可为空");
        }
        Double money = playerInfoService.getBuyMaxHealthMoneyByUuid(uuid);
        return BaseResult.ok(money);
    }

    @PostMapping("/buy/maxHealth")
    public BaseResult buyMaxHealthMoney(String uuid){
        if(uuid == null){
            return BaseResult.err("uuid不可为空");
        }
        Boolean bool = playerInfoService.buyMaxHealthByUuid(uuid);
        if(bool == null){
            return BaseResult.err("无法查到该玩家信息或其它错误");
        } else if(bool.equals(false)){
            return BaseResult.err("玩家余额不足或以达到购买上限");
        }else{
            return BaseResult.ok("购买成功");
        }
    }
}
