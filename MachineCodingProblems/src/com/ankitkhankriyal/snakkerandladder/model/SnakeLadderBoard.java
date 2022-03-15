package com.ankitkhankriyal.snakkerandladder.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeLadderBoard {
    private int size;
    private List<Snake> snakes = new ArrayList<>();
    private List<Ladder> ladders=new ArrayList<>();
    private Map<String,Integer> personPieces=new HashMap<>();


    public SnakeLadderBoard( int size,List<Snake> snakes, List<Ladder> ladders, Map<String, Integer> personPieces) {
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.personPieces = personPieces;
    }

    public SnakeLadderBoard(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public Map<String, Integer> getPersonPieces() {
        return personPieces;
    }

    public void setPersonPieces(Map<String, Integer> personPieces) {
        this.personPieces = personPieces;
    }
}
