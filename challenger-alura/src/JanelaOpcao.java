import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaOpcao extends JFrame {

	private static final long serialVersionUID = 1L;

	public JanelaOpcao() {
		super("Janela de op��es");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 150);
		setResizable(false);
		setLocationRelativeTo(null);

		// Cria um r�tulo para o texto "Deseja continuar?"
		JLabel lblPergunta = new JLabel("Deseja continuar?");
		lblPergunta.setHorizontalAlignment(SwingConstants.CENTER);

		// Cria um painel para os bot�es e define um layout de FlowLayout com
		// alinhamento � esquerda
		JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// Cria os bot�es "Sim", "N�o" e "Cancelar"
		JButton btnSim = new JButton("Sim");
		JButton btnNao = new JButton("N�o");
		JButton btnCancelar = new JButton("Cancelar");

		// Adiciona um ActionListener para cada bot�o
		btnSim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu().devolve();
				;

			}
		});

		btnNao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA");
				dispose();
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu();
				new ConverterTemperatura(Menu.valor);

			}
		});

		// Adiciona os bot�es ao painel de bot�es
		panelBotoes.add(btnSim);
		panelBotoes.add(btnNao);
		panelBotoes.add(btnCancelar);

		// Cria um painel para o r�tulo e o painel de bot�es e define um layout de
		// BorderLayout
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.add(lblPergunta, BorderLayout.CENTER);
		panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);

		// Adiciona o painel principal � janela
		getContentPane().add(panelPrincipal);

		// Torna a janela vis�vel
		setVisible(true);
	}
}