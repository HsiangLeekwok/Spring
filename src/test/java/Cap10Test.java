import com.enjoy.cap10.aop.Calculator;
import com.enjoy.cap10.config.Cap10MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:45
 * Version: v1.0
 * Description:
 */

public class Cap10Test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap10MainConfig.class);
//        String[] names = app.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

        Calculator calculator = (Calculator) app.getBean("calculator");
        int result = calculator.div(10, 2);
        System.out.println("Calculator.div() result: " + result);
        app.close();
    }
}
