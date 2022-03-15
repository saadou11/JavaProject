package spring.security.jwtexample;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.security.JwtTokenProvider;
import spring.services.AwsConnectService;

import java.util.Date;
import java.util.Map;

@SpringBootTest
class JwtExampleApplicationTests {

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    AwsConnectService awsConnectService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Test
    void contextLoads() {}

    @Test
    void checkPasswordEncoder() {
        String password = passwordEncoder().encode("PWD");
        Assert.isTrue(passwordEncoder().matches("PWD", password));
    }

    @Test
    void generateTokenBuilder() {
        JwtBuilder token = tokenProvider.generateJwtBuilder("username");
        Claims claims = tokenProvider
                .getAllClaimsFromToken(token.compact())
                .setExpiration(new Date(System.currentTimeMillis() + 6000));

        for(Map.Entry entry : claims.entrySet())
            System.out.println(entry.getKey() +" ==> "+entry.getValue());

        Assert.isTrue(tokenProvider.tokenHasExpired(token.compact()));
        Assert.isTrue(claims.getSubject().equals("username"));
    }

    @Test
    void generateAndValidateToken() {
        String token = tokenProvider.getJwtTokenAsString("username");
        Assert.isTrue(tokenProvider.tokenHasExpired(token));
    }

}
