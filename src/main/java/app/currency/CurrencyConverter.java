package app.currency;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    private Currency from;
    private Currency to;

    private Map<Currency, Double> currencyToUSD = new HashMap<Currency, Double>(){{
       put(Currency.USD, 1d);
       put(Currency.UAH, 0.027);
       put(Currency.EUR, 1.11d);
       put(Currency.AUD, 0.67d);
       put(Currency.BGN, 0.56d);
       put(Currency.DKK, 0.15d);
    }};

    private Map<Currency, Double> USDtoCurrency = new HashMap<Currency, Double>(){{
        put(Currency.USD, 1d);
        put(Currency.UAH, 36.91d);
        put(Currency.EUR, 0.9d);
        put(Currency.AUD, 1.49d);
        put(Currency.BGN, 1.78d);
        put(Currency.DKK, 6.78d);
    }};
    public CurrencyConverter(){
    }
    public CurrencyConverter(Currency from, Currency to){
        this.from = from;
        this.to = to;
    }

    public Double convert(Double amount) throws ArithmeticException{

        if (from == to){
            throw new ArithmeticException("Currency to convert is the same as starting currency!");
        }

        Double USDCurrency = currencyToUSD.get(from);
        Double USDResult = USDCurrency * amount;

        Double askedCurrency = USDtoCurrency.get(to);
        return USDResult * askedCurrency;

    }

    public Currency getFrom() {
        return from;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public Currency getTo() {
        return to;
    }

    public void setTo(Currency to) {
        this.to = to;
    }

    public static void main(String[] args) {
        CurrencyConverter currencyConverter = new CurrencyConverter(Currency.USD, Currency.EUR);
        System.out.println(currencyConverter.convert(200d));
    }

}
