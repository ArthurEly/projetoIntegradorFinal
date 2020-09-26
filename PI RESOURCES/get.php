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
	} elseif ($_GET["table"] == "os" + $suffix) {
        $vinn = "{" .
            "'os_numero': ".$build["os_numero"].","
          . "'veiculo_placa': '" . $build["veiculo_placa"]."',"
          . "'veiculo_situacao': '" . $build["veiculo_situacao"] . "',"
          . "'cliente_cpf_ou_cnpj': '" . $build["cliente_cpf_ou_cnpj"] . "',"
          . "'os_data_entrada': '" . $build["os_data_entrada"] . "',"
          . "'os_previsao_saida': '" . $build["os_previsao_saida"] . "',"
          . "'os_data_saida': '" . $build["os_data_saida"] ."',"
          . "'colaborador_nome_atendimento': '" . $build["colaborador_nome_atendimento"] . "'"
          . "},";
          //break;
    } elseif ($_GET["table"] == "orcamento" + $suffix) {
        $vinn = "{" .
            "'os_numero': ".$build["os_numero"].","
          . "'orcamento_preco_pecas': '" . $build["orcamento_preco_pecas"]."',"
          . "'orcamento_descricao_pecas': '" . $build["orcamento_descricao_pecas"] . "',"
          . "'orcamento_preco_servicos': '" . $build["orcamento_preco_servicos"] . "',"
          . "'os_dataorcamento_descricao_servicos_entrada': '" . $build["orcamento_descricao_servicos"] . "',"
          . "'orcamento_data': '" . $build["orcamento_data"] . "'"
          . "},";
          //break;
    } elseif ($_GET["table"] == "veiculo" + $suffix) {
        $vinn = "{" .
            "'veiculo_placa': ".$build["veiculo_placa"].","
          . "'veiculo_tipo': '" . $build["veiculo_tipo"]."',"
          . "'veiculo_fabricante': '" . $build["veiculo_fabricante"] . "',"
          . "'veiculo_modelo': '" . $build["veiculo_modelo"] . "',"
          . "'veiculo_cor': '" . $build["veiculo_cor"] . "',"
          . "'veiculo_ano': '" . $build["veiculo_ano"] . "',"
          . "'veiculo_acessorios': '" . $build["veiculo_acessorios"] . "',"
          . "'veiculo_observacoes': '" . $build["veiculo_observacoes"] . "',"
          . "'veiculo_defeito_cliente': '" . $build["veiculo_defeito_cliente"] . "',"
          . "'veiculo_situacao': '" . $build["veiculo_situacao"] . "',"
          . "'parecer_tecnico': '" . $build["parecer_tecnico"] . "',"
          . "'os_numero': '" . $build["os_numero"] . "',"
          . "'veiculo_dono': '" . $build["veiculo_dono"] . "'"
          . "},";
          //break;
    } elseif ($_GET["table"] == "parecer_tecnico" + $suffix) {
        $vinn = "{" .
            "'os_numero': ".$build["os_numero"].","
          . "'parecer_data': '" . $build["parecer_data"]."',"
          . "'colab_nome_tecnico': '" . $build["colab_nome_tecnico"] . "',"
          . "'parecer_descricao': '" . $build["parecer_descricao"] . "'"
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