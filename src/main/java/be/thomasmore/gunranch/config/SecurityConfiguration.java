package be.thomasmore.gunranch.config;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@EnableWebSecurity
    @Configuration
    public class SecurityConfiguration {

    @Autowired
    private DataSource dataSource;

    @Value("${security.h2-console-needed}")
    private boolean h2ConsoleNeeded;
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            HandlerMappingIntrospector introspector = new HandlerMappingIntrospector();
            MvcRequestMatcher.Builder mvcMatcherBuilder =
                    new MvcRequestMatcher.Builder(introspector);

            http.authorizeHttpRequests(auth -> auth
                    .requestMatchers(mvcMatcherBuilder.pattern("/admin/**")).hasAnyAuthority("ADMIN")
                    .anyRequest().permitAll());

            http.formLogin(Customizer.withDefaults());


            if (h2ConsoleNeeded){
                http.csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()));
                http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

            }

            return http.build();
        }

        @Bean
        public JdbcUserDetailsManager jdbcUserDetailsManager(){
            return new JdbcUserDetailsManager(dataSource);
        }

        @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
    }

