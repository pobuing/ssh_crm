package cn.probuing.test;

import cn.probuing.domain.User;
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
        user.setUser_code("tom3");
        user.setUser_name("汤姆3");
        user.setUser_password("31234");
        session.save(user);
        tx.commit();
        session.close();
        sf.close();
    }

}
