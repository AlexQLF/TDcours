package fr.p10.miage.rps.model;

import java.util.*;

public class Player {

    String nom;
    int score;
    List<RPSEnum> mouv;


    public Player(String nom, List<RPSEnum> mouv) {
        this.nom = nom;
        this.mouv = mouv;
    }

    public Player(String nom) {
        this.nom = nom;

        List<RPSEnum> mouv = new ArrayList<>();
        int nombreAlea2;

        for(int i = 0; i<10; i++){

            nombreAlea2 =  0 + (int)(Math.random() * ((2 - 0) + 0));

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
        return this.mouv.remove(0);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
