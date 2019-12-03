package br.unicamp.cotuca.apbuscadecaminho;
import java.io.Serializable;
import java.io.*;
import java.lang.Comparable;
import java.lang.*;



///
/// Guilherme Salim de Barros - 18188 \\ Victor Botin Avelino - 18172
///

public class Caminho implements Comparable<Caminho>, Serializable
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

        public void setIdCidadeOrigem(int novoId)
        {
            this.idCidadeOrigem = novoId;
        }

        public void setIdCidadeDestino(int novoId)
        {
            this.idCidadeDestino = novoId;
        }

        public void setDistancia(int novaDistancia)
        {
            this.distancia = novaDistancia;
        }

        public void setTempo(int novoTempo)
        {
            this.tempo = novoTempo;
        }

        //Construtor da classe. Especificamente, este construtor atribui
        //aos atributos os dados de uma linha do arquivo texto.
        public Caminho(String s)
        {
            this.idCidadeOrigem = Integer.parseInt(s.substring(INICIOIDORIGEM, TAMANHOIDORIGEM)); 
            this.idCidadeDestino = Integer.parseInt(s.substring(INICIOIDDESTINO, TAMANHOIDDESTINO));
            this.distancia = Integer.parseInt(s.substring(INICIODISTANCIA, TAMANHODISTANCIA));
            this.tempo = Integer.parseInt(s.substring(INICIOTEMPO, TAMANHOTEMPO));
        }   

        public int CompareTo(Caminho caminho)
        {
            return this.distancia - caminho.distancia;
        }

        public Caminho(int idCidadeOrigem, int idCidadeDestino)
        {
            this.idCidadeOrigem = idCidadeOrigem;
            this.idCidadeDestino = idCidadeDestino;
        }

        public Caminho(Caminho modelo) throws Exception
        {
            if (modelo == null)
                throw new Exception("Modelo ausente");

            this.idCidadeOrigem = modelo.idCidadeOrigem;
            this.idCidadeDestino = modelo.idCidadeDestino;
            this.distancia = modelo.distancia;
            this.tempo = modelo.tempo;
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

    public int compareTo(Caminho c)
    {
        return this.distancia - c.distancia;
    }
}
