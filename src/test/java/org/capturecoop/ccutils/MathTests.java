package org.capturecoop.ccutils;

import org.capturecoop.ccutils.utils.CCMathUtils;
import org.capturecoop.ccutils.math.CCVector2Float;
import org.capturecoop.ccutils.math.CCVector2Int;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathTests {
    @Test
    public void tests() {
        //MathUtils
        assertTrue(CCMathUtils.isDouble("2.0"));
        assertFalse(CCMathUtils.isDouble("Text"));
        assertFalse(CCMathUtils.isDouble("2.0Text"));

        assertTrue(CCMathUtils.isInteger("2"));
        assertFalse(CCMathUtils.isInteger("2.0"));
        assertFalse(CCMathUtils.isInteger("Text"));
        assertFalse(CCMathUtils.isInteger("2Text"));

        //Vector2Int
        CCVector2Int vec2int1 = new CCVector2Int(5, 10);
        CCVector2Int vec2int2 = new CCVector2Int(105, -5);

        assertFalse(vec2int1.isSame(vec2int2));
        assertTrue(vec2int2.isSame(new CCVector2Int(105, -5)));
        assertTrue(vec2int1.add(vec2int2).isSame(new CCVector2Int(110, 5)));

        //Vector2Float
        CCVector2Float vec2float1 = new CCVector2Float(5.2F, 10.3F);
        CCVector2Float vec2float2 = new CCVector2Float(105.7F, -5.1F);

        assertFalse(vec2float1.isSame(vec2float2));
        assertTrue(vec2float2.isSame(new CCVector2Float(105.7F, -5.1F)));
        assertTrue(vec2float1.add(vec2float2).isSame(new CCVector2Float(5.2F + 105.7F, 10.3F - 5.1F)));
    }
}
