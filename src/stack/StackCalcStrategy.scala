package stack

import general.{CalcNode, CalcStrategy, OperationsMatch}

object StackCalcStrategy extends CalcStrategy {
  var result:Double = 0;

  def getDigitsFromStack (numberDigits:Int): List[Double] = {
    var res = List[Double]()
    for (i:Int <- 0 to numberDigits-1) {
      res = digitStack.pullData().value::res
    }
    return res;
  }


  def operate (item:String) : Null = {

    if (operStack.getLength() == 0) return null;

    if (operStack.firstElement().operation.priority < OperationsMatch.matchOperations(item).priority || item == "(")
      operStack.pushData(new CalcNodeImp(item))
    else  {
      val node: CalcNode = operStack.pullData();
      if (node.operation.isOperate) {
        node.processNode(getDigitsFromStack(node.operation.paramsNumber))
        result = node.value;
        digitStack.pushData(new CalcNodeImp(result.toString))
        if (node.item!="(" || item != ")") operate(item)
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
      if (OperationsMatch.isNumeric (item)) digitStack.pushData(new CalcNodeImp(item)) else operate(item)
    })
    return result
  }
}
