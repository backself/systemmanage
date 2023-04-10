package os.g.zone.commons.results;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 数据分页类
 * <T> 查到的记录类型
 * @Auther: AA
 * @Date: 2023/3/29 19:31
 * @Version 1.0.0
 */
@Data
public class JsonPage<T> implements Serializable {

    private Long pageIndex; // 当前页下标
    private Long pageSize; // 一页包含记录数
    private Long totalPage; // 总页数
    private Long total; // 记录总数
    private List<?> list; // 数据


    /**
     * 分页
     */
    public static final<T> JsonPage<T> parse(IPage<?> page) {
        JsonPage<T> jsonPage = new JsonPage<>();
        jsonPage.setPageIndex(page.getCurrent());
        jsonPage.setPageSize(page.getSize());
        jsonPage.setTotalPage(page.getPages());
        jsonPage.setTotal(page.getTotal());
        jsonPage.setList(page.getRecords());
        return jsonPage;
    }


}
