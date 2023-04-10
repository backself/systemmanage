package os.g.zone.sso.pojo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemUserLoginParamsDTO implements Serializable {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码（原文）
     */
    private String userPassword;

}
