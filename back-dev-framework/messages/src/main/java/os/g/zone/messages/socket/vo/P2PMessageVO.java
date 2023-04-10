package os.g.zone.messages.socket.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * 点对点消息数据类
 */
@Data
@NoArgsConstructor
public class P2PMessageVO<T> implements Serializable {
    //接收消息的用户id
    private Long reciveUId;
    //发送消息的用户id
    private Long sendUId;
    //消息内容
    private T content;

}
