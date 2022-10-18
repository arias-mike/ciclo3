package co.usa.tools.adapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
/**
 *
 * @author Mike
 */
@Configuration
@EnableGlobalMethodSecurity(
    prePostEnabled=true
)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    
}
