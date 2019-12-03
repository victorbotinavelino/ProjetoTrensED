package br.unicamp.cotuca.apbuscadecaminho;
import java.io.Serializable;
import java.io.*;
import java.lang.Comparable;
import java.lang.*;


public class BucketHash
    {
        private final int SIZE = 101;
        ListaSimples<Cidade>[] vetor;

        public BucketHash()
        {
            this.vetor = new ListaSimples[SIZE];
            for(int i = 0; i < SIZE; i++)
                this.vetor[i] = new ListaSimples<Cidade>();
        }

        public int hash(Cidade cidade)
        {
            long total = 0;

            for(int i = 0; i < cidade.getNome().length(); i++)
                total += 37 * total + (int)cidade.getNome().charAt(i);

            total = total % vetor.length -1;
            if (total < 0)
                total += vetor.length -1;

            return (int)total;
        }

        public void inserir(Cidade cidade) throws Exception
        {
            int valorDeHash;
            valorDeHash = hash(cidade);

            int indice;
            for(indice = 0; indice < SIZE; indice++)
                if(vetor[indice].existeDado(cidade))
                    throw new Exception("O dado já existe.");
            
            vetor[valorDeHash].inserirEmOrdem(cidade);
        }

        public void remover(Cidade cidade) throws Exception
        {
            int valorDeHash2;
            valorDeHash2 = hash(cidade);

             for(int indice = 0; indice < SIZE; indice++)
                if(vetor[indice].existeDado(cidade))
                {
                    vetor[valorDeHash2].remover(cidade);
                    return;
                }
            
            throw new Exception("O dado já existe.");
            
            
        }

    }
