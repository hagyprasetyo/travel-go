package com.travelgo.app.utils;

import java.util.Random;

public final class ConfirmationGenerator {

    private static final Random RANDOM = new Random();

    private ConfirmationGenerator() {
    }

    public static int generate() {
        return 100000 + RANDOM.nextInt(900000);
    }
}
