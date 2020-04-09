package uam.estrturaDados;

public class Lista {
    private int [] valores;
    private int tamanho;

    public Lista(int tamanho){
        if (tamanho > 0) {
            this.tamanho = tamanho;
            this.valores = new int[tamanho];
        }
    }

    public int inserirVlr(int valor, int pos){
        if(verificarNulo(pos)){
            this.valores[pos] = valor;
            return valor;
        }
        else
            return -1;
    }

    public int removerVlr(int pos){
        int valor;
        if(verificarNulo(pos)){
            valor = this.valores[pos];
            this.valores[pos] = 0;
            return valor;
        }
        else return -1;
    }

    //Método para verificar se a posição é valida
    private boolean verificarNulo(int pos){
        return pos >= 0 && pos < this.valores.length;
    }

    public int getTamanho() {
        return tamanho;
    }
}
