
import com.enjoy.cap3.config.Cap3MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:45
 * Version: v1.0
 * Description:
 */
public class Cap3Test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap3MainConfig.class);
        String[] beanNames = app.getBeanDefinitionNames();
        for (String name : beanNames) {
            System.out.println(name);
        }

        Object bean1 = app.getBean("person");
        Object bean2 = app.getBean("person");
        System.out.println(bean1 == bean2);
    }
}
