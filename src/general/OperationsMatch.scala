package general

object OperationsMatch {

  def isNumeric (item:String) = scala.util.Try(item.toDouble).isSuccess

  def matchOperations(oper:String) = oper match {
    case "+"  => new Operation {
      override val priority = 1
      override def getValue (params:List[Double]):Double = params(0)+params(1);
    }
    case "-"  => new Operation {
        override val priority = 1
        override def getValue (params:List[Double]):Double = params(0)-params(1);
      }
    case "*"  => new Operation {
      override val priority = 2
      override def getValue (params:List[Double]):Double = params(0)*params(1);
    }
    case "/"  => new Operation {
      override val priority = 2
      override def getValue (params:List[Double]):Double = params(0)/params(1);
    }
    case "sin"  => new Operation {
      override val priority = 3
      override val paramsNumber: Int = 1
      override def getValue (params:List[Double]):Double = Math.sin (params(0));
    }
    case "("  => new Operation {
      override val priority = 0
      override val paramsNumber: Int = 1
    }
    case ")"  => new Operation {
      override val priority = 0
      override val paramsNumber: Int = 0
      override val isOperate = false
    }
    case _  => new Operation {
      override val priority = 1
      override val paramsNumber: Int = 0
    }
  }

}

