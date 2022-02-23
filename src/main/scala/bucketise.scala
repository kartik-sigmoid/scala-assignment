
object bucketise {
  def truncate_val(x: Double, p: Int): Double = {
    val v = math.pow(10, p)
    (x * v).toInt / v
  }

  def bucket(y: Double): (Double, Double) = {
    var initialVal: Double = (y / 0.05).floor * 0.05
    var finalVal: Double = (y / 0.05).floor * 0.05 + 0.049;
    return (truncate_val(initialVal, 3), truncate_val(finalVal, 3))
  }

  def main(args: Array[String]): Unit = {
    var value: Array[Double] = Array(12.05, 12.03, 10.33, 11.45, 13.5)
    for (num <- value) {
      print(s"For value $num bucket is ")
      println(bucket(num))
    }
  }
}