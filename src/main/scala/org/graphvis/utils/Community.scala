package org.graphvis.utils

import scala.math._


class Vector(dir_x: Double = 0, dir_y: Double = 0){
  var x = dir_x
  var y = dir_y
}

class Point(xc: Double = 0, yc: Double = 0){
  var x = xc;
  var y = yc;
}

class Community (nodeList: Array[Point] = Array[Point](), name: String = null){

  var vertexs: Array[vertex] = nodeList
  var groupName = name
  var center: Point = new Point(0,0)
  val dirVec:Array[Vector] = getDirectionVector();

  val outlinePoint: Array[Point] = _;
  def getCenter(): Unit ={
    var sum_x : Double = 0
    var sum_y : Double = 0
    for(node <- nodes){
      sum_x += node.x
      sum_y += node.y
    }
    center.x = sum_x/nodes.length
    center.y = sum_y/nodes.length
  }

  def getDirectionVector(num: Int = 12): Array[Vector] ={

    val unitRad = 2*math.Pi/num
    var dirVec: Array[Vector] = new Array[Vector](num)

    for(i <- 0 to num-1){
      dirVec(i) = new Vector()
      val a = math.cos(unitRad*i)
      dirVec(i).x = math.cos(unitRad*i)
      dirVec(i).y = math.sin(unitRad*i)
    }

    return dirVec
  }


}
