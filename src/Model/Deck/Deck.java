package Model.Deck;

import Model.Piece.Piece;

import java.util.ArrayList;

public class Deck{
    private ArrayList<Piece> Deck = new ArrayList<>();

    Deck(ArrayList<Piece> newDeck){
        this.Deck = newDeck;
    }
}
