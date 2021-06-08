package com.example.ksiazka_adresowa;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;
import org.xmlpull.v1.XmlSerializer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Documents/"+"eksperymenty.csv");
        File fileXML = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Documents/"+"eksperymenty_wyniki.xml");
        try{
            fileXML.createNewFile();
        }catch (IOException e){

        }
        FileOutputStream outstream = null;
        try{
            outstream = new FileOutputStream(fileXML);
        }catch (IOException e){
            Log.e("FileNotFoundException",e.toString());
        }
        XmlSerializer xmlserializer = Xml.newSerializer();
        String split[];
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            StringWriter writer = new StringWriter();
            xmlserializer.setOutput(writer);
            xmlserializer.startDocument("UTF-8", true);
            xmlserializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            br.readLine();

            while ((line = br.readLine()) != null) {
                split = line.split(",");

                xmlserializer.startTag("","Projekt");
                xmlserializer.attribute("", "nazwa", split[6]);

                xmlserializer.startTag("","Eksperyment");
                xmlserializer.attribute("", "id", split[0]);

                xmlserializer.startTag("","Rezultat");
                xmlserializer.text(split[2]);
                xmlserializer.endTag("", "Rezultat");

                xmlserializer.startTag("","Temperatura");
                xmlserializer.text(split[3]);
                xmlserializer.endTag("","Temperatura");

                xmlserializer.startTag("","Ciśnienie");
                xmlserializer.text(split[4]);
                xmlserializer.endTag("","Ciśnienie");

                xmlserializer.startTag("","Wiatr");
                xmlserializer.text(split[5]);
                xmlserializer.endTag("","Wiatr");
                xmlserializer.endTag("", "Eksperyment");
                xmlserializer.endTag("", "Projekt");

                xmlserializer.endDocument();

            }
            String data = writer.toString();
            outstream.write(data.getBytes());

            br.close();
            Toast.makeText(this, "Plik został zapisany",
                    Toast.LENGTH_LONG).show();

        }
        catch (IOException e) {
            Log.e("Błąd pliku:", String.valueOf(e));
        }


    }

}