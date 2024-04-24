import Controller.GameController;

import java.util.List;
import java.util.Scanner;

import Exceptions.InvalidExceptions;
import Module.Game;
import Module.Player;
import Module.Symbol;
import Module.PlayerType;
import Module.BotDifficulityLevel;
import Module.Bot;
import Module.GameState;


public class Main {

    public static void main(String[] args) throws InvalidExceptions {
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();
//        System.out.println("Enter the dimension of the board");
        int dimension = 3;
        List<Player> players = List.of(new Player("Player1", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Player2", new Symbol('O'), PlayerType.BOT, BotDifficulityLevel.EASY));

        Game game = gameController.startGame(dimension, players);
         while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            // -> print the board
            gameController.printBoard(game);
            // -> player makes a move
            gameController.makeMove(game);


        }
        if (!gameController.checkState(game).equals(GameState.ENDED)) {
            game.setGameState(GameState.DRAW);
            System.out.println("Game Draw");
        } else {
            gameController.printBoard(game);
            System.out.println("Winner is " + game.getWinner().getName());
        }



    }
}