/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackbox;

/**
 *
 * @author goodo
 */
public class StackBoxDriver2 extends StackBox {

    public static void main(String[] args) {
        mainFunc();
    }

    public static void mainFunc() {
        StackBox<String> box = new StackBox<String>();
        java.util.Scanner scan = new java.util.Scanner(System.in);
        String input = "";
        input = scan.nextLine();
        String reverse = "";
        for (int i = 0; i < input.length(); i++) {
            box.push(input.charAt(i) + "");
            System.out.print(box.peek());
        }
        System.out.println("");
        for (int i = 0; i < input.length(); i++) {
            System.out.print("-");
        }
        System.out.println("");
        while (box.isEmpty() != true) {
            System.out.print(box.peek());
            String item = box.pop();
            reverse += item;
        }
        if (reverse.equals(input)) {
            System.out.println("\n" + reverse + ": Is a Palindrome");
        } else {
            System.out.println("\n" + input + ": Is Not a Palindrome");
        }
    }
}
