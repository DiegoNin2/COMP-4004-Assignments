package org.example;

import java.util.ArrayList;

public class Quest {
    private ArrayList<Card> stageSet;
    private int stageValue;

    public Quest() {
        stageSet = new ArrayList<Card>();
        stageValue = 0;
    }

    //getter
    public int getStageSize() {return stageSet.size();}
    public int getValue() {return stageValue;}
    public ArrayList<Card> getStageSet() {return stageSet;}

    public void addCard(Card c) {
        stageSet.add(c);
    }

    public void removeCard(Card c) {
        stageSet.remove(c);
    }

    public void removeAll() {
        stageSet.clear();
    }

    public boolean isStageEmpty() {
        return stageSet.isEmpty();
    }

    public Card getCardAt(int i) {
        return stageSet.get(i);
    }

    public void increaseValue() {
        int newStageVal = 0;
        for (int i = 0; i < stageSet.size(); i++) {
            switch(stageSet.get(i).getValue()) {
                case "5":
                    newStageVal += 5;
                    break;
                case "10":
                    newStageVal += 10;
                    break;
                case "15":
                    newStageVal += 15;
                    break;
                case "20":
                    newStageVal += 20;
                    break;
                case "25":
                    newStageVal += 25;
                    break;
                case "30":
                    newStageVal += 30;
                    break;
                case "35":
                    newStageVal += 35;
                    break;
                case "40":
                    newStageVal += 40;
                    break;
                case "50":
                    newStageVal += 50;
                    break;
                case "70":
                    newStageVal += 70;
                    break;
            }
        }
        stageValue = newStageVal;
    }

    public String displaySet() {
        String cardsInSet = "";
        for (int i = 0; i < stageSet.size(); i++) {
            if (i == stageSet.size()-1) {
                cardsInSet += stageSet.get(i).toString();
            } else {
                cardsInSet += stageSet.get(i).toString() + ", ";
            }
        }
        return cardsInSet;
    }

}
