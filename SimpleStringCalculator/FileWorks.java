package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileWorks {
    private String fileNamePath;
    private String[] Arr = new String[0];
    private BufferedReader fileR;
    private FileWriter fileW;

    public String GetFileName() {
        return fileNamePath;
    }

    public void SetFileName() {
        Scanner ans = new Scanner(System.in);
        fileNamePath = ans.nextLine();
    }

    public void OpenToRead() throws IOException {
        fileR = new BufferedReader(new FileReader(fileNamePath));
    }

    public void OpenToWrite() throws IOException {
        fileW = new FileWriter(fileNamePath, false);
    }

    public String[] ArrCreate() throws IOException {
        String line;
        ArrayWorks anArr = new ArrayWorks();
        while ((line = fileR.readLine()) != null) {
            Arr = anArr.AddElement(Arr, line);
        }
        return Arr;
    }

    public void WriteInFile(String[] numbers) throws IOException {
        for (String number : numbers) {
            fileW.write(number);
            fileW.append("\n");
            fileW.flush();
        }
        fileW.close();
    }

    public void ShowNumbers(String text) throws IOException {
        String line;
        BufferedReader fileF = new BufferedReader(new FileReader(fileNamePath));
        System.out.println(text);
        int i = 0;
        while ((line = fileF.readLine()) != null) {
            System.out.println(i + " " + line);
            i++;
        }
    }
}
