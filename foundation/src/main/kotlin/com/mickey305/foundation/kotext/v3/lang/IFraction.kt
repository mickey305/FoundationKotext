package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.kotext.v3.Fraction

interface IFraction {
    /**
     * 分数インスタンスを生成する
     * ```
     * val f = 1 of 2 // Fraction.getReducedFraction(1, 2)
     * ```
     * @return Fractionインスタンス
     */
    infix fun Int.of(int: Int): Fraction = Fraction.getReducedFraction(this, int)
}
