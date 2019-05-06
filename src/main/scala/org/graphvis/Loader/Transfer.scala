package org.graphvis.Loader

import org.graphvis.utils.{Node, Edge}
import org.neo4j.driver.v1.types.Relationship

class Transfer(setting: Neo4jSetting) {

  def neo4j2Vis(nNode: org.neo4j.driver.v1.types.Node):Node = {
        var node: Node = new Node(nId = nNode.id());
        if(nNode.containsKey(setting._communityField)) node.group = nNode.get(setting._communityField).asInstanceOf[String];
        if(nNode.containsKey(setting.x)) node.x = nNode.get(setting.x).asDouble;
        if(nNode.containsKey(setting.y)) node.y = nNode.get(setting.y).asDouble;
        node;
    }

  def neo4j2Vis(nRel: Relationship): Edge = {
    val from = nRel.startNodeId();
    val to = nRel.endNodeId();
    val id = nRel.id();
    val label = nRel.`type`();
    var edge: Edge = new Edge(id,from,to,label);
    edge
  }

}
