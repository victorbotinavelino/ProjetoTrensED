package br.unicamp.cotuca.apbuscadecaminho;

import java.io.Serializable;
import java.io.*;

public class NoLista<Dado extends Comparable<Dado> & Serializable>
{
        Dado info;
        NoLista<Dado> prox;

        public NoLista(Dado info, NoLista<Dado> prox)
        {
            this.info = info;
            this.prox = prox;
        }

        public Dado getInfo()
        {
            return this.info;
        }

        public NoLista<Dado> getProx()
        {
            return this.prox;
        }

    public void setInfo(Dado novoDado) throws Exception
    {
        if(novoDado == null)
            throw new Exception("Parâmetro nulo!");

        this.info = novoDado;
    }

    public void setProx(NoLista<Dado> novoProx) throws Exception
    {
        if(novoProx.info == null)
            throw new Exception("Parâmetro nulo!");
        this.prox = novoProx;
    }


}
