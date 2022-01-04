package net.capturecoop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void tests() {
        //CCMathUtils
        assertTrue(CCMathUtils.isDouble("2.0"));
        assertFalse(CCMathUtils.isDouble("Text"));
        assertFalse(CCMathUtils.isDouble("2.0Text"));

        assertTrue(CCMathUtils.isInteger("2"));
        assertFalse(CCMathUtils.isInteger("2.0"));
        assertFalse(CCMathUtils.isInteger("Text"));
        assertFalse(CCMathUtils.isInteger("2Text"));

        //Vector2Int
        Vector2Int vec2int1 = new Vector2Int(5, 10);
        Vector2Int vec2int2 = new Vector2Int(105, -5);

        assertFalse(vec2int1.isSame(vec2int2));
        assertTrue(vec2int2.isSame(new Vector2Int(105, -5)));
        assertTrue(vec2int1.add(vec2int2).isSame(new Vector2Int(110, 5)));

        //Vector2Float
        Vector2Float vec2float1 = new Vector2Float(5.2F, 10.3F);
        Vector2Float vec2float2 = new Vector2Float(105.7F, -5.1F);

        assertFalse(vec2float1.isSame(vec2float2));
        assertTrue(vec2float2.isSame(new Vector2Float(105.7F, -5.1F)));
        assertTrue(vec2float1.add(vec2float2).isSame(new Vector2Float(5.2F + 105.7F, 10.3F - 5.1F)));
    }
}
