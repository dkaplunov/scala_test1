package tree

import general.CalcNode

trait CalcTree {
  var parentNode:CalcNode = null
  var childNodes:List[CalcNode] = List ()
  var currentData:CalcNode

  def processNode (calcCollection: Iterator[String]):Double = _

  def addChildNode (calcNode: CalcNode) = calcNode :: childNodes

  def setParentNode (calcNode: CalcNode) = parentNode = calcNode

}
