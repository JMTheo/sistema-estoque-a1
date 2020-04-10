package uam.estrturaDados;

import java.util.Scanner;

public class FabricaDeLista {
    private Lista listaProdutos;
    private static Scanner scanner = new Scanner(System.in);

    public int menu(int escolha){
        switch (escolha){
            case 1:
                iniciarLista();
                break;
            case 2:
                //TODO: Inserir elemento na lista,
                inserirItem();
                break;
            case 3:
                //Todo: Remover elemento da lista,
                System.out.println("MENU 3");

                break;
            case 4:
                // Todo: Listar todos os elementos da lista,
                System.out.println("MENU 4");

                break;
            case 5:
                // Todo:  Listar um elemento da lista.
                System.out.println("MENU 5");

                break;
            case 6:
                System.out.println("Fechando o sistema ...");
                break;
            default:
                System.out.println("Digite um número valido !");
                System.out.println("De 1 a 6!");

                break;
        }
        return escolha;
    }

    private void iniciarLista(){
        System.out.println("Digite o tamanho da lista");

        int tamanho = Integer.parseInt(scanner.nextLine());

        this.listaProdutos = new Lista(tamanho);
        System.out.println("Tamanho: " + this.listaProdutos.getTamanho());

    }

    private void inserirItem(){
        int codigo = 0;
        String nomeProd = "";
        String status = "";
        boolean escolha = true;

        do {
            System.out.println("Digite o codigo do produto");
            codigo = Integer.parseInt(scanner.nextLine());

            System.out.println("Digite o nome do produto");

            nomeProd = scanner.nextLine();
            status = this.listaProdutos.inserirVlr(nomeProd, codigo);

            if(status.isEmpty())
                System.out.println("Codigo maior que a lista, erro ao inserir registro");

            System.out.println("Deseja cadastrar mais produtos ? ");
            escolha = !(scanner.nextLine().toLowerCase().equals("n"));

        }while(escolha);

    }

}
