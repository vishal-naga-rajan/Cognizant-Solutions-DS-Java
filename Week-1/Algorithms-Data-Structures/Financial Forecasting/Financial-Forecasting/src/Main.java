public class Main {
    public static void main(String[] args) {
        double initialAmount = 50000;
        double growthRate = 0.07;
        int years = 5;

        System.out.println("Recursive Forecast:");
        double result = FinancialForecast.futureValue(initialAmount, growthRate, years);
        System.out.printf("After %d years: ₹%.2f\n", years, result);

        System.out.println("\n Optimized with Memoization:");
        double[] memo = new double[years + 1];
        double optimized = FinancialForecast.futureValueMemo(initialAmount, growthRate, years, memo);
        System.out.printf("After %d years: ₹%.2f\n", years, optimized);
    }
}
