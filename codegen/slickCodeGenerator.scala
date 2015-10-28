import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import slick.driver.MySQLDriver
import slick.driver.MySQLDriver.api._
import slick.codegen.SourceCodeGenerator
import slick.model.Model
import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by piyushm on 27/10/15.
 */
object slickCodeGenerator {
  def main(args: Array[String]) {
    val ds = new MysqlDataSource
    ds.setDatabaseName("computerDatabase")
    ds.setUser("root")
    val db = Database.forDataSource(ds)
    val modelFuture = db.run(MySQLDriver.createModel(Some(MySQLDriver.defaultTables)))
    val codegenFuture = modelFuture.map(model => new SlickSourceCodeGenerator(model))
    import scala.concurrent.duration._
    Await.ready(codegenFuture.map(
      _.writeToFile("slick.driver.MySQLDriver", args(0),
      "demo")), 30 seconds)
  }
}


class SlickSourceCodeGenerator(model: Model) extends SourceCodeGenerator(model) {
  gen =>

  override def entityName = dbTableName => dbTableName match {
        case "computers" => "Computer"
        case "comapnies" => "Company"
        case "persons" => "Person"
        case _ => super.entityName(dbTableName)
      }


  override def tableName =
    dbTableName => dbTableName
  // add some custom import
  override def code = super.code

  // override table generator
  override def Table = new Table(_) {
    // disable entity class generation and mapping
    override def EntityType = new EntityType {
      override def classEnabled = true
    }

    // override contained column generator
    override def Column = new Column(_) {
      // use the data model member of this column to change the Scala type,
      // e.g. to a custom enum or anything else
      override def rawType = super.rawType
    }
  }
}















