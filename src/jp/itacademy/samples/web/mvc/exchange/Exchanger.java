package jp.itacademy.samples.web.mvc.exchange;

import java.util.HashMap;
import java.util.Map;

public class Exchanger {

    private Map<String, Double> rates;

    public Exchanger() {
        rates = new HashMap<>();
    }

    public void addCurrency(String currency, double rate) {
        rates.put(currency, rate);
    }

    public double getJpyAmount(double targetAmount, String target) {
        if (!rates.containsKey(target)) {
            throw new IllegalArgumentException("no such currency: " + target);
        }
        return targetAmount * rates.get(target);
    }

    public double getTargetAmount(int jpyAmount, String target) {
        if (!rates.containsKey(target)) {
            throw new IllegalArgumentException("no such currency: " + target);
        }
        return jpyAmount / rates.get(target);
    }

}
