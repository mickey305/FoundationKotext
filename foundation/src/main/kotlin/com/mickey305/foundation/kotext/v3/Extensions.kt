package com.mickey305.foundation.kotext.v3

import com.mickey305.foundation.v3.util.StringUtil

// global function definition

/**
 * 入力された回数分コールバックを実行する
 * インデックス番号：from times-1 to zero
 */
inline fun repeatDecrement(times: Int, action: (Int) -> Unit) {
    for (index in 0 until times) {
        action(times - index - 1)
    }
}

/**
 * 空白文字・全角スペースを入力文字列の両サイドから除去した文字列を返却する
 * @return 出力文字列
 */
fun String.fastTrim(): String = StringUtil.trim(this)

/**
 * 2次元配列を作成する
 * @return 2次元配列
 */
inline fun <reified T : Number> createTable(size: Int, noinline init: (Int) -> T): Array<Array<T>> {
    return Array(size, { Array(size, init) })
}

