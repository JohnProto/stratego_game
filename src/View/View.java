package View;
import Model.Board.Board;
import Model.Piece.Piece;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class View extends JFrame{
    private Board Board;
    private ArrayList<MyButton> available = new ArrayList<>();

    public View(ArrayList<Piece> Red, ArrayList<Piece> Blue){
        for(int i=0; i<80; i++){
            if(i < 30){
                MyButton bu = new MyButton();
                bu.setIcon(Blue.get(i).getimg());
                bu.setEmpty(false);
                bu.setSea(false);
                bu.setColor("Blue");
                bu.setCurrentCell(Blue.get(i));
                available.add(bu);
            }
            else if(i==30 || i==31 || i==34 || i==35 || i==38 || i==39 || i==40 || i==41 || i==44 || i==45 || i==48 || i==49){
                MyButton bu = new MyButton();
                bu.Empty();
                available.add(bu);
            }
            else if(i==32 || i==33 || i==36 || i==37 || i==42 || i==43 || i==46 || i==47){
                MyButton bu = new MyButton();
                bu.setEnabled(false);
                bu.wet();
                available.add(bu);
            }
            else{
                MyButton bu = new MyButton();
                bu.setIcon(Red.get(i-50).getimg());
                bu.setEmpty(false);
                bu.setSea(false);
                bu.setColor("Red");
                bu.setCurrentCell(Red.get(i-50));
                available.add(bu);
            }
        }
        initialize();
    }

    public ArrayList<MyButton> getavailable(){
        return available;
    }

    public void initialize(){
        JFrame biggerFrame = new JFrame();
        biggerFrame.setLayout(new BorderLayout());
        biggerFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel Arena = new JPanel();
        Arena.setLayout(new GridLayout(8,10));
        for(int i=0; i<80; i++){
            Arena.add(available.get(i));
        }
        biggerFrame.add(Arena, BorderLayout.CENTER);
        biggerFrame.pack();
        biggerFrame.setVisible(true);
    }

    public void makeMatch(ArrayList<Piece> red, ArrayList<Piece> blue){

    }

    public void update(double WinRate, ArrayList<Piece> EnemyDead, int TotalAttacks){

    }

    public void makeAvailable(MyButton piece){

    }

    public void resetAvailable(){

    }

    public boolean isAvailable(MyButton piece){
        return true;
    }

    public void nextTurn(){

    }
}
