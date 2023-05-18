package com.strangeye.dubalnebal.util;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
	private static final String SALT = "";

	//토큰 생성
//	public String createToken() {
//			return Jwts.builder()
//					.setHeaderParam("alg", "HS256")
//					.setHeaderParam("typ", "JWT") //헤더 완료
//	}

	//유효성 검사
}
