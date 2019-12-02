
class FilaLista<Dado> : ListaSimples<Dado>
{
  public void enfileirar(Dado elemento) // inclui objeto “elemento”
  {
    NoLista<Dado> novoNo = new NoLista<Dado>(elemento, null);
    super.inserirAposFim(novoNo);
  }
  public Dado retirar() // devolve objeto do início e o
  {                     // retira da fila
    if (!estaVazia())
    {
      Dado elemento = super.primeiro.Info;
      super.removerNo(null, Primeiro);
      return elemento;
    }
    throw new Exception("Fila vazia");
  }
  public Dado oInicio() // devolve objeto do início
  {                     // sem retirá-lo da fila
    if (estaVazia())
      throw new Exception("Fila vazia");
    Dado o = super.primeiro.Info; // acessa o 1o objeto genérico
    return o;
  }
  public Dado oFim() // devolve objeto do fim
  {                  // sem retirá-lo da fila
    if (estaVazia())
      throw new Exception("Fila vazia");

    Dado o = super.ultimo.Info; // acessa o 1o objeto genérico
    return o;
  }
  public int tamanho() // devolve número de elementos da fila
  {
    return super.quantosNos;  // tamanho da lista ligada herdada
  }
  public boolean estaVazia()
  {
    return super.estaVazia;
  }
  public Dado[] toArray()
  {
    Dado[] itens = new Dado[this.tamanho()];
    int indice = 0;
    super.iniciarPercursoSequencial();
    while (super.podePercorrer())
          itens[indice++] = super.atual.Info;

    return itens;
  }
}