package os.g.zone.messages.commons;

/**
 * 实时数据展示位置
 * @Auther: AA
 * @Date: 2023/4/10 02:17
 * @Description: DisplayPositionEnum
 * @Version 1.0.0
 */
public enum DisplayPositionEnum {
    CARD_ONLINE("1"),
    CARD_MSG("2"),
    CARD_STOCKS("3"),
    CARD_ORDERS("4"),
    REPORTS("5");
    private String position;
    DisplayPositionEnum(String position){
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
