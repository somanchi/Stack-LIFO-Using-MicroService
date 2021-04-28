package sp.sample.simpleCurd.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import sp.sample.simpleCurd.dao.Credentials;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="config", ignoreUnknownFields = false)
@Slf4j
public class DataSourceConfiguration {

    private Credentials credentials;

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    @Bean
    @ConditionalOnProperty(name="store.databaseName", havingValue="mysql",matchIfMissing = true)
    public DataSource mySQLDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        printCredentials(credentials);
        dataSource.setUrl(credentials.url);
        dataSource.setUsername(credentials.username);
        dataSource.setPassword(credentials.password);
        return dataSource;
    }

    private void printCredentials(Credentials credentials) {
        log.info("========================================");
        log.info("DB url: " + credentials.url);
        log.info("DB username: " + credentials.username);
        log.info("DB password: " + credentials.password);
        log.info("========================================");
    }

    @Bean
    @ConditionalOnProperty(name="store.databaseName", havingValue="postgresSQL")
    public DataSource postgresSQLDataSource() {
        printCredentials(credentials);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(credentials.url);
        dataSource.setUsername(credentials.username);
        dataSource.setPassword(credentials.password);
        return dataSource;
    }
}
