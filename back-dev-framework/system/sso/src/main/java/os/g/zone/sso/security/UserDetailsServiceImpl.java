package os.g.zone.sso.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import os.g.zone.sys.users.api.dto.SystemUserLoginInfoDTO;
import os.g.zone.sys.users.api.service.ISystemUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring Security处理认证时使用到的获取管理员登录详情的实现类
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @DubboReference
    private ISystemUserService dubboSystemUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.debug("Spring Security调用了loadUserByUsername()方法，参数：{}", s);

        SystemUserLoginInfoDTO loginInfo = dubboSystemUserService.getLoginInfoByUsername(s);
        log.debug("从数据库中根据用户名【{}】查询登录信息，结果：{}", s, loginInfo);

        if (loginInfo == null) {
            return null;
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> permissions = loginInfo.getPermissions();
        for (String permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }

        UserLoginDetails userLoginDetails = new UserLoginDetails(
                loginInfo.getUserId(),
                loginInfo.getUserName(),
                loginInfo.getUserPassword(),true,
                authorities);
        log.debug("即将向Spring Security返回UserDetails类型的对象：{}", userLoginDetails);
        return userLoginDetails;
    }

}
