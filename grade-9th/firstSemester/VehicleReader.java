//Megan Wang
//10-9-14

public class VehicleRunner{
	public static void main(String [] args){
		Vehicle x = new Bike("bike","pedals","brakes", "human powered", 2 );
		x.print();
		Vehicle z = new Car("car", "motorized");
		z.printForSale();
		Vehicle y = new ElectricCar("electric car", "electric");
		y.printForSale();
		
	}
}