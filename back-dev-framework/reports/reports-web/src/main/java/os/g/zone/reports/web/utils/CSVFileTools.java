package os.g.zone.reports.web.utils;

import lombok.extern.slf4j.Slf4j;
import os.g.zone.reports.api.dto.ReportsDataDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: AA
 * @Date: 2023/4/8 14:52
 * @Description: CSVFileTools
 * @Version 1.0.0
 */
@Slf4j
public class CSVFileTools {

    /** CSV文件列分隔符 */
    private static final String CSV_COLUMN_SEPARATOR = ",";

    /** CSV文件行分隔符 */
    private static final String CSV_RN = "\r\n";

    public static boolean doExportListData(List<ReportsDataDTO> dataDTOS, String colNames, String mapKey, OutputStream os) {
        try {
            StringBuffer buf = new StringBuffer();

            String[] colNamesArr = null;
            String[] mapKeyArr = null;

            colNamesArr = colNames.split(",");
            mapKeyArr = mapKey.split(",");


            for (int i = 0;i<dataDTOS.size();i++){
                // 文件表头
                buf.append(dataDTOS.get(i).getName()).append(CSV_COLUMN_SEPARATOR);
                // 完成数据csv文件的封装
                // 输出列头
                for (String aColNamesArr : colNamesArr) {
                    buf.append(aColNamesArr).append(CSV_COLUMN_SEPARATOR);
                }
            }
            buf.append(CSV_RN);
            for (ReportsDataDTO item:dataDTOS) {
                if (null != item.getData()) { // 输出数据
                    for (Map<String, Object> itemData : item.getData()) {
                        for (String aMapKeyArr : mapKeyArr) {
                            buf.append(itemData.get(aMapKeyArr)).append(CSV_COLUMN_SEPARATOR);
                        }
                        buf.append(CSV_RN);
                    }
                }
            }

            // 写出响应
            os.write(buf.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();
            return true;
        } catch (Exception e) {
            log.error("doExport错误...", e);
        }
        return false;
    }

    /**
     *
     * @param dataList 集合数据
     * @param colNames 表头部数据
     * @param mapKey 查找的对应数据
     * @param os 返回结果
     */
    public static boolean doExport(List<HashMap<String, Object>> dataList, String colNames, String mapKey, OutputStream os) {
        try {
            StringBuffer buf = new StringBuffer();

            String[] colNamesArr = null;
            String[] mapKeyArr = null;

            colNamesArr = colNames.split(",");
            mapKeyArr = mapKey.split(",");

            // 完成数据csv文件的封装
            // 输出列头
            for (String aColNamesArr : colNamesArr) {
                buf.append(aColNamesArr).append(CSV_COLUMN_SEPARATOR);
            }
            buf.append(CSV_RN);

            if (null != dataList) { // 输出数据
                for (Map<String, Object> aDataList : dataList) {
                    for (String aMapKeyArr : mapKeyArr) {
                        buf.append(aDataList.get(aMapKeyArr)).append(CSV_COLUMN_SEPARATOR);
                    }
                    buf.append(CSV_RN);
                }
            }
            // 写出响应
            os.write(buf.toString().getBytes(StandardCharsets.UTF_8));
            os.flush();
            return true;
        } catch (Exception e) {
            log.error("doExport错误...", e);
        }
        return false;
    }

    /**
     * setHeader
     */
    public static void responseSetProperties(String fileName, HttpServletResponse response) throws UnsupportedEncodingException {
        // 设置文件后缀
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fn = fileName + sdf.format(new Date()) + ".csv";
        // 读取字符编码
        String utf = "UTF-8";

        // 设置响应
        response.setContentType("application/ms-txt.numberformat:@");
        response.setCharacterEncoding(utf);
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control", "max-age=30");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fn, utf));
    }

}

