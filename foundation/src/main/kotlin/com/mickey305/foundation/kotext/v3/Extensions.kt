package com.mickey305.foundation.kotext.v3

import com.mickey305.foundation.v3.util.ByteUtil
import com.mickey305.foundation.v3.util.StringUtil

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// global extension function definition
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * 空白文字・全角スペースを入力文字列の両サイドから除去した文字列を返却する
 * @return 出力文字列
 */
fun String.fastTrim(): String = StringUtil.trim(this)

/**
 * 文字列の左側から指定された文字数の文字列を取得する
 * @param size 文字数
 * @return 文字列
 */
fun String.left(size: Int): String = StringUtil.left(this, size)

/**
 * 文字列の右側から指定された文字数の文字列を取得する
 * @param size 文字数
 * @return 文字列
 */
fun String.right(size: Int): String = StringUtil.right(this, size)

/**
 * 指定されたインデックス番号の位置から文字数分の文字列を取得する
 * @param startIndex インデックス番号
 * @param size 文字数
 * @return 文字列
 */
fun String.mid(startIndex: Int, size: Int): String = StringUtil.mid(this, startIndex, size)

/**
 * 指定されたインデックス番号の位置から始まる文字列を取得する
 * @param startIndex インデックス番号
 * @return 文字列
 */
fun String.mid(startIndex: Int): String = StringUtil.mid(this, startIndex)

/**
 * バイト配列の左側から指定されたバイト数の配列を取得する
 * @param size バイト数
 * @return バイト配列
 */
fun ByteArray.left(size: Int): ByteArray = ByteUtil.left(this, size)

/**
 * バイト配列の右側から指定されたバイト数の配列を取得する
 * @param size バイト数
 * @return バイト配列
 */
fun ByteArray.right(size: Int): ByteArray = ByteUtil.right(this, size)

/**
 * 指定されたインデックス番号の位置からバイト数分のバイト配列を取得する
 * @param startIndex インデックス番号
 * @param size バイト数
 * @return バイト配列
 */
fun ByteArray.mid(startIndex: Int, size: Int): ByteArray = ByteUtil.mid(this, startIndex, size)

/**
 * 指定されたインデックス番号の位置から始まるバイト配列を取得する
 * @param startIndex インデックス番号
 * @return バイト配列
 */
fun ByteArray.mid(startIndex: Int): ByteArray = ByteUtil.mid(this, startIndex)

/**
 * バイト配列の左側から指定されたバイト数の配列を取得する
 * @param size バイト数
 * @return バイト配列
 */
fun Array<Byte>.left(size: Int): Array<Byte> = this.toByteArray().left(size).toTypedArray()

/**
 * バイト配列の右側から指定されたバイト数の配列を取得する
 * @param size バイト数
 * @return バイト配列
 */
fun Array<Byte>.right(size: Int): Array<Byte> = this.toByteArray().right(size).toTypedArray()

/**
 * 指定されたインデックス番号の位置からバイト数分のバイト配列を取得する
 * @param startIndex インデックス番号
 * @param size バイト数
 * @return バイト配列
 */
fun Array<Byte>.mid(startIndex: Int, size: Int): Array<Byte> = this.toByteArray().mid(startIndex, size).toTypedArray()

/**
 * 指定されたインデックス番号の位置から始まるバイト配列を取得する
 * @param startIndex インデックス番号
 * @return バイト配列
 */
fun Array<Byte>.mid(startIndex: Int): Array<Byte> = this.toByteArray().mid(startIndex).toTypedArray()
