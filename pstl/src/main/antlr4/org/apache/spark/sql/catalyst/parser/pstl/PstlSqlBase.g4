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

grammar PstlSqlBase;

import SqlBase;

singleStatement
    : statement EOF
    ;

statement
    : CREATE STREAM
        tableIdentifier ('(' colTypeList ')')? sourceProvider
        (OPTIONS tablePropertyList)?                                   #createStreamFrom
    | SAVE STREAM
        tableIdentifier sinkProvider
        (IDENTIFIED BY qualifiedName)?
        (TRIGGER trigger)?
        (OUTPUT MODE outputMode)?
        (PARTITIONED ON identifierList)?
        (OPTIONS tablePropertyList)?                                   #saveStreamTo
    | STOP STREAM qualifiedName                                        #stopStream
    | SHOW STREAMS                                                     #showStreams
    ;

sourceProvider
    : FROM qualifiedName
    ;

sinkProvider
    : TO qualifiedName
    ;

trigger
    : triggerField
    ;

triggerField
    : triggerValue triggerUnit                                         #triggerProcessingTime
    | ONCE                                                             #triggerOnce
    ;

triggerValue
    : INTEGER_VALUE
    ;

triggerUnit
    : TIME_HOURS
    | TIME_HOUR
    | TIME_MINUTES
    | TIME_MINUTE
    | TIME_SECONDS
    | TIME_SECOND
    | TIME_MILLISECONDS
    | TIME_MILLISECOND
    ;

outputMode
    : APPEND
    | COMPLETE
    | UPDATE;

APPEND: 'APPEND';
COMPLETE: 'COMPLETE';
FROM: 'FROM';
IDENTIFIED: 'IDENTIFIED';
OUTPUT: 'OUTPUT';
MODE: 'MODE';
SAVE: 'SAVE';
STOP: 'STOP';
STREAM: 'STREAM';
STREAMS: 'STREAMS';
TRIGGER: 'TRIGGER';
ONCE: 'ONCE';
PROCESSING: 'PROCESSING';
TIME: 'TIME';
UPDATE: 'UPDATE';
QUERY: 'QUERY';
NAME: 'NAME';

TIME_MILLISECOND: 'MILLISECOND';
TIME_MILLISECONDS: 'MILLISECONDS';

TIME_SECOND: 'SECOND';
TIME_SECONDS: 'SECONDS';

TIME_MINUTE: 'MINUTE';
TIME_MINUTES: 'MINUTES';

TIME_HOUR: 'HOUR';
TIME_HOURS: 'HOURS';
