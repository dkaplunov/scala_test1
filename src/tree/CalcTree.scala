package tree

import general.CalcNode

trait CalcTree {
  var parentNode:CalcNode
  var childNodes:List[CalcNode] = List ()
  var currentData:CalcNode

}
