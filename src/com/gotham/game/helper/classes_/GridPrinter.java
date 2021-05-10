package com.gotham.game.helper.classes_;

import com.gotham.game.interfaces_.Printer;
import com.gotham.game.main.classes_.Grid;

import java.util.stream.IntStream;

public class GridPrinter implements Printer{
    
    Grid grid;    
    public GridPrinter(Grid grid){
        this.grid = grid;
    }

    @Override
    public void print(int[][] board) {

        int j = 0;
        System.out.print(" ");
        IntStream.rangeClosed(1, 10).forEach(k -> System.out.print(" " + k));
        System.out.println();

        for(var row : board){

            System.out.print(grid.getFirstColumn()[j++]);

            for(var col : row)
                System.out.print(" " + col);

            System.out.println();

        }
        
    }

    @Override
    public void print(char[][] board) {

        int i = 0;
        System.out.print(" ");
        IntStream.rangeClosed(1, 10).forEach(k -> System.out.print(" " + k));
        System.out.println();

        for(var row : board){

            System.out.print(grid.getFirstColumn()[i++]);

            for(var col : row)
                System.out.print(" " + col);

            System.out.println();

        }
        
    }


}
