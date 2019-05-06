import org.graphvis.Loader.{Neo4jLoader, Neo4jSetting}
import org.junit.Test

class LoaderTest {
  val setting = new Neo4jSetting
  val loader = new Neo4jLoader(setting)


  @Test
  def queryNode(): Unit ={
    val nodes = loader.queryNodes();
    val edges = loader.queryEdges();
    println(nodes)
    println()
  }
}
