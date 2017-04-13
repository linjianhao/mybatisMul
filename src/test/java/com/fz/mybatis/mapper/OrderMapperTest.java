package com.fz.mybatis.mapper;

import com.fz.mybatis.domain.OrderDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.apache.ibatis.io.Resources;
import java.io.InputStream;
import java.util.List;

//（断言）变灰色的话表示导的包没用上
import static org.junit.Assert.*;
/*断言表示为一些布尔表达式，程序员相信在程序中的某个特定点该表达式值为真，可以在任何时候启用和禁用断言验证，因此可以在测试时启用断言而在部署时禁用断言。
同样，程序投入运行后，最终用户在遇到问题时可以重新启用断言。使用断言可以创建更稳定、品质更好且 不易于出错的
代码。当需要在一个值为FALSE时中断当前操作的话，可以使用断言。单元测试必须使用断言(Junit/JunitX)。*/
/**
 * Created by Administrator on 2017/4/12.
 */
@Slf4j
public class OrderMapperTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession(true);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void testQueryOrder() throws Exception {
        OrderMapper mapper = session.getMapper(OrderMapper.class);

        List<OrderDo> ls = mapper.queryOrder();

        log.info("ls :{}", ls);

    }
}