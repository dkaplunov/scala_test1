abstract class Operation {
  val priority:Int = 0;
  val paramsNumber = 2;
  val getValue = (params:List[Double]) => params(0)
}
