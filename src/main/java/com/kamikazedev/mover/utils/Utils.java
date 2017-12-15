package com.kamikazedev.mover.utils;

import java.util.Arrays;

public class Utils
{
    public static double[] toDoubleArray(String[] array)
    {
        return Arrays.stream(array)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}
