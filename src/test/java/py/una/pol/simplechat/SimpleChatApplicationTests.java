package py.una.pol.simplechat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import py.una.pol.simplechat.controller.MessageController;

@SpringBootTest
class SimpleChatApplicationTests {

    @Autowired
    private MessageController messageController;

    @Test
    void contextLoads() {
        Assert.notNull(messageController, "The MessageController can't be null");
    }

}
