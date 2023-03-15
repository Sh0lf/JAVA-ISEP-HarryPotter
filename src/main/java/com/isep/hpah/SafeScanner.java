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

    public void closeScanner(){
        this.sc.close();
    }
}
