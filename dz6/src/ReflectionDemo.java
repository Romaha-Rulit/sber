import java.lang.reflect.Field;


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

    public static void main(String[] args) throws Exception {
        Pet pet = new Pet("слон", 3, "африканский");
        Animal animal = petToAnimal(pet);
        animal.display();
    }
}