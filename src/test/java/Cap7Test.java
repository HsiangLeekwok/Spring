import com.enjoy.cap5.config.Cap5MainConfig;
import com.enjoy.cap7.config.Cap7ConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:45
 * Version: v1.0
 * Description:
 */

public class Cap7Test {

    @Autowired
    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap7ConfigOfLifeCycle.class);
//        String[] names = app.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
        System.out.println("IOC initialize complete。");

        app.close();
    }
}
