package Model.Player;
import Model.Piece.Piece;
import javax.management.InvalidAttributeValueException;
import java.util.ArrayList;

public class Player{
    private ArrayList<Piece> Alive = new ArrayList<>();
    private ArrayList<Piece> EnemyDead = new ArrayList<>();
    private double WinRate = 0;
    private int TotalAttacks;
    private int AttacksWon;
    private int Revives;

    public boolean IsAlive(Piece p){
        return true;
    }

    public void Kill(Piece alive){

    }

    public void revive(Piece dead){

    }

    public int getAttacksWon(){
        return AttacksWon;
    }

    public ArrayList<Piece> getAlive(){
        return Alive;
    }

    public int getEnemyDead(){
        return EnemyDead.size();
    }

    public int getRevives(){
        return Revives;
    }

    public double getWinRate(){
        return WinRate;
    }

    public int getTotalAttacks(){
        return TotalAttacks;
    }

    public void setWinRate(double newWinRate){
        this.WinRate = newWinRate;
    }

    public void setAlive(Piece x){
        Alive.add(x);
    }
}
