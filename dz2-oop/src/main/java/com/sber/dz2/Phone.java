package com.sber.dz2;

public class Phone {
    private String number;
    private String model;
    private int weight;

    public Phone(String number, String model, int weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this(number, model, 0);
    }

    public Phone() {
        this(null, null, 0);
    }

    public void receiveCall(String name) {
        System.out.println("звонит " + name);
    }

    public void receiveCall(String name, String numberPhone) {
        System.out.println("номер: " + numberPhone + " имя " + name);
    }

    public void sendMessage(String[] phoneNumbers) {
        for (String phoneNumber : phoneNumbers) {
            System.out.print(phoneNumber + " ");
        }
        System.out.println();
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "номер " + number + "\n" + "модель " + model + "\n" + "вес " + weight;
    }
}
