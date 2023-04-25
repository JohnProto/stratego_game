package Model.Piece;

import javax.swing.*;

public class SpeceialMovablePiece extends MovablePiece{
    private boolean canrevive;

    SpeceialMovablePiece(ImageIcon newimg, int newpower, String newname, boolean newcanrivive){
        super(newimg, newpower, newname);
        this.canrevive = newcanrivive;
    }

    public Piece Simpleattack(Piece target){
        if(this.getpower() > target.getpower()){
            return this;
        }
        else{
            return target;
        }
    }

    public Piece attack(Piece target){
        if(this.getname().equals("Dwarf")){
            if(target.getname().equals("Trap")){
                return this;
            }
            else{
                return Simpleattack(target);
            }
        }
        else if(this.getname().equals("Slayer")){
            if(target.getname().equals("Dragon")){
                return this;
            }
            else{
                return Simpleattack(target);
            }
        }
        else{
            return Simpleattack(target);
        }
    }
}
