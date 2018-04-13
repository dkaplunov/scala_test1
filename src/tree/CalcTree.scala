package tree

object CalcTree {
  def addNodeToTree (calcTreeNode: CalcTreeNode, prevNode: CalcTreeNode):CalcTreeNode = {
//    if (prevNode == null) return _;

    if (calcTreeNode.value != null) prevNode.addChildNode(calcTreeNode)
    else calcTreeNode.setParentNode(prevNode)

    return calcTreeNode

  }
}
