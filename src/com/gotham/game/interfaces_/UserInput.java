package com.gotham.game.interfaces_;

import java.util.Scanner;

public interface UserInput {

    static String[] getInput() {

        Scanner in = new Scanner(System.in);
        String response = in.nextLine();

        return response.split(" ");
        
    }
    
}
