package Model.Piece;
import javax.swing.*;

public class MovablePiece extends Piece{

    MovablePiece(ImageIcon newimg, int newpower, String newname){
        super(newimg, newpower, newname);
    }

    
    public Piece attack(Piece target){
        if(this.getpower() > target.getpower()){
            return this;
        }
        else{
            return target;
        }
    }
}
