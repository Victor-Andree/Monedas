import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaMoneda {

    private static final String URL = "https://v6.exchangerate-api.com/v6/27d4cdc25c8c4f2a606d5036/latest/";

    public double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) throws Exception {
        String urlString = URL + monedaOrigen;
        URI uri = URI.create(urlString);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            return jsonResponse.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();
        } else {
            throw new Exception("Error en la solicitud: " + response.statusCode());
        }
    }
}

