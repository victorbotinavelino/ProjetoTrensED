/// 
/// Guilherme Salim de Barros - 18188 \\ Victor Botin Avelino - 18172
///

    class Cidade : IComparable<Cidade>
    {
        //Atributos:
        private int idCidade;
        private String nome;
        private int coordenadaX;
        private int coordenadaY;

        //Constantes dos atributos:
        const int inicioId = 0;
        const int tamanhoId = 3;
        const int inicioNome = inicioId + tamanhoId;
        const int tamanhoNome = 15;
        const int inicioX = inicioNome + tamanhoNome;
        const int tamanhoX = 5;
        const int inicioY = inicioX + tamanhoX;
        const int tamanhoY = 5;

        //Getters dos atributos:
        public int getIdCidade()
        {
             return idCidade;
        }
        public String getNome() 
        {
             return nome;
        }
        public int getCoordenadaX()
        {
             return coordenadaX;
        }
        public int getCoordenadaY()
        {
             return coordenadaY;
        }

        // Setters dos atributos:
         public int setIdCidade(int novoId) throws Exception
        {
             if(novoId == null)
                    throw new Exception("Parâmetro nulo!");

            this.idCidade = novoId;

        }

        public string setNome(String novoNome) 
        { 
             if(novoNome == null)
                    throw new Exception("Parâmetro nulo!");

            this.nome = novoNome;
        }

        public int setCoordenadaX(int novaCoordenadaX)
        { 
             if(novaCoordenadaX == null)
                    throw new Exception("Parâmetro nulo!");

            this.coordenadaX = novaCoordenadaX;
        }

        public int setCoordenadaY(int novaCoordenadaY)
        { 
             if(novaCoordenadaY == null)
                    throw new Exception("Parâmetro nulo!");

            this.coordenadaY = novaCoordenadaY;
        }


        //Construtor da classe. Especificamente, este construtor atribui
        //aos atributos os dados de uma linha do arquivo texto.
        public cidade(string linhaArquivo)
        {
            this.idCidade = int.Parse(linhaArquivo.Substring(inicioId, tamanhoId));
            this.nome = linhaArquivo.Substring(inicioNome, tamanhoNome);
            this.coordenadaX = int.Parse(linhaArquivo.Substring(inicioX, tamanhoX));
            this.coordenadaY = int.Parse(linhaArquivo.Substring(inicioY, tamanhoY));
        }

        public cidade(int i)
        {
            this.idCidade = i;
            this.nome = null;
            this.coordenadaX = 0;
            this.coordenadaY = 0;
        }

        public int compareTo(Cidade c)
        {
            return this.IdCidade - c.IdCidade;
        }
    }
