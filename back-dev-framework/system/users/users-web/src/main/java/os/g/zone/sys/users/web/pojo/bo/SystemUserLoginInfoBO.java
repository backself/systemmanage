package os.g.zone.sys.users.web.pojo.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 用户表，保存用户信息
 * @TableName system_user
 */
@Data
public class SystemUserLoginInfoBO implements Serializable {
    /**
     * 用户编号
     */
    private Object userId;

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
    private List<HashMap<String,Object>> permissions;

}