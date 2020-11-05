package fr.p10.miage.rps.model;

import com.sun.source.tree.DoWhileLoopTree;

public class RockPaperScissors {

    public Result play(RPSEnum p1, RPSEnum p2) {

        if (p1.equals(p2)) {
            return Result.TIE;
        }

        switch (p1) {

            case ROCK:
                if (p2.equals(RPSEnum.PAPER)) {
                    return Result.LOST;
                } else {
                    return Result.WIN;
                }

            case PAPER:
                if (p2.equals(RPSEnum.SCISSORS)) {
                    return Result.LOST;
                } else {
                    return Result.WIN;
                }

            case SCISSORS:
                if (p2.equals(RPSEnum.ROCK)) {
                    return Result.LOST;
                } else {
                    return Result.WIN;
                }

            default:
                return null;
        }
    }


    public Result play(Player p1, Player p2){

        Result res;

        for(int i = 0; i<p1.getNbrMouv();i++) {

            res = play(p1.getNextMove(),p2.getNextMove());

            if(res == Result.TIE){

                p1.setScore(p1.getScore()+1);
                p2.setScore(p2.getScore()+1);

            }else if(res == Result.WIN){

                p1.setScore(p1.getScore()+1);

            }else if(res == Result.LOST){

                p2.setScore(p2.getScore()+1);

            }

            if(p1.getScore() > 5 && p2.getScore() < 5){
                return Result.WIN;
            }

            if(p2.getScore() > 5 && p1.getScore() < 5){
                return Result.LOST;
            }

        }

        return Result.TIE;

    }

}
