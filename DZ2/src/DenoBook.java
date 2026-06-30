class DemoBook {
     static void main(String[] args) {
        // Создаем автора
        Author author = new Author("Лев Толстой", "Мужской", "ttttt@gmail.com");

        // Создаем книгу
        Book book = new Book("Война и мир", author, 1869);

        // Демонстрация работы геттеров
        System.out.println("Название книги: " + book.getTitle());
        System.out.println("Автор: " + book.getAuthor().getName());
        System.out.println("Год издания: " + book.getYear());

        // Демонстрация работы сеттеров
        book.setTitle("Анна Каренина");
        book.setYear(1877);
        author.setEmail("aaaaaaa@mail.com");

        System.out.println("\nПосле изменений:");
        System.out.println(book);

        // Создаем второго автора
        Author author2 = new Author("Федор Достоевский", "Мужской", "ddddddd@mail.com");
        Book book2 = new Book("Преступление и наказание", author2, 1866);

        System.out.println("\nВторая книга:");
        System.out.println(book2);
    }
}