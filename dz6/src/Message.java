@Paint(style = "arrow", color = Message.RED)
class Message {
    public static final String RESET  = "\u001B[0m";
    public static final String RED    = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";

    @Paint(style = "hurray", color = PURPLE)
    public String happyBirthday() {
        return "С днём рождения!";
    }

    @Paint(style = "!", color = YELLOW)
    public String warning() {
        return "Предупреждение";
    }

    public String error() {
        return "Ошибка";
    }
}