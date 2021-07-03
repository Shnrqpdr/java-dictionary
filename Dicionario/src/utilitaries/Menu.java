package utilitaries;

public class Menu {
	
	public static int menuPrincipal() {
		
		String menu = "Sistema de Dicionário\n\n"
				+ "1 - Cadastrar Palavra\n"
				+ "2 - Alterar Palavra\n"
				+ "3 - Excluir Palavra\n"
				+ "4 - Listar palavras\n"
				+ "5 - Exportar para arquivo\n"
				+ "6 - Sair\n";
		
		return Messages.leInteiro(menu+"Informe uma opção: ");
	}
	
	public static int menuListagens() {
		String menu = "Sistema de Dicionário - Listagens\n\n"
				+ "1 - Listar todas as palavras\n"
				+ "2 - Buscar uma palavra\n\n"
				+ "3 - Retornar\n";
		
		return Messages.leInteiro(menu+"Informe uma opção: ");
		
	}
	
	public static int menuBuscas() {
		String menu = "Sistema de Dicionário - Buscas\n\n"
				+ "1 - Buscar palavra em português\n"
				+ "2 - Buscar palavra em inglês\n"
				+ "3 - Buscar palavra em espanhol\n\n"
				+ "4 - Retornar\n";
		
		return Messages.leInteiro(menu+"Informe uma opção: ");
	}

}
