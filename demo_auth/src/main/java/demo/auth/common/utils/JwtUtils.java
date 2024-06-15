package demo.auth.common.utils;

import demo.auth.common.login.bo.LoginUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {

    private static String ISS;
    private static String SECRET;

    @Value("${jwt.demo.iss}")
    public void setISS(String ISS) {
        JwtUtils.ISS = ISS;
    }

    @Value("${jwt.demo.secret}")
    public void setSECRET(String SECRET) {
        JwtUtils.SECRET = SECRET;
    }

//    public static String generateToken(LoginUser loginUser) {
//        Calendar exp = Calendar.getInstance();
//        exp.add(Calendar.DATE, 1);
//
//        Claims claims = Jwts.claims();
//        claims.setIssuer(ISS);
//        claims.setIssuedAt(new Date());
//        claims.setSubject(loginUser.getUsername());
//        claims.setExpiration(exp.getTime());
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .signWith(getKey(), SignatureAlgorithm.HS256)
//                .compact();
//    }

    public static String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private static Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }


    private static String createToken(Map<String, Object> claims, String username) {
        Calendar exp = Calendar.getInstance();
        exp.add(Calendar.DATE, 1);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(exp.getTime())
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private static Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

}
