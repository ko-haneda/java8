var b = new java.math.BigInteger('1234567890987654321');

print(b);
//1234567890987654400
print(b.mod(java.math.BigInteger.TEN));
//1

print(java.lang.String.valueOf(b.longValue()));
//下記が原因？
//整数として精度が保証されるのは、-253 (-9,007,199,254,740,992) ～253 (9,007,199,254,740,992) までです。その範囲外では演算結果に誤差が生じます。
//表示する前に文字列にすると正しく動作する。
