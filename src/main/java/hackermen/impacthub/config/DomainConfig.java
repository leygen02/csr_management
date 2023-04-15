package hackermen.impacthub.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("hackermen.impacthub.domain")
@EnableJpaRepositories("hackermen.impacthub.repos")
@EnableTransactionManagement
public class DomainConfig {
}
