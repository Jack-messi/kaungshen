import com.kuang.dao.UserDaoMySqlImpl;
import com.kuang.dao.UserDaoOracleImpl;
import com.kuang.service.UserService;
import com.kuang.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test()
    {
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.setUserDao(new UserDaoMySqlImpl());
//        userService.getUser();
//
//        userService.setUserDao(new UserDaoOracleImpl());
//        userService.getUser();


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserServiceImpl serviceimpl = (UserServiceImpl) context.getBean("ServiceImpl");

        serviceimpl.getUser();

    }
}
