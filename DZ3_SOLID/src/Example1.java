// 1. Класс для хранения пользователей
class UserRepository {
    private java.util.Map<String, String> users = new java.util.HashMap<>();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

// 2. Класс для логирования
class Logger {
    public void log(String message) {
        System.out.println("[" + java.time.LocalDateTime.now() + "] " + message);
    }

    public void logError(String error) {
        System.err.println("[ERROR " + java.time.LocalDateTime.now() + "] " + error);
    }
}

// 3. Сервис, который их использует
class UserService {
    private UserRepository userRepository;
    private Logger logger;

    public UserService(UserRepository userRepository, Logger logger) {
        this.userRepository = userRepository;
        this.logger = logger;
    }

    public void registerUser(String username, String password) {
        userRepository.addUser(username, password);
        logger.log("User registered: " + username);
    }

    public boolean loginUser(String username, String password) {
        boolean success = userRepository.authenticate(username, password);
        if (success) {
            logger.log("User logged in: " + username);
        } else {
            logger.logError("Failed login attempt: " + username);
        }
        return success;
    }
}

// Использование в main
public class Example1 {
    public static void main(String[] args) {
        UserRepository repo = new UserRepository();
        Logger logger = new Logger();
        UserService service = new UserService(repo, logger);

        service.registerUser("alice", "pass123");
        service.loginUser("alice", "pass123");
        service.loginUser("alice", "wrong");
    }
}