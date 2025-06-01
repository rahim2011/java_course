package az.developia.book_project.util;


import java.security.Key;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

	
	public String generateToken(String username,String firstName,String lastName,String email,List<String> authorities) {
		Map<String, String> claims=new HashMap<String, String>();
		claims.put("firstName", firstName);
		claims.put("lastName", lastName);
		claims.put("email", email);

		String authorityString = String.join(",", authorities);
		claims.put("authorities", authorityString);
		
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

	public Map<String, Object> extractClaims(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(signingKey)
				.build()
				.parseClaimsJws(token)
				.getBody();

		Map<String, Object> claimMap1=new HashMap<>();
		claimMap1.put("firstName", claims.get("firstName").toString());
		claimMap1.put("lastName", claims.get("lastName").toString());
		claimMap1.put("email", claims.get("email").toString());

		String authorities = (String) claims.get("authorities");
		if (authorities != null && !authorities.isEmpty()) {
			claimMap1.put("authorities", Arrays.asList(authorities.split(",")));
		}else {
			claimMap1.put("authorities", new String[] {});
		}
		
		return claimMap1;
	}
	
}
