package Model;

public class ActiveUser implements User{
    private int activeUserPoints;
    private String userName;
    public int[] activeUserHighestScoreArray = new int[3];
    public ActiveUser(String userName){
        super();
        this.setUserName(userName);
        this.activeUserHighestScoreArray[0] = 0;
        this.activeUserHighestScoreArray[1] = 0;
        this.activeUserHighestScoreArray[2] = 0;
        this.setActiveUserPoints(0);
    }
    public ActiveUser(){}
    public int getActiveUserPoints() {
        return activeUserPoints;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setActiveUserPoints(int activeUserPoints) {
        this.activeUserPoints = activeUserPoints;
    }
}
