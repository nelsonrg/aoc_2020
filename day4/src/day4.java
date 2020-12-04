import java.util.ArrayList;

public class day4 {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        ArrayList<Passport> passportList = PassportFactory.loadPassports(inputFile);
        System.out.println("Valid passports: " + passportList.size());
    }
}
