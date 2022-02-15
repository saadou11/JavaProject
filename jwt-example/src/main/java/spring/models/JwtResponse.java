package spring.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtResponse {
    public String user;
    public String token;
    public int status;
    public String message;
}
