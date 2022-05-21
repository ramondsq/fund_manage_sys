package com.qurui.fund_manage_sys.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class JWTUtils {
    public static String createToken(String subject){
        try {
            Algorithm algorithm = Algorithm.HMAC256("qr99915");
            String token = JWT.create()
                    .withIssuedAt(new Date())
                    .withSubject(subject)
                    .withIssuer("fms")
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            System.out.println("无法创建token");
            return "";
        }
    }

    public static String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256("qr99915"); //use more secure key
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("fms")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getToken();
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            System.out.println("无法验证token");
            return null;
        }
    }


}
