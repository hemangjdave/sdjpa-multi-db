package guruspringframework.sdjpamultidb.config;

import com.zaxxer.hikari.HikariDataSource;
import guruspringframework.sdjpamultidb.domain.creditcard.CreditCard;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import static java.util.Objects.requireNonNull;

/**
 * Created By Hemang Dave
 * Date: 24/02/23
 * Time: 5:27 pm
 */
@Configuration
public class CardDatabaseConfiguration {
    @Bean
    @ConfigurationProperties("spring.card.datasource")
    public DataSourceProperties cardProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource cardDataSource(@Qualifier("cardProperties") DataSourceProperties cardProperties) {
        return cardProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean cardEntityManagerFactory(
            @Qualifier("cardDataSource") DataSource dataSource,
            EntityManagerFactoryBuilder factoryBuilder
    ) {
        return factoryBuilder.dataSource(dataSource)
                .packages(CreditCard.class)
                .persistenceUnit("card")
                .build();
    }

    @Bean
    public PlatformTransactionManager cardTransactionManager(
            @Qualifier("cardEntityManagerFactory") LocalContainerEntityManagerFactoryBean cardEntityManagerFactory
    ) {
        return new JpaTransactionManager(requireNonNull(cardEntityManagerFactory.getObject()));
    }
}
