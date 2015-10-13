public class Ingredient{
	private String name = " ";
	private double amount = 0;
	private String unit = " ";
	public Ingredient(String nm, double am, String un){
		name = nm;
		amount = am;
		unit = un;
	}
	public String getName(){
		return name;
	}
	public double getAmount(){
		return amount;
	}
	public void addAmount(double a){
		amount += a;
	}
	public String getUnit(){
		return unit;
	}
}
