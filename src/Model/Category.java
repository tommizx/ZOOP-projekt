package Model;

public abstract class Category {
    private String categoryName = "Category";
    private int categoryNumber = 0;
    public String[] questionArray = new String[5];
    public String[] answerArray = new String[5];
    public String getCategoryName() {
        return categoryName;
    }
    public int getCategoryNumber() { return categoryNumber; }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public void setCategoryNumber(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }
    public void bCClass(){
        System.out.println(this.getCategoryName());
        System.out.println(this.getCategoryNumber());
        System.out.println("why");
    }
    public abstract int isAnswerCorrect(int questionNumber, String userAnswer);
}