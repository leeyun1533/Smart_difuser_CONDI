<?php

$data = $_GET['data'];

if($data==2){

echo shell_exec('./run.sh');
//shell_exec('./servo b 20');
//set b servo position 20
echo "<br>";
echo shell_exec('whoami');
}

?>
