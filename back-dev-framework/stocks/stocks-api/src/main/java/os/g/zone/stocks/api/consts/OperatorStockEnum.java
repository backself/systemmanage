package os.g.zone.stocks.api.consts;

/**
 * 库存修改类型
 * @Auther: AA
 * @Date: 2023/4/5 23:49
 * @Description: OperatorStockEnum
 * @Version 1.0.0
 */
public enum OperatorStockEnum {
    REDUCE(0),
    PLUS(1);
    private Integer type;
    OperatorStockEnum(Integer type){
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
