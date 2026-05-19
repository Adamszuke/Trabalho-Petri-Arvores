public class Main {
    public static void main(String[] args) {

        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(0);
        arvore.inserir(-3);
        arvore.inserir(-5);
        arvore.inserir(-4);
        arvore.inserir(5);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(10);
        arvore.inserir(7);
        arvore.inserir(9);

        System.out.println("Arvore inicial");
        arvore.exibir("Em");

        // Caso 1 – Nó folha
        System.out.println("Caso 1: removendo no folha (-4)");
        arvore.remover(-4);
        arvore.exibir("Em");
        // Esperado: -5 -3 0 3 4 5 7 9 10

        // CASO 2: Remoção de nó com um filho
        System.out.println("Caso 2: removendo no com um filho (-5)");
        arvore.remover(-5);
        arvore.exibir("Em");
        // Esperado: -3 0 3 4 5 7 9 10

        // CASO 3: Remoção de nó com dois filhos
        System.out.println("Caso 3: removendo no com dois filhos (5)");
        arvore.remover(5);
        arvore.exibir("Em");
        // Esperado: -3 0 3 4 7 9 10
        // Sucessor de 5 é 7 (menor valor da subárvore direita de 5)

        // CASO 4 extra: remoção da raiz 
        System.out.println("Caso 4: removendo a raiz (0)");
        arvore.remover(0);
        arvore.exibir("Em");
        // Esperado: -3 3 4 7 9 10
        // Sucessor de 0 é 3 (menor da subárvore direita)

        // Valor inexistente 
        System.out.println("Tentativa de remover valor inexistente (99)");
        arvore.remover(99);
    }
}