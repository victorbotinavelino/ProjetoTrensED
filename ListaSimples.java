﻿public class ListaSimples<Dado extends Comparable<Dado> & Serializable> implements Comparable & Serializable
{
    private NoLista primeiro, ultimo, anterior, atual;
    int quantosNos;

    public ListaSimples()
    {
        primeiro = ultimo = anterior = atual = null;
        quantosNos = 0;
    }

    public void percorrerLista()
    {
        PrintWriter saida = new PrintWriter
        (new BufferedWriter(new FileWriter("nomeDoArquivo")));

        atual = primeiro;
        while (atual != null)
        {
            saida.println(atual.info);
            atual = atual.prox;
        }
    }

    public boolean estaVazia()
    {
        if(primeiro == null)
        return true;
    }

    public NoLista getPrimeiro { return this.primeiro; }

    public NoLista getUltimo { return this.ultimo }

    public int getQuantosNos { return this.quantosNos; }

    public NoLista getAtual { return this.atual; }

    public void inserirAntesDoInicio(NoLista novoNo)
    {
        if (estaVazia)
            ultimo = novoNo;
        novoNo.Prox = primeiro;
        primeiro = novoNo;
        quantosNos++;
    }

    public void inserirAntesDoInicio(Dado informacao)
    {
        if (informacao != null)
        {
            var novoNo = new NoLista(informacao, null);
            inserirAntesDoInicio(novoNo);
        }
    }

    public void inserirAposFim(NoLista novoNo)
    {
        if (estaVazia)
            primeiro = novoNo;
        else
            ultimo.Prox = novoNo;
        novoNo.Prox = null;
        ultimo = novoNo;
        quantosNos++;
    }

    public void inserirAposFim(Dado informacao)
    {
        if (informacao != null)
        {
            var novoNo = new NoLista(informacao, null);
            inserirAposFim(novoNo);
        }
    }


  public boolean existeDado(Dado outroProcurado)
  {
    anterior = null;
    atual = primeiro;

    // Em seguida, é verificado se a lista está vazia. Caso esteja, é
    // retornado false ao local de chamada, indicando que a chave não foi
    // encontrada, e atual e anterior ficam valendo null

    if (estaVazia)
      return false;

    // a lista não está vazia, possui nós
    // dado procurado é menor que o primeiro dado da lista:
    // portanto, dado procurado não existe

    if (outroProcurado.CompareTo(primeiro.Info) < 0)
      return false;

    // dado procurado é maior que o último dado da lista:
    // portanto, dado procurado não existe

    if (outroProcurado.CompareTo(ultimo.Info) > 0)
    {
      anterior = ultimo;
      atual = null;
      return false;
    }

    // caso não tenha sido definido que a chave está fora dos limites de
    // chaves da lista, vamos procurar no seu interior

    // o apontador atual indica o primeiro nó da lista e consideraremos que
    // ainda não achou a chave procurada nem chegamos ao final da lista

    boolean achou = false;
    boolean fim = false;

    // repete os comandos abaixo enquanto não achou o RA nem chegou ao
    // final da lista
    while (!achou && !fim)
    {
      // se o apontador atual vale null, indica final da lista
      if (atual == null)
        fim = true;

      // se não chegou ao final da lista, verifica o valor da chave atual
      else
      // verifica igualdade entre chave procurada e chave do nó atual
      if (outroProcurado.compareTo(atual.Info) == 0)
        achou = true;
      else
      // se chave atual é maior que a procurada, significa que
      // a chave procurada não existe na lista ordenada e, assim,
      // termina a pesquisa indicando que não achou. Anterior
      // aponta o anterior ao atual, que foi acessado por
      // último
      if (atual.info.compareTo(outroProcurado) > 0)
        fim = true;
      else
      {
        // se não achou a chave procurada nem uma chave > que ela,
        // então a pesquisa continua, de maneira que o apontador
        // anterior deve apontar o nó atual e o apontador atual
        // deve seguir para o nó seguinte
        anterior = atual;
        atual = atual.Prox;
      }
    }
    // por fim, caso a pesquisa tenha terminado, o apontador atual
    // aponta o nó onde está a chave procurada, caso ela tenha sido
    // encontrada, ou o nó onde ela deveria estar para manter a
    // ordenação da lista. O apontador anterior aponta o nó anterior
    // ao atual
    return achou; // devolve o valor da variável achou, que indica
                  // se a chave procurada foi ou não encontrado
}

  public void inserirEmOrdem(Dado dados)
  {
    if (!existeDado(dados)) // existeDado configurou anterior e atual
    {                       // aqui temos certeza de que a chave não existe
      NoLista novo = new NoLista(dados, null); // guarda dados no
                                                     // novo nó
      if (estaVazia) // se a lista está vazia, então o
        inserirAntesDoInicio(novo); // novo nó é o primeiro da lista
      else
      if (anterior == null && atual != null)
        inserirAntesDoInicio(novo); // liga novo antes do primeiro
      else
        inserirNoMeio(novo); // insere entre os nós anterior e atual
    }
  }

  private void inserirNoMeio(NoLista<Dado> novo)
  {
    // existeDado() encontrou intervalo de inclusão do novo nó
    anterior.Prox = novo; // liga anterior ao novo
    novo.Prox = atual; // e novo no atual
    if (anterior == ultimo) // se incluiu ao final da lista,
      ultimo = novo; // atualiza o apontador ultimo
    quantosNos++; // incrementa número de nós da lista
  }

  public bool remover(Dado dados)
  {
    if (!existeDado(dados))  // ajusta ponteiros atual e anterior
       return false;

    // aqui, temos certeza de que a lista não está vazia, 
    // que o dado procurado existe, e seu
    // nó é apontado pelo atributo atual. 
    // O nó anterior é apontado pelo atributo anterior.

    RemoverNo(anterior, atual);

    return true;
  }

  protected void RemoverNo(NoLista anterior, NoLista atual)
  {
    if (anterior == null && atual != null) // o procurado é o 1o nó
    {
      primeiro = atual.Prox;
      if (primeiro == null) // lista ficou vazia
        ultimo = null;      // ajustamos ultimo para não ficar lixo
    }
    else
    {
      anterior.Prox = atual.Prox;
      if (atual == ultimo)
        ultimo = anterior;
    }
    quantosNos--;
  }

  private void procurarMenor(ref NoLista antM, 
                             	              ref NoLista atuM)
  {
    antM = anterior = null;
    atuM = atual = primeiro;
    while (atual != null)
    {
      if (atual.Info.compareTo(atuM.Info) < 0 )
      {
        antM = anterior;
        atuM = atual;
      }
      anterior = atual;
      atual = atual.Prox;
    }
  }
  public void ordenar()
  {
    NoLista<Dado> menor = null, antMenor = null, noAIncluir = null;
    var listaOrdenada = new ListaSimples();
    while (!this.EstaVazia)
    {
      procurarMenor(ref antMenor, ref menor);
      noAIncluir = menor;  // reaproveitamos os nós da lista original
      this.RemoverNo(antMenor, menor);
      listaOrdenada.InserirAposFim(noAIncluir);
    }
    this.primeiro = listaOrdenada.primeiro;
    this.ultimo = listaOrdenada.ultimo;
    this.quantosNos = listaOrdenada.quantosNos;
    this.atual = this.anterior = null;
  }