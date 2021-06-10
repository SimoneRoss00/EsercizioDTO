package it.objectmethod.ecommercedto.service;

import java.util.Calendar;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import it.objectmethod.ecommercedto.service.dto.UserDTO;

@Component
public class JWTService {

	Logger log = LoggerFactory.logger(JWTService.class);

	private static final String MY_SECRET_JWT_KEY = "Qd^8PgY@J0OkJu&TH";

	public String createJWTToken(UserDTO userDTO) {

		log.info("LOGIN EFETTUATO CON SUCCESSO!");

		Calendar cal = Calendar.getInstance();

		int seconds = cal.get(Calendar.SECOND) + 86400;
		if (seconds > 60) {
			seconds = seconds - 60;
			cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 1);
		}
		cal.set(Calendar.SECOND, seconds);

		Algorithm alg = Algorithm.HMAC256(MY_SECRET_JWT_KEY);
		String token = JWT.create().withClaim("user_id", userDTO.getId()).withClaim("user_name", userDTO.getUserName())
				.withExpiresAt(cal.getTime()).sign(alg);

		return token;
	}

	public boolean checkJWTToken(String jwtToken) {
		log.info(jwtToken);
		boolean valid = false;
		Algorithm alg = Algorithm.HMAC256(MY_SECRET_JWT_KEY);

		try {
			JWTVerifier ver = JWT.require(alg).build();
			DecodedJWT decoded = ver.verify(jwtToken);

			Long userId = decoded.getClaim("user_id").asLong();
			String userName = decoded.getClaim("user_name").asString();

			System.out.println("Utente verificato! " + userId + " - " + userName);
			valid = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info(valid);
		return valid;
	}

	public Long getUserIdByToken(String jwtToken) {
		Algorithm alg = Algorithm.HMAC256(MY_SECRET_JWT_KEY);
		Long userId = null;
		try {
			JWTVerifier ver = JWT.require(alg).build();
			DecodedJWT decoded = ver.verify(jwtToken);

			userId = decoded.getClaim("user_id").asLong();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

}
