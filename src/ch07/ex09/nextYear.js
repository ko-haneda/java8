if($ARG.length == 1) {
  print("Next year, you will be " + (+$ARG [0] + 1));
}
else if("AGE" in $ENV) {
  print("Next year, you will be " + (+$ENV.AGE + 1));
}
else{
  print("Next year, you will be " + (+readLine('Input your age:') + 1));
}