package MetThePet.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderMain {
    
    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("hasłoMasło"));//zamienia surowe hasło na posać zaHASHowana

        System.out.println(encoder.matches("hasłoMasło","1a23724e-315b-4506-a768-493bf41bffd7"));

        validatePassword();
    }

    private static void validatePassword() {
        String passwd = "";
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        System.out.println(passwd.matches(pattern));
    }
}
