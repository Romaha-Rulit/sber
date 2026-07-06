import java.lang.annotation.*;
import java.lang.reflect.Method;

public class Annotation {
    public static void print(Object obj) throws Exception {
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
                    String style = paint.style();
                    System.out.println(paint.color() + text + Message.RESET);
                } else {
                    System.out.println(text);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        print(new Message());
    }
}