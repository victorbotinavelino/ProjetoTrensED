package br.unicamp.cotuca.apbuscadecaminho;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

///
/// Guilherme Salim de Barros - 18188 \\ Victor Botin Avelino - 18172
///

//NO MÉTODO A SEGUIR, FAZEMOS A ABERTURA, A LEITURA E A EXIBIÇÃO
//DOS ARQUIVOS TEXTO QUE CONTÊM AS CIDADES A SEREM UTILIZADAS
//PELO PROJETO NA CRIAÇÃO DOS CAMINHOS.
//O MÉTODO UTILIZADO É MUITO SEMELHANTE AO QUE FAZÍAMOS EM C#.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResultados = (TextView)findViewById(R.id.txtResultados);
        Button btnAdicionarCidade = (Button) findViewById(R.id.btnAdicionarCidade);
        Button btnBuscar = (Button) findViewById(R.id.btnBuscar);
        Spinner spCidadeOrigem = (Spinner) findViewById(R.id.spCidadeOrigem);
        Spinner spCidadeDestino = (Spinner) findViewById(R.id.spCidadeDestino);
        ImageView ivMapa = findViewById(R.id.ivMapa);

        BucketHash hash = new BucketHash();
        // Ler Arquivo de cidades
        BufferedReader reader = null;
        BufferedReader readerCaminhos = null;
        Grafo grafoCaminhos = new Grafo();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mapa_espanha_portugal);
        Bitmap bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);

        Canvas canvas = new Canvas(bitmap2);
        canvas.drawBitmap(bitmap, 0, 0, null);
        ivMapa.setImageDrawable(new BitmapDrawable(getResources(), bitmap2));

        try
        {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("Cidades.txt")));

            String linhaASerLida;
            ListaSimples<Cidade> listaCidades= new ListaSimples<>();
            while ((linhaASerLida = reader.readLine()) != null) {
                Cidade novaCidade = new Cidade(linhaASerLida);
                listaCidades.inserirAposFim(novaCidade);
                hash.inserir(novaCidade);
            }

            Object[] vetObj = listaCidades.toArray();
            Cidade[] vetorCidades = new Cidade[listaCidades.getQuantosNos()];
            String[] vetorSpinner = new String[listaCidades.getQuantosNos()];
            for(int i = 0; i < listaCidades.getQuantosNos(); i++)
            {
                vetorCidades[i] = (Cidade)vetObj[i];
                vetorSpinner[i] = vetorCidades[i].getNome();
                grafoCaminhos.NovoVertice(vetorCidades[i].getNome());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, vetorSpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spCidadeOrigem.setAdapter(adapter);
            spCidadeDestino.setAdapter(adapter);

            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("GrafoTremEspanhaPortugal.txt")));

            linhaASerLida = "";
            while ((linhaASerLida = reader.readLine()) != null) {
                //process line
                Caminho novoCaminho = new Caminho(linhaASerLida);
                Cidade cidadeUm = hash.buscarCidade(novoCaminho.getcidadeOrigem());
                Cidade cidadeDois = hash.buscarCidade(novoCaminho.getcidadeDestino());
                grafoCaminhos.NovaAresta(cidadeUm.getIdCidade(), cidadeDois.getIdCidade(), novoCaminho);

            }


            readerCaminhos = new BufferedReader(
                    new InputStreamReader(getAssets().open("Cidades.txt")));





        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
