package com.mickey305.foundation.kotext.v3

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// global function definition
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * 2次元配列を作成する
 * @return 2次元配列
 */
inline fun <reified T> createTable(size: Int, noinline init: (Int) -> T): Array<Array<T>> {
    return Array(size, { Array(size, init) })
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

