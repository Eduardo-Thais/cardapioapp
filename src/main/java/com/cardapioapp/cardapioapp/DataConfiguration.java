package com.cardapioapp.cardapioapp;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {


	@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(System.getenv("JDBC_DATABASE_URL"));
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //dataSource.setUrl("jdbc:mysql://localhost:3306/cardapiodb");
        //dataSource.setUsername("root");
        //dataSource.setPassword("");
        return dataSource;
    }
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		//adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		//adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		//adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}
	
}
