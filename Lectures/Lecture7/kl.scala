def kl(x:List[Double], y:List[Double]): Double = { 
  val xy = x.zip(y) 
  def f(acc: Double, xy : (Double,Double)): Double = { 
    val (x0,y0) = xy 
    acc + (x0 * Math.log(x0/y0)) 
  }
  xy.foldLeft(0.0)(f(_,_)) 
}
