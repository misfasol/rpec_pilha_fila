import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;
        Fila f = new Fila(2);
        while (rodando) {
            System.out.println();
            System.out.println("1: Inserir");
            System.out.println("2: Remover e printar");
            System.out.println("3: Printar");
            System.out.println("4: Sair");
            System.out.print("Sua opcao: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Qual valor: ");
                    int valor = scanner.nextInt();
                    f.inserir(valor);
                    break;
                case 2:
                    int removido = f.remover();
                    System.out.println("Valor removido: " + removido);
                    break;
                case 3:
                    f.printar();
                    break;
                case 4:
                    rodando = false;
                    break;
            }
        }
        scanner.close();
    }
}

class Fila {

    int primeiro;
    int ultimo;
    int[] vetor;
    int tamanho;

    public Fila(int tamanho) {
        primeiro = -1;
        ultimo = -1;
        vetor = new int[tamanho];
        this.tamanho = tamanho;
    }

    public void printar() {
        int qtd = ultimo - primeiro + 1;
        if (ultimo < primeiro) {
            qtd += tamanho;
        } else if (ultimo == -1) {
            qtd = 0;
        }
        System.out.printf(
            "prim: %d\tulti: %d\tqtd: %d\n",
            primeiro,
            ultimo,
            qtd
        );
        for (int i = 0; i < qtd; i++) {
            System.out.printf(
                "[%d]: %d\n",
                i,
                vetor[(i + primeiro + tamanho) % tamanho]
            );
        }
    }

    public boolean cheio() {
        if (primeiro < ultimo) {
            return primeiro + tamanho - 1 == ultimo;
        }
        return primeiro - 1 == ultimo;
    }

    public boolean vazio() {
        return primeiro == -1;
    }

    public void inserir(int i) throws FilaCheia {
        if (cheio()) {
            throw new FilaCheia();
        }
        if (primeiro == -1) {
            primeiro = 0;
        }
        ultimo = (ultimo + 1) % tamanho;
        vetor[ultimo] = i;
    }

    public int remover() throws FilaVazia {
        if (vazio()) {
            throw new FilaVazia();
        }
        int valor = vetor[primeiro];
        primeiro = (primeiro + 1) % tamanho;
        if (primeiro == (ultimo + 1) % tamanho) {
            primeiro = -1;
            ultimo = -1;
        }
        return valor;
    }
}

class FilaCheia extends Exception {

    public FilaCheia() {
        super();
    }
}

class FilaVazia extends Exception {

    public FilaVazia() {
        super();
    }
}
