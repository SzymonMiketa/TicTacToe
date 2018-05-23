/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.miketa.TicTacToe;

import pl.miketa.Communication.Communication;
import pl.miketa.Controller.Controller;
import pl.miketa.GameLogic.GameLogic;

/**
 * class that consists main method
 * @author Szymon Miketa
 * @version 1.0
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int size;
        int inRowToWin;

        size = 3;
        inRowToWin = 3;
        
        GameLogic model = new GameLogic(size, inRowToWin);
        Communication view = new Communication();
        Controller controller = new Controller(model, view);
        controller.run();
    }
    
}
