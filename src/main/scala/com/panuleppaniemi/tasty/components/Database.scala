package com.panuleppaniemi.tasty.components

import com.mchange.v2.c3p0.ComboPooledDataSource
import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession

// TODO: Close the connection.
class Database {
  val source = new ComboPooledDataSource
  val connection = Database.forDataSource(source)
}