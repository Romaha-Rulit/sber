package com.sber.dz3.solid;

import java.util.ArrayList;
import java.util.List;

// DIP: Абстракция (интерфейс)
interface Database {
    void save(String data);
}

// DIP: Конкретные реализации
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to PostgreSQL: " + data);
    }
}

class InMemoryDatabase implements Database {
    private List<String> data = new ArrayList<>();

    @Override
    public void save(String data) {
        this.data.add(data);
        System.out.println("Saving in-memory: " + data);
    }
}

// DIP: Сервис зависит от абстракции, а не от конкретной реализации
class UserService5 {
    private Database database;

    public UserService5(Database database) {
        this.database = database;
    }

    public void createUser(String username) {
        database.save("User: " + username);
    }
}

public class Example5 {
    public static void main(String[] args) {
        System.out.println("=== Пример 5: DIP (Dependency Inversion Principle) ===\n");
        Database mysql = new MySQLDatabase();
        Database postgres = new PostgreSQLDatabase();
        Database inMemory = new InMemoryDatabase();

        UserService5 service1 = new UserService5(mysql);
        service1.createUser("alice");

        UserService5 service2 = new UserService5(postgres);
        service2.createUser("bob");

        UserService5 service3 = new UserService5(inMemory);
        service3.createUser("charlie");
    }
}
