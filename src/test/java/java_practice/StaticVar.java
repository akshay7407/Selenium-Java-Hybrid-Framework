package java_practice;

public class StaticVar {
	
	String name ; //instance variable 
    String address ;
    static String city ; //class variable
    static int i =2;
	
	public StaticVar(String name , String address , String city) {
		
		this.name = name;
		this.address = address ;
		this.city =city ;
		i++ ;
		System.out.println(i);
		
		// TODO Auto-generated constructor stub
	}
	
	public void getAddress() {
		System.out.println(address+"  "+ city);
	}
	
	public static void getCity() {
		System.out.println(city);
	}

	public static void main(String[] args) {
		StaticVar obj = new StaticVar("Akshay", "Vimannagar", "PCMC");
		StaticVar obj1 = new StaticVar("Vikas", "ChandanNagar", "pune");
		obj.getAddress();
		obj1.getAddress();
		getCity();

	}

}
