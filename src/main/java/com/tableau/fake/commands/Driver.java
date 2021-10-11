package com.tableau.fake.commands;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.println("use Help Command to get all your answers!. Hit EXIT to terminate");
            System.out.print("/# ");

             input = sc.nextLine();
             if(input.equalsIgnoreCase("EXIT"))
                 break;

            try {
                CommandExecutor.executeCommand(input.split(" "));
            } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
                e.printStackTrace();
            }
        } while(true);
    }
}
