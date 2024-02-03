package vip.linfeng.mcweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.linfeng.mcweb.mapper.WebAuthMapper;
import vip.linfeng.mcweb.pojo.User;
import vip.linfeng.mcweb.service.WebAuthService;

import java.util.List;

/**
 * @author linfeng
 * @version 1.0
 * @createTime 2024/2/1 10:55
 * @apiNote
 */
@Service
public class WebAuthServiceImpl implements WebAuthService {
    private WebAuthMapper webAuthMapper;

    @Autowired
    public void setWebAuthMapper(WebAuthMapper webAuthMapper) {
        this.webAuthMapper = webAuthMapper;
    }

    @Override
    public String login(String username, String password) {
        System.out.println(webAuthMapper);
        User user = webAuthMapper.selectUserWebAuthInfoByName(username);
        if (user == null){
            // 用户名输入错误
            return null;
        }
        String pwd = user.getPwd();
        if (pwd.equals(password)) {
            // 密码正确，返回token
            return user.getUuid();
        }
        // 密码错误，返回空值
        return null;
    }

    @Override
    public User getUserInfoByUuid(String uuid) {
        return webAuthMapper.selectUserWebAuthInfoByUuid(uuid);
    }

    @Override
    public List<User> getUserInfoList() {
        List<User> users = webAuthMapper.selectUserWebAuthInfoList();
        users.forEach(System.out::println);
        return users;
    }
}
