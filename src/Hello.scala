object Hello extends App {
  var str = "(123+456)*789-sin(10)"//scala.io.StdIn.readLine()

  val re = """\d+|(\w+\s*\()|\(|\)|\+|\*|\/|\-""".r

  def isNumeric (item:String) = scala.util.Try(item.toDouble).isSuccess

  re.findAllIn(str).foreach(item => println(item+" -- "+isNumeric(item)))


  var m1 = Map ("+" -> {(a:Double,b:Double) => a+b});

  println( m1("+") (1,2) );

//  reS.findAllIn(str).foreach(println)
}
