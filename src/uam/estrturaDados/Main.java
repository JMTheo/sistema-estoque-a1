package uam.estrturaDados;

import java.util.Scanner;

//Tema: Lista Estoque de itens
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FabricaDeLista gerenciadorLista = new FabricaDeLista();
        int entrada = 0;

        while (entrada != 7) {
            System.out.println("=== Sistema de Estoque ===");
            System.out.println("1 - Iniciar a Lista");
            System.out.println("2 - Inserir um novo produto");
            System.out.println("3 - Remover um produto");
            System.out.println("4 - Listar todos os produtos");
            System.out.println("5 - Pesquisar um produto");
            System.out.println("6 - Modificar um produto");
            System.out.println("7 - Fechar sistema");
            System.out.println("Digite um numero para prosseguir !");

            entrada = Validador.validarInt(scanner.nextLine());

            gerenciadorLista.menu(entrada);
        }
        scanner.close();
    }
}
