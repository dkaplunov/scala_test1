package tree

import general.{CalcNode, CalcStrategy}

object TreeCalcStrategy extends CalcStrategy {

  class CalcTreeImp (var item: String) extends CalcTreeNode

  override def processCalc(str: String): Double = {
    var rootNode = new CalcTreeImp("(");
    var prevNode:CalcTreeNode = rootNode
    reF.findAllIn(str+")").foreach(item => {
      prevNode = CalcTree.addNodeToTree(new CalcTreeImp(item), prevNode)
    })



    return rootNode.calcNode()

  }
}
