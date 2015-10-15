function createArrayList() {
  var arr = new (Java.extend(java.util.ArrayList)){
    add: function(x) {
      print('Adding ' + x);
      return Java.super(arr).add(x);
    }
  }
  return arr;
}
var list1 = createArrayList();
var list2 = createArrayList();
list1.add("1");
list2.add("2");
list1.add("3");
list2.add("4");
list1.add("5");
list2.add("6");
print(list1);
print(list2);