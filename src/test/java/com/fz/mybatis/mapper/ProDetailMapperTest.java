package com.fz.mybatis.mapper;

import com.fz.mybatis.domain.ProDetailDo;
import com.fz.mybatis.domain.ProductDo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


/**
 * Created by Administrator on 2017/4/12.
 */
@Slf4j
public class ProDetailMapperTest {
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

    @Test
    public void testFindByIdProDet() throws Exception {
        ProDetailMapper mapper = session.getMapper(ProDetailMapper.class);

        ProDetailDo prod= mapper.findByIdProDet(1);

        log.info("prod :{} ", prod);

    }

    @Test
    public void testQueryProDetail() throws Exception {
        ProDetailMapper mapper = session.getMapper(ProDetailMapper.class);

        List<ProDetailDo> prod= mapper.queryProDetail();

        for (ProDetailDo prode : prod){
            ProductDo pro = prode.getProd();
            log.info("prodName : {}",pro.getProName());
        }

        log.info("prod :{} ", prod);
    }
}