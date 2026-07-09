package com.sber.dz6;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
    public static Animal petToAnimal(Pet pet) throws Exception {
        Animal animal = new Animal();

        Field[] petFields = pet.getClass().getDeclaredFields();
        Field[] animalFields = Animal.class.getDeclaredFields();

        for (Field petField : petFields) {
            petField.setAccessible(true);

            for (Field animalField : animalFields) {
                animalField.setAccessible(true);

                if (petField.getName().equals(animalField.getName())
                        && petField.getType().equals(animalField.getType())) {

                    Object value = petField.get(pet);
                    animalField.set(animal, value);
                    break;
                }
            }
        }

        return animal;
    }

    public static void printAnnotatedMessages(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Paint classPaint = clazz.getAnnotation(Paint.class);

        for (Method method : clazz.getDeclaredMethods()) {
            method.setAccessible(true);
            Object result = method.invoke(obj);

            if (result instanceof String text) {
                Paint paint = method.getAnnotation(Paint.class);
                if (paint == null) {
                    paint = classPaint;
                }
                if (paint != null && !paint.color().isEmpty()) {
                    System.out.println(paint.color() + text + Message.RESET);
                } else {
                    System.out.println(text);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("=== Конвертация Pet -> Animal ===\n");
        Pet pet = new Pet("слон", 3, "африканский");
        Animal animal = petToAnimal(pet);
        animal.display();

        System.out.println("\n=== Аннотации ===\n");
        printAnnotatedMessages(new Message());
    }
}
