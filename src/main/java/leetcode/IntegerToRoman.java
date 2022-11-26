package leetcode;

/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*/
@LeetcodeNumber(number = 12, level = Level.MEDIUM)
public class IntegerToRoman {
    //1 <= num <= 3999
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case (0):
                    result = convert0(num % 10).append(result);
                    break;
                case (1):
                    result = convert1(num % 10).append(result);
                    break;
                case (2):
                    result = convert2(num % 10).append(result);
                    break;
                case (3):
                    result = convert3(num % 10).append(result);
                    break;
            }
            num = num / 10;
            if (num == 0) break;
        }
        return result.toString();
    }

    //III, IV, VIII, IX
    StringBuilder convert0(int n) {
        if (n <= 5) {
            switch (n) {
                case (1):
                    return new StringBuilder("I");
                case (2):
                    return new StringBuilder("II");
                case (3):
                    return new StringBuilder("III");
                case (4):
                    return new StringBuilder("IV");
                case (5):
                    return new StringBuilder("V");
            }
        } else {
            switch (n) {
                case (6):
                    return new StringBuilder("VI");
                case (7):
                    return new StringBuilder("VII");
                case (8):
                    return new StringBuilder("VIII");
                case (9):
                    return new StringBuilder("IX");
            }
        }
        return new StringBuilder();
    }

    StringBuilder convert1(int n) {
        if (n <= 5) {
            switch (n) {
                case (1):
                    return new StringBuilder("X");
                case (2):
                    return new StringBuilder("XX");
                case (3):
                    return new StringBuilder("XXX");
                case (4):
                    return new StringBuilder("XL");
                case (5):
                    return new StringBuilder("L");
            }
        } else {
            switch (n) {
                case (6):
                    return new StringBuilder("LX");
                case (7):
                    return new StringBuilder("LXX");
                case (8):
                    return new StringBuilder("LXXX");
                case (9):
                    return new StringBuilder("XC");
            }
        }
        return new StringBuilder();
    }

    StringBuilder convert2(int n) {
        if (n <= 5) {
            switch (n) {
                case (1):
                    return new StringBuilder("C");
                case (2):
                    return new StringBuilder("CC");
                case (3):
                    return new StringBuilder("CCC");
                case (4):
                    return new StringBuilder("CD");
                case (5):
                    return new StringBuilder("D");
            }
        } else {
            switch (n) {
                case (6):
                    return new StringBuilder("DC");
                case (7):
                    return new StringBuilder("DCC");
                case (8):
                    return new StringBuilder("DCCC");
                case (9):
                    return new StringBuilder("CM");
            }
        }
        return new StringBuilder();
    }

    StringBuilder convert3(int n) {
        switch (n) {
            case (1):
                return new StringBuilder("M");
            case (2):
                return new StringBuilder("MM");
            case (3):
                return new StringBuilder("MMM");
            default:
                return new StringBuilder();
        }
    }
}
