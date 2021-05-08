package com.gotham.game.helper.classes_;

import com.gotham.game.interfaces_.Printer;
import com.gotham.game.main.classes_.Grid;

import java.util.stream.IntStream;

public class GridPrinter extends Grid implements Printer {
    
    @Override
    public void print(char[][] grid) {

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
        
    }
}
