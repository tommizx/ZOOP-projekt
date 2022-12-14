package Model;

public class GeneralKnowledge extends Category{
    public GeneralKnowledge() {
        super();
        this.setCategoryName("General Knowledge");
        this.setCategoryNumber(1);
        questionArray[0] = "Ktory prvok je znamy tym, ze pomaha udrziavat silu a odolnost ludskych kosti?";
        questionArray[1] = "Kolko zivotov maju udajne macky?";
        questionArray[2] = "Aka je mena v polsku?";
        questionArray[3] = "Pyrofobia je chorobny strach z?";
        questionArray[4] = "Ktory jazyk ovlada viac ludi : spanielcinu / anglictinu?";

        answerArray[0] = "vapnik";
        answerArray[1] = "9";
        answerArray[2] = "polsky zloty";
        answerArray[3] = "ohna";
        answerArray[4] = "spanielcinu";
    }
    @Override
    public String toString(){
        return "Nazov kategorie je "+this.getCategoryName()+" a jej cislo je "+this.getCategoryNumber();
    }
    public int isAnswerCorrect(int questionNumber, String userAnswer){
        int result = 0;
        if(userAnswer.equals(this.answerArray[questionNumber])){
            result = 1;
        }
        return result;
    }
    @Override
    public void bCClass(){
        System.out.println("GK class");
    }
}
