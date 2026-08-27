package Solitare;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Solitare {

    public static void main(String[] args) {
        go();
    }

    private static void go() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> shuffled_deck = shuffledDeck();
        Tableau<String> T0 = new Tableau<>();
        Tableau<String> T1 = new Tableau<>();
        Tableau<String> T2 = new Tableau<>();
        Tableau<String> T3 = new Tableau<>();
        Tableau<String> T4 = new Tableau<>();
        Tableau<String> T5 = new Tableau<>();
        Tableau<String> T6 = new Tableau<>();
        Deck<String> deck = new Deck<>();
        Foundations<String> Hearts = new Foundations<>();
        Foundations<String> Diamonds = new Foundations<>();
        Foundations<String> Clubs = new Foundations<>();
        Foundations<String> Spades = new Foundations<>();

        Waste<String> waste = new Waste<>();

        T0.addQ(shuffled_deck.remove(0));
        System.out.println("");
        for (int i = 0; i < 2; i++) {
            T1.addQ(shuffled_deck.remove(shuffled_deck.size() - 1));
        }
        for (int i = 0; i < 3; i++) {
            T2.addQ(shuffled_deck.remove(shuffled_deck.size() - 1));
        }
        for (int i = 0; i < 4; i++) {
            T3.addQ(shuffled_deck.remove(shuffled_deck.size() - 1));
        }
        for (int i = 0; i < 5; i++) {
            T4.addQ(shuffled_deck.remove(shuffled_deck.size() - 1));
        }
        for (int i = 0; i < 6; i++) {
            T5.addQ(shuffled_deck.remove(shuffled_deck.size() - 1));
        }
        for (int i = 0; i < 7; i++) {
            T6.addQ(shuffled_deck.remove(shuffled_deck.size() - 1));
        }
        while (shuffled_deck.isEmpty() != true) {
            deck.push(shuffled_deck.remove(shuffled_deck.size() - 1));
        }
        StartFlip(T0);
        StartFlip(T1);
        StartFlip(T2);
        StartFlip(T3);
        StartFlip(T4);
        StartFlip(T5);
        StartFlip(T6);
        Hearts.push("1H");
        Diamonds.push("1D");
        Clubs.push("1C");
        Spades.push("1S");
        //MenuSystem
        int input = 0;

        while (input != 6) {

            if (input == 0) {

                //Deck
                if(deck.isEmpty()){
                    while(waste.isEmpty()!=true){
                        deck.push(waste.pop());
                    }
                }
                if(deck.isEmpty()!=true){
                    System.out.println("Deck/Stock Contains: " + deck.size() + " cards");
                }
                //Waste Deck
                if (waste.isEmpty()) {
                    System.out.println("Top Card of Waste: (Empty)");
                } else {
                    System.out.println("Top Card of Waste: " + waste.peek() + "");
                }

                System.out.println("");
                //Tableaus

                System.out.println("<TABLEAUS>");
                if (T0.Qsize() == -1) {
                    System.out.println("T1 : has 0 face down cards and " + T0.Ssize() + " face up cards, showing: (EMPTY)");
                } else {
                    System.out.println("T1 : has " + T0.Qsize() + " face down cards and " + T0.Ssize() + " face up cards, showing: " + T0.sPeek());
                }
                if (T1.Qsize() == -1) {
                    System.out.println("T2 : has 0 face down cards and " + T1.Ssize() + " face up cards, showing: (EMPTY)");
                } else {
                    System.out.println("T2 : has " + T1.Qsize() + " face down cards and " + T1.Ssize() + " face up cards, showing: " + T1.sPeek());
                }
                if (T2.Qsize() == -1) {
                    System.out.println("T3 : has 0 face down cards and " + T2.Ssize() + " face up cards, showing: (EMPTY)");
                } else {
                    System.out.println("T3 : has " + T2.Qsize() + " face down cards and " + T2.Ssize() + " face up cards, showing: " + T2.sPeek());
                }

                if (T3.Qsize() == -1) {
                    System.out.println("T4 : has 0 face down cards and " + T2.Ssize() + " face up cards, showing: (EMPTY)");
                } else {
                    System.out.println("T4 : has " + T3.Qsize() + " face down cards and " + T3.Ssize() + " face up cards, showing: " + T3.sPeek());
                }
                if (T4.Qsize() == -1) {
                    System.out.println("T5 : has 0 face down cards and " + T2.Ssize() + " face up cards, showing: (EMPTY)");
                } else {
                    System.out.println("T5 : has " + T4.Qsize() + " face down cards and " + T4.Ssize() + " face up cards, showing: " + T4.sPeek());
                }
                if (T5.Qsize() == -1) {
                    System.out.println("T6 : has 0 face down cards and " + T2.Ssize() + " face up cards, showing: (EMPTY)");
                } else {
                    System.out.println("T6 : has " + T5.Qsize() + " face down cards and " + T5.Ssize() + " face up cards, showing: " + T5.sPeek());
                }
                if (T6.Qsize() == -1) {
                    System.out.println("T7 : has 0 face down cards and " + T2.Ssize() + " face up cards, showing: (EMPTY)");
                } else {
                    System.out.println("T7 : has " + T6.Qsize() + " face down cards and " + T6.Ssize() + " face up cards, showing: " + T6.sPeek());
                }
                System.out.println("");
                //FOUNDATIONS
                System.out.println("<FOUNDATIONS>");

                System.out.println("F1: " + Hearts.peek());
                System.out.println("F2: " + Diamonds.peek());
                System.out.println("F3: " + Clubs.peek());
                System.out.println("F4: " + Spades.peek());

                System.out.println("");
                System.out.println("1. Draw a Card from the Deck");
                System.out.println("2. Move Waste Card to Foundations");
                System.out.println("3. Move Waste Card to Tableau");
                System.out.println("4. Move a Tableau Card to another Tableau");
                System.out.println("5. Move a Tableau Card to another Foundations");
                System.out.println("6. Quit Game");
                input = scan.nextInt();
            }

            if (input == 1) {
                DrawDeck(waste, deck);
            }
            if (input == 2) {
                System.out.println("Which foundation? ");
                int found = Integer.parseInt(scan.next());
                if (found == 1) {
                    WasteToFoundation(waste, Hearts);
                }
                if (found == 2) {
                    WasteToFoundation(waste, Diamonds);
                }
                if (found == 3) {
                    WasteToFoundation(waste, Clubs);
                }
                if (found == 4) {
                    WasteToFoundation(waste, Spades);
                }

            }
            if (input == 3) {
                System.out.println("Which tableau? ");
                int found = Integer.parseInt(scan.next());
                if (found == 1) {
                    WasteToTableau(waste, T0);
                }
                if (found == 2) {
                    WasteToTableau(waste, T1);
                }
                if (found == 3) {
                    WasteToTableau(waste, T2);
                }
                if (found == 4) {
                    WasteToTableau(waste, T3);
                }
                if (found == 5) {
                    WasteToTableau(waste, T4);
                }
                if (found == 6) {
                    WasteToTableau(waste, T5);
                }
                if (found == 7) {
                    WasteToTableau(waste, T6);
                }

            }
            if (input == 4) {
                System.out.println("Move From which tableau? ");
                int tableau1 = Integer.parseInt(scan.next());
                int tableau2;
                switch (tableau1) {
                    case 1:
                        System.out.println("Move To which tableau? ");
                        tableau2 = Integer.parseInt(scan.next());
                        if (tableau2 == 1) {
                            System.out.println("Same Tableau");
                        }
                        if (tableau2 == 2) {
                            TableauToTableau(T0, T1);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }
                        }
                        if (tableau2 == 3) {
                            TableauToTableau(T0, T2);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }
                        }
                        if (tableau2 == 4) {
                            TableauToTableau(T0, T3);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }
                        }
                        if (tableau2 == 5) {
                            TableauToTableau(T0, T4);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }
                        }
                        if (tableau2 == 6) {
                            TableauToTableau(T0, T5);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }
                        }
                        if (tableau2 == 7) {
                            TableauToTableau(T0, T6);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Move To which tableau? ");
                        tableau2 = Integer.parseInt(scan.next());
                        if (tableau2 == 2) {
                            System.out.println("Same Tableau");
                        }
                        if (tableau2 == 2) {
                            TableauToTableau(T1, T0);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        if (tableau2 == 3) {
                            TableauToTableau(T1, T2);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        if (tableau2 == 4) {
                            TableauToTableau(T1, T3);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        if (tableau2 == 5) {
                            TableauToTableau(T1, T4);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        if (tableau2 == 6) {
                            TableauToTableau(T1, T5);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        if (tableau2 == 7) {
                            TableauToTableau(T1, T6);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Move To which tableau? ");
                        tableau2 = Integer.parseInt(scan.next());
                        if (tableau2 == 3) {
                            System.out.println("Same Tableau");
                        }
                        if (tableau2 == 1) {
                            TableauToTableau(T2, T0);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        if (tableau2 == 2) {
                            TableauToTableau(T2, T1);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        if (tableau2 == 4) {
                            TableauToTableau(T2, T3);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        if (tableau2 == 5) {
                            TableauToTableau(T2, T4);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        if (tableau2 == 6) {
                            TableauToTableau(T2, T5);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        if (tableau2 == 7) {
                            TableauToTableau(T2, T6);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Move To which tableau? ");
                        tableau2 = Integer.parseInt(scan.next());
                        if (tableau2 == 4) {
                            System.out.println("Same Tableau");
                        }
                        if (tableau2 == 1) {
                            TableauToTableau(T3, T0);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        if (tableau2 == 2) {
                            TableauToTableau(T3, T1);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        if (tableau2 == 3) {
                            TableauToTableau(T3, T2);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        if (tableau2 == 5) {
                            TableauToTableau(T3, T4);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        if (tableau2 == 6) {
                            TableauToTableau(T3, T5);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        if (tableau2 == 7) {
                            TableauToTableau(T3, T6);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Move To which tableau? ");
                        tableau2 = Integer.parseInt(scan.next());
                        if (tableau2 == 5) {
                            System.out.println("Same Tableau");
                        }
                        if (tableau2 == 1) {
                            TableauToTableau(T4, T0);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        if (tableau2 == 2) {
                            TableauToTableau(T4, T1);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        if (tableau2 == 3) {
                            TableauToTableau(T4, T2);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        if (tableau2 == 4) {
                            TableauToTableau(T4, T3);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        if (tableau2 == 6) {
                            TableauToTableau(T4, T5);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        if (tableau2 == 7) {
                            TableauToTableau(T4, T6);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Move To which tableau? ");
                        tableau2 = Integer.parseInt(scan.next());
                        if (tableau2 == 6) {
                            System.out.println("Same Tableau");
                        }
                        if (tableau2 == 1) {
                            TableauToTableau(T5, T0);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        if (tableau2 == 2) {
                            TableauToTableau(T5, T1);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        if (tableau2 == 3) {
                            TableauToTableau(T5, T2);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        if (tableau2 == 4) {
                            TableauToTableau(T5, T3);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        if (tableau2 == 5) {
                            TableauToTableau(T5, T4);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        if (tableau2 == 7) {
                            TableauToTableau(T5, T6);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Move To which tableau? ");
                        tableau2 = Integer.parseInt(scan.next());
                        if (tableau2 == 7) {
                            System.out.println("Same Tableau");
                        }
                        if (tableau2 == 1) {
                            TableauToTableau(T6, T0);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }

                        }
                        if (tableau2 == 2) {
                            TableauToTableau(T6, T1);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        if (tableau2 == 3) {
                            TableauToTableau(T6, T2);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        if (tableau2 == 4) {
                            TableauToTableau(T6, T3);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        if (tableau2 == 5) {
                            TableauToTableau(T6, T4);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        if (tableau2 == 6) {
                            TableauToTableau(T6, T5);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        break;

                }

            }
            if (input == 5) {
                System.out.println("Move To which tableau? ");
                int tableau1 = Integer.parseInt(scan.next());
                int found;
                switch (tableau1) {
                    case 1:
                        System.out.println("Move To which Foundation? ");
                        found = Integer.parseInt(scan.next());
                        if (found == 1) {
                            TableauToFoundations(T0, Hearts);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }

                        }
                        if (found == 2) {
                            TableauToFoundations(T0, Diamonds);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }
                        }
                        if (found == 3) {
                            TableauToFoundations(T0, Clubs);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }

                        }
                        if (found == 4) {
                            TableauToFoundations(T0, Spades);
                            if (T0.isEmpty()) {
                                T0.stackRefill();
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Move To which Foundation? ");
                        found = Integer.parseInt(scan.next());
                        if (found == 1) {
                            TableauToFoundations(T1, Hearts);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        if (found == 2) {
                            TableauToFoundations(T1, Diamonds);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        if (found == 3) {
                            TableauToFoundations(T1, Clubs);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        if (found == 4) {
                            TableauToFoundations(T1, Spades);
                            if (T1.isEmpty()) {
                                T1.stackRefill();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Move To which Foundation? ");
                        found = Integer.parseInt(scan.next());
                        if (found == 1) {
                            TableauToFoundations(T2, Hearts);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        if (found == 2) {
                            TableauToFoundations(T2, Diamonds);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        if (found == 3) {
                            TableauToFoundations(T2, Clubs);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        if (found == 4) {
                            TableauToFoundations(T2, Spades);
                            if (T2.isEmpty()) {
                                T2.stackRefill();
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Move To which Foundation? ");
                        found = Integer.parseInt(scan.next());
                        if (found == 1) {
                            TableauToFoundations(T3, Hearts);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        if (found == 2) {
                            TableauToFoundations(T3, Diamonds);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        if (found == 3) {
                            TableauToFoundations(T3, Clubs);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        if (found == 4) {
                            TableauToFoundations(T3, Spades);
                            if (T3.isEmpty()) {
                                T3.stackRefill();
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Move To which Foundation? ");
                        found = Integer.parseInt(scan.next());
                        if (found == 1) {
                            TableauToFoundations(T4, Hearts);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        if (found == 2) {
                            TableauToFoundations(T4, Diamonds);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        if (found == 3) {
                            TableauToFoundations(T4, Clubs);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        if (found == 4) {
                            TableauToFoundations(T4, Spades);
                            if (T4.isEmpty()) {
                                T4.stackRefill();
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Move To which Foundation? ");
                        found = Integer.parseInt(scan.next());
                        if (found == 1) {
                            TableauToFoundations(T5, Hearts);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        if (found == 2) {
                            TableauToFoundations(T5, Diamonds);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        if (found == 3) {
                            TableauToFoundations(T5, Clubs);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        if (found == 4) {
                            TableauToFoundations(T5, Spades);
                            if (T5.isEmpty()) {
                                T5.stackRefill();
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Move To which Foundation? ");
                        found = Integer.parseInt(scan.next());
                        if (found == 1) {
                            TableauToFoundations(T6, Hearts);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        if (found == 2) {
                            TableauToFoundations(T6, Diamonds);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        if (found == 3) {
                            TableauToFoundations(T6, Clubs);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        if (found == 4) {
                            TableauToFoundations(T6, Spades);
                            if (T6.isEmpty()) {
                                T6.stackRefill();
                            }
                        }
                        break;
                }
            }
            if (input == 6) {
                System.exit(0);
            }
            
            input = 0;
        }

    }

    private static ArrayList<String> shuffledDeck() {
        ArrayList<String> deck = new ArrayList<String>();

        String[] suit = new String[]{"H", "D", "C", "S"};
        for (int i = 2; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i + suit[j]);
            }
        }

        Collections.shuffle(deck);

        return deck;
    }

    private static boolean StartFlip(Tableau<String> tab) {
        return tab.push(tab.remove());
        
    }

    private static String DrawDeck(Waste<String> waste, Deck<String> deck) {
        return waste.push(deck.pop());
    }

    private static Waste<String> WasteToFoundation(Waste<String> waste, Foundations<String> foundation) {
        String wasteSuit = waste.peek();
        String foundSuit = foundation.peek();
        if (wasteSuit.charAt(1) == foundSuit.charAt(1) && wasteSuit.charAt(0) == foundSuit.charAt(0) + 1) {
            foundation.push(waste.pop());
        } else {
            System.out.println("Not Compatible");
        }
        return waste;
    }

    private static Tableau<String> WasteToTableau(Waste<String> waste, Tableau<String> tab) {
        String wasteSuit = waste.peek();
        String tabSuit = tab.sPeek();
        if (wasteSuit.charAt(1) == 'H' && tabSuit.charAt(1) != 'D' && tabSuit.charAt(1) != 'H' && wasteSuit.charAt(0) == tabSuit.charAt(0) - 1) {
            tab.push(waste.pop());
        } else {
            System.out.println("Not Compatible");
        }
        if (wasteSuit.charAt(1) == 'D' && tabSuit.charAt(1) != 'H' && tabSuit.charAt(1) != 'D' && wasteSuit.charAt(0) == tabSuit.charAt(0) - 1) {
            tab.push(waste.pop());
        } else {
            System.out.println("Not Compatible");
        }
        if (wasteSuit.charAt(1) == 'C' && tabSuit.charAt(1) != 'S' && tabSuit.charAt(1) != 'C' && wasteSuit.charAt(0) == tabSuit.charAt(0) - 1) {
            tab.push(waste.pop());
        } else {
            System.out.println("Not Compatible");
        }
        if (wasteSuit.charAt(1) == 'S' && tabSuit.charAt(1) != 'C' && tabSuit.charAt(1) != 'S' && wasteSuit.charAt(0) == tabSuit.charAt(0) - 1) {
            tab.push(waste.pop());
        } else {
            System.out.println("Not Compatible");
        }
        return tab;
    }

    private static Tableau<String> TableauToTableau(Tableau<String> tab1, Tableau<String> tab2) {
        if (tab1.isEmpty()) {
            System.out.println("Tableau Empty");
        }
        if (tab2.isEmpty()) {
            tab2.push(tab1.pop());
        } 
        if(tab1.isEmpty()==false && tab2.isEmpty()==false){
            String tab1Suit = tab1.sPeek();
            String tab2Suit = tab2.sPeek();
            if(tab1Suit.charAt(1) == 'H' && tab2Suit.charAt(1) =='S'){
                tab2.push(tab1.pop());
                return tab2;
            }
            if(tab1Suit.charAt(1) == 'H' && tab2Suit.charAt(1) =='C'){
                tab2.push(tab1.pop());
                return tab2;
            }
            if(tab1Suit.charAt(1) == 'D' && tab2Suit.charAt(1) =='S'){
                tab2.push(tab1.pop());
                return tab2;
            }
            if(tab1Suit.charAt(1) == 'D' && tab2Suit.charAt(1) =='C'){
                tab2.push(tab1.pop());
                return tab2;
            }
            if(tab1Suit.charAt(1) == 'S' && tab2Suit.charAt(1) =='H'){
                tab2.push(tab1.pop());
                return tab2;
            }
            if(tab1Suit.charAt(1) == 'S' && tab2Suit.charAt(1) =='D'){
                tab2.push(tab1.pop());
                return tab2;
            }
            if(tab1Suit.charAt(1) == 'C' && tab2Suit.charAt(1) =='H'){
                tab2.push(tab1.pop());
                return tab2;
            }
            if(tab1Suit.charAt(1) == 'C' && tab2Suit.charAt(1) =='D'){
                tab2.push(tab1.pop());
                return tab2;
            }
            
        }
        return tab1;
    }
    

    private static Tableau<String> TableauToFoundations(Tableau<String> tab, Foundations<String> foundation) {
        String tabSuit = tab.sPeek();
        String foundSuit = foundation.peek();
        if (tabSuit.charAt(1) == foundSuit.charAt(1) && tabSuit.charAt(0) == foundSuit.charAt(0) + 1) {
            foundation.push(tab.pop());
        } else {
            System.out.println("Not Compatible");
        }
        return tab;
    }
    private static int WinChecker(Foundations<String> Hearts,Foundations<String> Diamonds,Foundations<String> Clubs,Foundations<String> Spades){
        if(Hearts.peek() == "13H" && Diamonds.peek() == "13D" && Clubs.peek() == "13C" && Spades.peek() == "13S"){
            System.out.println("YOU WIN!!");
            return 6;
        }
        else{
            return 0;
        }
    }

}
