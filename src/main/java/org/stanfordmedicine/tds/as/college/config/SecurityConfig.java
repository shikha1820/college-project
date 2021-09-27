package org.stanfordmedicine.tds.as.college.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.stanfordmedicine.tds.as.foundation.FoundationException;
import org.stanfordmedicine.tds.as.foundation.web.security.HttpSecurityConfigurer;
import org.stanfordmedicine.tds.as.foundation.web.security.SecurityChainOrder;

@Configuration
public class SecurityConfig {
  private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

  @Bean
  @Order(SecurityChainOrder.APPLICATION_SECURITY_CONFIG)
  public HttpSecurityConfigurer appSecurityConfigurer() {
    return new HttpSecurityConfigurer() {

      @Override
      public void configureHttpSecurity(HttpSecurity http) throws FoundationException {
        logger.info("Configuring application level security");
        try {
          http.authorizeRequests().antMatchers("/api/v1/hello").permitAll()
              .antMatchers("/api/v1/helloFriend").authenticated();
        } catch (Exception e) {
          throw new FoundationException(
              "Unhandled exception while configuring HTTP security, " + e.getMessage(), e);
        }
      }
    };
  }

  @Bean
  public UserDetailsService userDetailsService() {
    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    manager.createUser(
        User.builder().username("user").password("{noop}password").roles("USER").build());
    manager.createUser(
        User.builder().username("admin").password("{noop}password").roles("ADMIN").build());
    return manager;
  }
}
