/*
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

import stack.StackCalcStrategy
import tree.TreeCalcStrategy
import base.CalcStrategy

object Calculator extends App {
  var strDef = "sqrt (sin (PI) ^ 2 + cos (PI) ^ 2) + 1" //"sqrt(sin(PI)^2+cos(PI)^2)+1
  var str = "" //scala.io.StdIn.readLine()


  str = if (str.length()==0) strDef else str

  println("Calc expression: "+str);

  calcAndPrint(StackCalcStrategy)
  calcAndPrint(TreeCalcStrategy)

  def calcAndPrint (strategy: CalcStrategy) = {
    val name = strategy.strategyName
    try println(name+" result is "+strategy.processCalc(str)) catch {case p: Exception => println(name+" error: "+p)
  }
  }

}
