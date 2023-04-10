package os.g.zone.messages;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * redis测试类
 */
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    void redisBaseOperaTest() {
        // 设置String类型的key值，有效时间未1000毫秒
        redisTemplate.opsForValue().set("test","1", 1000,TimeUnit.MINUTES);
        System.out.println(redisTemplate.opsForValue().get("test"));
        // 设置String类型的key值，有效时间为1000毫秒
        redisTemplate.opsForValue().set("test","1", 1000, TimeUnit.MINUTES);
        System.out.println(redisTemplate.opsForValue().get("test"));
    }
}
