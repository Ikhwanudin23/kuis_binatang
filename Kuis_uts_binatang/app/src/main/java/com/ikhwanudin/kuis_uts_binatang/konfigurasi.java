package com.ikhwanudin.kuis_uts_binatang;

/**
 * Created by muhammadyusuf on 01/19/2017.
 * kodingindonesia
 */

public class konfigurasi {

    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.56.39/db_kuis/TambahBinatang.php";
    public static final String URL_GET_ALL = "http://192.168.56.39/db_kuis/TampilSemuaBinatang.php";
    public static final String URL_GET_EMP = "http://192.168.56.39/db_kuis/TampilBinatang.php?id=";
    public static final String URL_DELETE_EMP = "http://192.168.56.39/db_kuis/.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.56.39/db_kuis/.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "nama";
    public static final String KEY_EMP_JENIS_BINATANG = "jenis_binatang"; //desg itu variabel untuk posisi
    public static final String KEY_EMP_JUMLAH = "jumlah"; //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_JENIS_BINATANG = "jenis_binatang";
    public static final String TAG_JUMLAH = "jumlah";


    public static final String EMP_ID = "emp_id";
}