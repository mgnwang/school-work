import java.util.Scanner;
public class ClassSize{
	public static int average, max, min, slots = 0;
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
