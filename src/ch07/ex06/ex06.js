function pipe() {
  var result;
  for each (var command in arguments) {
    result = $EXEC(command,result);
  }
  return result;
}
print(pipe('ls', 'grep java', 'sort'));