package vip.linfeng.mcweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.linfeng.mcweb.common.utils.BaseResult;
import vip.linfeng.mcweb.service.WebAuthService;

import java.util.Map;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 11:00
 * @apiNote
 */
//@CrossOrigin
@RestController
@RequestMapping("/user")
public class WebAuthController {
    private WebAuthService webAuthService;

    @Autowired
    public void setWebAuthService(WebAuthService webAuthService) {
        this.webAuthService = webAuthService;
    }
    @PostMapping("/auth/login")
    public BaseResult login(@RequestBody Map<String, String> userInfo){
        String username = userInfo.get("username");
        String password = userInfo.get("password");
        if(username == null){
            return BaseResult.err(401, "用户名未输入");
        }
        if(password == null){
            return BaseResult.err(401, "密码未输入");
        }
        String token = webAuthService.login(username, password);
        if(token != null){
            return BaseResult.ok("登录成功", token);
        }
        return BaseResult.err(403, "用户名或密码有误");
    }
}
