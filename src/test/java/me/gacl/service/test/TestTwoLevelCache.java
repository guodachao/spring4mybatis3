package me.gacl.service.test;

import me.gacl.domain.User;
import me.gacl.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @Author: Chao Guo
 * @Date: 2018-12-03 1:20 PM
 */
public class TestTwoLevelCache { /*
 * 测试二级缓存
 * 使用两个不同的SqlSession对象去执行相同查询条件的查询，第二次查询时不会再发送SQL语句，而是直接从缓存中取出数据
 */
    @Test
    public void testCache2() {
        String statement = "me.gacl.dao.UserMapper.getUser";
        SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
        //开启两个不同的SqlSession
        SqlSession session1 = factory.openSession();
        SqlSession session2 = factory.openSession();
        //使用二级缓存时，User类必须实现一个Serializable接口===> User implements Serializable
        User user1 = session1.selectOne(statement, 1);
        session1.commit();//不懂为啥，这个地方一定要提交事务之后二级缓存才会起作用
        System.out.println("user1=" + user1);

        //由于使用的是两个不同的SqlSession对象，所以即使查询条件相同，一级缓存也不会开启使用
        User user2 = session2.selectOne(statement, 1);
        //session2.commit();
        System.out.println("user2=" + user2);

        System.out.println(user1.equals(user2));
    }
}
