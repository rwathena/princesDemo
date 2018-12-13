import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author:     prince.
 * @ Date：      Created in 4:09 PM 10/15/2018
 * @ Description:
 * @ Version:     1.0
 */
@SpringBootApplication
@ComponentScan("com.rwathena.*")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ImportResource("classpath:/spring/spring-dubbo-customer.xml")
public class PrinceStartCrtlApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PrinceStartCrtlApplication.class, args);
    }
}