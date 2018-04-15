/**
 * Базовый класс, определяющий поведение элемента коллекции (дерево или стек)
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package base

trait CalcNode {

  var item:String

  var operation:Operation = OperationsMatch.matchOperations(this)

  var value:Double = try item.toDouble catch {case n: NumberFormatException => Predef.Double2double(null) }

  def processNode(params:List[Double]) = if (operation.isOperate)  value = operation.getValue(params)

  def isNumeric () = scala.util.Try(item.toDouble).isSuccess

}
