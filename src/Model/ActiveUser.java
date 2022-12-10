package Model;

public class ActiveUser extends User{
    private int activeUserPoints;
    private int activeUserHighestScore;
    public ActiveUser(){
        super();
        this.setActiveUserHighestScore(0);
    }

    public int getActiveUserPoints() {
        return activeUserPoints;
    }

    public void setActiveUserPoints(int activeUserPoints) {
        this.activeUserPoints = activeUserPoints;
    }

    public int getActiveUserHighestScore() {
        return activeUserHighestScore;
    }

    public void setActiveUserHighestScore(int activeUserHighestScore) {
        this.activeUserHighestScore = activeUserHighestScore;
    }
}
