/**
 * Базвый класс для стратегии обработки строки калькулятора: стек или дерево
 * Разбор строки выполняется с использованием регулярного выражения
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package base

trait CalcStrategy {
  val reF = """(\w+)(\.\d+)?|\(|\)|\+|\*|\/|\-|\^""".r
  val strategyName:String
  def processCalc (str:String) : Double
  class CalcNodeImp (var item: String) extends CalcNode
}
