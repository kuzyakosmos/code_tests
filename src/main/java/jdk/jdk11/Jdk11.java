package jdk.jdk11;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class Jdk11 {
    public static void main(String[] args) throws IOException, InterruptedException {

        //strings
        var chant = "  USA!!!  ";
        System.out.println("chant.repeat(3) = " + chant.repeat(3));
        System.out.println("chant.isBlank() = " + chant.isBlank());
        System.out.println("chant.strip() = " + chant.strip());

        //lambdas
        //с помощью var можно использовть аннотоции
        Consumer<BigDecimal> moneyConsumer = (@Deprecated var money) ->
                System.out.println("I got this such money! = " + money);

        //http client
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri((URI.create("https://www.google.com")))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
