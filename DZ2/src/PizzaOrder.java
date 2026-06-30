public class PizzaOrder {
    public enum Size {
        SMALL, MEDIUM, BIG
    }

    private String name;
    private Size size;
    private boolean hasSauce;
    private String deliveryAddress;
    private boolean isOrderAccepted;

    public PizzaOrder(String name, Size size, boolean hasSauce, String deliveryAddress) {
        this.name = name;
        this.size = size;
        this.hasSauce = hasSauce;
        this.deliveryAddress = deliveryAddress;
        this.isOrderAccepted = false; // По умолчанию заказ не принят
    }

    public void order() {
        if (isOrderAccepted) {
            System.out.println("Заказ уже принят.");
            return;
        }

        isOrderAccepted = true;

        String sizeName = switch (size) {
            case SMALL -> "Маленькая";
            case MEDIUM -> "Средняя";
            case BIG -> "Большая";
        };

        String sauceInfo = hasSauce ? "с соусом" : "без соуса";

        System.out.printf("Заказ принят. %s пицца «%s» %s на адрес %s.%n",
                sizeName, name, sauceInfo, deliveryAddress);
    }

    public void cancel() {
        if (isOrderAccepted) {
            isOrderAccepted = false;
            System.out.println("Заказ отменен.");
        }
    }

    public String getName() {
        return name;
    }

    public Size getSize() {
        return size;
    }

    public boolean isHasSauce() {
        return hasSauce;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isOrderAccepted() {
        return isOrderAccepted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setHasSauce(boolean hasSauce) {
        this.hasSauce = hasSauce;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return name + ' ' + size +' '+ hasSauce +' '+ deliveryAddress + ' ' + isOrderAccepted;
    }
}

