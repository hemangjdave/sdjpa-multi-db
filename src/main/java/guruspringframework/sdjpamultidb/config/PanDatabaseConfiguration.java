package guruspringframework.sdjpamultidb.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    public DataSourceProperties cardHolderProperties() {
        return new DataSourceProperties();
    }
}
