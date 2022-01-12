/* Name; John Gitahi
    SMU; 48116033
	Lab 5 Fall-2019
*/	
//Pop1.java
import java.util.Random;
import java.util.Scanner;

public class Pop1 {

    static int containingMoney = 0;
    static int containingPeruna = 0;
    static int ballons[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


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
            } else {
                return ballonIndex;
            }
        }
    }

    public static void pop(int ballonIndex) {
        ballonIndex -= 1; // subtract 1
        if (ballons[ballonIndex] == 100) {
            containingMoney += 100;
            System.out.println("You popped $100!");
        } else {
            containingPeruna += 1;
            System.out.println("You popped a Peruna!");

        }
    }

    public static void displayBallons() {
        System.out.printf("%10s $%6d\n","Perunas:", containingPeruna);
        System.out.printf("%10s $%6d\n","Money:", containingMoney);
        System.out.println("\nAVAILABLE BALLONS:");
        for (int i = 1; i <= ballons.length; i++) {
            if (ballons[i - 1] == 100) {
                System.out.printf("%4c", '$');
            } else {
                System.out.printf("%4c", 'P');
            }
            if (i % 5 == 0) System.out.println();

        }
    }
}//end Pop1