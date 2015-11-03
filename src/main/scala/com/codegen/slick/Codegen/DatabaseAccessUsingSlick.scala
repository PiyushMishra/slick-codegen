package com.codegen.slick.Codegen

import auto_generated._
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

import scala.concurrent.Await

/**
 * Created by piyushm on 28/10/15.
 */
object DatabaseAccessUsingSlick extends App {

  import Tables._
  import slick.driver.MySQLDriver.api._
  import scala.concurrent.duration._

  val ds = new MysqlDataSource
  ds.setDatabaseName("computerDatabase")
  ds.setUser("root")
  val db = Database.forDataSource(ds)
  val insertFuture = db.run(Companies += Company(1, "IronLogic")
  )
  Await.result(insertFuture, 10 seconds)
}