package br.linguagens;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1101575145711799198L;

	private No raiz;

	public static void main(String[] args) {
		new Principal();
	}

	public Principal() {

		setTitle("Jogo das linguagens!");
		setDefaultCloseOperation(3);

		JPanel painel = new JPanel();
		painel.setLayout(new BoxLayout(painel, 3));
		Border padding = BorderFactory.createEmptyBorder(20, 50, 20, 50);
		painel.setBorder(padding);

		JButton botao = new JButton("Entrar");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.this.botaoOk();
			}
		});
		botao.setAlignmentX(0.5F);

		JLabel label = new JLabel("Pense em uma linguagem de programação");
		label.setAlignmentX(0.5F);

		painel.add(label);
		painel.add(Box.createRigidArea(new Dimension(0, 10)));
		painel.add(botao);
		setContentPane(painel);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		this.raiz = new No(null);
		this.raiz.setPergunta("A linguagem que voçe pensou é BackEnd?");

		No direitaNo = new No(raiz);
		direitaNo.setLinguagem("Java");

		No esquerdaNo = new No(raiz);
		esquerdaNo.setLinguagem("Javascript");

		this.raiz.setDireita(direitaNo);
		this.raiz.setEsquerda(esquerdaNo);

	}

	private void botaoOk() {
		this.raiz.pergunta(this);
	}

}
