package az.developia.book_project.util;


import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private final Key signingKey;

	public JwtUtil(@Value("${jwt.secret}") String secretKey) {
		byte[] decode = Base64.getDecoder().decode(secretKey);
		this.signingKey = Keys.hmacShaKeyFor(decode);
		System.out.println(decode.length);
	}

	public String generateToken(String username) {
	public String generateToken(String username,String firstName,String lastName,String email) {
		Map<String, String> claims=new HashMap<String, String>();
		claims.put("firstName", firstName);
		claims.put("lastName", lastName);
		claims.put("email", email);
		
		return Jwts.builder()
				.setClaims(claims)
		.setSubject(username)
		.setIssuedAt(new Date())
		.setExpiration(new Date(System.currentTimeMillis() + 86400000)) //1 gun
		.signWith(signingKey)
		.compact();
	}

	public String extractUsername(String token) {
		Claims claims = Jwts.parserBuilder()
		.setSigningKey(signingKey)
		.build()
		.parseClaimsJws(token)
		.getBody();

		return claims.getSubject();
	}
	
	public Map<String, String> extractClaims(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(signingKey)
				.build()
				.parseClaimsJws(token)
				.getBody();
		
		Map<String, String> claimMap=new HashMap<String, String>();
		claimMap.put("firstName", claims.get("firstName").toString());
		claimMap.put("lastName", claims.get("lastName").toString());
		claimMap.put("email", claims.get("email").toString());
		
		return claimMap;
	}
}
