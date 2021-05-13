package com.gotham.game.main.classes_;

import com.gotham.game.helper.classes_.GridPrinter;
import com.gotham.game.helper.classes_.SetUp;
import com.gotham.game.interfaces_.UserInput;
import com.gotham.game.interfaces_.Weapon;
import com.gotham.game.validation_.classes_.AlphaNumericChecker;
import com.gotham.game.validation_.classes_.BoundaryValidator;

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

            String[] userInput = UserInput.getInput();
            if(userInput.length > 2){
                System.out.println("Error: Invalid input! Try Again");
                fire();
            }

            if(!new AlphaNumericChecker().validate( userInput[0].charAt(0),'A', 
                                                    userInput[0].charAt(1),'0')){
                
                displayErrorMessageAndRerun("Error: Invalid input! Try Again");

            }
            
            int row = (int) Character.toUpperCase(userInput[0].charAt(0)) - 65;
            int column = Integer.parseInt(userInput[0].substring(1)) - 1;

            if(!new BoundaryValidator().validate(row, row, column, column))
                displayErrorMessageAndRerun("\nError! Wrong ship location! Try again:");
                        
            char cellValue = grid.getBattlefield()[row][column];
            
            if(cellValue == 'O' || cellValue == 'X'){
                
                grid.getBattlefield()[row][column] = 'X';
                grid.getHitGrid()[row][column] = 'X';
                
                int life = grid.getPointGrid()[row][column];
                grid.getPointGrid()[row][column] -= grid.getPointGrid()[row][column];
                
                if(life > 0) shipLives[life-1] -= life;
                 
                if(life > 0 && shipLives[life - 1] <= 0){
                    System.out.println("You sunk a ship");
                }else{
                    System.out.println("You hit a ship!");
                }

            }else{
                
                grid.getHitGrid()[row][column] = 'M';
                System.out.println("You missed!");

            }
            new GridPrinter(grid).print(grid.getHitGrid());
            

        } catch (Exception e) {

            System.out.println(e.getClass().getSimpleName());
            fire();
            
        }

        return false;

    }
    
    //TODO: duplicated code -> fix
    private void displayErrorMessageAndRerun(String message){
        System.out.println(message);
        fire();
    }
    
}
