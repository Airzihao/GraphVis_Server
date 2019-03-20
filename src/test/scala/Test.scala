
package org.graphvis
import scala.math._
import org.junit.Test
import utils.{Community, Node, Point, Vector}

import scala.collection.mutable.ArrayBuffer
import scala.io.Source


class BaseTest{

  @Test
  def test1(): Unit ={
    val pi = math.Pi
    print(math.cos(pi))

  }

  @Test
  def directionVector(): Unit ={
    val community = new Community()
    for(item <- community.dirVec){
      println(item.x,item.y)
    }
  }

  @Test
  def test(): Unit ={
    var nodeList = new Array[Node](4)
    nodeList(0) = new Node(1,1)
    nodeList(1) = new Node(3,1)
    nodeList(2) = new Node(3,3)
    nodeList(3) = new Node(1,3)

    var community = new Community(nodeList,"testCommunity")
    println(community.groupName)
    community.getOutlinePoint()
    println(community.center.x,community.center.y) //(1,1)

    for(item <- community.outlinePoint){
      println(item.x,item.y)
    }

  }

  @Test
  def testReadFile(): Unit ={
    val group = 11
    val filePath = "D:\\GitSpace\\GraphVis_Server\\src\\test\\scala\\data\\" + group
    val file=Source.fromFile(filePath)
    var nodeList = new ArrayBuffer[Node]()
    for(line <- file.getLines)
    {
      val num1 = line.replace("(","").replace(")","").split(",")
      val node = new Node(num1(0).toDouble,num1(1).toDouble,group.toString)
      nodeList.append(node)
    }
    file.close

    var community = new Community(nodeList.toArray)
    community.getOutlinePoint()

    for(item <- community.outlinePoint){
      println(item.x.toInt,item.y.toInt)

    }


  }



}

