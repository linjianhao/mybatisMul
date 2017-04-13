package com.fz.mybatis.mapper;

import com.fz.mybatis.domain.User;
import com.fz.mybatis.domain.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/12.
 */
@Slf4j
public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;


    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        session.close();

    }
    /**
     * 测试一级缓存
     * @throws Exception
     */
    @Test
    public void testFindUserById() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserDo user = mapper.findUserById(1);

        log.info("User{}",user);

        User u = new User();
        u.setId(12);
        u.setUserName("wangwu");
        u.setPassword("pppppppppppppppp");
        u.setAddress("中文");
        u.setUpdateBy("admin");

        mapper.updateById(u);

        UserDo user2 = mapper.findUserById(1);

        log.info("User2{}",user2);


    }
    @Test
    public void testCache() throws Exception {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);//创建代理对象
        //下边查询使用一个SqlSession
        //第一次发起请求，查询id为1的用户
        UserDo user1 = userMapper1.findUserById(1);
        System.out.println(user1.getUserName());
        //不关闭SqlSession无法写进二级缓存区域中
        sqlSession1.close();

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);//创建代理对象
        //第二次发起请求，查询id为1的用户
        UserDo user2 = userMapper2.findUserById(1);
        System.out.println(user2.getUserName());
        sqlSession2.close();
    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testDeleteById() throws Exception {

    }

    @Test
    public void testUpdateById() throws Exception {

    }

    @Test
    public void testUpdateBatchId() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> ls = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        user.setAddress("洛阳");
        user.setCellPhone("13387654321");
        ls.add(user);

        User user1 = new User();
        user1.setId(2);
        user1.setAddress("杭州");
        user1.setCellPhone("15812345678");
        ls.add(user1);


        mapper.updateBatchId(ls);

        session.commit();

    }

    @Test
    public void testQueryBatchId() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<User> ls = new ArrayList<User>();
        User user = new User();
        user.setId(1);
        ls.add(user);

        User user1 = new User();
        user1.setId(2);
        ls.add(user1);

        List<User> userLs = mapper.queryBatchId(ls);

        log.info("i={}", userLs.size());

    }

    @Test
    public void testQueryBatchIds() throws Exception {
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserDo user = new UserDo();
        List<String> ls = new ArrayList<String>();
        ls.add("1");
        ls.add("2");
        user.setIdds(ls);

        List<UserDo> userLs = mapper.queryBatchIds(user);

        log.info("i={}", userLs.size());

    }
}