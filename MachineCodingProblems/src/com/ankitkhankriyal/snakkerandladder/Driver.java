package com.ankitkhankriyal.snakkerandladder;

import com.ankitkhankriyal.snakkerandladder.model.Ladder;
import com.ankitkhankriyal.snakkerandladder.model.Player;
import com.ankitkhankriyal.snakkerandladder.model.Snake;
import com.ankitkhankriyal.snakkerandladder.service.SnakeAndLadderGameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int noOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<>();
        for(int i = 0;i<noOfSnakes;i++){
            int startPosition=scanner.nextInt();
            int endPosition=scanner.nextInt();
            snakes.add(new Snake(startPosition,endPosition));
        }
        int noOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<>();
        for(int i=0;i<noOfLadders;i++){
            int startPosition = scanner.nextInt();
            int endPosition = scanner.nextInt();
            ladders.add(new Ladder(startPosition,endPosition));
        }
        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for(int i=0;i<noOfPlayers;i++){
            String name=scanner.next();
            players.add(new Player(name));
        }
        SnakeAndLadderGameService snakeAndLadderGameService = new SnakeAndLadderGameService();
        snakeAndLadderGameService.setSnakes(snakes);
        snakeAndLadderGameService.setLadders(ladders);
        snakeAndLadderGameService.setPlayers(players);
        snakeAndLadderGameService.startGame();

    }
}
