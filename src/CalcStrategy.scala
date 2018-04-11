trait CalcStrategy {
  val reF = """(\w+)|\(|\)|\+|\*|\/|\-""".r
  def processCalc (str:String) : Double
}
