package ru.sbt.stream;

import org.junit.Test;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static junit.framework.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testFilterTransformToMap() {
        Map<Integer, Integer> r = Streams.of(Arrays.asList("a", "b"))
                .filter(s -> s.contains("a"))
                .transform(String::length)
                .toMap(Function.identity(), Function.identity());

        assertEquals(1, r.size());
        assertEquals((Integer) 1, r.get(1));
    }

    @Test
    public void testFilterToMap() {
        Map<String, String> r = Streams.of(Arrays.asList("a", "b"))
                .filter(s -> s.contains("a"))
                .toMap(Function.identity(), Function.identity());

        assertEquals(1, r.size());
        assertEquals("a", r.get("a"));
    }

    @Test
    public void testToMap() {
        Map<String, String> r = Streams.of(Arrays.asList((String) null, "bdsdd"))
                .toMap(Function.identity(), Function.identity());

        String[] keys = new String[r.size()];
        r.keySet().toArray(keys);
        String[] vals = new String[r.size()];
        r.values().toArray(vals);
        assertEquals(null, keys[0]);
        assertEquals(null, vals[0]);
        assertEquals("bdsdd", keys[1]);
        assertEquals("bdsdd", vals[1]);
    }
}
