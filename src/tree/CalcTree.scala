/**
 * Сервисный класс для работы с деревом. Отличие от стратегии Стек в способе хранения
 * Информация о связях дерева хранится в самих элментах, поэтому отдельно стуруктуры для хранения не требуется
 * Copyright (c) 2018. Kaplunov Dmitry (kda2266@gmail.com)
 */

package tree

import base.OperationsMatch.{ConstanteCase, GeneralCase, OpenParantessCase}

object CalcTree {
  def addNodeToTree (calcTreeNode: CalcTreeNode, prevNode: CalcTreeNode):CalcTreeNode = {

    if (calcTreeNode.item == ")") return findLocalRootNode(prevNode)

    prevNode.operation.addNodeSpecficType match {
      case ConstanteCase() if checkPriority(prevNode, calcTreeNode) => calcTreeNode.addChildNode(prevNode.parentNode)
      case ConstanteCase() if !checkPriority(prevNode, calcTreeNode) => calcTreeNode.addChildNode(prevNode)
      case OpenParantessCase() if prevNode.childNodes.nonEmpty && checkPriority(prevNode, calcTreeNode) => calcTreeNode.addChildNode(prevNode.parentNode)
      case OpenParantessCase() if prevNode.childNodes.nonEmpty && !checkPriority(prevNode, calcTreeNode) => calcTreeNode.addChildNode(prevNode)
      case _ => calcTreeNode.setParentNode(prevNode)
    }

    calcTreeNode
  }

  def checkPriority (prevNode:CalcTreeNode, calcTreeNode: CalcTreeNode) : Boolean = prevNode.parentNode.operation.priority>calcTreeNode.operation.priority

  def findLocalRootNode (prevNode: CalcTreeNode) :CalcTreeNode = {
    var node = prevNode
    while (node.item != "(") node = node.parentNode

    node
  }

}
