package tree

import general.{CalcNode, CalcStrategy}

object TreeCalcStrategy extends CalcStrategy {

  class CalcTreeImp (var currentData: CalcNode) extends CalcTree

  override def processCalc(str: String): Double = {

    val calcCollection = reF.findAllIn("("+str+")")
    return new CalcTreeImp(new CalcNodeImp(calcCollection.next())).processNode(calcCollection)

  }
}
