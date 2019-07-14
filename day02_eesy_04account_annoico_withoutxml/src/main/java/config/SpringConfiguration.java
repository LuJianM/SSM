package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * 该类是一个配置类，作用与bean.xml类似
 * @Configuration ： 指定当前类是一个配置类
 * @Companent ： 通过注解指定spring在创建容器时需要扫描的包
 *      属性：
 *          value：等价于basePackages,都是用于指定创建容器时需要扫描的包。使用此注解就等同于bean.xml中
 *              <context:component-scan base-package="com.ssm"></context:component-scan>
 *
 */


@Configuration
@ComponentScan(basePackages = "com.ssm")
public class SpringConfiguration {

    /**
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")
    @Scope(value = "prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     *数据源配置
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = null;
        try {
            ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8");
            ds.setUser("root");
            ds.setPassword("123456");
            return  ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
