package app.temperature;

public class TemperatureConverter{

    private Temperatures from;
    private Temperatures to;

    // Method to convert Celcius to Fahrenheit
    public double CtoF(double C){
        double F = (C * 9/5) + 32;
        return F;
    }
    // Method to convert Celcius to Kelvin
    public double CtoK(double C){
        double K = C + 273.15;
        return K;
    }

    // Method to convert Fahrenheit to Celcius
    public double FtoC(double F){
        double C = (F - 32) * 5/9;
        return C;
    }
    // Method to convert Fahrenheit to Kelvin
    public double FtoK(double F){
        double K = (F - 32) * 5/9 + 273.15;
        return K;
    }

    // Method to convert Kelvin to Celcius
    public double KtoC(double K){
        double C = K - 273.15;
        return C;
    }
    // Method to convert Kelvin to Fahrenheit
    public double KtoF(double K){
        double F = (K - 273.15) * 9/5 + 32;
        return F;
    }

    /*public double convert(Double amount) throws Exception {
        int ch;
        if (from == Temperatures.CELSIUS && to == Temperatures.FAHRENHEIT){
         ch = 1;
        } else if (from == Temperatures.CELSIUS && to == Temperatures.KELVIN) {
            ch = 2;
        }else if (from == Temperatures.FAHRENHEIT && to == Temperatures.CELSIUS) {
            ch = 3;
        }else if (from == Temperatures.FAHRENHEIT && to == Temperatures.KELVIN) {
            ch = 4;
        }else if (from == Temperatures.KELVIN && to == Temperatures.CELSIUS) {
            ch = 5;
        }else if (from == Temperatures.KELVIN && to == Temperatures.FAHRENHEIT) {
            ch = 6;
        }else ch = 7;

        return switch (ch) {
            case 1 -> CtoF(amount);
            case 2 -> CtoK(amount);
            case 3 -> FtoC(amount);
            case 4 -> FtoK(amount);
            case 5 -> KtoC(amount);
            case 6 -> KtoF(amount);
            case 7 -> throw new Exception("Invalid data!");
            default -> 0;
        };

    }*/

    public Temperatures getFrom() {
        return from;
    }

    public void setFrom(Temperatures from) {
        this.from = from;
    }

    public Temperatures getTo() {
        return to;
    }

    public void setTo(Temperatures to) {
        this.to = to;
    }
}
