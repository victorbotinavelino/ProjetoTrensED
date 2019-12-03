/// 
/// Guilherme Salim de Barros - 18188 \\ Victor Botin Avelino - 18172
///

class Caminho implements Comparable, Cloneable
{
        //Atributos:
        private int idCidadeOrigem;
        private int idCidadeDestino;
        private int distancia;
        private int tempo;
        //Constantes dos atributos:
        final int INICIOIDORIGEM = 0;
        final int TAMANHOIDORIGEM = 3;
        final int INICIOIDDESTINO = INICIOIDORIGEM + TAMANHOIDORIGEM;
        final int TAMANHOIDDESTINO = 3;
        final int INICIODISTANCIA = INICIOIDDESTINO + TAMANHOIDDESTINO;
        final int TAMANHODISTANCIA = 5;
        final int INICIOTEMPO = INICIODISTANCIA + TAMANHODISTANCIA;
        final int TAMANHOTEMPO = 4;

        //Métodos acessores dos atributos:

        public int getIdCidadeOrigem()
        {
            return this.idCidadeOrigem;
        }

        public int getIdCidadeDestino()
        {
            return this.idCidadeDestino;
        }

        public int getDistancia()
        {
            return this.distancia;
        }

        public int getTempo()
        {
            return this.tempo;
        }

        public int setIdCidadeOrigem(int novoId) throws Exception
        {
            if(this.novoId.Equals(""))
                   throw new Exception("Parâmetro nulo!");

            this.idCidadeOrigem = novoId;
        }

        public int setIdCidadeDestino(int novoId) throws Exception
        {
            if(this.novoId.Equals(""))
                   throw new Exception("Parâmetro nulo!");

            this.idCidadeDestino = novoId;
        }

        public int setDistancia(int novaDistancia) throws Exception
        {
            if(this.novaDistancia.Equals(""))
                   throw new Exception("Parâmetro nulo!");

            this.distancia = novaDistancia;
        }

        public int setTempo(int novoTempo) throws Exception
        {
            if(this.novoTempo.Equals(""))
                   throw new Exception("Parâmetro nulo!");

            this.tempo = novoTempo;
        }

        //Construtor da classe. Especificamente, este construtor atribui
        //aos atributos os dados de uma linha do arquivo texto.
        public Caminho(String s)
        {
            this.idCidadeOrigem = Integer.parseInt(s.substring(INICIOIDORIGEM, TAMANHOIDORIGEM)); 
            this.idCidadeDestino = Integer.parseInt(s.substring(INICIOIDDESTINO, TAMANHOIDDESTINO));
            this.distancia = Integer.parseInt(s.substring(INICIODISTANCIA, TAMANHODISTANCIA));
            this.tempo = Integer.parseInte(s.substring(INICIOTEMPO, TAMANHOTEMPO));
        }   

        public int CompareTo(Caminho caminho)
        {
            return this.distancia - caminho.distancia;
        }

        public Caminho(int idCidadeOrigem, int idCidadeDestino)
        {
            this.IDCIDADEORIGEM = idCidadeOrigem;
            this.IDCIDADEDESTINO = idCidadeDestino;
        }

        public Caminho(Caminho modelo)
        {
            if (modelo == null)
                throw new Exception("Modelo ausente");

            this.idCidadeOrigem = modelo.idCidadeOrigem;
            this.idCidadeDestino = modelo.idCidadeDestino;
            this.distancia = modelo.distancia;
            this.tempo = modelo.tempo;
            this.custo = modelo.custo;
        }

        public Object Clone()
        {
            Caminho obj = null;

            try
            {
                obj = new Caminho(this);
            }
            catch (Exception erro)
            {
            }

            return obj;
        }
    }
}