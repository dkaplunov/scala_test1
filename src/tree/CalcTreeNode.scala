package tree

import general.CalcNode

trait CalcTreeNode extends CalcNode {
  var parentNode:CalcTreeNode = _
  var childNodes:List[CalcTreeNode] = List ()

  def calcNode ():Double = {
    var childValues:List[Double] = List ();
    childNodes.foreach(node => {
      childValues = node.calcNode()::childValues
    })
    processNode(childValues)

    return value
  }

  def addChildNode (newChildNode: CalcTreeNode) = {
    newChildNode :: childNodes
    if (newChildNode.parentNode != None) {
      parentNode = newChildNode.parentNode;
      parentNode.childNodes = (this::parentNode.childNodes).filterNot(p => newChildNode == p)
    }
  }

  def setParentNode (parentCalcNode: CalcTreeNode) = {
      parentNode = parentCalcNode
      parentCalcNode.childNodes = this :: parentCalcNode.childNodes
  }

}
