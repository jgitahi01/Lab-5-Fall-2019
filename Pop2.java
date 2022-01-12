/* Name; John Gitahi
    SMU; 48116033
	Lab 5 Fall-2019
*/	

// Pop2.java
import java.util.Random;
import java.util.Scanner;
public class Pop2 {
  
   static int containingMoney = 0;
   static int containingPeruna = 0;
   static int ballons[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
   static boolean selected[] = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
  
   public static void main(String[] args) {

       int ballonNumber = 0;
       inflate();
       do {
           displayBallons();
           ballonNumber = selectBallon();
           pop(ballonNumber);
       } while (containingPeruna != 4);
       displayBallons();
   }
  
   public static void inflate() {

       Random random = new Random();
       int toss=0;
       for (int i = 0; i < ballons.length; i++) {

       toss = random.nextInt(2);
           if (toss == 0) {
               ballons[i] = 1; // will represent Peruna
           } else {
               ballons[i] = 100; // will represent money;
           }
       }
   }
  
   public static int selectBallon() {

       int ballonIndex = 0;
       Scanner scanner = new Scanner(System.in);
       while (true) {
           System.out.print("Select a ballon to pop (1-20): ");
           ballonIndex = scanner.nextInt();
           if (ballonIndex < 1 || ballonIndex > 20) {
               System.out.println("Sorry! You must enter a number between 1 and 20. Try again.");
           }else if(selected[ballonIndex-1])
           {
               System.out.println("Ballon was already popped.");
           }
           else {
               return ballonIndex;
           }
       }
   }
  
   public static void pop(int ballonIndex) {
       ballonIndex -= 1; // subtract 1
       selected[ballonIndex] = true;
       if (ballons[ballonIndex] == 100) {
           containingMoney += 100;
           System.out.println("You popped $100!");
       } else {
           containingPeruna += 1;
           System.out.println("You popped a Peruna!");
       }
   }
  
   public static void displayBallons() {
       System.out.printf("%10s %6d\n","Perunas:", containingPeruna);
       System.out.printf("%10s $%6d\n","Money:", containingMoney);
       System.out.println("\nAVAILABLE BALLONS:");
       for (int i = 1; i <= ballons.length; i++) {
           if(selected[i-1])
           {
               if (ballons[i - 1] == 100) {
                   System.out.printf(" %-2c ", '$');
               } else {
                   System.out.printf(" %-2c ", 'P');
               }
           }else
           {
               System.out.printf("[%2d] ",i);
           }
           if (i % 5 == 0) System.out.println();
       }
   }

}

//end of Pop2.java