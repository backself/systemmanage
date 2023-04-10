package os.g.zone.sso.security;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 管理员登录信息详情类，用于Spring Security处理认证
 *
 * @author java@tedu.cn
 * @version 0.0.1
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserLoginDetails extends User {

    private Long id;

    public UserLoginDetails(Long id, String username, String password, boolean enabled,
                            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled,
                true, true, true, authorities);
        this.id = id;
    }

}
