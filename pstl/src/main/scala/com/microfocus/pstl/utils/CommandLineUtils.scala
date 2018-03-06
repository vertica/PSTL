/*
 * (c) Copyright [2018] Micro Focus or one of its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.microfocus.pstl.utils

import java.util.Properties

import joptsimple.{OptionException, OptionParser, OptionSet, OptionSpec}

object CommandLineUtils {
  def tryParse(parser: OptionParser, args: Array[String]): OptionSet = {
    try {
      parser.parse(args: _*)
    }
    catch {
      case e: OptionException =>
        printUsageAndDie(parser, e.getMessage)
    }
  }

  def checkRequiredArgs(parser: OptionParser, options: OptionSet, required: OptionSpec[_]*) {
    for (arg <- required) {
      if(!options.has(arg)) {
        printUsageAndDie(parser, s"Missing required argument '$arg'")
      }
    }
  }

  def checkInvalidArgs(parser: OptionParser,
                       options: OptionSet,
                       usedOption: OptionSpec[_],
                       invalidOptions: Set[OptionSpec[_]]) {
    if(options.has(usedOption)) {
      for (arg <- invalidOptions) {
        if(options.has(arg)) {
          val msg = s"Option '$usedOption' can't be used with option '$arg'"
          printUsageAndDie(parser, msg)
        }
      }
    }
  }

  def printUsageAndDie(parser: OptionParser): Nothing = {
    printUsageAndDie(parser, "")
  }

  def printUsageAndDie(parser: OptionParser, message: String): Nothing = {
    // scalastyle:off
    if(message.nonEmpty) {
      System.err.println(message)
    }
    // scalastyle:on

    parser.printHelpOn(System.err)
    sys.exit(1)
  }

  def parseKeyValueArgs(args: Iterable[String], acceptMissingValue: Boolean = true): Properties = {
    val splits = args.map(_ split "=").filterNot(_.length == 0)

    val props = new Properties
    for (a <- splits) {
      if (a.length == 1) {
        if (acceptMissingValue) props.put(a(0), "")
        else throw new IllegalArgumentException(s"Missing value for key ${a(0)}")
      }
      else if (a.length == 2) props.put(a(0), a(1))
      else {
        System.err.println("Invalid command line properties: " + args.mkString(" "))
        sys.exit(1)
      }
    }
    props
  }
}
