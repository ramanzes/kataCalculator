
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Calculator {

    enum NumeralSystem {
        ARABIC,
        ROMAN
    }

        private static final Map<String, Integer> romanNumerals = new TreeMap<String, Integer>() {{
        put("I", 1);
        put("II", 2);
        put("III", 3);
        put("IV", 4);
        put("V", 5);
        put("VI", 6);
        put("VII", 7);
        put("VIII", 8);
        put("IX", 9);
        put("X", 10);
    }};

    public static void main(String[] args) {
//        if (args.length != 1) {
//            throw new IllegalArgumentException("Применение: Calculator \"выражение\"");
//        }
//        String expression = args[0];
//        String[] parts = expression.split(" ");
//        if (parts.length != 3) {
//            throw new IllegalArgumentException("Выражение должно содержать два операнда и один оператор");
//        }
//
//        NumeralSystem numeralSystem = getNumeralSystem(parts[0], parts[2]);
//
//        int a = convertToArabic(parts[0], numeralSystem);
//        int b = convertToArabic(parts[2], numeralSystem);
//        char op = parts[1].charAt(0);
//        int result = calculate(a, op, b);
        String s1,s2,s3;

        Scanner in = new Scanner(System.in);
        System.out.print("Операнд 1 >> "); s1=in.nextLine();
        System.out.print("Операнд 2 >> "); s2=in.nextLine();
        System.out.print("Операция >> "); s3=in.nextLine();

        NumeralSystem numeralSystem = getNumeralSystem(s1, s2);

        int a = convertToArabic(s1, numeralSystem);
        int b = convertToArabic(s2, numeralSystem);
        char op = s3.charAt(0);

        int result = calculate(a, op, b);



        String output = convertToNumeral(result, numeralSystem);
        System.out.println("Результат операции = "+output);
    }

    private static NumeralSystem getNumeralSystem(String a, String b) {
        boolean aArabic = Character.isDigit(a.charAt(0));
        boolean bArabic = Character.isDigit(b.charAt(0));
        if (aArabic && bArabic) {
            return NumeralSystem.ARABIC;
        } else if (!aArabic && !bArabic) {
            return NumeralSystem.ROMAN;
        } else {
            throw new IllegalArgumentException("Операнды должны быть одной системы счисления.");
        }
    }

    private static int convertToArabic(String input, NumeralSystem numeralSystem) {
        if (numeralSystem == NumeralSystem.ARABIC) {
            return Integer.parseInt(input);
        } else {
            if (!romanNumerals.containsKey(input)) {
                throw new IllegalArgumentException("Неверная римская цифра: " + input);
            }
            return romanNumerals.get(input);
        }
    }

    private static int calculate(int a, char op, int b) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            case ':' -> a / b;
            default -> throw new IllegalArgumentException("Неверный оператор: " + op);
        };
    }

    private static String convertToNumeral(int number, NumeralSystem numeralSystem) {
        if (numeralSystem == NumeralSystem.ARABIC) {
            return Integer.toString(number);
        } else {
            if (number <= 0) {
                throw new IllegalArgumentException("Римские цифры должны быть положительными");
            }
            String numeral = "";
            while (number > 0) {
                for (Map.Entry<String, Integer> entry : romanNumerals.entrySet()) {
                    if (entry.getValue() <= number) {
                        numeral += entry.getKey();
                        number -= entry.getValue();
                        break;
                    }
                }
            }
            return numeral;
        }
    }
}