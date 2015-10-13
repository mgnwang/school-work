import java.util.Scanner;
public class ClassSize1{
	public static int average, max= 0, min = 0, slots = 0, min1 = 999999, max1 = 0;
	public static String string = " ";
	public static int [] students = new int [100];
	
	public static void main(String[]args){
		input();
		calculate();
		print();
	}
	
	public static void input(){
		Scanner reader = new Scanner(System.in);
		int num = 0;
		for(int i = 0; i<=100; i++){
			System.out.println("How many students are in the class?");
			string = reader.nextLine();
			if(string.equals("quit")){
				break;
			}
			else
				num = Integer.parseInt(string);
				students[i] = num;
				average += num;
				slots ++;
				System.out.println(" Before compare: max = " + max1 + " min = " + min1 + ", input" + num);
				if (max1 <= num) {
					max1 = num;
				}
				if (min1 > num) {
					min1 = num;
				}
				System.out.println(" after  compare: max = " + max1 + " min = " + min1 + ", input" + num);
		}	
		
	}
	public static void calculate(){
		average /= slots;
		for(int y = 0; y < slots; y++){
			if(y == 0){
				min = Math.min(students[y], students[y+1]);
				max = Math.max(students[y], students[y+1]);
				y++;
			}
			else{
				min = Math.min(students[y], min);
				max = Math.max(students[y], max);
			}
		}
	}
	public static void print(){
		for(int x = 0; x < slots; x++)
			System.out.println("index: " + x + " students: " + students[x]);
		System.out.println("average: " + average);
		System.out.println("maximum: " + max);
		System.out.println("minimum: " + min);
		System.out.println("maximum1: " + max1);
		System.out.println("minimum1: " + min1);
		for(int w = 0; w <= slots; w++){
			if(students[w]>36)
				System.out.printf("%s %d %s %d %s \n","Class at index",w,"exceeds ideal maximum of 36 students by",students[w]-36,"students");
			else if(students[w]<36)
				System.out.printf("%s %d %s %d %s \n","Class at index",w,"is",36 - students[w],"students below the ideal maximum of 36");
			else
				System.out.printf("%s %d %s \n","Class at index",w,"has the ideal maximum of 36 students");
		}
	}
	
}
