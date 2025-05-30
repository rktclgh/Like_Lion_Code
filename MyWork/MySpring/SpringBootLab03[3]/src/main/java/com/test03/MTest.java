package com.test03;

import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;

public class MTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        //generator.initialize(2048);

        KeyPair key = generator.genKeyPair();

        System.out.println(generator.getAlgorithm());
        System.out.println("생성된 개인키: "+ generator.genKeyPair().getPrivate());//생성된 개인키
        System.out.println("생성된 개인키: "+ generator.genKeyPair().getPublic());//생성된 공개키


        Object res = NimbusJwtDecoder.withPublicKey((RSAPublicKey) key.getPublic() ).build();
        System.out.println("res = " + res);

    }
}
