package com.company;

/**
 * Created by moyjoht on 5/2/2016.
 */
public class Card {
    private String suit;
    private int value;
    private String kind;

    public void setSuit(String s){
        suit = s;
    }

    public void setKind(String k){
        kind = k;
        setValue();
    }

    private void setValue(){
        if (kind.equals("Two"))
            value = 1;
        else if (kind.equals("Three"))
            value = 2;
        else if (kind.equals("Four"))
            value = 3;
        else if (kind.equals("Five"))
            value = 4;
        else if (kind.equals("Six"))
            value = 5;
        else if (kind.equals("Seven"))
            value = 6;
        else if (kind.equals("Eight"))
            value = 7;
        else if (kind.equals("Nine"))
            value = 8;
        else if (kind.equals("Ten"))
            value = 9;
        else if (kind.equals("Jack"))
            value = 10;
        else if (kind.equals("Queen"))
            value = 11;
        else if (kind.equals("King"))
            value = 12;
        else if (kind.equals("Ace"))
            value = 13;
    }

    public int getValue(){
        return value;
    }

    public void displayCard(){
        System.out.println("\t" + kind + " of " + suit);
    }
}
