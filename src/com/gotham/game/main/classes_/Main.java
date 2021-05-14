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

        setUpPlayerOne(gridInstance1, shipUtil1);

        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\nPlayer 2, place your ships on the game field");
        new GridPrinter(gridInstance2).print(gridInstance2.getBlankGrid());
        SetUp s2 = new SetUp(gridInstance2, shipUtil2);
        s2.placeShips();

        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        while (User.GAME_OVER != -1) {

            if (i % 2 == 0)
                player1.fire(player2);
            else
                player2.fire(player1);

            i++;
        }


    }

    static void setUpPlayerOne(Grid gridInstance1, ShipUtil shipUtil1) {


        System.out.println("Player 1, place your ships on the game field");
        new GridPrinter(gridInstance1).print(gridInstance1.getBlankGrid());
        SetUp s1 = new SetUp(gridInstance1, shipUtil1);
        s1.placeShips();
        return;

    }

}

