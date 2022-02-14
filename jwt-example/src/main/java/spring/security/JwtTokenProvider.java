package spring.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Conditional(IsSecurityEnabledCondition.class)
public class JwtTokenProvider {

    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";

    @Value("${am-data.fsociety.security.secret}")
    private String secretKey;

    @Value("${am-data.fsociety.security.token.duration}")
    private Long duration;

    /**
     * @param username
     * @return
     */
    public JwtBuilder generateJwtBuilder(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("fsocietyJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList())
                )
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes());

        if (duration > 0)
            jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + duration));

        return jwtBuilder;
    }

    /**
     * @param username string for which generate jwt token
     * @return jwt token
     */
    public String getJwtTokenAsString(String username) {
        return "Bearer " + generateJwtBuilder(username).compact();
    }

    /**
     * @param request HttpServletRequest to parse and validate token
     * @return is a valid token
     */
    public Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(jwtToken).getBody();
    }

    /**
     * @param request HttpRequest containing the jwt
     * @return whether request contains a jwt
     */
    public boolean checkJWTToken(HttpServletRequest request) {
        String authenticationHandler = request.getHeader(HEADER);
        return authenticationHandler != null && authenticationHandler.startsWith(PREFIX);
    }

    /**
     * @param token current jwt
     * @return whether token has expired or not
     */
    public Boolean tokenHasExpired(String token) {
        Claims claims = getAllClaimsFromToken(token);
        Date expiration = claims.getExpiration();
        return expiration.before(new Date());
    }

    /**
     * @param token current jwt
     * @return all claims from current jwt
     */
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token.replace(PREFIX, "")).getBody();
    }
}
