package spring.controllers;

import com.amazonaws.services.dynamodbv2.document.Item;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.models.JwtResponse;
import spring.models.UserCredentials;
import spring.security.IsSecurityEnabledCondition;
import spring.security.JwtTokenProvider;
import spring.services.AwsConnectService;

import javax.validation.Valid;

@RestController
@Conditional(IsSecurityEnabledCondition.class)
public class AuthenticationController {

    private final JwtTokenProvider tokenProvider;

    @Autowired
    private AwsConnectService awsConnectService;

    public AuthenticationController(JwtTokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder bcrypt = null;
        if (bcrypt == null)
            bcrypt = new BCryptPasswordEncoder();
        return bcrypt;
    }

    @PostMapping("authenticate")
    public JwtResponse createAuthenticationToken(@Valid @RequestBody UserCredentials credentials) {
        JwtResponse response = new JwtResponse();
        response.setUser(credentials.login);
        if (isAuthenticate(credentials.userID, credentials.login, credentials.password)) {
            response.setToken(tokenProvider.getJwtTokenAsString(credentials.login));
            response.setStatus(HttpStatus.SC_OK);
        } else {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
        }
        return response;
    }

    /**
     *
     * @param userID primary key of dynamoDB table
     * @param username username
     * @param password bcrypt encoded password
     * @return whether username and password exists for userID and account is enabled
     */
    private boolean isAuthenticate(Integer userID, String username, String password) {
        Item currentUser = awsConnectService.getUserDetails(userID);
        return currentUser.getString("username").equals(username)
                && passwordEncoder().matches(password, currentUser.getString("password"))
                && currentUser.getBOOL("is_enabled");
    }
}
