import stack.StackCalcStrategy

object Calculator extends App {
  var str = "3.2+sin(2+7)*2"//scala.io.StdIn.readLine()

  println(StackCalcStrategy.processCalc(str));

}
