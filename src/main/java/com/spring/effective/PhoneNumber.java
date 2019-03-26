package com.spring.effective;

/**
 * @author chenjunlin  junlin.chen@msn.cn
 * @date 2019-03-25 13:30
 *
 * 覆盖equals时总要覆盖hashcode
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(short areaCode, short prefix, short lineNumber) {
        rangeCheck(areaCode,999,"area code");
        rangeCheck(prefix,999,"prefix");
        rangeCheck(lineNumber,999,"lineNumber");
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    private static void rangeCheck(int arg,int max,String name){
        if ((arg < 0) || (arg > max))
            throw new IllegalArgumentException(name+":"+arg);
    }

    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber
        && pn.prefix == prefix
        && pn.areaCode == areaCode;
    }
}
