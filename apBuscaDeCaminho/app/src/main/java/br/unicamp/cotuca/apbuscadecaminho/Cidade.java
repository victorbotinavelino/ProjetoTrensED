package br.unicamp.cotuca.apbuscadecaminho;
import java.io.Serializable;
import java.io.*;
import java.lang.Comparable;
import java.lang.*;

///
/// Guilherme Salim de Barros - 18188 \\ Victor Botin Avelino - 18172
///

    public class Cidade implements Comparable<Cidade>, Serializable, Chaveavel
    {
        //Atributos:
        private int idCidade;
        private String nome;
        private float coordenadaX;
        private float coordenadaY;

        //Constantes dos atributos:
        final int INICIOID = 0;
        final int TAMANHOID = 2;
        final int INICIONOME = INICIOID + TAMANHOID;
        final int TAMANHONOME = 16;
        final int INICIOX = INICIONOME + TAMANHONOME;
        final int TAMANHOX = 5;
        final int INICIOY = INICIOX + TAMANHOX + 1;
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
        public float getCoordenadaX()
        {
             return this.coordenadaX;
        }
        public float getCoordenadaY()
        {
             return this.coordenadaY;
        }

        // Setters dos atributos:
         public void setIdCidade(int novoId) throws Exception
        {
            this.idCidade = novoId;
        }

        public void setNome(String novoNome) throws Exception
        {
            this.nome = novoNome;
        }

        public void setCoordenadaX(float novaCoordenadaX) throws Exception
        {
            this.coordenadaX = novaCoordenadaX;
        }

        public void setCoordenadaY(float novaCoordenadaY) throws Exception
        {
            this.coordenadaY = novaCoordenadaY;
        }


        //Construtor da classe. Especificamente, este construtor atribui
        //aos atributos os dados de uma linha do arquivo texto.
        public Cidade(String linhaArquivo)
        {

            this.idCidade = Integer.parseInt(linhaArquivo.substring(INICIOID, TAMANHOID).trim());
            this.nome = linhaArquivo.substring(INICIONOME, INICIONOME + TAMANHONOME).trim();
            this.coordenadaX = Float.parseFloat(linhaArquivo.substring(INICIOX, TAMANHOX + INICIOX).trim().replace(',', '.'));
            this.coordenadaY = Float.parseFloat(linhaArquivo.substring(INICIOY, TAMANHOY + INICIOY).trim().replace(',', '.'));
        }

        public Cidade(int i)
        {
            this.idCidade = i;
            this.nome = null;
            this.coordenadaX = 0;
            this.coordenadaY = 0;
        }

        public int compareTo(Cidade c)
        {
            return this.idCidade - c.idCidade;
        }

        public String getChave()
        {
            return getNome();
        }

    }
