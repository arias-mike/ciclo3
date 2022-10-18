
package co.usa.tools.adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mike
 */
@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    String[] resources = new String[]{
        "/dist/**","/plugins/**", "/error", "/webjars/**", "/api/**","/pages/login/forgot-password.html","/pages/login/register.html",
        "/pages/login/recover-password.html","/pages/login/login.html","/login/**"
    };
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .authorizeRequests(a -> a
                .antMatchers(resources).permitAll()
                //.antMatchers("/","/index").permitAll()
                .anyRequest().authenticated()
            )
            .logout(l -> l
                .logoutSuccessUrl("/login").permitAll()
            )
            .csrf(c -> c
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
            )
            .exceptionHandling(e -> e
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            )
            .oauth2Login();

        http.cors().and().csrf().disable();
    }
}