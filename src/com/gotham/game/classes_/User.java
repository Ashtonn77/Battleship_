package com.gotham.game.classes_;

import com.gotham.game.interfaces_.GridPrinter;
import com.gotham.game.interfaces_.Weapon;

import java.util.stream.IntStream;

public class User extends Grid implements Weapon {
            
    public User(){
        
    }
    
    GridPrinter printer = (grid) -> {

        int i = 0;
        System.out.print(" ");
        IntStream.rangeClosed(1, 10).forEach(k -> System.out.print(" " + k));
        System.out.println("");

        for(var row : grid){

            System.out.print(firstColumn[i++]);

            for(var col : row)
                System.out.print(" " + col);

            System.out.println("");

        }
        
    };
    
    
    @Override
    public boolean fire() {
        printer.print(new Grid().battlefield);
        return false;
    }
}
