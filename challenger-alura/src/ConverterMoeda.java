import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConverterMoeda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
    private JButton btnConverter;
    public double valor;
    FazRequest fazRequest = new FazRequest();
    private final double valorEntrada; 

    public double getValorEntrada() {
		return valorEntrada;
	}

	public ConverterMoeda(double valor) {
        // Configura��es b�sicas da janela
        super("Conversor de Moeda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        this.valorEntrada = valor;
        this.valor = valor;
        
        // Cria o JComboBox com as op��es e ajusta o tamanho da caixa de sele��o
        comboBox = new JComboBox<>(new String[] {"Converter de Reais a D�lar",
                                                "Converter de Reais a Euro",
                                                "Converter de Reais a Libras Esterlinas",
                                                "Converter de Reais a Peso argentino",
                                                "Converter de Reais a Peso Chileno",
                                                "Converter de D�lar a Reais",
                                                "Converter de Euro a Reais",
        										"Converter de Libras Esterlinas a Reais",
        										"Converter de Peso argentino a  Reais",
        										"Converter de Peso Chileno a Reais"});
        comboBox.setPreferredSize(new Dimension(300, 20));

        // Cria o bot�o "Converter" e adiciona o ActionListener
        btnConverter = new JButton("Converter");
        btnConverter.addActionListener(this);

        // Cria um painel para adicionar o JComboBox e o JButton
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(comboBox);
        panel.add(btnConverter);

        // Adiciona o painel na janela
        getContentPane().add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        // Obt�m a op��o selecionada
        String opcao = (String) comboBox.getSelectedItem();

        switch (opcao) {
            case "Converter de Reais a D�lar":
                try {
                    fazRequest.devolveConversao(this.valor, "BRL", "USD");
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
                dispose();
                break;
            case "Converter de Reais a Euro":
                try {
                    fazRequest.devolveConversao(this.valor, "BRL", "EUR");
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
                dispose();
                break;
            case "Converter de Reais a Libras Esterlinas":
            	 try {
                     fazRequest.devolveConversao(this.valor, "BRL", "GBP");
                 } catch (IOException | InterruptedException ex) {
                     ex.printStackTrace();
                 }
            	dispose();
                break;
            case "Converter de Reais a Peso argentino":
            	double resultado = this.valor / 0.0259;
            	JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
            	dispose();
            	break;
            case "Converter de Reais a Peso Chileno":
            	double reaisPesoChileno = this.valor / 0.0065;
            	JOptionPane.showMessageDialog(null, "Resultado: " + reaisPesoChileno);
            	dispose();
            	new JanelaOpcao();
            	break;
            case "Converter de D�lar a Reais":
            	 try {
                     fazRequest.devolveConversao(this.valor, "USD", "BRL");
                 } catch (IOException | InterruptedException ex) {
                     ex.printStackTrace();
                 }
            	 dispose();
            	break;
            case "Converter de Euro a Reais":
            	 try {
                     fazRequest.devolveConversao(this.valor, "EUR", "BRL");
                 } catch (IOException | InterruptedException ex) {
                     ex.printStackTrace();
                 }
            	dispose();
            	break;
            case "Converter de Libras Esterlinas a Reais":
            	 try {
                     fazRequest.devolveConversao(this.valor, "GBP", "BRL");
                 } catch (IOException | InterruptedException ex) {
                     ex.printStackTrace();
                 }
            	dispose();
            	break;
            case "Converter de Peso argentino a  Reais":
            	double re = this.valor * 0.0259;
            	JOptionPane.showMessageDialog(null, "Resultado: " + re);
            	dispose();
            	new JanelaOpcao();
            	break;
            case "Converter de Peso Chileno a Reais":
            	double pesoChilenoReais = this.valor * 0.0065;
            	JOptionPane.showMessageDialog(null, "Resultado: " + pesoChilenoReais);
            	dispose();
            	new JanelaOpcao();
            	break;
            default:
                // A��o padr�o, caso nenhuma das op��es seja selecionada
                JOptionPane.showMessageDialog(null, "Nenhuma op��o selecionada...");
                break;
        }
    }

}
