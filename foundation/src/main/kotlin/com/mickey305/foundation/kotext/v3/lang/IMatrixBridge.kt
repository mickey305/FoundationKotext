package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.kotext.v3.*
import com.mickey305.foundation.v4.lang.math.Matrix
import com.mickey305.foundation.v4.lang.math.SquareMatrix
import com.mickey305.foundation.v4.lang.math.builder.BuilderMatrix
import com.mickey305.foundation.v4.lang.math.builder.BuilderSquareMatrix
import com.mickey305.foundation.v4.lang.math.factory.*
import com.mickey305.foundation.v4.lang.math.operator.IElementInitializer
import com.mickey305.foundation.v4.lang.math.operator.IOperationFactory

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
            Int::class.javaObjectType         -> ElementInitializerIntFactory()
            Long::class.javaObjectType        -> ElementInitializerLongFactory()
            Short::class.javaObjectType       -> ElementInitializerShortFactory()
            Float::class.javaObjectType       -> ElementInitializerFloatFactory()
            Double::class.javaObjectType      -> ElementInitializerDoubleFactory()
            Byte::class.javaObjectType        -> ElementInitializerByteFactory()
            BigInteger::class.javaObjectType  -> ElementInitializerBigIntFactory()
            BigDecimal::class.javaObjectType  -> ElementInitializerBigDecimalFactory()
            Fraction::class.javaObjectType    -> ElementInitializerFractionFactory()
            BigFraction::class.javaObjectType -> ElementInitializerBigFractionFactory()
            else -> throw UnsupportedOperationException("element type error")
        } as IElementInitializer<E>
        return ini
    }

    @Suppress("warnings")
    private fun <E : Number> getOperator(type: Class<*>): IOperationFactory<E> {
        val op = when (type) {
            Int::class.javaObjectType         -> OperationIntFactory()
            Long::class.javaObjectType        -> OperationLongFactory()
            Short::class.javaObjectType       -> OperationShortFactory()
            Float::class.javaObjectType       -> OperationFloatFactory()
            Double::class.javaObjectType      -> OperationDoubleFactory()
            Byte::class.javaObjectType        -> OperationByteFactory()
            BigInteger::class.javaObjectType  -> OperationBigIntFactory()
            BigDecimal::class.javaObjectType  -> OperationBigDecimalFactory()
            Fraction::class.javaObjectType    -> OperationFractionFactory()
            BigFraction::class.javaObjectType -> OperationBigFractionFactory()
            else -> throw UnsupportedOperationException("element type error")
        } as IOperationFactory<E>
        return op
    }
}
