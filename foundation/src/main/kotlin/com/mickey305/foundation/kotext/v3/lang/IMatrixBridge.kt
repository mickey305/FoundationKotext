package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.kotext.v3.*
import com.mickey305.foundation.v4.lang.math.Matrix
import com.mickey305.foundation.v4.lang.math.SquareMatrix
import com.mickey305.foundation.v4.lang.math.factory.*
import com.mickey305.foundation.v4.lang.math.operator.IElementInitializer

interface IMatrixBridge {
    /**
     * マトリクス変換処理
     */
    fun <T : Number> Array<Array<T>>.toSquareMatrix(): SquareMatrix<T> {
        // get type of T
        val element = this.javaClass.componentType.componentType

        val ini = getIni<T>(element)
        val op = getOperator<T>(element)

        return BuilderSquareMatrix<T>().initializer(ini).operator(op).cookbook({ this }).build()
    }

    /**
     * マトリクス変換処理
     */
    fun <T : Number> Array<Array<T>>.toMatrix(): Matrix<T> {
        // get type of T
        val element = this.javaClass.componentType.componentType

        val ini = getIni<T>(element)
        val op = getOperator<T>(element)

        return BuilderMatrix<T>().initializer(ini).operator(op).cookbook({ this }).build()
    }

    /**
     * 配列変換処理
     */
    fun <T : Number> Matrix<T>.toTable(): Array<Array<T>> = this.table

    /**
     * 配列変換処理
     */
    fun <T : Number> SquareMatrix<T>.toTable(): Array<Array<T>> = this.table

    @Suppress("warnings")
    private fun <E : Number> getIni(type: Class<*>): IElementInitializer<E> {
        val ini = when (type) {
            Int::class.javaObjectType -> ElmIniFactory.intIni()
            Long::class.javaObjectType -> ElmIniFactory.longIni()
            Short::class.javaObjectType -> ElmIniFactory.shortIni()
            Float::class.javaObjectType -> ElmIniFactory.floatIni()
            Double::class.javaObjectType -> ElmIniFactory.doubleIni()
            Byte::class.javaObjectType -> ElmIniFactory.byteIni()
            BigInteger::class.javaObjectType -> ElmIniFactory.bigIntIni()
            BigDecimal::class.javaObjectType -> ElmIniFactory.bigDcmlIni()
            Fraction::class.javaObjectType -> ElmIniFactory.fractionIni()
            BigFraction::class.javaObjectType -> ElmIniFactory.bigFractionIni()
            else -> throw UnsupportedOperationException("element type error")
        } as IElementInitializer<E>
        return ini
    }

    @Suppress("warnings")
    private fun <E : Number> getOperator(type: Class<*>): IOperationFactory<E> {
        val op = when (type) {
            Int::class.javaObjectType -> OperationIntFactory.getInstance()
            Long::class.javaObjectType -> OperationLongFactory.getInstance()
            Short::class.javaObjectType -> OperationShortFactory.getInstance()
            Float::class.javaObjectType -> OperationFloatFactory.getInstance()
            Double::class.javaObjectType -> OperationDoubleFactory.getInstance()
            Byte::class.javaObjectType -> OperationByteFactory.getInstance()
            BigInteger::class.javaObjectType -> OperationBigIntFactory.getInstance()
            BigDecimal::class.javaObjectType -> OperationBigDecimalFactory.getInstance()
            Fraction::class.javaObjectType -> OperationFractionFactory.getInstance()
            BigFraction::class.javaObjectType -> OperationBigFractionFactory.getInstance()
            else -> throw UnsupportedOperationException("element type error")
        } as IOperationFactory<E>
        return op
    }
}