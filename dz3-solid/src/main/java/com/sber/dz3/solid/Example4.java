package com.sber.dz3.solid;

// ISP: Разделенные интерфейсы
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

// ISP: Человек реализует оба интерфейса
class Human implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Человек работает");
    }

    @Override
    public void eat() {
        System.out.println("Человек ест");
    }
}

// ISP: Робот реализует только работу
class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Робот работает");
    }
}

public class Example4 {
    public static void main(String[] args) {
        System.out.println("=== Пример 4: ISP (Interface Segregation Principle) ===\n");
        Workable human = new Human();
        Workable robot = new Robot();

        human.work();
        ((Eatable) human).eat();

        robot.work();
        // robot.eat() - невозможно вызвать, что правильно!
    }
}
