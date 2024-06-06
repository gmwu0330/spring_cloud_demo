package demo.admin.common.utils;

import demo.admin.auth.bo.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Component
public class JwtUtils {

    private static String ISS;
    private static String SECRET;

    @Value("${jwt.demo.iss}")
    public void setISS(String ISS){
        JwtUtils.ISS = ISS;
    }

    @Value("${jwt.demo.secret}")
    public void setSECRET(String SECRET){
        JwtUtils.SECRET = SECRET;
    }

    public static String generateToken(LoginUser loginUser) {
        Calendar exp = Calendar.getInstance();
        exp.add(Calendar.DATE, 1);

        Claims claims = Jwts.claims();
        claims.setIssuer(ISS);
        claims.setIssuedAt(new Date());
        claims.setSubject(loginUser.getUsername());
        claims.setExpiration(exp.getTime());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public static String parseUsername(String token){
        Key secretKey = Keys.hmacShaKeyFor(SECRET.getBytes());

        JwtParser parser = Jwts.parserBuilder()
                .setSigningKey(secretKey).build();

        Claims claims = parser.parseClaimsJws(token).getBody();

        return claims.getSubject();
    }


    public static Key getKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

}
