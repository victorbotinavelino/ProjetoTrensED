package br.unicamp.cotuca.apbuscadecaminho;
import java.io.Serializable;
import java.io.*;
import java.lang.Comparable;
import java.lang.*;

///
/// CLASSE ADAPTADA DA APOSTILA DO PROFESSOR FRANCISCO RODRIGUES.
///

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

        public int hash(String cidade)
        {
            long total = 0;

            for(int i = 0; i < cidade.length(); i++)
                total += 37 * total + (int)cidade.charAt(i);

            total = total % vetor.length -1;
            if (total < 0)
                total += vetor.length -1;

            return (int)total;
        }

        public void inserir(Cidade cidade) throws Exception
        {
            int valorDeHash;
            valorDeHash = hash(cidade.getNome());

                if(vetor[valorDeHash].existeDado(cidade))
                    throw new Exception("O dado já existe.");
            
            vetor[valorDeHash].inserirEmOrdem(cidade);
        }

        public void remover(Cidade cidade) throws Exception
        {
            int valorDeHash2;
            valorDeHash2 = hash(cidade.getNome());
                if(vetor[valorDeHash2].existeDado(cidade))
                {
                    vetor[valorDeHash2].remover(cidade);
                    return;
                }
            
            throw new Exception("O dado já existe.");
            
            
        }

        public Cidade buscarCidade(String nomeProcurada)
        {
            int indice = hash(nomeProcurada);
            if(vetor[indice] == null)
                vetor[indice] = new ListaSimples<>();

            return vetor[indice].buscaChave(nomeProcurada);
        }



    }
