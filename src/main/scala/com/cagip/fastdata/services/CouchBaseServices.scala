package com.cagip.fastdata.services

import com.couchbase.client.scala.{Bucket, Collection}
import com.couchbase.client.scala.manager.bucket.BucketSettings
import com.cagip.fastdata.database.CouchBaseConnect.cluster
import org.apache.logging.log4j.scala.Logging

import scala.concurrent.duration.DurationInt
import scala.util.{Failure, Success, Try}


object CouchBaseServices extends Logging {

  val allBuckets: Seq[BucketSettings] = cluster.buckets.getAllBuckets() match {
    case Failure(e) =>
      logger.error(s"${this.getClass.getCanonicalName} ==> $e")
      Seq[BucketSettings]()
    case Success(value) => value
  }


  def getCollectionFromBucket(bucketName : String): Collection ={
    val bucket: Bucket = cluster.bucket(bucketName = bucketName)
    bucket.waitUntilReady(10.seconds).get
    bucket.defaultCollection
  }





}
