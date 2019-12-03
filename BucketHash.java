    class BucketHash
    {
        private final int SIZE = 101;
        ListaSimples<int> lista;

        public BucketHash()
        {
            lista = new ListaSimples<int>();

            lista.percorrerLista();
        }

        public int hash(string s)
        {
            long total = 0;

            foreach (char c in s)
                total += 37 * total + (int)c;

            total = total % data.GetUpperBound(0);
            if (total < 0)
                total += data.GetUpperBound(0);

            return (int)total;
        }

        public void inserir(String item) throws Exception
        {
            int valorDeHash;
            valorDeHash = Hash(item);
            
            if(existeDado(valorDeHash))
            throw new Exception("O dado já existe.");
            else
                lista.inserirEmOrdem(valorDeHash);
        }

        public void remover(string item) throws Exception
        {
            int valorDeHash2;
            valorDeHash2 = Hash(item);

            if (!existeDado(valorDeHash2))
            throw new Exception("O dado não existe.");
            else
                lista.remover(valorDeHash2);
            
        }

        public void Exibir()
        {
            while(lista.percorrerLista())
            {
                System.out.println(lista.getAtual().toString());
            }
        }
    }
