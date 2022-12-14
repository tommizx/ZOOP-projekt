package Model;

public interface User {
    default void resetPoints(ActiveUser activeUser){
        activeUser.setActiveUserPoints(0);
        System.out.println("Body boli resetovane! :)");
    }
}