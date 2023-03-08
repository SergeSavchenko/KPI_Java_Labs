package com.company;

public class ArrayWorks {
    public String[] AddElement(String[] oldOne, String newLine) {
        int newLen = oldOne.length+1;

        String[] newOne = new String[newLen];

        if (newLen != 1) {
            for (int i = 0; i < newLen-1; i++)
                newOne[i] = oldOne[i];
        }

        newOne[newLen-1] = newLine;

        return newOne;
    }
}

// /Users/anton/Desktop/КПИ/ООП/test.csv