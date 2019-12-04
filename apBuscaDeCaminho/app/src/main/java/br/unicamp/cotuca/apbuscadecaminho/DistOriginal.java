package br.unicamp.cotuca.apbuscadecaminho;
import java.io.Serializable;
import java.io.*;
import java.lang.Comparable;
import java.lang.*;

///
/// CLASSE ADAPTADA DA APOSTILA DO PROFESSOR FRANCISCO RODRIGUES.
///


public class DistOriginal
{
    public int distancia;
    public int verticePai;
    public DistOriginal(int vp, int d)
    {
        distancia = d;
        verticePai = vp;
    }
}

