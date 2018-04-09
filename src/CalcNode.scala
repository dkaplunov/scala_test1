trait CalcNode {

  var parentNode:CalcNode = null
  var childNodes:List[CalcNode] = List ()

  var item:String

  var operation:Operation = OperationsMatch.matchOperations(item:String)

  var value:Double = try item.toDouble catch {case n: NumberFormatException => 0 }

  def processNode(params:List[Double]) = { value = operation.getValue(params) }
}
