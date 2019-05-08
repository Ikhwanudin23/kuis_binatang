<?php

	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$nama = $_POST['nama'];
		$jenis_binatang = $_POST['jenis_binatang'];
		$jumlah = $_POST['jumlah'];
		
		//Pembuatan Syntax SQL
		$sql = "INSERT INTO db_kuis (nama,jenis_binatang,jumlah) VALUES ('$nama','$jenis_binatang','$jumlah')";
		
		//Import File Koneksi database
		require_once('koneksi.php');
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)){
			echo 'Berhasil Menambahkan Data Binatang';
		}else{
			echo 'Gagal Menambahkan data binatang';
		}
		
		mysqli_close($con);
	}
?>