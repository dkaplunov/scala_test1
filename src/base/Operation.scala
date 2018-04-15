/**
 * Базовый класс для описания операций
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package base

import base.OperationsMatch.GeneralCase

trait Operation {
  val priority:Int = 0;
  val paramsNumber = 2;
  val isOperate = true;

  val addNodeSpecficType:AddingNodeBase = GeneralCase ()

  def getValue (params:List[Double]):Double = params(0)
}
