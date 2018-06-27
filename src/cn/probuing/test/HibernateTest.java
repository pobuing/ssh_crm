package cn.probuing.test;

import cn.probuing.dao.UserDao;
import cn.probuing.domain.User;
import cn.probuing.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Auther: wxblack-mac
 * @Date: 2018/6/14 17:53
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {


    @Resource(name = "sessionFactory")
    private SessionFactory sf;
    /**
     * 测试Dao Hibernate模板
     */
    @Resource(name = "userDao")
    private UserDao ud;
    @Resource(name = "userService")
    private UserService us;

    @Test
    public void fun1() {
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //-----option data
        User user = new User();
        user.setUser_code("tom");
        user.setUser_name("汤姆");
        user.setUser_password("1234");
        session.save(user);
        tx.commit();
        session.close();
        sf.close();
    }

    @Test
    public void fun2() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        //-----option data
        User user = new User();
        user.setUser_code("tom4");
        user.setUser_name("汤姆4");
        user.setUser_password("41234");
        session.save(user);
        tx.commit();
        session.close();
        sf.close();
    }

    @Test
    public void fun3() {
        User wx = ud.getByUserCode("wx");
        System.out.println(wx.toString());
    }

    /**
     * 测试事务
     */
    @Test
    public void fun4() {
        User user = new User();
        user.setUser_code("comeonhello");
        user.setUser_name("jacklilei");
        user.setUser_password("9087654");
        us.saveUser(user);
    }
}
