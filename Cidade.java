/// 
/// Guilherme Salim de Barros - 18188 \\ Victor Botin Avelino - 18172
///

    class Cidade implements Comparable
    {
        //Atributos:
        private int idCidade;
        private String nome;
        private int coordenadaX;
        private int coordenadaY;

        //Constantes dos atributos:
        final int INICIOID = 0;
        final int TAMANHOID = 3;
        final int INICIONOME = INICIOID + TAMANHOID;
        final int TAMANHONOME = 15;
        final int INICIOX = INICIONOME + TAMANHONOME;
        final int TAMANHOX = 5;
        final int INICIOY = INICIOX + TAMANHOX;
        final int TAMANHOY = 5;

        //Métodos acessores dos atributos:
        public int getIdCidade()
        {
             return this.idCidade;
        }
        public String getNome() 
        {
             return this.nome;
        }
        public int getCoordenadaX()
        {
             return this.coordenadaX;
        }
        public int getCoordenadaY()
        {
             return this.coordenadaY;
        }

        // Setters dos atributos:
         public int setIdCidade(int novoId) throws Exception
        {
             if(this.novoId == null)
                    throw new Exception("Parâmetro nulo!");

            this.idCidade = novoId;

        }

        public string setNome(String novoNome) throws Exception
        { 
             if(this.novoNome.equals(""))
                    throw new Exception("Parâmetro nulo!");

            this.nome = novoNome;
        }

        public int setCoordenadaX(int novaCoordenadaX) throws Exception
        { 
             if(this.novaCoordenadaX.equals(""))
                    throw new Exception("Parâmetro nulo!");

            this.coordenadaX = novaCoordenadaX;
        }

        public int setCoordenadaY(int novaCoordenadaY) throws Exception
        { 
             if(this.novaCoordenadaY.equals(""))
                    throw new Exception("Parâmetro nulo!");

            this.coordenadaY = novaCoordenadaY;
        }


        //Construtor da classe. Especificamente, este construtor atribui
        //aos atributos os dados de uma linha do arquivo texto.
        public cidade(String linhaArquivo)
        {
            this.idCidade = Integer.parseInt(linhaArquivo.substring(INICIOID, TAMANHOID));
            this.nome = linhaArquivo.substring(INICIONOME, TAMANHONOME);
            this.coordenadaX = Integer.parseInt(linhaArquivo.substring(INICIOX, TAMANHOX));
            this.coordenadaY = Integer.parseInt(linhaArquivo.substring(INICIOY, TAMANHOY));
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
