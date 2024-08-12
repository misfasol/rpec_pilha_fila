class Pilha {

    public static void main(String[] args) {
        Pilha p = new Pilha(100);
        p.adicionar(5);
        p.adicionar(7);
        p.adicionar(2);
        System.out.println(p);
        p.tirar();
        p.tirar();
        p.tirar();
        System.out.println(p);
    }

    int topo;
    int[] pilha;
    int tamanho;

    Pilha(int tamanho) {
        this.topo = -1;
        this.pilha = new int[tamanho];
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return String.format("topo: %d", topo);
    }

    boolean vazio() {
        return topo < 0;
    }

    boolean cheio() {
        return topo == tamanho - 1;
    }

    void adicionar(int valor) {
        if (!cheio()) {
            topo++;
            pilha[topo] = valor;
        }
    }

    void tirar() {
        if (!vazio()) {
            topo--;
        }
    }

    int mostrar() {
        return pilha[topo];
    }
}
