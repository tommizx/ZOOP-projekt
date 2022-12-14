package Utils;

import Model.*;

public class PointsUtils {
    public static void setHighestScore(ActiveUser activeUser, Category currentCategory){
        activeUser.activeUserHighestScoreArray[currentCategory.getCategoryNumber()-1] = activeUser.getActiveUserPoints();
//        currentCategory.setActiveHighestScore(activeUser.getActiveUserPoints());
    }
}
