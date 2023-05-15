package utils;

import java.util.Random;

public class RandomUtils {
    private static Random random = new Random();

    public static int getRandomIndex(int max) {
        return random.nextInt(max);
    }
}