//import
var StandardCharsets = java.nio.charset.StandardCharsets;
var Files = java.nio.file.Files;
var Paths = java.nio.file.Paths;
var Arrays = java.util.Arrays;
var String = java.lang.String;

var path = "C:\\a\\pleiades\\workspace\\Java\\src\\ch07\\ex02\\WarAndPeace.txt";
var contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
var words = Arrays.asList(contents.split(/\W+/));
words.stream().filter(function(w) w.length() > 12).map(function(w) w.toLowerCase()).distinct().sorted().forEach(function(w) print(w));