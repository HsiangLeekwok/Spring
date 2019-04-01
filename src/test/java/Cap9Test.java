import com.enjoy.cap9.config.Cap9MainConfig;
import com.enjoy.cap9.dao.TestDao;
import com.enjoy.cap9.service.TestService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: Hsiang Leekwok
 * Date: 2019/03/30 08:45
 * Version: v1.0
 * Description:
 */

public class Cap9Test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9MainConfig.class);
//        String[] names = app.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

        TestService testService = app.getBean(TestService.class);
        testService.println();

        // 直接从容器中取得的TestDao和利用Autowired注解来取得的bean进行比较
        TestDao testDao = app.getBean(TestDao.class);
        System.out.println(testDao);

        app.close();
    }
}
