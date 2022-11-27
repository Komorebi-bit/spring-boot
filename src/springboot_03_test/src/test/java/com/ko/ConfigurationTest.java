package com.ko;

import com.ko.config.MsgConfig;
import net.bytebuddy.asm.Advice.AssignReturned.ToFields;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author Komorebi
 * @since 2022.11.27.13:16
 */
@SpringBootTest
@Import(MsgConfig.class)
public class ConfigurationTest {
    @Autowired
    private String msg; //有Import就可以自动装配了

    @Test
    public void testConfiguration(){
        System.out.println(msg);
    }
}
