/*
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

import stack.StackCalcStrategy
import tree.TreeCalcStrategy

object Calculator extends App {
  var strDef = "1+25/(3+2)-10"
  var str = "" //scala.io.StdIn.readLine()


  str = if (str.length()==0) strDef else str

  println("Stack strategy result is "+StackCalcStrategy.processCalc(str));
  println("Tree strategy result is "+TreeCalcStrategy.processCalc(str));

}
