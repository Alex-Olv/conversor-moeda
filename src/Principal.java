import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        Scanner leitura = new Scanner(System.in);
        String endereco = "https://v6.exchangerate-api.com/v6/59e893affa11e5df4895d605/latest/USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        // Cria objetos Moeda conforme as opções:
        Moeda dolar = new Moeda("USD", 1.0); // Base é dólar
        Moeda real = new Moeda("BRL", rates.get("BRL").getAsDouble());
        Moeda pesoArgentino = new Moeda("ARS", rates.get("ARS").getAsDouble());
        Moeda pesoColombiano = new Moeda("COP", rates.get("COP").getAsDouble());

        while (true) {
            System.out.println("**********************************************");
            System.out.println("Seja bem vindo ao conversor de moedas =)\n");
            System.out.println("1) Dólar => Peso Argentino\n" +
                    "2) Peso Argentino => Dólar\n" +
                    "3) Dólar => Real Brasileiro\n" +
                    "4) Real Brasileiro => Dólar\n" +
                    "5) Dólar => Peso Colombiano\n" +
                    "6) Peso Colombiano => Dólar\n" +
                    "7) Sair\n");
            System.out.println("Escolha uma opção valida: ");
            System.out.println("**********************************************");
            int opcao = leitura.nextInt();

            if (opcao == 7) {
                System.out.println("Saindo...");
                break;
            }

            System.out.println("Digite a quantidade a converter:");
            double quantidade = leitura.nextDouble();
            leitura.nextLine();

            double resultado = 0;

            switch (opcao) {
                case 1: // Dólar => Peso Argentino
                    resultado = Conversor.converterDolarParaPesoArgentino(quantidade, pesoArgentino.getValor());
                    break;
                case 2: // Peso Argentino => Dólar
                    resultado = Conversor.converterPesoArgentinoParaDolar(quantidade, pesoArgentino.getValor());
                    break;
                case 3: // Dólar => Real Brasileiro
                    resultado = Conversor.converterDolarParaReal(quantidade, real.getValor());
                    break;
                case 4: // Real Brasileiro => Dólar
                    resultado = Conversor.converterRealParaDolar(quantidade, real.getValor());
                    break;
                case 5: // Dólar => Peso Colombiano
                    resultado = Conversor.converterDolarParaPesoColombiano(quantidade, pesoColombiano.getValor());
                    break;
                case 6: // Peso Colombiano => Dólar
                    resultado = Conversor.converterPesoColombianoParaDolar(quantidade, pesoColombiano.getValor());
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.printf("Resultado da conversão: %.2f%n%n", resultado);
        }
    }
}
