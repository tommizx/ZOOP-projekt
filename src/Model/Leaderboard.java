package Model;

public class Leaderboard {
    private ActiveUser bestOverallPlayer;
    public ActiveUser[] generalKnowledgeLeaderboard = new ActiveUser[100];
    public ActiveUser[] mathLeaderboard = new ActiveUser[100];
    public ActiveUser[] geographyLeaderboard = new ActiveUser[100];

    public ActiveUser getBestOverallPlayer() {
        return bestOverallPlayer;
    }

    public void setBestOverallPlayer(ActiveUser bestOverallPlayer) {
        this.bestOverallPlayer = bestOverallPlayer;
    }
}
