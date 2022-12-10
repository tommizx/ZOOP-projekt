package Model;

public class Category {
    private String categoryName;
    private int categoryNumber;
    private int activeHighestScore;
    public String[] questionArray = new String[5];
    public String[] answerArray = new String[5];

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }
    public int getActiveHighestScore() {
        return activeHighestScore;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryNumber(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }
    public void setActiveHighestScore(int activeHighestScore){
        this.activeHighestScore = activeHighestScore;
    }
}