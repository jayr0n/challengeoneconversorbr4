import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

public class FazRequest {
	public void devolveConversao(double valor, String from, String to) throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder().GET()
				.uri(URI.create(String.format("https://api.frankfurter.app/latest?amount=%s&from=%s&to=%s",valor, from, to ))).build();

		var response = HttpClient.newHttpClient().send(request,
				HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
		var resposta = response.body().substring(56).replace("{", "").replace("}", "");
		JOptionPane.showMessageDialog(null, "Resultado: " + resposta);
		new JanelaOpcao();
	}
}
