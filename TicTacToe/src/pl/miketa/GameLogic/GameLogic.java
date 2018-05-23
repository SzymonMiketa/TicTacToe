package pl.miketa.GameLogic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * class that is responsible for evaluations
 * @author Szymon Miketa
 * @version 1.0
 */
public class GameLogic {
    
    /**
     * size of game array
     */
    
    private final int size;
    
    /**
     * amount of characters in a row needed to win
     */
    private final int inRowToWin;
    
    /**
     * two-dimensional array working as game board
     */
    private final char[][] board;
    
    /**
     * Default constructor
     * @param size parameter is of type int, it definies the size of game array
     * @param inRowToWin parameter is of type int, it definies how many character in a row you need to win
     */
    public GameLogic(int size, int inRowToWin)
    {
        this.size = size;
        this.inRowToWin = inRowToWin;
        this.board = new char[size][size];
    }    
    
    /**
     * returning board
     * @return returns board
     */
    public char[][] GetBoard()
    {
        return board;
    }
    
    /**
     * returning size
     * @return returns size
     */
    public int GetSize()
    {
        return size;
    }
    
    /**
     * Checks the string given by user for correction. String need to contain exactly 2 characters and they need to strictly correspond to the game board
     * @return returns true if string is correst, else returns false
     * @param answer parameter of type String containing user input
     */
    public boolean CheckValidity(String answer)
    {
         if(answer.length() != 2 || (int)answer.charAt(0) < 65 || (int)answer.charAt(0) > 65 + size || (int)answer.charAt(1) - 48 < 1 || (int)answer.charAt(1) - 48 > size || board[(int)answer.charAt(0) - 64 - 1][(int)answer.charAt(1) - 48 - 1] != '.')
         {
             return false;
         }   
         return true;
    }
    
    /**
     * Initialize array with dots
     */
    public void InitializeArray()
    {
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                board[x][y] = '.';
            }
        }
    }
    
    /**
     * Fills specific arrays postion with a character given
     * @param x specifies column of array
     * @param y specifies row of array
     * @param character specifies the character that will be used to fill position
     */
    public void ChangeArray(int x, int y, char character)
    {
        board[x][y] = character;
    }
    
    /**
     * Invokes method that fill arrays with player mark and check the win condition of the game
     * @param x specifies column of array
     * @param y specifies row of array
     * @param currentPlayer specifies the player mark
     * @return returns 0 for draw, 1 if player won, 2 if noting happened
     */
    
    public int Turn(int x, int y, char currentPlayer)
    {
        ChangeArray(x, y, currentPlayer);
        return CheckWinCondition(x, y, currentPlayer);
    }
    
    /**
     * Invokes methods that check if there was a draw or if player won
     * @param x specifies column of array
     * @param y specifies row of array
     * @param currentPlayer specifies the player mark
     * @return 0 for draw, 1 if player 2, 2 if nothing happened
     */
    public int CheckWinCondition(int x, int y, char currentPlayer)
    {
        if(CheckForDraw() == true)
        {
            return CheckForWin(x, y, currentPlayer);
        }
        return 0;
    }
    /**
     * Check the board for draw
     * @return returns false for draw and true for no draw
     */
    public boolean CheckForDraw()
    {
        for (int x = 0; x < size; x++)
		for (int y = 0; y < size; y++)
		{
			if (board[x][y] == '.')
				return true;
		}
	return false;
    }
    
    /**
     * Checks if specific player won
     * @param x specifies column of array
     * @param y specifies row of array
     * @param currentPlayer specifies the character mark
     * @return returns 1 if player won and 2 if the game is still on
     */
    
    public int CheckForWin(int x, int y, char currentPlayer)
    {
	int inRow = 0;
	int yTmp = -inRowToWin + 1;
	for (int xCheck = -inRowToWin + 1; xCheck < inRowToWin; xCheck++)
	{
		if (x + xCheck >= 0 && x + xCheck <= size - 1)
		{
			if (board[x + xCheck][y] == currentPlayer)
			{
				inRow++;
				if (inRow == 3)
				{
					return 1;
				}
			}
			else
			{
				inRow = 0;
			}
		}
	}
	inRow = 0;
	for (int xCheck = -inRowToWin + 1; xCheck < inRowToWin; xCheck++)
	{
		if (x + xCheck >= 0 && x + xCheck <= size - 1 && y + yTmp >= 0 && y + yTmp <= size - 1)
		{
			if (board[x + xCheck][y + yTmp] == currentPlayer)
			{
				inRow++;
				if (inRow == 3)
				{
					return 1;
				}
			}
			else
			{
				inRow = 0;
			}
		}
		yTmp++;
	}
	inRow = 0;
	yTmp = -inRowToWin + 1;
	for (int xCheck = inRowToWin - 1; xCheck > -inRowToWin; xCheck--)
	{
		if (x + xCheck >= 0 && x + xCheck <= size - 1 && y + yTmp >= 0 && y + yTmp <= size - 1)
		{
			if (board[x + xCheck][y + yTmp] == currentPlayer)
			{
				inRow++;
				if (inRow == 3)
				{
					return 1;
				}
			}
			else
			{
				inRow = 0;
			}
		}
		yTmp++;
	}
	inRow = 0;
	for (int yCheck = -inRowToWin + 1; yCheck < inRowToWin; yCheck++)
	{
		if (y + yCheck >= 0 && y + yCheck <= size - 1)
		{
			if (board[x][y + yCheck] == currentPlayer)
			{
				inRow++;
				if (inRow == 3)
				{
					return 1;
				}
			}
			else
			{
				inRow = 0;
			}
		}
	}
        return 2;
    }
}
