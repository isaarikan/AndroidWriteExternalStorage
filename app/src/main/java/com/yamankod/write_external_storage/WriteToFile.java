package com.yamankod.write_external_storage;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriteToFile {

    ///sdcard/mysdfile.txt"

    private static final String TAG = "_WriteToFile";


    //Genel metod dosya yazmak için sadece bu metoda erişeceğiz
    public void WriteFile(String fileName, String[] mesaj) {

        //1.parametre dosya adı 2.parametre yazacagım veri
         try {

            //Harici kayıt için  File sınıfını kullanıyoruz  Environemnt harici alan yol belirliyor
            File root = Environment.getExternalStorageDirectory();
            // File myFile = new File("/sdcard/mysdfile.txt");//root, fileName);
             File myFile = new File(root,fileName);
             //Dosya konumda var alıyorsa tekrar oluşturmaya gerek yok
            if (myFile.exists()) {
                Log.i(TAG, "file exist");
             //   myFile.delete(); //bu satırın silinmedigi zaman silip üzerine yazıyor
            }

            //Yoksa yeni dosya oluştur
            myFile.createNewFile();

             //Dosyalar parça parça halinde veriler kaydedilecek
            FileOutputStream fOut = new FileOutputStream(myFile, true);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);

             //Dizi elemanlarına ulaşmak için for döngüsü yazıyoruz
            for (int i = 0; i < mesaj.length; i++) {
                myOutWriter.write(mesaj[i] + "\n");
            }

            //Yapıları kapatalım yazma işmeliminin bittiğini söylüyoruz
            myOutWriter.flush();
            myOutWriter.close();

            fOut.close();

            Log.d(TAG, "Done writing SD");

        } catch (IOException e) {

            Log.w(TAG, "" + e.toString());

        }

    }
}
