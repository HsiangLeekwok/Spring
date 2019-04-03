import com.enjoy.cap11.config.Cap11MainConfig;
import com.enjoy.cap11.service.OrderService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:45
 * Version: v1.0
 * Description:
 */

public class Cap11Test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap11MainConfig.class);

        OrderService orderService = (OrderService) app.getBean("orderService");
        orderService.addOrder();

        app.close();
    }
}
