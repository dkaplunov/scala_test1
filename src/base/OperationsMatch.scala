/**
 * Case для определения операции при разборе строки
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package base

object OperationsMatch {

  def matchOperations(node:CalcNode) = node.item match {
    case "+"  => new Operation {
      override val priority = 1
      override def getValue (params:List[Double]):Double = testParams(params,0)+testParams(params,1);
    }
    case "-"  => new Operation {
        override val priority = 1
        override def getValue (params:List[Double]):Double = testParams(params,0)-testParams(params,1);
      }
    case "*"  => new Operation {
      override val priority = 2
      override def getValue (params:List[Double]):Double = params(0)*params(1);
    }
    case "/"  => new Operation {
      override val priority = 2
      override def getValue (params:List[Double]):Double = params(0)/params(1);
    }
    case "^"  => new Operation {
      override val priority = 3
      override def getValue (params:List[Double]):Double = Math.pow (params(0), params(1))
    }
    case "sin"  => new FuncOperation {
      override def getValue (params:List[Double]):Double = Math.sin (params(0));
    }
    case "cos"  => new FuncOperation {
      override def getValue (params:List[Double]):Double = Math.cos (params(0));
    }
    case "tan"  => new FuncOperation {
      override def getValue (params:List[Double]):Double = Math.tan (params(0));
    }
    case "log"  => new FuncOperation {
      override def getValue (params:List[Double]):Double = Math.log (params(0));
    }
    case "exp"  => new FuncOperation {
      override def getValue (params:List[Double]):Double = Math.exp (params(0));
    }
    case "sqrt"  => new FuncOperation {
      override def getValue (params:List[Double]):Double = Math.sqrt (params(0));
    }
    case "PI"  => new FuncOperation {
      override def getValue (params:List[Double]):Double = Math.PI;
      override val addNodeSpecficType: AddingNodeBase = new ConstanteCase ()
    }
    case "E"  => new FuncOperation {
      override def getValue (params:List[Double]):Double = Math.E;
      override val addNodeSpecficType: AddingNodeBase = new ConstanteCase ()
    }
    case "(" => new Operation {
      override val priority = 0
      override val paramsNumber: Int = 1
      override val addNodeSpecficType: AddingNodeBase = new OpenParantessCase ()
    }
    case ")" => new Operation {
      override val priority = 0
      override val paramsNumber: Int = 0
      override val isOperate = false
      override val addNodeSpecficType: AddingNodeBase = new CloseParantessCase ()
    }
    case _ if (node.isNumeric()) =>  new Operation {
      override val priority = 1
      override val paramsNumber: Int = 0
      override val isOperate = false
      override val addNodeSpecficType: AddingNodeBase = new ConstanteCase ()
    }
    case _  => throw new Exception ("Не число "+node.item)
  }

  case class ConstanteCase () extends AddingNodeBase
  case class OpenParantessCase () extends AddingNodeBase
  case class CloseParantessCase () extends AddingNodeBase
  case class GeneralCase () extends AddingNodeBase

  def testParams (params:List[Double], num:Int):Double = {
    if (params.length>num) params(num) else 0.0
  }

}

