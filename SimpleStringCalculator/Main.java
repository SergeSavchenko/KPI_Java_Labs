package com.company;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] Arr;
        String[] FinalArr;

        FileWorks read = new FileWorks();
        FileWorks write = new FileWorks();
        CountWords count = new CountWords();

        System.out.println("Enter Initial File path: ");
        read.SetFileName();
        read.OpenToRead();
        Arr = read.ArrCreate();

        while (true) {
            System.out.println("Enter Final File path: ");
            write.SetFileName();
            if ((read.GetFileName()).equals(write.GetFileName())) {
                System.out.println("Please, use another Final file path.");
            } else
                break;
        }

        count.SetDelimiter();
        count.SetUnion();

        FinalArr = count.Count(Arr);

        write.OpenToWrite();
        write.WriteInFile(FinalArr);
        read.ShowNumbers("Initial File:");
        System.out.println();
        write.ShowNumbers("Final File:");
    }
}
