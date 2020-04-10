package uam.estrturaDados;

import java.util.Scanner;

public class FabricaDeLista {
    private Lista listaProdutos;
    private static Scanner scanner = new Scanner(System.in);

    public int menu(int escolha){
        switch (escolha){
            case 1:
                if(this.listaProdutos != null){
                    System.out.println("A lista já foi criada, retornando ao menu");
                    break;
                }else iniciarLista();
                break;
            case 2:
                inserirItem();
                break;
            case 3:

                removerItem();
                break;
            case 4:
                listarTodosProd();
                break;
            case 5:
                pesquisarProd();
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
            else
                System.out.println("Sucesso ao cadastrar produto");

            System.out.println("Deseja cadastrar mais produtos ? ");
            escolha = !(scanner.nextLine().toLowerCase().equals("n"));

        }while(escolha);

    }

    private void removerItem(){
        int codigo = 0;
        String status = "";
        boolean escolha = true;

        do {
            System.out.println("Digite o codigo do produto");
            codigo = Integer.parseInt(scanner.nextLine());

            status = this.listaProdutos.removerVlr(codigo);

            if(status.isEmpty())
                System.out.println("Codigo não existe, erro ao excluir produto");
            else
                System.out.println("Produto removido com sucesso");
            System.out.println("Deseja remover mais produtos ? ");
            escolha = !(scanner.nextLine().toLowerCase().equals("n"));

        }while(escolha);
    }

    private void listarTodosProd(){
        this.listaProdutos.listarTodosProdutos();
    }

    private void pesquisarProd(){
        boolean condicao = true;
        int codProd;
        String status;
        do {
            System.out.println("Digite o codigo do produto: ");
            codProd = Integer.parseInt(scanner.nextLine());

            status = this.listaProdutos.pesquisarElemento(codProd);

            if(status.isEmpty())
                System.out.println("Codigo não existe, erro ao buscar produto");
            else
                System.out.println("Codigo: " + codProd + " | Produto: " + status);
            System.out.println("Deseja pesquisar mais produtos ? ");
            condicao = !(scanner.nextLine().toLowerCase().equals("n"));
        }while(condicao);

    }
}
