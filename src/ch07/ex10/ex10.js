var StandardCharsets = java.nio.charset.StandardCharsets;
var Files = java.nio.file.Files;
var Paths = java.nio.file.Paths;
var String = java.lang.String;
var FXCollections = javafx.collections.FXCollections;
var PieChart = javafx.scene.chart.PieChart;

var path = "C:\\a\\pleiades\\workspace\\Java\\src\\ch07\\ex10\\ex10.json";
var contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
var json = JSON.parse(contents);

var pieChartData = FXCollections.observableArrayList();
for (var n in json.data) {
  pieChartData.add(new PieChart.Data(json.data[n].type, +json.data[n].papers));
}
var chart = new PieChart(pieChartData);

$STAGE.scene = new javafx.scene.Scene(chart, 600, 400)