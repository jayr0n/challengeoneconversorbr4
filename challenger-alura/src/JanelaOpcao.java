import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaOpcao extends JFrame {

	private static final long serialVersionUID = 1L;

	public JanelaOpcao() {
		super("Janela de opções");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 150);
		setResizable(false);
		setLocationRelativeTo(null);

		// Cria um rótulo para o texto "Deseja continuar?"
		JLabel lblPergunta = new JLabel("Deseja continuar?");
		lblPergunta.setHorizontalAlignment(SwingConstants.CENTER);

		// Cria um painel para os botões e define um layout de FlowLayout com
		// alinhamento à esquerda
		JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// Cria os botões "Sim", "Não" e "Cancelar"
		JButton btnSim = new JButton("Sim");
		JButton btnNao = new JButton("Não");
		JButton btnCancelar = new JButton("Cancelar");

		// Adiciona um ActionListener para cada botão
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
				if(Menu.escolha.equals("Converter Moedas")) {
					new ConverterMoeda(Menu.valor);
				} else if((Menu.escolha.equals("Converter Temperaturas"))){
					new ConverterTemperatura(Menu.valor);
				}

			}
		});

		// Adiciona os botões ao painel de botões
		panelBotoes.add(btnSim);
		panelBotoes.add(btnNao);
		panelBotoes.add(btnCancelar);

		// Cria um painel para o rótulo e o painel de botões e define um layout de
		// BorderLayout
		JPanel panelPrincipal = new JPanel(new BorderLayout());
		panelPrincipal.add(lblPergunta, BorderLayout.CENTER);
		panelPrincipal.add(panelBotoes, BorderLayout.SOUTH);

		// Adiciona o painel principal à janela
		getContentPane().add(panelPrincipal);

		// Torna a janela visível
		setVisible(true);
	}
}
