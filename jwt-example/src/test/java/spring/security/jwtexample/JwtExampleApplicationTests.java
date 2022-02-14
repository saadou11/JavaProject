package spring.security.jwtexample;

import com.amazonaws.services.dynamodbv2.document.Item;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import org.apache.hadoop.io.MD5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.security.JwtTokenProvider;
import spring.services.AwsConnectService;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JwtExampleApplicationTests {

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    AwsConnectService awsConnectService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder bcrypt = null;
        if (bcrypt == null)
            bcrypt = new BCryptPasswordEncoder();
        return bcrypt;
    }

    @Test
    void contextLoads() {}

    @Test
    void checkPasswordEncoder() {
        Item item = awsConnectService.getUserDetails(0);
        String password = passwordEncoder().encode(item.getString("password"));
        assertThat(passwordEncoder().matches("toto", password));
    }

    @Test
    void generateTokenBuilder() {
        JwtBuilder token = tokenProvider.generateJwtBuilder("username");
        Claims claims = tokenProvider.getAllClaimsFromToken(token.compact());

        for(Map.Entry entry : claims.entrySet())
            System.out.println(entry.getKey() +" ==> "+entry.getValue());
    }

    @Test
    void generateAndValidateToken() {
        String token = tokenProvider.getJwtTokenAsString("username");
        assertThat(tokenProvider.tokenHasExpired(token)).isEqualTo(false);
    }

}
