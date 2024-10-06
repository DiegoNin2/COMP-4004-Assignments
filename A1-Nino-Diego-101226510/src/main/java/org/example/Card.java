package org.example;

import java.io.PrintWriter;

public class Card implements Comparable<Card> {
    private String type;
    private String value;
    private String name;

    //getters
    public String getType() {return type;}
    public String getValue() {return value;}
    public String getName() {return name;}

    //setters
    public void setType(String cType) {type = cType;}
    public void setValue(String cVal) {value = cVal;}
    public void setName(String cName) {name = cName;}

    public String toString() {
        return name + ", value = " + value;
    }

    @Override
    public int compareTo(Card c) {
        //compare types first
        int typeCompare = compareHelper(type, c.getType());
        if (typeCompare != 0) {
            return typeCompare;
        }

        //compare values
        //im assuming they can be integers
        int currentCardVal = Integer.parseInt(value);
        int otherCardVal = Integer.parseInt(c.getValue());
        int valueCompare = Integer.compare(currentCardVal, otherCardVal);
        if (valueCompare != 0) {
            return valueCompare;
        }

        //Sword & Horse case
        if (type.equals("Weapon") && type.equals(c.getType())) {
            if (name.equals("Sword") && c.getName().equals("Horse")) {
                return -1;
            } else if (name.equals("Horse") && c.getName().equals("Sword")) {
                return 1;
            }
        }

        //sort by name otherwise
        return name.compareTo(c.getName());
    }

    //used to compare types
    private int compareHelper(String t1, String t2) {
        if (t1.equals("Foe") && t2.equals("Weapon")) {
            return -1;
        } else if (t1.equals("Weapon") && t2.equals("Foe")) {
            return 1;
        }
        //must be same if neither
        return t1.compareTo(t2);
    }
}
