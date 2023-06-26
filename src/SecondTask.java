import java.util.HashMap;
import java.util.Map;

public class SecondTask {
    public static void main(String[] args) {
        // Створення першого многочлена
        Map<Integer, Double> polynomial1 = new HashMap<>();
        polynomial1.put(2, 3.0);  // x^2 коефіцієнт 3
        polynomial1.put(1, 1.0);  // x^1 коефіцієнт 1
        polynomial1.put(0, -4.0); // x^0 коефіцієнт -4

        // Створення другого многочлена
        Map<Integer, Double> polynomial2 = new HashMap<>();
        polynomial2.put(2, 2.0);  // x^2 коефіцієнт 2
        polynomial2.put(1, -3.0); // x^1 коефіцієнт -3
        polynomial2.put(0, 5.0);  // x^0 коефіцієнт 5

        // Додавання многочленів
        Map<Integer, Double> sum = addPolynomials(polynomial1, polynomial2);

        // Виведення результату
        System.out.println("Результат додавання:");
        printPolynomial(sum);
    }

    public static Map<Integer, Double> addPolynomials(Map<Integer, Double> poly1, Map<Integer, Double> poly2) {
        Map<Integer, Double> sum = new HashMap<>();

        // Додавання коефіцієнтів спільних степенів
        for (Map.Entry<Integer, Double> term : poly1.entrySet()) {
            int power = term.getKey();
            double coefficient = term.getValue();
            sum.put(power, coefficient + poly2.getOrDefault(power, 0.0));
        }

        // Додавання коефіцієнтів з полінома poly2, які відсутні в poly1
        for (Map.Entry<Integer, Double> term : poly2.entrySet()) {
            int power = term.getKey();
            if (!sum.containsKey(power)) {
                sum.put(power, term.getValue());
            }
        }

        return sum;
    }

    public static void printPolynomial(Map<Integer, Double> polynomial) {
        StringBuilder sb = new StringBuilder();
        boolean isFirstTerm = true;

        for (int power = polynomial.size() - 1; power >= 0; power--) {
            double coefficient = polynomial.getOrDefault(power, 0.0);

            if (coefficient != 0) {
                if (!isFirstTerm) {
                    if (coefficient > 0) {
                        sb.append(" + ");
                    } else {
                        sb.append(" - ");
                        coefficient = -coefficient;
                    }
                }

                if (power == 0) {
                    sb.append(coefficient);
                } else if (power == 1) {
                    if (coefficient == 1) {
                        sb.append("x");
                    } else {
                        sb.append(coefficient).append("x");
                    }
                } else {
                    if (coefficient == 1) {
                        sb.append("x^").append(power);
                    } else {
                        sb.append(coefficient).append("x^").append(power);
                    }
                }

                isFirstTerm = false;
            }
        }

        System.out.println(sb.toString());
    }
}
