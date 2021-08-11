/*
package com.welldev.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
@ComponentScan
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .oauth2Login();
    }

    //Github as auth and resource server
    private ClientRegistration clientRegistration(){
        ClientRegistration clientRegistration = CommonOAuth2Provider.GITHUB
                .getBuilder("github")
                .clientId("bdas316e622294014cd2")
                .clientSecret("9030e4f2cb43ab58c9c98dfad21b8e5b21gj5001")
                .build();

        return clientRegistration;
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(fbClientRegistration());
    }

    */
/*private ClientRegistration clientRegistration(){
        ClientRegistration clientRegistration =
                ClientRegistration.withRegistrationId("github")
                .clientId("bd2a616e622294014cd2")
                .clientSecret("9030e4f2cb43ab58c9c98dfad21b8e5b2150b001")
                .scope(new String[]{"Dipro"})
                .authorizationUri("https://github.com/login/oauth/authorize")
                .tokenUri("https://github.com/login/oauth/access_token")
                .userInfoUri("https://api.github.com/user")
                .userNameAttributeName("id")
                .clientName("Github")
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
                .build();
        return clientRegistration;
    }*//*


    //Facebook as auth and resource server
    private ClientRegistration fbClientRegistration(){
        ClientRegistration clientRegistration = CommonOAuth2Provider.FACEBOOK
                .getBuilder("fb")
                .clientId("640098ajt586796")
                .clientSecret("1cajfi4979d5cab7d49f5aae3ad404be0f")
                .build();

        return clientRegistration;
    }
}
*/
