/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.miketa.Controller;

import pl.miketa.Communication.Communication;
import pl.miketa.GameLogic.GameLogic;

/**
 * class that controls whole project using class model and class view
 *
 * @author Szymon Miketa
 * @version 1.0
 */
public class Controller {

    /**
     * field consisting GameLogic that uses different algorithms on data
     */
    private GameLogic model;

    /**
     * field consisting class Communication that show messages and takes output
     * of user
     */
    private Communication view;

    /**
     * field of type char indicating which player's turn it is
     */
    private char currentPlayer;

    /**
     * field of type int that contains result code of last turn
     */
    private int result;

    /**
     * class contructor
     *
     * @param model parameter is of type model, it definies the class's field
     * @param view parameter is of type view, it definies the class's field
     */
    public Controller(GameLogic model, Communication view) {
        this.model = model;
        this.view = view;
    }

    /**
     * main method that calls view and model methods
     */
    public void run() {
        //Initializing game array
        model.InitializeArray();
        boolean loop = true;
        String coordinates;
        //Starting game loop(break from it if someone wins or there is a draw)
        while (loop) {
            view.ShowArray(model.GetSize(), model.GetBoard());
            currentPlayer = 'X';
            boolean repeatInputRequest = true;
            coordinates = view.GetCoordinates(currentPlayer);
            repeatInputRequest = model.CheckValidity(coordinates);
            //Loops until input is correct
            while (!repeatInputRequest) {
                view.ShowMessage(3, currentPlayer);
                coordinates = view.GetCoordinates(currentPlayer);
                repeatInputRequest = model.CheckValidity(coordinates);
            }
            result = model.Turn((int) coordinates.charAt(0) - 64 - 1, (int) coordinates.charAt(1) - 48 - 1, currentPlayer);
            view.ShowMessage(result, currentPlayer);
            if (result == 1 || result == 0) {
                view.ShowArray(model.GetSize(), model.GetBoard());
                break;
            }
            view.ShowArray(model.GetSize(), model.GetBoard());
            currentPlayer = '0';
            coordinates = view.GetCoordinates(currentPlayer);
            repeatInputRequest = model.CheckValidity(coordinates);
            //Loops until input is correct
            while (!repeatInputRequest) {
                view.ShowMessage(3, currentPlayer);
                coordinates = view.GetCoordinates(currentPlayer);
                repeatInputRequest = model.CheckValidity(coordinates);
            }
            result = model.Turn((int) coordinates.charAt(0) - 64 - 1, (int) coordinates.charAt(1) - 48 - 1, currentPlayer);
            view.ShowMessage(result, currentPlayer);
            if (result == 1) {
                view.ShowArray(model.GetSize(), model.GetBoard());
                break;
            }
        }
        view.ShowEndMessage();
    }
}
