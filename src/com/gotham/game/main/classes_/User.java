package com.gotham.game.main.classes_;

import com.gotham.game.helper.classes_.GridPrinter;
import com.gotham.game.helper.classes_.SetUp;
import com.gotham.game.interfaces_.UserInput;
import com.gotham.game.interfaces_.Weapon;

import java.util.Arrays;

public class User implements Weapon {

    private int id;
    int[] shipLives;
    Grid grid;
    
    public User(int id, Grid grid) {
        this.id = id;
        shipLives = new int[]{2, 6, 12, 16, 25};
        this.grid = grid;
    }
        
    @Override
    public boolean fire() {

        try {

//            String[] userInput = UserInput.getInput();
//
//            int row = (int) Character.toUpperCase(userInput[0].charAt(0)) - 65;
//            int column = Integer.parseInt(userInput[0].substring(1)) - 1;
//          
//            grid.getBattlefield()[row][column] = 'X';
//            new GridPrinter(grid).print(grid.getBattlefield());
//            
//            int life = grid.getHitGrid()[row][column];
//            shipLives[life-1] -= life;
//            
//            System.out.println(Arrays.toString(shipLives));

        } catch (Exception e) {

            System.out.println(e.getClass().getSimpleName());
            
        }

        return false;

    }
}
