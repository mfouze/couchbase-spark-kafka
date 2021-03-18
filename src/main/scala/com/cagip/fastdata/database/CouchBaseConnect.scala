package com.cagip.fastdata.database

import com.couchbase.client.scala.Cluster

object CouchBaseConnect {

  val cluster: Cluster = Cluster.connect(
    connectionString =  "user-Pc-Ubuntu.mshome.net",
    username =  "Admin",
    password =  "Covid19!").get



}

