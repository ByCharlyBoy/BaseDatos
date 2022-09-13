<?php
$servername = "localhost"; 
$username = "root"; 
$password = ""; 
$dbname = "miBase"; 

$idplayer = $_POST["IdPlayer"]; 
$nombre = $_POST["Nombre"];
$edad = $_POST["Edad"];
$score = $_POST ["Score"];

//Crea la conexion 
$conn = new mysqli($servername, $username, $password, $dbname); 

//Checha la conexion 
if ($conn->connect_error)
{
	die("Connection failed:" . conn->connect_error); 
}

$sql = "INSERT INTO Player(IdPlayer, Nombre, Edad, Score)
VALUES (". $idplayer . ",'" . $nombre . "', " . $edad . "," . $score . ")";
 

if ($conn->query($sql) === TRUE) 
{
  echo "New record created successfully";
} else {
  echo "Error: " . $sql . "<br>" . $conn->error;
}



$conn->close();
?>