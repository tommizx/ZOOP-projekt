package Model;

public class ActiveUser extends User{
    private int activeUserPoints;
    public int[] activeUserHighestScoreArray = new int[3];
    private int activeUserGeneralKnowledgeRecord;
    private int activeUserMathRecord;
    private int activeUserGeographyRecord;
    public ActiveUser(String userName){
        super();
        this.setUserName(userName);
        this.activeUserHighestScoreArray[0] = 0;
        this.activeUserHighestScoreArray[1] = 0;
        this.activeUserHighestScoreArray[2] = 0;
        this.setActiveUserPoints(0);
        this.setActiveUserGeneralKnowledgeRecord(0);
        this.setActiveUserMathRecord(0);
        this.setActiveUserGeographyRecord(0);
    }
    public int getActiveUserPoints() {
        return activeUserPoints;
    }

    public void setActiveUserPoints(int activeUserPoints) {
        this.activeUserPoints = activeUserPoints;
    }
    public int getActiveUserGeneralKnowledgeRecord() {
        return activeUserGeneralKnowledgeRecord;
    }

    public void setActiveUserGeneralKnowledgeRecord(int activeUserGeneralKnowledgeRecord) {
        this.activeUserGeneralKnowledgeRecord = activeUserGeneralKnowledgeRecord;
    }

    public int getActiveUserMathRecord() {
        return activeUserMathRecord;
    }

    public void setActiveUserMathRecord(int activeUserMathRecord) {
        this.activeUserMathRecord = activeUserMathRecord;
    }

    public int getActiveUserGeographyRecord() {
        return activeUserGeographyRecord;
    }

    public void setActiveUserGeographyRecord(int activeUserGeographyRecord) {
        this.activeUserGeographyRecord = activeUserGeographyRecord;
    }
}
