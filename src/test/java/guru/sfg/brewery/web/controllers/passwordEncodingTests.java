package guru.sfg.brewery.web.controllers;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Ignore
public class passwordEncodingTests {

    static final String PASSWORD = "password";

    @Test
    void testBcrypt() {
        PasswordEncoder bcrypt = new BCryptPasswordEncoder(15);

        System.out.println(bcrypt.encode(PASSWORD));
        System.out.println(bcrypt.encode("tiger"));

    }

    @Test
    void sha256() {
        PasswordEncoder sha256 = new StandardPasswordEncoder();

        System.out.println(sha256.encode(PASSWORD));
    }

    @Test
    void testLdap() {
        PasswordEncoder ldap = new LdapShaPasswordEncoder();

        System.out.println(ldap.encode("tiger"));
    }
}
