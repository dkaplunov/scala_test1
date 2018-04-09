object Hello extends App {
  var str = "1+4-3-6"//scala.io.StdIn.readLine()

  val re = """\d+|(\w+\s*\()|\(|\)|\+|\*|\/|\-""".r
  val reF = """(\w+)|\(|\)|\+|\*|\/|\-""".r
  val reO = """\d+""".r

  var result:Double = 0;

  def isNumeric (item:String) = scala.util.Try(item.toDouble).isSuccess

  def getDigitsFromStack (numberDigits:Int): List[Double] = {
    var res = List[Double]()
    for (i:Int <- 0 to numberDigits-1) {
      res = digitStack.head::res
      digitStack = digitStack.tail
    }
    return res;
  }

  def operate (item:String) : Null = {

    if (digitStack.length == 0) return null;

    if (Operations.operations(operStack.head).priority < Operations.operations(item).priority) operStack = item::operStack
    else if (Operations.operations(operStack.head).priority>=0) {
      result = Operations.operations(operStack.head).getValue (getDigitsFromStack(Operations.operations(item).paramsNumber))
      digitStack = result::digitStack
      operStack = operStack.tail
      operate(item);
    }
    return null
  }

  var operStack = List[String] ("B")
  var digitStack = List[Double] ()
  reF.findAllIn(str+"F").foreach(item => {
    if (isNumeric (item)) digitStack = item.toDouble::digitStack else operate(item)
  })

  println(result);

/*  println( Operations.operations("*").priority);
  println( Operations.operations("*").getValue (3,5));*/

}
