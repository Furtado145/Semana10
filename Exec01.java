package Aula10;
/**
 * 1) Crie uma tela com um campo texto com a etiqueta Texto, um botão Mostrar, um
 * botão Limpar e um botão Sair. O botão Mostrar, ao ser clicado, mostra o conteúdo
 * do campo Texto em um JOptionPane. O botão Limpar limpa o campo Texto e o botão
 * Sair sai do programa.
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;

public class Exec01 extends JFrame implements ActionListener{

	private JTextField txtTexto;
	private JLabel lblTexto;
	private JButton btnMostar, btnLimpar, btnSair;
	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == btnMostar) {
			JOptionPane.showMessageDialog(null, txtTexto.getText());
		}else if(e.getSource() == btnLimpar) {
			txtTexto.setText(null);;
			JOptionPane.showMessageDialog(null, "Texto Limpo");	
		}else if(e.getSource() == btnSair) {
			System.exit(0);
		}
	}
	public Exec01() {
		super("Exercicio 01 - Aula 10");
		
		JPanel painelTexto = new JPanel(new FlowLayout());
		lblTexto = new JLabel("Texto: ");
		txtTexto = new JTextField(30);
		painelTexto.add(lblTexto);
		painelTexto.add(txtTexto);
		
		JPanel painelBotoes = new JPanel(new FlowLayout());
		btnMostar = new JButton("Mostar");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		
		btnMostar.addActionListener(this);
		btnLimpar.addActionListener(this);
		btnSair.addActionListener(this);
		
		painelBotoes.add(btnMostar);
		painelBotoes.add(btnLimpar);
		painelBotoes.add(btnSair);
			
		Container painelConteudo = getContentPane();
		
		painelConteudo.setLayout(new BorderLayout());
		
		painelConteudo.add(painelTexto, BorderLayout.CENTER);
		painelConteudo.add(painelBotoes, BorderLayout.SOUTH);
		
		setSize (500, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Exec01();
			}
		});
	}
}
