import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class testdemo {
    public static void main(String[] args) throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        DruidDataSource dataSource = (DruidDataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
