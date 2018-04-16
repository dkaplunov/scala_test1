/**
  * Реализация стратегии обработки строки калькулятора типа Дерево
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package tree

import base.{CalcNode, CalcStrategy}

object TreeCalcStrategy extends CalcStrategy {

  class CalcTreeImp (var item: String) extends CalcTreeNode

  override val strategyName = "Tree strategy"

  override def processCalc(str: String): Double = {
    val rootNode = new CalcTreeImp("(");
    var prevNode:CalcTreeNode = rootNode
    reF.findAllIn(str+")").foreach(item => {
      prevNode = CalcTree.addNodeToTree(new CalcTreeImp(item), prevNode)
    })

    return rootNode.calcNode()
  }
}
