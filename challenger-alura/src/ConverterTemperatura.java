import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ConverterTemperatura extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBox;
    private JButton btnConverter;
    public double valor;
    FazRequest fazRequest = new FazRequest();
    private final double valorEntrada; 

    public double getValorEntrada() {
		return valorEntrada;
	}

	public ConverterTemperatura(double valor) {
        // Configura��es b�sicas da janela
        super("Conversor de Moeda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        this.valorEntrada = valor;
        this.valor = valor;
        
        // Cria o JComboBox com as op��es e ajusta o tamanho da caixa de sele��o
        comboBox = new JComboBox<>(new String[] {"Converter de Celsius para Fahrenheit",
                                                "Converter de Fahrenheit para Celsius",});
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
            case "Converter de Celsius para Fahrenheit":
            	//F = (C x 1.8) + 32
            	double fahrenheit = Math.ceil((this.valor * 1.8) + 32);
            	JOptionPane.showMessageDialog(null, "Resultado: " + fahrenheit + "Fahrenheit");
            	dispose();
            	new JanelaOpcao();
                break;
            case "Converter de Fahrenheit para Celsius":
            	//C = (F - 32) / 1.8
            	double celsius = Math.ceil((this.valor - 32) / 1.8);
            	JOptionPane.showMessageDialog(null, "Resultado: " + celsius + "Celsius");
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

