import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class CustomUtils {

    public boolean check_string_array(String[] array, String value) {
        Arrays.sort(array);

        return (Arrays.binarySearch(array, value) >= 0 ? true : false);
    }

    public String correct_value_input(Scanner mainInput, String textInput, String[] permitedValues, String userValue)
            throws Exception {
        System.out.println("***Enter esc to exit\n");
        do {
            if (userValue.equals("esc"))
                throw new Exception();

            System.out.println(textInput);
            userValue = mainInput.next();
        } while (!(check_string_array(permitedValues, userValue)));

        System.out.println(userValue + "testing inside");
        return userValue;
    }

    public String correct_number_input(Scanner mainInput, String textInput, String userValue) throws Exception {

        while (!userValue.matches("-?\\d+(\\.\\d+)?([eE]-?\\d+)?")) {
            if (userValue.equals("esc"))
                throw new Exception();
            System.out.println(textInput);
            userValue = mainInput.next();
        }
        ;

        return userValue;
    }

    public Double currency_conversor(String currency1, String currency2, Double value) {
        String API_URL = new String("https://v6.exchangerate-api.com/v6/41df757f828609672e822386/pair/" + currency1 + "/" + currency2 + "/" + value.toString());
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            // Construir la URL de la API
            URL url = new URL(API_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Leer la respuesta de la API
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Parsear la respuesta JSON de forma más directa
            String json = response.toString();

            String rateStr = json.split("\"" + "conversion_result" + "\":")[1].split(",|}")[0];
            double rate = Double.parseDouble(rateStr);

            // // Calcular el valor convertido
            // return amount * rate;
            return rate;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 0.0;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}
