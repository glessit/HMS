package com.handmakestore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class HMSApplicationLauncher {

    @Configuration
    @EnableJpaRepositories(basePackages = {"com.handmakestore.service.repository"})
    public static class HMSApplicationContext {

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

    @Configuration
    public static class HSMProductionSecurityContext extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .oauth2Login();
        }
    }

	public static void main(String[] args) {
		SpringApplication.run(HMSApplicationLauncher.class, args);
	}
}
