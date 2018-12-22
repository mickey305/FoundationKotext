package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.v4.lang.math.Matrix
import com.mickey305.foundation.v4.lang.math.SquareMatrix
import com.mickey305.foundation.v4.lang.math.factory.*
import com.mickey305.foundation.v4.lang.math.operator.IElementInitializer
import org.apache.commons.lang3.math.Fraction
import org.apache.commons.math3.fraction.BigFraction
import java.math.BigDecimal
import java.math.BigInteger

interface IMatrixBridge {

    /**
     * マトリクス変換処理
     */
    fun <T : Number> Array<Array<T>>.toSquareMatrix(): SquareMatrix<T> {
        if (this.isEmpty() or this.first().isEmpty()) {
            throw UnsupportedOperationException("empty element error")
        }

        val element = this.javaClass.componentType.componentType
        val ini = getIni<T>(element)
        val op = getOperator<T>(element)

        return BuilderSquareMatrix<T>().initializer(ini).operator(op).cookbook({ this }).build()
    }

    /**
     * マトリクス変換処理
     */
    fun <T : Number> Array<Array<T>>.toMatrix(): Matrix<T> {
        if (this.isEmpty() or this.first().isEmpty()) {
            throw UnsupportedOperationException("empty element error")
        }

        val element = this.javaClass.componentType.componentType
        val ini = getIni<T>(element)
        val op = getOperator<T>(element)

        return BuilderMatrix<T>().initializer(ini).operator(op).cookbook({ this }).build()
    }

    /**
     * 配列変換処理
     */
    fun <T : Number> Matrix<T>.toArray(): Array<Array<T>> = this.table

    /**
     * 配列変換処理
     */
    fun <T : Number> SquareMatrix<T>.toArray(): Array<Array<T>> = this.table

    @Suppress("warnings")
    private fun <E : Number> getIni(type: Class<*>): IElementInitializer<E> {
        val ini: IElementInitializer<E> = when (type) {
            Int::class.javaObjectType -> ElementInitializerFactory.intIni() as IElementInitializer<E>
            Long::class.javaObjectType -> ElementInitializerFactory.longIni() as IElementInitializer<E>
            Short::class.javaObjectType -> ElementInitializerFactory.shortIni() as IElementInitializer<E>
            Float::class.javaObjectType -> ElementInitializerFactory.floatIni() as IElementInitializer<E>
            Double::class.javaObjectType -> ElementInitializerFactory.doubleIni() as IElementInitializer<E>
            Byte::class.javaObjectType -> ElementInitializerFactory.byteIni() as IElementInitializer<E>
            BigInteger::class.javaObjectType -> ElementInitializerFactory.bigIntIni() as IElementInitializer<E>
            BigDecimal::class.javaObjectType -> ElementInitializerFactory.bigDcmlIni() as IElementInitializer<E>
            Fraction::class.javaObjectType -> ElementInitializerFactory.fractionIni() as IElementInitializer<E>
            BigFraction::class.javaObjectType -> ElementInitializerFactory.bigFractionIni() as IElementInitializer<E>
            else -> throw UnsupportedOperationException("element type error")
        }
        return ini
    }

    @Suppress("warnings")
    private fun <E : Number> getOperator(type: Class<*>): IOperationFactory<E> {
        val op: IOperationFactory<E> = when (type) {
            Int::class.javaObjectType -> OperationIntFactory.getInstance() as IOperationFactory<E>
            Long::class.javaObjectType -> OperationLongFactory.getInstance() as IOperationFactory<E>
            Short::class.javaObjectType -> OperationShortFactory.getInstance() as IOperationFactory<E>
            Float::class.javaObjectType -> OperationFloatFactory.getInstance() as IOperationFactory<E>
            Double::class.javaObjectType -> OperationDoubleFactory.getInstance() as IOperationFactory<E>
            Byte::class.javaObjectType -> OperationByteFactory.getInstance() as IOperationFactory<E>
            BigInteger::class.javaObjectType -> OperationBigIntFactory.getInstance() as IOperationFactory<E>
            BigDecimal::class.javaObjectType -> OperationBigDecimalFactory.getInstance() as IOperationFactory<E>
            Fraction::class.javaObjectType -> OperationFractionFactory.getInstance() as IOperationFactory<E>
            BigFraction::class.javaObjectType -> OperationBigFractionFactory.getInstance() as IOperationFactory<E>
            else -> throw UnsupportedOperationException("element type error")
        }
        return op
    }
}