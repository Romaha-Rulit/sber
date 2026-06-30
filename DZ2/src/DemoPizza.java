class DemoPizza {
     static void main(String[] args) {
        PizzaOrder order = new PizzaOrder(
                "Аль-Капчоне",
                PizzaOrder.Size.BIG,
                true,
                "Ярославская 101"
        );

        System.out.println("=== Демонстрация работы PizzaOrder ===\n");

        order.order(); // Заказ принят
        order.order(); // Повторный заказ - ошибка

        System.out.println();
        order.cancel(); // Отмена заказа
        order.cancel(); // Повторная отмена - ошибка

        System.out.println("\n=== Демонстрация геттеров и сеттеров ===");

        System.out.println("Название пиццы: " + order.getName());
        System.out.println("Размер: " + order.getSize());
        System.out.println("Есть соус: " + order.isHasSauce());
        System.out.println("Адрес доставки: " + order.getDeliveryAddress());
        System.out.println("Заказ принят: " + order.isOrderAccepted());

        order.setName("Маргарита");
        order.setSize(PizzaOrder.Size.MEDIUM);
        order.setHasSauce(false);
        order.setDeliveryAddress("Ленина 15");

        System.out.println("\nПосле изменений:");
        System.out.println(order);

        System.out.println("\n=== Новый заказ ===");
        PizzaOrder order2 = new PizzaOrder(
                "Гавайская",
                PizzaOrder.Size.SMALL,
                true,
                "Мира 7"
        );
        order2.order();
    }
}