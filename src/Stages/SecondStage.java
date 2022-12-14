package Stages;

//singleton logic from https://www.baeldung.com/java-private-constructors

public final class SecondStage {
    private String stageName;
    private SecondStage(){
        this.setStageName("testing");
    }
    private static SecondStage secondStage;
    public static SecondStage createSecondStage(){
        if(secondStage == null){
            secondStage = new SecondStage();
        }
        return secondStage;
    }
    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
}
