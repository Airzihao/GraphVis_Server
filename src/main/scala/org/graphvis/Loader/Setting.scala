package org.graphvis.Loader

import java.io.{File,FileInputStream, InputStreamReader}
import java.util.Properties

import scala.beans.BeanProperty
import scala.collection.JavaConversions
import scala.io.Source

import org.graphvis.utils.Logging

class Neo4jSetting extends Setting with Logging {
  val path = "D:\\GitSpace\\GraphVis_Server\\src\\main\\scala\\org\\graphvis\\Loader\\neo4j.properties"
  val configFile = new File(path)

  val is = new InputStreamReader(new FileInputStream(path), "utf-8");
  val ps = new Properties();
  ps.load(is);
  is.close();

  logger.info(s"using configuration: $configFile");
  val map = JavaConversions.propertiesAsScalaMap(ps);

  val _boltUrl = map.get("neo4j.boltUrl").get;
  val _user = map.get("neo4j.boltUser").get;
  val _pwd = map.get("neo4j.boltPwd").get;
  val _communityField = map.get("communityFieldName").get;


}

class Setting {
  val x = "x"
  val y = "y"

}
