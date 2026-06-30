public class DemoPhone {
    static void main() {
        Phone phone1=new Phone("892100000","Iphone 17 pro", 450);
        Phone phone2=new Phone("8921777777","Iphone 15");
        Phone phone3=new Phone();
        phone1.receiveCall("Рома");
        System.out.println("##########");
        phone2.receiveCall("Витя","8900555777");

        String[] numdersphone={
                "892123456789",
                "890023456744",
                "895177777777"
        };
        System.out.println("##########");
        phone3.sendMessage(numdersphone);
        System.out.println("##########");
        System.out.println(phone1);
        System.out.println("##########");
        System.out.println(phone2);
        System.out.println("##########");
        System.out.println(phone3);

    }
}
