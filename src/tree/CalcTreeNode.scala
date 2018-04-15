/**
 * Расширение стандартного элмента для организации дерева. Содержит список дочерних узлов и
  * объект родительского узел, а так же методы добавления-удаления-изменения родительских и
  * дочерних узлов, связанных с этим
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package tree

import base.CalcNode

trait CalcTreeNode extends CalcNode {
  var parentNode:CalcTreeNode = _
  var childNodes:List[CalcTreeNode] = List ()

  def calcNode ():Double = {
    var childValues:List[Double] = List ();
    childNodes.foreach(node => {
      childValues = childValues :+ node.calcNode()
    })
    processNode(childValues)

    return value
  }

  def addChildNode (newChildNode: CalcTreeNode) = {
    childNodes = childNodes :+ newChildNode
    if (newChildNode.parentNode != null) {
      parentNode = newChildNode.parentNode;
      parentNode.childNodes = (parentNode.childNodes:+this).filterNot(p => newChildNode == p)
    }
    newChildNode.parentNode = this
  }

  def setParentNode (parentCalcNode: CalcTreeNode) = {
      parentNode = parentCalcNode
      parentCalcNode.childNodes = parentCalcNode.childNodes :+ this
  }

}
