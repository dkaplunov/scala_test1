abstract class CalcNode {
  var parentNode:CalcNode
  var childNodes:List[CalcNode]

  var operation:Operation

  var value:Double

  def processNode(): Double
}
