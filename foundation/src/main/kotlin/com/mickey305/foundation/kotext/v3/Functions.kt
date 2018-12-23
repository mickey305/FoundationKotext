package com.mickey305.foundation.kotext.v3

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// global function definition
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * 2次元配列を作成する
 * @return 2次元配列
 */
inline fun <reified T> createTable(size: Int, action: (Int, Int) -> T): Array<Array<T>> {
    return Array(size, { i -> Array(size, { j -> action(i, j) }) })
}

/**
 * 2次元配列を作成する
 * ```
 * val table = iniTable(10, { 0 }) // width->10, height->10, data->0:Int
 * val table = iniTable(5, { BigFraction.ZERO }) // width->5, height->5, data->0:BigFraction
 * ```
 * @return 2次元配列
 */
inline fun <reified T> iniTable(size: Int, action: () -> T): Array<Array<T>> {
    return createTable(size, { _, _ -> action() })
}

/**
 * 入力された回数分コールバックを実行する
 * インデックス番号：from times-1 to zero
 */
inline fun repeatDecrement(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(times - index - 1)
    }
}

