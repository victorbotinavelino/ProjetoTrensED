package br.unicamp.cotuca.apbuscadecaminho;
import java.io.Serializable;
import java.io.*;
import java.lang.Comparable;
import java.lang.*;



///
/// Guilherme Salim de Barros - 18188 \\ Victor Botin Avelino - 18172
///

public class Caminho implements Comparable<Caminho>, Serializable, Chaveavel
{
        //Atributos:
        private String cidadeOrigem;
        private String cidadeDestino;
        private int distancia;
        private int tempo;
        //Constantes dos atributos:
        final int INICIOIDORIGEM = 0;
        final int TAMANHOIDORIGEM = 15;
        final int INICIOIDDESTINO = INICIOIDORIGEM + TAMANHOIDORIGEM;
        final int TAMANHOIDDESTINO = 16;
        final int INICIODISTANCIA = INICIOIDDESTINO + TAMANHOIDDESTINO;
        final int TAMANHODISTANCIA = 5;
        final int INICIOTEMPO = INICIODISTANCIA + TAMANHODISTANCIA;
        final int TAMANHOTEMPO = 3;

        //Métodos acessores dos atributos:

        public String getcidadeOrigem()
        {
            return this.cidadeOrigem;
        }

        public String getcidadeDestino()
        {
            return this.cidadeDestino;
        }

        public int getDistancia()
        {
            return this.distancia;
        }

        public int getTempo()
        {
            return this.tempo;
        }

        public void setcidadeOrigem(String novo)
        {
            this.cidadeOrigem = novo;
        }

        public void setcidadeDestino(String novo)
        {
            this.cidadeDestino = novo;
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
            this.cidadeOrigem = s.substring(INICIOIDORIGEM, TAMANHOIDORIGEM).trim();
            this.cidadeDestino = s.substring(INICIOIDDESTINO, TAMANHOIDDESTINO).trim();
            this.distancia = Integer.parseInt(s.substring(INICIODISTANCIA, TAMANHODISTANCIA).trim());
            this.tempo = Integer.parseInt(s.substring(INICIOTEMPO, TAMANHOTEMPO));
        }   

        public int CompareTo(Caminho caminho)
        {
            return this.distancia - caminho.distancia;
        }

        public Caminho(String cidadeOrigem, String cidadeDestino)
        {
            this.cidadeOrigem = cidadeOrigem;
            this.cidadeDestino = cidadeDestino;
        }

        public Caminho(Caminho modelo) throws Exception
        {
            if (modelo == null)
                throw new Exception("Modelo ausente");

            this.cidadeOrigem = modelo.cidadeOrigem;
            this.cidadeDestino = modelo.cidadeDestino;
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

    @Override
    public String getChave() {
        return null;
    }
}
