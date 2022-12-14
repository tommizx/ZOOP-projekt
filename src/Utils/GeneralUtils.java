package Utils;

//import Model.Category;
//import Model.GeneralKnowledge;
//import Model.Math;
//import Model.Geography;
//import Stages.Game;

public class GeneralUtils {
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static void exitCheck(String userInput){
        if(userInput.equals("exit")){
            System.exit(0);
        }
    }
}