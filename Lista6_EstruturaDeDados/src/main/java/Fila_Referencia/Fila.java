package Fila_Referencia;

public class Fila {
    Nodo fim;
    Nodo inicio;
    Integer tamanho;

    //Fila vazia
    Fila() {
        fim = null;
        inicio = null;
        tamanho = 0;
    }

    //Inserir elementos
    public void inserirValor(Integer numero) {
        Nodo nodo = new Nodo();
        nodo.valor = numero; //atribui a estrutura inicializada o parametro recebido
        nodo.proximo = fim; //atribui a referência do nodo criado a informação do inicio
        fim = nodo; //atribui ao ponteiro qual o novo "inicio", neste caso o próprio nodo

        if (tamanho == 0) {
            inicio = nodo;
        }
        tamanho++;
    }

    //Retirar elementos
    public Integer removerValor() {
        //verificar se está vazia
        if (fim == null) {
            return null;
        }
        Integer deletado = inicio.valor; //armazena o valor do primeiro da fila a sair

        if (tamanho == 1) {
            inicio = null;
            fim = null;
        } else {
            Nodo aux = fim;

            //percorrer a fila do final até o seu 1 elemento antes do início e mudar o ponteiro de inicio para fazer a retirada
            while (aux.proximo != inicio) {
                aux = aux.proximo;
            }

            inicio = aux; //inicio da fila vira o segundo elemento, para o primeiro sair;
            inicio.proximo = null;
        }
        tamanho--;
        System.out.println("Elemento retirado: "+ deletado);
        return deletado;
    }

    //Exibir elementos da fila
    public void exibir() {
        if (fim == null) {
            System.out.println("[]");
            return;
        }

        Nodo aux = fim; //começa a percorrer de trás pra frente
        System.out.print("[");
        while (aux != null) {
            System.out.print(aux.valor);
            aux = aux.proximo;
            if (aux != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Tamanho da fila
    public Integer retornarTamanho() {
        System.out.println("Tamanho: " + tamanho);
        return tamanho;
    }

    //Pesquisar por valor especifico na fila
    public void pesquisar(Integer numero) {
        //Se a lista estiver vazia
        if (fim == null) {
            System.out.println("O valor " + numero + " não foi encontrado");
        }

        Nodo aux = fim; //começa a percorrer de trás pra frente
        while (aux != null) {
            if (aux.valor.equals(numero)) {
                System.out.println("O valor " + numero + " foi encontrado");
                return;
            } else {
                aux = aux.proximo;
            }
        }
        System.out.println("O valor " + numero + " não foi encontrado");
    }

    public static void main(String[] args) {
        Fila f = new Fila();
        f.inserirValor(5);
        f.inserirValor(10);
        f.inserirValor(50);
        f.inserirValor(45);
        f.inserirValor(60);
        f.retornarTamanho();
        f.exibir();
        f.pesquisar(45);
        f.pesquisar(90);
        f.removerValor();
        f.removerValor();
        f.retornarTamanho();
        f.exibir();
    }
}

