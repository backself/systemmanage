package os.g.zone.sys.users.web.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表，保存用户信息
 * @TableName system_user
 */
@TableName(value ="system_user")
@Data
public class SystemUserPO implements Serializable {
    /**
     * 用户编号
     */
    @TableId(type = IdType.AUTO)
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
     * 用户账号状态（0：不可用；1：可用）
     */
    private Integer userStatus;

    /**
     * 用户创建时间
     */
    private Date userCreateTime;

    /**
     * 创建当前账号的用户id
     */
    private Integer parentUserId;

    /**
     * 用户更新时间
     */
    private Date userModifiedTime;

    /**
     * 用户删除状态标识（0：未删除，1：已删除）
     */
    private Integer userIsDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}