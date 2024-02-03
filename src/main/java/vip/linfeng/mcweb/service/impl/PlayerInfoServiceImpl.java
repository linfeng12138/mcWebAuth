package vip.linfeng.mcweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vip.linfeng.mcweb.mapper.MPDBEconomyMapper;
import vip.linfeng.mcweb.mapper.MPDBExperienceMapper;
import vip.linfeng.mcweb.mapper.MPDBHealthFoodAirMapper;
import vip.linfeng.mcweb.mapper.MPDBInventoryMapper;
import vip.linfeng.mcweb.pojo.Player;
import vip.linfeng.mcweb.pojo.User;
import vip.linfeng.mcweb.pojo.mpdb.Economy;
import vip.linfeng.mcweb.pojo.mpdb.Exp;
import vip.linfeng.mcweb.pojo.mpdb.HealthFoodAir;
import vip.linfeng.mcweb.pojo.mpdb.Inventory;
import vip.linfeng.mcweb.service.PlayerInfoService;
import vip.linfeng.mcweb.service.WebAuthService;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 16:29
 * @apiNote
 */
@Service
public class PlayerInfoServiceImpl implements PlayerInfoService {

    private MPDBEconomyMapper mpdbEconomyMapper;
    private MPDBExperienceMapper mpdbExperienceMapper;
    private MPDBHealthFoodAirMapper mpdbHealthFoodAirMapper;
    private MPDBInventoryMapper mpdbInventoryMapper;
    private WebAuthService webAuthService;
    @Value("${shop.max-health-money}")
    private double shopMaxHealthMoney;
    @Value("${shop.max-health-to-max}")
    private double maxHealthToMax;
    @Value("${shop.max-health-next-add-money}")
    private double maxHealthNextAddMoney;

    @Autowired
    public void setWebAuthService(WebAuthService webAuthService) {
        this.webAuthService = webAuthService;
    }

    @Autowired
    public void setMpdbEconomyMapper(MPDBEconomyMapper mpdbEconomyMapper) {
        this.mpdbEconomyMapper = mpdbEconomyMapper;
    }

    @Autowired
    public void setMpdbExperienceMapper(MPDBExperienceMapper mpdbExperienceMapper) {
        this.mpdbExperienceMapper = mpdbExperienceMapper;
    }

    @Autowired
    public void setMpdbHealthFoodAirMapper(MPDBHealthFoodAirMapper mpdbHealthFoodAirMapper) {
        this.mpdbHealthFoodAirMapper = mpdbHealthFoodAirMapper;
    }

    @Autowired
    public void setMpdbInventoryMapper(MPDBInventoryMapper mpdbInventoryMapper) {
        this.mpdbInventoryMapper = mpdbInventoryMapper;
    }

    @Override
    public Player getUserInfoByUuid(String uuid) {
        if(uuid == null){
            return null;
        }
        User userInfo = webAuthService.getUserInfoByUuid(uuid);
        if(userInfo == null){
            return null;
        }
        Economy economy = mpdbEconomyMapper.selectEconomyByUserUuid(uuid);
        Exp exp = mpdbExperienceMapper.selectExpByUserUuid(uuid);
        Inventory inventory = mpdbInventoryMapper.selectInventoryByUserUuid(uuid);
        HealthFoodAir healthFoodAir = mpdbHealthFoodAirMapper.selectHealthFoodAirByUserUuid(uuid);
        if(economy == null || inventory == null || exp == null || healthFoodAir == null){
            return null;
        }
        return new Player(userInfo.getAuthId(), uuid, userInfo.getName(), economy.getMoney(), exp.getExpLvl(), healthFoodAir.getHealth(), healthFoodAir.getMaxHealth(), healthFoodAir.getFood(), healthFoodAir.getAir(), healthFoodAir.getMaxAir(), inventory.getGamemode());
    }

    @Override
    public Double getBuyMaxHealthMoneyByUuid(String uuid) {
        User userInfo = webAuthService.getUserInfoByUuid(uuid);
        if(userInfo == null){
            // 用户不存在
            return null;
        }
        HealthFoodAir healthFoodAir = mpdbHealthFoodAirMapper.selectHealthFoodAirByUserUuid(uuid);
        if(healthFoodAir == null){
            // 放报错
            return null;
        }
        Double maxHealth = healthFoodAir.getMaxHealth();
        return shopMaxHealthMoney + maxHealthNextAddMoney*(maxHealth-20);
    }

    @Override
    public Boolean buyMaxHealthByUuid(String uuid) {
        User userInfo = webAuthService.getUserInfoByUuid(uuid);
        if(userInfo == null){
            // 用户不存在
            return null;
        }
        Economy economy = mpdbEconomyMapper.selectEconomyByUserUuid(uuid);
        if(economy == null){
            // 防止报错
            return null;
        }
        Double money = economy.getMoney();
        HealthFoodAir healthFoodAir = mpdbHealthFoodAirMapper.selectHealthFoodAirByUserUuid(uuid);
        if(healthFoodAir == null){
            // 放报错
            return null;
        }
        Double maxHealth = healthFoodAir.getMaxHealth();
        if(maxHealth >= maxHealthToMax){
            // 超过生命最大值
            return false;
        }
        double shopMoney = shopMaxHealthMoney + maxHealthNextAddMoney*(maxHealth-20);
        if(money < shopMoney){
            // 金额不足
            return false;
        }

        int moneyStatus = mpdbEconomyMapper.setMoneyByUserUuid(uuid, (money - shopMoney));
        int maxHealthStatus = mpdbHealthFoodAirMapper.setMaxHealthByUserUuid(uuid, (maxHealth + 2));

        // 成功返回true，失败返回false
        return moneyStatus == 1 && maxHealthStatus == 1;
    }
}
