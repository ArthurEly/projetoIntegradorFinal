<?php

$servername = "localhost";
$username = "u618559852_arttidev";
$password = "ArThUr040203716228";
$database = "u618559852_pif";
$table = "";
$where = "";
$suffix = "_teste";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $database);

// Check connection
if (!$conn) {
    die("{ 'error':'Connection failed: " . mysqli_connect_error() . "'}");
}

$db = "[";

if (isset($_GET["table"])) {
    $table = $_GET["table"];
} else {
    die("{'error': true}");
}

if (isset($_GET["where"]) && isset($_GET["equals_where"])) {
	$where = " WHERE `".$_GET["where"] . "`='".$_GET["equals_where"] . "'";
} else {
	$where = "";
}


$x = 0;
$result = mysqli_query($conn, "SELECT * FROM `" . $table . "`" . $where);
while($build = mysqli_fetch_array($result)) {
    $vinn = "";
	if ($_GET["table"] == "cliente" + $suffix) {
      $vinn = "{" .
	      "'cliente_id': ".$build["serie_id"].","
        . "'cliente_nome_ou_razao': '" . $build["cliente_nome_ou_razao"]."',"
        . "'cliente_sobrenome_ou_nome_fantasia': '" . $build["cliente_sobrenome_ou_nome_fantasia"] . "',"
        . "'cliente_cpf_ou_cnpj': '" . $build["cliente_cpf_ou_cnpj"] . "',"
        . "'cliente_rg_ou_ie': '" . $build["cliente_rg_ou_ie"] . "',"
        . "'cliente_contato': '" . $build["cliente_contato"] . "',"
        . "'cliente_pj': '" . $build["cliente_pj"] ."',"
        . "'cliente_uf': '" . $build["cliente_uf"] . "',"
        . "'cliente_cep': '" . $build["cliente_cep"] . "',"
        . "'cliente_cidade': '" . $build["cliente_cidade"] . "',"
        . "'cliente_bairro': '" . $build["cliente_bairro"] . "',"
        . "'cliente_lograd': '" . $build["cliente_lograd"] . "',"
        . "'cliente_lograd_num': '" . $build["cliente_lograd_num"] . "',"
        . "'cliente_lograd_comp': '" . $build["cliente_lograd_comp"] . "',"
        . "'cliente_nascimento': '" . $build["cliente_nascimento"] . "',"
        . "'cliente_pass': '" . $build["cliente_pass"] . "'"
        . "},";
        //break;
	} elseif ($_GET["table"] == "usuario") {
      $vinn = "{" .
	      "'usuario_id': ".$build["usuario_id"].","
        . "'usuario_nome': '" . $build["usuario_nome"]."',"
        . "'usuario_email': '" . $build["usuario_email"] . "',"
        . "'usuario_senha': '" . $build["usuario_senha"] . "',"
        . "'usuario_pro': " . $build["usuario_pro"] . ","
        . "'usuario_series': [" . $build["usuario_series"] . "],"
        . "'usuario_ultimo_episodio': '" . $build["usuario_ultimo_episodio"] . "',"
        . "'usuario_idade': " . $build["usuario_idade"]
        . "},";
        //break;
	} elseif ($_GET["table"] == "episodios") {
      $vinn = "{" .
	      "'episodio_id': ".$build["episodio_id"].","
        . "'episodio_nome': '" . $build["episodio_nome"]."',"
        . "'episodio_descricao': \"" . $build["episodio_descricao"]."\","
        . "'serie_id': " . $build["serie_id"].","
        . "'episodio_url': '" . $build["episodio_url"]."'"
        . "},";
        //break;
	}
	$db .= $vinn;
    $x++;
}
$dbN = rtrim($db, ",");
$dbN .= "]";

die($dbN);
?>