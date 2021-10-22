
import com.kuang.dao.UserMapper;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void test()
    {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession.getMapper(UserMapper.class);

//        User user = mapper.queryUserById(1);
//        System.out.println(user);

//        mapper.updateUser( new User(2,"aaaa","bbb"));
//
//        System.out.println("===========");
//        User user2 = mapper.queryUserById(2);
//        System.out.println(user2);
//
//        System.out.println(user == user2);

        sqlSession.close();
    }

}
