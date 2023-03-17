package com.isep.hpah;
import java.io.IOException;
import java.util.Scanner;
import java.io.InputStream;

public class SafeScanner {
    private Scanner sc;
    public SafeScanner(InputStream is){
        this.sc = new Scanner(is);
    }

    public int getInt(){
        System.out.println("-> \n");
        int input = this.sc.nextInt();
        this.sc.nextLine();
        return input;
    }

    public String getString(){
        System.out.println("-> \n");
        return this.sc.nextLine();
    }

    public void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //function to clear console (technically skipping / doing empty lines)
    public void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //function for separator
    public void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //function to print a heading
    public void printHeading(String title) {
        printSeparator(title.length());
        System.out.println(title);
        printSeparator(title.length());
    }

    //clears Console and does the heading afterwards
    public void printHeader(String title){
        clearConsole();
        printHeading(title);
    }

    public void closeScanner(){
        this.sc.close();
    }
}
