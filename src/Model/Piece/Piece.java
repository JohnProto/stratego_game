package Model.Piece;
import javax.swing.*;

public abstract class Piece{
    private int power;
    private String name;
    private ImageIcon img;
    private boolean canRevive = true;

    Piece(ImageIcon newimg, int newpower, String newname){
        this.img = newimg;
        this.power = newpower;
        this.name = newname;
    }
    /**
     * <b>Getters<b/>
     * @return the current power, coordinates and name*/
    public int getpower(){
        return power;
    }

    public String getname(){
        return name;
    }

    public ImageIcon getimg(){
        return img;
    }

    public boolean getcanrevive(){
        return canRevive;
    }
    public Piece attack(Piece target){
        return null;
    }
}
