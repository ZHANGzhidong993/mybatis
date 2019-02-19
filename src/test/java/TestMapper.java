import com.study.mapper.UserMapper;
import com.study.pojo.User;
import com.study.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author zhangzhidong
 * @create: 2019-02-20 01:05
 */
public class TestMapper {

    static SqlSessionFactory sqlSessionFactory;

    static {
        sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    @Test
    public void testAdd() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User("tom", 5);
            userMapper.insertUser(user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void getUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(3);
            System.out.println("name: " + user.getName() + "|age: " + user.getAge());
        } finally {
            sqlSession.close();
        }
    }
}
