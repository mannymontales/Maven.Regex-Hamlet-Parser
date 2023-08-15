import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public static void main(String[] args) {
        HamletParser parser = new HamletParser();

        String output = parser.hamletData;
        String output2 = parser.getHamletData();
        String output3 = parser.loadFile();

        System.out.println(output3);
    }

    public String replaceHamletWithLeon(String input) {
        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        StringBuffer output = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(output, "Leon");
        }
        matcher.appendTail(output);

        return  output.toString();
    }

    public String replaceHoratioWithTariq(String input) {
        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        StringBuffer output = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(output, "Tariq");
        }
        matcher.appendTail(output);

        return  output.toString();
    }

    public String calculateFinalString(String input){
        String firstReplace = replaceHamletWithLeon(input);
        String finalReplace = replaceHoratioWithTariq(firstReplace);
        return finalReplace;
    }

}
