// package ru.netology;

import java.util.Scanner;

public class Main {

    public static int age_18 = 18;

    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        validateUser(getUserByLoginAndPassword(login, password));
        System.out.println("Доступ предоставлен");
    }

    public static User[] getUsers() {
        User user1 = new User("Franc", "pass", 18, "franc@mail.ru");
        User user2 = new User("John", "qwerty", 15, "john@mail.ru");
        User user3 = new User("Mike", "123456", 21, "mike@mail.ru");
        User user4 = new User("Nastya", "111", 17, "nastya@mail.ru");
        return new User[]{user1, user2, user3, user4};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < age_18) {
            throw new AccessDeniedException("Access Denied");
        }
    }
}

