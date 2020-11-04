package fr.p10.miage.rps.model;

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

        return Result.LOST;

    }

}
