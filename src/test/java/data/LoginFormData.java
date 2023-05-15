package data;

import com.github.javafaker.Faker;

public final class LoginFormData {

    private LoginFormData() {
    }

    public static String password() {
        return new Faker().name().firstName() + new Faker().name().lastName().toUpperCase() + new Faker().code().ean8();
    }

    public static String email() {
        return new Faker().name().firstName();
    }

    public static String domain() {
        return new Faker().internet().domainWord();
    }
}