package guruspringframework.sdjpamultidb.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created By Hemang Dave
 * Date: 24/02/23
 * Time: 5:28 pm
 */
@Configuration
public class PanDatabaseConfiguration {

    @Bean
    @ConfigurationProperties("spring.pan.datasource")
    @Primary
    public DataSourceProperties panProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource panDataSource(@Qualifier("panProperties") DataSourceProperties panProperties) {
        return panProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }
}
