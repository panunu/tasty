package com.panuleppaniemi.tasty.services

import java.util.Properties
import com.mchange.v2.c3p0.ComboPooledDataSource
import scala.slick.driver.MySQLDriver.simple._
import Database.threadLocalSession

// TODO: Close the connection.
trait Database {
  val db = Database.forDataSource(source)

  private val source = {
    val properties = new Properties
    properties.load(getClass.getResourceAsStream("/datasource.properties"))

    val source = new ComboPooledDataSource
    source.setProperties(properties)
    source
  }
}