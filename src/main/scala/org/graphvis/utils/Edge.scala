package org.graphvis.utils

class Edge (_id: Long, sId: Long, eId: Long, _label: String){


  var startNodeId = sId;
  var endNodeId = eId;
  var id = _id;
  var label = _label;

  def getStartNodeId(): Long ={
    startNodeId
  }
  def getEndNodeId(): Long ={
    endNodeId
  }
}
