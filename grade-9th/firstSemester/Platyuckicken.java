import java.util.Scanner; //import Scanner

public class Platyuckicken{ //class header
        static int blood = 0;//global variables int blood, int egg, String
        static int egg = 0;
        static int milk = 0;
        static String feet = "";
        static String surface = "";

        public static void main(String[]args){ //main
                String animal = "";
                animal = whichAnimal(); //call whichAnimal
                printOutput(animal); //call printOutput
        }

        public static void printOutput(String a){ //printOutput
                System.out.println("I'd classify this as..." + a); //prints out animal
        }

        public static String whichAnimal(){//whichAnimal
                String animal = "";
                Scanner x = new Scanner(System.in); //create Scanner instance
                System.out.println("Is the animal warm blooded? Enter 1 as yes, 0 as no");//ask questions, read output. If 1, then true, if 0 then false
                blood = x.nextInt();//save to variable
                if (blood == 1){
                        System.out.println("Does the animal produce milk? Enter 1 as yes, 0 as no.");
                        milk = x.nextInt();
                        if(milk == 1){
							animal = "mammal";
							System.out.println("Does the animal have fur or feathers?");
                        	surface = x.nextLine();
                        	surface = x.nextLine();
                                if (surface.equalsIgnoreCase("fur")){//if milk - mammal
                                        System.out.println("Does the animal lay eggs? Enter 1 as yes, 0 as no");
                                        egg = x.nextInt();
                                   	 	System.out.println("Does the animal have webbed or not webbed feet?");
                                    	feet = x.nextLine();//reads next line
                                   	 		if(feet.equalsIgnoreCase("webbed")&& egg==1)//if webbed feet - duck
                                                    animal = animal + ", platypus";
											else if(egg==0||feet.equalsIgnoreCase("not webbed"))//if webbed feet - duck)
													animal = animal;
									}
								else
									animal = "inconclusive";
							}
                            else if (milk == 0){//if milk false - bird
                            	System.out.println("Does the animal have fur or feathers?");
	                        	surface = x.nextLine();
	                        	surface = x.nextLine();  
										if (surface.equalsIgnoreCase("fur")) 
											animal = "inconclsive";
										else if (surface.equalsIgnoreCase("feathers")){
											animal = "bird";
                                       	 	System.out.println("Does the animal have webbed or not webbed feet?");
                                        	feet = x.nextLine();//reads next line
                                       	 		if(feet.equalsIgnoreCase("webbed"))//if webbed feet - duck
                                                	animal = animal + ", duck";
                                        		else if(feet.equalsIgnoreCase("not webbed"))//if not webbed - chicken
                                                	animal = animal + ", chicken";
										}
								}
                return animal;//return animal
        	}
}