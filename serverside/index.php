<?php

$data = $_GET['data'];

if($data==="delighted"){
echo shell_exec('./DifuserSet 1');
//shell_exec('./servo b 20');
//set b servo position 20
echo "<br>";
}
elseif($data==="gloomy"){
//gloomy difuser
echo shell_exec('whoami');
echo shell_exec('./DifuserSet 2');

print_r("rr");
}
elseif($data==="nervous"){
//nervous difuser
echo shell_exec('./DifuserSet 3');

}
elseif($data==="serious"){
echo shell_exec('./DifuserSet 4');

//serious difuser
}

elseif($data==="happy"){

echo shell_exec('./DifuserSet 5');
//Happy difuser
}
elseif($data==="love"){

echo shell_exec('./DifuserSet 6');
//love difuser
}
?>
