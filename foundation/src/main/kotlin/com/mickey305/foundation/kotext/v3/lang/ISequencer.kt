package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.kotext.v3.repeatDecrement

interface ISequencer {
    /**
     * 繰り返し処理
     */
    fun Int.times(callback: (Int) -> Unit) { repeat(this) { callback(it) } }

    /**
     * 繰り返し処理
     */
    fun Int.times(with: With, callback: (Int) -> Unit) {
        when (with) {
            With.Default -> this.times(callback)
            With.Reverse -> repeatDecrement(this) { callback(it) }
        }
    }

    /**
     * 繰り返し処理オプション
     */
    enum class With {
        /**
         * デフォルト
         */
        Default,

        /**
         * 反転実行
         */
        Reverse

    }
}
