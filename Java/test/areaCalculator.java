class Shape {
    public void area () {
        return;
    }
}

class Rectangle extends Shape {
    private int len, bd;
    Rectangle(int a, int b){
        len = a;
        bd = b;
    }
    public void area (){
        System.out.println("Area of a Rectangle: " + len*bd);
    }
}

class Triangle extends Shape {
    private int hgt, bse;
    Triangle(int a, int b){
        hgt = a;
        bse = b;
    }
    public void area (){
        System.out.println("Area of a Triangle: " + 0.5*hgt*bse);
    }
}

class Circle extends Shape {
    private int rad;
    Circle(int rad){
        this.rad = rad;
    }
    public void area() {
        System.out.println("Area of a Circle: " + 3.14*rad*rad);
    }
}

class calArea {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 20);
        Triangle tri = new Triangle(10, 20);
        Circle cir = new Circle(10);

        rect.area();
        tri.area();
        cir.area();
    }
}
