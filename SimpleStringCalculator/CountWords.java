package com.company;

import java.util.Scanner;

public class CountWords {
    private char delimiter, union;
    private final char quote = '"';

    public void SetDelimiter() {
        while(true) {
            System.out.println("Enter delimiter: ");
            Scanner d = new Scanner(System.in);
            String test = d.nextLine();
            if (test.length() != 1) {
                System.out.println("Delimiter must be 1 char long. Try again.");
            } else {
                delimiter = test.charAt(0);
                break;
            }
        }
    }

    public void SetUnion() {
        while(true) {
            System.out.println("Enter union char: ");
            Scanner d = new Scanner(System.in);
            String test = d.nextLine();
            if (test.length() != 1) {
                System.out.println("Union char must be 1 char long. Try again.");
            } else {
                union = test.charAt(0);
                break;
            }
        }
    }

    public String addToNumLine (String numLine, int len) {
        if (numLine.length() == 0) {
            numLine += Integer.toString(len);
        } else {
            numLine += union + Integer.toString(len);
        }
        return numLine;
    }

    public String[] Count(String[] Array) {
        int inputLen = Array.length;
        String[] fArray = new String[inputLen];

        for (int i = 0; i < inputLen; i++) {
            String numLine = "";
            char[] chars = Array[i].toCharArray();
            int len = 0;
            boolean closed = true;
            boolean first = (chars[0] == quote && chars[1] != quote);

            for (int j = 0; j < chars.length; j++) {
                if (j+1 < chars.length) {
                    if (chars[j] == quote) {
                        if (chars[j+1] == quote) {
                            j++;
                            len++;
                            if (j+1 ==  chars.length) {
                                numLine = this.addToNumLine(numLine, len);
                            }
                        } else if (first) {
                            if (closed) {
                                closed = false;
                            } else {
                                closed = true;
                                first = false;
                            }
                        } else
                            len++;
                    } else if (chars[j] == delimiter) {
                        if (closed) {
                            numLine = this.addToNumLine(numLine, len);
                            len = 0;
                            first = (chars[j+1] == quote && chars[j+2] != quote);
                        } else
                            len++;
                    } else
                        len++;
                } else {
                    if ((chars[j] == quote && !first) || (chars[j] != quote && chars[j] != delimiter))
                        len++;
                    numLine = this.addToNumLine(numLine, len);
                }
            }
            fArray[i] = numLine;
        }
        return fArray;
    }
}

// /Users/anton/Desktop/КПИ/ООП/test2.csv