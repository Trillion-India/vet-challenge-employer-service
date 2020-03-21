package com.trillion.vcemployerservice.configuration;

import java.sql.SQLException;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.trillion.vcemployerservice.repository"}, 
entityManagerFactoryRef = "vetChallengeEntityManager", 
transactionManagerRef = "vetChallengeTransactionManager")
public class VetChallengeDatasource {

	
	@Autowired
	private Environment env;

	@Bean(name = "vetChallengeDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dpDataSource() {
		
        if (env.containsProperty("spring.datasource.jndi-name")) {

            String jndiName = env.getProperty("spring.datasource.jndi-name");
            JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();

            return jndiDataSourceLookup.getDataSource(jndiName);
        } else {
            return DataSourceBuilder.create().build();
        }
	}
	
	@PersistenceContext(unitName = "vetChallengePersistance") 
	@Bean(name = "vetChallengeEntityManager")
	@Primary
	public LocalContainerEntityManagerFactoryBean dpEntityManager(EntityManagerFactoryBuilder builder) throws SQLException {


		return builder.dataSource(dpDataSource())
				.persistenceUnit("vetChallengePersistance")
				.packages("com.trillion.vcemployerservice..domain")
				.build();  

	}
	
	@Bean(name = "vetChallengeTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) throws SQLException {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(dpEntityManager(builder).getObject());
		jpaTransactionManager.setDataSource(dpDataSource());
		return jpaTransactionManager;
	}
}
