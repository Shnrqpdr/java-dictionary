package entity;

import javax.swing.JOptionPane;

import utilitaries.Messages;

public class Palavra {
	
	private int id;
	private String portugues;
	private String ingles;
	private String espanhol;
	
	public Palavra() {
		
		setPortugues(Messages.leString("Informe a palavra em português: ", null));
		setIngles(Messages.leString("Informe a palavra em inglês: ", null));
		setEspanhol(Messages.leString("Informe a palavra em espanhol: ", null));
	}
	
	public Palavra(int id) {
		setId(id);
	}
	
	public Palavra(int id, String portugues, String ingles, String espanhol) {
		setId(id);
		setPortugues(portugues);
		setIngles(ingles);
		setEspanhol(espanhol);
	}
	
	@Override
	public String toString() {
		return getId()+" -   Portugues: "+getPortugues()+" - \t Ingles: "+getIngles()+" - \t Espanhol: "+getEspanhol()+"\n";
	}
	
	public String toString(boolean escrevendo) {
		return getPortugues()+", "+getIngles()+", "+getEspanhol()+"\n";
	}
	
	public String toString(String linguagem) {
		
		if(linguagem.equals("Português")) {
			return getId()+" -  Inglês: "+getIngles()+" - \t Espanhol: "+getEspanhol()+"\n";
		}
		else if(linguagem.equals("Inglês")) {
			return getId()+" -  Português: "+getPortugues()+" - \t Espanhol: "+getEspanhol()+"\n";
		}
		else if(linguagem.equals("Espanhol")) {
			return getId()+" -  Português: "+getPortugues()+" - \t Inglês: "+getIngles()+"\n";
		}
		
		return "Valor informado inválido\n";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPortugues() {
		return portugues;
	}
	public void setPortugues(String portugues) {
		this.portugues = portugues;
	}
	public String getIngles() {
		return ingles;
	}
	public void setIngles(String ingles) {
		this.ingles = ingles;
	}
	public String getEspanhol() {
		return espanhol;
	}
	public void setEspanhol(String espanhol) {
		this.espanhol = espanhol;
	}
	
	

}
