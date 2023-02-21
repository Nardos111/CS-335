
public class tester {
    public static void main(String[] args) { 
	    List<Integer> options = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	    Scanner scanner = new Scanner(System.in);
        boolean x = false; 
        while( x != true)
        System.out.println("What do you want to do? Select a number from the listed options: ");
	       try {
	        	//if (scanner.hasNextInt()) {
	        	int selection = scanner.nextInt();
	        		if (options.contains(selection)) {
	        			System.out.println(selction);  
                        x= true; 
	            }  else {
	                System.out.println("Please enter a number between 1-9: ");
	                x= false; } } 
	          
	        catch (InputMismatchException err) {
	         System.out.println("Please enter a valid integer input."); 
	            x= false;   




        }  } } 