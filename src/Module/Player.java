package Module;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);


    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {
        // Ask user where they want to place their symbol
        System.out.println("Enter row  number to place your symbol");
        int row = scanner.nextInt();
        System.out.println("Enter column number to place your symbol");
        int col = scanner.nextInt();
        return new Move(this, new Cell(row, col));


    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }


}
