package org.graphvis.utils

class Node (nId: Long, xc: Double = 0, yc: Double = 0, groupName: String = null){

  var id = nId;
  var x = xc;
  var y = yc;
  var rel_x = xc;
  var rel_y = yc;
  var group = groupName

  def moveTo(xc1: Double, yc1: Double): Unit ={
    x = xc1;
    y = yc1;
  }
  def moveBy(delta_x: Double,delta_y: Double): Unit ={
    x += delta_x;
    y += delta_y;
  }

  def getRelativeCoordinate(center: Point): Unit ={
    rel_x = x - center.x
    rel_y = y - center.y
  }

}
