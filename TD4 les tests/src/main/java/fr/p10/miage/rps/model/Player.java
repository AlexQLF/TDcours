package fr.p10.miage.rps.model;

import java.util.*;
import java.util.Random;

public class Player {

    String nom;
    int score;
    List<RPSEnum> mouv;
    int nextMove;


    public Player(String nom, List<RPSEnum> mouv) {
        this.nom = nom;
        this.mouv = mouv;
        this.nextMove = 0;
    }

    public Player(String nom) {

        this.nom = nom;
        this.nextMove = 0;
        this.mouv = new ArrayList<RPSEnum>();

        int nombreAlea2;

        for(int i = 0; i<10; i++){

            Random r = new Random();
            nombreAlea2 = r.nextInt(2);

            if(nombreAlea2 == 0){
                mouv.add(RPSEnum.PAPER);
            }else if(nombreAlea2 == 1){
                mouv.add(RPSEnum.ROCK);
            }else{
                mouv.add(RPSEnum.SCISSORS);
            }

        }

    }

    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public int getNbrMouv() {
        return this.mouv.size();
    }

    public RPSEnum getNextMove(){

        if(nextMove >= mouv.size()){

            return null;

        }else{

            nextMove = nextMove + 1;

            return this.mouv.get(nextMove-1);
        }
    }

    public void setScore(int score) {
        this.score = score;
    }




}
