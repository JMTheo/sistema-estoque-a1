package uam.estrturaDados;

public class Lista {
    private String[] valores;
    private int[] quantidade;
    private int tamanho;

    public Lista(int tamanho) {
        if (tamanho > 0) {
            this.tamanho = tamanho;
            this.valores = new String[tamanho];
            this.quantidade = new int[tamanho];

            for(int i = 0; i < tamanho; i++){
                this.valores[i] = "";
                this.quantidade[i] = 0;
            }
        }
    }

    public String inserirVlr(String valor, int pos, int qtd) {
        if (verificarNulo(pos)) {
            this.valores[pos] = valor;
            this.quantidade[pos] = qtd;
            return valor;
        } else
            return "";
    }

    public String removerVlr(int pos) {
        String valor;
        if (verificarNulo(pos)) {
            valor = this.valores[pos];
            this.valores[pos] = "";
            this.quantidade[pos] = 0;
            return valor;
        } else return "";
    }

    public void listarTodosProdutos() {
        for (int i = 0; i < this.tamanho; i++) {
            if (!this.valores[i].isEmpty())
                System.out.println("Codigo: " + i + " | Produto: " + this.valores[i] + " | QTD: " + this.quantidade[i]);
        }
    }

    public String pesquisarElemento(int cod) {
        if (verificarNulo(cod))
            return this.valores[cod] + " | Quantidade: " + this.quantidade[cod];
        else
            return "";
    }

    //Método para verificar se a posição é valida p/ continuar com o processo
    private boolean verificarNulo(int pos) {
        return pos >= 0 && pos < this.valores.length;
    }

    public int getTamanho() {
        return tamanho;
    }

    //Os dois métodos abaixo são questionaveis
    public void setValores(String valores, int pos) {
        this.valores[pos] = valores;
    }

    public void setQuantidade(int quantidade, int pos) {
        this.quantidade[pos] = quantidade;
    }
}
