
import javax.swing.JOptionPane;

public class Menu {
	public static double valor = 0;

	public void devolve() {
		String[] opcoes = { "Converter Moedas", "Converter Temperaturas" };

		String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Conversor",
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

		if (escolha.equals("Converter Moedas")) {
			String valorStr = JOptionPane.showInputDialog(null, "Digite o valor em reais a ser convertido:",
					"Conversor", JOptionPane.PLAIN_MESSAGE);

			try {
				valor = Double.parseDouble(valorStr);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor invalido. Por favor, digite um valor numérico.", "Conversor",
						JOptionPane.ERROR_MESSAGE);
				devolve();
				;
				return;

			}
			new ConverterMoeda(valor);
		}
		if (escolha.equals("Converter Temperaturas")) {
			String valorStr = JOptionPane.showInputDialog(null, "Digite o valor em reais a ser convertido:",
					"Conversor", JOptionPane.PLAIN_MESSAGE);

			try {
				valor = Double.parseDouble(valorStr);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor invalido. Por favor, digite um valor numérico.", "Conversor",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			new ConverterTemperatura(valor);
		}
	}
}
