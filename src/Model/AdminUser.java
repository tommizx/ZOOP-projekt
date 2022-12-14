package Model;

public class AdminUser extends ActiveUser{

    public AdminUser(){
        super();
    }
    public final void resetLeaderboard(Leaderboard leaderboard, ActiveUser[] activeUserArray){
        for(int i=0; i<100; i++){
            leaderboard.generalKnowledgeLeaderboard[i] = null;
            leaderboard.mathLeaderboard[i] = null;
            leaderboard.geographyLeaderboard[i] = null;
            activeUserArray[i] = null;
        }
    }
}
