package com.company;
import java.util.*;

/**
 * Created by moyjoht on 5/3/2016.
 */
public class Hand {
    private ArrayList h = new ArrayList();
    String playerName;

    public void setName(String name){
        playerName = name;
    }

    public String getName(){
        return playerName;
    }

    public Card getCard(int index){
        return (Card)h.get(index);
    }

    public void addCard(Card c){
        h.add(c);
        return;
    }

    public Card removeCard(int index){
        return (Card)h.remove(index);
    }

    public int numCards(){
        return h.size();
    }
}
