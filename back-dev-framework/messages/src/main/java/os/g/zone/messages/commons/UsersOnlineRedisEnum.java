package os.g.zone.messages.commons;

/**
 * redis中使用的key值
 */
public enum UsersOnlineRedisEnum {
    USER_LOGIN("users"), //redis中保存的在线用户的id列表（包含用户id和sessionid）
    MESSAGE_BASIC_TOPIC("message_baseic_topic"),//订阅消息的基础主题

    MESSAGE_TYPE_ALL_TIP("all_tip"),//消息类型一：消息为广播，消息类型为提示
    MESSAGE_TYPE_ALL_DISPLAY("all_display");//消息类型二：消息为广播，消息类型为展示

    private String key;

    /**
     * 使用getKey方法获取指定枚举类型的参数值时，必须使用有参构造函数
     * @param key
     */
    UsersOnlineRedisEnum(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
