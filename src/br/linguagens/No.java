package br.linguagens;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class No {

	private No pai;
	private String pergunta;
	private String linguagem;
	private No esquerda;
	private No direita;
	private boolean isNoDireita;

	public No(No valor) {
		this.pai = valor;
	}

	public void pergunta(JFrame frame) {
		if (linguagem != null) {
			montarPergunta();

			boolean resposta = JOptionPane.showConfirmDialog(frame, this.pergunta + "?", "Confirmar", 0) == 0;

			if (resposta) {
				JOptionPane.showMessageDialog(frame, "Acertei de novo!", "Jogo das linguagens", 1);
			} else {
				No novoPai = new No(this.getPai());

				String novaLinguagem = JOptionPane.showInputDialog(frame, "Qual linguagem você pensou?", "Desisto",
						3);

				String tipo = JOptionPane.showInputDialog(frame,
						novaLinguagem + " é _______ , mas " + this.getLinguagem() + " não.", "Complete", 3);

				tipo = "A linguagem que você pensou é " + tipo + "?";

				No filho = new No(novoPai);
				filho.setLinguagem(novaLinguagem);

				if (this.isNoDireita) {
					this.getPai().setDireita(novoPai);
				} else {
					this.getPai().setEsquerda(novoPai);
				}
				novoPai.setPergunta(tipo);
				novoPai.setDireita(filho);
				novoPai.setEsquerda(this);
				this.setPai(novoPai);
			}

		} else {
			Integer resposta = JOptionPane.showConfirmDialog(frame, this.pergunta, "Confirmar", 0);

			verificarSeEDireitaOuEsquerda(resposta, frame);
		}

	}

	public void montarPergunta() {
		this.pergunta = "A linguagem que você pensou é: " + linguagem; 
	}
	
	public void verificarSeEDireitaOuEsquerda(Integer resposta, JFrame frame) {
		if (resposta == 0) {
			this.direita.pergunta(frame);
		} else {
			this.esquerda.pergunta(frame);
		}
	}
	
	public boolean isNoDireita() {
		return isNoDireita;
	}

	public void setNoDireita(boolean isNoDireita) {
		this.isNoDireita = isNoDireita;
	}

	public String getLinguagem() {
		return linguagem;
	}

	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
		this.esquerda.setNoDireita(false);
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
		this.direita.setNoDireita(true);
	}

}
