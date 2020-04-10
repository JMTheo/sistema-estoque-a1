package uam.estrturaDados;

public class Lista {
    private String [] valores;
    private int tamanho;

    public Lista(int tamanho){
        if (tamanho > 0) {
            this.tamanho = tamanho;
            this.valores = new String[tamanho];
        }
    }

    public String inserirVlr(String valor, int pos){
        if(verificarNulo(pos)){
            this.valores[pos] = valor;
            return valor;
        }
        else
            return "";
    }

    public String removerVlr(int pos){
        String valor;
        if(verificarNulo(pos)){
            valor = this.valores[pos];
            this.valores[pos] = "";
            return valor;
        }
        else return "";
    }

    public void listarTodosProdutos(){
        for(int i = 0; i < this.tamanho; i++){
            System.out.println("Codigo: " + i + " | Produto: " + this.valores[i]);
        }
    }

    public String pesquisarElemento(int cod){
        if(verificarNulo(cod))
            return this.valores[cod];
        else
            return "";
    }
    //Método para verificar se a posição é valida p/ continuar com o processo
    private boolean verificarNulo(int pos){
        return pos >= 0 && pos < this.valores.length;
    }

    public int getTamanho() {
        return tamanho;
    }
}
