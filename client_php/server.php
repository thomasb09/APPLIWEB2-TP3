<!DOCTYPE html>
<html>
<head>
    <title>Exemple de Requête GET en PHP</title>
</head>
<body>

<?php
$url = "http://172.20.45.21:8080/serviceREST-0.0.1-SNAPSHOT/routeDuJour";

$response = file_get_contents($url);

if ($response === FALSE) {
    echo "La requête GET a échoué";
} else {
    echo "<h1>Route du jour : <h1><br>";
    echo $response;
}
?>

</body>
</html>
