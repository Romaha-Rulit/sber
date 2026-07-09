package com.sber.dz3.solid;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

// SRP: Класс для хранения пользователей
class UserRepository {
    private Map<String, String> users = new HashMap<>();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

// SRP: Класс для логирования
class Logger {
    public void log(String message) {
        System.out.println("[" + LocalDateTime.now() + "] " + message);
    }

    public void logError(String error) {
        System.err.println("[ERROR " + LocalDateTime.now() + "] " + error);
    }
}

// Сервис, который их использует
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

public class Example1 {
    public static void main(String[] args) {
        System.out.println("=== Пример 1: SRP (Single Responsibility) ===\n");
        UserRepository repo = new UserRepository();
        Logger logger = new Logger();
        UserService service = new UserService(repo, logger);

        service.registerUser("alice", "pass123");
        service.loginUser("alice", "pass123");
        service.loginUser("alice", "wrong");
    }
}
