<?php

$data = $_GET['data'];

if($data==2){

echo shell_exec('./run.sh');
echo "<br>";
echo shell_exec('whoami');
}

?>
