interface Shape {
	public double area(double length);
}

class Square implements Shape {
	public double area(double length) {
		return length * length;
	}
}

class Circle implements Shape {
	public double area(double length) {
		return Math.PI * length * length;
	}
}

public class Test3 {

	public static void main(String[] args) {
		Square square = new Square();
		Circle circle = new Circle();
		double area = square.area(2);
		System.out.println("边长为2的正方形面积为" + area);
		area = circle.area(3);
		System.out.println("半径为3的圆形面积为" + area);
	}

}
