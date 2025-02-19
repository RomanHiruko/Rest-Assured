package utils;

import com.github.javafaker.Faker;

// Генератор данных
public class DataGenerator {
    private static final Faker faker = new Faker();


    public static String generateRandomName() {
        return faker.name().fullName();
    }

    public static String generateRandomJob() {
        return faker.job().position();
    }

    public static String generateRandomDate() {
        return faker.date().birthday().toString();
    }
}
