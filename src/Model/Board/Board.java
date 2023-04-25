package Model.Board;
import View.MyButton;
import java.util.ArrayList;

public class Board{
    private int round = 1;
    private ArrayList<MyButton> buttons = new ArrayList<>();

    public void addButton(MyButton but){
        buttons.add(but);
    }

    public int getRound(){
        return round;
    }

    public void increaseRound(){
        round++;
    }
}
