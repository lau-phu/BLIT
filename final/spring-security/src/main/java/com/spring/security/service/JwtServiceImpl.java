/*
 * package com.spring.security.service;
 * 
 * 
 * import java.util.Date; import java.util.HashMap; import java.util.Map; import
 * java.util.function.Function;
 * 
 * import javax.crypto.SecretKey;
 * 
 * import org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.stereotype.Component;
 * 
 * import io.jsonwebtoken.Claims; import io.jsonwebtoken.Jwts; import
 * io.jsonwebtoken.SignatureAlgorithm; import io.jsonwebtoken.security.Keys;
 * 
 * @Component public class JwtServiceImpl {
 * 
 * private final SecretKey SECRET_KEY =
 * Keys.secretKeyFor(SignatureAlgorithm.HS256);
 * 
 * 
 * public String extractUserName(String token){ return extractClaim(token,
 * Claims::getSubject); }
 * 
 * public Date extractExpiration(String token){ return extractClaim(token,
 * Claims::getExpiration); } public String generateToken(UserDetails
 * userDetails) { Map<String, Object> claims = new HashMap<>(); String token =
 * Jwts.builder() .setClaims(claims) .setSubject(userDetails.getUsername())
 * .setIssuedAt(new Date(System.currentTimeMillis())) .setExpiration(new
 * Date(System.currentTimeMillis()+ 1000*60*60*10)) .signWith(SECRET_KEY)
 * .compact(); return token; }
 * 
 * public Boolean validateToken( String token, UserDetails userDetails){ final
 * String userName = extractUserName(token); return
 * (userName.equals(userDetails.getUsername())) && !isTokenExpired(token); }
 * 
 * private Boolean isTokenExpired(String token) { return
 * extractExpiration(token).before(new Date()); }
 * 
 * private <T>T extractClaim(String token, Function<Claims, T> claimsTFunction){
 * final Claims
 * claims=Jwts.parser().setSigningKey(SECRET_KEY).build().parseClaimsJws(token).
 * getBody(); return claimsTFunction.apply(claims); }
 * 
 * }
 */