package principal;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.palavraDAO;
import entity.Palavra;
import utilitaries.Arquivo;
import utilitaries.Conecta;
import utilitaries.Menu;
import utilitaries.Messages;

public class Main {
	
	private static Connection conn = Conecta.connectWithSQLite();
	
	public static void main(String[] args) {
		
		int optionPrincipal = 0;
		
		do {
			
			optionPrincipal = Menu.menuPrincipal();
			
			switch (optionPrincipal) {
			
				case 1:
					
					cadastraPalavra();
					
					break;
					
				case 2:
					
					alteraPalavra();
					
					break;
					
				case 3:
					
					deletaPalavra();
					
					break;
					
				case 4:
					
					menuListagens();
					
					break;
					
				case 5:
					
					if(Arquivo.escreveArquivo(listarProArquivo())) JOptionPane.showMessageDialog(null, "Exportado.");
					else JOptionPane.showMessageDialog(null, "Erro.");
					
					break;
					
				case 6:
					
					break;
	
				default:
					
					JOptionPane.showMessageDialog(null, "Informe uma opção válida");
					
					break;
			}
			
		}while(optionPrincipal != 6);
		
	}
	
	private static void menuListagens() {
		
		int option = 0;
		
		do {
			
			option = Menu.menuListagens();
			
			switch (option) {
				case 1:
					
					mostrarPalavras(listarPalavras());
					
					break;
					
				case 2:
					
					menuBuscas();
					
					break;
					
				case 3:
					
					break;
	
				default:
					
					JOptionPane.showMessageDialog(null, "Informe uma opção válida");
					
					break;
			}
			
			
		}while(option != 3);
	}
	
	private static void menuBuscas() {
		
		int option = 0;
		
		do {
			
			option = Menu.menuBuscas();
			
			switch (option) {
				case 1:
					
					mostrarPalavraLinguagem(listarPalavrasPortugues(JOptionPane.showInputDialog("Informe a palavra: ")).get(0), "Português");
					
					break;
				
				case 2:
					
					mostrarPalavraLinguagem(listarPalavrasIngles(JOptionPane.showInputDialog("Informe a palavra: ")).get(0), "Inglês");
					
					break;
					
				case 3:
					
					mostrarPalavraLinguagem(listarPalavrasEspanhol(JOptionPane.showInputDialog("Informe a palavra: ")).get(0), "Espanhol");
					
					break;
					
				case 4:
					
					break;
	
				default:
					
					JOptionPane.showMessageDialog(null, "Informe uma opção válida");
					
					break;
			}
			
			
		}while(option != 4);
	}
	
	private static void cadastraPalavra() {
		
		Palavra word = new Palavra();
		
		if(palavraDAO.insert(word, conn)) JOptionPane.showMessageDialog(null, "Inserido");
		else JOptionPane.showMessageDialog(null, "Erro");
		
	}
	
	private static void alteraPalavra() {
		
		int codigo_id = Messages.leInteiro(listagemPalavras());
		
		Palavra word = palavraDAO.searchByID(conn, codigo_id).get(0);
		Palavra w = new Palavra(codigo_id, Messages.leString("Nova palavra em português: ", word.getPortugues()), 
				Messages.leString("Nova palavra em inglês", word.getIngles()), Messages.leString("Nova palavra em espanhol: ", word.getEspanhol()));
		
		if(palavraDAO.altera(w, conn)) JOptionPane.showMessageDialog(null, "Alterado");
		else JOptionPane.showMessageDialog(null, "Erro");
		
	}
	
	private static void deletaPalavra() {
		
		int codigo_id = Messages.leInteiro(listagemPalavras());
		
		Palavra word = new Palavra(codigo_id);
		
		if(palavraDAO.deleta(word, conn)) JOptionPane.showMessageDialog(null, "Excluído");
		else JOptionPane.showMessageDialog(null, "Erro");
		
	}
	
	private static ArrayList<Palavra> listarPalavrasPortugues(String filtro){	
		return palavraDAO.searchByPortuguese(conn, filtro);
	}
	
	private static ArrayList<Palavra> listarPalavrasIngles(String filtro){	
		return palavraDAO.searchByEnglish(conn, filtro);
	}
	
	private static ArrayList<Palavra> listarPalavrasEspanhol(String filtro){	
		return palavraDAO.searchBySpanish(conn, filtro);
	}
	
	private static ArrayList<Palavra> listarProArquivo(){
		return palavraDAO.listaArquivo(conn);
	}
	
	private static String listagemPalavras() {
		
		StringBuilder listagem = new StringBuilder();
		ArrayList<Palavra> words = listarPalavras();
		
		for (Palavra palavra : words) {
			listagem.append(palavra);
		}
		
		return listagem.toString();
	}
	
	private static ArrayList<Palavra> listarPalavras(){
		return palavraDAO.listAll(conn);
	}
	
	private static void mostrarPalavraLinguagem(Palavra word, String linguagem) {
		
		StringBuilder saida = new StringBuilder();
		
		saida.append(word.toString(linguagem));
		
		Messages.mostraMensagem(saida.toString(), "Traduçao da palavra buscada");
		
	}
	
	
	private static void mostrarPalavras(ArrayList<Palavra> list) {
		
		StringBuilder saida = new StringBuilder();
		
		for (Palavra word : list) {
			saida.append(word);
		}
		
		Messages.mostraMensagem(saida.toString(), "Listas das Palavras Solicitadas");
	}
	
	

}
