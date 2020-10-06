package com.mickey305.foundation.kotext.v3.lang

import com.mickey305.foundation.kotext.v3.repeatDecrement

interface ISequencer {
    /**
     * 繰り返し処理
     */
    fun Int.times(action: (Int) -> Unit) = repeat(this) { action(it) }

    /**
     * 繰り返し処理
     */
    fun Int.times(with: With, action: (Int) -> Unit) {
        when (with) {
            With.Default -> this.times(action)
            With.Reverse -> repeatDecrement(this) { action(it) }
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
