package com.gotham.game.main.classes_;

import com.gotham.game.helper.classes_.GridPrinter;
import com.gotham.game.interfaces_.UserInput;
import com.gotham.game.interfaces_.Weapon;
import com.gotham.game.validation_.classes_.AlphaNumericChecker;
import com.gotham.game.validation_.classes_.BoundaryValidator;

import java.io.IOException;

public class User implements Weapon {

    public static int GAME_OVER = 0;
    private int id;
    int[] shipLives;
    int userLife;
    Grid enemyGrid;
    Grid playerGrid;

    public User(int id, Grid enemyGrid, Grid playerGrid) {

        this.id = id;
        shipLives = new int[]{2, 6, 9, 16, 25};
        userLife = 58;
        this.enemyGrid = enemyGrid;
        this.playerGrid = playerGrid;

    }

    @Override
    public void fire(User user) {

        try {

            System.out.println("\nPlayer " + this.id + ", it's your turn:");
            new GridPrinter(enemyGrid).print(enemyGrid.getBlankGrid());
            System.out.println("---------------------");
            new GridPrinter(playerGrid).print(playerGrid.getBattlefield());


            String[] userInput = UserInput.getInput();
            if(userInput.length > 2){
                System.out.println("\nError: Invalid input! Try Again");
                fire(user);
            }

            if(!new AlphaNumericChecker().validate( userInput[0].charAt(0),'A',
                    userInput[0].charAt(1),'0')){

                displayErrorMessageAndRerun("\nError: Invalid input! Try Again", user);

            }

            int row = (int) Character.toUpperCase(userInput[0].charAt(0)) - 65;
            int column = Integer.parseInt(userInput[0].substring(1)) - 1;

            if(!new BoundaryValidator().validate(row, row, column, column))
                displayErrorMessageAndRerun("\nError! Wrong ship location! Try again:", user);

            char cellValue = enemyGrid.getBattlefield()[row][column];

            if(cellValue == 'O' || cellValue == 'X'){

                enemyGrid.getBattlefield()[row][column] = 'X';
                enemyGrid.getHitGrid()[row][column] = 'X';

                int life = enemyGrid.getPointGrid()[row][column];
                enemyGrid.getPointGrid()[row][column] -= enemyGrid.getPointGrid()[row][column];
                user.userLife -= life;

                if (user.userLife <= 0){

                    System.out.println("\nYou sank the last ship. You won. Congratulations!");
                    this.GAME_OVER = -1;
                    return;

                }


                if(life > 0) shipLives[life-1] -= life;

                if(life > 0 && shipLives[life - 1] <= 0){
                    System.out.println("\nYou sank a ship");
                }else{
                    System.out.println("You hit a ship!");
                }

            }else{

                enemyGrid.getHitGrid()[row][column] = 'M';
                System.out.println("\nYou missed!");

            }


        } catch (Exception e) {


            fire(user);

        }

        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayErrorMessageAndRerun(String message, User user){
        System.out.println(message);
        fire(user);
    }

}
