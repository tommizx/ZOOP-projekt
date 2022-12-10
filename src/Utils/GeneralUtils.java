package Utils;

import Model.Category;
import Model.GeneralKnowledge;
import Model.Math;
import Model.Geography;

public class GeneralUtils {
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static void selectCategory(int categoryNumber, Category selectedCategory){
        if(categoryNumber == 1){
            selectedCategory = new GeneralKnowledge();
        }
        else if(categoryNumber == 2){
            selectedCategory = new Math();
        }
        else{
            selectedCategory = new Geography();
        }
    }
    public static void exitCheck(String userInput){
        if(userInput.equals("exit")){
            System.exit(0);
        }
    }
}