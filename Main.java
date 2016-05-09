package com.company;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // DECLARATIONS
            Scanner user_input = new Scanner(System.in);

            // create new deck
            Deck d = new Deck();

            // create 2 new hands, one for each player
            Hand user = new Hand();
            Hand computer = new Hand();

            String winner = "";
        // END DECLARATIONS

        housekeeping(d, user, computer, user_input);

        while (user.numCards() > 0 && computer.numCards() > 0){
            System.out.println(user.getName() + "'s Hand: \t\t" + user.numCards() + " cards");
            System.out.println(computer.getName() + "'s Hand: \t" + computer.numCards() + " cards\n");
            System.out.println("=================================================");
            user_input.nextLine();
            winner = battle(user, computer, user_input);
        }
        finishUp(winner, user.getName());
    }

    public static void housekeeping(Deck d, Hand user, Hand computer, Scanner user_input){
        String name;
        System.out.println("Welcome to the card game War\n");
        System.out.print("Please enter your name: ");
        name = user_input.next();
        user.setName(name);
        computer.setName("Computer");

        // assign values to the deck's cards
        d.setCards();

        // "deal" cards to the players, randomly removing them from the deck and adding them to the players' hands
        dealCards(d, user, computer);
        System.out.println("\n\t***Dealing the cards***\n");
        System.out.println("=================================================\n");
        user_input.nextLine();
    }

    public static void finishUp(String winner, String user_name){
        if (winner.equals("user")) {
            System.out.println(user_name + " WINNNNNS!");
            for (int i = 0; i < 50; i++)
                System.out.println(user_name + " is the winner of the war!!!");
        }
        else {
            for (int i = 0; i < 50; i++)
                System.out.println("You lose the war!!! 8-( 8-( 8-(");
        }
    }

    public static void dealCards(Deck d, Hand p1, Hand p2){
        Random randomGenerator = new Random();

        for (int i = 52; i > 0; i--){
            int randomInt = randomGenerator.nextInt(i);

            Card c = d.removeCard(randomInt);

            if (i % 2 == 0)
                p1.addCard(c);
            else
                p2.addCard(c);
        }
    }

    public static String battle(Hand p1, Hand p2, Scanner user_input){
        String winner;

        Card c1 = p1.getCard(0);
        Card c2 = p2.getCard(0);

        p1.removeCard(0);
        p2.removeCard(0);

        System.out.println(p1.getName() + ": ");
        c1.displayCard();
        System.out.println();

        System.out.println(p2.getName() + ": ");
        c2.displayCard();
        System.out.println();

        if (c1.getValue() > c2.getValue()){
            p1.addCard(c1);
            p1.addCard(c2);

            System.out.println(p1.getName() + " Wins\n");
            winner = "user";
        }
        else if (c1.getValue() < c2.getValue()){
            p2.addCard(c1);
            p2.addCard(c2);

            System.out.println(p2.getName() + " Wins\n");
            winner = "computer";
        }
        else {
            System.out.println("We have a Tie!");

            Card c3 = p1.getCard(0);
            Card c4 = p2.getCard(0);
            p1.removeCard(0);
            p2.removeCard(0);

            user_input.nextLine();
            String tieWinner = battle(p1, p2, user_input);
            if (tieWinner.equals("user")){
                p1.addCard(c1);
                p1.addCard(c2);
                p1.addCard(c3);
                p1.addCard(c4);

                winner = "user";
            }
            else {
                p2.addCard(c1);
                p2.addCard(c2);
                p2.addCard(c3);
                p2.addCard(c4);
                winner = "computer";
            }
        }

        return winner;
    }
}