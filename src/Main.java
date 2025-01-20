import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static String[] currencyCodes = {
            "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD",
            "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY",
            "COP",
            "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK",
            "GBP",
            "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS",
            "IMP",
            "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD",
            "KYD",
            "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU",
            "MUR",
            "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK",
            "PHP",
            "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP",
            "SLE",
            "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD",
            "TZS",
            "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER",
            "ZAR",
            "ZMW", "ZWL"
    };
    public static CustomUtils utils = new CustomUtils();

    public static void main(String[] args) {

        String currency1 = "";
        String currency2 = "";
        Double valueCurrency;
        Double currencyConverted;

        Scanner scanner = new Scanner(System.in);

        String userValue = "";

        try {
            userValue = utils.correct_value_input(scanner,
                    new String("Welcome to currency exchanger V1.0 try converting the following currencies:\n" +
                            String.join(", ", currencyCodes) + "\nWrite the main currency"),
                    currencyCodes, userValue);
            currency1 = userValue;


            userValue = utils.correct_number_input(scanner, new String("Now write the amount to convert\n"), userValue);
            valueCurrency = Double.valueOf(userValue);
            

            userValue = utils.correct_value_input(scanner,
                    new String("now write the currency to convert, select the values from the above list\n"),
                    currencyCodes, userValue);
            currency2 = userValue;

            currencyConverted = utils.currency_conversor(currency1, currency2, valueCurrency);

            System.out.printf("Resultado: %.2f %s = %.2f %s%n", valueCurrency, currency1, currencyConverted, currency2);

        } catch (Exception e) {
            System.out.println("Closing system\n");
            scanner.close();
            System.exit(0);
        }
    }
}