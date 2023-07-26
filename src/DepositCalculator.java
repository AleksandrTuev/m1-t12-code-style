import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double value = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(value, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    double round(double value, int power) { //округлять
        double scale = Math.pow(10, power); //scale - размер, power - степень
        return Math.round(value * scale) / scale;
    }

    void getInformationOnDeposit( ) {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double grandTotal = 0;
        if (action == 1) {
            grandTotal = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            grandTotal = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + grandTotal);
    }

public static void main(String[] args) {
    new DepositCalculator().getInformationOnDeposit();
}




}
