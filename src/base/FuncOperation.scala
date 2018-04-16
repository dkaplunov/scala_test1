/**
 * Расширение базового класса операций для функций (sin т.д.)
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package base

trait FuncOperation extends Operation {
  override val priority = 4
  override val paramsNumber: Int = 1

}
