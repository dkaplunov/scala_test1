/**
 * Реализация стека - основные операции - взять с вершины, положить в стек
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package stack

import base.CalcNode

trait CalcStack {

  var dataList:List [CalcNode]

  def pullData () : CalcNode = {
    val res:CalcNode = dataList.head
    dataList = dataList.tail

    return res
  }

  def pushData (node:CalcNode) = dataList = node :: dataList

  def getLength () : Int = dataList.length

  def firstElement () : CalcNode = dataList.head

}
