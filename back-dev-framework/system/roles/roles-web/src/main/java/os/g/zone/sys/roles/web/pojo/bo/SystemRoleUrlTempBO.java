package os.g.zone.sys.roles.web.pojo.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 权限链接对应关系表

当权限或者链接匹配模式修改时：
将该权限或者链接原持有的所有链接记录全部设置为失效；

详细描述如下：
当修改权限匹配模式为通用模式时
权限级别修改后需要将该权限原持有的匹配模式为精准模式的所有链接记录全部设置为失效

当修改权限匹配模式为精准模式时
权限级别修改后需要将该权限原持有的匹配模式为通用模式的所有链接记录全部设置为失效


当级别发生改变时：

当链接级别发生改变时：
链接如果为通用模式匹配下则不产生影响；
链接如果为对精准模式匹配则将原有的记录更新为失效，保存原因在每条记录的temp_reason字段，并排除掉已失效的记录
并将新的权限链接关系记录到此表中

当权限级别发生改变时
权限的匹配模式如果为通用模式匹配下则不产生影响；
权限的匹配模式如果为对精准模式匹配则将原有的记录更新为失效，保存原因在每条记录的temp_reason字段，并排除掉已失效的记录
并将新的权限链接关系记录到此表中
 * @TableName system_role_url_temp
 */
@Data
public class SystemRoleUrlTempBO implements Serializable {

    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 链接id
     */
    private List<Long> urlIds;

    private List<SystemRoleUrlTempBO> childs;

}