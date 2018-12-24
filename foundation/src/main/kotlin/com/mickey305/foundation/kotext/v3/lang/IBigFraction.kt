package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.kotext.v3.BigFraction
import com.mickey305.foundation.kotext.v3.BigInteger

interface IBigFraction {
    /**
     * 分数インスタンスを生成する
     * ```
     * val f = 1 of 2 // BigFraction.getReducedFraction(1, 2)
     * ```
     * @return BigFractionインスタンス
     */
    infix fun Int.of(int: Int): BigFraction = BigFraction.getReducedFraction(this, int)

    /**
     * 分数インスタンスを生成する
     * @return BigFractionインスタンス
     */
    infix fun Long.of(long: Long): BigFraction = BigFraction(this, long)

    /**
     * 分数インスタンスを生成する
     * @return BigFractionインスタンス
     */
    infix fun BigInteger.of(bigInt: BigInteger): BigFraction = BigFraction(this, bigInt)
}
