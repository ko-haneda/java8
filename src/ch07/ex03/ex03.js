var b = new java.math.BigInteger('1234567890987654321');

print(b);
//1234567890987654400
print(b.mod(java.math.BigInteger.TEN));
//1

print(java.lang.String.valueOf(b.longValue()));
//���L�������H
//�����Ƃ��Đ��x���ۏ؂����̂́A-253 (-9,007,199,254,740,992) �`253 (9,007,199,254,740,992) �܂łł��B���͈̔͊O�ł͉��Z���ʂɌ덷�������܂��B
//�\������O�ɕ�����ɂ���Ɛ��������삷��B
