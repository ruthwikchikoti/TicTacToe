package Module;

import Exceptions.InvalidExceptions;
import Strategies.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private WinningAlgorithm winningAlgorithm;


    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameState getGameState() {
        return gameState;
    }


    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.winner = null;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winningAlgorithm = new WinningAlgorithm();
    }


    public void setWinner(Player winner){
        this.winner = winner;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex){

        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }
    public  void PrintBoard( ){

        this.board.printBoard();
    }
    public void makeMove() throws InvalidExceptions {
        Player currentPlayer = players.get(nextPlayerMoveIndex);

        System.out.println("Player " + currentPlayer.getName() + " turn") ;
        // move that current player wants to make
        Move move = currentPlayer.makeMove(board);

        // game class will validate the move before making it
        if(!validateMove(move)){
          throw  new InvalidExceptions("Invalid Move made by " + currentPlayer.getName());
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cellTOChange = board.getBoard().get(row).get(col);
        cellTOChange.setPlayer(currentPlayer);
        cellTOChange.setCellState(CellState.FILLED);
        Move finalMove = new Move(currentPlayer, cellTOChange);
        moves.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();
        // check if the current move is winning move or not
        if(winningAlgorithm.checkWinner(board, finalMove)){
            gameState = GameState.ENDED ;
            winner = currentPlayer;
        }

    }

    public void printBoard() {
        this.board.printBoard();

    }
    private boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if (row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()) {
            return false;
        }
        return board.getBoard().get(row).get( col).getCellState().equals(CellState.EMPTY);
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
