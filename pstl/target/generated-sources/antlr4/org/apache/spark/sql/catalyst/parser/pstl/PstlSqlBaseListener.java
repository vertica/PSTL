// Generated from org/apache/spark/sql/catalyst/parser/pstl/PstlSqlBase.g4 by ANTLR 4.7
package org.apache.spark.sql.catalyst.parser.pstl;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PstlSqlBaseParser}.
 */
public interface PstlSqlBaseListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatement(PstlSqlBaseParser.SingleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#singleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatement(PstlSqlBaseParser.SingleStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createStreamFrom}
	 * labeled alternative in {@link PstlSqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCreateStreamFrom(PstlSqlBaseParser.CreateStreamFromContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createStreamFrom}
	 * labeled alternative in {@link PstlSqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCreateStreamFrom(PstlSqlBaseParser.CreateStreamFromContext ctx);
	/**
	 * Enter a parse tree produced by the {@code saveStreamTo}
	 * labeled alternative in {@link PstlSqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSaveStreamTo(PstlSqlBaseParser.SaveStreamToContext ctx);
	/**
	 * Exit a parse tree produced by the {@code saveStreamTo}
	 * labeled alternative in {@link PstlSqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSaveStreamTo(PstlSqlBaseParser.SaveStreamToContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stopStream}
	 * labeled alternative in {@link PstlSqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStopStream(PstlSqlBaseParser.StopStreamContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stopStream}
	 * labeled alternative in {@link PstlSqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStopStream(PstlSqlBaseParser.StopStreamContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showStreams}
	 * labeled alternative in {@link PstlSqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterShowStreams(PstlSqlBaseParser.ShowStreamsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showStreams}
	 * labeled alternative in {@link PstlSqlBaseParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitShowStreams(PstlSqlBaseParser.ShowStreamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#sourceProvider}.
	 * @param ctx the parse tree
	 */
	void enterSourceProvider(PstlSqlBaseParser.SourceProviderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#sourceProvider}.
	 * @param ctx the parse tree
	 */
	void exitSourceProvider(PstlSqlBaseParser.SourceProviderContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#sinkProvider}.
	 * @param ctx the parse tree
	 */
	void enterSinkProvider(PstlSqlBaseParser.SinkProviderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#sinkProvider}.
	 * @param ctx the parse tree
	 */
	void exitSinkProvider(PstlSqlBaseParser.SinkProviderContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#trigger}.
	 * @param ctx the parse tree
	 */
	void enterTrigger(PstlSqlBaseParser.TriggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#trigger}.
	 * @param ctx the parse tree
	 */
	void exitTrigger(PstlSqlBaseParser.TriggerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code triggerProcessingTime}
	 * labeled alternative in {@link PstlSqlBaseParser#triggerField}.
	 * @param ctx the parse tree
	 */
	void enterTriggerProcessingTime(PstlSqlBaseParser.TriggerProcessingTimeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code triggerProcessingTime}
	 * labeled alternative in {@link PstlSqlBaseParser#triggerField}.
	 * @param ctx the parse tree
	 */
	void exitTriggerProcessingTime(PstlSqlBaseParser.TriggerProcessingTimeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code triggerOnce}
	 * labeled alternative in {@link PstlSqlBaseParser#triggerField}.
	 * @param ctx the parse tree
	 */
	void enterTriggerOnce(PstlSqlBaseParser.TriggerOnceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code triggerOnce}
	 * labeled alternative in {@link PstlSqlBaseParser#triggerField}.
	 * @param ctx the parse tree
	 */
	void exitTriggerOnce(PstlSqlBaseParser.TriggerOnceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#triggerValue}.
	 * @param ctx the parse tree
	 */
	void enterTriggerValue(PstlSqlBaseParser.TriggerValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#triggerValue}.
	 * @param ctx the parse tree
	 */
	void exitTriggerValue(PstlSqlBaseParser.TriggerValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#triggerUnit}.
	 * @param ctx the parse tree
	 */
	void enterTriggerUnit(PstlSqlBaseParser.TriggerUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#triggerUnit}.
	 * @param ctx the parse tree
	 */
	void exitTriggerUnit(PstlSqlBaseParser.TriggerUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#outputMode}.
	 * @param ctx the parse tree
	 */
	void enterOutputMode(PstlSqlBaseParser.OutputModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#outputMode}.
	 * @param ctx the parse tree
	 */
	void exitOutputMode(PstlSqlBaseParser.OutputModeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSingleExpression(PstlSqlBaseParser.SingleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSingleExpression(PstlSqlBaseParser.SingleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#singleTableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSingleTableIdentifier(PstlSqlBaseParser.SingleTableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#singleTableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSingleTableIdentifier(PstlSqlBaseParser.SingleTableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#singleFunctionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterSingleFunctionIdentifier(PstlSqlBaseParser.SingleFunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#singleFunctionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitSingleFunctionIdentifier(PstlSqlBaseParser.SingleFunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#singleDataType}.
	 * @param ctx the parse tree
	 */
	void enterSingleDataType(PstlSqlBaseParser.SingleDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#singleDataType}.
	 * @param ctx the parse tree
	 */
	void exitSingleDataType(PstlSqlBaseParser.SingleDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#singleTableSchema}.
	 * @param ctx the parse tree
	 */
	void enterSingleTableSchema(PstlSqlBaseParser.SingleTableSchemaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#singleTableSchema}.
	 * @param ctx the parse tree
	 */
	void exitSingleTableSchema(PstlSqlBaseParser.SingleTableSchemaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#unsupportedHiveNativeCommands}.
	 * @param ctx the parse tree
	 */
	void enterUnsupportedHiveNativeCommands(PstlSqlBaseParser.UnsupportedHiveNativeCommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#unsupportedHiveNativeCommands}.
	 * @param ctx the parse tree
	 */
	void exitUnsupportedHiveNativeCommands(PstlSqlBaseParser.UnsupportedHiveNativeCommandsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#createTableHeader}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableHeader(PstlSqlBaseParser.CreateTableHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#createTableHeader}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableHeader(PstlSqlBaseParser.CreateTableHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#bucketSpec}.
	 * @param ctx the parse tree
	 */
	void enterBucketSpec(PstlSqlBaseParser.BucketSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#bucketSpec}.
	 * @param ctx the parse tree
	 */
	void exitBucketSpec(PstlSqlBaseParser.BucketSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#skewSpec}.
	 * @param ctx the parse tree
	 */
	void enterSkewSpec(PstlSqlBaseParser.SkewSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#skewSpec}.
	 * @param ctx the parse tree
	 */
	void exitSkewSpec(PstlSqlBaseParser.SkewSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#locationSpec}.
	 * @param ctx the parse tree
	 */
	void enterLocationSpec(PstlSqlBaseParser.LocationSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#locationSpec}.
	 * @param ctx the parse tree
	 */
	void exitLocationSpec(PstlSqlBaseParser.LocationSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(PstlSqlBaseParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(PstlSqlBaseParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertOverwriteTable}
	 * labeled alternative in {@link PstlSqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void enterInsertOverwriteTable(PstlSqlBaseParser.InsertOverwriteTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertOverwriteTable}
	 * labeled alternative in {@link PstlSqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void exitInsertOverwriteTable(PstlSqlBaseParser.InsertOverwriteTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertIntoTable}
	 * labeled alternative in {@link PstlSqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void enterInsertIntoTable(PstlSqlBaseParser.InsertIntoTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertIntoTable}
	 * labeled alternative in {@link PstlSqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void exitInsertIntoTable(PstlSqlBaseParser.InsertIntoTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertOverwriteHiveDir}
	 * labeled alternative in {@link PstlSqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void enterInsertOverwriteHiveDir(PstlSqlBaseParser.InsertOverwriteHiveDirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertOverwriteHiveDir}
	 * labeled alternative in {@link PstlSqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void exitInsertOverwriteHiveDir(PstlSqlBaseParser.InsertOverwriteHiveDirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertOverwriteDir}
	 * labeled alternative in {@link PstlSqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void enterInsertOverwriteDir(PstlSqlBaseParser.InsertOverwriteDirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertOverwriteDir}
	 * labeled alternative in {@link PstlSqlBaseParser#insertInto}.
	 * @param ctx the parse tree
	 */
	void exitInsertOverwriteDir(PstlSqlBaseParser.InsertOverwriteDirContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#partitionSpecLocation}.
	 * @param ctx the parse tree
	 */
	void enterPartitionSpecLocation(PstlSqlBaseParser.PartitionSpecLocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#partitionSpecLocation}.
	 * @param ctx the parse tree
	 */
	void exitPartitionSpecLocation(PstlSqlBaseParser.PartitionSpecLocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#partitionSpec}.
	 * @param ctx the parse tree
	 */
	void enterPartitionSpec(PstlSqlBaseParser.PartitionSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#partitionSpec}.
	 * @param ctx the parse tree
	 */
	void exitPartitionSpec(PstlSqlBaseParser.PartitionSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#partitionVal}.
	 * @param ctx the parse tree
	 */
	void enterPartitionVal(PstlSqlBaseParser.PartitionValContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#partitionVal}.
	 * @param ctx the parse tree
	 */
	void exitPartitionVal(PstlSqlBaseParser.PartitionValContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#describeFuncName}.
	 * @param ctx the parse tree
	 */
	void enterDescribeFuncName(PstlSqlBaseParser.DescribeFuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#describeFuncName}.
	 * @param ctx the parse tree
	 */
	void exitDescribeFuncName(PstlSqlBaseParser.DescribeFuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#describeColName}.
	 * @param ctx the parse tree
	 */
	void enterDescribeColName(PstlSqlBaseParser.DescribeColNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#describeColName}.
	 * @param ctx the parse tree
	 */
	void exitDescribeColName(PstlSqlBaseParser.DescribeColNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#ctes}.
	 * @param ctx the parse tree
	 */
	void enterCtes(PstlSqlBaseParser.CtesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#ctes}.
	 * @param ctx the parse tree
	 */
	void exitCtes(PstlSqlBaseParser.CtesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#namedQuery}.
	 * @param ctx the parse tree
	 */
	void enterNamedQuery(PstlSqlBaseParser.NamedQueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#namedQuery}.
	 * @param ctx the parse tree
	 */
	void exitNamedQuery(PstlSqlBaseParser.NamedQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#tableProvider}.
	 * @param ctx the parse tree
	 */
	void enterTableProvider(PstlSqlBaseParser.TableProviderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#tableProvider}.
	 * @param ctx the parse tree
	 */
	void exitTableProvider(PstlSqlBaseParser.TableProviderContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#tablePropertyList}.
	 * @param ctx the parse tree
	 */
	void enterTablePropertyList(PstlSqlBaseParser.TablePropertyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#tablePropertyList}.
	 * @param ctx the parse tree
	 */
	void exitTablePropertyList(PstlSqlBaseParser.TablePropertyListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#tableProperty}.
	 * @param ctx the parse tree
	 */
	void enterTableProperty(PstlSqlBaseParser.TablePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#tableProperty}.
	 * @param ctx the parse tree
	 */
	void exitTableProperty(PstlSqlBaseParser.TablePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#tablePropertyKey}.
	 * @param ctx the parse tree
	 */
	void enterTablePropertyKey(PstlSqlBaseParser.TablePropertyKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#tablePropertyKey}.
	 * @param ctx the parse tree
	 */
	void exitTablePropertyKey(PstlSqlBaseParser.TablePropertyKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#tablePropertyValue}.
	 * @param ctx the parse tree
	 */
	void enterTablePropertyValue(PstlSqlBaseParser.TablePropertyValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#tablePropertyValue}.
	 * @param ctx the parse tree
	 */
	void exitTablePropertyValue(PstlSqlBaseParser.TablePropertyValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#constantList}.
	 * @param ctx the parse tree
	 */
	void enterConstantList(PstlSqlBaseParser.ConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#constantList}.
	 * @param ctx the parse tree
	 */
	void exitConstantList(PstlSqlBaseParser.ConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#nestedConstantList}.
	 * @param ctx the parse tree
	 */
	void enterNestedConstantList(PstlSqlBaseParser.NestedConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#nestedConstantList}.
	 * @param ctx the parse tree
	 */
	void exitNestedConstantList(PstlSqlBaseParser.NestedConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#createFileFormat}.
	 * @param ctx the parse tree
	 */
	void enterCreateFileFormat(PstlSqlBaseParser.CreateFileFormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#createFileFormat}.
	 * @param ctx the parse tree
	 */
	void exitCreateFileFormat(PstlSqlBaseParser.CreateFileFormatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableFileFormat}
	 * labeled alternative in {@link PstlSqlBaseParser#fileFormat}.
	 * @param ctx the parse tree
	 */
	void enterTableFileFormat(PstlSqlBaseParser.TableFileFormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableFileFormat}
	 * labeled alternative in {@link PstlSqlBaseParser#fileFormat}.
	 * @param ctx the parse tree
	 */
	void exitTableFileFormat(PstlSqlBaseParser.TableFileFormatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code genericFileFormat}
	 * labeled alternative in {@link PstlSqlBaseParser#fileFormat}.
	 * @param ctx the parse tree
	 */
	void enterGenericFileFormat(PstlSqlBaseParser.GenericFileFormatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code genericFileFormat}
	 * labeled alternative in {@link PstlSqlBaseParser#fileFormat}.
	 * @param ctx the parse tree
	 */
	void exitGenericFileFormat(PstlSqlBaseParser.GenericFileFormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#storageHandler}.
	 * @param ctx the parse tree
	 */
	void enterStorageHandler(PstlSqlBaseParser.StorageHandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#storageHandler}.
	 * @param ctx the parse tree
	 */
	void exitStorageHandler(PstlSqlBaseParser.StorageHandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(PstlSqlBaseParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(PstlSqlBaseParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleInsertQuery}
	 * labeled alternative in {@link PstlSqlBaseParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void enterSingleInsertQuery(PstlSqlBaseParser.SingleInsertQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleInsertQuery}
	 * labeled alternative in {@link PstlSqlBaseParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void exitSingleInsertQuery(PstlSqlBaseParser.SingleInsertQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiInsertQuery}
	 * labeled alternative in {@link PstlSqlBaseParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void enterMultiInsertQuery(PstlSqlBaseParser.MultiInsertQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiInsertQuery}
	 * labeled alternative in {@link PstlSqlBaseParser#queryNoWith}.
	 * @param ctx the parse tree
	 */
	void exitMultiInsertQuery(PstlSqlBaseParser.MultiInsertQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#queryOrganization}.
	 * @param ctx the parse tree
	 */
	void enterQueryOrganization(PstlSqlBaseParser.QueryOrganizationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#queryOrganization}.
	 * @param ctx the parse tree
	 */
	void exitQueryOrganization(PstlSqlBaseParser.QueryOrganizationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#multiInsertQueryBody}.
	 * @param ctx the parse tree
	 */
	void enterMultiInsertQueryBody(PstlSqlBaseParser.MultiInsertQueryBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#multiInsertQueryBody}.
	 * @param ctx the parse tree
	 */
	void exitMultiInsertQueryBody(PstlSqlBaseParser.MultiInsertQueryBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryTermDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void enterQueryTermDefault(PstlSqlBaseParser.QueryTermDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryTermDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void exitQueryTermDefault(PstlSqlBaseParser.QueryTermDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code setOperation}
	 * labeled alternative in {@link PstlSqlBaseParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void enterSetOperation(PstlSqlBaseParser.SetOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code setOperation}
	 * labeled alternative in {@link PstlSqlBaseParser#queryTerm}.
	 * @param ctx the parse tree
	 */
	void exitSetOperation(PstlSqlBaseParser.SetOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code queryPrimaryDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterQueryPrimaryDefault(PstlSqlBaseParser.QueryPrimaryDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code queryPrimaryDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitQueryPrimaryDefault(PstlSqlBaseParser.QueryPrimaryDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code table}
	 * labeled alternative in {@link PstlSqlBaseParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTable(PstlSqlBaseParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code table}
	 * labeled alternative in {@link PstlSqlBaseParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTable(PstlSqlBaseParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineTableDefault1}
	 * labeled alternative in {@link PstlSqlBaseParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterInlineTableDefault1(PstlSqlBaseParser.InlineTableDefault1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineTableDefault1}
	 * labeled alternative in {@link PstlSqlBaseParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitInlineTableDefault1(PstlSqlBaseParser.InlineTableDefault1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code subquery}
	 * labeled alternative in {@link PstlSqlBaseParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void enterSubquery(PstlSqlBaseParser.SubqueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subquery}
	 * labeled alternative in {@link PstlSqlBaseParser#queryPrimary}.
	 * @param ctx the parse tree
	 */
	void exitSubquery(PstlSqlBaseParser.SubqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#sortItem}.
	 * @param ctx the parse tree
	 */
	void enterSortItem(PstlSqlBaseParser.SortItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#sortItem}.
	 * @param ctx the parse tree
	 */
	void exitSortItem(PstlSqlBaseParser.SortItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void enterQuerySpecification(PstlSqlBaseParser.QuerySpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#querySpecification}.
	 * @param ctx the parse tree
	 */
	void exitQuerySpecification(PstlSqlBaseParser.QuerySpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#hint}.
	 * @param ctx the parse tree
	 */
	void enterHint(PstlSqlBaseParser.HintContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#hint}.
	 * @param ctx the parse tree
	 */
	void exitHint(PstlSqlBaseParser.HintContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#hintStatement}.
	 * @param ctx the parse tree
	 */
	void enterHintStatement(PstlSqlBaseParser.HintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#hintStatement}.
	 * @param ctx the parse tree
	 */
	void exitHintStatement(PstlSqlBaseParser.HintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(PstlSqlBaseParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(PstlSqlBaseParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void enterAggregation(PstlSqlBaseParser.AggregationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#aggregation}.
	 * @param ctx the parse tree
	 */
	void exitAggregation(PstlSqlBaseParser.AggregationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#groupingSet}.
	 * @param ctx the parse tree
	 */
	void enterGroupingSet(PstlSqlBaseParser.GroupingSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#groupingSet}.
	 * @param ctx the parse tree
	 */
	void exitGroupingSet(PstlSqlBaseParser.GroupingSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#lateralView}.
	 * @param ctx the parse tree
	 */
	void enterLateralView(PstlSqlBaseParser.LateralViewContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#lateralView}.
	 * @param ctx the parse tree
	 */
	void exitLateralView(PstlSqlBaseParser.LateralViewContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void enterSetQuantifier(PstlSqlBaseParser.SetQuantifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#setQuantifier}.
	 * @param ctx the parse tree
	 */
	void exitSetQuantifier(PstlSqlBaseParser.SetQuantifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(PstlSqlBaseParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(PstlSqlBaseParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#joinRelation}.
	 * @param ctx the parse tree
	 */
	void enterJoinRelation(PstlSqlBaseParser.JoinRelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#joinRelation}.
	 * @param ctx the parse tree
	 */
	void exitJoinRelation(PstlSqlBaseParser.JoinRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#joinType}.
	 * @param ctx the parse tree
	 */
	void enterJoinType(PstlSqlBaseParser.JoinTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#joinType}.
	 * @param ctx the parse tree
	 */
	void exitJoinType(PstlSqlBaseParser.JoinTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#joinCriteria}.
	 * @param ctx the parse tree
	 */
	void enterJoinCriteria(PstlSqlBaseParser.JoinCriteriaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#joinCriteria}.
	 * @param ctx the parse tree
	 */
	void exitJoinCriteria(PstlSqlBaseParser.JoinCriteriaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#sample}.
	 * @param ctx the parse tree
	 */
	void enterSample(PstlSqlBaseParser.SampleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#sample}.
	 * @param ctx the parse tree
	 */
	void exitSample(PstlSqlBaseParser.SampleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(PstlSqlBaseParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(PstlSqlBaseParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#identifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierSeq(PstlSqlBaseParser.IdentifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#identifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierSeq(PstlSqlBaseParser.IdentifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#orderedIdentifierList}.
	 * @param ctx the parse tree
	 */
	void enterOrderedIdentifierList(PstlSqlBaseParser.OrderedIdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#orderedIdentifierList}.
	 * @param ctx the parse tree
	 */
	void exitOrderedIdentifierList(PstlSqlBaseParser.OrderedIdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#orderedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterOrderedIdentifier(PstlSqlBaseParser.OrderedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#orderedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitOrderedIdentifier(PstlSqlBaseParser.OrderedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#identifierCommentList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierCommentList(PstlSqlBaseParser.IdentifierCommentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#identifierCommentList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierCommentList(PstlSqlBaseParser.IdentifierCommentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#identifierComment}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierComment(PstlSqlBaseParser.IdentifierCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#identifierComment}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierComment(PstlSqlBaseParser.IdentifierCommentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableName}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTableName(PstlSqlBaseParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableName}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTableName(PstlSqlBaseParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aliasedQuery}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterAliasedQuery(PstlSqlBaseParser.AliasedQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aliasedQuery}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitAliasedQuery(PstlSqlBaseParser.AliasedQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code aliasedRelation}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterAliasedRelation(PstlSqlBaseParser.AliasedRelationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code aliasedRelation}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitAliasedRelation(PstlSqlBaseParser.AliasedRelationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inlineTableDefault2}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterInlineTableDefault2(PstlSqlBaseParser.InlineTableDefault2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code inlineTableDefault2}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitInlineTableDefault2(PstlSqlBaseParser.InlineTableDefault2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code tableValuedFunction}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void enterTableValuedFunction(PstlSqlBaseParser.TableValuedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableValuedFunction}
	 * labeled alternative in {@link PstlSqlBaseParser#relationPrimary}.
	 * @param ctx the parse tree
	 */
	void exitTableValuedFunction(PstlSqlBaseParser.TableValuedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#inlineTable}.
	 * @param ctx the parse tree
	 */
	void enterInlineTable(PstlSqlBaseParser.InlineTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#inlineTable}.
	 * @param ctx the parse tree
	 */
	void exitInlineTable(PstlSqlBaseParser.InlineTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#functionTable}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTable(PstlSqlBaseParser.FunctionTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#functionTable}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTable(PstlSqlBaseParser.FunctionTableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void enterTableAlias(PstlSqlBaseParser.TableAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#tableAlias}.
	 * @param ctx the parse tree
	 */
	void exitTableAlias(PstlSqlBaseParser.TableAliasContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowFormatSerde}
	 * labeled alternative in {@link PstlSqlBaseParser#rowFormat}.
	 * @param ctx the parse tree
	 */
	void enterRowFormatSerde(PstlSqlBaseParser.RowFormatSerdeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowFormatSerde}
	 * labeled alternative in {@link PstlSqlBaseParser#rowFormat}.
	 * @param ctx the parse tree
	 */
	void exitRowFormatSerde(PstlSqlBaseParser.RowFormatSerdeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowFormatDelimited}
	 * labeled alternative in {@link PstlSqlBaseParser#rowFormat}.
	 * @param ctx the parse tree
	 */
	void enterRowFormatDelimited(PstlSqlBaseParser.RowFormatDelimitedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowFormatDelimited}
	 * labeled alternative in {@link PstlSqlBaseParser#rowFormat}.
	 * @param ctx the parse tree
	 */
	void exitRowFormatDelimited(PstlSqlBaseParser.RowFormatDelimitedContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTableIdentifier(PstlSqlBaseParser.TableIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#tableIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTableIdentifier(PstlSqlBaseParser.TableIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionIdentifier(PstlSqlBaseParser.FunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionIdentifier(PstlSqlBaseParser.FunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#namedExpression}.
	 * @param ctx the parse tree
	 */
	void enterNamedExpression(PstlSqlBaseParser.NamedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#namedExpression}.
	 * @param ctx the parse tree
	 */
	void exitNamedExpression(PstlSqlBaseParser.NamedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#namedExpressionSeq}.
	 * @param ctx the parse tree
	 */
	void enterNamedExpressionSeq(PstlSqlBaseParser.NamedExpressionSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#namedExpressionSeq}.
	 * @param ctx the parse tree
	 */
	void exitNamedExpressionSeq(PstlSqlBaseParser.NamedExpressionSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PstlSqlBaseParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PstlSqlBaseParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link PstlSqlBaseParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNot(PstlSqlBaseParser.LogicalNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalNot}
	 * labeled alternative in {@link PstlSqlBaseParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNot(PstlSqlBaseParser.LogicalNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanDefault(PstlSqlBaseParser.BooleanDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanDefault(PstlSqlBaseParser.BooleanDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exists}
	 * labeled alternative in {@link PstlSqlBaseParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterExists(PstlSqlBaseParser.ExistsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exists}
	 * labeled alternative in {@link PstlSqlBaseParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitExists(PstlSqlBaseParser.ExistsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalBinary}
	 * labeled alternative in {@link PstlSqlBaseParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalBinary(PstlSqlBaseParser.LogicalBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalBinary}
	 * labeled alternative in {@link PstlSqlBaseParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalBinary(PstlSqlBaseParser.LogicalBinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#predicated}.
	 * @param ctx the parse tree
	 */
	void enterPredicated(PstlSqlBaseParser.PredicatedContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#predicated}.
	 * @param ctx the parse tree
	 */
	void exitPredicated(PstlSqlBaseParser.PredicatedContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(PstlSqlBaseParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(PstlSqlBaseParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpressionDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpressionDefault(PstlSqlBaseParser.ValueExpressionDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpressionDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpressionDefault(PstlSqlBaseParser.ValueExpressionDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link PstlSqlBaseParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparison(PstlSqlBaseParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparison}
	 * labeled alternative in {@link PstlSqlBaseParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparison(PstlSqlBaseParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticBinary}
	 * labeled alternative in {@link PstlSqlBaseParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticBinary(PstlSqlBaseParser.ArithmeticBinaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticBinary}
	 * labeled alternative in {@link PstlSqlBaseParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticBinary(PstlSqlBaseParser.ArithmeticBinaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticUnary}
	 * labeled alternative in {@link PstlSqlBaseParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticUnary(PstlSqlBaseParser.ArithmeticUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticUnary}
	 * labeled alternative in {@link PstlSqlBaseParser#valueExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticUnary(PstlSqlBaseParser.ArithmeticUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code struct}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterStruct(PstlSqlBaseParser.StructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code struct}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitStruct(PstlSqlBaseParser.StructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dereference}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterDereference(PstlSqlBaseParser.DereferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dereference}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitDereference(PstlSqlBaseParser.DereferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleCase}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCase(PstlSqlBaseParser.SimpleCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleCase}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCase(PstlSqlBaseParser.SimpleCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code columnReference}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterColumnReference(PstlSqlBaseParser.ColumnReferenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code columnReference}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitColumnReference(PstlSqlBaseParser.ColumnReferenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rowConstructor}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterRowConstructor(PstlSqlBaseParser.RowConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rowConstructor}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitRowConstructor(PstlSqlBaseParser.RowConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code last}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterLast(PstlSqlBaseParser.LastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code last}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitLast(PstlSqlBaseParser.LastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code star}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterStar(PstlSqlBaseParser.StarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code star}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitStar(PstlSqlBaseParser.StarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(PstlSqlBaseParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(PstlSqlBaseParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timeFunctionCall}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterTimeFunctionCall(PstlSqlBaseParser.TimeFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timeFunctionCall}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitTimeFunctionCall(PstlSqlBaseParser.TimeFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subqueryExpression}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSubqueryExpression(PstlSqlBaseParser.SubqueryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subqueryExpression}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSubqueryExpression(PstlSqlBaseParser.SubqueryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cast}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterCast(PstlSqlBaseParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cast}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitCast(PstlSqlBaseParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantDefault(PstlSqlBaseParser.ConstantDefaultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantDefault}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantDefault(PstlSqlBaseParser.ConstantDefaultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(PstlSqlBaseParser.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedExpression}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(PstlSqlBaseParser.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(PstlSqlBaseParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(PstlSqlBaseParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code searchedCase}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterSearchedCase(PstlSqlBaseParser.SearchedCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code searchedCase}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitSearchedCase(PstlSqlBaseParser.SearchedCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code position}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPosition(PstlSqlBaseParser.PositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code position}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPosition(PstlSqlBaseParser.PositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code first}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterFirst(PstlSqlBaseParser.FirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code first}
	 * labeled alternative in {@link PstlSqlBaseParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitFirst(PstlSqlBaseParser.FirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(PstlSqlBaseParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(PstlSqlBaseParser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterIntervalLiteral(PstlSqlBaseParser.IntervalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intervalLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitIntervalLiteral(PstlSqlBaseParser.IntervalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterTypeConstructor(PstlSqlBaseParser.TypeConstructorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeConstructor}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitTypeConstructor(PstlSqlBaseParser.TypeConstructorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(PstlSqlBaseParser.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numericLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(PstlSqlBaseParser.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(PstlSqlBaseParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(PstlSqlBaseParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(PstlSqlBaseParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(PstlSqlBaseParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(PstlSqlBaseParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(PstlSqlBaseParser.ComparisonOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(PstlSqlBaseParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(PstlSqlBaseParser.ArithmeticOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#predicateOperator}.
	 * @param ctx the parse tree
	 */
	void enterPredicateOperator(PstlSqlBaseParser.PredicateOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#predicateOperator}.
	 * @param ctx the parse tree
	 */
	void exitPredicateOperator(PstlSqlBaseParser.PredicateOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(PstlSqlBaseParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(PstlSqlBaseParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#interval}.
	 * @param ctx the parse tree
	 */
	void enterInterval(PstlSqlBaseParser.IntervalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#interval}.
	 * @param ctx the parse tree
	 */
	void exitInterval(PstlSqlBaseParser.IntervalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#intervalField}.
	 * @param ctx the parse tree
	 */
	void enterIntervalField(PstlSqlBaseParser.IntervalFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#intervalField}.
	 * @param ctx the parse tree
	 */
	void exitIntervalField(PstlSqlBaseParser.IntervalFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#intervalValue}.
	 * @param ctx the parse tree
	 */
	void enterIntervalValue(PstlSqlBaseParser.IntervalValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#intervalValue}.
	 * @param ctx the parse tree
	 */
	void exitIntervalValue(PstlSqlBaseParser.IntervalValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#colPosition}.
	 * @param ctx the parse tree
	 */
	void enterColPosition(PstlSqlBaseParser.ColPositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#colPosition}.
	 * @param ctx the parse tree
	 */
	void exitColPosition(PstlSqlBaseParser.ColPositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code complexDataType}
	 * labeled alternative in {@link PstlSqlBaseParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterComplexDataType(PstlSqlBaseParser.ComplexDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code complexDataType}
	 * labeled alternative in {@link PstlSqlBaseParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitComplexDataType(PstlSqlBaseParser.ComplexDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primitiveDataType}
	 * labeled alternative in {@link PstlSqlBaseParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveDataType(PstlSqlBaseParser.PrimitiveDataTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primitiveDataType}
	 * labeled alternative in {@link PstlSqlBaseParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveDataType(PstlSqlBaseParser.PrimitiveDataTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#colTypeList}.
	 * @param ctx the parse tree
	 */
	void enterColTypeList(PstlSqlBaseParser.ColTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#colTypeList}.
	 * @param ctx the parse tree
	 */
	void exitColTypeList(PstlSqlBaseParser.ColTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#colType}.
	 * @param ctx the parse tree
	 */
	void enterColType(PstlSqlBaseParser.ColTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#colType}.
	 * @param ctx the parse tree
	 */
	void exitColType(PstlSqlBaseParser.ColTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#complexColTypeList}.
	 * @param ctx the parse tree
	 */
	void enterComplexColTypeList(PstlSqlBaseParser.ComplexColTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#complexColTypeList}.
	 * @param ctx the parse tree
	 */
	void exitComplexColTypeList(PstlSqlBaseParser.ComplexColTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#complexColType}.
	 * @param ctx the parse tree
	 */
	void enterComplexColType(PstlSqlBaseParser.ComplexColTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#complexColType}.
	 * @param ctx the parse tree
	 */
	void exitComplexColType(PstlSqlBaseParser.ComplexColTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void enterWhenClause(PstlSqlBaseParser.WhenClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#whenClause}.
	 * @param ctx the parse tree
	 */
	void exitWhenClause(PstlSqlBaseParser.WhenClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#windows}.
	 * @param ctx the parse tree
	 */
	void enterWindows(PstlSqlBaseParser.WindowsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#windows}.
	 * @param ctx the parse tree
	 */
	void exitWindows(PstlSqlBaseParser.WindowsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#namedWindow}.
	 * @param ctx the parse tree
	 */
	void enterNamedWindow(PstlSqlBaseParser.NamedWindowContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#namedWindow}.
	 * @param ctx the parse tree
	 */
	void exitNamedWindow(PstlSqlBaseParser.NamedWindowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code windowRef}
	 * labeled alternative in {@link PstlSqlBaseParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void enterWindowRef(PstlSqlBaseParser.WindowRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code windowRef}
	 * labeled alternative in {@link PstlSqlBaseParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void exitWindowRef(PstlSqlBaseParser.WindowRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code windowDef}
	 * labeled alternative in {@link PstlSqlBaseParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void enterWindowDef(PstlSqlBaseParser.WindowDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code windowDef}
	 * labeled alternative in {@link PstlSqlBaseParser#windowSpec}.
	 * @param ctx the parse tree
	 */
	void exitWindowDef(PstlSqlBaseParser.WindowDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#windowFrame}.
	 * @param ctx the parse tree
	 */
	void enterWindowFrame(PstlSqlBaseParser.WindowFrameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#windowFrame}.
	 * @param ctx the parse tree
	 */
	void exitWindowFrame(PstlSqlBaseParser.WindowFrameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#frameBound}.
	 * @param ctx the parse tree
	 */
	void enterFrameBound(PstlSqlBaseParser.FrameBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#frameBound}.
	 * @param ctx the parse tree
	 */
	void exitFrameBound(PstlSqlBaseParser.FrameBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(PstlSqlBaseParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(PstlSqlBaseParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PstlSqlBaseParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PstlSqlBaseParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link PstlSqlBaseParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterUnquotedIdentifier(PstlSqlBaseParser.UnquotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unquotedIdentifier}
	 * labeled alternative in {@link PstlSqlBaseParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitUnquotedIdentifier(PstlSqlBaseParser.UnquotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code quotedIdentifierAlternative}
	 * labeled alternative in {@link PstlSqlBaseParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifierAlternative(PstlSqlBaseParser.QuotedIdentifierAlternativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code quotedIdentifierAlternative}
	 * labeled alternative in {@link PstlSqlBaseParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifierAlternative(PstlSqlBaseParser.QuotedIdentifierAlternativeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(PstlSqlBaseParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(PstlSqlBaseParser.QuotedIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(PstlSqlBaseParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(PstlSqlBaseParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(PstlSqlBaseParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(PstlSqlBaseParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bigIntLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterBigIntLiteral(PstlSqlBaseParser.BigIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bigIntLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitBigIntLiteral(PstlSqlBaseParser.BigIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code smallIntLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterSmallIntLiteral(PstlSqlBaseParser.SmallIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code smallIntLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitSmallIntLiteral(PstlSqlBaseParser.SmallIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tinyIntLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterTinyIntLiteral(PstlSqlBaseParser.TinyIntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tinyIntLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitTinyIntLiteral(PstlSqlBaseParser.TinyIntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterDoubleLiteral(PstlSqlBaseParser.DoubleLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitDoubleLiteral(PstlSqlBaseParser.DoubleLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bigDecimalLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void enterBigDecimalLiteral(PstlSqlBaseParser.BigDecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bigDecimalLiteral}
	 * labeled alternative in {@link PstlSqlBaseParser#number}.
	 * @param ctx the parse tree
	 */
	void exitBigDecimalLiteral(PstlSqlBaseParser.BigDecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PstlSqlBaseParser#nonReserved}.
	 * @param ctx the parse tree
	 */
	void enterNonReserved(PstlSqlBaseParser.NonReservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link PstlSqlBaseParser#nonReserved}.
	 * @param ctx the parse tree
	 */
	void exitNonReserved(PstlSqlBaseParser.NonReservedContext ctx);
}