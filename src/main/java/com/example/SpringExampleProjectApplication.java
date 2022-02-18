package com.example;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;



@MapperScan(basePackages = "com.example.*")  // mapper scan 추가!!!
// @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //DB에러 DB를 사용하지 않겠다. DB를 찾지 않겠다
@SpringBootApplication
public class SpringExampleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleProjectApplication.class, args);
	}
	
	@Bean //객체
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml"); //db xml경로
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }

}
