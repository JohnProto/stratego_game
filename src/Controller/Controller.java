package Controller;
import Model.Piece.*;
import Model.Player.Player;
import View.MyButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import View.*;

public class Controller{
    private Player red = new Player();
    private Player blue = new Player();
    private ArrayList<MyButton> greenbuttons = new ArrayList<>();
    private MyButton tmp = null;
    private boolean whosturn;
    private View V;

    public Controller(){
        ImageIcon beastRiderB, dragonB, dwarfB, elfB, flagB, knightB, mageB, scoutB, slayerB, sorceressB, trapB, yeti;
        ImageIcon beastRiderR, dragonR, dwarfR, elfR, flagR, knightR, mageR, scoutR, slayerR, sorceressR, trapR, lavaBeast;
        dragonR = scale("images/RedPieces/dragonR.png");
        dragonB = scale("images/bluePieces/dragonB.png");
        mageR = scale("images/RedPieces/mageR.png");
        mageB = scale("images/bluePieces/mageB.png");
        knightR = scale("images/RedPieces/knightR.png");
        knightB = scale("images/bluePieces/knightB.png");
        sorceressR = scale("images/RedPieces/sorceressR.png");
        sorceressB = scale("images/bluePieces/sorceressB.png");
        elfR = scale("images/RedPieces/elfR.png");
        elfB = scale("images/bluePieces/elfB.png");
        beastRiderR = scale("images/RedPieces/beastRiderR.png");
        beastRiderB = scale("images/bluePieces/beastRiderB.png");
        dwarfR = scale("images/RedPieces/dwarfR.png");
        dwarfB = scale("images/bluePieces/dwarfB.png");
        scoutR = scale("images/RedPieces/scoutB.png");
        scoutB = scale("images/bluePieces/scoutB.png");
        slayerR = scale("images/RedPieces/slayerR.png");
        slayerB = scale("images/bluePieces/slayerB.png");
        trapR = scale("images/RedPieces/trapR.png");
        trapB = scale("images/bluePieces/trapB.png");
        flagR = scale("images/RedPieces/flagR.png");
        flagB = scale("images/bluePieces/flagB.png");
        lavaBeast = scale("images/RedPieces/lavaBeast.png");
        yeti = scale("images/bluePieces/yeti.png");
        red.setAlive(new Dragon(dragonR));
        blue.setAlive(new Dragon(dragonB));
        red.setAlive(new Mage(mageR));
        blue.setAlive(new Mage(mageB));
        for(int i=0; i<=1; i++){
            red.setAlive(new Knight(knightR));
            red.setAlive(new Sorceress(sorceressR));
            red.setAlive(new Elf(elfR));
            red.setAlive(new LavaBeast(lavaBeast));
            blue.setAlive(new Knight(knightB));
            blue.setAlive(new Sorceress(sorceressB));
            blue.setAlive(new Elf(elfB));
            blue.setAlive(new Yeti(yeti));
        }
        for(int i=0; i<=2; i++){
            red.setAlive(new BeastRider(beastRiderR));
            blue.setAlive(new BeastRider(beastRiderB));
        }
        for(int i=0; i<=4; i++){
            red.setAlive(new Dwarf(dwarfR));
            blue.setAlive(new Dwarf(dwarfB));
        }
        for(int i=0; i<=3; i++){
            red.setAlive(new Scout(scoutR));
            blue.setAlive(new Scout(scoutB));
        }
        red.setAlive(new Slayer(slayerR));
        blue.setAlive(new Slayer(slayerB));
        for(int i=0; i<=5; i++) {
            red.setAlive(new Trap(trapR));
            blue.setAlive(new Trap(trapB));
        }
        red.setAlive(new Flag(flagR));
        blue.setAlive(new Flag(flagB));
        Collections.shuffle(red.getAlive());
        Collections.shuffle(blue.getAlive());
        V = new View(red.getAlive(), blue.getAlive());
        ArrayList<MyButton> holder = V.getavailable();
        for(int i=0; i<80; i++){
            holder.get(i).addMouseListener(new ActionListener());
        }
    }

    public ImageIcon scale(String filepath){
        ImageIcon imageIcon = new ImageIcon(filepath);
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(80, 120,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }

    public class ActionListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e){
            MyButton B = (MyButton)e.getSource();
            if(greenbuttons.contains(B)){
                move(tmp, B);
                tmp.Empty();
                for(MyButton greenbutton : greenbuttons){
                    greenbutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
                greenbuttons.clear();
                tmp = null;
            }
            else{
                tmp = B;
                for(MyButton greenbutton : greenbuttons){
                    greenbutton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                }
                greenbuttons.clear();
                if(!B.getIsEmpty() && !B.getIsSea()){
                    if(!B.getCurrentCell().getname().equals("Trap") && !B.getCurrentCell().getname().equals("Flag")){
                        int coordinates = V.getavailable().indexOf(B);
                        if(!B.getCurrentCell().getname().equals("Scout")){
                            if(coordinates - 10 >= 0){
                                if(!V.getavailable().get(coordinates - 10).getIsSea()){
                                    if(!V.getavailable().get(coordinates - 10).getColor().equals(V.getavailable().get(coordinates).getColor())){
                                        V.getavailable().get(coordinates - 10).setBorder(BorderFactory.createLineBorder(Color.green, 8));
                                        greenbuttons.add(V.getavailable().get(coordinates - 10));
                                    }
                                }
                            }
                            if(coordinates % 10 != 9){
                                if(!V.getavailable().get(coordinates + 1).getIsSea()){
                                    if(!V.getavailable().get(coordinates + 1).getColor().equals(V.getavailable().get(coordinates).getColor())){
                                        V.getavailable().get(coordinates + 1).setBorder(BorderFactory.createLineBorder(Color.green, 8));
                                        greenbuttons.add(V.getavailable().get(coordinates + 1));
                                    }
                                }
                            }
                            if(coordinates % 10 != 0){
                                if(!V.getavailable().get(coordinates - 1).getIsSea()){
                                    if(!V.getavailable().get(coordinates - 1).getColor().equals(V.getavailable().get(coordinates).getColor())){
                                        V.getavailable().get(coordinates - 1).setBorder(BorderFactory.createLineBorder(Color.green, 8));
                                        greenbuttons.add(V.getavailable().get(coordinates - 1));
                                    }
                                }
                            }
                            if(coordinates + 10 <80){
                                if(!V.getavailable().get(coordinates + 10).getIsSea()){
                                    if(!V.getavailable().get(coordinates + 10).getColor().equals(V.getavailable().get(coordinates).getColor())){
                                        V.getavailable().get(coordinates + 10).setBorder(BorderFactory.createLineBorder(Color.green,8));
                                        greenbuttons.add(V.getavailable().get(coordinates + 10));
                                    }
                                }
                            }
                        }
                        else{
                            int tmpcoordinates = coordinates;
                            while(tmpcoordinates - 10 >= 0){
                                if(!V.getavailable().get(tmpcoordinates - 10).getIsSea()){
                                    if(!V.getavailable().get(tmpcoordinates - 10).getColor().equals(V.getavailable().get(coordinates).getColor())){
                                        V.getavailable().get(tmpcoordinates - 10).setBorder(BorderFactory.createLineBorder(Color.green, 8));
                                        greenbuttons.add(V.getavailable().get(tmpcoordinates - 10));
                                        if(!V.getavailable().get(tmpcoordinates - 10).getIsEmpty()){
                                            break;
                                        }
                                        tmpcoordinates -= 10;
                                    }
                                    else{
                                        break;
                                    }
                                }
                                else{
                                    break;
                                }
                            }
                            tmpcoordinates = coordinates;
                            while(tmpcoordinates % 10 != 9){
                                if(!V.getavailable().get(tmpcoordinates + 1).getIsSea()){
                                    if(!V.getavailable().get(tmpcoordinates + 1).getColor().equals(V.getavailable().get(coordinates).getColor())){
                                        V.getavailable().get(tmpcoordinates + 1).setBorder(BorderFactory.createLineBorder(Color.green, 8));
                                        greenbuttons.add(V.getavailable().get(tmpcoordinates + 1));
                                        if(!V.getavailable().get(tmpcoordinates + 1).getIsEmpty()){
                                            break;
                                        }
                                        tmpcoordinates++;
                                    }
                                    else{
                                        break;
                                    }
                                }
                                else{
                                    break;
                                }
                            }
                            tmpcoordinates = coordinates;
                            while(tmpcoordinates % 10 != 0){
                                if(!V.getavailable().get(tmpcoordinates - 1).getIsSea()){
                                    if(!V.getavailable().get(tmpcoordinates - 1).getColor().equals(V.getavailable().get(coordinates).getColor())){
                                        V.getavailable().get(tmpcoordinates - 1).setBorder(BorderFactory.createLineBorder(Color.green, 8));
                                        greenbuttons.add(V.getavailable().get(tmpcoordinates - 1));
                                        if(!V.getavailable().get(tmpcoordinates - 1).getIsEmpty()){
                                            break;
                                        }
                                        tmpcoordinates--;
                                    }
                                    else{
                                        break;
                                    }
                                }
                                else{
                                    break;
                                }
                            }
                            tmpcoordinates = coordinates;
                            while(tmpcoordinates + 10 <80){
                                if(!V.getavailable().get(tmpcoordinates + 10).getIsSea()){
                                    if(!V.getavailable().get(tmpcoordinates + 10).getColor().equals(V.getavailable().get(coordinates).getColor())){
                                        V.getavailable().get(tmpcoordinates + 10).setBorder(BorderFactory.createLineBorder(Color.green,8));
                                        greenbuttons.add(V.getavailable().get(tmpcoordinates + 10));
                                        if(!V.getavailable().get(tmpcoordinates + 10).getIsEmpty()){
                                            break;
                                        }
                                        tmpcoordinates += 10;
                                    }
                                    else{
                                        break;
                                    }
                                }
                                else{
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e){

        }

        @Override
        public void mouseReleased(MouseEvent e){

        }

        @Override
        public void mouseEntered(MouseEvent e){

        }

        @Override
        public void mouseExited(MouseEvent e){

        }
    }

    public static void main(String argv[]){
        Controller C = new Controller();
    }

    public Player getRed(){
        return red;
    }

    public Player getBlue(){
        return blue;
    }

    public void nextTurn(){

    }

    public boolean areEnemies(Piece x, Piece y){
        return true;
    }

    public void attack(MyButton tmp, MyButton cur){
        Piece winner;
        if(tmp.getCurrentCell().getpower() != cur.getCurrentCell().getpower()){
            winner = tmp.getCurrentCell().attack(cur.getCurrentCell());
            if(winner.getname().equals(tmp.getCurrentCell().getname())){
                cur.setCurrentCell(tmp.getCurrentCell());
                cur.setIcon(tmp.getIcon());
                cur.setColor(tmp.getColor());
            }
        }
        else{
            cur.Empty();
        }
    }

    public boolean isFinished(){
        return false;
    }

    public void move(MyButton tmp, MyButton cur){
        if(cur.getIsEmpty()){
            cur.setCurrentCell(tmp.getCurrentCell());
            cur.setIcon(tmp.getIcon());
            cur.setColor(tmp.getColor());
        }
        else if(!cur.getIsSea()){
            attack(tmp, cur);
        }
    }

    public void revive(Piece x){

    }
}
