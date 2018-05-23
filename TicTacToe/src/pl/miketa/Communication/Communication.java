/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.miketa.Communication;

import java.util.Scanner;

/**
 * class that is responsible for communication with user
 * @author Szymon Miketa
 * @version 1.0
 */
public class Communication {
    
     /**
     * showing board to user
     * @param size parameter of type int indicating size of bard
     * @param board paramter of type two-dimensional arrays of chars, that will be displayed
     */
     public void ShowArray(int size, char [][] board)
    { 
        System.out.print(" ");
        for(int i = 1; i <= size; i++)
        {
            System.out.print(" " + Integer.toString(i));
        }
        System.out.print("\n");
        for(int x = 0; x < size; x++)
        {
            System.out.print((char) (x + 65));
            for(int y = 0; y < size; y++)
            {
                System.out.print(" " + board[x][y]);
                
            }
            System.out.print("\n");
        }
    }
     
    
     /**
     * shows end message for user after games finished and waits for input
     */
     public void ShowEndMessage()
     {
         System.out.print("Type anything to finish\n");
         Scanner reader = new Scanner(System.in);
         reader.next();
     }
     
      /**
     * shows message to user depending on parameters
     * @param message parameter of type int deciding which message will be shown
     * @param player parameter of type char helping indicating which player won
     */
     
     public void ShowMessage(int message, char player)
     {
         switch(message)
         {
             case 0:
                 System.out.print("Draw!\n");
                 break;
             case 1:
                 System.out.print(player + " won!\n");
                 break;
             case 2:
                 break;
             case 3:
                 System.out.print("Wrong coordinates!\n");
                 break;
                 
             default:
     
         }
     }
     
     /**
     * gets input from user
     * @param player parameter of type char. Used to tell user whose turn it is
     * @return returns string written in stream by user
     */
     public String GetCoordinates(char player)
     {
         System.out.print("It's " + player + " turn\nPlease insert coordinates in format ColumnRow (example: A2)\n");
         Scanner reader = new Scanner(System.in);
         String answer = reader.next();                
         return answer;
         
     }
}
