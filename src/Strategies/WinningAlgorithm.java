package Strategies;

import java.util.HashMap;
import Module.Board;
import Module.Cell;
import Module.Move;
import Module.Player;

public class WinningAlgorithm {
    // row number ->hashmap for that row
     HashMap<Integer,HashMap<Character,Integer>> rowMaps = new HashMap<>();
    // column number ->hashmap for that column
    HashMap<Integer,HashMap<Character,Integer>> colMaps = new HashMap<>();

    HashMap<Character,Integer> leftDiagonalMap = new HashMap<>();
    HashMap<Character,Integer> rightDiagonalMap = new HashMap<>();

    public boolean checkWinner(Board board,Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character character = move.getPlayer().getSymbol().getChar();

        //check row
        if(!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }
       HashMap<Character,Integer> currowmap = rowMaps.get(row);
        if(!currowmap.containsKey(character)){
            currowmap.put(character,1);

        }else{
            currowmap.put(character,currowmap.get(character)+1);
        }
        if(currowmap.get(character)==board.getSize()){
            return true;
        }
        //check column
        if(!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }
        HashMap<Character,Integer> curcolmap = colMaps.get(col);
        if(!curcolmap.containsKey(character)) {
            curcolmap.put(character, 1);
        }
        else{
            curcolmap.put(character,curcolmap.get(character)+1);
        }
        if(curcolmap.get(character)==board.getSize()){
            return true;
        }
        // check left diagonal
        if(row==col){
            if(!leftDiagonalMap.containsKey(character)){
                leftDiagonalMap.put(character,1);
            }else{
                leftDiagonalMap.put(character,leftDiagonalMap.get(character)+1);
            }
            if(leftDiagonalMap.get(character)==board.getSize()){
                return true;
            }
        }
        // check right diagonal
        if(row+col==board.getSize()-1){
            if(!rightDiagonalMap.containsKey(character)){
                rightDiagonalMap.put(character,1);
            }else{
                rightDiagonalMap.put(character,rightDiagonalMap.get(character)+1);
            }
            if(rightDiagonalMap.get(character)==board.getSize()){
                return true;
            }
        }
        return false;
    }

}
