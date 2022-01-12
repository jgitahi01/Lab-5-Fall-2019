/* Name; John Gitahi
    SMU; 48116033
	Lab 5 Fall-2019
*/	

// Pop3.java
import java.util.Random;
import java.util.Scanner;
public class Pop3 {
  
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
       System.out.println("You popped four Perunas! Game Over!");
       System.out.printf("You Won:$%d", containingMoney);
   }
  
   public static void inflate() {

       Random random = new Random();
       int toss=0;
       // loop to randomly allocate peruna and money ballons
       for (int i = 0; i < ballons.length; i++) {
       toss = random.nextInt(2);
           if (toss == 0) {
               ballons[i] = 1; // will represent Peruna
           } else {
               ballons[i] = getBallonValue(); // generate a random money value between 50 and 1000
           }
       }
      
       toss = random.nextInt(20);
       ballons[toss] = -1;
   }
  
   public static int getBallonValue()
   {
       Random random = new Random();
       int value = random.nextInt(951)+50;
       while(value%50 != 0)
           value = random.nextInt(951)+50;
       return value;
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
      
       if(ballons[ballonIndex] == -1)
       {
           containingMoney = 0;
           System.out.println("Horned Frog! You lost your money!");
       }
       else if (ballons[ballonIndex] > 1) {
           containingMoney += ballons[ballonIndex];
           System.out.println("You popped "+ballons[ballonIndex]+"!");
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
               if(ballons[i-1] == -1)
                   System.out.printf(" %-2c ", 'H');
               else if (ballons[i - 1] > 1) {
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

//end of Pop3.java