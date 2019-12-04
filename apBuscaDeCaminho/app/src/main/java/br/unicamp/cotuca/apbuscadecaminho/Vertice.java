package br.unicamp.cotuca.apbuscadecaminho;
import java.io.Serializable;
import java.io.*;
import java.lang.Comparable;
import java.lang.*;

///
/// CLASSE ADAPTADA DA APOSTILA DO PROFESSOR FRANCISCO RODRIGUES.
///


public class Vertice
{
    public boolean foiVisitado;
    public String rotulo;
    private boolean estaAtivo;

    public Vertice(String label)
    {
        rotulo = label;
        foiVisitado = false;
        estaAtivo = true;
    }

}

