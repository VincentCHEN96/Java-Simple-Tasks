class Student {
	public String name;
	public int age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void show() {
		System.out.println("The name is " + name + "," + "and the age is " + age);
	}
}

class Undergraduate extends Student {
	public String degree;

	public Undergraduate(String name, int age, String degree) {
		super(name, age);
		this.degree = degree;
	}

	public void show() {
		super.show();
		System.out.println("The degree is " + degree);
	}
}

public class Test2 {

	public static void main(String[] args) {
		Student student = new Student("³ÂÎ¤ï£", 19);
		Undergraduate undergraduate = new Undergraduate("³ÂÎ¤ï£", 19, "Ñ§Ê¿");
		student.show();
		undergraduate.show();
	}

}
