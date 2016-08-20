package equal_hashcode;

import java.util.Arrays;

/**
 * Created by chuangjian.li
 * 16/3/12
 */
public class Unit {
    private short aShort;
    private char aChar;
    private byte aByte;
    private boolean aBool;
    private long aLong;
    private float aFloat;
    private double aDouble;
    private Unit aObject;
    private int[] ints;
    private Unit[] units;

    public boolean equals(Object o) {
        if (!(o instanceof Unit))
            return false;
        Unit unit = (Unit) o;
        return unit.aShort == aShort
                && unit.aChar == aChar
                && unit.aByte == aByte
                && unit.aBool == aBool
                && unit.aLong == aLong
                && Float.floatToIntBits(unit.aFloat) == Float
                .floatToIntBits(aFloat)
                && Double.doubleToLongBits(unit.aDouble) == Double
                .doubleToLongBits(aDouble)
                && unit.aObject.equals(aObject)
                && equalsInts(unit.ints)
                && equalsUnits(unit.units);
    }

    private boolean equalsInts(int[] aints) {
        return Arrays.equals(ints, aints);
    }

    private boolean equalsUnits(Unit[] aUnits) {
        return Arrays.equals(units, aUnits);
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + (int) aShort;
        result = 37 * result + (int) aChar;
        result = 37 * result + (int) aByte;
        result = 37 * result + (aBool ? 0 : 1);
        result = 37 * result + (int) (aLong ^ (aLong >>> 32));
        result = 37 * result + Float.floatToIntBits(aFloat);
        long toLong = Double.doubleToLongBits(aDouble);
        result = 37 * result + (int) (toLong ^ (toLong >>> 32));
        result = 37 * result + aObject.hashCode();
        result = 37 * result + intsHashCode(ints);
        result = 37 * result + unitsHashCode(units);
        return result;
    }

    private int intsHashCode(int[] aints) {
        int result = 17;
        for (int aInt : aints) {
            result = 37 * result + aInt;
        }
        return result;
    }

    private int unitsHashCode(Unit[] aUnits) {
        int result = 17;
        for (Unit aUnit : aUnits) {
            result = 37 * result + aUnit.hashCode();
        }
        return result;
    }
}
