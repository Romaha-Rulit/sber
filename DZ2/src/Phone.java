public class Phone {
    String number;
    String model;
    int weight;
    public Phone(String number, String model, int weight){
        this.number=number;
        this.model=model;
        this.weight=weight;
    }
    public void receiveCall(String name){
        System.out.println("звонит " +name);
    }
    public String getNumber(){
        return number;
    }
    public Phone(String number, String model){
        this.number=number;
        this.model=model;
    }
    public Phone(){
        this.number=null;
        this.model=null;
        this.weight=0;
    }
    public void receiveCall(String name, String numberPhone){
        System.out.println("номер: "+numberPhone+" имя "+name);
    }
    public void sendMessage(String[] ListNum){
        for(int i=0;i< ListNum.length;i++){
            System.out.println(ListNum[i]+" ");
        }
    }
    @Override
    public String toString(){
        return "номер "+number+"\n"+"модель "+model+"\n"+"вес "+weight;
    }
}
