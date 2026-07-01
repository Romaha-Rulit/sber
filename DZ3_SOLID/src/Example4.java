// 1. Разделенные интерфейсы
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

// 2. Человек реализует оба интерфейса
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

// 3. Робот реализует только работу
class Robot implements Workable {
    @Override
    public void work() {
        System.out.println("Робот работает");
    }
}

// Использование в main
public class Example4 {
    public static void main(String[] args) {
        Workable human = new Human();
        Workable robot = new Robot();

        human.work();
        ((Eatable) human).eat();

        robot.work();
        // robot.eat() - невозможно вызвать, что правильно!
    }
}