/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.miketa.GameLogic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Szymon Miketa
 * @version 1.0
 */
public class GameLogicTest {
    
    public GameLogicTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetBoard method, of class GameLogic.
     */
    @Test
    public void testGetBoard() {
        System.out.println("GetBoard");
        GameLogic instance = new GameLogic(3, 3);
        instance.InitializeArray();
        char[][] expResult = new char[3][3];
        char[][] expResult2 = new char[3][3];
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                expResult[x][y] = '.';
                expResult2[x][y] = '.';
            }
        }
        expResult2[1][2] = 'X';
        GameLogic instance2 = new GameLogic(3, 3);
        instance2.InitializeArray();
        instance2.Turn(1, 2, 'X');
        char[][] result2 = instance2.GetBoard();
        char[][] result = instance.GetBoard();
        assertArrayEquals("Arrays are not equal!", expResult, result);
        assertArrayEquals("Arrays are not equal!", expResult2, result2);
    }

    /**
     * Test of GetSize method, of class GameLogic.
     */
    @Test
    public void testGetSize() {
        System.out.println("GetSize");
        GameLogic instance = new GameLogic(3, 3);
        int expResult = 3;
        int result = instance.GetSize();
        assertEquals(expResult, result);
        GameLogic instance2 = new GameLogic(10, 3);
        int expResult2 = 10;
        int result2 = instance2.GetSize();
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of CheckValidity method, of class GameLogic.
     */
    @Test
    public void testCheckValidity() {
        System.out.println("CheckValidity");
        String answer = "";
        String answer2 = "2";
        String answer3 = "B2";
        String answer4 = "2b";
        String answer5 = "2BKEtu";
        GameLogic instance = new GameLogic(3, 3);
        instance.InitializeArray();
        boolean expResult = false;
        boolean expResult2 = true;
        boolean result = instance.CheckValidity(answer);
        boolean result2 = instance.CheckValidity(answer2);
        boolean result3 = instance.CheckValidity(answer3);
        boolean result4 = instance.CheckValidity(answer4);
        boolean result5 = instance.CheckValidity(answer5);
        assertEquals("Boolean is not equal!", expResult, result);
        assertEquals("Boolean is not equal!", expResult, result2);
        assertEquals("Boolean is not equal!", expResult2, result3);
        assertEquals("Boolean is not equal!", expResult, result4);
        assertEquals("Boolean is not equal!", expResult, result5);

    }

    /**
     * Test of InitializeArray method, of class GameLogic.
     */
    @Test
    public void testInitializeArray() {
        System.out.println("InitializeArray");
        GameLogic instance = new GameLogic(3, 3);
        instance.InitializeArray();
        char[][] expResult = new char[3][3];
        for(int x = 0; x < 3; x++)
        {
            for(int y = 0; y < 3; y++)
            {
                expResult[x][y] = '.';
            }
        }
        char[][] result = instance.GetBoard();
        Assert.assertArrayEquals("Arrays are not the same!", expResult, result);
    }

    /**
     * Test of Turn method, of class GameLogic.
     */
    @Test
    public void testTurn() {
        System.out.println("Turn");
        GameLogic instance = new GameLogic(3, 3);
        GameLogic instance2 = new GameLogic(3, 3);
        int expResult = 0;
        int expResult2 = 1;
        int expResult3 = 2;
        instance.InitializeArray();
        instance2.InitializeArray();
        for(int i = 0; i < 3; i++)
        {           
            for(int y = 0; y < 3; y++)
            {
                if(i == 2 && y == 2)
                {
                    break;
                }
                instance.ChangeArray(i, y, 'X');
            }
        }
        GameLogic instance3 = new GameLogic(3, 3);
        instance3.InitializeArray();
        instance3.ChangeArray(0, 0, 'X');
        instance3.ChangeArray(0, 2, 'X');
        GameLogic instance4 = new GameLogic(3, 3);
        instance4.InitializeArray();
        instance4.ChangeArray(0, 0, 'X');
        instance4.ChangeArray(1, 1, 'X');
        GameLogic instance5 = new GameLogic(3, 3);
        instance5.InitializeArray();
        instance5.ChangeArray(0, 0, 'X');
        instance5.ChangeArray(2, 0, 'X');
        GameLogic instance6 = new GameLogic(3, 3);
        instance6.InitializeArray();
        instance6.ChangeArray(0, 1, 'X');

        int result = instance.Turn(2, 2, 'X');
        int result2 = instance2.Turn(0, 0, 'X');
        int result3 = instance3.Turn(0, 1, 'X');
        int result4 = instance4.Turn(2, 2, 'X');
        int result5 = instance5.Turn(1, 0, 'X');
        int result6 = instance6.Turn(0, 0, 'X');
        
        
        assertEquals(expResult, result);
        assertEquals(expResult3, result2);
        assertEquals(expResult2, result3);
        assertEquals(expResult2, result4);
        assertEquals(expResult2, result5);
        assertEquals(expResult3, result6);
    }

    /**
     * Test of CheckWinCondition method, of class GameLogic.
     */
    @Test
    public void testCheckWinCondition() {
        System.out.println("CheckWinCondition");
        GameLogic instance = new GameLogic(3, 3);
        GameLogic instance2 = new GameLogic(3, 3);
        GameLogic instance3 = new GameLogic(3, 3);
        int expResult = 0;
        int expResult2 = 1;
        int expResult3 = 2;
        instance.InitializeArray();
        instance2.InitializeArray();
        instance3.InitializeArray();
        instance3.ChangeArray(0, 0, 'X');
        for(int i = 0; i < 3; i++)
        {
            instance2.ChangeArray(i, 0, 'X');
            for(int y = 0; y < 3; y++)
            {
                instance.ChangeArray(i, y, 'X');
            }
        }
        GameLogic instance4 = new GameLogic(3, 3);
        instance4.InitializeArray();
        instance4.ChangeArray(0, 0, 'X');
        instance4.ChangeArray(0, 2, 'X');
        instance4.ChangeArray(0, 1, 'X');
        GameLogic instance5 = new GameLogic(3, 3);
        instance5.InitializeArray();
        instance5.ChangeArray(0, 0, 'X');
        instance5.ChangeArray(1, 1, 'X');
        instance5.ChangeArray(2, 2, 'X');
        GameLogic instance6 = new GameLogic(3, 3);
        instance6.InitializeArray();
        instance6.ChangeArray(0, 0, 'X');
        instance6.ChangeArray(2, 0, 'X');
        instance6.ChangeArray(1, 0, 'X');
        GameLogic instance7 = new GameLogic(3, 3);
        instance7.InitializeArray();
        instance7.ChangeArray(0, 1, 'X');
        instance7.ChangeArray(0, 0, 'X'); 

        int result = instance.CheckWinCondition(2, 2, 'X');
        int result2 = instance2.CheckWinCondition(2, 0, 'X');
        int result3 = instance3.CheckWinCondition(0, 0, 'X');
        int result4 = instance4.CheckWinCondition(0, 1, 'X');
        int result5 = instance5.CheckWinCondition(2, 2, 'X');
        int result6 = instance6.CheckWinCondition(1, 0, 'X');
        int result7 = instance7.CheckWinCondition(0, 0, 'X');
        
        
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult2, result4);
        assertEquals(expResult2, result5);
        assertEquals(expResult2, result6);
        assertEquals(expResult3, result7);
    }

    /**
     * Test of CheckForDraw method, of class GameLogic.
     */
    @Test
    public void testCheckForDraw() {
        System.out.println("CheckForDraw");
        GameLogic instance = new GameLogic(3, 3);
        GameLogic instance2 = new GameLogic(3, 3);
        GameLogic instance3 = new GameLogic(3, 3);
        boolean expResult = false;
        boolean expResult2 = true;
        boolean expResult3 = true;
        instance.InitializeArray();
        instance2.InitializeArray();
        instance3.InitializeArray();
        for(int i = 0; i < 3; i++)
        {
            instance2.ChangeArray(i, 0, 'X');
            for(int y = 0; y < 3; y++)
            {
                instance.ChangeArray(i, y, 'X');
            }
        }
        
        boolean result = instance.CheckForDraw();
        boolean result2 = instance2.CheckForDraw();
        boolean result3 = instance3.CheckForDraw();
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult2, result3);
    }

    /**
     * Test of CheckForWin method, of class GameLogic.
     */
    @Test
    public void testCheckForWin() {
        System.out.println("CheckForWin");      
        GameLogic instance = new GameLogic(3, 3);
        instance.InitializeArray();
        instance.ChangeArray(0, 0, 'X');
        instance.ChangeArray(0, 2, 'X');
        instance.ChangeArray(0, 1, 'X');
        GameLogic instance2 = new GameLogic(3, 3);
        instance2.InitializeArray();
        instance2.ChangeArray(0, 0, 'X');
        instance2.ChangeArray(1, 1, 'X');
        instance2.ChangeArray(2, 2, 'X');
        GameLogic instance3 = new GameLogic(3, 3);
        instance3.InitializeArray();
        instance3.ChangeArray(0, 0, 'X');
        instance3.ChangeArray(2, 0, 'X');
        instance3.ChangeArray(1, 0, 'X');
        GameLogic instance4 = new GameLogic(3, 3);
        instance4.InitializeArray();
        instance4.ChangeArray(0, 1, 'X');
        instance4.ChangeArray(0, 0, 'X'); 
        GameLogic instance5 = new GameLogic(3, 3);
        instance5.InitializeArray();
        int expResult = 1;
        int expResult2 = 2;
        int result = instance.CheckForWin(0, 1, 'X');
        int result2 = instance2.CheckForWin(2, 2, 'X');
        int result3 = instance3.CheckForWin(1, 0, 'X');
        int result4 = instance4.CheckForWin(1, 0, 'X');
        int result5 = instance5.CheckForWin(1, 0, 'X');       
        assertEquals(expResult, result);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
        assertEquals(expResult2, result4);
        assertEquals(expResult2, result5);

    }
    
    /**
     * Test of ChangeArray method, of class GameLogic.
     */
    @Test
    public void testChangeArray()
    {
        System.out.println("CnangeArray");
        GameLogic instance = new GameLogic(3, 3);
        instance.InitializeArray();
        instance.ChangeArray(1, 1, 'X');
        char [][] expResult = new char[3][3];
        for(int i = 0; i < 3; i++)
        {
            for(int y = 0; y < 3; y++)
            {
                expResult[i][y] = '.';
            }
        }
        expResult[1][1] = 'X';
        
        char [][] result = instance.GetBoard();
        
        Assert.assertArrayEquals("Arrays not equal!", expResult, result);
    }
    
}
