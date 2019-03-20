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

class Community (nodeList: Array[Node] = Array[Node](), name: String = null){

  var nodes: Array[Node] = nodeList
  var groupName = name
  var center: Point = new Point(0,0)
  val dirVec:Array[Vector] = getDirectionVector();

  var outlinePoint: Array[Point] = new Array[Point](36);

  for (i <- 0 to 35){
    outlinePoint(i) = new Point()
  }


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

  def getDirectionVector(num: Int = 36): Array[Vector] ={

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


  def getOutlinePoint(): Array[Point] ={
    getCenter()
    var directionLength : Array[Double] = new Array[Double](36)
    for(node <- nodes){
      node.getRelativeCoordinate(center)
      for(i <- 0 to 35){
        val unit_vector = dirVec(i)
        val length = (node.rel_x*unit_vector.x + node.rel_y*unit_vector.y)
        if (length > directionLength(i)) directionLength(i) = length + 50
      }
    }

    for(i <- 0 to 35) {
      outlinePoint(i).x = directionLength(i)*dirVec(i).x+center.x
      outlinePoint(i).y = directionLength(i)*dirVec(i).y+center.y
    }
    return outlinePoint
  }



}
