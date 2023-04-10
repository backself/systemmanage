package os.g.zone.messages.socket.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * 广播消息数据传输体
 */
@Data
@NoArgsConstructor
public class BCMessageVO<T> implements Serializable {
    private String displayPosition;
    //消息内容
    private T content;
}
