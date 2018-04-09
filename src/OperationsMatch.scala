object OperationsMatch {

  def matchOperations(oper:String) = oper match {
    case "B" => new Operation {
      override val priority = -1
      override val paramsNumber = 1;
    }
    case "F"  => new Operation {
      override val priority = 10
      override val paramsNumber = 1;
    }
    case "+"  => new Operation {
      override val priority = 2
      override val  getValue = (params:List[Double]) => params(0)+params(1);
    }
    case "-"  => new Operation {
        override val priority = 2
        override val getValue = (params:List[Double]) => params(0)-params(1);
      }
    case "*"  => new Operation {
      override val priority = 1
      override val getValue = (params:List[Double]) => params(0)*params(1);
    }
    case "/"  => new Operation {
      override val priority = 1
      override val getValue = (params:List[Double]) => params(0)/params(1);
    }
    case "sin"  => new Operation {
      override val priority = 3
      override val paramsNumber: Int = 1
      override val getValue = (params:List[Double]) => Math.sin (params(0));
    }
    case "("  => new Operation {
      override val priority = 0
      override val paramsNumber: Int = 1
    }
    case ")"  => new Operation {
      override val priority = 3
      override val paramsNumber: Int = 1
    }
  }

}
