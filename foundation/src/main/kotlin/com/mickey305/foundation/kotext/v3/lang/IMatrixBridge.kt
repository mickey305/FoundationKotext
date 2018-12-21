package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.v4.lang.math.Matrix
import com.mickey305.foundation.v4.lang.math.SquareMatrix
import com.mickey305.foundation.v4.lang.math.factory.*
import com.mickey305.foundation.v4.lang.math.operator.IElementInitializer
import org.apache.commons.lang3.math.Fraction
import org.apache.commons.math3.fraction.BigFraction
import java.math.BigDecimal
import java.math.BigInteger

interface IMatrixBridge<T> where T : Number {

    /**
     * マトリクス変換処理
     */
    fun Array<Array<T>>.toSquareMatrix(): SquareMatrix<T> {
        if (this.isEmpty() or this.first().isEmpty()) { throw UnsupportedOperationException("empty element error") }

        val element = this.javaClass.componentType.componentType
        val ini = getIni<T>(element)
        val op = getOperator<T>(element)

        return BuilderSquareMatrix<T>().initializer(ini).operator(op).cookbook({this}).build()
    }

    /**
     * マトリクス変換処理
     */
    fun Array<Array<T>>.toMatrix(): Matrix<T> {
        if (this.isEmpty() or this.first().isEmpty()) { throw UnsupportedOperationException("empty element error") }

        val element = this.javaClass.componentType.componentType
        val ini = getIni<T>(element)
        val op = getOperator<T>(element)

        return BuilderMatrix<T>().initializer(ini).operator(op).cookbook({this}).build()
    }

    /**
     * 配列変換処理
     */
    fun Matrix<T>.toArray(): Array<Array<T>> { return this.table }

    /**
     * 配列変換処理
     */
    fun SquareMatrix<T>.toArray(): Array<Array<T>> { return this.table }

    @Suppress("warnings")
    private fun <E : Number> getIni(type: Class<*>): IElementInitializer<E> {
        var ini: IElementInitializer<E>
        when(type) {
            Int::class.javaObjectType -> { ini = ElementInitializerFactory.intIni() as IElementInitializer<E> }
            Long::class.javaObjectType -> { ini = ElementInitializerFactory.longIni() as IElementInitializer<E> }
            Short::class.javaObjectType -> { ini = ElementInitializerFactory.shortIni() as IElementInitializer<E> }
            Float::class.javaObjectType -> { ini = ElementInitializerFactory.floatIni() as IElementInitializer<E> }
            Double::class.javaObjectType -> { ini = ElementInitializerFactory.doubleIni() as IElementInitializer<E> }
            Byte::class.javaObjectType -> { ini = ElementInitializerFactory.byteIni() as IElementInitializer<E> }
            BigInteger::class.javaObjectType -> { ini = ElementInitializerFactory.bigIntIni() as IElementInitializer<E> }
            BigDecimal::class.javaObjectType -> { ini = ElementInitializerFactory.bigDcmlIni() as IElementInitializer<E> }
            Fraction::class.javaObjectType -> { ini = ElementInitializerFactory.fractionIni() as IElementInitializer<E> }
            BigFraction::class.javaObjectType -> { ini = ElementInitializerFactory.bigFractionIni() as IElementInitializer<E> }
            else -> { throw UnsupportedOperationException("element type error") }
        }
        return ini
    }

    @Suppress("warnings")
    private fun <E : Number> getOperator(type: Class<*>): IOperationFactory<E> {
        var op: IOperationFactory<E>
        when(type) {
            Int::class.javaObjectType -> { op = OperationIntFactory.getInstance() as IOperationFactory<E> }
            Long::class.javaObjectType -> { op = OperationLongFactory.getInstance() as IOperationFactory<E> }
            Short::class.javaObjectType -> { op = OperationShortFactory.getInstance() as IOperationFactory<E> }
            Float::class.javaObjectType -> { op = OperationFloatFactory.getInstance() as IOperationFactory<E> }
            Double::class.javaObjectType -> { op = OperationDoubleFactory.getInstance() as IOperationFactory<E> }
            Byte::class.javaObjectType -> { op = OperationByteFactory.getInstance() as IOperationFactory<E> }
            BigInteger::class.javaObjectType -> { op = OperationBigIntFactory.getInstance() as IOperationFactory<E> }
            BigDecimal::class.javaObjectType -> { op = OperationBigDecimalFactory.getInstance() as IOperationFactory<E> }
            Fraction::class.javaObjectType -> { op = OperationFractionFactory.getInstance() as IOperationFactory<E> }
            BigFraction::class.javaObjectType -> { op = OperationBigFractionFactory.getInstance() as IOperationFactory<E>
            }
            else -> { throw UnsupportedOperationException("element type error") }
        }
        return op
    }
}