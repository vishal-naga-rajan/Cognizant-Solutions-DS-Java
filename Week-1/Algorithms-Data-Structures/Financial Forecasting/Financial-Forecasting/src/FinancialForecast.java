public class FinancialForecast {
    public static double futureValue(double initialAmount, double growthRate, int years) {
        if (years == 0) {
            return initialAmount;
        }
        return futureValue(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }
    public static double futureValueMemo(double initialAmount, double growthRate, int years, double[] memo) {
        if (years == 0) return initialAmount;
        if (memo[years] != 0) return memo[years];
        memo[years] = futureValueMemo(initialAmount, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }
}
