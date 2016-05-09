package com.company;
import java.util.*;

/**
 * Created by moyjoht on 5/2/2016.
 */
public class Deck {
    private ArrayList d = new ArrayList();

    public void setCards(){
        for (int i = 0; i < 52; i++){
            Card c = new Card();

            if (i / 13 == 0)
                c.setSuit("Spades");
            else if (i / 13 == 1)
                c.setSuit("Clubs");
            else if (i / 13 == 2)
                c.setSuit("Diamonds");
            else if (i / 13 == 3)
                c.setSuit("Hearts");

            if (i % 13 == 0)
                c.setKind("Two");
            else if (i % 13 == 1)
                c.setKind("Three");
            else if (i % 13 == 2)
                c.setKind("Four");
            else if (i % 13 == 3)
                c.setKind("Five");
            else if (i % 13 == 4)
                c.setKind("Six");
            else if (i % 13 == 5)
                c.setKind("Seven");
            else if (i % 13 == 6)
                c.setKind("Eight");
            else if (i % 13 == 7)
                c.setKind("Nine");
            else if (i % 13 == 8)
                c.setKind("Ten");
            else if (i % 13 == 9)
                c.setKind("Jack");
            else if (i % 13 == 10)
                c.setKind("Queen");
            else if (i % 13 == 11)
                c.setKind("King");
            else if (i % 13 == 12)
                c.setKind("Ace");

            d.add(c);
        }
    }

    public Card removeCard(int index){
        return (Card)d.remove(index);
    }
}
