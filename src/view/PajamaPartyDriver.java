package view;

import java.util.Scanner;

import controller.InputController;

/**
 * This is the driver class for this problem.
 * It takes a string input and displays desired output.
 * This class acts as the logic behind a view. For the 
 * sake of this exercise, our view is the console.
 * 
 * Run this class and provide the input string int the console to get the desired output 
 * @author Shashank Shekhar
 *
 */
public class PajamaPartyDriver {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        InputController controller = new InputController();
        String result = controller.parseAndReturnOutput(input);
        System.out.println(result);
    }

}
