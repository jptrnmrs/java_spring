package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Component
public class JwtProvider {
    private String issuer;
    private SecretKey secretKey;

    public JwtProvider(@Value("${jwt.issuer}") String issuer,
                       @Value("${jwt.secret}") String secretKey) {
        this.issuer = issuer;
        this.secretKey = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String createToken(User user, int days) {

        // 발급일, 만료일 생성
        Date issuedDate = new Date();
        Date expireDate = new Date(issuedDate.getTime()+ Duration.ofDays(days).toMillis());

        // 토큰 생성
        String token = Jwts.builder()
                .issuer(issuer)
                .issuedAt(issuedDate)
                .expiration(expireDate)
                .claim("username", user.getUsername())
                .claim("role", user.getRole())
                .signWith(this.secretKey, Jwts.SIG.HS256)
                .compact();

        return token;
    }

    // 토큰으로부터 클레임 값 추출
    public Claims getClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(this.secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Authentication getAuthentication(String token) {

        // 토큰으로부터 사용자 정보 가져오기
        Claims claims = getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        // User Entity 생성
        User user = User.builder()
                .username(username)
                .role(role)
                .build();

        // 사용자 권한 목록
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));

        return new UsernamePasswordAuthenticationToken(user, token, authorities);
    }

    public void validateToken(String token) throws Exception {
        try {
            Jwts.parser()
                    .setSigningKey(this.secretKey)
                    .build()
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            throw new JwtException("Token is expired", e);
        } catch (UnsupportedJwtException e) {
            throw new JwtException("Unsupported JWT token", e);
        } catch (MalformedJwtException e) {
            throw new JwtException("Malformed JWT token", e);
        } catch (SignatureException e) {
            throw new JwtException("Invalid JWT signature", e);
        } catch (IllegalArgumentException e) {
            throw new JwtException("JWT token is missing or invalid", e);
        }
    }
}
