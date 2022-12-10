package Model;

public class Category {
    private String categoryName;
    private int categoryNumber;
    public String[] questionArray = new String[5];
    public String[] answerArray = new String[5];

    public String getCategoryName() {
        return categoryName;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryNumber(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }
}