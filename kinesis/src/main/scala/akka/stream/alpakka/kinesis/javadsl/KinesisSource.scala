/*
 * Copyright (C) 2016-2018 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.stream.alpakka.kinesis.javadsl

import akka.NotUsed
import akka.stream.alpakka.kinesis.{scaladsl, ShardSettings}
import akka.stream.javadsl.Source
import com.amazonaws.services.kinesis.AmazonKinesisAsync
import com.amazonaws.services.kinesis.model.Record

import scala.collection.JavaConverters._

object KinesisSource {

  /**
   * Read from one shard into a stream.
   */
  def basic(shardSettings: ShardSettings, amazonKinesisAsync: AmazonKinesisAsync): Source[Record, NotUsed] =
    scaladsl.KinesisSource.basic(shardSettings, amazonKinesisAsync).asJava

  /**
   * Read from multiple shards into a single stream.
   */
  def basicMerge(shardSettings: java.util.List[ShardSettings],
                 amazonKinesisAsync: AmazonKinesisAsync): Source[Record, NotUsed] =
    scaladsl.KinesisSource.basicMerge(shardSettings.asScala.toList, amazonKinesisAsync).asJava

}
