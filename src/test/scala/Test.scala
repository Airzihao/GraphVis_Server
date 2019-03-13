
package org.graphvis
import scala.math._
import org.junit.Test

import utils.Community
import utils.Vector


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


}

