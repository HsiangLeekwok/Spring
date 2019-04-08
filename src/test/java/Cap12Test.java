import com.enjoy.cap12.config.Cap12MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/08 19:29<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
public class Cap12Test {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(Cap12MainConfig.class);
        app.close();
    }
}
