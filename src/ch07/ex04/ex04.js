var str = 'Hello World!';
print(str + ":" + str.getClass());
str = str.substring(0,11)
print(str + " :" + str.getClass()) ;
str = java.lang.String.class.cast(str);
print(str + " :" + str.getClass());

//すべてjava.lang.Stringが表示されてしまった．．．
//Hello World!:class java.lang.String
//Hello World :class java.lang.String
//Hello World :class java.lang.String
print(str + ":" + str.constructor.name); 			//String
print(str + ":" + str instanceof String);			//false
print(str + ":" + str instanceof java.lang.String);	//false

