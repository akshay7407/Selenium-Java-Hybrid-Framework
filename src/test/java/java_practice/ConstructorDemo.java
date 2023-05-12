package java_practice;

public class ConstructorDemo {
	
	//Non parameterized constructor 
	public ConstructorDemo(){
		System.out.println("I am the constructor ");
	}
	
	//parameterized constructor 
	public ConstructorDemo(int a , int b){
		System.out.println("I am the parameterized constructor ");
		System.out.println(a+b);
	}
	
	public void getData() {
		System.out.println("I am the mehod in class");
	}
	public static void main(String[] args) {
		
		
		ConstructorDemo obj = new ConstructorDemo();
		ConstructorDemo obj1 = new ConstructorDemo(2,3);
		//Whenever you create object constructor is called 
		obj.getData();

	}

}
