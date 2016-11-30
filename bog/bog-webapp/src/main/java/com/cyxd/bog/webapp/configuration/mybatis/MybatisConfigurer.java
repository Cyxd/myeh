package com.cyxd.bog.webapp.configuration.mybatis;

import static com.cyxd.bog.webapp.configuration.Constant.MYBATIS_MAPPER_XML_CONFIGURER;
import static com.cyxd.bog.webapp.configuration.Constant.SCAN_PACKAGE_NAME_DAO;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
//@MapperScan(SCAN_PACKAGE_NAME_DAO)
// @EnableTransactionManagement
// @ComponentScan
// @EnableAutoConfiguration
public class MybatisConfigurer {

    /**
     * <p>dataSource<br>
     * Description:数据源
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @return
     * 
     * @see
     * @see
     *
     */
    @Bean
    public DataSource dataSource() {
	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	dataSource.setUsername("smt");
	dataSource.setPassword("smt");
	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://120.24.217.254:3306/smt_op");
//	dataSource.setMaxTotal(50);  
//        dataSource.setMinIdle(5);  
//        dataSource.setMaxIdle(10);  
	return dataSource;
	// or official configurations
	// return new EmbeddedDatabaseBuilder()
	// .addScript("schema.sql")
	// .build();
    }

    /**
     * <p>transactionManager<br>
     * Description:事务配置
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @param dataSource
     * @return PlatformTransactionManager
     * 
     * @see #PlatformTransactionManager
     * @see #DataSourceTransactionManager
     *
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
	return new DataSourceTransactionManager(dataSource());
    }

    /**
     * <p>sqlSessionFactory<br>
     * Description:配置sessionFactory
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @return
     * @throws Exception
     * 
     * @see #SqlSessionFactory
     * @see #SqlSessionFactoryBean
     *
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
	SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	sessionFactory.setDataSource(dataSource());
	sessionFactory.setConfigLocation(new ClassPathResource(MYBATIS_MAPPER_XML_CONFIGURER));
//	sessionFactory.setMapperLocations(new Resource[]{
//		new ClassPathResource(SCAN_PACKAGE_NAME_DAO_MAPPER)
//	});
//	sessionFactory.setTypeAliasesPackage(SCAN_PACKAGE_NAME_DAO);
	return sessionFactory.getObject();
    }

    /**
     * <p>mapperScannnerConfigurer<br>
     * Description:扫描Dao接口
     *
     * @author Slil
     * @version 1.0.0
     * @since 1.0.0
     * 
     * @return This property lets you set the base package for your mapper interface files.
     * 
     * @see
     * @see
     *
     */
    @Bean
    public MapperScannerConfigurer mapperScannnerConfigurer() {
	MapperScannerConfigurer msc = new MapperScannerConfigurer();
	msc.setSqlSessionFactoryBeanName("sqlSessionFactory");
	msc.setBasePackage(SCAN_PACKAGE_NAME_DAO);
	return msc;
    }

}
