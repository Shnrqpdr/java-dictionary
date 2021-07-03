package utilitaries;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Messages {
	
	public static int leInteiro(String mensagem) {
		return Integer.parseInt(JOptionPane.showInputDialog(new JScrollPane(new JTextArea(mensagem, 10, 20))));
	}
	
	public static Double leDouble(String mensagem) {
		
		return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
	}
	
	public static String leString(String mensagem, String valorInicial) {
		
		return JOptionPane.showInputDialog(mensagem, valorInicial);
	}
	
	public static void mostraMensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(mensagem, 15, 35)), titulo, -1);
	}

}
