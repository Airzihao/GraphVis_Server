package org.graphvis.Loader
import java.io.File

import org.neo4j.driver.v1._
import org.neo4j.driver.v1.Session

import scala.reflect.ClassTag
import org.graphvis.utils.Logging

import scala.collection.JavaConversions._


class Neo4jLoader(setting: Neo4jSetting) {
  val _url = setting._boltUrl.toString;
  val _user = setting._user;
  val _pwd = setting._pwd;
  val driver = GraphDatabase.driver(_url, AuthTokens.basic(_user, _pwd))

  val session: Session = driver.session

  val transfer: Transfer = new Transfer(setting)
  def queryNodes(): Array[Any] ={
    session.run("MATCH(n) RETURN(n);").map { result =>
      val node =result.get("n").asNode();
      transfer.neo4j2Vis(node)
    }.toArray
  }
  def queryEdges(): Array[Any] ={
    session.run("MATCH p=()-->() RETURN p").map { result=>
      val rel = result.get("p").asPath().relationships().iterator().next();
      transfer.neo4j2Vis(rel)
    }.toArray
  }

}
