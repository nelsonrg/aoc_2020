public class Passport {
    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;

    public Passport(String byr, String iyr, String eyr, String hgt, String hcl, String ecl, String pid, String cid) {
        this.byr = byr;
        this.iyr = iyr;
        this.eyr = eyr;
        this.hgt = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
        this.cid = cid;
    }

    public Passport(String byr, String iyr, String eyr, String hgt, String hcl, String ecl, String pid) {
        this.byr = byr;
        this.iyr = iyr;
        this.eyr = eyr;
        this.hgt = hgt;
        this.hcl = hcl;
        this.ecl = ecl;
        this.pid = pid;
    }
}
