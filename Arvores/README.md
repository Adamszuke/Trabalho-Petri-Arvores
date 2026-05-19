# Relatório da Atividade
Professor: Ricardo Petri

---

## Casos de remoção

### Caso 1 – Nó folha
Um nó folha é aquele que não possui nenhum filho, ou seja, suas ramificações (ponteiros para a esquerda e para a direita) apontam para NULL

### Caso 2 – Nó com um filho
Quando o nó possui apenas um filho (esquerdo ou direito), ele é substituído diretamente por esse filho. O pai do nó removido passa a apontar para o neto, mantendo a propriedade da Árvore intacta, pois os valores já estavam corretamente posicionados.

### Caso 3 – Nó com dois filhos 
Como previsto pela atividade foi-se utilizado o método sucessor ou o menor dos maiores.

1. Localiza-se o **sucessor**: o nó mais à esquerda da subárvore **direita** do nó a ser removido. Esse nó contém o menor valor que ainda é maior que o nó a ser removido, garantindo que a propriedade da ABB seja preservada após a substituição.
2. O **conteúdo** do nó a ser removido é sobrescrito com o conteúdo do sucessor.
3. O **sucessor original** é então removido da subárvore direita. Como o sucessor é o nó mais à esquerda possível, ele possui **no máximo um filho direito**, reduzindo sua própria remoção ao Caso 1 ou ao Caso 2 — nunca ao Caso 3 novamente.

---
## Justificativa da escolha da recursividade

A implementação recursiva da remoção foi escolhida por manter coerência com a arquitetura já adotada no projeto, que utiliza recursão tanto na inserção (``inserirRecursivo``) quanto nos percursos da árvore (``preOrdem``, ``emOrdem`` e ``posOrdem``). Além disso, essa abordagem está alinhada à própria natureza recursiva da Árvore Binária de Busca, em que cada nó representa a raiz de uma subárvore que também é uma ABB válida. Dessa forma, chamadas como ``removerRecursivo(no.getEsquerda(), valor)`` expressam diretamente a lógica do problema. Outro ponto importante é que a técnica de “retornar o filho” elimina a necessidade de rastrear explicitamente o nó pai durante a remoção, simplificando a atualização das referências por meio de instruções como ``atual.setEsquerda(removerRecursivo(atual.getEsquerda(), conteudo));``. Isso torna o código mais limpo, legível e fácil de manter, já que os três casos clássicos de remoção ficam organizados em blocos condicionais claros. Embora a recursão tenha como desvantagem o maior consumo de pilha de chamadas em árvores desbalanceadas, esse impacto não representa um problema prático no contexto acadêmico deste projeto, onde a profundidade da árvore permanece controlada.

---
### Notas finais
Professor, não vou mentir para o senhor que usei um pouco de IA para gerar esse relatório em MD para que ficasse com um preview lefível e também utilizei para a organização dos textos, mas foi apenas para isso.
