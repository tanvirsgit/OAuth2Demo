package com.welldev.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.*;

@Configuration
@EnableAuthorizationServer
@PropertySource("application.properties")
public class CustomAuthServer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager manager;

    @Value("${jwt.key}")
    private String key;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsService service = new InMemoryClientDetailsService();
        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId("client1");
        clientDetails.setClientSecret("secret1");
        clientDetails.setScope(Arrays.asList("read"));
        clientDetails.setAuthorizedGrantTypes(Arrays.asList("password","refresh_token")); //For password grant type
        //clientDetails.setAuthorizedGrantTypes(Arrays.asList("authorization_code")); //only for code grant type
        //clientDetails.setRegisteredRedirectUri(Collections.singleton("http://localhost:8080/OAuth2Demo"));//only for code grant type
        clientDetails.setAccessTokenValiditySeconds(100);
        service.setClientDetailsStore(Collections.singletonMap("client1",clientDetails));
        clients.withClientDetails(service);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(manager)
                .tokenStore(tokenStore())
                .accessTokenConverter(converter()); //generates JTI(unique per JWT) usage: optional
    }

    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(converter());
    }

    @Bean
    public JwtAccessTokenConverter converter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(key);
        return converter;
    }
}
