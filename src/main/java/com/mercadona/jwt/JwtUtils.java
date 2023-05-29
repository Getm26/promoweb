package com.mercadona.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mercadona.promoweb.user.User;

@Component
public class JwtUtils {

    long JWT_VALIDITY = 5 * 60 * 60;
    
    private static final String AUTHORITIES_KEY = "auth";
    
    private Key key;

    private finale JwtParser jwtParser = Jwts.parserBuilder()
        .setSigningKey(key)
        .build();

        public JwtUtils(@Value("${jwt.secret}") String secret) {
            this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
            this.jwtParser = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        }   

        public String generateToken(UserDetails userDetails) {
            return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim(AUTHORITIES_KEY, userDetails.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_VALIDITY * 1000))
                .signWith(key)
                .compact();
        }

        public Authentification getAuthentication(String token) {
            Claims claims = jwtParser.parseClaimsJws(token).getBody();
            Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
            User principal = new User(claims.getSubject(), "", authorities);
            return new UsernamePasswordAuthenticationToken(principal, token, authorities);
        

        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
        }
    
}
