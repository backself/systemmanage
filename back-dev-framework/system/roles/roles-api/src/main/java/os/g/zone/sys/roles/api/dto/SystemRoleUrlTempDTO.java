package os.g.zone.sys.roles.api.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据传输层 对象类
 * @Auther: AA
 * @Date: 2023/3/30 0:03
 * @Version 1.0.0
 */
@Data
public class SystemRoleUrlTempDTO implements Serializable {
    /**
     * 角色链接表主键id
     */
    @TableId(type = IdType.AUTO)
    private Integer tempId;

    /**
     * 角色id
     */
    private Integer roleId;


    /**
     * 链接id
     */
    private Integer urlId;

    /**
     * 角色链接对应关系状态（0：有效；1：失效）
     */
    private Integer tempStatus;

    /**
     * 最后一次修改对应关系的原因
     */
    private String tempReason;

    /**
     * 角色链接对应关系创建时间
     */
    private Date tempCreateTime;

    /**
     * 角色链接对应关系更新时间
     */
    private Date tempModifiedTime;

    /**
     * 对应关系是否删除（0：未删除，1：已删除）
     */
    private Integer tempIsDel;



}