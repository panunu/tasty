package com.panuleppaniemi.components

import com.mchange.v2.c3p0.ComboPooledDataSource
import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession

class Database {
  val source = new ComboPooledDataSource
  val connection = Database.forDataSource(source)
}