package controller;

import model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

class LoginServletTest {

    @Test
    void testHashing() {
        String ourHashedPassword = null;
        String ourPassword = "ali123";
        try {
            byte [] hash = MessageDigest
                    .getInstance("SHA-256")
                    .digest(ourPassword.getBytes(StandardCharsets.UTF_8));
            ourHashedPassword = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Assertions.assertEquals(ourHashedPassword, User.hashPassword(ourPassword));
    }

}
