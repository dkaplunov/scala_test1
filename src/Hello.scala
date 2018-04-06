object Hello extends App {
  var str = "(123+456)*789 - sin (10)"//scala.io.StdIn.readLine()

  val re = """\d+|(\w+\s*\()|\(|\)|\+|\*|\/|\-""".r
  val reF = """(\w+)|\(|\)|\+|\*|\/|\-""".r
  val reO = """\d+""".r

  def isNumeric (item:String) = scala.util.Try(item.toDouble).isSuccess

//  re.findAllIn(str).foreach(item => println(item+" -- "+isNumeric(item)))

  reF.findAllIn(str).foreach(item => println(item))

//  reO.findAllIn(str).foreach(item => println(item))


//  var m1 = Map ("+" -> {(a:Double,b:Double) => a+b});

  println( Operations.operations("*").priority);
  println( Operations.operations("*").getValue (3,5));

  //  reS.findAllIn(str).foreach(println)
}
