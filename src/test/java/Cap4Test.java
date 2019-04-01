import com.enjoy.cap4.config.Cap4MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:45
 * Version: v1.0
 * Description:
 */
public class Cap4Test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap4MainConfig.class);
        System.out.println("IOC容器创建完成.....");
        System.out.println("开始加载bean.....");
        Object bean1 = app.getBean("person");// 执行获取的时候才创建bean
        Object bean2 = app.getBean("person");
        System.out.println(bean1 == bean2);
    }
}
