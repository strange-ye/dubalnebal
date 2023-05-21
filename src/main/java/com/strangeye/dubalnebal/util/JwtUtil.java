package com.strangeye.dubalnebal.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {
	private static final String SALT = "SSAFITKEYISNOTENOUGHTSOITSHOUWBELONGERTHANNOW";

	//  토큰 생성
	public String createToken(String claimId, String data) throws UnsupportedEncodingException {
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")
				.claim(claimId, data)
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15))
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8"))
				.compact();
	}

	// 유효성 검사
	public void valid(String token) throws UnsupportedEncodingException {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}

	public Claims decodeToken(String token) throws UnsupportedEncodingException {
		Claims claims = Jwts.parser()
				.setSigningKey(SALT.getBytes("UTF-8"))
				.parseClaimsJws(token)
				.getBody();
		return claims;
	}
}
