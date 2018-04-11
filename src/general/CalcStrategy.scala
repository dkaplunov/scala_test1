package general

trait CalcStrategy {
  val reF = """(\w+)(\.\d+)?|\(|\)|\+|\*|\/|\-""".r
  def processCalc (str:String) : Double
}
