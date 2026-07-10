package com.sber;

class Car implements Runnable {

    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");

            Main.START_BARRIER.await();

            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }

            synchronized (Main.class) {
                if (Main.winner == null) {
                    Main.winner = this.name;
                    System.out.println(this.name + " - WIN");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Main.FINISH_LATCH.countDown();
        }
    }
}
