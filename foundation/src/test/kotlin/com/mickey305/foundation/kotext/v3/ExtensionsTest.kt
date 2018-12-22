package com.mickey305.foundation.kotext.v3

import com.mickey305.foundation.kotext.v3.lang.ISequencer
import com.mickey305.foundation.v3.util.Log
import org.apache.commons.lang3.tuple.Pair
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.ArrayList

class ExtensionsTest : ISequencer {
    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
    }

    @Test
    @Throws(Exception::class)
    fun testCase_01_01() {
        // left: input data, right: output data
        val testData = ArrayList<Pair<String, String>>()
        testData.add(Pair.of("test", "test"))
        testData.add(Pair.of(" test ", "test"))
        testData.add(Pair.of("test  ", "test"))
        testData.add(Pair.of("  test", "test"))
        testData.add(Pair.of("　test　", "test"))
        testData.add(Pair.of("test　　", "test"))
        testData.add(Pair.of("　　test", "test"))
        testData.add(Pair.of("test", "test"))
        testData.add(Pair.of("\ttest\t", "test"))
        testData.add(Pair.of("test\t\t", "test"))
        testData.add(Pair.of("\t\ttest", "test"))
        testData.add(Pair.of("\ntest\n", "test"))
        testData.add(Pair.of("test\n\n", "test"))
        testData.add(Pair.of("\n\ntest", "test"))
        testData.add(Pair.of("\rtest\r", "test"))
        testData.add(Pair.of("test\r\r", "test"))
        testData.add(Pair.of("\r\rtest", "test"))
        testData.add(Pair.of("\r\ntest\r\n", "test"))
        testData.add(Pair.of("test\r\n\r\n", "test"))
        testData.add(Pair.of("\r\n\r\ntest", "test"))
        testData.add(Pair.of("te st", "te st"))
        testData.add(Pair.of(" te st ", "te st"))
        testData.add(Pair.of("te st  ", "te st"))
        testData.add(Pair.of("  te st", "te st"))
        testData.add(Pair.of("　te st　", "te st"))
        testData.add(Pair.of("te st　　", "te st"))
        testData.add(Pair.of("　　te st", "te st"))
        testData.add(Pair.of("\tte st\t", "te st"))
        testData.add(Pair.of("te st\t\t", "te st"))
        testData.add(Pair.of("\t\tte st", "te st"))
        testData.add(Pair.of("\nte st\n", "te st"))
        testData.add(Pair.of("te st\n\n", "te st"))
        testData.add(Pair.of("\n\nte st", "te st"))
        testData.add(Pair.of("\rte st\r", "te st"))
        testData.add(Pair.of("te st\r\r", "te st"))
        testData.add(Pair.of("\r\rte st", "te st"))
        testData.add(Pair.of("\r\nte st\r\n", "te st"))
        testData.add(Pair.of("te st\r\n\r\n", "te st"))
        testData.add(Pair.of("\r\n\r\nte st", "te st"))
        testData.add(Pair.of("te　st", "te　st"))
        testData.add(Pair.of(" te　st ", "te　st"))
        testData.add(Pair.of("te　st  ", "te　st"))
        testData.add(Pair.of("  te　st", "te　st"))
        testData.add(Pair.of("　te　st　", "te　st"))
        testData.add(Pair.of("te　st　　", "te　st"))
        testData.add(Pair.of("　　te　st", "te　st"))
        testData.add(Pair.of("\tte　st\t", "te　st"))
        testData.add(Pair.of("te　st\t\t", "te　st"))
        testData.add(Pair.of("\t\tte　st", "te　st"))
        testData.add(Pair.of("\nte　st\n", "te　st"))
        testData.add(Pair.of("te　st\n\n", "te　st"))
        testData.add(Pair.of("\n\nte　st", "te　st"))
        testData.add(Pair.of("\rte　st\r", "te　st"))
        testData.add(Pair.of("te　st\r\r", "te　st"))
        testData.add(Pair.of("\r\rte　st", "te　st"))
        testData.add(Pair.of("\r\nte　st\r\n", "te　st"))
        testData.add(Pair.of("te　st\r\n\r\n", "te　st"))
        testData.add(Pair.of("\r\n\r\nte　st", "te　st"))

        // complex data
        testData.add(Pair.of("\n 　\n \t  \r\n\r\nt\t\r\ne　　st\n\r  　", "t\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検証\nt\t\r\ne　　st\n\r  　", "検証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r￡￦\nt\t\r\ne　　st\n\r  　", "￡￦\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検証︥﹄︸︩︹\nt\t\r\ne　　st\n\r  　", "検証︥﹄︸︩︹\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検⺀鿕証\nt\t\r\ne　　st\n\r  　", "検⺀鿕証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検㐀힣ힹ証\nt\t\r\ne　　st\n\r  　", "検㐀힣ힹ証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検豈舘証\nt\t\r\ne　　st\n\r  　", "検豈舘証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検ﻄﺶﺶﺶﺶﺶ証\nt\t\r\ne　　st\n\r  　", "検ﻄﺶﺶﺶﺶﺶ証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🈓🈤🈤🈪証\nt\t\r\ne　　st\n\r  　", "検🈓🈤🈤🈪証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検😀😐😷😷😩証\nt\t\r\ne　　st\n\r  　", "検😀😐😷😷😩証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🜒🜓🜙🜛🜷🜳証\nt\t\r\ne　　st\n\r  　", "検🜒🜓🜙🜛🜷🜳証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🚄証\nt\t\r\ne　　st\n\r  　", "検🚄証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🚱証\nt\t\r\ne　　st\n\r  　", "検🚱証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🚲証\nt\t\r\ne　　st\n\r  　", "検🚲証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🚰証\nt\t\r\ne　　st\n\r  　", "検🚰証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🚳証\nt\t\r\ne　　st\n\r  　", "検🚳証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🚴証\nt\t\r\ne　　st\n\r  　", "検🚴証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r検🚵証\nt\t\r\ne　　st\n\r  　", "検🚵証\nt\t\r\ne　　st"))
        testData.add(Pair.of("\n 　\n \t  \r\n\r🚶🚷\nt\t\r\ne　　st\n\r  　", "🚶🚷\nt\t\r\ne　　st"))

        // method test
        for ((i, data) in testData.withIndex()) {
            val result = data.left.fastTrim()
            Assert.assertEquals("stopped data[$i]", data.right, result)
        }

        // method benchmark
        val list1 = mutableListOf<Long>()
        val list2 = mutableListOf<Long>()
        var start: Long
        var end: Long
        100.times {
            start = System.nanoTime()
            for (data in testData) {
                data.left.fastTrim()
            }
            end = System.nanoTime()
            list1.add(end - start)
//            Log.i("iteration[$it] fastTrim: " + (end - start))

            start = System.nanoTime()
            for (data in testData) {
                data.left.trim()
            }
            end = System.nanoTime()
            list2.add(end - start)
//            Log.i("iteration[$it] trim:     " + (end - start))
        }
        Log.d("fastTrim: " + (list1.average() / 1000).toLong() + "[ms]")
        Log.d("trim:     " + (list2.average() / 1000).toLong() + "[ms]")
    }

}
