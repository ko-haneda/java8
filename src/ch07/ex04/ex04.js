var str = 'Hello World!';
print(str + ":" + str.getClass());
str = str.substring(0,11)
print(str + " :" + str.getClass()) ;
str = java.lang.String.class.cast(str);
print(str + " :" + str.getClass());

//���ׂ�java.lang.String���\������Ă��܂����D�D�D
//Hello World!:class java.lang.String
//Hello World :class java.lang.String
//Hello World :class java.lang.String
print(str + ":" + str.constructor.name); 			//String
print(str + ":" + str instanceof String);			//false
print(str + ":" + str instanceof java.lang.String);	//false

