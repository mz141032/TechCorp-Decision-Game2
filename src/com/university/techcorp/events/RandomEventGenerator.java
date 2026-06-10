package com.university.techcorp.events;

import java.util.Random;

public class RandomEventGenerator {
    private static Random random = new Random();

    public static GameEvent generateRandomEvent() {
        int chance = random.nextInt(100);

        if (chance < 20) {
            int eventType = random.nextInt(3);

            switch (eventType) {
                case 0:
                    return new MarketSlowdownEvent();
                case 1:
                    return new ClientBonusEvent();
                case 2:
                    return new ServerFailureEvent();
                default:
                    return null;
            }
        }

        return null;
    }
}