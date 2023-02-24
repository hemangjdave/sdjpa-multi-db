package guruspringframework.sdjpamultidb.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created By Hemang Dave
 * Date: 24/02/23
 * Time: 5:27 pm
 */
@Configuration
public class CardDatabaseConfiguration {
    @Bean
    @ConfigurationProperties("spring.card.datasource")
    public DataSourceProperties cardHolderProperties() {
        return new DataSourceProperties();
    }
}
