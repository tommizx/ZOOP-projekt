package Model;

public class Math extends Category{
    public Math(){
        super();
        this.setCategoryName("Math");
        this.setCategoryNumber(2);
        this.setActiveHighestScore(0);
        questionArray[0] = "Napis cislo PI s jeho prvymi styrmi desatinnymi cislami (s bodkou)";
        questionArray[1] = "Kolko je 6^0?";
        questionArray[2] = "Ak objekt vyhodime do vzduchu a spadne naspat na zem, tvar jeho trajektorie je?";
        questionArray[3] = "Ktore prvocislo je najblizsie cislu 100?";
        questionArray[4] = "Zaporne cisla sa prvykrat pouzili v ......? (dopln vysklonovany nazov krajiny)";

        answerArray[0] = "3.1415";
        answerArray[1] = "1";
        answerArray[2] = "parabola";
        answerArray[3] = "101";
        answerArray[4] = "Cine";
    }
    @Override
    public String toString(){
        return "Nazov kategorie je "+this.getCategoryName()+" a jej cislo je "+this.getCategoryNumber();
    }
}