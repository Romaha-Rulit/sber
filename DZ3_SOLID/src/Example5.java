// 1. Абстракция (интерфейс)
interface Database {
    void save(String data);
}

// 2. Конкретные реализации
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
    private java.util.List<String> data = new java.util.ArrayList<>();

    @Override
    public void save(String data) {
        this.data.add(data);
        System.out.println("Saving in-memory: " + data);
    }
}

// 3. Сервис зависит от абстракции, а не от конкретной реализации
class UserService5 {
    private Database database;

    // Внедрение зависимости через конструктор
    public UserService5(Database database) {
        this.database = database;
    }

    public void createUser(String username) {
        database.save("User: " + username);
    }
}

// Использование в main
public class Example5 {
    public static void main(String[] args) {
        // Можно легко менять реализацию базы данных
        Database mysql = new MySQLDatabase();
        Database postgres = new PostgreSQLDatabase();
        Database inMemory = new InMemoryDatabase();

        // Используем любую реализацию
        UserService5 service1 = new UserService5(mysql);
        service1.createUser("alice");

        UserService5 service2 = new UserService5(postgres);
        service2.createUser("bob");

        UserService5 service3 = new UserService5(inMemory);
        service3.createUser("charlie");
    }
}