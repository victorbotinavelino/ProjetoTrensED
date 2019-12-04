package br.unicamp.cotuca.apbuscadecaminho;
import java.io.Serializable;
import java.io.*;
import java.lang.Comparable;
import java.lang.*;
import java.util.Stack;

///
/// CLASSE ADAPTADA DA APOSTILA DO PROFESSOR FRANCISCO RODRIGUES.
///

class Grafo
{
    private final int NUM_VERTICES = 20;
    private Vertice[] vertices;
    private Caminho[][] adjMatrix;
    int numVerts;

    /// ALGORITMO DE DIKSTRA
    DistOriginal[] percurso;
    int infinity = 1000000;
    int verticeAtual;   // global usada para indicar o vértice atualmente sendo visitado 
    int doInicioAteAtual;   // global usada para ajustar menor caminho com Djikstra
    int nTree;
    boolean tempoDis;

    public Grafo()
    {
        vertices = new Vertice[NUM_VERTICES];
        adjMatrix = new Caminho[NUM_VERTICES][NUM_VERTICES];
        numVerts = 0;
        nTree = 0;

        for (int j = 0; j < NUM_VERTICES; j++)      // zera toda a matriz
            for (int k = 0; k < NUM_VERTICES; k++)
                adjMatrix[j][k] = null; // distância tão grande que não existe

        percurso = new DistOriginal[NUM_VERTICES];
    }

    public void NovoVertice(String label)
    {
        vertices[numVerts] = new Vertice(label);
        numVerts++;
    }


    public void NovaAresta(int origem, int destino, Caminho estrada)
    {
        adjMatrix[origem][destino] = estrada;
    }



    public void removerVertice(int vert)
    {
        if (vert != numVerts - 1)
        {
            for (int j = vert; j < numVerts - 1; j++)   // remove vértice do vetor
                vertices[j] = vertices[j + 1];

            // remove vértice da matriz
            for (int row = vert; row < numVerts; row++)
                moverLinhas(row, numVerts - 1);
            for (int col = vert; col < numVerts; col++)
                moverColunas(col, numVerts - 1);
        }
        numVerts--;
       
    }
    private void moverLinhas(int row, int length)
    {
        if (row != numVerts - 1)
            for (int col = 0; col < length; col++)
                adjMatrix[row][col] = adjMatrix[row + 1][col];  // desloca para excluir
    }
    private void moverColunas(int col, int length)
    {
        if (col != numVerts - 1)
            for (int row = 0; row < length; row++)
                adjMatrix[row][col] = adjMatrix[row][col + 1]; // desloca para excluir
    }



    public int ObterMenor()
    {
        int distanciaMinima = infinity;
        int indiceDaMinima = 0;
        for (int j = 0; j < numVerts; j++)
            if (!(vertices[j].foiVisitado) && (percurso[j].distancia < distanciaMinima))
            {
                distanciaMinima = percurso[j].distancia;
                indiceDaMinima = j;
            }
        return indiceDaMinima;
    }




    public String Dijkstra(int inicioDoPercurso, int finalDoPercurso, boolean disTemp)
    {
        for (int j = 0; j < numVerts; j++)
            vertices[j].foiVisitado = false;

        vertices[inicioDoPercurso].foiVisitado = true;
        for (int j = 0; j < numVerts; j++)
        {
            // anotamos no vetor percurso a distância entre o inicioDoPercurso e cada vértice
            // se não há ligação direta, o valor da distância será infinity
            Caminho tempDist = adjMatrix[inicioDoPercurso][j];
            if(tempDist == null)
                percurso[j] = new DistOriginal(inicioDoPercurso, infinity);
            else if(tempoDis == false) // se for por Distancia
                percurso[j] = new DistOriginal(inicioDoPercurso, tempDist.getDistancia());
            else // se for por Tempo
                percurso[j] = new DistOriginal(inicioDoPercurso, tempDist.getTempo());
        }

        for (int nTree = 0; nTree < numVerts; nTree++)
        {
            // Procuramos a saída não visitada do vértice inicioDoPercurso com a menor distância
            int indiceDoMenor = ObterMenor();

            // e anotamos essa menor distância
            int distanciaMinima = percurso[indiceDoMenor].distancia;


            // o vértice com a menor distância passa a ser o vértice atual
            // para compararmos com a distância calculada em AjustarMenorCaminho()
            verticeAtual = indiceDoMenor;
            doInicioAteAtual = percurso[indiceDoMenor].distancia;

            // visitamos o vértice com a menor distância desde o inicioDoPercurso
            vertices[verticeAtual].foiVisitado = true;
        }

        return exibirPercursos(inicioDoPercurso, finalDoPercurso);
    }

    public void AjustarMenorCaminho()
    {
        for (int coluna = 0; coluna < numVerts; coluna++)
            if (!vertices[coluna].foiVisitado)       // para cada vértice ainda não visitado
            {
                // acessamos a distância desde o vértice atual (pode ser infinity)
                int atualAteMargem = 0;

                Caminho tempDist = adjMatrix[verticeAtual][coluna];
                if(tempDist == null)
                    atualAteMargem = infinity;
                else if(tempoDis == false) // se for por Distancia
                    atualAteMargem = adjMatrix[verticeAtual][coluna].getDistancia();
                else // se for por Tempo
                    atualAteMargem = adjMatrix[verticeAtual][coluna].getTempo();

                // calculamos a distância desde inicioDoPercurso passando por vertice atual até
                // esta saída
                int doInicioAteMargem = doInicioAteAtual + atualAteMargem;

                // quando encontra uma distância menor, marca o vértice a partir do
                // qual chegamos no vértice de índice coluna, e a soma da distância
                // percorrida para nele chegar
                int distanciaDoCaminho = percurso[coluna].distancia;
                if (doInicioAteMargem < distanciaDoCaminho)
                {
                    percurso[coluna].verticePai = verticeAtual;
                    percurso[coluna].distancia = doInicioAteMargem;

                }
            }
    }

    public String exibirPercursos(int inicioDoPercurso, int finalDoPercurso)
    {

        String resultado = "";
        int onde = finalDoPercurso;
        Stack<String> pilha = new Stack<String>();

        int cont = 0;
        while (onde != inicioDoPercurso)
        {
            onde = percurso[onde].verticePai;
            pilha.push(vertices[onde].rotulo);
            cont++;
        }


        while (pilha.size() != 0)
        {
            resultado += pilha.pop();
            if (pilha.size() != 0)
                resultado += " --> ";
        }

        if ((cont == 1) && (percurso[finalDoPercurso].distancia == infinity))
            resultado = "Não há caminho.";
        else
            resultado += " --> " + vertices[finalDoPercurso].rotulo;

        return resultado;
    }



}
