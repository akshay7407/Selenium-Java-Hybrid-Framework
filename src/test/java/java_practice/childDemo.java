package java_practice;

public class childDemo extends parentsDemo {
	
	
	public childDemo() {
		super(); //This should be always called in first line 
		System.out.println("I am child class constructor ");
		
	}

	
	 String name = "QaAkshayGaikwad";
	
	public  void getStringData()
	{
		System.out.println(name);
		
//		Using Super Keyword Here
		
		System.out.println(super.name);
	}
	
	
	public void getData() {
		//Call parents class method using super keyword 
		super.getData();
		System.out.println("I am in Child class");
	}
	public static void main(String[] args) {
		
		childDemo obj =new childDemo();
		obj.getStringData();
		obj.getData();
	

	}

}
