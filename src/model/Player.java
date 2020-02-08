package model;

public class Player implements GeneralData {
    private Boat boat;
    private int life, score;

    public Player(){
        life = INIT_LIFE;
        score = INIT_SCORE;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
