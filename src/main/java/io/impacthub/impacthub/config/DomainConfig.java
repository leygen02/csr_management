package io.impacthub.impacthub.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("io.impacthub.impacthub.domain")
@EnableJpaRepositories("io.impacthub.impacthub.repos")
@EnableTransactionManagement
public class DomainConfig {
}
