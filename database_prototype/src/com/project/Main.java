package com.project;

/*
language	: Java
author		: xaaphrodite
date		: 20-02-2021
github		: https://github.com/xaaphrodite
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFileChooser;


public class Main {
// Program Beginning----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner Input = new Scanner(System.in);
        String userInput;
        boolean display = true;
        
        try {
        	while (display) {
                ClearScreen();
                System.out.print("xaaphrodite database\n"
                		+ "1. list databse\n"
                		+ "2. add database\n"
                		+ "3. edit database\n"
                		+ "4. remove database\n"
                		+ "5. exit\n");
                
                System.err.println("\nyour choice?");
                userInput = Input.next();

                switch (userInput) {
                    case "1":
                    	ClearScreen();
                    //  System.out.println("---show database---");
                        ListDatabase();
                        break;
                    case "2":
                    	ClearScreen();
                        System.out.println("---add database---");
                        // cari data
                        break;
                    case "3":
                    	ClearScreen();
                        System.out.println("---edit database---");
                        // tambah data
                        break;
                    case "4":
                    	ClearScreen();
                        System.out.println("---remove database---");
                        // ubah data
                        break;
                    case "5":
                        ClearScreen();
                        System.out.println("---exit---");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("\nwrong choice");
                        continue;
                }

                display = choice("continue");
            }Input.close();
		} catch (Exception error) {
			// TODO: handle exception
		}
    }

    private static boolean choice(String message){
        Scanner Input = new Scanner(System.in);
        System.out.print(""+message+"[Y/n]? ");
        
        String userInput = Input.next();

        while(!userInput.equalsIgnoreCase("Y") && !userInput.equalsIgnoreCase("y") &&
        	  !userInput.equalsIgnoreCase("N") && !userInput.equalsIgnoreCase("n")) {
            System.err.println("wrong choice [Y/n]");
            System.out.print("\n"+message+"[Y/n]? ");
            userInput = Input.next();
        } 
        
        return userInput.equalsIgnoreCase("y");
    }

    private static void ClearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex){
            System.err.println("cant clear screen your PC is pootato!");
        }
	}
     
// Core Program----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
    
    private static void ListDatabase() throws IOException{
    	FileReader fInput;
        BufferedReader bufferInput;
        JButton open = new JButton();
        JFileChooser file = new JFileChooser();

        file.setCurrentDirectory(new java.io.File(""));
        file.setDialogTitle("Hemllo World!");
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (file.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {	
        } 
        try {
            fInput = new FileReader(file.getSelectedFile().getAbsolutePath());
            bufferInput = new BufferedReader(fInput);
        } catch (Exception error){
            System.err.println("File not found!");
            return;
        }


        System.out.println("\n|No |\tYear              |\tAuthor          |     \tPublisher     |          \tTitle                           |");
        System.out.println("+---+---------------------+---------------------+---------------------+-------------------------------------------------+");
        
        String data = bufferInput.readLine();
        int nomorData = 0;
        while(data != null) {
            nomorData++;

            StringTokenizer stringToken = new StringTokenizer(data,",");

            stringToken.nextToken();
            System.out.printf("| %-2s", nomorData);
            System.out.printf("| %-20s", stringToken.nextToken());
            System.out.printf("| %-20s", stringToken.nextToken());
            System.out.printf("| %-20s", stringToken.nextToken());
            System.out.printf("| %-20s", stringToken.nextToken());
            System.out.print("\n");

            data = bufferInput.readLine();
        }

        System.out.println("+---+---------------------+---------------------+---------------------+-------------------------------------------------+");
    
    }

}




















