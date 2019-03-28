package org.graphvis.utils

class Edge (sId: String, eId: String){

  var startNodeId = sId;
  var endNodeId = eId;

  def getStartNodeId(): String ={
    startNodeId
  }
  def getEndNodeId(): String ={
    endNodeId
  }
}
