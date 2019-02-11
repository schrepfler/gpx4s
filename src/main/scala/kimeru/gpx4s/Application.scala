/*
 * Copyright 2019 Srdan Srepfler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.nio.file.Paths

import akka.actor.ActorSystem
import akka.stream.IOResult
import caseapp._

import scala.concurrent.Future

case class Options(
    file: String
)

object Applications extends CaseApp[Options] {
  import akka.stream.scaladsl._
  val system: ActorSystem = ActorSystem("gpx2csv")

  def run(options: Options, arg: RemainingArgs): Unit =
    println(s"Hello, World! $options.file")

  val file = Paths.get("example.csv")

  val foreach: Future[IOResult] = FileIO
    .fromPath(file)
    .to(Sink.ignore)
    .run()

}
