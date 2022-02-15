package spring.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Conditional(IsSecurityEnabledCondition.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //private final Boolean securityEnabled;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    public SecurityConfiguration(@Value("${am-data.fsociety.security.enabled}") Boolean securityEnabled,
                                 JWTAuthorizationFilter jwtAuthorizationFilter) {
        //this.securityEnabled = securityEnabled;
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    private static final String[] AUTH_WHITELIST = {
            "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
            "/configuration/security", "/swagger-ui.html", "/webjars/**",
            "/v3/api-docs/**", "/swagger-ui/**"
    };

    private static final String JWT_ENDPOINT = "/authenticate";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, JWT_ENDPOINT).permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
