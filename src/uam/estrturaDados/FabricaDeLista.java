package uam.estrturaDados;

import java.util.Scanner;

public class FabricaDeLista {
    private Lista listaProdutos;

    public int menu(int escolha){
        switch (escolha){
            case 1:
                iniciarLista();
                break;
            case 2:
                //TODO: Inserir elemento na lista,

                System.out.println("MENU 2");

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho da lista");

        int tamanho = Integer.parseInt(scanner.nextLine());

        this.listaProdutos = new Lista(tamanho);
        System.out.println("Tamanho: " + this.listaProdutos.getTamanho());

    }

}
