import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        HamletParser hamlet = new HamletParser();

        String output = hamlet.getHamletData();
        System.out.println(hamlet.calculateFinalString(output));
    }

}
