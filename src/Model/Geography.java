package Model;

public class Geography extends Category{
    public Geography(){
        super();
        this.setCategoryName("Geography");
        this.setCategoryNumber(3);
        this.setActiveHighestScore(0);
        questionArray[0] = "Ako sa vola najdlhsia rieka v Afrike?";
        questionArray[1] = "Ake je hlavne mesto Kanady?";
        questionArray[2] = "Aka planeta je najblizsia k Zemi?";
        questionArray[3] = "Kolko casovych zon ma Rusko?";
        questionArray[4] = "Kolko hviezd je na vlajke Australie?";

        answerArray[0] = "Nil";
        answerArray[1] = "Ottawa";
        answerArray[2] = "Venusa";
        answerArray[3] = "11";
        answerArray[4] = "6";
    }
    @Override
    public String toString(){
        return "Nazov kategorie je "+this.getCategoryName()+" a jej cislo je "+this.getCategoryNumber();
    }
}