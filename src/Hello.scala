object Hello extends App {
  var str = "1+4*3-2-6"//scala.io.StdIn.readLine()

  val re = """\d+|(\w+\s*\()|\(|\)|\+|\*|\/|\-""".r
  val reF = """(\w+)|\(|\)|\+|\*|\/|\-""".r
  val reO = """\d+""".r

  var result:Double = 0;

  def getDigitsFromStack (numberDigits:Int): List[Double] = {
    var res = List[Double]()
    for (i:Int <- 0 to numberDigits-1) {
      res = digitStack.pullData().value::res
    }
    return res;
  }


  def operate (item:String) : Null = {

    if (digitStack.getLength() == 0) return null;

    if (operStack.firstElement().operation.priority < OperationsMatch.matchOperations(item).priority) operStack.pushData(new CalcNodeImp(item))
    else if (operStack.firstElement().operation.priority>=0) {
      operStack.firstElement().processNode(getDigitsFromStack(OperationsMatch.matchOperations(item).paramsNumber))
      result = operStack.firstElement().value;
      digitStack.pushData(new CalcNodeImp(result.toString))
      operStack.pullData()
      operate(item);
    }
    return null
  }

  class OperStack (var dataList: List [CalcNode]) extends CalcStack
  class DigitStack (var dataList: List [CalcNode]) extends CalcStack
  class CalcNodeImp (var item: String) extends CalcNode

  var operStack = new OperStack (List[CalcNode] (new CalcNodeImp ("+"))) //List[String] ("B")
  var digitStack = new DigitStack(List[CalcNode](new CalcNodeImp ("0")))//List[Double] ()

  reF.findAllIn(str+"F").foreach(item => {
    if (OperationsMatch.isNumeric (item)) digitStack.pushData(new CalcNodeImp(item))  // = item.toDouble::digitStack else operate(item)
  })

  println(result);

}
