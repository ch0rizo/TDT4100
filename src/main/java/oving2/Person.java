package oving2;

import java.util.Date;

public class Person {

    private String name;
    private String email;
    private Date birthday;
    private char gender;
    

    public Person(String name, String email, Date birthday, char gender) {
        if (!isValidFullName(name)) {
            throw new IllegalArgumentException("Name is wrong");
        }
        this.name = name;

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email is wrong");
        }
        this.email = email;

        if (!isValidBirthday(birthday)) {
            throw new IllegalArgumentException("Birthday is wrong");
        }
        this.birthday = birthday;

        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Gender is wrong");
        }
        this.gender = gender;
    }

    public Person() {
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
    
    public Date getBirthday() {
        return this.birthday;
    }

    public char getGender() {
        return gender;
    }


    private boolean isValidFullName(String name) {
        // That is a name and not an empty string
        if (name.trim().isEmpty()) {
            return false;
        }

        // Checks if any of the char is digits
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }

        // Checks if the name only consist of two parts, if so check if both parts is atleast two char long
        String[] parts = name.trim().split("\\s+");
        if (parts.length == 2) {
            if (parts[0].length() > 2 && parts[1].length() > 2) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidEmail(String email) {
        if (name.trim().isEmpty() || name == null) {
            return false;
        }

        String countryCodes[] = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
        String countryCodePattern = String.join("|", countryCodes);

        String[] nameParts = name.toLowerCase().trim().split("\\s+");
        String email_pattern = nameParts[0] + "\\." + nameParts[1] + "@" + "[a-zA-Z0-9.-]+" + "\\." + "(" + countryCodePattern + ")";

        if (!email.matches(email_pattern)) {
            return false;
        }
        return true;
    }
    
    private static boolean isValidBirthday(Date birthday) {
    Date todayDate = new Date();

    return birthday.after(todayDate);
}
    
    private static boolean isValidGender(char gender) {
        if (gender == 'M' || gender == 'F' || gender == '\0') {
            return true;
        }
        return false;
    }

    public void setName(String name) {
        if (!isValidFullName(name)) {
            throw new IllegalArgumentException("Name wrong");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email wrong");
        }
        this.email = email;
    }

    public void setBirthday(Date birthday) {
        if (isValidBirthday(birthday)) {
            throw new IllegalArgumentException("Birthday wrong");
        }
        this.birthday = birthday;
    }

    public void setGender(char gender) {
        if (!isValidGender(gender)) {
            throw new IllegalArgumentException("Gender wrong");
        }
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person: " + name + ", " + email;
    }

    public static void main(String[] args) {
        Date today = new Date();
        Person person = new Person();
        person.setName("Ola Nordmann");
        System.out.println(person.toString());
        person.setEmail("ola.nordmann@ntnu");
        System.out.println(person.getEmail());
    }
}
