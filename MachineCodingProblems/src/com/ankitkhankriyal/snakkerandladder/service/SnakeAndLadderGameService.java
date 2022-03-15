package com.ankitkhankriyal.snakkerandladder.service;

import com.ankitkhankriyal.snakkerandladder.model.Ladder;
import com.ankitkhankriyal.snakkerandladder.model.Player;
import com.ankitkhankriyal.snakkerandladder.model.Snake;
import com.ankitkhankriyal.snakkerandladder.model.SnakeLadderBoard;

import java.util.*;

public class SnakeAndLadderGameService {
    private SnakeLadderBoard snakeLadderBoard;
    private int boardSize;
    private int initialNoOfPlayers;
    private Queue<Player> playersQueue;
    private boolean isGameCompleted;
    private int noOfDices;

    private static final Integer INITIAL_BOARD_SIZE=100;
    private static final Integer INITIAL_DICE=1;

    public SnakeAndLadderGameService(int boardSize) {
        this.snakeLadderBoard = new SnakeLadderBoard(boardSize);
        this.boardSize = boardSize;
        this.playersQueue = new LinkedList<>();
        this.isGameCompleted=false;
        this.noOfDices=SnakeAndLadderGameService.INITIAL_DICE;
    }
    public SnakeAndLadderGameService(){
        this(SnakeAndLadderGameService.INITIAL_BOARD_SIZE);
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getNoOfDices() {
        return noOfDices;
    }

    public void setNoOfDices(int noOfDices) {
        this.noOfDices = noOfDices;
    }

    /**
     * Initilaized Board
     *
     */

    public void setSnakes(List<Snake> snakes){
        snakeLadderBoard.setSnakes(snakes);
    }
    public void setLadders(List<Ladder> ladders){
        snakeLadderBoard.setLadders(ladders);
    }
    public void setPlayers(List<Player> players){
        initialNoOfPlayers=players.size();
        Map<String,Integer> playersPieces=new HashMap<>();
        for(Player player:players){
            playersQueue.add(player);
            playersPieces.put(player.getId(),0);
        }
        snakeLadderBoard.setPersonPieces(playersPieces);
    }
    /**
     * Core Business Logic for the Game
     */
    public void startGame(){
        while(!isGameCompleted()){
            int diceRollNumber = getDiceNumberOnRoll();
            Player currentPlayer = playersQueue.poll();
            moveCurrentPlayerPosition(currentPlayer,diceRollNumber);
            if(hasPlayerWon(currentPlayer)){
                System.out.println("Player "+currentPlayer.getName()+" has won the game");
                snakeLadderBoard.getPersonPieces().remove(currentPlayer.getId());
            }else{
                playersQueue.add(currentPlayer);
            }
        }
    }

    private boolean hasPlayerWon(Player currentPlayer) {
        int currentPosition=snakeLadderBoard.getPersonPieces().get(currentPlayer.getId());
        int winningPosition=boardSize;
        return currentPosition==winningPosition;
    }

    private void moveCurrentPlayerPosition(Player currentPlayer, int diceRollNumber) {
        int prevPosition= snakeLadderBoard.getPersonPieces().get(currentPlayer.getId());
        int newPosition = diceRollNumber+ prevPosition;
        if(newPosition>boardSize){
            newPosition=prevPosition;
        }else{
            newPosition=getPlayerPositionAfterSnakeAndLadders(newPosition);
        }
        snakeLadderBoard.getPersonPieces().put(currentPlayer.getId(),newPosition);
        System.out.println("Player "+currentPlayer.getName()+" has rolled "+diceRollNumber+" and moved from "+prevPosition+" to "+newPosition);
    }

    private int getPlayerPositionAfterSnakeAndLadders(int newPosition) {
        int prevPosition;
        do{
            prevPosition = newPosition;
            for(Snake snake:snakeLadderBoard.getSnakes()){
                if(newPosition==snake.getStart()){
                    newPosition=snake.getEnd();
                }
            }
            for(Ladder ladder:snakeLadderBoard.getLadders()){
                if(newPosition==ladder.getStart()){
                    newPosition=ladder.getEnd();
                }
            }
        }while(prevPosition != newPosition);
        return newPosition;
    }

    private int getDiceNumberOnRoll() {
        return DiceService.rollDice();
    }

    private  boolean isGameCompleted() {
        int currentPlayers = playersQueue.size();
        return currentPlayers<initialNoOfPlayers;
    }


}
