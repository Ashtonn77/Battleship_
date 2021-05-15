package com.gotham.game.main.classes_;

import com.gotham.game.helper.classes_.GridPrinter;
import com.gotham.game.helper.classes_.SetUp;
import com.gotham.game.helper.classes_.ShipUtil;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        
        ShipUtil shipUtil1 = new ShipUtil();
        ShipUtil shipUtil2 = new ShipUtil();

        Grid gridInstance1 = new Grid();
        Grid gridInstance2 = new Grid();

        User player1 = new User(1, gridInstance2, gridInstance1);
        User player2 = new User(2, gridInstance1, gridInstance2);

        setUpPlayer(
                gridInstance1,
                "Player 1, place your ships on the game field",
                new SetUp(gridInstance1, shipUtil1)
        );
        
        promptForNextPlayerStart();

        setUpPlayer(
                gridInstance2,
                "\nPlayer 2, place your ships on the game field",
                new SetUp(gridInstance2, shipUtil2)
        );
        
        promptForNextPlayerStart();

        int i = 0;
        while (User.GAME_OVER != -1) {

            if (i % 2 == 0)
                player1.fire(player2);
            else
                player2.fire(player1);

            i++;
        }


    }

    private static void setUpPlayer(
            Grid gridInstance1,
            String message,
            SetUp setUp
    ) {
        System.out.println(message);
        new GridPrinter(gridInstance1).print(gridInstance1.getBlankGrid());    
        setUp.placeShips();

    }

    private static void promptForNextPlayerStart() {

        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

