/**
 * Реализация стратегии разбора строки калькулятора типа Стек
 * Используется два стека - для значений и для операций
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package stack

import base.{CalcNode, CalcStrategy, OperationsMatch}

object StackCalcStrategy extends CalcStrategy {
  var result:Double = 0;

  def getDigitsFromStack (numberDigits:Int): List[Double] = {
    var res = List[Double]()
    for (i:Int <- 0 to numberDigits-1) {
      res = digitStack.pullData().value::res
    }
    return res;
  }


  def operate (newNode:CalcNode) : Null = {

    if (operStack.getLength() == 0) return null;

    if (operStack.firstElement().operation.priority < OperationsMatch.matchOperations(newNode).priority || newNode.item == "(")
      operStack.pushData(newNode)
    else  {
      val node: CalcNode = operStack.pullData();
      if (node.operation.isOperate) {
        node.processNode(getDigitsFromStack(node.operation.paramsNumber))
        result = node.value;
        digitStack.pushData(new CalcNodeImp(result.toString))
        if (node.item!="(" || newNode.item != ")") operate(newNode)
      }
    }
    return null
  }

  class OperStack (var dataList: List [CalcNode]) extends CalcStack
  class DigitStack (var dataList: List [CalcNode]) extends CalcStack

  var operStack = new OperStack (List[CalcNode] (new CalcNodeImp ("(")))
  var digitStack = new DigitStack(List[CalcNode](new CalcNodeImp ("0")))

  override def processCalc(str: String): Double = {
    reF.findAllIn(str+")").foreach(item => {
      val node = new CalcNodeImp(item)
      if (node.isNumeric()) digitStack.pushData(node) else operate(node)
    })
    return result
  }
}
