package com.person.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** Configuration class for DB. */
@Configuration
@EnableJpaRepositories("com.person.repository")
@EntityScan("com.person.entity")
@EnableTransactionManagement
public class DBConfig {

//  private static final String HIBERNATE_FORMAT_SQL = "spring.jpa.format_sql";
//
//  @Autowired private Environment env;
//
//  /** @return dataSource */
//  @Bean(destroyMethod = "close")
//  public HikariDataSource dataSource() {
//    final HikariConfig dataSourceConfig = new HikariConfig();
//    dataSourceConfig.setDriverClassName(this.env.getRequiredProperty("spring.database.driverClassName"));
//    dataSourceConfig.setJdbcUrl(this.env.getRequiredProperty("spring.datasource.url"));
//    dataSourceConfig.setUsername(this.env.getRequiredProperty("spring.datasource.username"));
//    dataSourceConfig.setPassword(this.env.getRequiredProperty("spring.datasource.password"));
//
//    return new HikariDataSource(dataSourceConfig);
//  }
//
//  /** @return entityManagerFactory */
//  @Bean
//  public EntityManagerFactory entityManagerFactory() {
//    final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//    jpaVendorAdapter.setDatabasePlatform(this.env.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
//    jpaVendorAdapter.setShowSql(
//        Boolean.valueOf(this.env.getRequiredProperty("spring.jpa.show-sql")));
//    jpaVendorAdapter.setGenerateDdl(
//        Boolean.valueOf(this.env.getRequiredProperty("spring.jpa.hibernate.ddl-auto")));
//
//    final LocalContainerEntityManagerFactoryBean entityManagerFactory =
//        new LocalContainerEntityManagerFactoryBean();
//    entityManagerFactory.setDataSource(this.dataSource());
//    entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
//    entityManagerFactory.setJpaDialect(new HibernateJpaDialect());
//    entityManagerFactory.setPackagesToScan(
//        "com.person.entity");
//
//    final Properties jpaProperties = new Properties();
//    jpaProperties.put(HIBERNATE_FORMAT_SQL, this.env.getRequiredProperty(HIBERNATE_FORMAT_SQL));
//
//    entityManagerFactory.setJpaProperties(jpaProperties);
//    entityManagerFactory.afterPropertiesSet();
//
//    return entityManagerFactory.getObject();
//  }
//
//  /** @return transactionManager */
//  @Bean
//  public PlatformTransactionManager transactionManager() {
//    final JpaTransactionManager txManager = new JpaTransactionManager();
//    txManager.setEntityManagerFactory(this.entityManagerFactory());
//
//    return txManager;
//  }
}
