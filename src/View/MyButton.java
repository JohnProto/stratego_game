package View;
import Model.Piece.Piece;
import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton{
    private boolean isEmpty = false;
    private boolean isSea = false;
    private Piece currentCell = null;
    private String color;

    public void setColor(String newcolor){
        this.color = newcolor;
    }

    public String getColor(){
        return color;
    }

    public void setEmpty(boolean newempty){
        this.isEmpty = newempty;
    }
    public void setSea(boolean newsea){
        this.isSea = newsea;
    }
    public void setCurrentCell(Piece newpiece){
        this.currentCell = newpiece;
        this.isEmpty = false;
    }

    public boolean getIsEmpty(){
        return isEmpty;
    }

    public boolean getIsSea(){
        return isSea;
    }

    public void wet(){
        this.isSea = true;
        this.setBackground(Color.YELLOW);
        this.setColor("White");
    }

    public void Empty(){
        this.setBackground(Color.WHITE);
        this.setIcon(null);
        this.isEmpty = true;
        this.setColor("White");
    }

    public Piece getCurrentCell(){
        return currentCell;
    }
}
