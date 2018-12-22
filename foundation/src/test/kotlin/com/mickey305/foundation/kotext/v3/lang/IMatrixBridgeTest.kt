package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.kotext.v3.createTable
import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.math3.fraction.BigFraction
import org.junit.After
import org.junit.Before
import org.junit.Test

class IMatrixBridgeTest : IMatrixBridge {

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
        val tbl = createTable(3, { BigFraction.ZERO })
        tbl[0] = arrayOf(BigFraction(51, 10), BigFraction(25, 10), BigFraction(12, 10))
        tbl[1] = arrayOf(BigFraction(11, 10), BigFraction(15, 10), BigFraction(12, 10))
        tbl[2] = arrayOf(BigFraction(23, 10), BigFraction(25, 10), BigFraction(62, 10))
        val matrix = tbl.toSquareMatrix()
        println(ToStringBuilder.reflectionToString(matrix.toTable()))
        println(ToStringBuilder.reflectionToString(matrix.createInverseMatrix().toTable()))
    }
}