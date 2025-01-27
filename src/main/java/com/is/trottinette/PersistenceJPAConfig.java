package com.is.trottinette;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.is.trottinette.persistence") 
public class PersistenceJPAConfig {

}
