import Run._

/**
  * Desc: 
  * ------------------------------------
  * Author:lichuangjian@meituan.com
  * Date: 2016/11/2
  * Time: 下午3:04
  */
object HelloWorld {

  def main(args: Array[String]): Unit = {
    println("Hello, world!")

    // var && val
    var myVar: Int = 10
    var myVal: String = "hello scala"
    var myVar1 = 20
    var myVal1 = "hello world"
    println(myVal)
    println(myVal)
    println(myVal1)
    println(myVal1)
  }
}


class Point(val xc: Int, val yc: Int) {
  var x: Int = xc
  var y: Int = yc


  def move(dx: Int, dy: Int): Unit = {
    x = x + dx
    y = y + dy
    println("Point x location : " + x)
    println("Point y location : " + y)

  }
}

class Location(override val xc: Int, override val yc: Int, val zc: Int) extends Point(xc, yc) {
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int): Unit = {
    x = x + dy
    y = y + dy
    z = z + dz
    println("Point x location:  " + x);
    println("Point y location:  " + y);
    println("Point z location:  " + z);
  }
}

object demo {
  def main(args: Array[String]): Unit = {
    val pt = new Point(10, 20);
    pt.move(10, 10)

    val loc = new Location(10, 20, 15)
    loc.move(10, 10, 5)
    4 times println("hello");

    println("multiplier(1) value = " + multiplier(1))
    println("multiplier(1) value = " + multiplier(2))
  }

  // closures
  var factor = 3;
  val multiplier = (i: Int) => i * factor;
}


object Run {

  implicit class IntTimes(x: Int) {
    def times[A](f: => A): Unit = {
      def loop(current: Int): Unit =
        if (current > 0) {
          f
          loop(current - 1)
        }
      loop(x)
    }
  }

}