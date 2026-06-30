public class Circle {
    double radius;
    String color;

    public double area(){
        return 3.14*radius*radius;
    }
    public double perimeter(){
        return 2*3.14*radius;
    }
    public Circle(String color, double radius){
        this.radius=radius;
        this.color=color;
    }
    @Override
    public String toString(){
        return "радиус: "+radius+"\n"+
                "цвет: "+color+"\n"+
                "периметр: "+perimeter();
    }
}
