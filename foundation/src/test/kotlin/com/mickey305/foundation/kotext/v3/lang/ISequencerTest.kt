package com.mickey305.foundation.kotext.v3.lang

import org.junit.After
import org.junit.Before
import org.junit.Test

class ISequencerTest : ISequencer {

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
        10.times { i -> println(i) }
    }

    @Test
    @Throws(Exception::class)
    fun testCase_01_02() {
        10.times { println(it) }
    }

    @Test
    @Throws(Exception::class)
    fun testCase_02_01() {
        10.times(ISequencer.With.Default) { i -> println(i) }
        10.times(ISequencer.With.Reverse) { i -> println(i) }
    }

    @Test
    @Throws(Exception::class)
    fun testCase_02_02() {
        10.times(ISequencer.With.Default) { println(it) }
        10.times(ISequencer.With.Reverse) { println(it) }
    }
}