import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PassportFactory {

    public static boolean hasRequiredFields(Map<String, String> fields) {
        String[] requiredFields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        for (String field: requiredFields) {
            if (fields.get(field) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasValidFields(Map<String, String> fields) {
        int byr, iyr, eyr, hgt;
        String hcl, ecl, pid, cid;
        // try to convert numerical values first
        try {
            byr = Integer.parseInt(fields.get("byr"));
            iyr = Integer.parseInt(fields.get("iyr"));
            eyr = Integer.parseInt(fields.get("eyr"));
        } catch (NumberFormatException e) {
            System.out.println("Invalid data");
            return false;
        }
        // check conditions
        if (byr < 1920 || byr > 2002) return false;
        if (iyr < 2010 || iyr > 2020) return false;
        if (eyr < 2020 || eyr > 2030) return false;

        String sHgt = fields.get("hgt");
        hgt = Integer.parseInt(sHgt.replaceAll("[^0-9]", ""));
        if ((sHgt.endsWith("cm") && (hgt < 150 || hgt > 193)) ||
                (sHgt.endsWith("in") && (hgt < 59 || hgt > 76))){
            return false;
        } else if (!sHgt.endsWith("cm") && !sHgt.endsWith("in")) {
            return false;
        }

        hcl = fields.get("hcl");
        if (!hcl.startsWith("#") || hcl.length() != 7) {
            return false;
        }
        else {
            for (char c: hcl.substring(1, hcl.length()).toCharArray()) {
                if ((c < '0' || c > '9') && (c < 'a' || c > 'f')) {
                    return false;
                }
            }
        }

        ecl = fields.get("ecl");
        String[] eyeColors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        if (!Arrays.asList(eyeColors).contains(ecl)) return false;

        pid = fields.get("pid");
        if (pid.replaceAll("[^0-9]", "").length() != 9) {
            return false;
        }

        return true;
    }

    public static Passport createPassport(Map<String, String> fields) {
        Passport passport = null;
        String byr = fields.get("byr");
        String iyr = fields.get("iyr");
        String eyr = fields.get("eyr");
        String hgt = fields.get("hgt");
        String hcl = fields.get("hcl");
        String ecl = fields.get("ecl");
        String pid = fields.get("pid");
        if (!hasRequiredFields(fields) || !hasValidFields(fields)) {
            return null;
        } else if (fields.containsKey("cid")) {
            String cid = fields.get("cid");
            return new Passport(byr, iyr, eyr, hgt, hcl, ecl, pid, cid);
        } else {
            return new Passport(byr, iyr, eyr, hgt, hcl, ecl, pid);
        }
    }

    public static ArrayList<Passport> loadPassports(String filename) {
        Map<String, String> fields = new HashMap<>();
        ArrayList<Passport> passportList = new ArrayList<>();
        File file = new File(filename);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        int lineNum = 0;
        while (fileScanner.hasNextLine()) {
            String[] line = fileScanner.nextLine().split(" ");
            if (line[0].equals("")) {
                Passport passport = createPassport(fields);
                if (passport != null) {
                    passportList.add(passport);
                }
                fields.clear();
            } else {
                for (String pair : line) {
                    String[] keyValue = pair.split(":");
                    fields.put(keyValue[0], keyValue[1]);
                }
            }
        }
        return passportList;
    }
}
