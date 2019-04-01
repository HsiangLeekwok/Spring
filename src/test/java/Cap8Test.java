import com.enjoy.cap8.bean.Bird;
import com.enjoy.cap8.config.Cap8MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:45
 * Version: v1.0
 * Description:
 */

public class Cap8Test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap8MainConfig.class);
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        Bird bird = (Bird) app.getBean("bird");
        System.out.println(bird);

        System.out.println("IOC initialize has complete");

        ConfigurableEnvironment environment = app.getEnvironment();
        System.out.println("environment ---> " + environment.getProperty("bird.color"));
        app.close();
    }
}
