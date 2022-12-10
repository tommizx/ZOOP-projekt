package Utils;

import Model.*;

public class PointsUtils {
    public static void resetPoints(ActiveUser activeUser){
        activeUser.setActiveUserPoints(0);
    }
    public static void setHighestScore(ActiveUser activeUser, Category currentCategory){
        currentCategory.setActiveHighestScore(activeUser.getActiveUserPoints());
    }
}
