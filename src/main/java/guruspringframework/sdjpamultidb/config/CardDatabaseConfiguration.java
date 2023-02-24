package guruspringframework.sdjpamultidb.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
}
