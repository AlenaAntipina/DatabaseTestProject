package data;

import com.github.javafaker.Faker;


public class DataForTables {

    private DataForTables() {
    }

    public static String getRandomDoubleNumber() {
        return String.valueOf(new Faker().number().numberBetween(1, 10)).repeat(2);
    }

    public static String getNameTestForTest() {
        return new Faker().twinPeaks().quote();
    }

    public static String getMethodNameForTest() {
        return new Faker().twinPeaks().location();
    }

    public static String getNameForAuthor() {
        return new Faker().twinPeaks().character();
    }

    public static String getLoginForAuthor() {
        return new Faker().name().username();
    }

    public static String getEmailForAuthor() {
        return new Faker().internet().emailAddress();
    }

    public static String getNameForProject() {
        return new Faker().ancient().titan();
    }

    public static String getSessionKeyForSession() {
        return new Faker().code().gtin8();
    }

    public static long getBuildNumberForSession() {
        return new Faker().number().randomNumber();
    }
}
