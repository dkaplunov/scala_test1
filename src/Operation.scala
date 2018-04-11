trait Operation {
  val priority:Int = 0;
  val paramsNumber = 2;
  val isOperate = true;

  def getValue (params:List[Double]):Double = params(0)
}
