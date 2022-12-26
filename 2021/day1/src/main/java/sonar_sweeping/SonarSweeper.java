package sonar_sweeping;

public class SonarSweeper {

    private int number1;
    private int number2;

    public SonarSweeper(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public boolean sweep() {
        return number2 > number1;
    }
    
}
