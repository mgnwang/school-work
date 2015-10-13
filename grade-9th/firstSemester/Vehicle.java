//Megan Wang
//10-8-14
//Food class

public class Vehicle{
	String x;
	public Vehicle(String name, String go, String stop, String power, int wheels){
		x = "";
		x = "I am a" + name + " that is" + power + ". Push on my" + go +"to go and my" + stop + "to stop. I have" + wheels + "wheels.";
		
	}
	
	public void print(){
		System.out.println(x);

	} 
}