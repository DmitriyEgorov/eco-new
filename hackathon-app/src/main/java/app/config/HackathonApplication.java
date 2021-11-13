package app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * boot configuration
 *
 * @author Dmitriy
 * @since 29.05.2019
 */
@SpringBootApplication
@ComponentScan(basePackages = "hackathon")
@EnableWebMvc
@EnableJpaRepositories(basePackages = {"hackathon.db.repository"})
@EntityScan(basePackages = {"hackathon.db.model"})
@PropertySource("classpath:hackathon.properties")
public class HackathonApplication {

    private final Environment environment;

    public HackathonApplication (Environment environment) {
        this.environment = environment;
    }

    public static void main(String[] args) {
        SpringApplication.run(HackathonApplication.class, args);
    }



}
