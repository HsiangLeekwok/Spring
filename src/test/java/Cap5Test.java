import com.enjoy.cap5.config.Cap5MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:45
 * Version: v1.0
 * Description:
 */
public class Cap5Test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap5MainConfig.class);
        String[] names = app.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
