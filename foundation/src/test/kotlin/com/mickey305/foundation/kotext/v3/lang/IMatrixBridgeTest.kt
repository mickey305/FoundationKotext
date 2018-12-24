package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.kotext.v3.BigFraction
import com.mickey305.foundation.kotext.v3.iniTable
import org.apache.commons.lang3.builder.ToStringBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test

class IMatrixBridgeTest : IMatrixBridge, IBigFraction {

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
        val tbl = iniTable(3, { BigFraction.ZERO })
        tbl[0] = arrayOf(51 of 10, 25 of 10, 12 of 10)
        tbl[1] = arrayOf(11 of 10, 15 of 10, 12 of 10)
        tbl[2] = arrayOf(23 of 10, 25 of 10, 62 of 10)
        val matrix = tbl.toSquareMatrix()
        println(ToStringBuilder.reflectionToString(matrix.toTable()))
        println(ToStringBuilder.reflectionToString(matrix.createInverseMatrix().toTable()))
    }
}