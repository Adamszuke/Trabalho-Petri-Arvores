public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Arvore Binaria criada com sucesso!");
    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);
        if (estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    private void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O no " + novoNo.getConteudo() + " foi inserido na Arvore.");
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo().equals(novoNo.getConteudo())) {
            System.out.println("Nao e possivel informar nos repetidos.");
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O no " + novoNo.getConteudo() + " foi inserido na Arvore.");
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public void remover(Integer conteudo) {
        if (estaVazia()) {
            System.out.println("A arvore esta vazia. Nao ha nada a remover.");
            return;
        }
        this.raiz = removerRecursivo(this.raiz, conteudo);
    }

    private No removerRecursivo(No atual, Integer conteudo) {

        if (atual == null) {
            System.out.println("Valor " + conteudo + " nao encontrado na arvore.");
            return null;
        }

        if (conteudo < atual.getConteudo()) {
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), conteudo));

        } else if (conteudo > atual.getConteudo()) {
            atual.setDireita(removerRecursivo(atual.getDireita(), conteudo));

        } else {
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                System.out.println("[Caso 1 - Folha] No " + conteudo + " removido.");
                return null; 

            } else if (atual.getEsquerda() == null) {
                System.out.println("[Caso 2 - Um filho] No " + conteudo
                        + " substituido pelo filho direito " + atual.getDireita().getConteudo() + ".");
                return atual.getDireita(); 

            } else if (atual.getDireita() == null) {
                System.out.println("[Caso 2 - Um filho] Nó " + conteudo
                        + " substituido pelo filho esquerdo " + atual.getEsquerda().getConteudo() + ".");
                return atual.getEsquerda(); 

            } else {
                No sucessor = encontrarSucessor(atual.getDireita());
                System.out.println("[Caso 3 - Dois filhos] No " + conteudo
                        + " substituido pelo sucessor " + sucessor.getConteudo() + ".");

                atual.setConteudo(sucessor.getConteudo());

                atual.setDireita(removerRecursivo(atual.getDireita(), sucessor.getConteudo()));
            }
        }

        return atual; 
    }

    private No encontrarSucessor(No no) {
        No atual = no;
        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }
        return atual;
    }

    public boolean estaVazia() {
        return this.raiz.getConteudo() == null;
    }

    private void preOrdem(No no) {
        if (no == null) return;
        System.out.print(no.getConteudo() + " ");
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if (no == null) return;
        emOrdem(no.getEsquerda());
        System.out.print(no.getConteudo() + " ");
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if (no == null) return;
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.print(no.getConteudo() + " ");
    }

    public void exibir(String percurso) {
        System.out.print("Percurso " + percurso + ": ");
        switch (percurso) {
            case "Pre": preOrdem(this.raiz); break;
            case "Em":  emOrdem(this.raiz);  break;
            case "Pos": posOrdem(this.raiz); break;
        }
        System.out.println();
    }
}