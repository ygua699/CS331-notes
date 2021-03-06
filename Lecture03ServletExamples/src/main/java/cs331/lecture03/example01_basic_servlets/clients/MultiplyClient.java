package cs331.lecture03.example01_basic_servlets.clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import cs331.lecture03.Keyboard;

public class MultiplyClient {

    public static void main(String[] args) {

        int num1 = Integer.parseInt(Keyboard.prompt("Please enter first number:"));
        int num2 = Integer.parseInt(Keyboard.prompt("Please enter second number:"));

        Client httpClient = ClientBuilder.newClient();

        Response response = httpClient.target(
                "http://localhost:8080/lecture_03_example_war_exploded/basicMultiply?num1="+num1+"&num2="+num2)
                .request()
                .get();

        String message = response.readEntity(String.class);
        int result = Integer.parseInt(message);

        System.out.println("Result: " + result);

        httpClient.close();

    }

}
