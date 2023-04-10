package os.g.zone.sys.roles.web.pojo.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 权限表，对应用户角色
当权限的匹配模式由通用模式修改为精准模式时，保留父级权限id，用于未来修改子级权限
当权限的匹配模式由精准模式修改为通用模式时，必须将当前权限级别修改为小于等与父级权限级别
 * @TableName system_role
 */
@TableName(value ="system_role")
@Data
public class SystemRole implements Serializable {
    /**
     * 角色id
     */
    @TableId(type = IdType.AUTO)
    private Object roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色状态(0:启用状态；1：失效状态)
     */
    private Integer roleStatus;

    /**
     * 角色级别（通用模式下，用户角色对应的权限级别越高可见性越强）
     */
    private Integer roleCommonLevel;

    /**
     * 角色类型（
0：通用模式，使用auth_common_level字段匹配；
1：精准模式，使用auth_spec_level字段匹配）
     */
    private Integer roleType;

    /**
     * 当前角色的父级角色id（
权限模式为通用模式时，父级权限要大于子级权限；
权限模式为精准模式时，则父级权限无效，但是保留，便于修改权限模式
）
     */
    private Integer parentRoleId;

    /**
     * 创建当前角色的用户id
     */
    private Integer createUserId;

    /**
     * 角色级别（精准模式下，只允许同级别权限匹配）
     */
    private Integer roleSpecLevel;

    /**
     * 角色创建时间
     */
    private Date roleCreateTime;

    /**
     * 角色更新时间
     */
    private Date roleModifiedTime;

    /**
     * 角色删除标志：0：未删除，1：已删除
     */
    private Integer roleIsDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}