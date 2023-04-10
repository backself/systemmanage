package os.g.zone.sys.users.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 用户表，保存用户信息
 * @TableName system_user
 */
@Data
public class SystemUserLoginInfoDTO implements Serializable {
    /**
     * 用户编号
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 权限列表
     */
    private List<String> permissions;

}