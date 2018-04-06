object Operations {

  val operations = Map (
      "+" -> new Operation {
        override val priority = 1
        override val  getValue = (a:Double, b: Double) => a+b;
      },
      "-" -> new Operation {
        override val priority = 1
        override val getValue = (a:Double, b: Double) => a-b;
      },
    "*" -> new Operation {
      override val priority = 2
      override val getValue = (a:Double, b: Double) => a*b;
    },
    "-" -> new Operation {
      override val priority = 2
      override val getValue = (a:Double, b: Double) => a*b;
    },
    "(" -> new Operation {
      override val priority = 0
    },
    ")" -> new Operation {
      override val priority = 3
    }
  )

}
