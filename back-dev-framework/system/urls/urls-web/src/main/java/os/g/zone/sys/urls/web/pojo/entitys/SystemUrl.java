package os.g.zone.sys.urls.web.pojo.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 链接表（
包含菜单链接
）
 * @TableName system_url
 */
@TableName(value ="system_url")
@Data
public class SystemUrl implements Serializable {
    /**
     * 链接id
     */
    @TableId(type = IdType.AUTO)
    private Integer urlId;

    /**
     * 链接名称
     */
    private String urlName;

    /**
     * 链接地址
     */
    private String urlLink;

    /**
     * 链接状态（0:可用；1：不可用）
     */
    private Integer urlStatus;

    /**
     * 子级链接id
     */
    private Integer childId;

    /**
     * 父级链接id
     */
    private Integer parentId;

    /**
     * 链接类型（0：菜单类型；1：http请求类型）
     */
    private Integer urlType;

    /**
     * 通用模式下：
当前链接的基本级别(
父级链接的url_common_level)要小于等于子级的url_common_level)
     */
    private Integer urlCommonLevel;

    /**
     * 链接匹配模式（0：通用模式下使用url_common_level；1：精准模式下使用url_spec_level）
     */
    private Integer urlMatchType;

    /**
     * 精准模式下：只允许精准匹配同等级权限可见
     */
    private Integer urlSpecLevel;
    /**
     * 链接删除标志：
     * 0：未删除
     * 1：已删除
     * @Auther: AA
     * @Date: 2023/4/3 11:51
     * @Version 1.0.0
     */
    private Integer urlIsDel;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}