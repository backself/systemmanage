package os.g.zone.reports.web.consts;

/**
 * @Auther: AA
 * @Date: 2023/4/8 13:25
 * @Description: ReportsEnum
 * @Version 1.0.0
 */
public enum ReportsEnum {
    DALIY("0","日订单统计报表","#4D8EFF"),
    WEEK("1","周订单统计报表","#84BFFF"),
    MONTH("2","月订单统计报表","#84BFFF"),
    YEAR("3","年订单统计报表","#84BFFF");
    private String value;
    private String reportName;
    private String reportColor;

    ReportsEnum(String value, String reportName, String reportColor) {
        this.value = value;
        this.reportName = reportName;
        this.reportColor = reportColor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportColor() {
        return reportColor;
    }

    public void setReportColor(String reportColor) {
        this.reportColor = reportColor;
    }
}
