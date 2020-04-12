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
                if(Validador.checarLista(this.listaProdutos))
                    inserirItem();
                break;
            case 3:
                if(Validador.checarLista(this.listaProdutos))
                    removerItem();
                break;
            case 4:
                if(Validador.checarLista(this.listaProdutos))
                    listarTodosProd();
                break;
            case 5:
                if(Validador.checarLista(this.listaProdutos))
                    pesquisarProd();
                break;
            case 6:
                if(Validador.checarLista(this.listaProdutos))
                    modificarProd();
                break;
            case 7:
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
        int tamanho;
        System.out.println("Digite o tamanho da lista");

        do {
            tamanho = Validador.validarInt(scanner.nextLine());
            if(tamanho == 0) System.out.println("O numero deve ser positivo");
        }while(tamanho <= 0);


        this.listaProdutos = new Lista(tamanho);
        System.out.println("Tamanho: " + this.listaProdutos.getTamanho());

    }

    private void inserirItem(){
        int codigo = 0;
        String nomeProd = "";
        String status = "";
        int quantidade;
        boolean escolha = true;

        do {
            System.out.println("Digite o codigo do produto");
            codigo = Validador.validarInt(scanner.nextLine());

            System.out.println("Digite o nome do produto");
            nomeProd = scanner.nextLine();

            System.out.println("Digite a quantidade do produto");
            quantidade = Validador.validarInt(scanner.nextLine());

            status = this.listaProdutos.inserirVlr(nomeProd, codigo, quantidade);

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
            codigo = Validador.validarInt(scanner.nextLine());

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
            codProd = Validador.validarInt(scanner.nextLine());

            status = this.listaProdutos.pesquisarElemento(codProd);

            if(status.isEmpty())
                System.out.println("Codigo não existe, erro ao buscar produto");
            else
                System.out.println("Codigo: " + codProd + " | Produto: " + status);
            System.out.println("Deseja pesquisar mais produtos ? ");
            condicao = !(scanner.nextLine().toLowerCase().equals("n"));
        }while(condicao);

    }

    private void modificarProd(){
        int codigo = 0;
        int escolha = 0;
        String status = "";

        while(true) {
            System.out.println("O que você deseja alterar");
            System.out.println("1 - Nome do produto");
            System.out.println("2 - Quantidade do produto");
            System.out.println("3 - Retornar ao menu anterior");

            escolha = Validador.validarInt(scanner.nextLine());

            if(escolha == 3) {
                System.out.println("Voltando ao menu anterior ...");
                break;
            }

            System.out.println("Digite o código do produto");
            codigo = Validador.validarInt(scanner.nextLine());

            status = this.listaProdutos.pesquisarElemento(codigo);

            if(status.isEmpty())
                System.out.println("Codigo não existe, erro ao buscar produto");
            else{
                switch (escolha){
                    case 1:
                        System.out.println("Digite o novo nome do produto");
                        this.listaProdutos.setValores(scanner.nextLine(), codigo);
                        System.out.println("Sucesso ao realizar alteração");
                        break;
                    case 2:
                        System.out.println("Digite a nova quantidade dos produtos");
                        this.listaProdutos.setQuantidade(Validador.validarInt(scanner.nextLine()), codigo);
                        System.out.println("Sucesso ao realizar alteração");
                        break;
                    default:
                        System.out.println("Digite um numero valido");
                        break;
                }
                System.out.println("\n\n");
            }
        }


    }
}
