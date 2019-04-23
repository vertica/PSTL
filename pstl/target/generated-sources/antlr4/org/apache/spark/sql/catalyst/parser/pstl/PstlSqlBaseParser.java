// Generated from org/apache/spark/sql/catalyst/parser/pstl/PstlSqlBase.g4 by ANTLR 4.7
package org.apache.spark.sql.catalyst.parser.pstl;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PstlSqlBaseParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		APPEND=10, COMPLETE=11, FROM=12, IDENTIFIED=13, OUTPUT=14, MODE=15, SAVE=16, 
		STOP=17, STREAM=18, STREAMS=19, TRIGGER=20, ONCE=21, PROCESSING=22, TIME=23, 
		UPDATE=24, QUERY=25, NAME=26, TIME_MILLISECOND=27, TIME_MILLISECONDS=28, 
		TIME_SECOND=29, TIME_SECONDS=30, TIME_MINUTE=31, TIME_MINUTES=32, TIME_HOUR=33, 
		TIME_HOURS=34, SELECT=35, ADD=36, AS=37, ALL=38, DISTINCT=39, WHERE=40, 
		GROUP=41, BY=42, GROUPING=43, SETS=44, CUBE=45, ROLLUP=46, ORDER=47, HAVING=48, 
		LIMIT=49, AT=50, OR=51, AND=52, IN=53, NOT=54, NO=55, EXISTS=56, BETWEEN=57, 
		LIKE=58, RLIKE=59, IS=60, NULL=61, TRUE=62, FALSE=63, NULLS=64, ASC=65, 
		DESC=66, FOR=67, INTERVAL=68, CASE=69, WHEN=70, THEN=71, ELSE=72, END=73, 
		JOIN=74, CROSS=75, OUTER=76, INNER=77, LEFT=78, SEMI=79, RIGHT=80, FULL=81, 
		NATURAL=82, ON=83, LATERAL=84, WINDOW=85, OVER=86, PARTITION=87, RANGE=88, 
		ROWS=89, UNBOUNDED=90, PRECEDING=91, FOLLOWING=92, CURRENT=93, FIRST=94, 
		AFTER=95, LAST=96, ROW=97, WITH=98, VALUES=99, CREATE=100, TABLE=101, 
		DIRECTORY=102, VIEW=103, REPLACE=104, INSERT=105, DELETE=106, INTO=107, 
		DESCRIBE=108, EXPLAIN=109, FORMAT=110, LOGICAL=111, CODEGEN=112, COST=113, 
		CAST=114, SHOW=115, TABLES=116, COLUMNS=117, COLUMN=118, USE=119, PARTITIONS=120, 
		FUNCTIONS=121, DROP=122, UNION=123, EXCEPT=124, SETMINUS=125, INTERSECT=126, 
		TO=127, TABLESAMPLE=128, STRATIFY=129, ALTER=130, RENAME=131, ARRAY=132, 
		MAP=133, STRUCT=134, COMMENT=135, SET=136, RESET=137, DATA=138, START=139, 
		TRANSACTION=140, COMMIT=141, ROLLBACK=142, MACRO=143, IGNORE=144, BOTH=145, 
		LEADING=146, TRAILING=147, IF=148, POSITION=149, EQ=150, NSEQ=151, NEQ=152, 
		NEQJ=153, LT=154, LTE=155, GT=156, GTE=157, PLUS=158, MINUS=159, ASTERISK=160, 
		SLASH=161, PERCENT=162, DIV=163, TILDE=164, AMPERSAND=165, PIPE=166, CONCAT_PIPE=167, 
		HAT=168, PERCENTLIT=169, BUCKET=170, OUT=171, OF=172, SORT=173, CLUSTER=174, 
		DISTRIBUTE=175, OVERWRITE=176, TRANSFORM=177, REDUCE=178, USING=179, SERDE=180, 
		SERDEPROPERTIES=181, RECORDREADER=182, RECORDWRITER=183, DELIMITED=184, 
		FIELDS=185, TERMINATED=186, COLLECTION=187, ITEMS=188, KEYS=189, ESCAPED=190, 
		LINES=191, SEPARATED=192, FUNCTION=193, EXTENDED=194, REFRESH=195, CLEAR=196, 
		CACHE=197, UNCACHE=198, LAZY=199, FORMATTED=200, GLOBAL=201, TEMPORARY=202, 
		OPTIONS=203, UNSET=204, TBLPROPERTIES=205, DBPROPERTIES=206, BUCKETS=207, 
		SKEWED=208, STORED=209, DIRECTORIES=210, LOCATION=211, EXCHANGE=212, ARCHIVE=213, 
		UNARCHIVE=214, FILEFORMAT=215, TOUCH=216, COMPACT=217, CONCATENATE=218, 
		CHANGE=219, CASCADE=220, RESTRICT=221, CLUSTERED=222, SORTED=223, PURGE=224, 
		INPUTFORMAT=225, OUTPUTFORMAT=226, DATABASE=227, DATABASES=228, DFS=229, 
		TRUNCATE=230, ANALYZE=231, COMPUTE=232, LIST=233, STATISTICS=234, PARTITIONED=235, 
		EXTERNAL=236, DEFINED=237, REVOKE=238, GRANT=239, LOCK=240, UNLOCK=241, 
		MSCK=242, REPAIR=243, RECOVER=244, EXPORT=245, IMPORT=246, LOAD=247, ROLE=248, 
		ROLES=249, COMPACTIONS=250, PRINCIPALS=251, TRANSACTIONS=252, INDEX=253, 
		INDEXES=254, LOCKS=255, OPTION=256, ANTI=257, LOCAL=258, INPATH=259, CURRENT_DATE=260, 
		CURRENT_TIMESTAMP=261, STRING=262, BIGINT_LITERAL=263, SMALLINT_LITERAL=264, 
		TINYINT_LITERAL=265, BYTELENGTH_LITERAL=266, INTEGER_VALUE=267, DECIMAL_VALUE=268, 
		DOUBLE_LITERAL=269, BIGDECIMAL_LITERAL=270, IDENTIFIER=271, BACKQUOTED_IDENTIFIER=272, 
		SIMPLE_COMMENT=273, BRACKETED_EMPTY_COMMENT=274, BRACKETED_COMMENT=275, 
		WS=276, UNRECOGNIZED=277, DELIMITER=278;
	public static final int
		RULE_singleStatement = 0, RULE_statement = 1, RULE_sourceProvider = 2, 
		RULE_sinkProvider = 3, RULE_trigger = 4, RULE_triggerField = 5, RULE_triggerValue = 6, 
		RULE_triggerUnit = 7, RULE_outputMode = 8, RULE_singleExpression = 9, 
		RULE_singleTableIdentifier = 10, RULE_singleFunctionIdentifier = 11, RULE_singleDataType = 12, 
		RULE_singleTableSchema = 13, RULE_unsupportedHiveNativeCommands = 14, 
		RULE_createTableHeader = 15, RULE_bucketSpec = 16, RULE_skewSpec = 17, 
		RULE_locationSpec = 18, RULE_query = 19, RULE_insertInto = 20, RULE_partitionSpecLocation = 21, 
		RULE_partitionSpec = 22, RULE_partitionVal = 23, RULE_describeFuncName = 24, 
		RULE_describeColName = 25, RULE_ctes = 26, RULE_namedQuery = 27, RULE_tableProvider = 28, 
		RULE_tablePropertyList = 29, RULE_tableProperty = 30, RULE_tablePropertyKey = 31, 
		RULE_tablePropertyValue = 32, RULE_constantList = 33, RULE_nestedConstantList = 34, 
		RULE_createFileFormat = 35, RULE_fileFormat = 36, RULE_storageHandler = 37, 
		RULE_resource = 38, RULE_queryNoWith = 39, RULE_queryOrganization = 40, 
		RULE_multiInsertQueryBody = 41, RULE_queryTerm = 42, RULE_queryPrimary = 43, 
		RULE_sortItem = 44, RULE_querySpecification = 45, RULE_hint = 46, RULE_hintStatement = 47, 
		RULE_fromClause = 48, RULE_aggregation = 49, RULE_groupingSet = 50, RULE_lateralView = 51, 
		RULE_setQuantifier = 52, RULE_relation = 53, RULE_joinRelation = 54, RULE_joinType = 55, 
		RULE_joinCriteria = 56, RULE_sample = 57, RULE_identifierList = 58, RULE_identifierSeq = 59, 
		RULE_orderedIdentifierList = 60, RULE_orderedIdentifier = 61, RULE_identifierCommentList = 62, 
		RULE_identifierComment = 63, RULE_relationPrimary = 64, RULE_inlineTable = 65, 
		RULE_functionTable = 66, RULE_tableAlias = 67, RULE_rowFormat = 68, RULE_tableIdentifier = 69, 
		RULE_functionIdentifier = 70, RULE_namedExpression = 71, RULE_namedExpressionSeq = 72, 
		RULE_expression = 73, RULE_booleanExpression = 74, RULE_predicated = 75, 
		RULE_predicate = 76, RULE_valueExpression = 77, RULE_primaryExpression = 78, 
		RULE_constant = 79, RULE_comparisonOperator = 80, RULE_arithmeticOperator = 81, 
		RULE_predicateOperator = 82, RULE_booleanValue = 83, RULE_interval = 84, 
		RULE_intervalField = 85, RULE_intervalValue = 86, RULE_colPosition = 87, 
		RULE_dataType = 88, RULE_colTypeList = 89, RULE_colType = 90, RULE_complexColTypeList = 91, 
		RULE_complexColType = 92, RULE_whenClause = 93, RULE_windows = 94, RULE_namedWindow = 95, 
		RULE_windowSpec = 96, RULE_windowFrame = 97, RULE_frameBound = 98, RULE_qualifiedName = 99, 
		RULE_identifier = 100, RULE_strictIdentifier = 101, RULE_quotedIdentifier = 102, 
		RULE_number = 103, RULE_nonReserved = 104;
	public static final String[] ruleNames = {
		"singleStatement", "statement", "sourceProvider", "sinkProvider", "trigger", 
		"triggerField", "triggerValue", "triggerUnit", "outputMode", "singleExpression", 
		"singleTableIdentifier", "singleFunctionIdentifier", "singleDataType", 
		"singleTableSchema", "unsupportedHiveNativeCommands", "createTableHeader", 
		"bucketSpec", "skewSpec", "locationSpec", "query", "insertInto", "partitionSpecLocation", 
		"partitionSpec", "partitionVal", "describeFuncName", "describeColName", 
		"ctes", "namedQuery", "tableProvider", "tablePropertyList", "tableProperty", 
		"tablePropertyKey", "tablePropertyValue", "constantList", "nestedConstantList", 
		"createFileFormat", "fileFormat", "storageHandler", "resource", "queryNoWith", 
		"queryOrganization", "multiInsertQueryBody", "queryTerm", "queryPrimary", 
		"sortItem", "querySpecification", "hint", "hintStatement", "fromClause", 
		"aggregation", "groupingSet", "lateralView", "setQuantifier", "relation", 
		"joinRelation", "joinType", "joinCriteria", "sample", "identifierList", 
		"identifierSeq", "orderedIdentifierList", "orderedIdentifier", "identifierCommentList", 
		"identifierComment", "relationPrimary", "inlineTable", "functionTable", 
		"tableAlias", "rowFormat", "tableIdentifier", "functionIdentifier", "namedExpression", 
		"namedExpressionSeq", "expression", "booleanExpression", "predicated", 
		"predicate", "valueExpression", "primaryExpression", "constant", "comparisonOperator", 
		"arithmeticOperator", "predicateOperator", "booleanValue", "interval", 
		"intervalField", "intervalValue", "colPosition", "dataType", "colTypeList", 
		"colType", "complexColTypeList", "complexColType", "whenClause", "windows", 
		"namedWindow", "windowSpec", "windowFrame", "frameBound", "qualifiedName", 
		"identifier", "strictIdentifier", "quotedIdentifier", "number", "nonReserved"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "','", "'.'", "'/*+'", "'*/'", "'['", "']'", "':'", 
		"'APPEND'", "'COMPLETE'", "'FROM'", "'IDENTIFIED'", "'OUTPUT'", "'MODE'", 
		"'SAVE'", "'STOP'", "'STREAM'", "'STREAMS'", "'TRIGGER'", "'ONCE'", "'PROCESSING'", 
		"'TIME'", "'UPDATE'", "'QUERY'", "'NAME'", "'MILLISECOND'", "'MILLISECONDS'", 
		"'SECOND'", "'SECONDS'", "'MINUTE'", "'MINUTES'", "'HOUR'", "'HOURS'", 
		"'SELECT'", "'ADD'", "'AS'", "'ALL'", "'DISTINCT'", "'WHERE'", "'GROUP'", 
		"'BY'", "'GROUPING'", "'SETS'", "'CUBE'", "'ROLLUP'", "'ORDER'", "'HAVING'", 
		"'LIMIT'", "'AT'", "'OR'", "'AND'", "'IN'", null, "'NO'", "'EXISTS'", 
		"'BETWEEN'", "'LIKE'", null, "'IS'", "'NULL'", "'TRUE'", "'FALSE'", "'NULLS'", 
		"'ASC'", "'DESC'", "'FOR'", "'INTERVAL'", "'CASE'", "'WHEN'", "'THEN'", 
		"'ELSE'", "'END'", "'JOIN'", "'CROSS'", "'OUTER'", "'INNER'", "'LEFT'", 
		"'SEMI'", "'RIGHT'", "'FULL'", "'NATURAL'", "'ON'", "'LATERAL'", "'WINDOW'", 
		"'OVER'", "'PARTITION'", "'RANGE'", "'ROWS'", "'UNBOUNDED'", "'PRECEDING'", 
		"'FOLLOWING'", "'CURRENT'", "'FIRST'", "'AFTER'", "'LAST'", "'ROW'", "'WITH'", 
		"'VALUES'", "'CREATE'", "'TABLE'", "'DIRECTORY'", "'VIEW'", "'REPLACE'", 
		"'INSERT'", "'DELETE'", "'INTO'", "'DESCRIBE'", "'EXPLAIN'", "'FORMAT'", 
		"'LOGICAL'", "'CODEGEN'", "'COST'", "'CAST'", "'SHOW'", "'TABLES'", "'COLUMNS'", 
		"'COLUMN'", "'USE'", "'PARTITIONS'", "'FUNCTIONS'", "'DROP'", "'UNION'", 
		"'EXCEPT'", "'MINUS'", "'INTERSECT'", "'TO'", "'TABLESAMPLE'", "'STRATIFY'", 
		"'ALTER'", "'RENAME'", "'ARRAY'", "'MAP'", "'STRUCT'", "'COMMENT'", "'SET'", 
		"'RESET'", "'DATA'", "'START'", "'TRANSACTION'", "'COMMIT'", "'ROLLBACK'", 
		"'MACRO'", "'IGNORE'", "'BOTH'", "'LEADING'", "'TRAILING'", "'IF'", "'POSITION'", 
		null, "'<=>'", "'<>'", "'!='", "'<'", null, "'>'", null, "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'DIV'", "'~'", "'&'", "'|'", "'||'", "'^'", "'PERCENT'", 
		"'BUCKET'", "'OUT'", "'OF'", "'SORT'", "'CLUSTER'", "'DISTRIBUTE'", "'OVERWRITE'", 
		"'TRANSFORM'", "'REDUCE'", "'USING'", "'SERDE'", "'SERDEPROPERTIES'", 
		"'RECORDREADER'", "'RECORDWRITER'", "'DELIMITED'", "'FIELDS'", "'TERMINATED'", 
		"'COLLECTION'", "'ITEMS'", "'KEYS'", "'ESCAPED'", "'LINES'", "'SEPARATED'", 
		"'FUNCTION'", "'EXTENDED'", "'REFRESH'", "'CLEAR'", "'CACHE'", "'UNCACHE'", 
		"'LAZY'", "'FORMATTED'", "'GLOBAL'", null, "'OPTIONS'", "'UNSET'", "'TBLPROPERTIES'", 
		"'DBPROPERTIES'", "'BUCKETS'", "'SKEWED'", "'STORED'", "'DIRECTORIES'", 
		"'LOCATION'", "'EXCHANGE'", "'ARCHIVE'", "'UNARCHIVE'", "'FILEFORMAT'", 
		"'TOUCH'", "'COMPACT'", "'CONCATENATE'", "'CHANGE'", "'CASCADE'", "'RESTRICT'", 
		"'CLUSTERED'", "'SORTED'", "'PURGE'", "'INPUTFORMAT'", "'OUTPUTFORMAT'", 
		null, null, "'DFS'", "'TRUNCATE'", "'ANALYZE'", "'COMPUTE'", "'LIST'", 
		"'STATISTICS'", "'PARTITIONED'", "'EXTERNAL'", "'DEFINED'", "'REVOKE'", 
		"'GRANT'", "'LOCK'", "'UNLOCK'", "'MSCK'", "'REPAIR'", "'RECOVER'", "'EXPORT'", 
		"'IMPORT'", "'LOAD'", "'ROLE'", "'ROLES'", "'COMPACTIONS'", "'PRINCIPALS'", 
		"'TRANSACTIONS'", "'INDEX'", "'INDEXES'", "'LOCKS'", "'OPTION'", "'ANTI'", 
		"'LOCAL'", "'INPATH'", "'CURRENT_DATE'", "'CURRENT_TIMESTAMP'", null, 
		null, null, null, null, null, null, null, null, null, null, null, "'/**/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "APPEND", 
		"COMPLETE", "FROM", "IDENTIFIED", "OUTPUT", "MODE", "SAVE", "STOP", "STREAM", 
		"STREAMS", "TRIGGER", "ONCE", "PROCESSING", "TIME", "UPDATE", "QUERY", 
		"NAME", "TIME_MILLISECOND", "TIME_MILLISECONDS", "TIME_SECOND", "TIME_SECONDS", 
		"TIME_MINUTE", "TIME_MINUTES", "TIME_HOUR", "TIME_HOURS", "SELECT", "ADD", 
		"AS", "ALL", "DISTINCT", "WHERE", "GROUP", "BY", "GROUPING", "SETS", "CUBE", 
		"ROLLUP", "ORDER", "HAVING", "LIMIT", "AT", "OR", "AND", "IN", "NOT", 
		"NO", "EXISTS", "BETWEEN", "LIKE", "RLIKE", "IS", "NULL", "TRUE", "FALSE", 
		"NULLS", "ASC", "DESC", "FOR", "INTERVAL", "CASE", "WHEN", "THEN", "ELSE", 
		"END", "JOIN", "CROSS", "OUTER", "INNER", "LEFT", "SEMI", "RIGHT", "FULL", 
		"NATURAL", "ON", "LATERAL", "WINDOW", "OVER", "PARTITION", "RANGE", "ROWS", 
		"UNBOUNDED", "PRECEDING", "FOLLOWING", "CURRENT", "FIRST", "AFTER", "LAST", 
		"ROW", "WITH", "VALUES", "CREATE", "TABLE", "DIRECTORY", "VIEW", "REPLACE", 
		"INSERT", "DELETE", "INTO", "DESCRIBE", "EXPLAIN", "FORMAT", "LOGICAL", 
		"CODEGEN", "COST", "CAST", "SHOW", "TABLES", "COLUMNS", "COLUMN", "USE", 
		"PARTITIONS", "FUNCTIONS", "DROP", "UNION", "EXCEPT", "SETMINUS", "INTERSECT", 
		"TO", "TABLESAMPLE", "STRATIFY", "ALTER", "RENAME", "ARRAY", "MAP", "STRUCT", 
		"COMMENT", "SET", "RESET", "DATA", "START", "TRANSACTION", "COMMIT", "ROLLBACK", 
		"MACRO", "IGNORE", "BOTH", "LEADING", "TRAILING", "IF", "POSITION", "EQ", 
		"NSEQ", "NEQ", "NEQJ", "LT", "LTE", "GT", "GTE", "PLUS", "MINUS", "ASTERISK", 
		"SLASH", "PERCENT", "DIV", "TILDE", "AMPERSAND", "PIPE", "CONCAT_PIPE", 
		"HAT", "PERCENTLIT", "BUCKET", "OUT", "OF", "SORT", "CLUSTER", "DISTRIBUTE", 
		"OVERWRITE", "TRANSFORM", "REDUCE", "USING", "SERDE", "SERDEPROPERTIES", 
		"RECORDREADER", "RECORDWRITER", "DELIMITED", "FIELDS", "TERMINATED", "COLLECTION", 
		"ITEMS", "KEYS", "ESCAPED", "LINES", "SEPARATED", "FUNCTION", "EXTENDED", 
		"REFRESH", "CLEAR", "CACHE", "UNCACHE", "LAZY", "FORMATTED", "GLOBAL", 
		"TEMPORARY", "OPTIONS", "UNSET", "TBLPROPERTIES", "DBPROPERTIES", "BUCKETS", 
		"SKEWED", "STORED", "DIRECTORIES", "LOCATION", "EXCHANGE", "ARCHIVE", 
		"UNARCHIVE", "FILEFORMAT", "TOUCH", "COMPACT", "CONCATENATE", "CHANGE", 
		"CASCADE", "RESTRICT", "CLUSTERED", "SORTED", "PURGE", "INPUTFORMAT", 
		"OUTPUTFORMAT", "DATABASE", "DATABASES", "DFS", "TRUNCATE", "ANALYZE", 
		"COMPUTE", "LIST", "STATISTICS", "PARTITIONED", "EXTERNAL", "DEFINED", 
		"REVOKE", "GRANT", "LOCK", "UNLOCK", "MSCK", "REPAIR", "RECOVER", "EXPORT", 
		"IMPORT", "LOAD", "ROLE", "ROLES", "COMPACTIONS", "PRINCIPALS", "TRANSACTIONS", 
		"INDEX", "INDEXES", "LOCKS", "OPTION", "ANTI", "LOCAL", "INPATH", "CURRENT_DATE", 
		"CURRENT_TIMESTAMP", "STRING", "BIGINT_LITERAL", "SMALLINT_LITERAL", "TINYINT_LITERAL", 
		"BYTELENGTH_LITERAL", "INTEGER_VALUE", "DECIMAL_VALUE", "DOUBLE_LITERAL", 
		"BIGDECIMAL_LITERAL", "IDENTIFIER", "BACKQUOTED_IDENTIFIER", "SIMPLE_COMMENT", 
		"BRACKETED_EMPTY_COMMENT", "BRACKETED_COMMENT", "WS", "UNRECOGNIZED", 
		"DELIMITER"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PstlSqlBase.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  /**
	   * Verify whether current token is a valid decimal token (which contains dot).
	   * Returns true if the character that follows the token is not a digit or letter or underscore.
	   *
	   * For example:
	   * For char stream "2.3", "2." is not a valid decimal token, because it is followed by digit '3'.
	   * For char stream "2.3_", "2.3" is not a valid decimal token, because it is followed by '_'.
	   * For char stream "2.3W", "2.3" is not a valid decimal token, because it is followed by 'W'.
	   * For char stream "12.0D 34.E2+0.12 "  12.0D is a valid decimal token because it is folllowed
	   * by a space. 34.E2 is a valid decimal token because it is followed by symbol '+'
	   * which is not a digit or letter or underscore.
	   */
	  public boolean isValidDecimal() {
	    int nextChar = _input.LA(1);
	    if (nextChar >= 'A' && nextChar <= 'Z' || nextChar >= '0' && nextChar <= '9' ||
	      nextChar == '_') {
	      return false;
	    } else {
	      return true;
	    }
	  }

	public PstlSqlBaseParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SingleStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PstlSqlBaseParser.EOF, 0); }
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_singleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			statement();
			setState(211);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SaveStreamToContext extends StatementContext {
		public TerminalNode SAVE() { return getToken(PstlSqlBaseParser.SAVE, 0); }
		public TerminalNode STREAM() { return getToken(PstlSqlBaseParser.STREAM, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public SinkProviderContext sinkProvider() {
			return getRuleContext(SinkProviderContext.class,0);
		}
		public TerminalNode IDENTIFIED() { return getToken(PstlSqlBaseParser.IDENTIFIED, 0); }
		public TerminalNode BY() { return getToken(PstlSqlBaseParser.BY, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode TRIGGER() { return getToken(PstlSqlBaseParser.TRIGGER, 0); }
		public TriggerContext trigger() {
			return getRuleContext(TriggerContext.class,0);
		}
		public TerminalNode OUTPUT() { return getToken(PstlSqlBaseParser.OUTPUT, 0); }
		public TerminalNode MODE() { return getToken(PstlSqlBaseParser.MODE, 0); }
		public OutputModeContext outputMode() {
			return getRuleContext(OutputModeContext.class,0);
		}
		public TerminalNode PARTITIONED() { return getToken(PstlSqlBaseParser.PARTITIONED, 0); }
		public TerminalNode ON() { return getToken(PstlSqlBaseParser.ON, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode OPTIONS() { return getToken(PstlSqlBaseParser.OPTIONS, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public SaveStreamToContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSaveStreamTo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSaveStreamTo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSaveStreamTo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ShowStreamsContext extends StatementContext {
		public TerminalNode SHOW() { return getToken(PstlSqlBaseParser.SHOW, 0); }
		public TerminalNode STREAMS() { return getToken(PstlSqlBaseParser.STREAMS, 0); }
		public ShowStreamsContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterShowStreams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitShowStreams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitShowStreams(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateStreamFromContext extends StatementContext {
		public TerminalNode CREATE() { return getToken(PstlSqlBaseParser.CREATE, 0); }
		public TerminalNode STREAM() { return getToken(PstlSqlBaseParser.STREAM, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public SourceProviderContext sourceProvider() {
			return getRuleContext(SourceProviderContext.class,0);
		}
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public TerminalNode OPTIONS() { return getToken(PstlSqlBaseParser.OPTIONS, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public CreateStreamFromContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterCreateStreamFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitCreateStreamFrom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitCreateStreamFrom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StopStreamContext extends StatementContext {
		public TerminalNode STOP() { return getToken(PstlSqlBaseParser.STOP, 0); }
		public TerminalNode STREAM() { return getToken(PstlSqlBaseParser.STREAM, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public StopStreamContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterStopStream(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitStopStream(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitStopStream(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(259);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE:
				_localctx = new CreateStreamFromContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(CREATE);
				setState(214);
				match(STREAM);
				setState(215);
				tableIdentifier();
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(216);
					match(T__0);
					setState(217);
					colTypeList();
					setState(218);
					match(T__1);
					}
				}

				setState(222);
				sourceProvider();
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS) {
					{
					setState(223);
					match(OPTIONS);
					setState(224);
					tablePropertyList();
					}
				}

				}
				break;
			case SAVE:
				_localctx = new SaveStreamToContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				match(SAVE);
				setState(228);
				match(STREAM);
				setState(229);
				tableIdentifier();
				setState(230);
				sinkProvider();
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIED) {
					{
					setState(231);
					match(IDENTIFIED);
					setState(232);
					match(BY);
					setState(233);
					qualifiedName();
					}
				}

				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TRIGGER) {
					{
					setState(236);
					match(TRIGGER);
					setState(237);
					trigger();
					}
				}

				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTPUT) {
					{
					setState(240);
					match(OUTPUT);
					setState(241);
					match(MODE);
					setState(242);
					outputMode();
					}
				}

				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITIONED) {
					{
					setState(245);
					match(PARTITIONED);
					setState(246);
					match(ON);
					setState(247);
					identifierList();
					}
				}

				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS) {
					{
					setState(250);
					match(OPTIONS);
					setState(251);
					tablePropertyList();
					}
				}

				}
				break;
			case STOP:
				_localctx = new StopStreamContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(254);
				match(STOP);
				setState(255);
				match(STREAM);
				setState(256);
				qualifiedName();
				}
				break;
			case SHOW:
				_localctx = new ShowStreamsContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				match(SHOW);
				setState(258);
				match(STREAMS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceProviderContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(PstlSqlBaseParser.FROM, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public SourceProviderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceProvider; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSourceProvider(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSourceProvider(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSourceProvider(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SourceProviderContext sourceProvider() throws RecognitionException {
		SourceProviderContext _localctx = new SourceProviderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sourceProvider);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(FROM);
			setState(262);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SinkProviderContext extends ParserRuleContext {
		public TerminalNode TO() { return getToken(PstlSqlBaseParser.TO, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public SinkProviderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sinkProvider; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSinkProvider(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSinkProvider(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSinkProvider(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SinkProviderContext sinkProvider() throws RecognitionException {
		SinkProviderContext _localctx = new SinkProviderContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sinkProvider);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(TO);
			setState(265);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerContext extends ParserRuleContext {
		public TriggerFieldContext triggerField() {
			return getRuleContext(TriggerFieldContext.class,0);
		}
		public TriggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTrigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTrigger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTrigger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerContext trigger() throws RecognitionException {
		TriggerContext _localctx = new TriggerContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			triggerField();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerFieldContext extends ParserRuleContext {
		public TriggerFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerField; }
	 
		public TriggerFieldContext() { }
		public void copyFrom(TriggerFieldContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TriggerProcessingTimeContext extends TriggerFieldContext {
		public TriggerValueContext triggerValue() {
			return getRuleContext(TriggerValueContext.class,0);
		}
		public TriggerUnitContext triggerUnit() {
			return getRuleContext(TriggerUnitContext.class,0);
		}
		public TriggerProcessingTimeContext(TriggerFieldContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTriggerProcessingTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTriggerProcessingTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTriggerProcessingTime(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TriggerOnceContext extends TriggerFieldContext {
		public TerminalNode ONCE() { return getToken(PstlSqlBaseParser.ONCE, 0); }
		public TriggerOnceContext(TriggerFieldContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTriggerOnce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTriggerOnce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTriggerOnce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerFieldContext triggerField() throws RecognitionException {
		TriggerFieldContext _localctx = new TriggerFieldContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_triggerField);
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_VALUE:
				_localctx = new TriggerProcessingTimeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				triggerValue();
				setState(270);
				triggerUnit();
				}
				break;
			case ONCE:
				_localctx = new TriggerOnceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(ONCE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(PstlSqlBaseParser.INTEGER_VALUE, 0); }
		public TriggerValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTriggerValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTriggerValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTriggerValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerValueContext triggerValue() throws RecognitionException {
		TriggerValueContext _localctx = new TriggerValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_triggerValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(INTEGER_VALUE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TriggerUnitContext extends ParserRuleContext {
		public TerminalNode TIME_HOURS() { return getToken(PstlSqlBaseParser.TIME_HOURS, 0); }
		public TerminalNode TIME_HOUR() { return getToken(PstlSqlBaseParser.TIME_HOUR, 0); }
		public TerminalNode TIME_MINUTES() { return getToken(PstlSqlBaseParser.TIME_MINUTES, 0); }
		public TerminalNode TIME_MINUTE() { return getToken(PstlSqlBaseParser.TIME_MINUTE, 0); }
		public TerminalNode TIME_SECONDS() { return getToken(PstlSqlBaseParser.TIME_SECONDS, 0); }
		public TerminalNode TIME_SECOND() { return getToken(PstlSqlBaseParser.TIME_SECOND, 0); }
		public TerminalNode TIME_MILLISECONDS() { return getToken(PstlSqlBaseParser.TIME_MILLISECONDS, 0); }
		public TerminalNode TIME_MILLISECOND() { return getToken(PstlSqlBaseParser.TIME_MILLISECOND, 0); }
		public TriggerUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggerUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTriggerUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTriggerUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTriggerUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerUnitContext triggerUnit() throws RecognitionException {
		TriggerUnitContext _localctx = new TriggerUnitContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_triggerUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIME_MILLISECOND) | (1L << TIME_MILLISECONDS) | (1L << TIME_SECOND) | (1L << TIME_SECONDS) | (1L << TIME_MINUTE) | (1L << TIME_MINUTES) | (1L << TIME_HOUR) | (1L << TIME_HOURS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutputModeContext extends ParserRuleContext {
		public TerminalNode APPEND() { return getToken(PstlSqlBaseParser.APPEND, 0); }
		public TerminalNode COMPLETE() { return getToken(PstlSqlBaseParser.COMPLETE, 0); }
		public TerminalNode UPDATE() { return getToken(PstlSqlBaseParser.UPDATE, 0); }
		public OutputModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterOutputMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitOutputMode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitOutputMode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputModeContext outputMode() throws RecognitionException {
		OutputModeContext _localctx = new OutputModeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_outputMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << APPEND) | (1L << COMPLETE) | (1L << UPDATE))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleExpressionContext extends ParserRuleContext {
		public NamedExpressionContext namedExpression() {
			return getRuleContext(NamedExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PstlSqlBaseParser.EOF, 0); }
		public SingleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSingleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSingleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSingleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleExpressionContext singleExpression() throws RecognitionException {
		SingleExpressionContext _localctx = new SingleExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_singleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			namedExpression();
			setState(282);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTableIdentifierContext extends ParserRuleContext {
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PstlSqlBaseParser.EOF, 0); }
		public SingleTableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTableIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSingleTableIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSingleTableIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSingleTableIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleTableIdentifierContext singleTableIdentifier() throws RecognitionException {
		SingleTableIdentifierContext _localctx = new SingleTableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_singleTableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			tableIdentifier();
			setState(285);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleFunctionIdentifierContext extends ParserRuleContext {
		public FunctionIdentifierContext functionIdentifier() {
			return getRuleContext(FunctionIdentifierContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PstlSqlBaseParser.EOF, 0); }
		public SingleFunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleFunctionIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSingleFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSingleFunctionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSingleFunctionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleFunctionIdentifierContext singleFunctionIdentifier() throws RecognitionException {
		SingleFunctionIdentifierContext _localctx = new SingleFunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_singleFunctionIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			functionIdentifier();
			setState(288);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleDataTypeContext extends ParserRuleContext {
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PstlSqlBaseParser.EOF, 0); }
		public SingleDataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSingleDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSingleDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSingleDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleDataTypeContext singleDataType() throws RecognitionException {
		SingleDataTypeContext _localctx = new SingleDataTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_singleDataType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			dataType();
			setState(291);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleTableSchemaContext extends ParserRuleContext {
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PstlSqlBaseParser.EOF, 0); }
		public SingleTableSchemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleTableSchema; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSingleTableSchema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSingleTableSchema(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSingleTableSchema(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleTableSchemaContext singleTableSchema() throws RecognitionException {
		SingleTableSchemaContext _localctx = new SingleTableSchemaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_singleTableSchema);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			colTypeList();
			setState(294);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnsupportedHiveNativeCommandsContext extends ParserRuleContext {
		public Token kw1;
		public Token kw2;
		public Token kw3;
		public Token kw4;
		public Token kw5;
		public Token kw6;
		public TerminalNode CREATE() { return getToken(PstlSqlBaseParser.CREATE, 0); }
		public TerminalNode ROLE() { return getToken(PstlSqlBaseParser.ROLE, 0); }
		public TerminalNode DROP() { return getToken(PstlSqlBaseParser.DROP, 0); }
		public TerminalNode GRANT() { return getToken(PstlSqlBaseParser.GRANT, 0); }
		public TerminalNode REVOKE() { return getToken(PstlSqlBaseParser.REVOKE, 0); }
		public TerminalNode SHOW() { return getToken(PstlSqlBaseParser.SHOW, 0); }
		public TerminalNode PRINCIPALS() { return getToken(PstlSqlBaseParser.PRINCIPALS, 0); }
		public TerminalNode ROLES() { return getToken(PstlSqlBaseParser.ROLES, 0); }
		public TerminalNode CURRENT() { return getToken(PstlSqlBaseParser.CURRENT, 0); }
		public TerminalNode EXPORT() { return getToken(PstlSqlBaseParser.EXPORT, 0); }
		public TerminalNode TABLE() { return getToken(PstlSqlBaseParser.TABLE, 0); }
		public TerminalNode IMPORT() { return getToken(PstlSqlBaseParser.IMPORT, 0); }
		public TerminalNode COMPACTIONS() { return getToken(PstlSqlBaseParser.COMPACTIONS, 0); }
		public TerminalNode TRANSACTIONS() { return getToken(PstlSqlBaseParser.TRANSACTIONS, 0); }
		public TerminalNode INDEXES() { return getToken(PstlSqlBaseParser.INDEXES, 0); }
		public TerminalNode LOCKS() { return getToken(PstlSqlBaseParser.LOCKS, 0); }
		public TerminalNode INDEX() { return getToken(PstlSqlBaseParser.INDEX, 0); }
		public TerminalNode ALTER() { return getToken(PstlSqlBaseParser.ALTER, 0); }
		public TerminalNode LOCK() { return getToken(PstlSqlBaseParser.LOCK, 0); }
		public TerminalNode DATABASE() { return getToken(PstlSqlBaseParser.DATABASE, 0); }
		public TerminalNode UNLOCK() { return getToken(PstlSqlBaseParser.UNLOCK, 0); }
		public TerminalNode TEMPORARY() { return getToken(PstlSqlBaseParser.TEMPORARY, 0); }
		public TerminalNode MACRO() { return getToken(PstlSqlBaseParser.MACRO, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PstlSqlBaseParser.NOT, 0); }
		public TerminalNode CLUSTERED() { return getToken(PstlSqlBaseParser.CLUSTERED, 0); }
		public TerminalNode BY() { return getToken(PstlSqlBaseParser.BY, 0); }
		public TerminalNode SORTED() { return getToken(PstlSqlBaseParser.SORTED, 0); }
		public TerminalNode SKEWED() { return getToken(PstlSqlBaseParser.SKEWED, 0); }
		public TerminalNode STORED() { return getToken(PstlSqlBaseParser.STORED, 0); }
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public TerminalNode DIRECTORIES() { return getToken(PstlSqlBaseParser.DIRECTORIES, 0); }
		public TerminalNode SET() { return getToken(PstlSqlBaseParser.SET, 0); }
		public TerminalNode LOCATION() { return getToken(PstlSqlBaseParser.LOCATION, 0); }
		public TerminalNode EXCHANGE() { return getToken(PstlSqlBaseParser.EXCHANGE, 0); }
		public TerminalNode PARTITION() { return getToken(PstlSqlBaseParser.PARTITION, 0); }
		public TerminalNode ARCHIVE() { return getToken(PstlSqlBaseParser.ARCHIVE, 0); }
		public TerminalNode UNARCHIVE() { return getToken(PstlSqlBaseParser.UNARCHIVE, 0); }
		public TerminalNode TOUCH() { return getToken(PstlSqlBaseParser.TOUCH, 0); }
		public TerminalNode COMPACT() { return getToken(PstlSqlBaseParser.COMPACT, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode CONCATENATE() { return getToken(PstlSqlBaseParser.CONCATENATE, 0); }
		public TerminalNode FILEFORMAT() { return getToken(PstlSqlBaseParser.FILEFORMAT, 0); }
		public TerminalNode REPLACE() { return getToken(PstlSqlBaseParser.REPLACE, 0); }
		public TerminalNode COLUMNS() { return getToken(PstlSqlBaseParser.COLUMNS, 0); }
		public TerminalNode START() { return getToken(PstlSqlBaseParser.START, 0); }
		public TerminalNode TRANSACTION() { return getToken(PstlSqlBaseParser.TRANSACTION, 0); }
		public TerminalNode COMMIT() { return getToken(PstlSqlBaseParser.COMMIT, 0); }
		public TerminalNode ROLLBACK() { return getToken(PstlSqlBaseParser.ROLLBACK, 0); }
		public TerminalNode DFS() { return getToken(PstlSqlBaseParser.DFS, 0); }
		public TerminalNode DELETE() { return getToken(PstlSqlBaseParser.DELETE, 0); }
		public TerminalNode FROM() { return getToken(PstlSqlBaseParser.FROM, 0); }
		public UnsupportedHiveNativeCommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsupportedHiveNativeCommands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterUnsupportedHiveNativeCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitUnsupportedHiveNativeCommands(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitUnsupportedHiveNativeCommands(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsupportedHiveNativeCommandsContext unsupportedHiveNativeCommands() throws RecognitionException {
		UnsupportedHiveNativeCommandsContext _localctx = new UnsupportedHiveNativeCommandsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unsupportedHiveNativeCommands);
		int _la;
		try {
			setState(466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(297);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(299);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(300);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(GRANT);
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROLE) {
					{
					setState(301);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(304);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(REVOKE);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROLE) {
					{
					setState(305);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(308);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(309);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(GRANT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(310);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(311);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLE);
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==GRANT) {
					{
					setState(312);
					((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(GRANT);
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(315);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(316);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(PRINCIPALS);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(317);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(318);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(ROLES);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(319);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(320);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(CURRENT);
				setState(321);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(ROLES);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(322);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(EXPORT);
				setState(323);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(324);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(IMPORT);
				setState(325);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(326);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(327);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(COMPACTIONS);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(328);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(329);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(CREATE);
				setState(330);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(TABLE);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(331);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(332);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TRANSACTIONS);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(333);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(334);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEXES);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(335);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(SHOW);
				setState(336);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(LOCKS);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(337);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(338);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(339);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(340);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(341);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(342);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(INDEX);
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(343);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(LOCK);
				setState(344);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(345);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(LOCK);
				setState(346);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(DATABASE);
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(347);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(UNLOCK);
				setState(348);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(349);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(UNLOCK);
				setState(350);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(DATABASE);
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(351);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(CREATE);
				setState(352);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TEMPORARY);
				setState(353);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(MACRO);
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(354);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DROP);
				setState(355);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TEMPORARY);
				setState(356);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(MACRO);
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(357);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(358);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(359);
				tableIdentifier();
				setState(360);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(361);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(CLUSTERED);
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(363);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(364);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(365);
				tableIdentifier();
				setState(366);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(CLUSTERED);
				setState(367);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(BY);
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(369);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(370);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(371);
				tableIdentifier();
				setState(372);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(373);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SORTED);
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(375);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(376);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(377);
				tableIdentifier();
				setState(378);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SKEWED);
				setState(379);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(BY);
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(381);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(382);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(383);
				tableIdentifier();
				setState(384);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(385);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SKEWED);
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(387);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(388);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(389);
				tableIdentifier();
				setState(390);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(NOT);
				setState(391);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(STORED);
				setState(392);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw5 = match(AS);
				setState(393);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw6 = match(DIRECTORIES);
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(395);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(396);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(397);
				tableIdentifier();
				setState(398);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SET);
				setState(399);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(SKEWED);
				setState(400);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw5 = match(LOCATION);
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(402);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(403);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(404);
				tableIdentifier();
				setState(405);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(EXCHANGE);
				setState(406);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(408);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(409);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(410);
				tableIdentifier();
				setState(411);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(ARCHIVE);
				setState(412);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(414);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(415);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(416);
				tableIdentifier();
				setState(417);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(UNARCHIVE);
				setState(418);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(PARTITION);
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(420);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(421);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(422);
				tableIdentifier();
				setState(423);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(TOUCH);
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(425);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(426);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(427);
				tableIdentifier();
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(428);
					partitionSpec();
					}
				}

				setState(431);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(COMPACT);
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(433);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(434);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(435);
				tableIdentifier();
				setState(437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(436);
					partitionSpec();
					}
				}

				setState(439);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(CONCATENATE);
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(441);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(442);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(443);
				tableIdentifier();
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(444);
					partitionSpec();
					}
				}

				setState(447);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(SET);
				setState(448);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(FILEFORMAT);
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(450);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ALTER);
				setState(451);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TABLE);
				setState(452);
				tableIdentifier();
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(453);
					partitionSpec();
					}
				}

				setState(456);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw3 = match(REPLACE);
				setState(457);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw4 = match(COLUMNS);
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(459);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(START);
				setState(460);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(TRANSACTION);
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(461);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(COMMIT);
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(462);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(ROLLBACK);
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(463);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DFS);
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(464);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw1 = match(DELETE);
				setState(465);
				((UnsupportedHiveNativeCommandsContext)_localctx).kw2 = match(FROM);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateTableHeaderContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(PstlSqlBaseParser.CREATE, 0); }
		public TerminalNode TABLE() { return getToken(PstlSqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode TEMPORARY() { return getToken(PstlSqlBaseParser.TEMPORARY, 0); }
		public TerminalNode EXTERNAL() { return getToken(PstlSqlBaseParser.EXTERNAL, 0); }
		public TerminalNode IF() { return getToken(PstlSqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(PstlSqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(PstlSqlBaseParser.EXISTS, 0); }
		public CreateTableHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterCreateTableHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitCreateTableHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitCreateTableHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableHeaderContext createTableHeader() throws RecognitionException {
		CreateTableHeaderContext _localctx = new CreateTableHeaderContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_createTableHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(CREATE);
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TEMPORARY) {
				{
				setState(469);
				match(TEMPORARY);
				}
			}

			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTERNAL) {
				{
				setState(472);
				match(EXTERNAL);
				}
			}

			setState(475);
			match(TABLE);
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(476);
				match(IF);
				setState(477);
				match(NOT);
				setState(478);
				match(EXISTS);
				}
				break;
			}
			setState(481);
			tableIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BucketSpecContext extends ParserRuleContext {
		public TerminalNode CLUSTERED() { return getToken(PstlSqlBaseParser.CLUSTERED, 0); }
		public List<TerminalNode> BY() { return getTokens(PstlSqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(PstlSqlBaseParser.BY, i);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode INTO() { return getToken(PstlSqlBaseParser.INTO, 0); }
		public TerminalNode INTEGER_VALUE() { return getToken(PstlSqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode BUCKETS() { return getToken(PstlSqlBaseParser.BUCKETS, 0); }
		public TerminalNode SORTED() { return getToken(PstlSqlBaseParser.SORTED, 0); }
		public OrderedIdentifierListContext orderedIdentifierList() {
			return getRuleContext(OrderedIdentifierListContext.class,0);
		}
		public BucketSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bucketSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterBucketSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitBucketSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitBucketSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BucketSpecContext bucketSpec() throws RecognitionException {
		BucketSpecContext _localctx = new BucketSpecContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_bucketSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			match(CLUSTERED);
			setState(484);
			match(BY);
			setState(485);
			identifierList();
			setState(489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORTED) {
				{
				setState(486);
				match(SORTED);
				setState(487);
				match(BY);
				setState(488);
				orderedIdentifierList();
				}
			}

			setState(491);
			match(INTO);
			setState(492);
			match(INTEGER_VALUE);
			setState(493);
			match(BUCKETS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SkewSpecContext extends ParserRuleContext {
		public TerminalNode SKEWED() { return getToken(PstlSqlBaseParser.SKEWED, 0); }
		public TerminalNode BY() { return getToken(PstlSqlBaseParser.BY, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode ON() { return getToken(PstlSqlBaseParser.ON, 0); }
		public ConstantListContext constantList() {
			return getRuleContext(ConstantListContext.class,0);
		}
		public NestedConstantListContext nestedConstantList() {
			return getRuleContext(NestedConstantListContext.class,0);
		}
		public TerminalNode STORED() { return getToken(PstlSqlBaseParser.STORED, 0); }
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public TerminalNode DIRECTORIES() { return getToken(PstlSqlBaseParser.DIRECTORIES, 0); }
		public SkewSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skewSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSkewSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSkewSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSkewSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SkewSpecContext skewSpec() throws RecognitionException {
		SkewSpecContext _localctx = new SkewSpecContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_skewSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495);
			match(SKEWED);
			setState(496);
			match(BY);
			setState(497);
			identifierList();
			setState(498);
			match(ON);
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(499);
				constantList();
				}
				break;
			case 2:
				{
				setState(500);
				nestedConstantList();
				}
				break;
			}
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STORED) {
				{
				setState(503);
				match(STORED);
				setState(504);
				match(AS);
				setState(505);
				match(DIRECTORIES);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocationSpecContext extends ParserRuleContext {
		public TerminalNode LOCATION() { return getToken(PstlSqlBaseParser.LOCATION, 0); }
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public LocationSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locationSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterLocationSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitLocationSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitLocationSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationSpecContext locationSpec() throws RecognitionException {
		LocationSpecContext _localctx = new LocationSpecContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_locationSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
			match(LOCATION);
			setState(509);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public CtesContext ctes() {
			return getRuleContext(CtesContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(511);
				ctes();
				}
			}

			setState(514);
			queryNoWith();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertIntoContext extends ParserRuleContext {
		public InsertIntoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertInto; }
	 
		public InsertIntoContext() { }
		public void copyFrom(InsertIntoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InsertOverwriteHiveDirContext extends InsertIntoContext {
		public Token path;
		public TerminalNode INSERT() { return getToken(PstlSqlBaseParser.INSERT, 0); }
		public TerminalNode OVERWRITE() { return getToken(PstlSqlBaseParser.OVERWRITE, 0); }
		public TerminalNode DIRECTORY() { return getToken(PstlSqlBaseParser.DIRECTORY, 0); }
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public TerminalNode LOCAL() { return getToken(PstlSqlBaseParser.LOCAL, 0); }
		public RowFormatContext rowFormat() {
			return getRuleContext(RowFormatContext.class,0);
		}
		public CreateFileFormatContext createFileFormat() {
			return getRuleContext(CreateFileFormatContext.class,0);
		}
		public InsertOverwriteHiveDirContext(InsertIntoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterInsertOverwriteHiveDir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitInsertOverwriteHiveDir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitInsertOverwriteHiveDir(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertOverwriteDirContext extends InsertIntoContext {
		public Token path;
		public TablePropertyListContext options;
		public TerminalNode INSERT() { return getToken(PstlSqlBaseParser.INSERT, 0); }
		public TerminalNode OVERWRITE() { return getToken(PstlSqlBaseParser.OVERWRITE, 0); }
		public TerminalNode DIRECTORY() { return getToken(PstlSqlBaseParser.DIRECTORY, 0); }
		public TableProviderContext tableProvider() {
			return getRuleContext(TableProviderContext.class,0);
		}
		public TerminalNode LOCAL() { return getToken(PstlSqlBaseParser.LOCAL, 0); }
		public TerminalNode OPTIONS() { return getToken(PstlSqlBaseParser.OPTIONS, 0); }
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public InsertOverwriteDirContext(InsertIntoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterInsertOverwriteDir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitInsertOverwriteDir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitInsertOverwriteDir(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertOverwriteTableContext extends InsertIntoContext {
		public TerminalNode INSERT() { return getToken(PstlSqlBaseParser.INSERT, 0); }
		public TerminalNode OVERWRITE() { return getToken(PstlSqlBaseParser.OVERWRITE, 0); }
		public TerminalNode TABLE() { return getToken(PstlSqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public TerminalNode IF() { return getToken(PstlSqlBaseParser.IF, 0); }
		public TerminalNode NOT() { return getToken(PstlSqlBaseParser.NOT, 0); }
		public TerminalNode EXISTS() { return getToken(PstlSqlBaseParser.EXISTS, 0); }
		public InsertOverwriteTableContext(InsertIntoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterInsertOverwriteTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitInsertOverwriteTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitInsertOverwriteTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertIntoTableContext extends InsertIntoContext {
		public TerminalNode INSERT() { return getToken(PstlSqlBaseParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(PstlSqlBaseParser.INTO, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TerminalNode TABLE() { return getToken(PstlSqlBaseParser.TABLE, 0); }
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public InsertIntoTableContext(InsertIntoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterInsertIntoTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitInsertIntoTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitInsertIntoTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertIntoContext insertInto() throws RecognitionException {
		InsertIntoContext _localctx = new InsertIntoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_insertInto);
		int _la;
		try {
			setState(564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new InsertOverwriteTableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(516);
				match(INSERT);
				setState(517);
				match(OVERWRITE);
				setState(518);
				match(TABLE);
				setState(519);
				tableIdentifier();
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(520);
					partitionSpec();
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IF) {
						{
						setState(521);
						match(IF);
						setState(522);
						match(NOT);
						setState(523);
						match(EXISTS);
						}
					}

					}
				}

				}
				break;
			case 2:
				_localctx = new InsertIntoTableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
				match(INSERT);
				setState(529);
				match(INTO);
				setState(531);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(530);
					match(TABLE);
					}
					break;
				}
				setState(533);
				tableIdentifier();
				setState(535);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARTITION) {
					{
					setState(534);
					partitionSpec();
					}
				}

				}
				break;
			case 3:
				_localctx = new InsertOverwriteHiveDirContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(537);
				match(INSERT);
				setState(538);
				match(OVERWRITE);
				setState(540);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(539);
					match(LOCAL);
					}
				}

				setState(542);
				match(DIRECTORY);
				setState(543);
				((InsertOverwriteHiveDirContext)_localctx).path = match(STRING);
				setState(545);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW) {
					{
					setState(544);
					rowFormat();
					}
				}

				setState(548);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STORED) {
					{
					setState(547);
					createFileFormat();
					}
				}

				}
				break;
			case 4:
				_localctx = new InsertOverwriteDirContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(550);
				match(INSERT);
				setState(551);
				match(OVERWRITE);
				setState(553);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LOCAL) {
					{
					setState(552);
					match(LOCAL);
					}
				}

				setState(555);
				match(DIRECTORY);
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(556);
					((InsertOverwriteDirContext)_localctx).path = match(STRING);
					}
				}

				setState(559);
				tableProvider();
				setState(562);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPTIONS) {
					{
					setState(560);
					match(OPTIONS);
					setState(561);
					((InsertOverwriteDirContext)_localctx).options = tablePropertyList();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionSpecLocationContext extends ParserRuleContext {
		public PartitionSpecContext partitionSpec() {
			return getRuleContext(PartitionSpecContext.class,0);
		}
		public LocationSpecContext locationSpec() {
			return getRuleContext(LocationSpecContext.class,0);
		}
		public PartitionSpecLocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionSpecLocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterPartitionSpecLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitPartitionSpecLocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitPartitionSpecLocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionSpecLocationContext partitionSpecLocation() throws RecognitionException {
		PartitionSpecLocationContext _localctx = new PartitionSpecLocationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_partitionSpecLocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			partitionSpec();
			setState(568);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCATION) {
				{
				setState(567);
				locationSpec();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionSpecContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(PstlSqlBaseParser.PARTITION, 0); }
		public List<PartitionValContext> partitionVal() {
			return getRuleContexts(PartitionValContext.class);
		}
		public PartitionValContext partitionVal(int i) {
			return getRuleContext(PartitionValContext.class,i);
		}
		public PartitionSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterPartitionSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitPartitionSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitPartitionSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionSpecContext partitionSpec() throws RecognitionException {
		PartitionSpecContext _localctx = new PartitionSpecContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_partitionSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(PARTITION);
			setState(571);
			match(T__0);
			setState(572);
			partitionVal();
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(573);
				match(T__2);
				setState(574);
				partitionVal();
				}
				}
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(580);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PartitionValContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQ() { return getToken(PstlSqlBaseParser.EQ, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public PartitionValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterPartitionVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitPartitionVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitPartitionVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PartitionValContext partitionVal() throws RecognitionException {
		PartitionValContext _localctx = new PartitionValContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_partitionVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			identifier();
			setState(585);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(583);
				match(EQ);
				setState(584);
				constant();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescribeFuncNameContext extends ParserRuleContext {
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ArithmeticOperatorContext arithmeticOperator() {
			return getRuleContext(ArithmeticOperatorContext.class,0);
		}
		public PredicateOperatorContext predicateOperator() {
			return getRuleContext(PredicateOperatorContext.class,0);
		}
		public DescribeFuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_describeFuncName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterDescribeFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitDescribeFuncName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitDescribeFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescribeFuncNameContext describeFuncName() throws RecognitionException {
		DescribeFuncNameContext _localctx = new DescribeFuncNameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_describeFuncName);
		try {
			setState(592);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(587);
				qualifiedName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(588);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(589);
				comparisonOperator();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(590);
				arithmeticOperator();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(591);
				predicateOperator();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescribeColNameContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> nameParts = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public DescribeColNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_describeColName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterDescribeColName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitDescribeColName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitDescribeColName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescribeColNameContext describeColName() throws RecognitionException {
		DescribeColNameContext _localctx = new DescribeColNameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_describeColName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			((DescribeColNameContext)_localctx).identifier = identifier();
			((DescribeColNameContext)_localctx).nameParts.add(((DescribeColNameContext)_localctx).identifier);
			setState(599);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(595);
				match(T__3);
				setState(596);
				((DescribeColNameContext)_localctx).identifier = identifier();
				((DescribeColNameContext)_localctx).nameParts.add(((DescribeColNameContext)_localctx).identifier);
				}
				}
				setState(601);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtesContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(PstlSqlBaseParser.WITH, 0); }
		public List<NamedQueryContext> namedQuery() {
			return getRuleContexts(NamedQueryContext.class);
		}
		public NamedQueryContext namedQuery(int i) {
			return getRuleContext(NamedQueryContext.class,i);
		}
		public CtesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterCtes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitCtes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitCtes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CtesContext ctes() throws RecognitionException {
		CtesContext _localctx = new CtesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_ctes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			match(WITH);
			setState(603);
			namedQuery();
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(604);
				match(T__2);
				setState(605);
				namedQuery();
				}
				}
				setState(610);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedQueryContext extends ParserRuleContext {
		public IdentifierContext name;
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public NamedQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterNamedQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitNamedQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitNamedQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedQueryContext namedQuery() throws RecognitionException {
		NamedQueryContext _localctx = new NamedQueryContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_namedQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			((NamedQueryContext)_localctx).name = identifier();
			setState(613);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(612);
				match(AS);
				}
			}

			setState(615);
			match(T__0);
			setState(616);
			query();
			setState(617);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableProviderContext extends ParserRuleContext {
		public TerminalNode USING() { return getToken(PstlSqlBaseParser.USING, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TableProviderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableProvider; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTableProvider(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTableProvider(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTableProvider(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableProviderContext tableProvider() throws RecognitionException {
		TableProviderContext _localctx = new TableProviderContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_tableProvider);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(USING);
			setState(620);
			qualifiedName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyListContext extends ParserRuleContext {
		public List<TablePropertyContext> tableProperty() {
			return getRuleContexts(TablePropertyContext.class);
		}
		public TablePropertyContext tableProperty(int i) {
			return getRuleContext(TablePropertyContext.class,i);
		}
		public TablePropertyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTablePropertyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTablePropertyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTablePropertyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyListContext tablePropertyList() throws RecognitionException {
		TablePropertyListContext _localctx = new TablePropertyListContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_tablePropertyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(622);
			match(T__0);
			setState(623);
			tableProperty();
			setState(628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(624);
				match(T__2);
				setState(625);
				tableProperty();
				}
				}
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(631);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyContext extends ParserRuleContext {
		public TablePropertyKeyContext key;
		public TablePropertyValueContext value;
		public TablePropertyKeyContext tablePropertyKey() {
			return getRuleContext(TablePropertyKeyContext.class,0);
		}
		public TablePropertyValueContext tablePropertyValue() {
			return getRuleContext(TablePropertyValueContext.class,0);
		}
		public TerminalNode EQ() { return getToken(PstlSqlBaseParser.EQ, 0); }
		public TablePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTableProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTableProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTableProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyContext tableProperty() throws RecognitionException {
		TablePropertyContext _localctx = new TablePropertyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_tableProperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			((TablePropertyContext)_localctx).key = tablePropertyKey();
			setState(638);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRUE || _la==FALSE || _la==EQ || ((((_la - 262)) & ~0x3f) == 0 && ((1L << (_la - 262)) & ((1L << (STRING - 262)) | (1L << (INTEGER_VALUE - 262)) | (1L << (DECIMAL_VALUE - 262)))) != 0)) {
				{
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQ) {
					{
					setState(634);
					match(EQ);
					}
				}

				setState(637);
				((TablePropertyContext)_localctx).value = tablePropertyValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyKeyContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public TablePropertyKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTablePropertyKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTablePropertyKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTablePropertyKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyKeyContext tablePropertyKey() throws RecognitionException {
		TablePropertyKeyContext _localctx = new TablePropertyKeyContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_tablePropertyKey);
		int _la;
		try {
			setState(649);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
			case SELECT:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case JOIN:
			case CROSS:
			case OUTER:
			case INNER:
			case LEFT:
			case SEMI:
			case RIGHT:
			case FULL:
			case NATURAL:
			case ON:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case DIRECTORY:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case UNION:
			case EXCEPT:
			case SETMINUS:
			case INTERSECT:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case BOTH:
			case LEADING:
			case TRAILING:
			case IF:
			case POSITION:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case ANTI:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(640);
				identifier();
				setState(645);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(641);
					match(T__3);
					setState(642);
					identifier();
					}
					}
					setState(647);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(648);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TablePropertyValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(PstlSqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(PstlSqlBaseParser.DECIMAL_VALUE, 0); }
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public TablePropertyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tablePropertyValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTablePropertyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTablePropertyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTablePropertyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TablePropertyValueContext tablePropertyValue() throws RecognitionException {
		TablePropertyValueContext _localctx = new TablePropertyValueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_tablePropertyValue);
		try {
			setState(655);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(651);
				match(INTEGER_VALUE);
				}
				break;
			case DECIMAL_VALUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(652);
				match(DECIMAL_VALUE);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(653);
				booleanValue();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(654);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantListContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public ConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitConstantList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitConstantList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantListContext constantList() throws RecognitionException {
		ConstantListContext _localctx = new ConstantListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_constantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			match(T__0);
			setState(658);
			constant();
			setState(663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(659);
				match(T__2);
				setState(660);
				constant();
				}
				}
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(666);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NestedConstantListContext extends ParserRuleContext {
		public List<ConstantListContext> constantList() {
			return getRuleContexts(ConstantListContext.class);
		}
		public ConstantListContext constantList(int i) {
			return getRuleContext(ConstantListContext.class,i);
		}
		public NestedConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedConstantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterNestedConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitNestedConstantList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitNestedConstantList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestedConstantListContext nestedConstantList() throws RecognitionException {
		NestedConstantListContext _localctx = new NestedConstantListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_nestedConstantList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668);
			match(T__0);
			setState(669);
			constantList();
			setState(674);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(670);
				match(T__2);
				setState(671);
				constantList();
				}
				}
				setState(676);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(677);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateFileFormatContext extends ParserRuleContext {
		public TerminalNode STORED() { return getToken(PstlSqlBaseParser.STORED, 0); }
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public FileFormatContext fileFormat() {
			return getRuleContext(FileFormatContext.class,0);
		}
		public TerminalNode BY() { return getToken(PstlSqlBaseParser.BY, 0); }
		public StorageHandlerContext storageHandler() {
			return getRuleContext(StorageHandlerContext.class,0);
		}
		public CreateFileFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createFileFormat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterCreateFileFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitCreateFileFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitCreateFileFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateFileFormatContext createFileFormat() throws RecognitionException {
		CreateFileFormatContext _localctx = new CreateFileFormatContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_createFileFormat);
		try {
			setState(685);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				match(STORED);
				setState(680);
				match(AS);
				setState(681);
				fileFormat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(682);
				match(STORED);
				setState(683);
				match(BY);
				setState(684);
				storageHandler();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FileFormatContext extends ParserRuleContext {
		public FileFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileFormat; }
	 
		public FileFormatContext() { }
		public void copyFrom(FileFormatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableFileFormatContext extends FileFormatContext {
		public Token inFmt;
		public Token outFmt;
		public TerminalNode INPUTFORMAT() { return getToken(PstlSqlBaseParser.INPUTFORMAT, 0); }
		public TerminalNode OUTPUTFORMAT() { return getToken(PstlSqlBaseParser.OUTPUTFORMAT, 0); }
		public List<TerminalNode> STRING() { return getTokens(PstlSqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PstlSqlBaseParser.STRING, i);
		}
		public TableFileFormatContext(FileFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTableFileFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTableFileFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTableFileFormat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GenericFileFormatContext extends FileFormatContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public GenericFileFormatContext(FileFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterGenericFileFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitGenericFileFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitGenericFileFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileFormatContext fileFormat() throws RecognitionException {
		FileFormatContext _localctx = new FileFormatContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_fileFormat);
		try {
			setState(692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new TableFileFormatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				match(INPUTFORMAT);
				setState(688);
				((TableFileFormatContext)_localctx).inFmt = match(STRING);
				setState(689);
				match(OUTPUTFORMAT);
				setState(690);
				((TableFileFormatContext)_localctx).outFmt = match(STRING);
				}
				break;
			case 2:
				_localctx = new GenericFileFormatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(691);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StorageHandlerContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public TerminalNode WITH() { return getToken(PstlSqlBaseParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(PstlSqlBaseParser.SERDEPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public StorageHandlerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storageHandler; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterStorageHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitStorageHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitStorageHandler(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StorageHandlerContext storageHandler() throws RecognitionException {
		StorageHandlerContext _localctx = new StorageHandlerContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_storageHandler);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			match(STRING);
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WITH) {
				{
				setState(695);
				match(WITH);
				setState(696);
				match(SERDEPROPERTIES);
				setState(697);
				tablePropertyList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResourceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitResource(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_resource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			identifier();
			setState(701);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryNoWithContext extends ParserRuleContext {
		public QueryNoWithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryNoWith; }
	 
		public QueryNoWithContext() { }
		public void copyFrom(QueryNoWithContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleInsertQueryContext extends QueryNoWithContext {
		public QueryTermContext queryTerm() {
			return getRuleContext(QueryTermContext.class,0);
		}
		public QueryOrganizationContext queryOrganization() {
			return getRuleContext(QueryOrganizationContext.class,0);
		}
		public InsertIntoContext insertInto() {
			return getRuleContext(InsertIntoContext.class,0);
		}
		public SingleInsertQueryContext(QueryNoWithContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSingleInsertQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSingleInsertQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSingleInsertQuery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultiInsertQueryContext extends QueryNoWithContext {
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public List<MultiInsertQueryBodyContext> multiInsertQueryBody() {
			return getRuleContexts(MultiInsertQueryBodyContext.class);
		}
		public MultiInsertQueryBodyContext multiInsertQueryBody(int i) {
			return getRuleContext(MultiInsertQueryBodyContext.class,i);
		}
		public MultiInsertQueryContext(QueryNoWithContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterMultiInsertQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitMultiInsertQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitMultiInsertQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryNoWithContext queryNoWith() throws RecognitionException {
		QueryNoWithContext _localctx = new QueryNoWithContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_queryNoWith);
		int _la;
		try {
			setState(715);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				_localctx = new SingleInsertQueryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(704);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INSERT) {
					{
					setState(703);
					insertInto();
					}
				}

				setState(706);
				queryTerm(0);
				setState(707);
				queryOrganization();
				}
				break;
			case 2:
				_localctx = new MultiInsertQueryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(709);
				fromClause();
				setState(711); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(710);
					multiInsertQueryBody();
					}
					}
					setState(713); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FROM || _la==SELECT || _la==INSERT || _la==MAP || _la==REDUCE );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryOrganizationContext extends ParserRuleContext {
		public SortItemContext sortItem;
		public List<SortItemContext> order = new ArrayList<SortItemContext>();
		public ExpressionContext expression;
		public List<ExpressionContext> clusterBy = new ArrayList<ExpressionContext>();
		public List<ExpressionContext> distributeBy = new ArrayList<ExpressionContext>();
		public List<SortItemContext> sort = new ArrayList<SortItemContext>();
		public ExpressionContext limit;
		public TerminalNode ORDER() { return getToken(PstlSqlBaseParser.ORDER, 0); }
		public List<TerminalNode> BY() { return getTokens(PstlSqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(PstlSqlBaseParser.BY, i);
		}
		public TerminalNode CLUSTER() { return getToken(PstlSqlBaseParser.CLUSTER, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(PstlSqlBaseParser.DISTRIBUTE, 0); }
		public TerminalNode SORT() { return getToken(PstlSqlBaseParser.SORT, 0); }
		public WindowsContext windows() {
			return getRuleContext(WindowsContext.class,0);
		}
		public TerminalNode LIMIT() { return getToken(PstlSqlBaseParser.LIMIT, 0); }
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ALL() { return getToken(PstlSqlBaseParser.ALL, 0); }
		public QueryOrganizationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryOrganization; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterQueryOrganization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitQueryOrganization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitQueryOrganization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryOrganizationContext queryOrganization() throws RecognitionException {
		QueryOrganizationContext _localctx = new QueryOrganizationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_queryOrganization);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(727);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ORDER) {
				{
				setState(717);
				match(ORDER);
				setState(718);
				match(BY);
				setState(719);
				((QueryOrganizationContext)_localctx).sortItem = sortItem();
				((QueryOrganizationContext)_localctx).order.add(((QueryOrganizationContext)_localctx).sortItem);
				setState(724);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(720);
					match(T__2);
					setState(721);
					((QueryOrganizationContext)_localctx).sortItem = sortItem();
					((QueryOrganizationContext)_localctx).order.add(((QueryOrganizationContext)_localctx).sortItem);
					}
					}
					setState(726);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(739);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLUSTER) {
				{
				setState(729);
				match(CLUSTER);
				setState(730);
				match(BY);
				setState(731);
				((QueryOrganizationContext)_localctx).expression = expression();
				((QueryOrganizationContext)_localctx).clusterBy.add(((QueryOrganizationContext)_localctx).expression);
				setState(736);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(732);
					match(T__2);
					setState(733);
					((QueryOrganizationContext)_localctx).expression = expression();
					((QueryOrganizationContext)_localctx).clusterBy.add(((QueryOrganizationContext)_localctx).expression);
					}
					}
					setState(738);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DISTRIBUTE) {
				{
				setState(741);
				match(DISTRIBUTE);
				setState(742);
				match(BY);
				setState(743);
				((QueryOrganizationContext)_localctx).expression = expression();
				((QueryOrganizationContext)_localctx).distributeBy.add(((QueryOrganizationContext)_localctx).expression);
				setState(748);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(744);
					match(T__2);
					setState(745);
					((QueryOrganizationContext)_localctx).expression = expression();
					((QueryOrganizationContext)_localctx).distributeBy.add(((QueryOrganizationContext)_localctx).expression);
					}
					}
					setState(750);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SORT) {
				{
				setState(753);
				match(SORT);
				setState(754);
				match(BY);
				setState(755);
				((QueryOrganizationContext)_localctx).sortItem = sortItem();
				((QueryOrganizationContext)_localctx).sort.add(((QueryOrganizationContext)_localctx).sortItem);
				setState(760);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(756);
					match(T__2);
					setState(757);
					((QueryOrganizationContext)_localctx).sortItem = sortItem();
					((QueryOrganizationContext)_localctx).sort.add(((QueryOrganizationContext)_localctx).sortItem);
					}
					}
					setState(762);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(766);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WINDOW) {
				{
				setState(765);
				windows();
				}
			}

			setState(773);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LIMIT) {
				{
				setState(768);
				match(LIMIT);
				setState(771);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
				case 1:
					{
					setState(769);
					match(ALL);
					}
					break;
				case 2:
					{
					setState(770);
					((QueryOrganizationContext)_localctx).limit = expression();
					}
					break;
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiInsertQueryBodyContext extends ParserRuleContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryOrganizationContext queryOrganization() {
			return getRuleContext(QueryOrganizationContext.class,0);
		}
		public InsertIntoContext insertInto() {
			return getRuleContext(InsertIntoContext.class,0);
		}
		public MultiInsertQueryBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiInsertQueryBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterMultiInsertQueryBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitMultiInsertQueryBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitMultiInsertQueryBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiInsertQueryBodyContext multiInsertQueryBody() throws RecognitionException {
		MultiInsertQueryBodyContext _localctx = new MultiInsertQueryBodyContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_multiInsertQueryBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INSERT) {
				{
				setState(775);
				insertInto();
				}
			}

			setState(778);
			querySpecification();
			setState(779);
			queryOrganization();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryTermContext extends ParserRuleContext {
		public QueryTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryTerm; }
	 
		public QueryTermContext() { }
		public void copyFrom(QueryTermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QueryTermDefaultContext extends QueryTermContext {
		public QueryPrimaryContext queryPrimary() {
			return getRuleContext(QueryPrimaryContext.class,0);
		}
		public QueryTermDefaultContext(QueryTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterQueryTermDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitQueryTermDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitQueryTermDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SetOperationContext extends QueryTermContext {
		public QueryTermContext left;
		public Token operator;
		public QueryTermContext right;
		public List<QueryTermContext> queryTerm() {
			return getRuleContexts(QueryTermContext.class);
		}
		public QueryTermContext queryTerm(int i) {
			return getRuleContext(QueryTermContext.class,i);
		}
		public TerminalNode INTERSECT() { return getToken(PstlSqlBaseParser.INTERSECT, 0); }
		public TerminalNode UNION() { return getToken(PstlSqlBaseParser.UNION, 0); }
		public TerminalNode EXCEPT() { return getToken(PstlSqlBaseParser.EXCEPT, 0); }
		public TerminalNode SETMINUS() { return getToken(PstlSqlBaseParser.SETMINUS, 0); }
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public SetOperationContext(QueryTermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSetOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSetOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSetOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryTermContext queryTerm() throws RecognitionException {
		return queryTerm(0);
	}

	private QueryTermContext queryTerm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		QueryTermContext _localctx = new QueryTermContext(_ctx, _parentState);
		QueryTermContext _prevctx = _localctx;
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_queryTerm, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new QueryTermDefaultContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(782);
			queryPrimary();
			}
			_ctx.stop = _input.LT(-1);
			setState(792);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SetOperationContext(new QueryTermContext(_parentctx, _parentState));
					((SetOperationContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_queryTerm);
					setState(784);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(785);
					((SetOperationContext)_localctx).operator = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 123)) & ~0x3f) == 0 && ((1L << (_la - 123)) & ((1L << (UNION - 123)) | (1L << (EXCEPT - 123)) | (1L << (SETMINUS - 123)) | (1L << (INTERSECT - 123)))) != 0)) ) {
						((SetOperationContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(787);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALL || _la==DISTINCT) {
						{
						setState(786);
						setQuantifier();
						}
					}

					setState(789);
					((SetOperationContext)_localctx).right = queryTerm(2);
					}
					} 
				}
				setState(794);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class QueryPrimaryContext extends ParserRuleContext {
		public QueryPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryPrimary; }
	 
		public QueryPrimaryContext() { }
		public void copyFrom(QueryPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SubqueryContext extends QueryPrimaryContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public SubqueryContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSubquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSubquery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSubquery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QueryPrimaryDefaultContext extends QueryPrimaryContext {
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public QueryPrimaryDefaultContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterQueryPrimaryDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitQueryPrimaryDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitQueryPrimaryDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineTableDefault1Context extends QueryPrimaryContext {
		public InlineTableContext inlineTable() {
			return getRuleContext(InlineTableContext.class,0);
		}
		public InlineTableDefault1Context(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterInlineTableDefault1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitInlineTableDefault1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitInlineTableDefault1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableContext extends QueryPrimaryContext {
		public TerminalNode TABLE() { return getToken(PstlSqlBaseParser.TABLE, 0); }
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TableContext(QueryPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryPrimaryContext queryPrimary() throws RecognitionException {
		QueryPrimaryContext _localctx = new QueryPrimaryContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_queryPrimary);
		try {
			setState(803);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
			case SELECT:
			case MAP:
			case REDUCE:
				_localctx = new QueryPrimaryDefaultContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(795);
				querySpecification();
				}
				break;
			case TABLE:
				_localctx = new TableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(796);
				match(TABLE);
				setState(797);
				tableIdentifier();
				}
				break;
			case VALUES:
				_localctx = new InlineTableDefault1Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(798);
				inlineTable();
				}
				break;
			case T__0:
				_localctx = new SubqueryContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(799);
				match(T__0);
				setState(800);
				queryNoWith();
				setState(801);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SortItemContext extends ParserRuleContext {
		public Token ordering;
		public Token nullOrder;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NULLS() { return getToken(PstlSqlBaseParser.NULLS, 0); }
		public TerminalNode ASC() { return getToken(PstlSqlBaseParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(PstlSqlBaseParser.DESC, 0); }
		public TerminalNode LAST() { return getToken(PstlSqlBaseParser.LAST, 0); }
		public TerminalNode FIRST() { return getToken(PstlSqlBaseParser.FIRST, 0); }
		public SortItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSortItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSortItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSortItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortItemContext sortItem() throws RecognitionException {
		SortItemContext _localctx = new SortItemContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_sortItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			expression();
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(806);
				((SortItemContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((SortItemContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(811);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLS) {
				{
				setState(809);
				match(NULLS);
				setState(810);
				((SortItemContext)_localctx).nullOrder = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FIRST || _la==LAST) ) {
					((SortItemContext)_localctx).nullOrder = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuerySpecificationContext extends ParserRuleContext {
		public Token kind;
		public RowFormatContext inRowFormat;
		public Token recordWriter;
		public Token script;
		public RowFormatContext outRowFormat;
		public Token recordReader;
		public BooleanExpressionContext where;
		public HintContext hint;
		public List<HintContext> hints = new ArrayList<HintContext>();
		public BooleanExpressionContext having;
		public TerminalNode USING() { return getToken(PstlSqlBaseParser.USING, 0); }
		public List<TerminalNode> STRING() { return getTokens(PstlSqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PstlSqlBaseParser.STRING, i);
		}
		public TerminalNode RECORDWRITER() { return getToken(PstlSqlBaseParser.RECORDWRITER, 0); }
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public TerminalNode RECORDREADER() { return getToken(PstlSqlBaseParser.RECORDREADER, 0); }
		public FromClauseContext fromClause() {
			return getRuleContext(FromClauseContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(PstlSqlBaseParser.WHERE, 0); }
		public TerminalNode SELECT() { return getToken(PstlSqlBaseParser.SELECT, 0); }
		public NamedExpressionSeqContext namedExpressionSeq() {
			return getRuleContext(NamedExpressionSeqContext.class,0);
		}
		public List<RowFormatContext> rowFormat() {
			return getRuleContexts(RowFormatContext.class);
		}
		public RowFormatContext rowFormat(int i) {
			return getRuleContext(RowFormatContext.class,i);
		}
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode TRANSFORM() { return getToken(PstlSqlBaseParser.TRANSFORM, 0); }
		public TerminalNode MAP() { return getToken(PstlSqlBaseParser.MAP, 0); }
		public TerminalNode REDUCE() { return getToken(PstlSqlBaseParser.REDUCE, 0); }
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public ColTypeListContext colTypeList() {
			return getRuleContext(ColTypeListContext.class,0);
		}
		public List<LateralViewContext> lateralView() {
			return getRuleContexts(LateralViewContext.class);
		}
		public LateralViewContext lateralView(int i) {
			return getRuleContext(LateralViewContext.class,i);
		}
		public AggregationContext aggregation() {
			return getRuleContext(AggregationContext.class,0);
		}
		public TerminalNode HAVING() { return getToken(PstlSqlBaseParser.HAVING, 0); }
		public WindowsContext windows() {
			return getRuleContext(WindowsContext.class,0);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public List<HintContext> hint() {
			return getRuleContexts(HintContext.class);
		}
		public HintContext hint(int i) {
			return getRuleContext(HintContext.class,i);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterQuerySpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitQuerySpecification(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitQuerySpecification(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_querySpecification);
		int _la;
		try {
			int _alt;
			setState(906);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				{
				setState(823);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
					{
					setState(813);
					match(SELECT);
					setState(814);
					((QuerySpecificationContext)_localctx).kind = match(TRANSFORM);
					setState(815);
					match(T__0);
					setState(816);
					namedExpressionSeq();
					setState(817);
					match(T__1);
					}
					break;
				case MAP:
					{
					setState(819);
					((QuerySpecificationContext)_localctx).kind = match(MAP);
					setState(820);
					namedExpressionSeq();
					}
					break;
				case REDUCE:
					{
					setState(821);
					((QuerySpecificationContext)_localctx).kind = match(REDUCE);
					setState(822);
					namedExpressionSeq();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(826);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ROW) {
					{
					setState(825);
					((QuerySpecificationContext)_localctx).inRowFormat = rowFormat();
					}
				}

				setState(830);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RECORDWRITER) {
					{
					setState(828);
					match(RECORDWRITER);
					setState(829);
					((QuerySpecificationContext)_localctx).recordWriter = match(STRING);
					}
				}

				setState(832);
				match(USING);
				setState(833);
				((QuerySpecificationContext)_localctx).script = match(STRING);
				setState(846);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					setState(834);
					match(AS);
					setState(844);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
					case 1:
						{
						setState(835);
						identifierSeq();
						}
						break;
					case 2:
						{
						setState(836);
						colTypeList();
						}
						break;
					case 3:
						{
						{
						setState(837);
						match(T__0);
						setState(840);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
						case 1:
							{
							setState(838);
							identifierSeq();
							}
							break;
						case 2:
							{
							setState(839);
							colTypeList();
							}
							break;
						}
						setState(842);
						match(T__1);
						}
						}
						break;
					}
					}
					break;
				}
				setState(849);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
				case 1:
					{
					setState(848);
					((QuerySpecificationContext)_localctx).outRowFormat = rowFormat();
					}
					break;
				}
				setState(853);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(851);
					match(RECORDREADER);
					setState(852);
					((QuerySpecificationContext)_localctx).recordReader = match(STRING);
					}
					break;
				}
				setState(856);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(855);
					fromClause();
					}
					break;
				}
				setState(860);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(858);
					match(WHERE);
					setState(859);
					((QuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(884);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SELECT:
					{
					setState(862);
					((QuerySpecificationContext)_localctx).kind = match(SELECT);
					setState(866);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(863);
						((QuerySpecificationContext)_localctx).hint = hint();
						((QuerySpecificationContext)_localctx).hints.add(((QuerySpecificationContext)_localctx).hint);
						}
						}
						setState(868);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(870);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
					case 1:
						{
						setState(869);
						setQuantifier();
						}
						break;
					}
					setState(872);
					namedExpressionSeq();
					setState(874);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
					case 1:
						{
						setState(873);
						fromClause();
						}
						break;
					}
					}
					break;
				case FROM:
					{
					setState(876);
					fromClause();
					setState(882);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
					case 1:
						{
						setState(877);
						((QuerySpecificationContext)_localctx).kind = match(SELECT);
						setState(879);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,86,_ctx) ) {
						case 1:
							{
							setState(878);
							setQuantifier();
							}
							break;
						}
						setState(881);
						namedExpressionSeq();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(889);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(886);
						lateralView();
						}
						} 
					}
					setState(891);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				}
				setState(894);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,90,_ctx) ) {
				case 1:
					{
					setState(892);
					match(WHERE);
					setState(893);
					((QuerySpecificationContext)_localctx).where = booleanExpression(0);
					}
					break;
				}
				setState(897);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
				case 1:
					{
					setState(896);
					aggregation();
					}
					break;
				}
				setState(901);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
				case 1:
					{
					setState(899);
					match(HAVING);
					setState(900);
					((QuerySpecificationContext)_localctx).having = booleanExpression(0);
					}
					break;
				}
				setState(904);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(903);
					windows();
					}
					break;
				}
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HintContext extends ParserRuleContext {
		public HintStatementContext hintStatement;
		public List<HintStatementContext> hintStatements = new ArrayList<HintStatementContext>();
		public List<HintStatementContext> hintStatement() {
			return getRuleContexts(HintStatementContext.class);
		}
		public HintStatementContext hintStatement(int i) {
			return getRuleContext(HintStatementContext.class,i);
		}
		public HintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterHint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitHint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitHint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HintContext hint() throws RecognitionException {
		HintContext _localctx = new HintContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_hint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			match(T__4);
			setState(909);
			((HintContext)_localctx).hintStatement = hintStatement();
			((HintContext)_localctx).hintStatements.add(((HintContext)_localctx).hintStatement);
			setState(916);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << FROM) | (1L << SELECT) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NULLS - 64)) | (1L << (ASC - 64)) | (1L << (DESC - 64)) | (1L << (FOR - 64)) | (1L << (INTERVAL - 64)) | (1L << (CASE - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (JOIN - 64)) | (1L << (CROSS - 64)) | (1L << (OUTER - 64)) | (1L << (INNER - 64)) | (1L << (LEFT - 64)) | (1L << (SEMI - 64)) | (1L << (RIGHT - 64)) | (1L << (FULL - 64)) | (1L << (NATURAL - 64)) | (1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (DIRECTORY - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (TABLESAMPLE - 128)) | (1L << (STRATIFY - 128)) | (1L << (ALTER - 128)) | (1L << (RENAME - 128)) | (1L << (ARRAY - 128)) | (1L << (MAP - 128)) | (1L << (STRUCT - 128)) | (1L << (COMMENT - 128)) | (1L << (SET - 128)) | (1L << (RESET - 128)) | (1L << (DATA - 128)) | (1L << (START - 128)) | (1L << (TRANSACTION - 128)) | (1L << (COMMIT - 128)) | (1L << (ROLLBACK - 128)) | (1L << (MACRO - 128)) | (1L << (IGNORE - 128)) | (1L << (BOTH - 128)) | (1L << (LEADING - 128)) | (1L << (TRAILING - 128)) | (1L << (IF - 128)) | (1L << (POSITION - 128)) | (1L << (DIV - 128)) | (1L << (PERCENTLIT - 128)) | (1L << (BUCKET - 128)) | (1L << (OUT - 128)) | (1L << (OF - 128)) | (1L << (SORT - 128)) | (1L << (CLUSTER - 128)) | (1L << (DISTRIBUTE - 128)) | (1L << (OVERWRITE - 128)) | (1L << (TRANSFORM - 128)) | (1L << (REDUCE - 128)) | (1L << (SERDE - 128)) | (1L << (SERDEPROPERTIES - 128)) | (1L << (RECORDREADER - 128)) | (1L << (RECORDWRITER - 128)) | (1L << (DELIMITED - 128)) | (1L << (FIELDS - 128)) | (1L << (TERMINATED - 128)) | (1L << (COLLECTION - 128)) | (1L << (ITEMS - 128)) | (1L << (KEYS - 128)) | (1L << (ESCAPED - 128)) | (1L << (LINES - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (SEPARATED - 192)) | (1L << (FUNCTION - 192)) | (1L << (EXTENDED - 192)) | (1L << (REFRESH - 192)) | (1L << (CLEAR - 192)) | (1L << (CACHE - 192)) | (1L << (UNCACHE - 192)) | (1L << (LAZY - 192)) | (1L << (FORMATTED - 192)) | (1L << (GLOBAL - 192)) | (1L << (TEMPORARY - 192)) | (1L << (OPTIONS - 192)) | (1L << (UNSET - 192)) | (1L << (TBLPROPERTIES - 192)) | (1L << (DBPROPERTIES - 192)) | (1L << (BUCKETS - 192)) | (1L << (SKEWED - 192)) | (1L << (STORED - 192)) | (1L << (DIRECTORIES - 192)) | (1L << (LOCATION - 192)) | (1L << (EXCHANGE - 192)) | (1L << (ARCHIVE - 192)) | (1L << (UNARCHIVE - 192)) | (1L << (FILEFORMAT - 192)) | (1L << (TOUCH - 192)) | (1L << (COMPACT - 192)) | (1L << (CONCATENATE - 192)) | (1L << (CHANGE - 192)) | (1L << (CASCADE - 192)) | (1L << (RESTRICT - 192)) | (1L << (CLUSTERED - 192)) | (1L << (SORTED - 192)) | (1L << (PURGE - 192)) | (1L << (INPUTFORMAT - 192)) | (1L << (OUTPUTFORMAT - 192)) | (1L << (DATABASE - 192)) | (1L << (DATABASES - 192)) | (1L << (DFS - 192)) | (1L << (TRUNCATE - 192)) | (1L << (ANALYZE - 192)) | (1L << (COMPUTE - 192)) | (1L << (LIST - 192)) | (1L << (STATISTICS - 192)) | (1L << (PARTITIONED - 192)) | (1L << (EXTERNAL - 192)) | (1L << (DEFINED - 192)) | (1L << (REVOKE - 192)) | (1L << (GRANT - 192)) | (1L << (LOCK - 192)) | (1L << (UNLOCK - 192)) | (1L << (MSCK - 192)) | (1L << (REPAIR - 192)) | (1L << (RECOVER - 192)) | (1L << (EXPORT - 192)) | (1L << (IMPORT - 192)) | (1L << (LOAD - 192)) | (1L << (ROLE - 192)) | (1L << (ROLES - 192)) | (1L << (COMPACTIONS - 192)) | (1L << (PRINCIPALS - 192)) | (1L << (TRANSACTIONS - 192)) | (1L << (INDEX - 192)) | (1L << (INDEXES - 192)) | (1L << (LOCKS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (OPTION - 256)) | (1L << (ANTI - 256)) | (1L << (LOCAL - 256)) | (1L << (INPATH - 256)) | (1L << (CURRENT_DATE - 256)) | (1L << (CURRENT_TIMESTAMP - 256)) | (1L << (IDENTIFIER - 256)) | (1L << (BACKQUOTED_IDENTIFIER - 256)))) != 0)) {
				{
				{
				setState(911);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(910);
					match(T__2);
					}
				}

				setState(913);
				((HintContext)_localctx).hintStatement = hintStatement();
				((HintContext)_localctx).hintStatements.add(((HintContext)_localctx).hintStatement);
				}
				}
				setState(918);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(919);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HintStatementContext extends ParserRuleContext {
		public IdentifierContext hintName;
		public PrimaryExpressionContext primaryExpression;
		public List<PrimaryExpressionContext> parameters = new ArrayList<PrimaryExpressionContext>();
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public HintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hintStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterHintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitHintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitHintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HintStatementContext hintStatement() throws RecognitionException {
		HintStatementContext _localctx = new HintStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_hintStatement);
		int _la;
		try {
			setState(934);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(921);
				((HintStatementContext)_localctx).hintName = identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(922);
				((HintStatementContext)_localctx).hintName = identifier();
				setState(923);
				match(T__0);
				setState(924);
				((HintStatementContext)_localctx).primaryExpression = primaryExpression(0);
				((HintStatementContext)_localctx).parameters.add(((HintStatementContext)_localctx).primaryExpression);
				setState(929);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(925);
					match(T__2);
					setState(926);
					((HintStatementContext)_localctx).primaryExpression = primaryExpression(0);
					((HintStatementContext)_localctx).parameters.add(((HintStatementContext)_localctx).primaryExpression);
					}
					}
					setState(931);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(932);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(PstlSqlBaseParser.FROM, 0); }
		public List<RelationContext> relation() {
			return getRuleContexts(RelationContext.class);
		}
		public RelationContext relation(int i) {
			return getRuleContext(RelationContext.class,i);
		}
		public List<LateralViewContext> lateralView() {
			return getRuleContexts(LateralViewContext.class);
		}
		public LateralViewContext lateralView(int i) {
			return getRuleContext(LateralViewContext.class,i);
		}
		public FromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitFromClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitFromClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromClauseContext fromClause() throws RecognitionException {
		FromClauseContext _localctx = new FromClauseContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_fromClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			match(FROM);
			setState(937);
			relation();
			setState(942);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(938);
					match(T__2);
					setState(939);
					relation();
					}
					} 
				}
				setState(944);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,99,_ctx);
			}
			setState(948);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(945);
					lateralView();
					}
					} 
				}
				setState(950);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,100,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AggregationContext extends ParserRuleContext {
		public ExpressionContext expression;
		public List<ExpressionContext> groupingExpressions = new ArrayList<ExpressionContext>();
		public Token kind;
		public TerminalNode GROUP() { return getToken(PstlSqlBaseParser.GROUP, 0); }
		public TerminalNode BY() { return getToken(PstlSqlBaseParser.BY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode WITH() { return getToken(PstlSqlBaseParser.WITH, 0); }
		public TerminalNode SETS() { return getToken(PstlSqlBaseParser.SETS, 0); }
		public List<GroupingSetContext> groupingSet() {
			return getRuleContexts(GroupingSetContext.class);
		}
		public GroupingSetContext groupingSet(int i) {
			return getRuleContext(GroupingSetContext.class,i);
		}
		public TerminalNode ROLLUP() { return getToken(PstlSqlBaseParser.ROLLUP, 0); }
		public TerminalNode CUBE() { return getToken(PstlSqlBaseParser.CUBE, 0); }
		public TerminalNode GROUPING() { return getToken(PstlSqlBaseParser.GROUPING, 0); }
		public AggregationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterAggregation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitAggregation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitAggregation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregationContext aggregation() throws RecognitionException {
		AggregationContext _localctx = new AggregationContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_aggregation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(951);
			match(GROUP);
			setState(952);
			match(BY);
			setState(953);
			((AggregationContext)_localctx).expression = expression();
			((AggregationContext)_localctx).groupingExpressions.add(((AggregationContext)_localctx).expression);
			setState(958);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(954);
					match(T__2);
					setState(955);
					((AggregationContext)_localctx).expression = expression();
					((AggregationContext)_localctx).groupingExpressions.add(((AggregationContext)_localctx).expression);
					}
					} 
				}
				setState(960);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			}
			setState(978);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(961);
				match(WITH);
				setState(962);
				((AggregationContext)_localctx).kind = match(ROLLUP);
				}
				break;
			case 2:
				{
				setState(963);
				match(WITH);
				setState(964);
				((AggregationContext)_localctx).kind = match(CUBE);
				}
				break;
			case 3:
				{
				setState(965);
				((AggregationContext)_localctx).kind = match(GROUPING);
				setState(966);
				match(SETS);
				setState(967);
				match(T__0);
				setState(968);
				groupingSet();
				setState(973);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(969);
					match(T__2);
					setState(970);
					groupingSet();
					}
					}
					setState(975);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(976);
				match(T__1);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GroupingSetContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GroupingSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupingSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterGroupingSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitGroupingSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitGroupingSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupingSetContext groupingSet() throws RecognitionException {
		GroupingSetContext _localctx = new GroupingSetContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_groupingSet);
		int _la;
		try {
			setState(993);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(980);
				match(T__0);
				setState(989);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FROM) | (1L << SELECT) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NULLS - 64)) | (1L << (ASC - 64)) | (1L << (DESC - 64)) | (1L << (FOR - 64)) | (1L << (INTERVAL - 64)) | (1L << (CASE - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (JOIN - 64)) | (1L << (CROSS - 64)) | (1L << (OUTER - 64)) | (1L << (INNER - 64)) | (1L << (LEFT - 64)) | (1L << (SEMI - 64)) | (1L << (RIGHT - 64)) | (1L << (FULL - 64)) | (1L << (NATURAL - 64)) | (1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (DIRECTORY - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (TABLESAMPLE - 128)) | (1L << (STRATIFY - 128)) | (1L << (ALTER - 128)) | (1L << (RENAME - 128)) | (1L << (ARRAY - 128)) | (1L << (MAP - 128)) | (1L << (STRUCT - 128)) | (1L << (COMMENT - 128)) | (1L << (SET - 128)) | (1L << (RESET - 128)) | (1L << (DATA - 128)) | (1L << (START - 128)) | (1L << (TRANSACTION - 128)) | (1L << (COMMIT - 128)) | (1L << (ROLLBACK - 128)) | (1L << (MACRO - 128)) | (1L << (IGNORE - 128)) | (1L << (BOTH - 128)) | (1L << (LEADING - 128)) | (1L << (TRAILING - 128)) | (1L << (IF - 128)) | (1L << (POSITION - 128)) | (1L << (PLUS - 128)) | (1L << (MINUS - 128)) | (1L << (ASTERISK - 128)) | (1L << (DIV - 128)) | (1L << (TILDE - 128)) | (1L << (PERCENTLIT - 128)) | (1L << (BUCKET - 128)) | (1L << (OUT - 128)) | (1L << (OF - 128)) | (1L << (SORT - 128)) | (1L << (CLUSTER - 128)) | (1L << (DISTRIBUTE - 128)) | (1L << (OVERWRITE - 128)) | (1L << (TRANSFORM - 128)) | (1L << (REDUCE - 128)) | (1L << (SERDE - 128)) | (1L << (SERDEPROPERTIES - 128)) | (1L << (RECORDREADER - 128)) | (1L << (RECORDWRITER - 128)) | (1L << (DELIMITED - 128)) | (1L << (FIELDS - 128)) | (1L << (TERMINATED - 128)) | (1L << (COLLECTION - 128)) | (1L << (ITEMS - 128)) | (1L << (KEYS - 128)) | (1L << (ESCAPED - 128)) | (1L << (LINES - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (SEPARATED - 192)) | (1L << (FUNCTION - 192)) | (1L << (EXTENDED - 192)) | (1L << (REFRESH - 192)) | (1L << (CLEAR - 192)) | (1L << (CACHE - 192)) | (1L << (UNCACHE - 192)) | (1L << (LAZY - 192)) | (1L << (FORMATTED - 192)) | (1L << (GLOBAL - 192)) | (1L << (TEMPORARY - 192)) | (1L << (OPTIONS - 192)) | (1L << (UNSET - 192)) | (1L << (TBLPROPERTIES - 192)) | (1L << (DBPROPERTIES - 192)) | (1L << (BUCKETS - 192)) | (1L << (SKEWED - 192)) | (1L << (STORED - 192)) | (1L << (DIRECTORIES - 192)) | (1L << (LOCATION - 192)) | (1L << (EXCHANGE - 192)) | (1L << (ARCHIVE - 192)) | (1L << (UNARCHIVE - 192)) | (1L << (FILEFORMAT - 192)) | (1L << (TOUCH - 192)) | (1L << (COMPACT - 192)) | (1L << (CONCATENATE - 192)) | (1L << (CHANGE - 192)) | (1L << (CASCADE - 192)) | (1L << (RESTRICT - 192)) | (1L << (CLUSTERED - 192)) | (1L << (SORTED - 192)) | (1L << (PURGE - 192)) | (1L << (INPUTFORMAT - 192)) | (1L << (OUTPUTFORMAT - 192)) | (1L << (DATABASE - 192)) | (1L << (DATABASES - 192)) | (1L << (DFS - 192)) | (1L << (TRUNCATE - 192)) | (1L << (ANALYZE - 192)) | (1L << (COMPUTE - 192)) | (1L << (LIST - 192)) | (1L << (STATISTICS - 192)) | (1L << (PARTITIONED - 192)) | (1L << (EXTERNAL - 192)) | (1L << (DEFINED - 192)) | (1L << (REVOKE - 192)) | (1L << (GRANT - 192)) | (1L << (LOCK - 192)) | (1L << (UNLOCK - 192)) | (1L << (MSCK - 192)) | (1L << (REPAIR - 192)) | (1L << (RECOVER - 192)) | (1L << (EXPORT - 192)) | (1L << (IMPORT - 192)) | (1L << (LOAD - 192)) | (1L << (ROLE - 192)) | (1L << (ROLES - 192)) | (1L << (COMPACTIONS - 192)) | (1L << (PRINCIPALS - 192)) | (1L << (TRANSACTIONS - 192)) | (1L << (INDEX - 192)) | (1L << (INDEXES - 192)) | (1L << (LOCKS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (OPTION - 256)) | (1L << (ANTI - 256)) | (1L << (LOCAL - 256)) | (1L << (INPATH - 256)) | (1L << (CURRENT_DATE - 256)) | (1L << (CURRENT_TIMESTAMP - 256)) | (1L << (STRING - 256)) | (1L << (BIGINT_LITERAL - 256)) | (1L << (SMALLINT_LITERAL - 256)) | (1L << (TINYINT_LITERAL - 256)) | (1L << (INTEGER_VALUE - 256)) | (1L << (DECIMAL_VALUE - 256)) | (1L << (DOUBLE_LITERAL - 256)) | (1L << (BIGDECIMAL_LITERAL - 256)) | (1L << (IDENTIFIER - 256)) | (1L << (BACKQUOTED_IDENTIFIER - 256)))) != 0)) {
					{
					setState(981);
					expression();
					setState(986);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(982);
						match(T__2);
						setState(983);
						expression();
						}
						}
						setState(988);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(991);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(992);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LateralViewContext extends ParserRuleContext {
		public IdentifierContext tblName;
		public IdentifierContext identifier;
		public List<IdentifierContext> colName = new ArrayList<IdentifierContext>();
		public TerminalNode LATERAL() { return getToken(PstlSqlBaseParser.LATERAL, 0); }
		public TerminalNode VIEW() { return getToken(PstlSqlBaseParser.VIEW, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OUTER() { return getToken(PstlSqlBaseParser.OUTER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public LateralViewContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lateralView; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterLateralView(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitLateralView(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitLateralView(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LateralViewContext lateralView() throws RecognitionException {
		LateralViewContext _localctx = new LateralViewContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_lateralView);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(995);
			match(LATERAL);
			setState(996);
			match(VIEW);
			setState(998);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,107,_ctx) ) {
			case 1:
				{
				setState(997);
				match(OUTER);
				}
				break;
			}
			setState(1000);
			qualifiedName();
			setState(1001);
			match(T__0);
			setState(1010);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FROM) | (1L << SELECT) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NULLS - 64)) | (1L << (ASC - 64)) | (1L << (DESC - 64)) | (1L << (FOR - 64)) | (1L << (INTERVAL - 64)) | (1L << (CASE - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (JOIN - 64)) | (1L << (CROSS - 64)) | (1L << (OUTER - 64)) | (1L << (INNER - 64)) | (1L << (LEFT - 64)) | (1L << (SEMI - 64)) | (1L << (RIGHT - 64)) | (1L << (FULL - 64)) | (1L << (NATURAL - 64)) | (1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (DIRECTORY - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (TABLESAMPLE - 128)) | (1L << (STRATIFY - 128)) | (1L << (ALTER - 128)) | (1L << (RENAME - 128)) | (1L << (ARRAY - 128)) | (1L << (MAP - 128)) | (1L << (STRUCT - 128)) | (1L << (COMMENT - 128)) | (1L << (SET - 128)) | (1L << (RESET - 128)) | (1L << (DATA - 128)) | (1L << (START - 128)) | (1L << (TRANSACTION - 128)) | (1L << (COMMIT - 128)) | (1L << (ROLLBACK - 128)) | (1L << (MACRO - 128)) | (1L << (IGNORE - 128)) | (1L << (BOTH - 128)) | (1L << (LEADING - 128)) | (1L << (TRAILING - 128)) | (1L << (IF - 128)) | (1L << (POSITION - 128)) | (1L << (PLUS - 128)) | (1L << (MINUS - 128)) | (1L << (ASTERISK - 128)) | (1L << (DIV - 128)) | (1L << (TILDE - 128)) | (1L << (PERCENTLIT - 128)) | (1L << (BUCKET - 128)) | (1L << (OUT - 128)) | (1L << (OF - 128)) | (1L << (SORT - 128)) | (1L << (CLUSTER - 128)) | (1L << (DISTRIBUTE - 128)) | (1L << (OVERWRITE - 128)) | (1L << (TRANSFORM - 128)) | (1L << (REDUCE - 128)) | (1L << (SERDE - 128)) | (1L << (SERDEPROPERTIES - 128)) | (1L << (RECORDREADER - 128)) | (1L << (RECORDWRITER - 128)) | (1L << (DELIMITED - 128)) | (1L << (FIELDS - 128)) | (1L << (TERMINATED - 128)) | (1L << (COLLECTION - 128)) | (1L << (ITEMS - 128)) | (1L << (KEYS - 128)) | (1L << (ESCAPED - 128)) | (1L << (LINES - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (SEPARATED - 192)) | (1L << (FUNCTION - 192)) | (1L << (EXTENDED - 192)) | (1L << (REFRESH - 192)) | (1L << (CLEAR - 192)) | (1L << (CACHE - 192)) | (1L << (UNCACHE - 192)) | (1L << (LAZY - 192)) | (1L << (FORMATTED - 192)) | (1L << (GLOBAL - 192)) | (1L << (TEMPORARY - 192)) | (1L << (OPTIONS - 192)) | (1L << (UNSET - 192)) | (1L << (TBLPROPERTIES - 192)) | (1L << (DBPROPERTIES - 192)) | (1L << (BUCKETS - 192)) | (1L << (SKEWED - 192)) | (1L << (STORED - 192)) | (1L << (DIRECTORIES - 192)) | (1L << (LOCATION - 192)) | (1L << (EXCHANGE - 192)) | (1L << (ARCHIVE - 192)) | (1L << (UNARCHIVE - 192)) | (1L << (FILEFORMAT - 192)) | (1L << (TOUCH - 192)) | (1L << (COMPACT - 192)) | (1L << (CONCATENATE - 192)) | (1L << (CHANGE - 192)) | (1L << (CASCADE - 192)) | (1L << (RESTRICT - 192)) | (1L << (CLUSTERED - 192)) | (1L << (SORTED - 192)) | (1L << (PURGE - 192)) | (1L << (INPUTFORMAT - 192)) | (1L << (OUTPUTFORMAT - 192)) | (1L << (DATABASE - 192)) | (1L << (DATABASES - 192)) | (1L << (DFS - 192)) | (1L << (TRUNCATE - 192)) | (1L << (ANALYZE - 192)) | (1L << (COMPUTE - 192)) | (1L << (LIST - 192)) | (1L << (STATISTICS - 192)) | (1L << (PARTITIONED - 192)) | (1L << (EXTERNAL - 192)) | (1L << (DEFINED - 192)) | (1L << (REVOKE - 192)) | (1L << (GRANT - 192)) | (1L << (LOCK - 192)) | (1L << (UNLOCK - 192)) | (1L << (MSCK - 192)) | (1L << (REPAIR - 192)) | (1L << (RECOVER - 192)) | (1L << (EXPORT - 192)) | (1L << (IMPORT - 192)) | (1L << (LOAD - 192)) | (1L << (ROLE - 192)) | (1L << (ROLES - 192)) | (1L << (COMPACTIONS - 192)) | (1L << (PRINCIPALS - 192)) | (1L << (TRANSACTIONS - 192)) | (1L << (INDEX - 192)) | (1L << (INDEXES - 192)) | (1L << (LOCKS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (OPTION - 256)) | (1L << (ANTI - 256)) | (1L << (LOCAL - 256)) | (1L << (INPATH - 256)) | (1L << (CURRENT_DATE - 256)) | (1L << (CURRENT_TIMESTAMP - 256)) | (1L << (STRING - 256)) | (1L << (BIGINT_LITERAL - 256)) | (1L << (SMALLINT_LITERAL - 256)) | (1L << (TINYINT_LITERAL - 256)) | (1L << (INTEGER_VALUE - 256)) | (1L << (DECIMAL_VALUE - 256)) | (1L << (DOUBLE_LITERAL - 256)) | (1L << (BIGDECIMAL_LITERAL - 256)) | (1L << (IDENTIFIER - 256)) | (1L << (BACKQUOTED_IDENTIFIER - 256)))) != 0)) {
				{
				setState(1002);
				expression();
				setState(1007);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1003);
					match(T__2);
					setState(1004);
					expression();
					}
					}
					setState(1009);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1012);
			match(T__1);
			setState(1013);
			((LateralViewContext)_localctx).tblName = identifier();
			setState(1025);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				{
				setState(1015);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
				case 1:
					{
					setState(1014);
					match(AS);
					}
					break;
				}
				setState(1017);
				((LateralViewContext)_localctx).identifier = identifier();
				((LateralViewContext)_localctx).colName.add(((LateralViewContext)_localctx).identifier);
				setState(1022);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1018);
						match(T__2);
						setState(1019);
						((LateralViewContext)_localctx).identifier = identifier();
						((LateralViewContext)_localctx).colName.add(((LateralViewContext)_localctx).identifier);
						}
						} 
					}
					setState(1024);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetQuantifierContext extends ParserRuleContext {
		public TerminalNode DISTINCT() { return getToken(PstlSqlBaseParser.DISTINCT, 0); }
		public TerminalNode ALL() { return getToken(PstlSqlBaseParser.ALL, 0); }
		public SetQuantifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setQuantifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSetQuantifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSetQuantifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSetQuantifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetQuantifierContext setQuantifier() throws RecognitionException {
		SetQuantifierContext _localctx = new SetQuantifierContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_setQuantifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1027);
			_la = _input.LA(1);
			if ( !(_la==ALL || _la==DISTINCT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationContext extends ParserRuleContext {
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public List<JoinRelationContext> joinRelation() {
			return getRuleContexts(JoinRelationContext.class);
		}
		public JoinRelationContext joinRelation(int i) {
			return getRuleContext(JoinRelationContext.class,i);
		}
		public RelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationContext relation() throws RecognitionException {
		RelationContext _localctx = new RelationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_relation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1029);
			relationPrimary();
			setState(1033);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1030);
					joinRelation();
					}
					} 
				}
				setState(1035);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinRelationContext extends ParserRuleContext {
		public RelationPrimaryContext right;
		public TerminalNode JOIN() { return getToken(PstlSqlBaseParser.JOIN, 0); }
		public RelationPrimaryContext relationPrimary() {
			return getRuleContext(RelationPrimaryContext.class,0);
		}
		public JoinTypeContext joinType() {
			return getRuleContext(JoinTypeContext.class,0);
		}
		public JoinCriteriaContext joinCriteria() {
			return getRuleContext(JoinCriteriaContext.class,0);
		}
		public TerminalNode NATURAL() { return getToken(PstlSqlBaseParser.NATURAL, 0); }
		public JoinRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterJoinRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitJoinRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitJoinRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinRelationContext joinRelation() throws RecognitionException {
		JoinRelationContext _localctx = new JoinRelationContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_joinRelation);
		try {
			setState(1047);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JOIN:
			case CROSS:
			case INNER:
			case LEFT:
			case RIGHT:
			case FULL:
			case ANTI:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1036);
				joinType();
				}
				setState(1037);
				match(JOIN);
				setState(1038);
				((JoinRelationContext)_localctx).right = relationPrimary();
				setState(1040);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
				case 1:
					{
					setState(1039);
					joinCriteria();
					}
					break;
				}
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(1042);
				match(NATURAL);
				setState(1043);
				joinType();
				setState(1044);
				match(JOIN);
				setState(1045);
				((JoinRelationContext)_localctx).right = relationPrimary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinTypeContext extends ParserRuleContext {
		public TerminalNode INNER() { return getToken(PstlSqlBaseParser.INNER, 0); }
		public TerminalNode CROSS() { return getToken(PstlSqlBaseParser.CROSS, 0); }
		public TerminalNode LEFT() { return getToken(PstlSqlBaseParser.LEFT, 0); }
		public TerminalNode OUTER() { return getToken(PstlSqlBaseParser.OUTER, 0); }
		public TerminalNode SEMI() { return getToken(PstlSqlBaseParser.SEMI, 0); }
		public TerminalNode RIGHT() { return getToken(PstlSqlBaseParser.RIGHT, 0); }
		public TerminalNode FULL() { return getToken(PstlSqlBaseParser.FULL, 0); }
		public TerminalNode ANTI() { return getToken(PstlSqlBaseParser.ANTI, 0); }
		public JoinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterJoinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitJoinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitJoinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinTypeContext joinType() throws RecognitionException {
		JoinTypeContext _localctx = new JoinTypeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_joinType);
		int _la;
		try {
			setState(1071);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1050);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INNER) {
					{
					setState(1049);
					match(INNER);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1052);
				match(CROSS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1053);
				match(LEFT);
				setState(1055);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1054);
					match(OUTER);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1057);
				match(LEFT);
				setState(1058);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1059);
				match(RIGHT);
				setState(1061);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1060);
					match(OUTER);
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1063);
				match(FULL);
				setState(1065);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER) {
					{
					setState(1064);
					match(OUTER);
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1068);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT) {
					{
					setState(1067);
					match(LEFT);
					}
				}

				setState(1070);
				match(ANTI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinCriteriaContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(PstlSqlBaseParser.ON, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode USING() { return getToken(PstlSqlBaseParser.USING, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public JoinCriteriaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinCriteria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterJoinCriteria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitJoinCriteria(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitJoinCriteria(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinCriteriaContext joinCriteria() throws RecognitionException {
		JoinCriteriaContext _localctx = new JoinCriteriaContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_joinCriteria);
		int _la;
		try {
			setState(1087);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ON:
				enterOuterAlt(_localctx, 1);
				{
				setState(1073);
				match(ON);
				setState(1074);
				booleanExpression(0);
				}
				break;
			case USING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1075);
				match(USING);
				setState(1076);
				match(T__0);
				setState(1077);
				identifier();
				setState(1082);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1078);
					match(T__2);
					setState(1079);
					identifier();
					}
					}
					setState(1084);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1085);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SampleContext extends ParserRuleContext {
		public Token negativeSign;
		public Token percentage;
		public Token sampleType;
		public Token numerator;
		public Token denominator;
		public TerminalNode TABLESAMPLE() { return getToken(PstlSqlBaseParser.TABLESAMPLE, 0); }
		public TerminalNode BYTELENGTH_LITERAL() { return getToken(PstlSqlBaseParser.BYTELENGTH_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OUT() { return getToken(PstlSqlBaseParser.OUT, 0); }
		public TerminalNode OF() { return getToken(PstlSqlBaseParser.OF, 0); }
		public TerminalNode PERCENTLIT() { return getToken(PstlSqlBaseParser.PERCENTLIT, 0); }
		public TerminalNode ROWS() { return getToken(PstlSqlBaseParser.ROWS, 0); }
		public TerminalNode BUCKET() { return getToken(PstlSqlBaseParser.BUCKET, 0); }
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(PstlSqlBaseParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(PstlSqlBaseParser.INTEGER_VALUE, i);
		}
		public TerminalNode DECIMAL_VALUE() { return getToken(PstlSqlBaseParser.DECIMAL_VALUE, 0); }
		public TerminalNode ON() { return getToken(PstlSqlBaseParser.ON, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public SampleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sample; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSample(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSample(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSample(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SampleContext sample() throws RecognitionException {
		SampleContext _localctx = new SampleContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_sample);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1089);
			match(TABLESAMPLE);
			setState(1090);
			match(T__0);
			setState(1115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				{
				{
				setState(1092);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(1091);
					((SampleContext)_localctx).negativeSign = match(MINUS);
					}
				}

				setState(1094);
				((SampleContext)_localctx).percentage = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INTEGER_VALUE || _la==DECIMAL_VALUE) ) {
					((SampleContext)_localctx).percentage = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1095);
				((SampleContext)_localctx).sampleType = match(PERCENTLIT);
				}
				}
				break;
			case 2:
				{
				{
				setState(1096);
				expression();
				setState(1097);
				((SampleContext)_localctx).sampleType = match(ROWS);
				}
				}
				break;
			case 3:
				{
				setState(1099);
				((SampleContext)_localctx).sampleType = match(BYTELENGTH_LITERAL);
				}
				break;
			case 4:
				{
				{
				setState(1100);
				((SampleContext)_localctx).sampleType = match(BUCKET);
				setState(1101);
				((SampleContext)_localctx).numerator = match(INTEGER_VALUE);
				setState(1102);
				match(OUT);
				setState(1103);
				match(OF);
				setState(1104);
				((SampleContext)_localctx).denominator = match(INTEGER_VALUE);
				setState(1113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(1105);
					match(ON);
					setState(1111);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
					case 1:
						{
						setState(1106);
						identifier();
						}
						break;
					case 2:
						{
						setState(1107);
						qualifiedName();
						setState(1108);
						match(T__0);
						setState(1109);
						match(T__1);
						}
						break;
					}
					}
				}

				}
				}
				break;
			}
			setState(1117);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public IdentifierSeqContext identifierSeq() {
			return getRuleContext(IdentifierSeqContext.class,0);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_identifierList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119);
			match(T__0);
			setState(1120);
			identifierSeq();
			setState(1121);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierSeqContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IdentifierSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIdentifierSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIdentifierSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIdentifierSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierSeqContext identifierSeq() throws RecognitionException {
		IdentifierSeqContext _localctx = new IdentifierSeqContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_identifierSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1123);
			identifier();
			setState(1128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1124);
					match(T__2);
					setState(1125);
					identifier();
					}
					} 
				}
				setState(1130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,128,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderedIdentifierListContext extends ParserRuleContext {
		public List<OrderedIdentifierContext> orderedIdentifier() {
			return getRuleContexts(OrderedIdentifierContext.class);
		}
		public OrderedIdentifierContext orderedIdentifier(int i) {
			return getRuleContext(OrderedIdentifierContext.class,i);
		}
		public OrderedIdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderedIdentifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterOrderedIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitOrderedIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitOrderedIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderedIdentifierListContext orderedIdentifierList() throws RecognitionException {
		OrderedIdentifierListContext _localctx = new OrderedIdentifierListContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_orderedIdentifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1131);
			match(T__0);
			setState(1132);
			orderedIdentifier();
			setState(1137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1133);
				match(T__2);
				setState(1134);
				orderedIdentifier();
				}
				}
				setState(1139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1140);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OrderedIdentifierContext extends ParserRuleContext {
		public Token ordering;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASC() { return getToken(PstlSqlBaseParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(PstlSqlBaseParser.DESC, 0); }
		public OrderedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orderedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterOrderedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitOrderedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitOrderedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrderedIdentifierContext orderedIdentifier() throws RecognitionException {
		OrderedIdentifierContext _localctx = new OrderedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_orderedIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1142);
			identifier();
			setState(1144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASC || _la==DESC) {
				{
				setState(1143);
				((OrderedIdentifierContext)_localctx).ordering = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASC || _la==DESC) ) {
					((OrderedIdentifierContext)_localctx).ordering = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierCommentListContext extends ParserRuleContext {
		public List<IdentifierCommentContext> identifierComment() {
			return getRuleContexts(IdentifierCommentContext.class);
		}
		public IdentifierCommentContext identifierComment(int i) {
			return getRuleContext(IdentifierCommentContext.class,i);
		}
		public IdentifierCommentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierCommentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIdentifierCommentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIdentifierCommentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIdentifierCommentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierCommentListContext identifierCommentList() throws RecognitionException {
		IdentifierCommentListContext _localctx = new IdentifierCommentListContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_identifierCommentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1146);
			match(T__0);
			setState(1147);
			identifierComment();
			setState(1152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1148);
				match(T__2);
				setState(1149);
				identifierComment();
				}
				}
				setState(1154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1155);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierCommentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(PstlSqlBaseParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public IdentifierCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIdentifierComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIdentifierComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIdentifierComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierCommentContext identifierComment() throws RecognitionException {
		IdentifierCommentContext _localctx = new IdentifierCommentContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_identifierComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1157);
			identifier();
			setState(1160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(1158);
				match(COMMENT);
				setState(1159);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationPrimaryContext extends ParserRuleContext {
		public RelationPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationPrimary; }
	 
		public RelationPrimaryContext() { }
		public void copyFrom(RelationPrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TableValuedFunctionContext extends RelationPrimaryContext {
		public FunctionTableContext functionTable() {
			return getRuleContext(FunctionTableContext.class,0);
		}
		public TableValuedFunctionContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTableValuedFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTableValuedFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTableValuedFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InlineTableDefault2Context extends RelationPrimaryContext {
		public InlineTableContext inlineTable() {
			return getRuleContext(InlineTableContext.class,0);
		}
		public InlineTableDefault2Context(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterInlineTableDefault2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitInlineTableDefault2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitInlineTableDefault2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AliasedRelationContext extends RelationPrimaryContext {
		public RelationContext relation() {
			return getRuleContext(RelationContext.class,0);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public AliasedRelationContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterAliasedRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitAliasedRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitAliasedRelation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AliasedQueryContext extends RelationPrimaryContext {
		public QueryNoWithContext queryNoWith() {
			return getRuleContext(QueryNoWithContext.class,0);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public AliasedQueryContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterAliasedQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitAliasedQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitAliasedQuery(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableNameContext extends RelationPrimaryContext {
		public TableIdentifierContext tableIdentifier() {
			return getRuleContext(TableIdentifierContext.class,0);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public SampleContext sample() {
			return getRuleContext(SampleContext.class,0);
		}
		public TableNameContext(RelationPrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationPrimaryContext relationPrimary() throws RecognitionException {
		RelationPrimaryContext _localctx = new RelationPrimaryContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_relationPrimary);
		try {
			setState(1186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
			case 1:
				_localctx = new TableNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1162);
				tableIdentifier();
				setState(1164);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
				case 1:
					{
					setState(1163);
					sample();
					}
					break;
				}
				setState(1166);
				tableAlias();
				}
				break;
			case 2:
				_localctx = new AliasedQueryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1168);
				match(T__0);
				setState(1169);
				queryNoWith();
				setState(1170);
				match(T__1);
				setState(1172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,134,_ctx) ) {
				case 1:
					{
					setState(1171);
					sample();
					}
					break;
				}
				setState(1174);
				tableAlias();
				}
				break;
			case 3:
				_localctx = new AliasedRelationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1176);
				match(T__0);
				setState(1177);
				relation();
				setState(1178);
				match(T__1);
				setState(1180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
				case 1:
					{
					setState(1179);
					sample();
					}
					break;
				}
				setState(1182);
				tableAlias();
				}
				break;
			case 4:
				_localctx = new InlineTableDefault2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1184);
				inlineTable();
				}
				break;
			case 5:
				_localctx = new TableValuedFunctionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1185);
				functionTable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InlineTableContext extends ParserRuleContext {
		public TerminalNode VALUES() { return getToken(PstlSqlBaseParser.VALUES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public InlineTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterInlineTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitInlineTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitInlineTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InlineTableContext inlineTable() throws RecognitionException {
		InlineTableContext _localctx = new InlineTableContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_inlineTable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1188);
			match(VALUES);
			setState(1189);
			expression();
			setState(1194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1190);
					match(T__2);
					setState(1191);
					expression();
					}
					} 
				}
				setState(1196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,137,_ctx);
			}
			setState(1197);
			tableAlias();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionTableContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TableAliasContext tableAlias() {
			return getRuleContext(TableAliasContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterFunctionTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitFunctionTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitFunctionTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTableContext functionTable() throws RecognitionException {
		FunctionTableContext _localctx = new FunctionTableContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_functionTable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1199);
			identifier();
			setState(1200);
			match(T__0);
			setState(1209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FROM) | (1L << SELECT) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NULLS - 64)) | (1L << (ASC - 64)) | (1L << (DESC - 64)) | (1L << (FOR - 64)) | (1L << (INTERVAL - 64)) | (1L << (CASE - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (JOIN - 64)) | (1L << (CROSS - 64)) | (1L << (OUTER - 64)) | (1L << (INNER - 64)) | (1L << (LEFT - 64)) | (1L << (SEMI - 64)) | (1L << (RIGHT - 64)) | (1L << (FULL - 64)) | (1L << (NATURAL - 64)) | (1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (DIRECTORY - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (TABLESAMPLE - 128)) | (1L << (STRATIFY - 128)) | (1L << (ALTER - 128)) | (1L << (RENAME - 128)) | (1L << (ARRAY - 128)) | (1L << (MAP - 128)) | (1L << (STRUCT - 128)) | (1L << (COMMENT - 128)) | (1L << (SET - 128)) | (1L << (RESET - 128)) | (1L << (DATA - 128)) | (1L << (START - 128)) | (1L << (TRANSACTION - 128)) | (1L << (COMMIT - 128)) | (1L << (ROLLBACK - 128)) | (1L << (MACRO - 128)) | (1L << (IGNORE - 128)) | (1L << (BOTH - 128)) | (1L << (LEADING - 128)) | (1L << (TRAILING - 128)) | (1L << (IF - 128)) | (1L << (POSITION - 128)) | (1L << (PLUS - 128)) | (1L << (MINUS - 128)) | (1L << (ASTERISK - 128)) | (1L << (DIV - 128)) | (1L << (TILDE - 128)) | (1L << (PERCENTLIT - 128)) | (1L << (BUCKET - 128)) | (1L << (OUT - 128)) | (1L << (OF - 128)) | (1L << (SORT - 128)) | (1L << (CLUSTER - 128)) | (1L << (DISTRIBUTE - 128)) | (1L << (OVERWRITE - 128)) | (1L << (TRANSFORM - 128)) | (1L << (REDUCE - 128)) | (1L << (SERDE - 128)) | (1L << (SERDEPROPERTIES - 128)) | (1L << (RECORDREADER - 128)) | (1L << (RECORDWRITER - 128)) | (1L << (DELIMITED - 128)) | (1L << (FIELDS - 128)) | (1L << (TERMINATED - 128)) | (1L << (COLLECTION - 128)) | (1L << (ITEMS - 128)) | (1L << (KEYS - 128)) | (1L << (ESCAPED - 128)) | (1L << (LINES - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (SEPARATED - 192)) | (1L << (FUNCTION - 192)) | (1L << (EXTENDED - 192)) | (1L << (REFRESH - 192)) | (1L << (CLEAR - 192)) | (1L << (CACHE - 192)) | (1L << (UNCACHE - 192)) | (1L << (LAZY - 192)) | (1L << (FORMATTED - 192)) | (1L << (GLOBAL - 192)) | (1L << (TEMPORARY - 192)) | (1L << (OPTIONS - 192)) | (1L << (UNSET - 192)) | (1L << (TBLPROPERTIES - 192)) | (1L << (DBPROPERTIES - 192)) | (1L << (BUCKETS - 192)) | (1L << (SKEWED - 192)) | (1L << (STORED - 192)) | (1L << (DIRECTORIES - 192)) | (1L << (LOCATION - 192)) | (1L << (EXCHANGE - 192)) | (1L << (ARCHIVE - 192)) | (1L << (UNARCHIVE - 192)) | (1L << (FILEFORMAT - 192)) | (1L << (TOUCH - 192)) | (1L << (COMPACT - 192)) | (1L << (CONCATENATE - 192)) | (1L << (CHANGE - 192)) | (1L << (CASCADE - 192)) | (1L << (RESTRICT - 192)) | (1L << (CLUSTERED - 192)) | (1L << (SORTED - 192)) | (1L << (PURGE - 192)) | (1L << (INPUTFORMAT - 192)) | (1L << (OUTPUTFORMAT - 192)) | (1L << (DATABASE - 192)) | (1L << (DATABASES - 192)) | (1L << (DFS - 192)) | (1L << (TRUNCATE - 192)) | (1L << (ANALYZE - 192)) | (1L << (COMPUTE - 192)) | (1L << (LIST - 192)) | (1L << (STATISTICS - 192)) | (1L << (PARTITIONED - 192)) | (1L << (EXTERNAL - 192)) | (1L << (DEFINED - 192)) | (1L << (REVOKE - 192)) | (1L << (GRANT - 192)) | (1L << (LOCK - 192)) | (1L << (UNLOCK - 192)) | (1L << (MSCK - 192)) | (1L << (REPAIR - 192)) | (1L << (RECOVER - 192)) | (1L << (EXPORT - 192)) | (1L << (IMPORT - 192)) | (1L << (LOAD - 192)) | (1L << (ROLE - 192)) | (1L << (ROLES - 192)) | (1L << (COMPACTIONS - 192)) | (1L << (PRINCIPALS - 192)) | (1L << (TRANSACTIONS - 192)) | (1L << (INDEX - 192)) | (1L << (INDEXES - 192)) | (1L << (LOCKS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (OPTION - 256)) | (1L << (ANTI - 256)) | (1L << (LOCAL - 256)) | (1L << (INPATH - 256)) | (1L << (CURRENT_DATE - 256)) | (1L << (CURRENT_TIMESTAMP - 256)) | (1L << (STRING - 256)) | (1L << (BIGINT_LITERAL - 256)) | (1L << (SMALLINT_LITERAL - 256)) | (1L << (TINYINT_LITERAL - 256)) | (1L << (INTEGER_VALUE - 256)) | (1L << (DECIMAL_VALUE - 256)) | (1L << (DOUBLE_LITERAL - 256)) | (1L << (BIGDECIMAL_LITERAL - 256)) | (1L << (IDENTIFIER - 256)) | (1L << (BACKQUOTED_IDENTIFIER - 256)))) != 0)) {
				{
				setState(1201);
				expression();
				setState(1206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1202);
					match(T__2);
					setState(1203);
					expression();
					}
					}
					setState(1208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1211);
			match(T__1);
			setState(1212);
			tableAlias();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableAliasContext extends ParserRuleContext {
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TableAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTableAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTableAlias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTableAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableAliasContext tableAlias() throws RecognitionException {
		TableAliasContext _localctx = new TableAliasContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_tableAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
			case 1:
				{
				setState(1215);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
				case 1:
					{
					setState(1214);
					match(AS);
					}
					break;
				}
				setState(1217);
				strictIdentifier();
				setState(1219);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
				case 1:
					{
					setState(1218);
					identifierList();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowFormatContext extends ParserRuleContext {
		public RowFormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowFormat; }
	 
		public RowFormatContext() { }
		public void copyFrom(RowFormatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RowFormatSerdeContext extends RowFormatContext {
		public Token name;
		public TablePropertyListContext props;
		public TerminalNode ROW() { return getToken(PstlSqlBaseParser.ROW, 0); }
		public TerminalNode FORMAT() { return getToken(PstlSqlBaseParser.FORMAT, 0); }
		public TerminalNode SERDE() { return getToken(PstlSqlBaseParser.SERDE, 0); }
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public TerminalNode WITH() { return getToken(PstlSqlBaseParser.WITH, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(PstlSqlBaseParser.SERDEPROPERTIES, 0); }
		public TablePropertyListContext tablePropertyList() {
			return getRuleContext(TablePropertyListContext.class,0);
		}
		public RowFormatSerdeContext(RowFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterRowFormatSerde(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitRowFormatSerde(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitRowFormatSerde(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowFormatDelimitedContext extends RowFormatContext {
		public Token fieldsTerminatedBy;
		public Token escapedBy;
		public Token collectionItemsTerminatedBy;
		public Token keysTerminatedBy;
		public Token linesSeparatedBy;
		public Token nullDefinedAs;
		public TerminalNode ROW() { return getToken(PstlSqlBaseParser.ROW, 0); }
		public TerminalNode FORMAT() { return getToken(PstlSqlBaseParser.FORMAT, 0); }
		public TerminalNode DELIMITED() { return getToken(PstlSqlBaseParser.DELIMITED, 0); }
		public TerminalNode FIELDS() { return getToken(PstlSqlBaseParser.FIELDS, 0); }
		public List<TerminalNode> TERMINATED() { return getTokens(PstlSqlBaseParser.TERMINATED); }
		public TerminalNode TERMINATED(int i) {
			return getToken(PstlSqlBaseParser.TERMINATED, i);
		}
		public List<TerminalNode> BY() { return getTokens(PstlSqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(PstlSqlBaseParser.BY, i);
		}
		public TerminalNode COLLECTION() { return getToken(PstlSqlBaseParser.COLLECTION, 0); }
		public TerminalNode ITEMS() { return getToken(PstlSqlBaseParser.ITEMS, 0); }
		public TerminalNode MAP() { return getToken(PstlSqlBaseParser.MAP, 0); }
		public TerminalNode KEYS() { return getToken(PstlSqlBaseParser.KEYS, 0); }
		public TerminalNode LINES() { return getToken(PstlSqlBaseParser.LINES, 0); }
		public TerminalNode NULL() { return getToken(PstlSqlBaseParser.NULL, 0); }
		public TerminalNode DEFINED() { return getToken(PstlSqlBaseParser.DEFINED, 0); }
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public List<TerminalNode> STRING() { return getTokens(PstlSqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PstlSqlBaseParser.STRING, i);
		}
		public TerminalNode ESCAPED() { return getToken(PstlSqlBaseParser.ESCAPED, 0); }
		public RowFormatDelimitedContext(RowFormatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterRowFormatDelimited(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitRowFormatDelimited(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitRowFormatDelimited(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowFormatContext rowFormat() throws RecognitionException {
		RowFormatContext _localctx = new RowFormatContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_rowFormat);
		try {
			setState(1272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				_localctx = new RowFormatSerdeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1223);
				match(ROW);
				setState(1224);
				match(FORMAT);
				setState(1225);
				match(SERDE);
				setState(1226);
				((RowFormatSerdeContext)_localctx).name = match(STRING);
				setState(1230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
				case 1:
					{
					setState(1227);
					match(WITH);
					setState(1228);
					match(SERDEPROPERTIES);
					setState(1229);
					((RowFormatSerdeContext)_localctx).props = tablePropertyList();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new RowFormatDelimitedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1232);
				match(ROW);
				setState(1233);
				match(FORMAT);
				setState(1234);
				match(DELIMITED);
				setState(1244);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
				case 1:
					{
					setState(1235);
					match(FIELDS);
					setState(1236);
					match(TERMINATED);
					setState(1237);
					match(BY);
					setState(1238);
					((RowFormatDelimitedContext)_localctx).fieldsTerminatedBy = match(STRING);
					setState(1242);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
					case 1:
						{
						setState(1239);
						match(ESCAPED);
						setState(1240);
						match(BY);
						setState(1241);
						((RowFormatDelimitedContext)_localctx).escapedBy = match(STRING);
						}
						break;
					}
					}
					break;
				}
				setState(1251);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
				case 1:
					{
					setState(1246);
					match(COLLECTION);
					setState(1247);
					match(ITEMS);
					setState(1248);
					match(TERMINATED);
					setState(1249);
					match(BY);
					setState(1250);
					((RowFormatDelimitedContext)_localctx).collectionItemsTerminatedBy = match(STRING);
					}
					break;
				}
				setState(1258);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
				case 1:
					{
					setState(1253);
					match(MAP);
					setState(1254);
					match(KEYS);
					setState(1255);
					match(TERMINATED);
					setState(1256);
					match(BY);
					setState(1257);
					((RowFormatDelimitedContext)_localctx).keysTerminatedBy = match(STRING);
					}
					break;
				}
				setState(1264);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
				case 1:
					{
					setState(1260);
					match(LINES);
					setState(1261);
					match(TERMINATED);
					setState(1262);
					match(BY);
					setState(1263);
					((RowFormatDelimitedContext)_localctx).linesSeparatedBy = match(STRING);
					}
					break;
				}
				setState(1270);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
				case 1:
					{
					setState(1266);
					match(NULL);
					setState(1267);
					match(DEFINED);
					setState(1268);
					match(AS);
					setState(1269);
					((RowFormatDelimitedContext)_localctx).nullDefinedAs = match(STRING);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableIdentifierContext extends ParserRuleContext {
		public IdentifierContext db;
		public IdentifierContext table;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TableIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTableIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTableIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTableIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableIdentifierContext tableIdentifier() throws RecognitionException {
		TableIdentifierContext _localctx = new TableIdentifierContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_tableIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				{
				setState(1274);
				((TableIdentifierContext)_localctx).db = identifier();
				setState(1275);
				match(T__3);
				}
				break;
			}
			setState(1279);
			((TableIdentifierContext)_localctx).table = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionIdentifierContext extends ParserRuleContext {
		public IdentifierContext db;
		public IdentifierContext function;
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public FunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitFunctionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitFunctionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionIdentifierContext functionIdentifier() throws RecognitionException {
		FunctionIdentifierContext _localctx = new FunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_functionIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
			case 1:
				{
				setState(1281);
				((FunctionIdentifierContext)_localctx).db = identifier();
				setState(1282);
				match(T__3);
				}
				break;
			}
			setState(1286);
			((FunctionIdentifierContext)_localctx).function = identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public NamedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterNamedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitNamedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitNamedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedExpressionContext namedExpression() throws RecognitionException {
		NamedExpressionContext _localctx = new NamedExpressionContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_namedExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1288);
			expression();
			setState(1296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,155,_ctx) ) {
			case 1:
				{
				setState(1290);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
				case 1:
					{
					setState(1289);
					match(AS);
					}
					break;
				}
				setState(1294);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FROM:
				case SELECT:
				case ADD:
				case AS:
				case ALL:
				case DISTINCT:
				case WHERE:
				case GROUP:
				case BY:
				case GROUPING:
				case SETS:
				case CUBE:
				case ROLLUP:
				case ORDER:
				case HAVING:
				case LIMIT:
				case AT:
				case OR:
				case AND:
				case IN:
				case NOT:
				case NO:
				case EXISTS:
				case BETWEEN:
				case LIKE:
				case RLIKE:
				case IS:
				case NULL:
				case TRUE:
				case FALSE:
				case NULLS:
				case ASC:
				case DESC:
				case FOR:
				case INTERVAL:
				case CASE:
				case WHEN:
				case THEN:
				case ELSE:
				case END:
				case JOIN:
				case CROSS:
				case OUTER:
				case INNER:
				case LEFT:
				case SEMI:
				case RIGHT:
				case FULL:
				case NATURAL:
				case ON:
				case LATERAL:
				case WINDOW:
				case OVER:
				case PARTITION:
				case RANGE:
				case ROWS:
				case UNBOUNDED:
				case PRECEDING:
				case FOLLOWING:
				case CURRENT:
				case FIRST:
				case AFTER:
				case LAST:
				case ROW:
				case WITH:
				case VALUES:
				case CREATE:
				case TABLE:
				case DIRECTORY:
				case VIEW:
				case REPLACE:
				case INSERT:
				case DELETE:
				case INTO:
				case DESCRIBE:
				case EXPLAIN:
				case FORMAT:
				case LOGICAL:
				case CODEGEN:
				case COST:
				case CAST:
				case SHOW:
				case TABLES:
				case COLUMNS:
				case COLUMN:
				case USE:
				case PARTITIONS:
				case FUNCTIONS:
				case DROP:
				case UNION:
				case EXCEPT:
				case SETMINUS:
				case INTERSECT:
				case TO:
				case TABLESAMPLE:
				case STRATIFY:
				case ALTER:
				case RENAME:
				case ARRAY:
				case MAP:
				case STRUCT:
				case COMMENT:
				case SET:
				case RESET:
				case DATA:
				case START:
				case TRANSACTION:
				case COMMIT:
				case ROLLBACK:
				case MACRO:
				case IGNORE:
				case BOTH:
				case LEADING:
				case TRAILING:
				case IF:
				case POSITION:
				case DIV:
				case PERCENTLIT:
				case BUCKET:
				case OUT:
				case OF:
				case SORT:
				case CLUSTER:
				case DISTRIBUTE:
				case OVERWRITE:
				case TRANSFORM:
				case REDUCE:
				case SERDE:
				case SERDEPROPERTIES:
				case RECORDREADER:
				case RECORDWRITER:
				case DELIMITED:
				case FIELDS:
				case TERMINATED:
				case COLLECTION:
				case ITEMS:
				case KEYS:
				case ESCAPED:
				case LINES:
				case SEPARATED:
				case FUNCTION:
				case EXTENDED:
				case REFRESH:
				case CLEAR:
				case CACHE:
				case UNCACHE:
				case LAZY:
				case FORMATTED:
				case GLOBAL:
				case TEMPORARY:
				case OPTIONS:
				case UNSET:
				case TBLPROPERTIES:
				case DBPROPERTIES:
				case BUCKETS:
				case SKEWED:
				case STORED:
				case DIRECTORIES:
				case LOCATION:
				case EXCHANGE:
				case ARCHIVE:
				case UNARCHIVE:
				case FILEFORMAT:
				case TOUCH:
				case COMPACT:
				case CONCATENATE:
				case CHANGE:
				case CASCADE:
				case RESTRICT:
				case CLUSTERED:
				case SORTED:
				case PURGE:
				case INPUTFORMAT:
				case OUTPUTFORMAT:
				case DATABASE:
				case DATABASES:
				case DFS:
				case TRUNCATE:
				case ANALYZE:
				case COMPUTE:
				case LIST:
				case STATISTICS:
				case PARTITIONED:
				case EXTERNAL:
				case DEFINED:
				case REVOKE:
				case GRANT:
				case LOCK:
				case UNLOCK:
				case MSCK:
				case REPAIR:
				case RECOVER:
				case EXPORT:
				case IMPORT:
				case LOAD:
				case ROLE:
				case ROLES:
				case COMPACTIONS:
				case PRINCIPALS:
				case TRANSACTIONS:
				case INDEX:
				case INDEXES:
				case LOCKS:
				case OPTION:
				case ANTI:
				case LOCAL:
				case INPATH:
				case CURRENT_DATE:
				case CURRENT_TIMESTAMP:
				case IDENTIFIER:
				case BACKQUOTED_IDENTIFIER:
					{
					setState(1292);
					identifier();
					}
					break;
				case T__0:
					{
					setState(1293);
					identifierList();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedExpressionSeqContext extends ParserRuleContext {
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public NamedExpressionSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedExpressionSeq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterNamedExpressionSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitNamedExpressionSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitNamedExpressionSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedExpressionSeqContext namedExpressionSeq() throws RecognitionException {
		NamedExpressionSeqContext _localctx = new NamedExpressionSeqContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_namedExpressionSeq);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1298);
			namedExpression();
			setState(1303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1299);
					match(T__2);
					setState(1300);
					namedExpression();
					}
					} 
				}
				setState(1305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,156,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1306);
			booleanExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
	 
		public BooleanExpressionContext() { }
		public void copyFrom(BooleanExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicalNotContext extends BooleanExpressionContext {
		public TerminalNode NOT() { return getToken(PstlSqlBaseParser.NOT, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public LogicalNotContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterLogicalNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitLogicalNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitLogicalNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanDefaultContext extends BooleanExpressionContext {
		public PredicatedContext predicated() {
			return getRuleContext(PredicatedContext.class,0);
		}
		public BooleanDefaultContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterBooleanDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitBooleanDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitBooleanDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExistsContext extends BooleanExpressionContext {
		public TerminalNode EXISTS() { return getToken(PstlSqlBaseParser.EXISTS, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ExistsContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterExists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitExists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitExists(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicalBinaryContext extends BooleanExpressionContext {
		public BooleanExpressionContext left;
		public Token operator;
		public BooleanExpressionContext right;
		public List<BooleanExpressionContext> booleanExpression() {
			return getRuleContexts(BooleanExpressionContext.class);
		}
		public BooleanExpressionContext booleanExpression(int i) {
			return getRuleContext(BooleanExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PstlSqlBaseParser.AND, 0); }
		public TerminalNode OR() { return getToken(PstlSqlBaseParser.OR, 0); }
		public LogicalBinaryContext(BooleanExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterLogicalBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitLogicalBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitLogicalBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		return booleanExpression(0);
	}

	private BooleanExpressionContext booleanExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, _parentState);
		BooleanExpressionContext _prevctx = _localctx;
		int _startState = 148;
		enterRecursionRule(_localctx, 148, RULE_booleanExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				{
				_localctx = new LogicalNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1309);
				match(NOT);
				setState(1310);
				booleanExpression(5);
				}
				break;
			case 2:
				{
				_localctx = new ExistsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1311);
				match(EXISTS);
				setState(1312);
				match(T__0);
				setState(1313);
				query();
				setState(1314);
				match(T__1);
				}
				break;
			case 3:
				{
				_localctx = new BooleanDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1316);
				predicated();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1325);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(1319);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1320);
						((LogicalBinaryContext)_localctx).operator = match(AND);
						setState(1321);
						((LogicalBinaryContext)_localctx).right = booleanExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new LogicalBinaryContext(new BooleanExpressionContext(_parentctx, _parentState));
						((LogicalBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleanExpression);
						setState(1322);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1323);
						((LogicalBinaryContext)_localctx).operator = match(OR);
						setState(1324);
						((LogicalBinaryContext)_localctx).right = booleanExpression(2);
						}
						break;
					}
					} 
				}
				setState(1329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,159,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PredicatedContext extends ParserRuleContext {
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public PredicatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterPredicated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitPredicated(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitPredicated(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicatedContext predicated() throws RecognitionException {
		PredicatedContext _localctx = new PredicatedContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_predicated);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1330);
			valueExpression(0);
			setState(1332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,160,_ctx) ) {
			case 1:
				{
				setState(1331);
				predicate();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public Token kind;
		public ValueExpressionContext lower;
		public ValueExpressionContext upper;
		public ValueExpressionContext pattern;
		public ValueExpressionContext right;
		public TerminalNode AND() { return getToken(PstlSqlBaseParser.AND, 0); }
		public TerminalNode BETWEEN() { return getToken(PstlSqlBaseParser.BETWEEN, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(PstlSqlBaseParser.NOT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IN() { return getToken(PstlSqlBaseParser.IN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode RLIKE() { return getToken(PstlSqlBaseParser.RLIKE, 0); }
		public TerminalNode LIKE() { return getToken(PstlSqlBaseParser.LIKE, 0); }
		public TerminalNode IS() { return getToken(PstlSqlBaseParser.IS, 0); }
		public TerminalNode NULL() { return getToken(PstlSqlBaseParser.NULL, 0); }
		public TerminalNode FROM() { return getToken(PstlSqlBaseParser.FROM, 0); }
		public TerminalNode DISTINCT() { return getToken(PstlSqlBaseParser.DISTINCT, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_predicate);
		int _la;
		try {
			setState(1382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1334);
					match(NOT);
					}
				}

				setState(1337);
				((PredicateContext)_localctx).kind = match(BETWEEN);
				setState(1338);
				((PredicateContext)_localctx).lower = valueExpression(0);
				setState(1339);
				match(AND);
				setState(1340);
				((PredicateContext)_localctx).upper = valueExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1342);
					match(NOT);
					}
				}

				setState(1345);
				((PredicateContext)_localctx).kind = match(IN);
				setState(1346);
				match(T__0);
				setState(1347);
				expression();
				setState(1352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(1348);
					match(T__2);
					setState(1349);
					expression();
					}
					}
					setState(1354);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1355);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1357);
					match(NOT);
					}
				}

				setState(1360);
				((PredicateContext)_localctx).kind = match(IN);
				setState(1361);
				match(T__0);
				setState(1362);
				query();
				setState(1363);
				match(T__1);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1365);
					match(NOT);
					}
				}

				setState(1368);
				((PredicateContext)_localctx).kind = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==LIKE || _la==RLIKE) ) {
					((PredicateContext)_localctx).kind = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1369);
				((PredicateContext)_localctx).pattern = valueExpression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1370);
				match(IS);
				setState(1372);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1371);
					match(NOT);
					}
				}

				setState(1374);
				((PredicateContext)_localctx).kind = match(NULL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1375);
				match(IS);
				setState(1377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT) {
					{
					setState(1376);
					match(NOT);
					}
				}

				setState(1379);
				((PredicateContext)_localctx).kind = match(DISTINCT);
				setState(1380);
				match(FROM);
				setState(1381);
				((PredicateContext)_localctx).right = valueExpression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueExpressionContext extends ParserRuleContext {
		public ValueExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueExpression; }
	 
		public ValueExpressionContext() { }
		public void copyFrom(ValueExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueExpressionDefaultContext extends ValueExpressionContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionDefaultContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterValueExpressionDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitValueExpressionDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitValueExpressionDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public ValueExpressionContext right;
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public ComparisonContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticBinaryContext extends ValueExpressionContext {
		public ValueExpressionContext left;
		public Token operator;
		public ValueExpressionContext right;
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(PstlSqlBaseParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(PstlSqlBaseParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(PstlSqlBaseParser.PERCENT, 0); }
		public TerminalNode DIV() { return getToken(PstlSqlBaseParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(PstlSqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public TerminalNode CONCAT_PIPE() { return getToken(PstlSqlBaseParser.CONCAT_PIPE, 0); }
		public TerminalNode AMPERSAND() { return getToken(PstlSqlBaseParser.AMPERSAND, 0); }
		public TerminalNode HAT() { return getToken(PstlSqlBaseParser.HAT, 0); }
		public TerminalNode PIPE() { return getToken(PstlSqlBaseParser.PIPE, 0); }
		public ArithmeticBinaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterArithmeticBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitArithmeticBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitArithmeticBinary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArithmeticUnaryContext extends ValueExpressionContext {
		public Token operator;
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(PstlSqlBaseParser.PLUS, 0); }
		public TerminalNode TILDE() { return getToken(PstlSqlBaseParser.TILDE, 0); }
		public ArithmeticUnaryContext(ValueExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterArithmeticUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitArithmeticUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitArithmeticUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueExpressionContext valueExpression() throws RecognitionException {
		return valueExpression(0);
	}

	private ValueExpressionContext valueExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ValueExpressionContext _localctx = new ValueExpressionContext(_ctx, _parentState);
		ValueExpressionContext _prevctx = _localctx;
		int _startState = 154;
		enterRecursionRule(_localctx, 154, RULE_valueExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				{
				_localctx = new ValueExpressionDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1385);
				primaryExpression(0);
				}
				break;
			case 2:
				{
				_localctx = new ArithmeticUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1386);
				((ArithmeticUnaryContext)_localctx).operator = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 158)) & ~0x3f) == 0 && ((1L << (_la - 158)) & ((1L << (PLUS - 158)) | (1L << (MINUS - 158)) | (1L << (TILDE - 158)))) != 0)) ) {
					((ArithmeticUnaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1387);
				valueExpression(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1411);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1409);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1390);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1391);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 160)) & ~0x3f) == 0 && ((1L << (_la - 160)) & ((1L << (ASTERISK - 160)) | (1L << (SLASH - 160)) | (1L << (PERCENT - 160)) | (1L << (DIV - 160)))) != 0)) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1392);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(7);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1393);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1394);
						((ArithmeticBinaryContext)_localctx).operator = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 158)) & ~0x3f) == 0 && ((1L << (_la - 158)) & ((1L << (PLUS - 158)) | (1L << (MINUS - 158)) | (1L << (CONCAT_PIPE - 158)))) != 0)) ) {
							((ArithmeticBinaryContext)_localctx).operator = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1395);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(6);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1396);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1397);
						((ArithmeticBinaryContext)_localctx).operator = match(AMPERSAND);
						setState(1398);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(5);
						}
						break;
					case 4:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1399);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1400);
						((ArithmeticBinaryContext)_localctx).operator = match(HAT);
						setState(1401);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(4);
						}
						break;
					case 5:
						{
						_localctx = new ArithmeticBinaryContext(new ValueExpressionContext(_parentctx, _parentState));
						((ArithmeticBinaryContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1402);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1403);
						((ArithmeticBinaryContext)_localctx).operator = match(PIPE);
						setState(1404);
						((ArithmeticBinaryContext)_localctx).right = valueExpression(3);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonContext(new ValueExpressionContext(_parentctx, _parentState));
						((ComparisonContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_valueExpression);
						setState(1405);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1406);
						comparisonOperator();
						setState(1407);
						((ComparisonContext)_localctx).right = valueExpression(2);
						}
						break;
					}
					} 
				}
				setState(1413);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StructContext extends PrimaryExpressionContext {
		public NamedExpressionContext namedExpression;
		public List<NamedExpressionContext> argument = new ArrayList<NamedExpressionContext>();
		public TerminalNode STRUCT() { return getToken(PstlSqlBaseParser.STRUCT, 0); }
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public StructContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DereferenceContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext base;
		public IdentifierContext fieldName;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DereferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterDereference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitDereference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitDereference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleCaseContext extends PrimaryExpressionContext {
		public ExpressionContext value;
		public ExpressionContext elseExpression;
		public TerminalNode CASE() { return getToken(PstlSqlBaseParser.CASE, 0); }
		public TerminalNode END() { return getToken(PstlSqlBaseParser.END, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PstlSqlBaseParser.ELSE, 0); }
		public SimpleCaseContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSimpleCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSimpleCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSimpleCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ColumnReferenceContext extends PrimaryExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColumnReferenceContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterColumnReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitColumnReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitColumnReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RowConstructorContext extends PrimaryExpressionContext {
		public List<NamedExpressionContext> namedExpression() {
			return getRuleContexts(NamedExpressionContext.class);
		}
		public NamedExpressionContext namedExpression(int i) {
			return getRuleContext(NamedExpressionContext.class,i);
		}
		public RowConstructorContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterRowConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitRowConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitRowConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LastContext extends PrimaryExpressionContext {
		public TerminalNode LAST() { return getToken(PstlSqlBaseParser.LAST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IGNORE() { return getToken(PstlSqlBaseParser.IGNORE, 0); }
		public TerminalNode NULLS() { return getToken(PstlSqlBaseParser.NULLS, 0); }
		public LastContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterLast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitLast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitLast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StarContext extends PrimaryExpressionContext {
		public TerminalNode ASTERISK() { return getToken(PstlSqlBaseParser.ASTERISK, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public StarContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitStar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitStar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubscriptContext extends PrimaryExpressionContext {
		public PrimaryExpressionContext value;
		public ValueExpressionContext index;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ValueExpressionContext valueExpression() {
			return getRuleContext(ValueExpressionContext.class,0);
		}
		public SubscriptContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSubscript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSubscript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimeFunctionCallContext extends PrimaryExpressionContext {
		public Token name;
		public TerminalNode CURRENT_DATE() { return getToken(PstlSqlBaseParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(PstlSqlBaseParser.CURRENT_TIMESTAMP, 0); }
		public TimeFunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTimeFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTimeFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTimeFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubqueryExpressionContext extends PrimaryExpressionContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public SubqueryExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSubqueryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSubqueryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSubqueryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastContext extends PrimaryExpressionContext {
		public TerminalNode CAST() { return getToken(PstlSqlBaseParser.CAST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public CastContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitCast(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitCast(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantDefaultContext extends PrimaryExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantDefaultContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterConstantDefault(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitConstantDefault(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitConstantDefault(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesizedExpressionContext extends PrimaryExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesizedExpressionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitParenthesizedExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends PrimaryExpressionContext {
		public ExpressionContext expression;
		public List<ExpressionContext> argument = new ArrayList<ExpressionContext>();
		public Token trimOption;
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode OVER() { return getToken(PstlSqlBaseParser.OVER, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public SetQuantifierContext setQuantifier() {
			return getRuleContext(SetQuantifierContext.class,0);
		}
		public TerminalNode FROM() { return getToken(PstlSqlBaseParser.FROM, 0); }
		public TerminalNode BOTH() { return getToken(PstlSqlBaseParser.BOTH, 0); }
		public TerminalNode LEADING() { return getToken(PstlSqlBaseParser.LEADING, 0); }
		public TerminalNode TRAILING() { return getToken(PstlSqlBaseParser.TRAILING, 0); }
		public FunctionCallContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SearchedCaseContext extends PrimaryExpressionContext {
		public ExpressionContext elseExpression;
		public TerminalNode CASE() { return getToken(PstlSqlBaseParser.CASE, 0); }
		public TerminalNode END() { return getToken(PstlSqlBaseParser.END, 0); }
		public List<WhenClauseContext> whenClause() {
			return getRuleContexts(WhenClauseContext.class);
		}
		public WhenClauseContext whenClause(int i) {
			return getRuleContext(WhenClauseContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PstlSqlBaseParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SearchedCaseContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSearchedCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSearchedCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSearchedCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PositionContext extends PrimaryExpressionContext {
		public ValueExpressionContext substr;
		public ValueExpressionContext str;
		public TerminalNode POSITION() { return getToken(PstlSqlBaseParser.POSITION, 0); }
		public TerminalNode IN() { return getToken(PstlSqlBaseParser.IN, 0); }
		public List<ValueExpressionContext> valueExpression() {
			return getRuleContexts(ValueExpressionContext.class);
		}
		public ValueExpressionContext valueExpression(int i) {
			return getRuleContext(ValueExpressionContext.class,i);
		}
		public PositionContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitPosition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FirstContext extends PrimaryExpressionContext {
		public TerminalNode FIRST() { return getToken(PstlSqlBaseParser.FIRST, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IGNORE() { return getToken(PstlSqlBaseParser.IGNORE, 0); }
		public TerminalNode NULLS() { return getToken(PstlSqlBaseParser.NULLS, 0); }
		public FirstContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterFirst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitFirst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitFirst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		return primaryExpression(0);
	}

	private PrimaryExpressionContext primaryExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, _parentState);
		PrimaryExpressionContext _prevctx = _localctx;
		int _startState = 156;
		enterRecursionRule(_localctx, 156, RULE_primaryExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1539);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
			case 1:
				{
				_localctx = new TimeFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1415);
				((TimeFunctionCallContext)_localctx).name = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==CURRENT_DATE || _la==CURRENT_TIMESTAMP) ) {
					((TimeFunctionCallContext)_localctx).name = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				{
				_localctx = new SearchedCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1416);
				match(CASE);
				setState(1418); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1417);
					whenClause();
					}
					}
					setState(1420); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(1424);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(1422);
					match(ELSE);
					setState(1423);
					((SearchedCaseContext)_localctx).elseExpression = expression();
					}
				}

				setState(1426);
				match(END);
				}
				break;
			case 3:
				{
				_localctx = new SimpleCaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1428);
				match(CASE);
				setState(1429);
				((SimpleCaseContext)_localctx).value = expression();
				setState(1431); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1430);
					whenClause();
					}
					}
					setState(1433); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WHEN );
				setState(1437);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(1435);
					match(ELSE);
					setState(1436);
					((SimpleCaseContext)_localctx).elseExpression = expression();
					}
				}

				setState(1439);
				match(END);
				}
				break;
			case 4:
				{
				_localctx = new CastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1441);
				match(CAST);
				setState(1442);
				match(T__0);
				setState(1443);
				expression();
				setState(1444);
				match(AS);
				setState(1445);
				dataType();
				setState(1446);
				match(T__1);
				}
				break;
			case 5:
				{
				_localctx = new StructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1448);
				match(STRUCT);
				setState(1449);
				match(T__0);
				setState(1458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FROM) | (1L << SELECT) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NULLS - 64)) | (1L << (ASC - 64)) | (1L << (DESC - 64)) | (1L << (FOR - 64)) | (1L << (INTERVAL - 64)) | (1L << (CASE - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (JOIN - 64)) | (1L << (CROSS - 64)) | (1L << (OUTER - 64)) | (1L << (INNER - 64)) | (1L << (LEFT - 64)) | (1L << (SEMI - 64)) | (1L << (RIGHT - 64)) | (1L << (FULL - 64)) | (1L << (NATURAL - 64)) | (1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (DIRECTORY - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (TABLESAMPLE - 128)) | (1L << (STRATIFY - 128)) | (1L << (ALTER - 128)) | (1L << (RENAME - 128)) | (1L << (ARRAY - 128)) | (1L << (MAP - 128)) | (1L << (STRUCT - 128)) | (1L << (COMMENT - 128)) | (1L << (SET - 128)) | (1L << (RESET - 128)) | (1L << (DATA - 128)) | (1L << (START - 128)) | (1L << (TRANSACTION - 128)) | (1L << (COMMIT - 128)) | (1L << (ROLLBACK - 128)) | (1L << (MACRO - 128)) | (1L << (IGNORE - 128)) | (1L << (BOTH - 128)) | (1L << (LEADING - 128)) | (1L << (TRAILING - 128)) | (1L << (IF - 128)) | (1L << (POSITION - 128)) | (1L << (PLUS - 128)) | (1L << (MINUS - 128)) | (1L << (ASTERISK - 128)) | (1L << (DIV - 128)) | (1L << (TILDE - 128)) | (1L << (PERCENTLIT - 128)) | (1L << (BUCKET - 128)) | (1L << (OUT - 128)) | (1L << (OF - 128)) | (1L << (SORT - 128)) | (1L << (CLUSTER - 128)) | (1L << (DISTRIBUTE - 128)) | (1L << (OVERWRITE - 128)) | (1L << (TRANSFORM - 128)) | (1L << (REDUCE - 128)) | (1L << (SERDE - 128)) | (1L << (SERDEPROPERTIES - 128)) | (1L << (RECORDREADER - 128)) | (1L << (RECORDWRITER - 128)) | (1L << (DELIMITED - 128)) | (1L << (FIELDS - 128)) | (1L << (TERMINATED - 128)) | (1L << (COLLECTION - 128)) | (1L << (ITEMS - 128)) | (1L << (KEYS - 128)) | (1L << (ESCAPED - 128)) | (1L << (LINES - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (SEPARATED - 192)) | (1L << (FUNCTION - 192)) | (1L << (EXTENDED - 192)) | (1L << (REFRESH - 192)) | (1L << (CLEAR - 192)) | (1L << (CACHE - 192)) | (1L << (UNCACHE - 192)) | (1L << (LAZY - 192)) | (1L << (FORMATTED - 192)) | (1L << (GLOBAL - 192)) | (1L << (TEMPORARY - 192)) | (1L << (OPTIONS - 192)) | (1L << (UNSET - 192)) | (1L << (TBLPROPERTIES - 192)) | (1L << (DBPROPERTIES - 192)) | (1L << (BUCKETS - 192)) | (1L << (SKEWED - 192)) | (1L << (STORED - 192)) | (1L << (DIRECTORIES - 192)) | (1L << (LOCATION - 192)) | (1L << (EXCHANGE - 192)) | (1L << (ARCHIVE - 192)) | (1L << (UNARCHIVE - 192)) | (1L << (FILEFORMAT - 192)) | (1L << (TOUCH - 192)) | (1L << (COMPACT - 192)) | (1L << (CONCATENATE - 192)) | (1L << (CHANGE - 192)) | (1L << (CASCADE - 192)) | (1L << (RESTRICT - 192)) | (1L << (CLUSTERED - 192)) | (1L << (SORTED - 192)) | (1L << (PURGE - 192)) | (1L << (INPUTFORMAT - 192)) | (1L << (OUTPUTFORMAT - 192)) | (1L << (DATABASE - 192)) | (1L << (DATABASES - 192)) | (1L << (DFS - 192)) | (1L << (TRUNCATE - 192)) | (1L << (ANALYZE - 192)) | (1L << (COMPUTE - 192)) | (1L << (LIST - 192)) | (1L << (STATISTICS - 192)) | (1L << (PARTITIONED - 192)) | (1L << (EXTERNAL - 192)) | (1L << (DEFINED - 192)) | (1L << (REVOKE - 192)) | (1L << (GRANT - 192)) | (1L << (LOCK - 192)) | (1L << (UNLOCK - 192)) | (1L << (MSCK - 192)) | (1L << (REPAIR - 192)) | (1L << (RECOVER - 192)) | (1L << (EXPORT - 192)) | (1L << (IMPORT - 192)) | (1L << (LOAD - 192)) | (1L << (ROLE - 192)) | (1L << (ROLES - 192)) | (1L << (COMPACTIONS - 192)) | (1L << (PRINCIPALS - 192)) | (1L << (TRANSACTIONS - 192)) | (1L << (INDEX - 192)) | (1L << (INDEXES - 192)) | (1L << (LOCKS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (OPTION - 256)) | (1L << (ANTI - 256)) | (1L << (LOCAL - 256)) | (1L << (INPATH - 256)) | (1L << (CURRENT_DATE - 256)) | (1L << (CURRENT_TIMESTAMP - 256)) | (1L << (STRING - 256)) | (1L << (BIGINT_LITERAL - 256)) | (1L << (SMALLINT_LITERAL - 256)) | (1L << (TINYINT_LITERAL - 256)) | (1L << (INTEGER_VALUE - 256)) | (1L << (DECIMAL_VALUE - 256)) | (1L << (DOUBLE_LITERAL - 256)) | (1L << (BIGDECIMAL_LITERAL - 256)) | (1L << (IDENTIFIER - 256)) | (1L << (BACKQUOTED_IDENTIFIER - 256)))) != 0)) {
					{
					setState(1450);
					((StructContext)_localctx).namedExpression = namedExpression();
					((StructContext)_localctx).argument.add(((StructContext)_localctx).namedExpression);
					setState(1455);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(1451);
						match(T__2);
						setState(1452);
						((StructContext)_localctx).namedExpression = namedExpression();
						((StructContext)_localctx).argument.add(((StructContext)_localctx).namedExpression);
						}
						}
						setState(1457);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1460);
				match(T__1);
				}
				break;
			case 6:
				{
				_localctx = new FirstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1461);
				match(FIRST);
				setState(1462);
				match(T__0);
				setState(1463);
				expression();
				setState(1466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGNORE) {
					{
					setState(1464);
					match(IGNORE);
					setState(1465);
					match(NULLS);
					}
				}

				setState(1468);
				match(T__1);
				}
				break;
			case 7:
				{
				_localctx = new LastContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1470);
				match(LAST);
				setState(1471);
				match(T__0);
				setState(1472);
				expression();
				setState(1475);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGNORE) {
					{
					setState(1473);
					match(IGNORE);
					setState(1474);
					match(NULLS);
					}
				}

				setState(1477);
				match(T__1);
				}
				break;
			case 8:
				{
				_localctx = new PositionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1479);
				match(POSITION);
				setState(1480);
				match(T__0);
				setState(1481);
				((PositionContext)_localctx).substr = valueExpression(0);
				setState(1482);
				match(IN);
				setState(1483);
				((PositionContext)_localctx).str = valueExpression(0);
				setState(1484);
				match(T__1);
				}
				break;
			case 9:
				{
				_localctx = new ConstantDefaultContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1486);
				constant();
				}
				break;
			case 10:
				{
				_localctx = new StarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1487);
				match(ASTERISK);
				}
				break;
			case 11:
				{
				_localctx = new StarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1488);
				qualifiedName();
				setState(1489);
				match(T__3);
				setState(1490);
				match(ASTERISK);
				}
				break;
			case 12:
				{
				_localctx = new RowConstructorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1492);
				match(T__0);
				setState(1493);
				namedExpression();
				setState(1496); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1494);
					match(T__2);
					setState(1495);
					namedExpression();
					}
					}
					setState(1498); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
				setState(1500);
				match(T__1);
				}
				break;
			case 13:
				{
				_localctx = new SubqueryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1502);
				match(T__0);
				setState(1503);
				query();
				setState(1504);
				match(T__1);
				}
				break;
			case 14:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1506);
				qualifiedName();
				setState(1507);
				match(T__0);
				setState(1519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << FROM) | (1L << SELECT) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NULLS - 64)) | (1L << (ASC - 64)) | (1L << (DESC - 64)) | (1L << (FOR - 64)) | (1L << (INTERVAL - 64)) | (1L << (CASE - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (JOIN - 64)) | (1L << (CROSS - 64)) | (1L << (OUTER - 64)) | (1L << (INNER - 64)) | (1L << (LEFT - 64)) | (1L << (SEMI - 64)) | (1L << (RIGHT - 64)) | (1L << (FULL - 64)) | (1L << (NATURAL - 64)) | (1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (DIRECTORY - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (TABLESAMPLE - 128)) | (1L << (STRATIFY - 128)) | (1L << (ALTER - 128)) | (1L << (RENAME - 128)) | (1L << (ARRAY - 128)) | (1L << (MAP - 128)) | (1L << (STRUCT - 128)) | (1L << (COMMENT - 128)) | (1L << (SET - 128)) | (1L << (RESET - 128)) | (1L << (DATA - 128)) | (1L << (START - 128)) | (1L << (TRANSACTION - 128)) | (1L << (COMMIT - 128)) | (1L << (ROLLBACK - 128)) | (1L << (MACRO - 128)) | (1L << (IGNORE - 128)) | (1L << (BOTH - 128)) | (1L << (LEADING - 128)) | (1L << (TRAILING - 128)) | (1L << (IF - 128)) | (1L << (POSITION - 128)) | (1L << (PLUS - 128)) | (1L << (MINUS - 128)) | (1L << (ASTERISK - 128)) | (1L << (DIV - 128)) | (1L << (TILDE - 128)) | (1L << (PERCENTLIT - 128)) | (1L << (BUCKET - 128)) | (1L << (OUT - 128)) | (1L << (OF - 128)) | (1L << (SORT - 128)) | (1L << (CLUSTER - 128)) | (1L << (DISTRIBUTE - 128)) | (1L << (OVERWRITE - 128)) | (1L << (TRANSFORM - 128)) | (1L << (REDUCE - 128)) | (1L << (SERDE - 128)) | (1L << (SERDEPROPERTIES - 128)) | (1L << (RECORDREADER - 128)) | (1L << (RECORDWRITER - 128)) | (1L << (DELIMITED - 128)) | (1L << (FIELDS - 128)) | (1L << (TERMINATED - 128)) | (1L << (COLLECTION - 128)) | (1L << (ITEMS - 128)) | (1L << (KEYS - 128)) | (1L << (ESCAPED - 128)) | (1L << (LINES - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (SEPARATED - 192)) | (1L << (FUNCTION - 192)) | (1L << (EXTENDED - 192)) | (1L << (REFRESH - 192)) | (1L << (CLEAR - 192)) | (1L << (CACHE - 192)) | (1L << (UNCACHE - 192)) | (1L << (LAZY - 192)) | (1L << (FORMATTED - 192)) | (1L << (GLOBAL - 192)) | (1L << (TEMPORARY - 192)) | (1L << (OPTIONS - 192)) | (1L << (UNSET - 192)) | (1L << (TBLPROPERTIES - 192)) | (1L << (DBPROPERTIES - 192)) | (1L << (BUCKETS - 192)) | (1L << (SKEWED - 192)) | (1L << (STORED - 192)) | (1L << (DIRECTORIES - 192)) | (1L << (LOCATION - 192)) | (1L << (EXCHANGE - 192)) | (1L << (ARCHIVE - 192)) | (1L << (UNARCHIVE - 192)) | (1L << (FILEFORMAT - 192)) | (1L << (TOUCH - 192)) | (1L << (COMPACT - 192)) | (1L << (CONCATENATE - 192)) | (1L << (CHANGE - 192)) | (1L << (CASCADE - 192)) | (1L << (RESTRICT - 192)) | (1L << (CLUSTERED - 192)) | (1L << (SORTED - 192)) | (1L << (PURGE - 192)) | (1L << (INPUTFORMAT - 192)) | (1L << (OUTPUTFORMAT - 192)) | (1L << (DATABASE - 192)) | (1L << (DATABASES - 192)) | (1L << (DFS - 192)) | (1L << (TRUNCATE - 192)) | (1L << (ANALYZE - 192)) | (1L << (COMPUTE - 192)) | (1L << (LIST - 192)) | (1L << (STATISTICS - 192)) | (1L << (PARTITIONED - 192)) | (1L << (EXTERNAL - 192)) | (1L << (DEFINED - 192)) | (1L << (REVOKE - 192)) | (1L << (GRANT - 192)) | (1L << (LOCK - 192)) | (1L << (UNLOCK - 192)) | (1L << (MSCK - 192)) | (1L << (REPAIR - 192)) | (1L << (RECOVER - 192)) | (1L << (EXPORT - 192)) | (1L << (IMPORT - 192)) | (1L << (LOAD - 192)) | (1L << (ROLE - 192)) | (1L << (ROLES - 192)) | (1L << (COMPACTIONS - 192)) | (1L << (PRINCIPALS - 192)) | (1L << (TRANSACTIONS - 192)) | (1L << (INDEX - 192)) | (1L << (INDEXES - 192)) | (1L << (LOCKS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (OPTION - 256)) | (1L << (ANTI - 256)) | (1L << (LOCAL - 256)) | (1L << (INPATH - 256)) | (1L << (CURRENT_DATE - 256)) | (1L << (CURRENT_TIMESTAMP - 256)) | (1L << (STRING - 256)) | (1L << (BIGINT_LITERAL - 256)) | (1L << (SMALLINT_LITERAL - 256)) | (1L << (TINYINT_LITERAL - 256)) | (1L << (INTEGER_VALUE - 256)) | (1L << (DECIMAL_VALUE - 256)) | (1L << (DOUBLE_LITERAL - 256)) | (1L << (BIGDECIMAL_LITERAL - 256)) | (1L << (IDENTIFIER - 256)) | (1L << (BACKQUOTED_IDENTIFIER - 256)))) != 0)) {
					{
					setState(1509);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
					case 1:
						{
						setState(1508);
						setQuantifier();
						}
						break;
					}
					setState(1511);
					((FunctionCallContext)_localctx).expression = expression();
					((FunctionCallContext)_localctx).argument.add(((FunctionCallContext)_localctx).expression);
					setState(1516);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(1512);
						match(T__2);
						setState(1513);
						((FunctionCallContext)_localctx).expression = expression();
						((FunctionCallContext)_localctx).argument.add(((FunctionCallContext)_localctx).expression);
						}
						}
						setState(1518);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1521);
				match(T__1);
				setState(1524);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,184,_ctx) ) {
				case 1:
					{
					setState(1522);
					match(OVER);
					setState(1523);
					windowSpec();
					}
					break;
				}
				}
				break;
			case 15:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1526);
				qualifiedName();
				setState(1527);
				match(T__0);
				setState(1528);
				((FunctionCallContext)_localctx).trimOption = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & ((1L << (BOTH - 145)) | (1L << (LEADING - 145)) | (1L << (TRAILING - 145)))) != 0)) ) {
					((FunctionCallContext)_localctx).trimOption = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1529);
				((FunctionCallContext)_localctx).expression = expression();
				((FunctionCallContext)_localctx).argument.add(((FunctionCallContext)_localctx).expression);
				setState(1530);
				match(FROM);
				setState(1531);
				((FunctionCallContext)_localctx).expression = expression();
				((FunctionCallContext)_localctx).argument.add(((FunctionCallContext)_localctx).expression);
				setState(1532);
				match(T__1);
				}
				break;
			case 16:
				{
				_localctx = new ColumnReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1534);
				identifier();
				}
				break;
			case 17:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1535);
				match(T__0);
				setState(1536);
				expression();
				setState(1537);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1551);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1549);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
					case 1:
						{
						_localctx = new SubscriptContext(new PrimaryExpressionContext(_parentctx, _parentState));
						((SubscriptContext)_localctx).value = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1541);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1542);
						match(T__6);
						setState(1543);
						((SubscriptContext)_localctx).index = valueExpression(0);
						setState(1544);
						match(T__7);
						}
						break;
					case 2:
						{
						_localctx = new DereferenceContext(new PrimaryExpressionContext(_parentctx, _parentState));
						((DereferenceContext)_localctx).base = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_primaryExpression);
						setState(1546);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1547);
						match(T__3);
						setState(1548);
						((DereferenceContext)_localctx).fieldName = identifier();
						}
						break;
					}
					} 
				}
				setState(1553);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NullLiteralContext extends ConstantContext {
		public TerminalNode NULL() { return getToken(PstlSqlBaseParser.NULL, 0); }
		public NullLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends ConstantContext {
		public List<TerminalNode> STRING() { return getTokens(PstlSqlBaseParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PstlSqlBaseParser.STRING, i);
		}
		public StringLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeConstructorContext extends ConstantContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public TypeConstructorContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTypeConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTypeConstructor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTypeConstructor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntervalLiteralContext extends ConstantContext {
		public IntervalContext interval() {
			return getRuleContext(IntervalContext.class,0);
		}
		public IntervalLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIntervalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIntervalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIntervalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumericLiteralContext extends ConstantContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumericLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterNumericLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitNumericLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitNumericLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralContext extends ConstantContext {
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public BooleanLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_constant);
		try {
			int _alt;
			setState(1566);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1554);
				match(NULL);
				}
				break;
			case 2:
				_localctx = new IntervalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1555);
				interval();
				}
				break;
			case 3:
				_localctx = new TypeConstructorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1556);
				identifier();
				setState(1557);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new NumericLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1559);
				number();
				}
				break;
			case 5:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1560);
				booleanValue();
				}
				break;
			case 6:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(1562); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1561);
						match(STRING);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1564); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,188,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(PstlSqlBaseParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(PstlSqlBaseParser.NEQ, 0); }
		public TerminalNode NEQJ() { return getToken(PstlSqlBaseParser.NEQJ, 0); }
		public TerminalNode LT() { return getToken(PstlSqlBaseParser.LT, 0); }
		public TerminalNode LTE() { return getToken(PstlSqlBaseParser.LTE, 0); }
		public TerminalNode GT() { return getToken(PstlSqlBaseParser.GT, 0); }
		public TerminalNode GTE() { return getToken(PstlSqlBaseParser.GTE, 0); }
		public TerminalNode NSEQ() { return getToken(PstlSqlBaseParser.NSEQ, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterComparisonOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitComparisonOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1568);
			_la = _input.LA(1);
			if ( !(((((_la - 150)) & ~0x3f) == 0 && ((1L << (_la - 150)) & ((1L << (EQ - 150)) | (1L << (NSEQ - 150)) | (1L << (NEQ - 150)) | (1L << (NEQJ - 150)) | (1L << (LT - 150)) | (1L << (LTE - 150)) | (1L << (GT - 150)) | (1L << (GTE - 150)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PstlSqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public TerminalNode ASTERISK() { return getToken(PstlSqlBaseParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(PstlSqlBaseParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(PstlSqlBaseParser.PERCENT, 0); }
		public TerminalNode DIV() { return getToken(PstlSqlBaseParser.DIV, 0); }
		public TerminalNode TILDE() { return getToken(PstlSqlBaseParser.TILDE, 0); }
		public TerminalNode AMPERSAND() { return getToken(PstlSqlBaseParser.AMPERSAND, 0); }
		public TerminalNode PIPE() { return getToken(PstlSqlBaseParser.PIPE, 0); }
		public TerminalNode CONCAT_PIPE() { return getToken(PstlSqlBaseParser.CONCAT_PIPE, 0); }
		public TerminalNode HAT() { return getToken(PstlSqlBaseParser.HAT, 0); }
		public ArithmeticOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterArithmeticOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitArithmeticOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitArithmeticOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticOperatorContext arithmeticOperator() throws RecognitionException {
		ArithmeticOperatorContext _localctx = new ArithmeticOperatorContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_arithmeticOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1570);
			_la = _input.LA(1);
			if ( !(((((_la - 158)) & ~0x3f) == 0 && ((1L << (_la - 158)) & ((1L << (PLUS - 158)) | (1L << (MINUS - 158)) | (1L << (ASTERISK - 158)) | (1L << (SLASH - 158)) | (1L << (PERCENT - 158)) | (1L << (DIV - 158)) | (1L << (TILDE - 158)) | (1L << (AMPERSAND - 158)) | (1L << (PIPE - 158)) | (1L << (CONCAT_PIPE - 158)) | (1L << (HAT - 158)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateOperatorContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(PstlSqlBaseParser.OR, 0); }
		public TerminalNode AND() { return getToken(PstlSqlBaseParser.AND, 0); }
		public TerminalNode IN() { return getToken(PstlSqlBaseParser.IN, 0); }
		public TerminalNode NOT() { return getToken(PstlSqlBaseParser.NOT, 0); }
		public PredicateOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicateOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterPredicateOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitPredicateOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitPredicateOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateOperatorContext predicateOperator() throws RecognitionException {
		PredicateOperatorContext _localctx = new PredicateOperatorContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_predicateOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1572);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanValueContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(PstlSqlBaseParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PstlSqlBaseParser.FALSE, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_booleanValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1574);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalContext extends ParserRuleContext {
		public TerminalNode INTERVAL() { return getToken(PstlSqlBaseParser.INTERVAL, 0); }
		public List<IntervalFieldContext> intervalField() {
			return getRuleContexts(IntervalFieldContext.class);
		}
		public IntervalFieldContext intervalField(int i) {
			return getRuleContext(IntervalFieldContext.class,i);
		}
		public IntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitInterval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitInterval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalContext interval() throws RecognitionException {
		IntervalContext _localctx = new IntervalContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_interval);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1576);
			match(INTERVAL);
			setState(1580);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1577);
					intervalField();
					}
					} 
				}
				setState(1582);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalFieldContext extends ParserRuleContext {
		public IntervalValueContext value;
		public IdentifierContext unit;
		public IdentifierContext to;
		public IntervalValueContext intervalValue() {
			return getRuleContext(IntervalValueContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode TO() { return getToken(PstlSqlBaseParser.TO, 0); }
		public IntervalFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIntervalField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIntervalField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIntervalField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalFieldContext intervalField() throws RecognitionException {
		IntervalFieldContext _localctx = new IntervalFieldContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_intervalField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1583);
			((IntervalFieldContext)_localctx).value = intervalValue();
			setState(1584);
			((IntervalFieldContext)_localctx).unit = identifier();
			setState(1587);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				{
				setState(1585);
				match(TO);
				setState(1586);
				((IntervalFieldContext)_localctx).to = identifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntervalValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(PstlSqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode DECIMAL_VALUE() { return getToken(PstlSqlBaseParser.DECIMAL_VALUE, 0); }
		public TerminalNode PLUS() { return getToken(PstlSqlBaseParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public IntervalValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIntervalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIntervalValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIntervalValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntervalValueContext intervalValue() throws RecognitionException {
		IntervalValueContext _localctx = new IntervalValueContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_intervalValue);
		int _la;
		try {
			setState(1594);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case INTEGER_VALUE:
			case DECIMAL_VALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1590);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(1589);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(1592);
				_la = _input.LA(1);
				if ( !(_la==INTEGER_VALUE || _la==DECIMAL_VALUE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1593);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColPositionContext extends ParserRuleContext {
		public TerminalNode FIRST() { return getToken(PstlSqlBaseParser.FIRST, 0); }
		public TerminalNode AFTER() { return getToken(PstlSqlBaseParser.AFTER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ColPositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colPosition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterColPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitColPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitColPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColPositionContext colPosition() throws RecognitionException {
		ColPositionContext _localctx = new ColPositionContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_colPosition);
		try {
			setState(1599);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIRST:
				enterOuterAlt(_localctx, 1);
				{
				setState(1596);
				match(FIRST);
				}
				break;
			case AFTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1597);
				match(AFTER);
				setState(1598);
				identifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataTypeContext extends ParserRuleContext {
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
	 
		public DataTypeContext() { }
		public void copyFrom(DataTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComplexDataTypeContext extends DataTypeContext {
		public Token complex;
		public List<DataTypeContext> dataType() {
			return getRuleContexts(DataTypeContext.class);
		}
		public DataTypeContext dataType(int i) {
			return getRuleContext(DataTypeContext.class,i);
		}
		public TerminalNode ARRAY() { return getToken(PstlSqlBaseParser.ARRAY, 0); }
		public TerminalNode MAP() { return getToken(PstlSqlBaseParser.MAP, 0); }
		public TerminalNode STRUCT() { return getToken(PstlSqlBaseParser.STRUCT, 0); }
		public TerminalNode NEQ() { return getToken(PstlSqlBaseParser.NEQ, 0); }
		public ComplexColTypeListContext complexColTypeList() {
			return getRuleContext(ComplexColTypeListContext.class,0);
		}
		public ComplexDataTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterComplexDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitComplexDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitComplexDataType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimitiveDataTypeContext extends DataTypeContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> INTEGER_VALUE() { return getTokens(PstlSqlBaseParser.INTEGER_VALUE); }
		public TerminalNode INTEGER_VALUE(int i) {
			return getToken(PstlSqlBaseParser.INTEGER_VALUE, i);
		}
		public PrimitiveDataTypeContext(DataTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterPrimitiveDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitPrimitiveDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitPrimitiveDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_dataType);
		int _la;
		try {
			setState(1635);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1601);
				((ComplexDataTypeContext)_localctx).complex = match(ARRAY);
				setState(1602);
				match(LT);
				setState(1603);
				dataType();
				setState(1604);
				match(GT);
				}
				break;
			case 2:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1606);
				((ComplexDataTypeContext)_localctx).complex = match(MAP);
				setState(1607);
				match(LT);
				setState(1608);
				dataType();
				setState(1609);
				match(T__2);
				setState(1610);
				dataType();
				setState(1611);
				match(GT);
				}
				break;
			case 3:
				_localctx = new ComplexDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1613);
				((ComplexDataTypeContext)_localctx).complex = match(STRUCT);
				setState(1620);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LT:
					{
					setState(1614);
					match(LT);
					setState(1616);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FROM) | (1L << SELECT) | (1L << ADD) | (1L << AS) | (1L << ALL) | (1L << DISTINCT) | (1L << WHERE) | (1L << GROUP) | (1L << BY) | (1L << GROUPING) | (1L << SETS) | (1L << CUBE) | (1L << ROLLUP) | (1L << ORDER) | (1L << HAVING) | (1L << LIMIT) | (1L << AT) | (1L << OR) | (1L << AND) | (1L << IN) | (1L << NOT) | (1L << NO) | (1L << EXISTS) | (1L << BETWEEN) | (1L << LIKE) | (1L << RLIKE) | (1L << IS) | (1L << NULL) | (1L << TRUE) | (1L << FALSE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (NULLS - 64)) | (1L << (ASC - 64)) | (1L << (DESC - 64)) | (1L << (FOR - 64)) | (1L << (INTERVAL - 64)) | (1L << (CASE - 64)) | (1L << (WHEN - 64)) | (1L << (THEN - 64)) | (1L << (ELSE - 64)) | (1L << (END - 64)) | (1L << (JOIN - 64)) | (1L << (CROSS - 64)) | (1L << (OUTER - 64)) | (1L << (INNER - 64)) | (1L << (LEFT - 64)) | (1L << (SEMI - 64)) | (1L << (RIGHT - 64)) | (1L << (FULL - 64)) | (1L << (NATURAL - 64)) | (1L << (ON - 64)) | (1L << (LATERAL - 64)) | (1L << (WINDOW - 64)) | (1L << (OVER - 64)) | (1L << (PARTITION - 64)) | (1L << (RANGE - 64)) | (1L << (ROWS - 64)) | (1L << (UNBOUNDED - 64)) | (1L << (PRECEDING - 64)) | (1L << (FOLLOWING - 64)) | (1L << (CURRENT - 64)) | (1L << (FIRST - 64)) | (1L << (AFTER - 64)) | (1L << (LAST - 64)) | (1L << (ROW - 64)) | (1L << (WITH - 64)) | (1L << (VALUES - 64)) | (1L << (CREATE - 64)) | (1L << (TABLE - 64)) | (1L << (DIRECTORY - 64)) | (1L << (VIEW - 64)) | (1L << (REPLACE - 64)) | (1L << (INSERT - 64)) | (1L << (DELETE - 64)) | (1L << (INTO - 64)) | (1L << (DESCRIBE - 64)) | (1L << (EXPLAIN - 64)) | (1L << (FORMAT - 64)) | (1L << (LOGICAL - 64)) | (1L << (CODEGEN - 64)) | (1L << (COST - 64)) | (1L << (CAST - 64)) | (1L << (SHOW - 64)) | (1L << (TABLES - 64)) | (1L << (COLUMNS - 64)) | (1L << (COLUMN - 64)) | (1L << (USE - 64)) | (1L << (PARTITIONS - 64)) | (1L << (FUNCTIONS - 64)) | (1L << (DROP - 64)) | (1L << (UNION - 64)) | (1L << (EXCEPT - 64)) | (1L << (SETMINUS - 64)) | (1L << (INTERSECT - 64)) | (1L << (TO - 64)))) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & ((1L << (TABLESAMPLE - 128)) | (1L << (STRATIFY - 128)) | (1L << (ALTER - 128)) | (1L << (RENAME - 128)) | (1L << (ARRAY - 128)) | (1L << (MAP - 128)) | (1L << (STRUCT - 128)) | (1L << (COMMENT - 128)) | (1L << (SET - 128)) | (1L << (RESET - 128)) | (1L << (DATA - 128)) | (1L << (START - 128)) | (1L << (TRANSACTION - 128)) | (1L << (COMMIT - 128)) | (1L << (ROLLBACK - 128)) | (1L << (MACRO - 128)) | (1L << (IGNORE - 128)) | (1L << (BOTH - 128)) | (1L << (LEADING - 128)) | (1L << (TRAILING - 128)) | (1L << (IF - 128)) | (1L << (POSITION - 128)) | (1L << (DIV - 128)) | (1L << (PERCENTLIT - 128)) | (1L << (BUCKET - 128)) | (1L << (OUT - 128)) | (1L << (OF - 128)) | (1L << (SORT - 128)) | (1L << (CLUSTER - 128)) | (1L << (DISTRIBUTE - 128)) | (1L << (OVERWRITE - 128)) | (1L << (TRANSFORM - 128)) | (1L << (REDUCE - 128)) | (1L << (SERDE - 128)) | (1L << (SERDEPROPERTIES - 128)) | (1L << (RECORDREADER - 128)) | (1L << (RECORDWRITER - 128)) | (1L << (DELIMITED - 128)) | (1L << (FIELDS - 128)) | (1L << (TERMINATED - 128)) | (1L << (COLLECTION - 128)) | (1L << (ITEMS - 128)) | (1L << (KEYS - 128)) | (1L << (ESCAPED - 128)) | (1L << (LINES - 128)))) != 0) || ((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & ((1L << (SEPARATED - 192)) | (1L << (FUNCTION - 192)) | (1L << (EXTENDED - 192)) | (1L << (REFRESH - 192)) | (1L << (CLEAR - 192)) | (1L << (CACHE - 192)) | (1L << (UNCACHE - 192)) | (1L << (LAZY - 192)) | (1L << (FORMATTED - 192)) | (1L << (GLOBAL - 192)) | (1L << (TEMPORARY - 192)) | (1L << (OPTIONS - 192)) | (1L << (UNSET - 192)) | (1L << (TBLPROPERTIES - 192)) | (1L << (DBPROPERTIES - 192)) | (1L << (BUCKETS - 192)) | (1L << (SKEWED - 192)) | (1L << (STORED - 192)) | (1L << (DIRECTORIES - 192)) | (1L << (LOCATION - 192)) | (1L << (EXCHANGE - 192)) | (1L << (ARCHIVE - 192)) | (1L << (UNARCHIVE - 192)) | (1L << (FILEFORMAT - 192)) | (1L << (TOUCH - 192)) | (1L << (COMPACT - 192)) | (1L << (CONCATENATE - 192)) | (1L << (CHANGE - 192)) | (1L << (CASCADE - 192)) | (1L << (RESTRICT - 192)) | (1L << (CLUSTERED - 192)) | (1L << (SORTED - 192)) | (1L << (PURGE - 192)) | (1L << (INPUTFORMAT - 192)) | (1L << (OUTPUTFORMAT - 192)) | (1L << (DATABASE - 192)) | (1L << (DATABASES - 192)) | (1L << (DFS - 192)) | (1L << (TRUNCATE - 192)) | (1L << (ANALYZE - 192)) | (1L << (COMPUTE - 192)) | (1L << (LIST - 192)) | (1L << (STATISTICS - 192)) | (1L << (PARTITIONED - 192)) | (1L << (EXTERNAL - 192)) | (1L << (DEFINED - 192)) | (1L << (REVOKE - 192)) | (1L << (GRANT - 192)) | (1L << (LOCK - 192)) | (1L << (UNLOCK - 192)) | (1L << (MSCK - 192)) | (1L << (REPAIR - 192)) | (1L << (RECOVER - 192)) | (1L << (EXPORT - 192)) | (1L << (IMPORT - 192)) | (1L << (LOAD - 192)) | (1L << (ROLE - 192)) | (1L << (ROLES - 192)) | (1L << (COMPACTIONS - 192)) | (1L << (PRINCIPALS - 192)) | (1L << (TRANSACTIONS - 192)) | (1L << (INDEX - 192)) | (1L << (INDEXES - 192)) | (1L << (LOCKS - 192)))) != 0) || ((((_la - 256)) & ~0x3f) == 0 && ((1L << (_la - 256)) & ((1L << (OPTION - 256)) | (1L << (ANTI - 256)) | (1L << (LOCAL - 256)) | (1L << (INPATH - 256)) | (1L << (CURRENT_DATE - 256)) | (1L << (CURRENT_TIMESTAMP - 256)) | (1L << (IDENTIFIER - 256)) | (1L << (BACKQUOTED_IDENTIFIER - 256)))) != 0)) {
						{
						setState(1615);
						complexColTypeList();
						}
					}

					setState(1618);
					match(GT);
					}
					break;
				case NEQ:
					{
					setState(1619);
					match(NEQ);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				_localctx = new PrimitiveDataTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1622);
				identifier();
				setState(1633);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
				case 1:
					{
					setState(1623);
					match(T__0);
					setState(1624);
					match(INTEGER_VALUE);
					setState(1629);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(1625);
						match(T__2);
						setState(1626);
						match(INTEGER_VALUE);
						}
						}
						setState(1631);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1632);
					match(T__1);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColTypeListContext extends ParserRuleContext {
		public List<ColTypeContext> colType() {
			return getRuleContexts(ColTypeContext.class);
		}
		public ColTypeContext colType(int i) {
			return getRuleContext(ColTypeContext.class,i);
		}
		public ColTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterColTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitColTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitColTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColTypeListContext colTypeList() throws RecognitionException {
		ColTypeListContext _localctx = new ColTypeListContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_colTypeList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1637);
			colType();
			setState(1642);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1638);
					match(T__2);
					setState(1639);
					colType();
					}
					} 
				}
				setState(1644);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(PstlSqlBaseParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public ColTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterColType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitColType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitColType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColTypeContext colType() throws RecognitionException {
		ColTypeContext _localctx = new ColTypeContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_colType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1645);
			identifier();
			setState(1646);
			dataType();
			setState(1649);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				{
				setState(1647);
				match(COMMENT);
				setState(1648);
				match(STRING);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexColTypeListContext extends ParserRuleContext {
		public List<ComplexColTypeContext> complexColType() {
			return getRuleContexts(ComplexColTypeContext.class);
		}
		public ComplexColTypeContext complexColType(int i) {
			return getRuleContext(ComplexColTypeContext.class,i);
		}
		public ComplexColTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexColTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterComplexColTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitComplexColTypeList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitComplexColTypeList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexColTypeListContext complexColTypeList() throws RecognitionException {
		ComplexColTypeListContext _localctx = new ComplexColTypeListContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_complexColTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1651);
			complexColType();
			setState(1656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(1652);
				match(T__2);
				setState(1653);
				complexColType();
				}
				}
				setState(1658);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComplexColTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public TerminalNode COMMENT() { return getToken(PstlSqlBaseParser.COMMENT, 0); }
		public TerminalNode STRING() { return getToken(PstlSqlBaseParser.STRING, 0); }
		public ComplexColTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexColType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterComplexColType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitComplexColType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitComplexColType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComplexColTypeContext complexColType() throws RecognitionException {
		ComplexColTypeContext _localctx = new ComplexColTypeContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_complexColType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1659);
			identifier();
			setState(1660);
			match(T__8);
			setState(1661);
			dataType();
			setState(1664);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(1662);
				match(COMMENT);
				setState(1663);
				match(STRING);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenClauseContext extends ParserRuleContext {
		public ExpressionContext condition;
		public ExpressionContext result;
		public TerminalNode WHEN() { return getToken(PstlSqlBaseParser.WHEN, 0); }
		public TerminalNode THEN() { return getToken(PstlSqlBaseParser.THEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WhenClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterWhenClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitWhenClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitWhenClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenClauseContext whenClause() throws RecognitionException {
		WhenClauseContext _localctx = new WhenClauseContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_whenClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1666);
			match(WHEN);
			setState(1667);
			((WhenClauseContext)_localctx).condition = expression();
			setState(1668);
			match(THEN);
			setState(1669);
			((WhenClauseContext)_localctx).result = expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowsContext extends ParserRuleContext {
		public TerminalNode WINDOW() { return getToken(PstlSqlBaseParser.WINDOW, 0); }
		public List<NamedWindowContext> namedWindow() {
			return getRuleContexts(NamedWindowContext.class);
		}
		public NamedWindowContext namedWindow(int i) {
			return getRuleContext(NamedWindowContext.class,i);
		}
		public WindowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterWindows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitWindows(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitWindows(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowsContext windows() throws RecognitionException {
		WindowsContext _localctx = new WindowsContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_windows);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1671);
			match(WINDOW);
			setState(1672);
			namedWindow();
			setState(1677);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,204,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1673);
					match(T__2);
					setState(1674);
					namedWindow();
					}
					} 
				}
				setState(1679);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,204,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NamedWindowContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public WindowSpecContext windowSpec() {
			return getRuleContext(WindowSpecContext.class,0);
		}
		public NamedWindowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedWindow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterNamedWindow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitNamedWindow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitNamedWindow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedWindowContext namedWindow() throws RecognitionException {
		NamedWindowContext _localctx = new NamedWindowContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_namedWindow);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1680);
			identifier();
			setState(1681);
			match(AS);
			setState(1682);
			windowSpec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowSpecContext extends ParserRuleContext {
		public WindowSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowSpec; }
	 
		public WindowSpecContext() { }
		public void copyFrom(WindowSpecContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WindowRefContext extends WindowSpecContext {
		public IdentifierContext name;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public WindowRefContext(WindowSpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterWindowRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitWindowRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitWindowRef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WindowDefContext extends WindowSpecContext {
		public ExpressionContext expression;
		public List<ExpressionContext> partition = new ArrayList<ExpressionContext>();
		public TerminalNode CLUSTER() { return getToken(PstlSqlBaseParser.CLUSTER, 0); }
		public List<TerminalNode> BY() { return getTokens(PstlSqlBaseParser.BY); }
		public TerminalNode BY(int i) {
			return getToken(PstlSqlBaseParser.BY, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public WindowFrameContext windowFrame() {
			return getRuleContext(WindowFrameContext.class,0);
		}
		public List<SortItemContext> sortItem() {
			return getRuleContexts(SortItemContext.class);
		}
		public SortItemContext sortItem(int i) {
			return getRuleContext(SortItemContext.class,i);
		}
		public TerminalNode PARTITION() { return getToken(PstlSqlBaseParser.PARTITION, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(PstlSqlBaseParser.DISTRIBUTE, 0); }
		public TerminalNode ORDER() { return getToken(PstlSqlBaseParser.ORDER, 0); }
		public TerminalNode SORT() { return getToken(PstlSqlBaseParser.SORT, 0); }
		public WindowDefContext(WindowSpecContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterWindowDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitWindowDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitWindowDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowSpecContext windowSpec() throws RecognitionException {
		WindowSpecContext _localctx = new WindowSpecContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_windowSpec);
		int _la;
		try {
			setState(1726);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
			case SELECT:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case JOIN:
			case CROSS:
			case OUTER:
			case INNER:
			case LEFT:
			case SEMI:
			case RIGHT:
			case FULL:
			case NATURAL:
			case ON:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case DIRECTORY:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case UNION:
			case EXCEPT:
			case SETMINUS:
			case INTERSECT:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case BOTH:
			case LEADING:
			case TRAILING:
			case IF:
			case POSITION:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case ANTI:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				_localctx = new WindowRefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1684);
				((WindowRefContext)_localctx).name = identifier();
				}
				break;
			case T__0:
				_localctx = new WindowDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1685);
				match(T__0);
				setState(1720);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CLUSTER:
					{
					setState(1686);
					match(CLUSTER);
					setState(1687);
					match(BY);
					setState(1688);
					((WindowDefContext)_localctx).expression = expression();
					((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
					setState(1693);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(1689);
						match(T__2);
						setState(1690);
						((WindowDefContext)_localctx).expression = expression();
						((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
						}
						}
						setState(1695);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case T__1:
				case ORDER:
				case PARTITION:
				case RANGE:
				case ROWS:
				case SORT:
				case DISTRIBUTE:
					{
					setState(1706);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PARTITION || _la==DISTRIBUTE) {
						{
						setState(1696);
						_la = _input.LA(1);
						if ( !(_la==PARTITION || _la==DISTRIBUTE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1697);
						match(BY);
						setState(1698);
						((WindowDefContext)_localctx).expression = expression();
						((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
						setState(1703);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(1699);
							match(T__2);
							setState(1700);
							((WindowDefContext)_localctx).expression = expression();
							((WindowDefContext)_localctx).partition.add(((WindowDefContext)_localctx).expression);
							}
							}
							setState(1705);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(1718);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ORDER || _la==SORT) {
						{
						setState(1708);
						_la = _input.LA(1);
						if ( !(_la==ORDER || _la==SORT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1709);
						match(BY);
						setState(1710);
						sortItem();
						setState(1715);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==T__2) {
							{
							{
							setState(1711);
							match(T__2);
							setState(1712);
							sortItem();
							}
							}
							setState(1717);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1723);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RANGE || _la==ROWS) {
					{
					setState(1722);
					windowFrame();
					}
				}

				setState(1725);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WindowFrameContext extends ParserRuleContext {
		public Token frameType;
		public FrameBoundContext start;
		public FrameBoundContext end;
		public TerminalNode RANGE() { return getToken(PstlSqlBaseParser.RANGE, 0); }
		public List<FrameBoundContext> frameBound() {
			return getRuleContexts(FrameBoundContext.class);
		}
		public FrameBoundContext frameBound(int i) {
			return getRuleContext(FrameBoundContext.class,i);
		}
		public TerminalNode ROWS() { return getToken(PstlSqlBaseParser.ROWS, 0); }
		public TerminalNode BETWEEN() { return getToken(PstlSqlBaseParser.BETWEEN, 0); }
		public TerminalNode AND() { return getToken(PstlSqlBaseParser.AND, 0); }
		public WindowFrameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_windowFrame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterWindowFrame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitWindowFrame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitWindowFrame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WindowFrameContext windowFrame() throws RecognitionException {
		WindowFrameContext _localctx = new WindowFrameContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_windowFrame);
		try {
			setState(1744);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,213,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1728);
				((WindowFrameContext)_localctx).frameType = match(RANGE);
				setState(1729);
				((WindowFrameContext)_localctx).start = frameBound();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1730);
				((WindowFrameContext)_localctx).frameType = match(ROWS);
				setState(1731);
				((WindowFrameContext)_localctx).start = frameBound();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1732);
				((WindowFrameContext)_localctx).frameType = match(RANGE);
				setState(1733);
				match(BETWEEN);
				setState(1734);
				((WindowFrameContext)_localctx).start = frameBound();
				setState(1735);
				match(AND);
				setState(1736);
				((WindowFrameContext)_localctx).end = frameBound();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1738);
				((WindowFrameContext)_localctx).frameType = match(ROWS);
				setState(1739);
				match(BETWEEN);
				setState(1740);
				((WindowFrameContext)_localctx).start = frameBound();
				setState(1741);
				match(AND);
				setState(1742);
				((WindowFrameContext)_localctx).end = frameBound();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FrameBoundContext extends ParserRuleContext {
		public Token boundType;
		public TerminalNode UNBOUNDED() { return getToken(PstlSqlBaseParser.UNBOUNDED, 0); }
		public TerminalNode PRECEDING() { return getToken(PstlSqlBaseParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(PstlSqlBaseParser.FOLLOWING, 0); }
		public TerminalNode ROW() { return getToken(PstlSqlBaseParser.ROW, 0); }
		public TerminalNode CURRENT() { return getToken(PstlSqlBaseParser.CURRENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FrameBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_frameBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterFrameBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitFrameBound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitFrameBound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FrameBoundContext frameBound() throws RecognitionException {
		FrameBoundContext _localctx = new FrameBoundContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_frameBound);
		int _la;
		try {
			setState(1753);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1746);
				match(UNBOUNDED);
				setState(1747);
				((FrameBoundContext)_localctx).boundType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PRECEDING || _la==FOLLOWING) ) {
					((FrameBoundContext)_localctx).boundType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1748);
				((FrameBoundContext)_localctx).boundType = match(CURRENT);
				setState(1749);
				match(ROW);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1750);
				expression();
				setState(1751);
				((FrameBoundContext)_localctx).boundType = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PRECEDING || _la==FOLLOWING) ) {
					((FrameBoundContext)_localctx).boundType = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterQualifiedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitQualifiedName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitQualifiedName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1755);
			identifier();
			setState(1760);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1756);
					match(T__3);
					setState(1757);
					identifier();
					}
					} 
				}
				setState(1762);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,215,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public StrictIdentifierContext strictIdentifier() {
			return getRuleContext(StrictIdentifierContext.class,0);
		}
		public TerminalNode ANTI() { return getToken(PstlSqlBaseParser.ANTI, 0); }
		public TerminalNode FULL() { return getToken(PstlSqlBaseParser.FULL, 0); }
		public TerminalNode INNER() { return getToken(PstlSqlBaseParser.INNER, 0); }
		public TerminalNode LEFT() { return getToken(PstlSqlBaseParser.LEFT, 0); }
		public TerminalNode SEMI() { return getToken(PstlSqlBaseParser.SEMI, 0); }
		public TerminalNode RIGHT() { return getToken(PstlSqlBaseParser.RIGHT, 0); }
		public TerminalNode NATURAL() { return getToken(PstlSqlBaseParser.NATURAL, 0); }
		public TerminalNode JOIN() { return getToken(PstlSqlBaseParser.JOIN, 0); }
		public TerminalNode CROSS() { return getToken(PstlSqlBaseParser.CROSS, 0); }
		public TerminalNode ON() { return getToken(PstlSqlBaseParser.ON, 0); }
		public TerminalNode UNION() { return getToken(PstlSqlBaseParser.UNION, 0); }
		public TerminalNode INTERSECT() { return getToken(PstlSqlBaseParser.INTERSECT, 0); }
		public TerminalNode EXCEPT() { return getToken(PstlSqlBaseParser.EXCEPT, 0); }
		public TerminalNode SETMINUS() { return getToken(PstlSqlBaseParser.SETMINUS, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_identifier);
		try {
			setState(1778);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
			case SELECT:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case OUTER:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case DIRECTORY:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case BOTH:
			case LEADING:
			case TRAILING:
			case IF:
			case POSITION:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
			case IDENTIFIER:
			case BACKQUOTED_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1763);
				strictIdentifier();
				}
				break;
			case ANTI:
				enterOuterAlt(_localctx, 2);
				{
				setState(1764);
				match(ANTI);
				}
				break;
			case FULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(1765);
				match(FULL);
				}
				break;
			case INNER:
				enterOuterAlt(_localctx, 4);
				{
				setState(1766);
				match(INNER);
				}
				break;
			case LEFT:
				enterOuterAlt(_localctx, 5);
				{
				setState(1767);
				match(LEFT);
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 6);
				{
				setState(1768);
				match(SEMI);
				}
				break;
			case RIGHT:
				enterOuterAlt(_localctx, 7);
				{
				setState(1769);
				match(RIGHT);
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 8);
				{
				setState(1770);
				match(NATURAL);
				}
				break;
			case JOIN:
				enterOuterAlt(_localctx, 9);
				{
				setState(1771);
				match(JOIN);
				}
				break;
			case CROSS:
				enterOuterAlt(_localctx, 10);
				{
				setState(1772);
				match(CROSS);
				}
				break;
			case ON:
				enterOuterAlt(_localctx, 11);
				{
				setState(1773);
				match(ON);
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 12);
				{
				setState(1774);
				match(UNION);
				}
				break;
			case INTERSECT:
				enterOuterAlt(_localctx, 13);
				{
				setState(1775);
				match(INTERSECT);
				}
				break;
			case EXCEPT:
				enterOuterAlt(_localctx, 14);
				{
				setState(1776);
				match(EXCEPT);
				}
				break;
			case SETMINUS:
				enterOuterAlt(_localctx, 15);
				{
				setState(1777);
				match(SETMINUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StrictIdentifierContext extends ParserRuleContext {
		public StrictIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strictIdentifier; }
	 
		public StrictIdentifierContext() { }
		public void copyFrom(StrictIdentifierContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QuotedIdentifierAlternativeContext extends StrictIdentifierContext {
		public QuotedIdentifierContext quotedIdentifier() {
			return getRuleContext(QuotedIdentifierContext.class,0);
		}
		public QuotedIdentifierAlternativeContext(StrictIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterQuotedIdentifierAlternative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitQuotedIdentifierAlternative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitQuotedIdentifierAlternative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnquotedIdentifierContext extends StrictIdentifierContext {
		public TerminalNode IDENTIFIER() { return getToken(PstlSqlBaseParser.IDENTIFIER, 0); }
		public NonReservedContext nonReserved() {
			return getRuleContext(NonReservedContext.class,0);
		}
		public UnquotedIdentifierContext(StrictIdentifierContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterUnquotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitUnquotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitUnquotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StrictIdentifierContext strictIdentifier() throws RecognitionException {
		StrictIdentifierContext _localctx = new StrictIdentifierContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_strictIdentifier);
		try {
			setState(1783);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1780);
				match(IDENTIFIER);
				}
				break;
			case BACKQUOTED_IDENTIFIER:
				_localctx = new QuotedIdentifierAlternativeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1781);
				quotedIdentifier();
				}
				break;
			case FROM:
			case SELECT:
			case ADD:
			case AS:
			case ALL:
			case DISTINCT:
			case WHERE:
			case GROUP:
			case BY:
			case GROUPING:
			case SETS:
			case CUBE:
			case ROLLUP:
			case ORDER:
			case HAVING:
			case LIMIT:
			case AT:
			case OR:
			case AND:
			case IN:
			case NOT:
			case NO:
			case EXISTS:
			case BETWEEN:
			case LIKE:
			case RLIKE:
			case IS:
			case NULL:
			case TRUE:
			case FALSE:
			case NULLS:
			case ASC:
			case DESC:
			case FOR:
			case INTERVAL:
			case CASE:
			case WHEN:
			case THEN:
			case ELSE:
			case END:
			case OUTER:
			case LATERAL:
			case WINDOW:
			case OVER:
			case PARTITION:
			case RANGE:
			case ROWS:
			case UNBOUNDED:
			case PRECEDING:
			case FOLLOWING:
			case CURRENT:
			case FIRST:
			case AFTER:
			case LAST:
			case ROW:
			case WITH:
			case VALUES:
			case CREATE:
			case TABLE:
			case DIRECTORY:
			case VIEW:
			case REPLACE:
			case INSERT:
			case DELETE:
			case INTO:
			case DESCRIBE:
			case EXPLAIN:
			case FORMAT:
			case LOGICAL:
			case CODEGEN:
			case COST:
			case CAST:
			case SHOW:
			case TABLES:
			case COLUMNS:
			case COLUMN:
			case USE:
			case PARTITIONS:
			case FUNCTIONS:
			case DROP:
			case TO:
			case TABLESAMPLE:
			case STRATIFY:
			case ALTER:
			case RENAME:
			case ARRAY:
			case MAP:
			case STRUCT:
			case COMMENT:
			case SET:
			case RESET:
			case DATA:
			case START:
			case TRANSACTION:
			case COMMIT:
			case ROLLBACK:
			case MACRO:
			case IGNORE:
			case BOTH:
			case LEADING:
			case TRAILING:
			case IF:
			case POSITION:
			case DIV:
			case PERCENTLIT:
			case BUCKET:
			case OUT:
			case OF:
			case SORT:
			case CLUSTER:
			case DISTRIBUTE:
			case OVERWRITE:
			case TRANSFORM:
			case REDUCE:
			case SERDE:
			case SERDEPROPERTIES:
			case RECORDREADER:
			case RECORDWRITER:
			case DELIMITED:
			case FIELDS:
			case TERMINATED:
			case COLLECTION:
			case ITEMS:
			case KEYS:
			case ESCAPED:
			case LINES:
			case SEPARATED:
			case FUNCTION:
			case EXTENDED:
			case REFRESH:
			case CLEAR:
			case CACHE:
			case UNCACHE:
			case LAZY:
			case FORMATTED:
			case GLOBAL:
			case TEMPORARY:
			case OPTIONS:
			case UNSET:
			case TBLPROPERTIES:
			case DBPROPERTIES:
			case BUCKETS:
			case SKEWED:
			case STORED:
			case DIRECTORIES:
			case LOCATION:
			case EXCHANGE:
			case ARCHIVE:
			case UNARCHIVE:
			case FILEFORMAT:
			case TOUCH:
			case COMPACT:
			case CONCATENATE:
			case CHANGE:
			case CASCADE:
			case RESTRICT:
			case CLUSTERED:
			case SORTED:
			case PURGE:
			case INPUTFORMAT:
			case OUTPUTFORMAT:
			case DATABASE:
			case DATABASES:
			case DFS:
			case TRUNCATE:
			case ANALYZE:
			case COMPUTE:
			case LIST:
			case STATISTICS:
			case PARTITIONED:
			case EXTERNAL:
			case DEFINED:
			case REVOKE:
			case GRANT:
			case LOCK:
			case UNLOCK:
			case MSCK:
			case REPAIR:
			case RECOVER:
			case EXPORT:
			case IMPORT:
			case LOAD:
			case ROLE:
			case ROLES:
			case COMPACTIONS:
			case PRINCIPALS:
			case TRANSACTIONS:
			case INDEX:
			case INDEXES:
			case LOCKS:
			case OPTION:
			case LOCAL:
			case INPATH:
			case CURRENT_DATE:
			case CURRENT_TIMESTAMP:
				_localctx = new UnquotedIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1782);
				nonReserved();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QuotedIdentifierContext extends ParserRuleContext {
		public TerminalNode BACKQUOTED_IDENTIFIER() { return getToken(PstlSqlBaseParser.BACKQUOTED_IDENTIFIER, 0); }
		public QuotedIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quotedIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterQuotedIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitQuotedIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitQuotedIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedIdentifierContext quotedIdentifier() throws RecognitionException {
		QuotedIdentifierContext _localctx = new QuotedIdentifierContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_quotedIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1785);
			match(BACKQUOTED_IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalLiteralContext extends NumberContext {
		public TerminalNode DECIMAL_VALUE() { return getToken(PstlSqlBaseParser.DECIMAL_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public DecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BigIntLiteralContext extends NumberContext {
		public TerminalNode BIGINT_LITERAL() { return getToken(PstlSqlBaseParser.BIGINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public BigIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterBigIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitBigIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitBigIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TinyIntLiteralContext extends NumberContext {
		public TerminalNode TINYINT_LITERAL() { return getToken(PstlSqlBaseParser.TINYINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public TinyIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterTinyIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitTinyIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitTinyIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BigDecimalLiteralContext extends NumberContext {
		public TerminalNode BIGDECIMAL_LITERAL() { return getToken(PstlSqlBaseParser.BIGDECIMAL_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public BigDecimalLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterBigDecimalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitBigDecimalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitBigDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleLiteralContext extends NumberContext {
		public TerminalNode DOUBLE_LITERAL() { return getToken(PstlSqlBaseParser.DOUBLE_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public DoubleLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterDoubleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitDoubleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitDoubleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends NumberContext {
		public TerminalNode INTEGER_VALUE() { return getToken(PstlSqlBaseParser.INTEGER_VALUE, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public IntegerLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SmallIntLiteralContext extends NumberContext {
		public TerminalNode SMALLINT_LITERAL() { return getToken(PstlSqlBaseParser.SMALLINT_LITERAL, 0); }
		public TerminalNode MINUS() { return getToken(PstlSqlBaseParser.MINUS, 0); }
		public SmallIntLiteralContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterSmallIntLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitSmallIntLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitSmallIntLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_number);
		int _la;
		try {
			setState(1815);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1788);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(1787);
					match(MINUS);
					}
				}

				setState(1790);
				match(DECIMAL_VALUE);
				}
				break;
			case 2:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1792);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(1791);
					match(MINUS);
					}
				}

				setState(1794);
				match(INTEGER_VALUE);
				}
				break;
			case 3:
				_localctx = new BigIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1796);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(1795);
					match(MINUS);
					}
				}

				setState(1798);
				match(BIGINT_LITERAL);
				}
				break;
			case 4:
				_localctx = new SmallIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1800);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(1799);
					match(MINUS);
					}
				}

				setState(1802);
				match(SMALLINT_LITERAL);
				}
				break;
			case 5:
				_localctx = new TinyIntLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1804);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(1803);
					match(MINUS);
					}
				}

				setState(1806);
				match(TINYINT_LITERAL);
				}
				break;
			case 6:
				_localctx = new DoubleLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(1808);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(1807);
					match(MINUS);
					}
				}

				setState(1810);
				match(DOUBLE_LITERAL);
				}
				break;
			case 7:
				_localctx = new BigDecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(1812);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(1811);
					match(MINUS);
					}
				}

				setState(1814);
				match(BIGDECIMAL_LITERAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonReservedContext extends ParserRuleContext {
		public TerminalNode SHOW() { return getToken(PstlSqlBaseParser.SHOW, 0); }
		public TerminalNode TABLES() { return getToken(PstlSqlBaseParser.TABLES, 0); }
		public TerminalNode COLUMNS() { return getToken(PstlSqlBaseParser.COLUMNS, 0); }
		public TerminalNode COLUMN() { return getToken(PstlSqlBaseParser.COLUMN, 0); }
		public TerminalNode PARTITIONS() { return getToken(PstlSqlBaseParser.PARTITIONS, 0); }
		public TerminalNode FUNCTIONS() { return getToken(PstlSqlBaseParser.FUNCTIONS, 0); }
		public TerminalNode DATABASES() { return getToken(PstlSqlBaseParser.DATABASES, 0); }
		public TerminalNode ADD() { return getToken(PstlSqlBaseParser.ADD, 0); }
		public TerminalNode OVER() { return getToken(PstlSqlBaseParser.OVER, 0); }
		public TerminalNode PARTITION() { return getToken(PstlSqlBaseParser.PARTITION, 0); }
		public TerminalNode RANGE() { return getToken(PstlSqlBaseParser.RANGE, 0); }
		public TerminalNode ROWS() { return getToken(PstlSqlBaseParser.ROWS, 0); }
		public TerminalNode PRECEDING() { return getToken(PstlSqlBaseParser.PRECEDING, 0); }
		public TerminalNode FOLLOWING() { return getToken(PstlSqlBaseParser.FOLLOWING, 0); }
		public TerminalNode CURRENT() { return getToken(PstlSqlBaseParser.CURRENT, 0); }
		public TerminalNode ROW() { return getToken(PstlSqlBaseParser.ROW, 0); }
		public TerminalNode LAST() { return getToken(PstlSqlBaseParser.LAST, 0); }
		public TerminalNode FIRST() { return getToken(PstlSqlBaseParser.FIRST, 0); }
		public TerminalNode AFTER() { return getToken(PstlSqlBaseParser.AFTER, 0); }
		public TerminalNode MAP() { return getToken(PstlSqlBaseParser.MAP, 0); }
		public TerminalNode ARRAY() { return getToken(PstlSqlBaseParser.ARRAY, 0); }
		public TerminalNode STRUCT() { return getToken(PstlSqlBaseParser.STRUCT, 0); }
		public TerminalNode LATERAL() { return getToken(PstlSqlBaseParser.LATERAL, 0); }
		public TerminalNode WINDOW() { return getToken(PstlSqlBaseParser.WINDOW, 0); }
		public TerminalNode REDUCE() { return getToken(PstlSqlBaseParser.REDUCE, 0); }
		public TerminalNode TRANSFORM() { return getToken(PstlSqlBaseParser.TRANSFORM, 0); }
		public TerminalNode SERDE() { return getToken(PstlSqlBaseParser.SERDE, 0); }
		public TerminalNode SERDEPROPERTIES() { return getToken(PstlSqlBaseParser.SERDEPROPERTIES, 0); }
		public TerminalNode RECORDREADER() { return getToken(PstlSqlBaseParser.RECORDREADER, 0); }
		public TerminalNode DELIMITED() { return getToken(PstlSqlBaseParser.DELIMITED, 0); }
		public TerminalNode FIELDS() { return getToken(PstlSqlBaseParser.FIELDS, 0); }
		public TerminalNode TERMINATED() { return getToken(PstlSqlBaseParser.TERMINATED, 0); }
		public TerminalNode COLLECTION() { return getToken(PstlSqlBaseParser.COLLECTION, 0); }
		public TerminalNode ITEMS() { return getToken(PstlSqlBaseParser.ITEMS, 0); }
		public TerminalNode KEYS() { return getToken(PstlSqlBaseParser.KEYS, 0); }
		public TerminalNode ESCAPED() { return getToken(PstlSqlBaseParser.ESCAPED, 0); }
		public TerminalNode LINES() { return getToken(PstlSqlBaseParser.LINES, 0); }
		public TerminalNode SEPARATED() { return getToken(PstlSqlBaseParser.SEPARATED, 0); }
		public TerminalNode EXTENDED() { return getToken(PstlSqlBaseParser.EXTENDED, 0); }
		public TerminalNode REFRESH() { return getToken(PstlSqlBaseParser.REFRESH, 0); }
		public TerminalNode CLEAR() { return getToken(PstlSqlBaseParser.CLEAR, 0); }
		public TerminalNode CACHE() { return getToken(PstlSqlBaseParser.CACHE, 0); }
		public TerminalNode UNCACHE() { return getToken(PstlSqlBaseParser.UNCACHE, 0); }
		public TerminalNode LAZY() { return getToken(PstlSqlBaseParser.LAZY, 0); }
		public TerminalNode GLOBAL() { return getToken(PstlSqlBaseParser.GLOBAL, 0); }
		public TerminalNode TEMPORARY() { return getToken(PstlSqlBaseParser.TEMPORARY, 0); }
		public TerminalNode OPTIONS() { return getToken(PstlSqlBaseParser.OPTIONS, 0); }
		public TerminalNode GROUPING() { return getToken(PstlSqlBaseParser.GROUPING, 0); }
		public TerminalNode CUBE() { return getToken(PstlSqlBaseParser.CUBE, 0); }
		public TerminalNode ROLLUP() { return getToken(PstlSqlBaseParser.ROLLUP, 0); }
		public TerminalNode EXPLAIN() { return getToken(PstlSqlBaseParser.EXPLAIN, 0); }
		public TerminalNode FORMAT() { return getToken(PstlSqlBaseParser.FORMAT, 0); }
		public TerminalNode LOGICAL() { return getToken(PstlSqlBaseParser.LOGICAL, 0); }
		public TerminalNode FORMATTED() { return getToken(PstlSqlBaseParser.FORMATTED, 0); }
		public TerminalNode CODEGEN() { return getToken(PstlSqlBaseParser.CODEGEN, 0); }
		public TerminalNode COST() { return getToken(PstlSqlBaseParser.COST, 0); }
		public TerminalNode TABLESAMPLE() { return getToken(PstlSqlBaseParser.TABLESAMPLE, 0); }
		public TerminalNode USE() { return getToken(PstlSqlBaseParser.USE, 0); }
		public TerminalNode TO() { return getToken(PstlSqlBaseParser.TO, 0); }
		public TerminalNode BUCKET() { return getToken(PstlSqlBaseParser.BUCKET, 0); }
		public TerminalNode PERCENTLIT() { return getToken(PstlSqlBaseParser.PERCENTLIT, 0); }
		public TerminalNode OUT() { return getToken(PstlSqlBaseParser.OUT, 0); }
		public TerminalNode OF() { return getToken(PstlSqlBaseParser.OF, 0); }
		public TerminalNode SET() { return getToken(PstlSqlBaseParser.SET, 0); }
		public TerminalNode RESET() { return getToken(PstlSqlBaseParser.RESET, 0); }
		public TerminalNode VIEW() { return getToken(PstlSqlBaseParser.VIEW, 0); }
		public TerminalNode REPLACE() { return getToken(PstlSqlBaseParser.REPLACE, 0); }
		public TerminalNode IF() { return getToken(PstlSqlBaseParser.IF, 0); }
		public TerminalNode POSITION() { return getToken(PstlSqlBaseParser.POSITION, 0); }
		public TerminalNode NO() { return getToken(PstlSqlBaseParser.NO, 0); }
		public TerminalNode DATA() { return getToken(PstlSqlBaseParser.DATA, 0); }
		public TerminalNode START() { return getToken(PstlSqlBaseParser.START, 0); }
		public TerminalNode TRANSACTION() { return getToken(PstlSqlBaseParser.TRANSACTION, 0); }
		public TerminalNode COMMIT() { return getToken(PstlSqlBaseParser.COMMIT, 0); }
		public TerminalNode ROLLBACK() { return getToken(PstlSqlBaseParser.ROLLBACK, 0); }
		public TerminalNode IGNORE() { return getToken(PstlSqlBaseParser.IGNORE, 0); }
		public TerminalNode SORT() { return getToken(PstlSqlBaseParser.SORT, 0); }
		public TerminalNode CLUSTER() { return getToken(PstlSqlBaseParser.CLUSTER, 0); }
		public TerminalNode DISTRIBUTE() { return getToken(PstlSqlBaseParser.DISTRIBUTE, 0); }
		public TerminalNode UNSET() { return getToken(PstlSqlBaseParser.UNSET, 0); }
		public TerminalNode TBLPROPERTIES() { return getToken(PstlSqlBaseParser.TBLPROPERTIES, 0); }
		public TerminalNode SKEWED() { return getToken(PstlSqlBaseParser.SKEWED, 0); }
		public TerminalNode STORED() { return getToken(PstlSqlBaseParser.STORED, 0); }
		public TerminalNode DIRECTORIES() { return getToken(PstlSqlBaseParser.DIRECTORIES, 0); }
		public TerminalNode LOCATION() { return getToken(PstlSqlBaseParser.LOCATION, 0); }
		public TerminalNode EXCHANGE() { return getToken(PstlSqlBaseParser.EXCHANGE, 0); }
		public TerminalNode ARCHIVE() { return getToken(PstlSqlBaseParser.ARCHIVE, 0); }
		public TerminalNode UNARCHIVE() { return getToken(PstlSqlBaseParser.UNARCHIVE, 0); }
		public TerminalNode FILEFORMAT() { return getToken(PstlSqlBaseParser.FILEFORMAT, 0); }
		public TerminalNode TOUCH() { return getToken(PstlSqlBaseParser.TOUCH, 0); }
		public TerminalNode COMPACT() { return getToken(PstlSqlBaseParser.COMPACT, 0); }
		public TerminalNode CONCATENATE() { return getToken(PstlSqlBaseParser.CONCATENATE, 0); }
		public TerminalNode CHANGE() { return getToken(PstlSqlBaseParser.CHANGE, 0); }
		public TerminalNode CASCADE() { return getToken(PstlSqlBaseParser.CASCADE, 0); }
		public TerminalNode RESTRICT() { return getToken(PstlSqlBaseParser.RESTRICT, 0); }
		public TerminalNode BUCKETS() { return getToken(PstlSqlBaseParser.BUCKETS, 0); }
		public TerminalNode CLUSTERED() { return getToken(PstlSqlBaseParser.CLUSTERED, 0); }
		public TerminalNode SORTED() { return getToken(PstlSqlBaseParser.SORTED, 0); }
		public TerminalNode PURGE() { return getToken(PstlSqlBaseParser.PURGE, 0); }
		public TerminalNode INPUTFORMAT() { return getToken(PstlSqlBaseParser.INPUTFORMAT, 0); }
		public TerminalNode OUTPUTFORMAT() { return getToken(PstlSqlBaseParser.OUTPUTFORMAT, 0); }
		public TerminalNode DBPROPERTIES() { return getToken(PstlSqlBaseParser.DBPROPERTIES, 0); }
		public TerminalNode DFS() { return getToken(PstlSqlBaseParser.DFS, 0); }
		public TerminalNode TRUNCATE() { return getToken(PstlSqlBaseParser.TRUNCATE, 0); }
		public TerminalNode COMPUTE() { return getToken(PstlSqlBaseParser.COMPUTE, 0); }
		public TerminalNode LIST() { return getToken(PstlSqlBaseParser.LIST, 0); }
		public TerminalNode STATISTICS() { return getToken(PstlSqlBaseParser.STATISTICS, 0); }
		public TerminalNode ANALYZE() { return getToken(PstlSqlBaseParser.ANALYZE, 0); }
		public TerminalNode PARTITIONED() { return getToken(PstlSqlBaseParser.PARTITIONED, 0); }
		public TerminalNode EXTERNAL() { return getToken(PstlSqlBaseParser.EXTERNAL, 0); }
		public TerminalNode DEFINED() { return getToken(PstlSqlBaseParser.DEFINED, 0); }
		public TerminalNode RECORDWRITER() { return getToken(PstlSqlBaseParser.RECORDWRITER, 0); }
		public TerminalNode REVOKE() { return getToken(PstlSqlBaseParser.REVOKE, 0); }
		public TerminalNode GRANT() { return getToken(PstlSqlBaseParser.GRANT, 0); }
		public TerminalNode LOCK() { return getToken(PstlSqlBaseParser.LOCK, 0); }
		public TerminalNode UNLOCK() { return getToken(PstlSqlBaseParser.UNLOCK, 0); }
		public TerminalNode MSCK() { return getToken(PstlSqlBaseParser.MSCK, 0); }
		public TerminalNode REPAIR() { return getToken(PstlSqlBaseParser.REPAIR, 0); }
		public TerminalNode RECOVER() { return getToken(PstlSqlBaseParser.RECOVER, 0); }
		public TerminalNode EXPORT() { return getToken(PstlSqlBaseParser.EXPORT, 0); }
		public TerminalNode IMPORT() { return getToken(PstlSqlBaseParser.IMPORT, 0); }
		public TerminalNode LOAD() { return getToken(PstlSqlBaseParser.LOAD, 0); }
		public TerminalNode VALUES() { return getToken(PstlSqlBaseParser.VALUES, 0); }
		public TerminalNode COMMENT() { return getToken(PstlSqlBaseParser.COMMENT, 0); }
		public TerminalNode ROLE() { return getToken(PstlSqlBaseParser.ROLE, 0); }
		public TerminalNode ROLES() { return getToken(PstlSqlBaseParser.ROLES, 0); }
		public TerminalNode COMPACTIONS() { return getToken(PstlSqlBaseParser.COMPACTIONS, 0); }
		public TerminalNode PRINCIPALS() { return getToken(PstlSqlBaseParser.PRINCIPALS, 0); }
		public TerminalNode TRANSACTIONS() { return getToken(PstlSqlBaseParser.TRANSACTIONS, 0); }
		public TerminalNode INDEX() { return getToken(PstlSqlBaseParser.INDEX, 0); }
		public TerminalNode INDEXES() { return getToken(PstlSqlBaseParser.INDEXES, 0); }
		public TerminalNode LOCKS() { return getToken(PstlSqlBaseParser.LOCKS, 0); }
		public TerminalNode OPTION() { return getToken(PstlSqlBaseParser.OPTION, 0); }
		public TerminalNode LOCAL() { return getToken(PstlSqlBaseParser.LOCAL, 0); }
		public TerminalNode INPATH() { return getToken(PstlSqlBaseParser.INPATH, 0); }
		public TerminalNode ASC() { return getToken(PstlSqlBaseParser.ASC, 0); }
		public TerminalNode DESC() { return getToken(PstlSqlBaseParser.DESC, 0); }
		public TerminalNode LIMIT() { return getToken(PstlSqlBaseParser.LIMIT, 0); }
		public TerminalNode RENAME() { return getToken(PstlSqlBaseParser.RENAME, 0); }
		public TerminalNode SETS() { return getToken(PstlSqlBaseParser.SETS, 0); }
		public TerminalNode AT() { return getToken(PstlSqlBaseParser.AT, 0); }
		public TerminalNode NULLS() { return getToken(PstlSqlBaseParser.NULLS, 0); }
		public TerminalNode OVERWRITE() { return getToken(PstlSqlBaseParser.OVERWRITE, 0); }
		public TerminalNode ALL() { return getToken(PstlSqlBaseParser.ALL, 0); }
		public TerminalNode ALTER() { return getToken(PstlSqlBaseParser.ALTER, 0); }
		public TerminalNode AS() { return getToken(PstlSqlBaseParser.AS, 0); }
		public TerminalNode BETWEEN() { return getToken(PstlSqlBaseParser.BETWEEN, 0); }
		public TerminalNode BY() { return getToken(PstlSqlBaseParser.BY, 0); }
		public TerminalNode CREATE() { return getToken(PstlSqlBaseParser.CREATE, 0); }
		public TerminalNode DELETE() { return getToken(PstlSqlBaseParser.DELETE, 0); }
		public TerminalNode DESCRIBE() { return getToken(PstlSqlBaseParser.DESCRIBE, 0); }
		public TerminalNode DROP() { return getToken(PstlSqlBaseParser.DROP, 0); }
		public TerminalNode EXISTS() { return getToken(PstlSqlBaseParser.EXISTS, 0); }
		public TerminalNode FALSE() { return getToken(PstlSqlBaseParser.FALSE, 0); }
		public TerminalNode FOR() { return getToken(PstlSqlBaseParser.FOR, 0); }
		public TerminalNode GROUP() { return getToken(PstlSqlBaseParser.GROUP, 0); }
		public TerminalNode IN() { return getToken(PstlSqlBaseParser.IN, 0); }
		public TerminalNode INSERT() { return getToken(PstlSqlBaseParser.INSERT, 0); }
		public TerminalNode INTO() { return getToken(PstlSqlBaseParser.INTO, 0); }
		public TerminalNode IS() { return getToken(PstlSqlBaseParser.IS, 0); }
		public TerminalNode LIKE() { return getToken(PstlSqlBaseParser.LIKE, 0); }
		public TerminalNode NULL() { return getToken(PstlSqlBaseParser.NULL, 0); }
		public TerminalNode ORDER() { return getToken(PstlSqlBaseParser.ORDER, 0); }
		public TerminalNode OUTER() { return getToken(PstlSqlBaseParser.OUTER, 0); }
		public TerminalNode TABLE() { return getToken(PstlSqlBaseParser.TABLE, 0); }
		public TerminalNode TRUE() { return getToken(PstlSqlBaseParser.TRUE, 0); }
		public TerminalNode WITH() { return getToken(PstlSqlBaseParser.WITH, 0); }
		public TerminalNode RLIKE() { return getToken(PstlSqlBaseParser.RLIKE, 0); }
		public TerminalNode AND() { return getToken(PstlSqlBaseParser.AND, 0); }
		public TerminalNode CASE() { return getToken(PstlSqlBaseParser.CASE, 0); }
		public TerminalNode CAST() { return getToken(PstlSqlBaseParser.CAST, 0); }
		public TerminalNode DISTINCT() { return getToken(PstlSqlBaseParser.DISTINCT, 0); }
		public TerminalNode DIV() { return getToken(PstlSqlBaseParser.DIV, 0); }
		public TerminalNode ELSE() { return getToken(PstlSqlBaseParser.ELSE, 0); }
		public TerminalNode END() { return getToken(PstlSqlBaseParser.END, 0); }
		public TerminalNode FUNCTION() { return getToken(PstlSqlBaseParser.FUNCTION, 0); }
		public TerminalNode INTERVAL() { return getToken(PstlSqlBaseParser.INTERVAL, 0); }
		public TerminalNode MACRO() { return getToken(PstlSqlBaseParser.MACRO, 0); }
		public TerminalNode OR() { return getToken(PstlSqlBaseParser.OR, 0); }
		public TerminalNode STRATIFY() { return getToken(PstlSqlBaseParser.STRATIFY, 0); }
		public TerminalNode THEN() { return getToken(PstlSqlBaseParser.THEN, 0); }
		public TerminalNode UNBOUNDED() { return getToken(PstlSqlBaseParser.UNBOUNDED, 0); }
		public TerminalNode WHEN() { return getToken(PstlSqlBaseParser.WHEN, 0); }
		public TerminalNode DATABASE() { return getToken(PstlSqlBaseParser.DATABASE, 0); }
		public TerminalNode SELECT() { return getToken(PstlSqlBaseParser.SELECT, 0); }
		public TerminalNode FROM() { return getToken(PstlSqlBaseParser.FROM, 0); }
		public TerminalNode WHERE() { return getToken(PstlSqlBaseParser.WHERE, 0); }
		public TerminalNode HAVING() { return getToken(PstlSqlBaseParser.HAVING, 0); }
		public TerminalNode NOT() { return getToken(PstlSqlBaseParser.NOT, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(PstlSqlBaseParser.CURRENT_DATE, 0); }
		public TerminalNode CURRENT_TIMESTAMP() { return getToken(PstlSqlBaseParser.CURRENT_TIMESTAMP, 0); }
		public TerminalNode DIRECTORY() { return getToken(PstlSqlBaseParser.DIRECTORY, 0); }
		public TerminalNode BOTH() { return getToken(PstlSqlBaseParser.BOTH, 0); }
		public TerminalNode LEADING() { return getToken(PstlSqlBaseParser.LEADING, 0); }
		public TerminalNode TRAILING() { return getToken(PstlSqlBaseParser.TRAILING, 0); }
		public NonReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonReserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).enterNonReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PstlSqlBaseListener ) ((PstlSqlBaseListener)listener).exitNonReserved(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PstlSqlBaseVisitor ) return ((PstlSqlBaseVisitor<? extends T>)visitor).visitNonReserved(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonReservedContext nonReserved() throws RecognitionException {
		NonReservedContext _localctx = new NonReservedContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_nonReserved);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1817);
			_la = _input.LA(1);
			if ( !(((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (FROM - 12)) | (1L << (SELECT - 12)) | (1L << (ADD - 12)) | (1L << (AS - 12)) | (1L << (ALL - 12)) | (1L << (DISTINCT - 12)) | (1L << (WHERE - 12)) | (1L << (GROUP - 12)) | (1L << (BY - 12)) | (1L << (GROUPING - 12)) | (1L << (SETS - 12)) | (1L << (CUBE - 12)) | (1L << (ROLLUP - 12)) | (1L << (ORDER - 12)) | (1L << (HAVING - 12)) | (1L << (LIMIT - 12)) | (1L << (AT - 12)) | (1L << (OR - 12)) | (1L << (AND - 12)) | (1L << (IN - 12)) | (1L << (NOT - 12)) | (1L << (NO - 12)) | (1L << (EXISTS - 12)) | (1L << (BETWEEN - 12)) | (1L << (LIKE - 12)) | (1L << (RLIKE - 12)) | (1L << (IS - 12)) | (1L << (NULL - 12)) | (1L << (TRUE - 12)) | (1L << (FALSE - 12)) | (1L << (NULLS - 12)) | (1L << (ASC - 12)) | (1L << (DESC - 12)) | (1L << (FOR - 12)) | (1L << (INTERVAL - 12)) | (1L << (CASE - 12)) | (1L << (WHEN - 12)) | (1L << (THEN - 12)) | (1L << (ELSE - 12)) | (1L << (END - 12)))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (OUTER - 76)) | (1L << (LATERAL - 76)) | (1L << (WINDOW - 76)) | (1L << (OVER - 76)) | (1L << (PARTITION - 76)) | (1L << (RANGE - 76)) | (1L << (ROWS - 76)) | (1L << (UNBOUNDED - 76)) | (1L << (PRECEDING - 76)) | (1L << (FOLLOWING - 76)) | (1L << (CURRENT - 76)) | (1L << (FIRST - 76)) | (1L << (AFTER - 76)) | (1L << (LAST - 76)) | (1L << (ROW - 76)) | (1L << (WITH - 76)) | (1L << (VALUES - 76)) | (1L << (CREATE - 76)) | (1L << (TABLE - 76)) | (1L << (DIRECTORY - 76)) | (1L << (VIEW - 76)) | (1L << (REPLACE - 76)) | (1L << (INSERT - 76)) | (1L << (DELETE - 76)) | (1L << (INTO - 76)) | (1L << (DESCRIBE - 76)) | (1L << (EXPLAIN - 76)) | (1L << (FORMAT - 76)) | (1L << (LOGICAL - 76)) | (1L << (CODEGEN - 76)) | (1L << (COST - 76)) | (1L << (CAST - 76)) | (1L << (SHOW - 76)) | (1L << (TABLES - 76)) | (1L << (COLUMNS - 76)) | (1L << (COLUMN - 76)) | (1L << (USE - 76)) | (1L << (PARTITIONS - 76)) | (1L << (FUNCTIONS - 76)) | (1L << (DROP - 76)) | (1L << (TO - 76)) | (1L << (TABLESAMPLE - 76)) | (1L << (STRATIFY - 76)) | (1L << (ALTER - 76)) | (1L << (RENAME - 76)) | (1L << (ARRAY - 76)) | (1L << (MAP - 76)) | (1L << (STRUCT - 76)) | (1L << (COMMENT - 76)) | (1L << (SET - 76)) | (1L << (RESET - 76)) | (1L << (DATA - 76)) | (1L << (START - 76)))) != 0) || ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & ((1L << (TRANSACTION - 140)) | (1L << (COMMIT - 140)) | (1L << (ROLLBACK - 140)) | (1L << (MACRO - 140)) | (1L << (IGNORE - 140)) | (1L << (BOTH - 140)) | (1L << (LEADING - 140)) | (1L << (TRAILING - 140)) | (1L << (IF - 140)) | (1L << (POSITION - 140)) | (1L << (DIV - 140)) | (1L << (PERCENTLIT - 140)) | (1L << (BUCKET - 140)) | (1L << (OUT - 140)) | (1L << (OF - 140)) | (1L << (SORT - 140)) | (1L << (CLUSTER - 140)) | (1L << (DISTRIBUTE - 140)) | (1L << (OVERWRITE - 140)) | (1L << (TRANSFORM - 140)) | (1L << (REDUCE - 140)) | (1L << (SERDE - 140)) | (1L << (SERDEPROPERTIES - 140)) | (1L << (RECORDREADER - 140)) | (1L << (RECORDWRITER - 140)) | (1L << (DELIMITED - 140)) | (1L << (FIELDS - 140)) | (1L << (TERMINATED - 140)) | (1L << (COLLECTION - 140)) | (1L << (ITEMS - 140)) | (1L << (KEYS - 140)) | (1L << (ESCAPED - 140)) | (1L << (LINES - 140)) | (1L << (SEPARATED - 140)) | (1L << (FUNCTION - 140)) | (1L << (EXTENDED - 140)) | (1L << (REFRESH - 140)) | (1L << (CLEAR - 140)) | (1L << (CACHE - 140)) | (1L << (UNCACHE - 140)) | (1L << (LAZY - 140)) | (1L << (FORMATTED - 140)) | (1L << (GLOBAL - 140)) | (1L << (TEMPORARY - 140)) | (1L << (OPTIONS - 140)))) != 0) || ((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & ((1L << (UNSET - 204)) | (1L << (TBLPROPERTIES - 204)) | (1L << (DBPROPERTIES - 204)) | (1L << (BUCKETS - 204)) | (1L << (SKEWED - 204)) | (1L << (STORED - 204)) | (1L << (DIRECTORIES - 204)) | (1L << (LOCATION - 204)) | (1L << (EXCHANGE - 204)) | (1L << (ARCHIVE - 204)) | (1L << (UNARCHIVE - 204)) | (1L << (FILEFORMAT - 204)) | (1L << (TOUCH - 204)) | (1L << (COMPACT - 204)) | (1L << (CONCATENATE - 204)) | (1L << (CHANGE - 204)) | (1L << (CASCADE - 204)) | (1L << (RESTRICT - 204)) | (1L << (CLUSTERED - 204)) | (1L << (SORTED - 204)) | (1L << (PURGE - 204)) | (1L << (INPUTFORMAT - 204)) | (1L << (OUTPUTFORMAT - 204)) | (1L << (DATABASE - 204)) | (1L << (DATABASES - 204)) | (1L << (DFS - 204)) | (1L << (TRUNCATE - 204)) | (1L << (ANALYZE - 204)) | (1L << (COMPUTE - 204)) | (1L << (LIST - 204)) | (1L << (STATISTICS - 204)) | (1L << (PARTITIONED - 204)) | (1L << (EXTERNAL - 204)) | (1L << (DEFINED - 204)) | (1L << (REVOKE - 204)) | (1L << (GRANT - 204)) | (1L << (LOCK - 204)) | (1L << (UNLOCK - 204)) | (1L << (MSCK - 204)) | (1L << (REPAIR - 204)) | (1L << (RECOVER - 204)) | (1L << (EXPORT - 204)) | (1L << (IMPORT - 204)) | (1L << (LOAD - 204)) | (1L << (ROLE - 204)) | (1L << (ROLES - 204)) | (1L << (COMPACTIONS - 204)) | (1L << (PRINCIPALS - 204)) | (1L << (TRANSACTIONS - 204)) | (1L << (INDEX - 204)) | (1L << (INDEXES - 204)) | (1L << (LOCKS - 204)) | (1L << (OPTION - 204)) | (1L << (LOCAL - 204)) | (1L << (INPATH - 204)) | (1L << (CURRENT_DATE - 204)) | (1L << (CURRENT_TIMESTAMP - 204)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 42:
			return queryTerm_sempred((QueryTermContext)_localctx, predIndex);
		case 74:
			return booleanExpression_sempred((BooleanExpressionContext)_localctx, predIndex);
		case 77:
			return valueExpression_sempred((ValueExpressionContext)_localctx, predIndex);
		case 78:
			return primaryExpression_sempred((PrimaryExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean queryTerm_sempred(QueryTermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanExpression_sempred(BooleanExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean valueExpression_sempred(ValueExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean primaryExpression_sempred(PrimaryExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u0118\u071e\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00df\n\3\3\3\3\3\3\3\5\3\u00e4"+
		"\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00ed\n\3\3\3\3\3\5\3\u00f1\n\3\3"+
		"\3\3\3\3\3\5\3\u00f6\n\3\3\3\3\3\3\3\5\3\u00fb\n\3\3\3\3\3\5\3\u00ff\n"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3\u0106\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\5\7\u0114\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u0131\n\20\3\20\3\20\5\20\u0135\n\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u013c\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01b0\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u01b8\n\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01c0\n"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01c9\n\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01d5\n\20\3\21\3\21\5\21\u01d9"+
		"\n\21\3\21\5\21\u01dc\n\21\3\21\3\21\3\21\3\21\5\21\u01e2\n\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u01ec\n\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u01f8\n\23\3\23\3\23\3\23\5\23\u01fd"+
		"\n\23\3\24\3\24\3\24\3\25\5\25\u0203\n\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u020f\n\26\5\26\u0211\n\26\3\26\3\26\3\26\5"+
		"\26\u0216\n\26\3\26\3\26\5\26\u021a\n\26\3\26\3\26\3\26\5\26\u021f\n\26"+
		"\3\26\3\26\3\26\5\26\u0224\n\26\3\26\5\26\u0227\n\26\3\26\3\26\3\26\5"+
		"\26\u022c\n\26\3\26\3\26\5\26\u0230\n\26\3\26\3\26\3\26\5\26\u0235\n\26"+
		"\5\26\u0237\n\26\3\27\3\27\5\27\u023b\n\27\3\30\3\30\3\30\3\30\3\30\7"+
		"\30\u0242\n\30\f\30\16\30\u0245\13\30\3\30\3\30\3\31\3\31\3\31\5\31\u024c"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\5\32\u0253\n\32\3\33\3\33\3\33\7\33\u0258"+
		"\n\33\f\33\16\33\u025b\13\33\3\34\3\34\3\34\3\34\7\34\u0261\n\34\f\34"+
		"\16\34\u0264\13\34\3\35\3\35\5\35\u0268\n\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u0275\n\37\f\37\16\37\u0278\13\37"+
		"\3\37\3\37\3 \3 \5 \u027e\n \3 \5 \u0281\n \3!\3!\3!\7!\u0286\n!\f!\16"+
		"!\u0289\13!\3!\5!\u028c\n!\3\"\3\"\3\"\3\"\5\"\u0292\n\"\3#\3#\3#\3#\7"+
		"#\u0298\n#\f#\16#\u029b\13#\3#\3#\3$\3$\3$\3$\7$\u02a3\n$\f$\16$\u02a6"+
		"\13$\3$\3$\3%\3%\3%\3%\3%\3%\5%\u02b0\n%\3&\3&\3&\3&\3&\5&\u02b7\n&\3"+
		"\'\3\'\3\'\3\'\5\'\u02bd\n\'\3(\3(\3(\3)\5)\u02c3\n)\3)\3)\3)\3)\3)\6"+
		")\u02ca\n)\r)\16)\u02cb\5)\u02ce\n)\3*\3*\3*\3*\3*\7*\u02d5\n*\f*\16*"+
		"\u02d8\13*\5*\u02da\n*\3*\3*\3*\3*\3*\7*\u02e1\n*\f*\16*\u02e4\13*\5*"+
		"\u02e6\n*\3*\3*\3*\3*\3*\7*\u02ed\n*\f*\16*\u02f0\13*\5*\u02f2\n*\3*\3"+
		"*\3*\3*\3*\7*\u02f9\n*\f*\16*\u02fc\13*\5*\u02fe\n*\3*\5*\u0301\n*\3*"+
		"\3*\3*\5*\u0306\n*\5*\u0308\n*\3+\5+\u030b\n+\3+\3+\3+\3,\3,\3,\3,\3,"+
		"\3,\5,\u0316\n,\3,\7,\u0319\n,\f,\16,\u031c\13,\3-\3-\3-\3-\3-\3-\3-\3"+
		"-\5-\u0326\n-\3.\3.\5.\u032a\n.\3.\3.\5.\u032e\n.\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\5/\u033a\n/\3/\5/\u033d\n/\3/\3/\5/\u0341\n/\3/\3/\3/\3/\3"+
		"/\3/\3/\3/\5/\u034b\n/\3/\3/\5/\u034f\n/\5/\u0351\n/\3/\5/\u0354\n/\3"+
		"/\3/\5/\u0358\n/\3/\5/\u035b\n/\3/\3/\5/\u035f\n/\3/\3/\7/\u0363\n/\f"+
		"/\16/\u0366\13/\3/\5/\u0369\n/\3/\3/\5/\u036d\n/\3/\3/\3/\5/\u0372\n/"+
		"\3/\5/\u0375\n/\5/\u0377\n/\3/\7/\u037a\n/\f/\16/\u037d\13/\3/\3/\5/\u0381"+
		"\n/\3/\5/\u0384\n/\3/\3/\5/\u0388\n/\3/\5/\u038b\n/\5/\u038d\n/\3\60\3"+
		"\60\3\60\5\60\u0392\n\60\3\60\7\60\u0395\n\60\f\60\16\60\u0398\13\60\3"+
		"\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u03a2\n\61\f\61\16\61\u03a5"+
		"\13\61\3\61\3\61\5\61\u03a9\n\61\3\62\3\62\3\62\3\62\7\62\u03af\n\62\f"+
		"\62\16\62\u03b2\13\62\3\62\7\62\u03b5\n\62\f\62\16\62\u03b8\13\62\3\63"+
		"\3\63\3\63\3\63\3\63\7\63\u03bf\n\63\f\63\16\63\u03c2\13\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\7\63\u03ce\n\63\f\63\16\63\u03d1"+
		"\13\63\3\63\3\63\5\63\u03d5\n\63\3\64\3\64\3\64\3\64\7\64\u03db\n\64\f"+
		"\64\16\64\u03de\13\64\5\64\u03e0\n\64\3\64\3\64\5\64\u03e4\n\64\3\65\3"+
		"\65\3\65\5\65\u03e9\n\65\3\65\3\65\3\65\3\65\3\65\7\65\u03f0\n\65\f\65"+
		"\16\65\u03f3\13\65\5\65\u03f5\n\65\3\65\3\65\3\65\5\65\u03fa\n\65\3\65"+
		"\3\65\3\65\7\65\u03ff\n\65\f\65\16\65\u0402\13\65\5\65\u0404\n\65\3\66"+
		"\3\66\3\67\3\67\7\67\u040a\n\67\f\67\16\67\u040d\13\67\38\38\38\38\58"+
		"\u0413\n8\38\38\38\38\38\58\u041a\n8\39\59\u041d\n9\39\39\39\59\u0422"+
		"\n9\39\39\39\39\59\u0428\n9\39\39\59\u042c\n9\39\59\u042f\n9\39\59\u0432"+
		"\n9\3:\3:\3:\3:\3:\3:\3:\7:\u043b\n:\f:\16:\u043e\13:\3:\3:\5:\u0442\n"+
		":\3;\3;\3;\5;\u0447\n;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3;\3"+
		";\3;\5;\u045a\n;\5;\u045c\n;\5;\u045e\n;\3;\3;\3<\3<\3<\3<\3=\3=\3=\7"+
		"=\u0469\n=\f=\16=\u046c\13=\3>\3>\3>\3>\7>\u0472\n>\f>\16>\u0475\13>\3"+
		">\3>\3?\3?\5?\u047b\n?\3@\3@\3@\3@\7@\u0481\n@\f@\16@\u0484\13@\3@\3@"+
		"\3A\3A\3A\5A\u048b\nA\3B\3B\5B\u048f\nB\3B\3B\3B\3B\3B\3B\5B\u0497\nB"+
		"\3B\3B\3B\3B\3B\3B\5B\u049f\nB\3B\3B\3B\3B\5B\u04a5\nB\3C\3C\3C\3C\7C"+
		"\u04ab\nC\fC\16C\u04ae\13C\3C\3C\3D\3D\3D\3D\3D\7D\u04b7\nD\fD\16D\u04ba"+
		"\13D\5D\u04bc\nD\3D\3D\3D\3E\5E\u04c2\nE\3E\3E\5E\u04c6\nE\5E\u04c8\n"+
		"E\3F\3F\3F\3F\3F\3F\3F\5F\u04d1\nF\3F\3F\3F\3F\3F\3F\3F\3F\3F\3F\5F\u04dd"+
		"\nF\5F\u04df\nF\3F\3F\3F\3F\3F\5F\u04e6\nF\3F\3F\3F\3F\3F\5F\u04ed\nF"+
		"\3F\3F\3F\3F\5F\u04f3\nF\3F\3F\3F\3F\5F\u04f9\nF\5F\u04fb\nF\3G\3G\3G"+
		"\5G\u0500\nG\3G\3G\3H\3H\3H\5H\u0507\nH\3H\3H\3I\3I\5I\u050d\nI\3I\3I"+
		"\5I\u0511\nI\5I\u0513\nI\3J\3J\3J\7J\u0518\nJ\fJ\16J\u051b\13J\3K\3K\3"+
		"L\3L\3L\3L\3L\3L\3L\3L\3L\5L\u0528\nL\3L\3L\3L\3L\3L\3L\7L\u0530\nL\f"+
		"L\16L\u0533\13L\3M\3M\5M\u0537\nM\3N\5N\u053a\nN\3N\3N\3N\3N\3N\3N\5N"+
		"\u0542\nN\3N\3N\3N\3N\3N\7N\u0549\nN\fN\16N\u054c\13N\3N\3N\3N\5N\u0551"+
		"\nN\3N\3N\3N\3N\3N\3N\5N\u0559\nN\3N\3N\3N\3N\5N\u055f\nN\3N\3N\3N\5N"+
		"\u0564\nN\3N\3N\3N\5N\u0569\nN\3O\3O\3O\3O\5O\u056f\nO\3O\3O\3O\3O\3O"+
		"\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\7O\u0584\nO\fO\16O\u0587\13"+
		"O\3P\3P\3P\3P\6P\u058d\nP\rP\16P\u058e\3P\3P\5P\u0593\nP\3P\3P\3P\3P\3"+
		"P\6P\u059a\nP\rP\16P\u059b\3P\3P\5P\u05a0\nP\3P\3P\3P\3P\3P\3P\3P\3P\3"+
		"P\3P\3P\3P\3P\3P\7P\u05b0\nP\fP\16P\u05b3\13P\5P\u05b5\nP\3P\3P\3P\3P"+
		"\3P\3P\5P\u05bd\nP\3P\3P\3P\3P\3P\3P\3P\5P\u05c6\nP\3P\3P\3P\3P\3P\3P"+
		"\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\6P\u05db\nP\rP\16P\u05dc\3P\3"+
		"P\3P\3P\3P\3P\3P\3P\3P\5P\u05e8\nP\3P\3P\3P\7P\u05ed\nP\fP\16P\u05f0\13"+
		"P\5P\u05f2\nP\3P\3P\3P\5P\u05f7\nP\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3P\3"+
		"P\3P\5P\u0606\nP\3P\3P\3P\3P\3P\3P\3P\3P\7P\u0610\nP\fP\16P\u0613\13P"+
		"\3Q\3Q\3Q\3Q\3Q\3Q\3Q\3Q\6Q\u061d\nQ\rQ\16Q\u061e\5Q\u0621\nQ\3R\3R\3"+
		"S\3S\3T\3T\3U\3U\3V\3V\7V\u062d\nV\fV\16V\u0630\13V\3W\3W\3W\3W\5W\u0636"+
		"\nW\3X\5X\u0639\nX\3X\3X\5X\u063d\nX\3Y\3Y\3Y\5Y\u0642\nY\3Z\3Z\3Z\3Z"+
		"\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\5Z\u0653\nZ\3Z\3Z\5Z\u0657\nZ\3Z\3Z"+
		"\3Z\3Z\3Z\7Z\u065e\nZ\fZ\16Z\u0661\13Z\3Z\5Z\u0664\nZ\5Z\u0666\nZ\3[\3"+
		"[\3[\7[\u066b\n[\f[\16[\u066e\13[\3\\\3\\\3\\\3\\\5\\\u0674\n\\\3]\3]"+
		"\3]\7]\u0679\n]\f]\16]\u067c\13]\3^\3^\3^\3^\3^\5^\u0683\n^\3_\3_\3_\3"+
		"_\3_\3`\3`\3`\3`\7`\u068e\n`\f`\16`\u0691\13`\3a\3a\3a\3a\3b\3b\3b\3b"+
		"\3b\3b\3b\7b\u069e\nb\fb\16b\u06a1\13b\3b\3b\3b\3b\3b\7b\u06a8\nb\fb\16"+
		"b\u06ab\13b\5b\u06ad\nb\3b\3b\3b\3b\3b\7b\u06b4\nb\fb\16b\u06b7\13b\5"+
		"b\u06b9\nb\5b\u06bb\nb\3b\5b\u06be\nb\3b\5b\u06c1\nb\3c\3c\3c\3c\3c\3"+
		"c\3c\3c\3c\3c\3c\3c\3c\3c\3c\3c\5c\u06d3\nc\3d\3d\3d\3d\3d\3d\3d\5d\u06dc"+
		"\nd\3e\3e\3e\7e\u06e1\ne\fe\16e\u06e4\13e\3f\3f\3f\3f\3f\3f\3f\3f\3f\3"+
		"f\3f\3f\3f\3f\3f\5f\u06f5\nf\3g\3g\3g\5g\u06fa\ng\3h\3h\3i\5i\u06ff\n"+
		"i\3i\3i\5i\u0703\ni\3i\3i\5i\u0707\ni\3i\3i\5i\u070b\ni\3i\3i\5i\u070f"+
		"\ni\3i\3i\5i\u0713\ni\3i\3i\5i\u0717\ni\3i\5i\u071a\ni\3j\3j\3j\2\6V\u0096"+
		"\u009c\u009ek\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8"+
		"\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0"+
		"\u00d2\2\30\3\2\35$\4\2\f\r\32\32\3\2}\u0080\3\2CD\4\2``bb\3\2()\3\2\u010d"+
		"\u010e\3\2<=\4\2\u00a0\u00a1\u00a6\u00a6\3\2\u00a2\u00a5\4\2\u00a0\u00a1"+
		"\u00a9\u00a9\3\2\u0106\u0107\3\2\u0093\u0095\3\2\u0098\u009f\3\2\u00a0"+
		"\u00aa\3\2\658\3\2@A\3\2\u00a0\u00a1\4\2YY\u00b1\u00b1\4\2\61\61\u00af"+
		"\u00af\3\2]^\13\2\16\16%KNNV|\u0081\u0097\u00a5\u00a5\u00ab\u00b4\u00b6"+
		"\u0102\u0104\u0107\2\u080e\2\u00d4\3\2\2\2\4\u0105\3\2\2\2\6\u0107\3\2"+
		"\2\2\b\u010a\3\2\2\2\n\u010d\3\2\2\2\f\u0113\3\2\2\2\16\u0115\3\2\2\2"+
		"\20\u0117\3\2\2\2\22\u0119\3\2\2\2\24\u011b\3\2\2\2\26\u011e\3\2\2\2\30"+
		"\u0121\3\2\2\2\32\u0124\3\2\2\2\34\u0127\3\2\2\2\36\u01d4\3\2\2\2 \u01d6"+
		"\3\2\2\2\"\u01e5\3\2\2\2$\u01f1\3\2\2\2&\u01fe\3\2\2\2(\u0202\3\2\2\2"+
		"*\u0236\3\2\2\2,\u0238\3\2\2\2.\u023c\3\2\2\2\60\u0248\3\2\2\2\62\u0252"+
		"\3\2\2\2\64\u0254\3\2\2\2\66\u025c\3\2\2\28\u0265\3\2\2\2:\u026d\3\2\2"+
		"\2<\u0270\3\2\2\2>\u027b\3\2\2\2@\u028b\3\2\2\2B\u0291\3\2\2\2D\u0293"+
		"\3\2\2\2F\u029e\3\2\2\2H\u02af\3\2\2\2J\u02b6\3\2\2\2L\u02b8\3\2\2\2N"+
		"\u02be\3\2\2\2P\u02cd\3\2\2\2R\u02d9\3\2\2\2T\u030a\3\2\2\2V\u030f\3\2"+
		"\2\2X\u0325\3\2\2\2Z\u0327\3\2\2\2\\\u038c\3\2\2\2^\u038e\3\2\2\2`\u03a8"+
		"\3\2\2\2b\u03aa\3\2\2\2d\u03b9\3\2\2\2f\u03e3\3\2\2\2h\u03e5\3\2\2\2j"+
		"\u0405\3\2\2\2l\u0407\3\2\2\2n\u0419\3\2\2\2p\u0431\3\2\2\2r\u0441\3\2"+
		"\2\2t\u0443\3\2\2\2v\u0461\3\2\2\2x\u0465\3\2\2\2z\u046d\3\2\2\2|\u0478"+
		"\3\2\2\2~\u047c\3\2\2\2\u0080\u0487\3\2\2\2\u0082\u04a4\3\2\2\2\u0084"+
		"\u04a6\3\2\2\2\u0086\u04b1\3\2\2\2\u0088\u04c7\3\2\2\2\u008a\u04fa\3\2"+
		"\2\2\u008c\u04ff\3\2\2\2\u008e\u0506\3\2\2\2\u0090\u050a\3\2\2\2\u0092"+
		"\u0514\3\2\2\2\u0094\u051c\3\2\2\2\u0096\u0527\3\2\2\2\u0098\u0534\3\2"+
		"\2\2\u009a\u0568\3\2\2\2\u009c\u056e\3\2\2\2\u009e\u0605\3\2\2\2\u00a0"+
		"\u0620\3\2\2\2\u00a2\u0622\3\2\2\2\u00a4\u0624\3\2\2\2\u00a6\u0626\3\2"+
		"\2\2\u00a8\u0628\3\2\2\2\u00aa\u062a\3\2\2\2\u00ac\u0631\3\2\2\2\u00ae"+
		"\u063c\3\2\2\2\u00b0\u0641\3\2\2\2\u00b2\u0665\3\2\2\2\u00b4\u0667\3\2"+
		"\2\2\u00b6\u066f\3\2\2\2\u00b8\u0675\3\2\2\2\u00ba\u067d\3\2\2\2\u00bc"+
		"\u0684\3\2\2\2\u00be\u0689\3\2\2\2\u00c0\u0692\3\2\2\2\u00c2\u06c0\3\2"+
		"\2\2\u00c4\u06d2\3\2\2\2\u00c6\u06db\3\2\2\2\u00c8\u06dd\3\2\2\2\u00ca"+
		"\u06f4\3\2\2\2\u00cc\u06f9\3\2\2\2\u00ce\u06fb\3\2\2\2\u00d0\u0719\3\2"+
		"\2\2\u00d2\u071b\3\2\2\2\u00d4\u00d5\5\4\3\2\u00d5\u00d6\7\2\2\3\u00d6"+
		"\3\3\2\2\2\u00d7\u00d8\7f\2\2\u00d8\u00d9\7\24\2\2\u00d9\u00de\5\u008c"+
		"G\2\u00da\u00db\7\3\2\2\u00db\u00dc\5\u00b4[\2\u00dc\u00dd\7\4\2\2\u00dd"+
		"\u00df\3\2\2\2\u00de\u00da\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2"+
		"\2\2\u00e0\u00e3\5\6\4\2\u00e1\u00e2\7\u00cd\2\2\u00e2\u00e4\5<\37\2\u00e3"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u0106\3\2\2\2\u00e5\u00e6\7\22"+
		"\2\2\u00e6\u00e7\7\24\2\2\u00e7\u00e8\5\u008cG\2\u00e8\u00ec\5\b\5\2\u00e9"+
		"\u00ea\7\17\2\2\u00ea\u00eb\7,\2\2\u00eb\u00ed\5\u00c8e\2\u00ec\u00e9"+
		"\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ef\7\26\2\2"+
		"\u00ef\u00f1\5\n\6\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f5"+
		"\3\2\2\2\u00f2\u00f3\7\20\2\2\u00f3\u00f4\7\21\2\2\u00f4\u00f6\5\22\n"+
		"\2\u00f5\u00f2\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00fa\3\2\2\2\u00f7\u00f8"+
		"\7\u00ed\2\2\u00f8\u00f9\7U\2\2\u00f9\u00fb\5v<\2\u00fa\u00f7\3\2\2\2"+
		"\u00fa\u00fb\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fd\7\u00cd\2\2\u00fd"+
		"\u00ff\5<\37\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0106\3\2"+
		"\2\2\u0100\u0101\7\23\2\2\u0101\u0102\7\24\2\2\u0102\u0106\5\u00c8e\2"+
		"\u0103\u0104\7u\2\2\u0104\u0106\7\25\2\2\u0105\u00d7\3\2\2\2\u0105\u00e5"+
		"\3\2\2\2\u0105\u0100\3\2\2\2\u0105\u0103\3\2\2\2\u0106\5\3\2\2\2\u0107"+
		"\u0108\7\16\2\2\u0108\u0109\5\u00c8e\2\u0109\7\3\2\2\2\u010a\u010b\7\u0081"+
		"\2\2\u010b\u010c\5\u00c8e\2\u010c\t\3\2\2\2\u010d\u010e\5\f\7\2\u010e"+
		"\13\3\2\2\2\u010f\u0110\5\16\b\2\u0110\u0111\5\20\t\2\u0111\u0114\3\2"+
		"\2\2\u0112\u0114\7\27\2\2\u0113\u010f\3\2\2\2\u0113\u0112\3\2\2\2\u0114"+
		"\r\3\2\2\2\u0115\u0116\7\u010d\2\2\u0116\17\3\2\2\2\u0117\u0118\t\2\2"+
		"\2\u0118\21\3\2\2\2\u0119\u011a\t\3\2\2\u011a\23\3\2\2\2\u011b\u011c\5"+
		"\u0090I\2\u011c\u011d\7\2\2\3\u011d\25\3\2\2\2\u011e\u011f\5\u008cG\2"+
		"\u011f\u0120\7\2\2\3\u0120\27\3\2\2\2\u0121\u0122\5\u008eH\2\u0122\u0123"+
		"\7\2\2\3\u0123\31\3\2\2\2\u0124\u0125\5\u00b2Z\2\u0125\u0126\7\2\2\3\u0126"+
		"\33\3\2\2\2\u0127\u0128\5\u00b4[\2\u0128\u0129\7\2\2\3\u0129\35\3\2\2"+
		"\2\u012a\u012b\7f\2\2\u012b\u01d5\7\u00fa\2\2\u012c\u012d\7|\2\2\u012d"+
		"\u01d5\7\u00fa\2\2\u012e\u0130\7\u00f1\2\2\u012f\u0131\7\u00fa\2\2\u0130"+
		"\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u01d5\3\2\2\2\u0132\u0134\7\u00f0"+
		"\2\2\u0133\u0135\7\u00fa\2\2\u0134\u0133\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u01d5\3\2\2\2\u0136\u0137\7u\2\2\u0137\u01d5\7\u00f1\2\2\u0138\u0139"+
		"\7u\2\2\u0139\u013b\7\u00fa\2\2\u013a\u013c\7\u00f1\2\2\u013b\u013a\3"+
		"\2\2\2\u013b\u013c\3\2\2\2\u013c\u01d5\3\2\2\2\u013d\u013e\7u\2\2\u013e"+
		"\u01d5\7\u00fd\2\2\u013f\u0140\7u\2\2\u0140\u01d5\7\u00fb\2\2\u0141\u0142"+
		"\7u\2\2\u0142\u0143\7_\2\2\u0143\u01d5\7\u00fb\2\2\u0144\u0145\7\u00f7"+
		"\2\2\u0145\u01d5\7g\2\2\u0146\u0147\7\u00f8\2\2\u0147\u01d5\7g\2\2\u0148"+
		"\u0149\7u\2\2\u0149\u01d5\7\u00fc\2\2\u014a\u014b\7u\2\2\u014b\u014c\7"+
		"f\2\2\u014c\u01d5\7g\2\2\u014d\u014e\7u\2\2\u014e\u01d5\7\u00fe\2\2\u014f"+
		"\u0150\7u\2\2\u0150\u01d5\7\u0100\2\2\u0151\u0152\7u\2\2\u0152\u01d5\7"+
		"\u0101\2\2\u0153\u0154\7f\2\2\u0154\u01d5\7\u00ff\2\2\u0155\u0156\7|\2"+
		"\2\u0156\u01d5\7\u00ff\2\2\u0157\u0158\7\u0084\2\2\u0158\u01d5\7\u00ff"+
		"\2\2\u0159\u015a\7\u00f2\2\2\u015a\u01d5\7g\2\2\u015b\u015c\7\u00f2\2"+
		"\2\u015c\u01d5\7\u00e5\2\2\u015d\u015e\7\u00f3\2\2\u015e\u01d5\7g\2\2"+
		"\u015f\u0160\7\u00f3\2\2\u0160\u01d5\7\u00e5\2\2\u0161\u0162\7f\2\2\u0162"+
		"\u0163\7\u00cc\2\2\u0163\u01d5\7\u0091\2\2\u0164\u0165\7|\2\2\u0165\u0166"+
		"\7\u00cc\2\2\u0166\u01d5\7\u0091\2\2\u0167\u0168\7\u0084\2\2\u0168\u0169"+
		"\7g\2\2\u0169\u016a\5\u008cG\2\u016a\u016b\78\2\2\u016b\u016c\7\u00e0"+
		"\2\2\u016c\u01d5\3\2\2\2\u016d\u016e\7\u0084\2\2\u016e\u016f\7g\2\2\u016f"+
		"\u0170\5\u008cG\2\u0170\u0171\7\u00e0\2\2\u0171\u0172\7,\2\2\u0172\u01d5"+
		"\3\2\2\2\u0173\u0174\7\u0084\2\2\u0174\u0175\7g\2\2\u0175\u0176\5\u008c"+
		"G\2\u0176\u0177\78\2\2\u0177\u0178\7\u00e1\2\2\u0178\u01d5\3\2\2\2\u0179"+
		"\u017a\7\u0084\2\2\u017a\u017b\7g\2\2\u017b\u017c\5\u008cG\2\u017c\u017d"+
		"\7\u00d2\2\2\u017d\u017e\7,\2\2\u017e\u01d5\3\2\2\2\u017f\u0180\7\u0084"+
		"\2\2\u0180\u0181\7g\2\2\u0181\u0182\5\u008cG\2\u0182\u0183\78\2\2\u0183"+
		"\u0184\7\u00d2\2\2\u0184\u01d5\3\2\2\2\u0185\u0186\7\u0084\2\2\u0186\u0187"+
		"\7g\2\2\u0187\u0188\5\u008cG\2\u0188\u0189\78\2\2\u0189\u018a\7\u00d3"+
		"\2\2\u018a\u018b\7\'\2\2\u018b\u018c\7\u00d4\2\2\u018c\u01d5\3\2\2\2\u018d"+
		"\u018e\7\u0084\2\2\u018e\u018f\7g\2\2\u018f\u0190\5\u008cG\2\u0190\u0191"+
		"\7\u008a\2\2\u0191\u0192\7\u00d2\2\2\u0192\u0193\7\u00d5\2\2\u0193\u01d5"+
		"\3\2\2\2\u0194\u0195\7\u0084\2\2\u0195\u0196\7g\2\2\u0196\u0197\5\u008c"+
		"G\2\u0197\u0198\7\u00d6\2\2\u0198\u0199\7Y\2\2\u0199\u01d5\3\2\2\2\u019a"+
		"\u019b\7\u0084\2\2\u019b\u019c\7g\2\2\u019c\u019d\5\u008cG\2\u019d\u019e"+
		"\7\u00d7\2\2\u019e\u019f\7Y\2\2\u019f\u01d5\3\2\2\2\u01a0\u01a1\7\u0084"+
		"\2\2\u01a1\u01a2\7g\2\2\u01a2\u01a3\5\u008cG\2\u01a3\u01a4\7\u00d8\2\2"+
		"\u01a4\u01a5\7Y\2\2\u01a5\u01d5\3\2\2\2\u01a6\u01a7\7\u0084\2\2\u01a7"+
		"\u01a8\7g\2\2\u01a8\u01a9\5\u008cG\2\u01a9\u01aa\7\u00da\2\2\u01aa\u01d5"+
		"\3\2\2\2\u01ab\u01ac\7\u0084\2\2\u01ac\u01ad\7g\2\2\u01ad\u01af\5\u008c"+
		"G\2\u01ae\u01b0\5.\30\2\u01af\u01ae\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\u01b1\3\2\2\2\u01b1\u01b2\7\u00db\2\2\u01b2\u01d5\3\2\2\2\u01b3\u01b4"+
		"\7\u0084\2\2\u01b4\u01b5\7g\2\2\u01b5\u01b7\5\u008cG\2\u01b6\u01b8\5."+
		"\30\2\u01b7\u01b6\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9"+
		"\u01ba\7\u00dc\2\2\u01ba\u01d5\3\2\2\2\u01bb\u01bc\7\u0084\2\2\u01bc\u01bd"+
		"\7g\2\2\u01bd\u01bf\5\u008cG\2\u01be\u01c0\5.\30\2\u01bf\u01be\3\2\2\2"+
		"\u01bf\u01c0\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\7\u008a\2\2\u01c2"+
		"\u01c3\7\u00d9\2\2\u01c3\u01d5\3\2\2\2\u01c4\u01c5\7\u0084\2\2\u01c5\u01c6"+
		"\7g\2\2\u01c6\u01c8\5\u008cG\2\u01c7\u01c9\5.\30\2\u01c8\u01c7\3\2\2\2"+
		"\u01c8\u01c9\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\7j\2\2\u01cb\u01cc"+
		"\7w\2\2\u01cc\u01d5\3\2\2\2\u01cd\u01ce\7\u008d\2\2\u01ce\u01d5\7\u008e"+
		"\2\2\u01cf\u01d5\7\u008f\2\2\u01d0\u01d5\7\u0090\2\2\u01d1\u01d5\7\u00e7"+
		"\2\2\u01d2\u01d3\7l\2\2\u01d3\u01d5\7\16\2\2\u01d4\u012a\3\2\2\2\u01d4"+
		"\u012c\3\2\2\2\u01d4\u012e\3\2\2\2\u01d4\u0132\3\2\2\2\u01d4\u0136\3\2"+
		"\2\2\u01d4\u0138\3\2\2\2\u01d4\u013d\3\2\2\2\u01d4\u013f\3\2\2\2\u01d4"+
		"\u0141\3\2\2\2\u01d4\u0144\3\2\2\2\u01d4\u0146\3\2\2\2\u01d4\u0148\3\2"+
		"\2\2\u01d4\u014a\3\2\2\2\u01d4\u014d\3\2\2\2\u01d4\u014f\3\2\2\2\u01d4"+
		"\u0151\3\2\2\2\u01d4\u0153\3\2\2\2\u01d4\u0155\3\2\2\2\u01d4\u0157\3\2"+
		"\2\2\u01d4\u0159\3\2\2\2\u01d4\u015b\3\2\2\2\u01d4\u015d\3\2\2\2\u01d4"+
		"\u015f\3\2\2\2\u01d4\u0161\3\2\2\2\u01d4\u0164\3\2\2\2\u01d4\u0167\3\2"+
		"\2\2\u01d4\u016d\3\2\2\2\u01d4\u0173\3\2\2\2\u01d4\u0179\3\2\2\2\u01d4"+
		"\u017f\3\2\2\2\u01d4\u0185\3\2\2\2\u01d4\u018d\3\2\2\2\u01d4\u0194\3\2"+
		"\2\2\u01d4\u019a\3\2\2\2\u01d4\u01a0\3\2\2\2\u01d4\u01a6\3\2\2\2\u01d4"+
		"\u01ab\3\2\2\2\u01d4\u01b3\3\2\2\2\u01d4\u01bb\3\2\2\2\u01d4\u01c4\3\2"+
		"\2\2\u01d4\u01cd\3\2\2\2\u01d4\u01cf\3\2\2\2\u01d4\u01d0\3\2\2\2\u01d4"+
		"\u01d1\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\37\3\2\2\2\u01d6\u01d8\7f\2\2"+
		"\u01d7\u01d9\7\u00cc\2\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"\u01db\3\2\2\2\u01da\u01dc\7\u00ee\2\2\u01db\u01da\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01e1\7g\2\2\u01de\u01df\7\u0096\2"+
		"\2\u01df\u01e0\78\2\2\u01e0\u01e2\7:\2\2\u01e1\u01de\3\2\2\2\u01e1\u01e2"+
		"\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4\5\u008cG\2\u01e4!\3\2\2\2\u01e5"+
		"\u01e6\7\u00e0\2\2\u01e6\u01e7\7,\2\2\u01e7\u01eb\5v<\2\u01e8\u01e9\7"+
		"\u00e1\2\2\u01e9\u01ea\7,\2\2\u01ea\u01ec\5z>\2\u01eb\u01e8\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\7m\2\2\u01ee\u01ef\7\u010d"+
		"\2\2\u01ef\u01f0\7\u00d1\2\2\u01f0#\3\2\2\2\u01f1\u01f2\7\u00d2\2\2\u01f2"+
		"\u01f3\7,\2\2\u01f3\u01f4\5v<\2\u01f4\u01f7\7U\2\2\u01f5\u01f8\5D#\2\u01f6"+
		"\u01f8\5F$\2\u01f7\u01f5\3\2\2\2\u01f7\u01f6\3\2\2\2\u01f8\u01fc\3\2\2"+
		"\2\u01f9\u01fa\7\u00d3\2\2\u01fa\u01fb\7\'\2\2\u01fb\u01fd\7\u00d4\2\2"+
		"\u01fc\u01f9\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd%\3\2\2\2\u01fe\u01ff\7"+
		"\u00d5\2\2\u01ff\u0200\7\u0108\2\2\u0200\'\3\2\2\2\u0201\u0203\5\66\34"+
		"\2\u0202\u0201\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0204\3\2\2\2\u0204\u0205"+
		"\5P)\2\u0205)\3\2\2\2\u0206\u0207\7k\2\2\u0207\u0208\7\u00b2\2\2\u0208"+
		"\u0209\7g\2\2\u0209\u0210\5\u008cG\2\u020a\u020e\5.\30\2\u020b\u020c\7"+
		"\u0096\2\2\u020c\u020d\78\2\2\u020d\u020f\7:\2\2\u020e\u020b\3\2\2\2\u020e"+
		"\u020f\3\2\2\2\u020f\u0211\3\2\2\2\u0210\u020a\3\2\2\2\u0210\u0211\3\2"+
		"\2\2\u0211\u0237\3\2\2\2\u0212\u0213\7k\2\2\u0213\u0215\7m\2\2\u0214\u0216"+
		"\7g\2\2\u0215\u0214\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"\u0219\5\u008cG\2\u0218\u021a\5.\30\2\u0219\u0218\3\2\2\2\u0219\u021a"+
		"\3\2\2\2\u021a\u0237\3\2\2\2\u021b\u021c\7k\2\2\u021c\u021e\7\u00b2\2"+
		"\2\u021d\u021f\7\u0104\2\2\u021e\u021d\3\2\2\2\u021e\u021f\3\2\2\2\u021f"+
		"\u0220\3\2\2\2\u0220\u0221\7h\2\2\u0221\u0223\7\u0108\2\2\u0222\u0224"+
		"\5\u008aF\2\u0223\u0222\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u0226\3\2\2"+
		"\2\u0225\u0227\5H%\2\u0226\u0225\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0237"+
		"\3\2\2\2\u0228\u0229\7k\2\2\u0229\u022b\7\u00b2\2\2\u022a\u022c\7\u0104"+
		"\2\2\u022b\u022a\3\2\2\2\u022b\u022c\3\2\2\2\u022c\u022d\3\2\2\2\u022d"+
		"\u022f\7h\2\2\u022e\u0230\7\u0108\2\2\u022f\u022e\3\2\2\2\u022f\u0230"+
		"\3\2\2\2\u0230\u0231\3\2\2\2\u0231\u0234\5:\36\2\u0232\u0233\7\u00cd\2"+
		"\2\u0233\u0235\5<\37\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0237"+
		"\3\2\2\2\u0236\u0206\3\2\2\2\u0236\u0212\3\2\2\2\u0236\u021b\3\2\2\2\u0236"+
		"\u0228\3\2\2\2\u0237+\3\2\2\2\u0238\u023a\5.\30\2\u0239\u023b\5&\24\2"+
		"\u023a\u0239\3\2\2\2\u023a\u023b\3\2\2\2\u023b-\3\2\2\2\u023c\u023d\7"+
		"Y\2\2\u023d\u023e\7\3\2\2\u023e\u0243\5\60\31\2\u023f\u0240\7\5\2\2\u0240"+
		"\u0242\5\60\31\2\u0241\u023f\3\2\2\2\u0242\u0245\3\2\2\2\u0243\u0241\3"+
		"\2\2\2\u0243\u0244\3\2\2\2\u0244\u0246\3\2\2\2\u0245\u0243\3\2\2\2\u0246"+
		"\u0247\7\4\2\2\u0247/\3\2\2\2\u0248\u024b\5\u00caf\2\u0249\u024a\7\u0098"+
		"\2\2\u024a\u024c\5\u00a0Q\2\u024b\u0249\3\2\2\2\u024b\u024c\3\2\2\2\u024c"+
		"\61\3\2\2\2\u024d\u0253\5\u00c8e\2\u024e\u0253\7\u0108\2\2\u024f\u0253"+
		"\5\u00a2R\2\u0250\u0253\5\u00a4S\2\u0251\u0253\5\u00a6T\2\u0252\u024d"+
		"\3\2\2\2\u0252\u024e\3\2\2\2\u0252\u024f\3\2\2\2\u0252\u0250\3\2\2\2\u0252"+
		"\u0251\3\2\2\2\u0253\63\3\2\2\2\u0254\u0259\5\u00caf\2\u0255\u0256\7\6"+
		"\2\2\u0256\u0258\5\u00caf\2\u0257\u0255\3\2\2\2\u0258\u025b\3\2\2\2\u0259"+
		"\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\65\3\2\2\2\u025b\u0259\3\2\2"+
		"\2\u025c\u025d\7d\2\2\u025d\u0262\58\35\2\u025e\u025f\7\5\2\2\u025f\u0261"+
		"\58\35\2\u0260\u025e\3\2\2\2\u0261\u0264\3\2\2\2\u0262\u0260\3\2\2\2\u0262"+
		"\u0263\3\2\2\2\u0263\67\3\2\2\2\u0264\u0262\3\2\2\2\u0265\u0267\5\u00ca"+
		"f\2\u0266\u0268\7\'\2\2\u0267\u0266\3\2\2\2\u0267\u0268\3\2\2\2\u0268"+
		"\u0269\3\2\2\2\u0269\u026a\7\3\2\2\u026a\u026b\5(\25\2\u026b\u026c\7\4"+
		"\2\2\u026c9\3\2\2\2\u026d\u026e\7\u00b5\2\2\u026e\u026f\5\u00c8e\2\u026f"+
		";\3\2\2\2\u0270\u0271\7\3\2\2\u0271\u0276\5> \2\u0272\u0273\7\5\2\2\u0273"+
		"\u0275\5> \2\u0274\u0272\3\2\2\2\u0275\u0278\3\2\2\2\u0276\u0274\3\2\2"+
		"\2\u0276\u0277\3\2\2\2\u0277\u0279\3\2\2\2\u0278\u0276\3\2\2\2\u0279\u027a"+
		"\7\4\2\2\u027a=\3\2\2\2\u027b\u0280\5@!\2\u027c\u027e\7\u0098\2\2\u027d"+
		"\u027c\3\2\2\2\u027d\u027e\3\2\2\2\u027e\u027f\3\2\2\2\u027f\u0281\5B"+
		"\"\2\u0280\u027d\3\2\2\2\u0280\u0281\3\2\2\2\u0281?\3\2\2\2\u0282\u0287"+
		"\5\u00caf\2\u0283\u0284\7\6\2\2\u0284\u0286\5\u00caf\2\u0285\u0283\3\2"+
		"\2\2\u0286\u0289\3\2\2\2\u0287\u0285\3\2\2\2\u0287\u0288\3\2\2\2\u0288"+
		"\u028c\3\2\2\2\u0289\u0287\3\2\2\2\u028a\u028c\7\u0108\2\2\u028b\u0282"+
		"\3\2\2\2\u028b\u028a\3\2\2\2\u028cA\3\2\2\2\u028d\u0292\7\u010d\2\2\u028e"+
		"\u0292\7\u010e\2\2\u028f\u0292\5\u00a8U\2\u0290\u0292\7\u0108\2\2\u0291"+
		"\u028d\3\2\2\2\u0291\u028e\3\2\2\2\u0291\u028f\3\2\2\2\u0291\u0290\3\2"+
		"\2\2\u0292C\3\2\2\2\u0293\u0294\7\3\2\2\u0294\u0299\5\u00a0Q\2\u0295\u0296"+
		"\7\5\2\2\u0296\u0298\5\u00a0Q\2\u0297\u0295\3\2\2\2\u0298\u029b\3\2\2"+
		"\2\u0299\u0297\3\2\2\2\u0299\u029a\3\2\2\2\u029a\u029c\3\2\2\2\u029b\u0299"+
		"\3\2\2\2\u029c\u029d\7\4\2\2\u029dE\3\2\2\2\u029e\u029f\7\3\2\2\u029f"+
		"\u02a4\5D#\2\u02a0\u02a1\7\5\2\2\u02a1\u02a3\5D#\2\u02a2\u02a0\3\2\2\2"+
		"\u02a3\u02a6\3\2\2\2\u02a4\u02a2\3\2\2\2\u02a4\u02a5\3\2\2\2\u02a5\u02a7"+
		"\3\2\2\2\u02a6\u02a4\3\2\2\2\u02a7\u02a8\7\4\2\2\u02a8G\3\2\2\2\u02a9"+
		"\u02aa\7\u00d3\2\2\u02aa\u02ab\7\'\2\2\u02ab\u02b0\5J&\2\u02ac\u02ad\7"+
		"\u00d3\2\2\u02ad\u02ae\7,\2\2\u02ae\u02b0\5L\'\2\u02af\u02a9\3\2\2\2\u02af"+
		"\u02ac\3\2\2\2\u02b0I\3\2\2\2\u02b1\u02b2\7\u00e3\2\2\u02b2\u02b3\7\u0108"+
		"\2\2\u02b3\u02b4\7\u00e4\2\2\u02b4\u02b7\7\u0108\2\2\u02b5\u02b7\5\u00ca"+
		"f\2\u02b6\u02b1\3\2\2\2\u02b6\u02b5\3\2\2\2\u02b7K\3\2\2\2\u02b8\u02bc"+
		"\7\u0108\2\2\u02b9\u02ba\7d\2\2\u02ba\u02bb\7\u00b7\2\2\u02bb\u02bd\5"+
		"<\37\2\u02bc\u02b9\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bdM\3\2\2\2\u02be\u02bf"+
		"\5\u00caf\2\u02bf\u02c0\7\u0108\2\2\u02c0O\3\2\2\2\u02c1\u02c3\5*\26\2"+
		"\u02c2\u02c1\3\2\2\2\u02c2\u02c3\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c5"+
		"\5V,\2\u02c5\u02c6\5R*\2\u02c6\u02ce\3\2\2\2\u02c7\u02c9\5b\62\2\u02c8"+
		"\u02ca\5T+\2\u02c9\u02c8\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02c9\3\2\2"+
		"\2\u02cb\u02cc\3\2\2\2\u02cc\u02ce\3\2\2\2\u02cd\u02c2\3\2\2\2\u02cd\u02c7"+
		"\3\2\2\2\u02ceQ\3\2\2\2\u02cf\u02d0\7\61\2\2\u02d0\u02d1\7,\2\2\u02d1"+
		"\u02d6\5Z.\2\u02d2\u02d3\7\5\2\2\u02d3\u02d5\5Z.\2\u02d4\u02d2\3\2\2\2"+
		"\u02d5\u02d8\3\2\2\2\u02d6\u02d4\3\2\2\2\u02d6\u02d7\3\2\2\2\u02d7\u02da"+
		"\3\2\2\2\u02d8\u02d6\3\2\2\2\u02d9\u02cf\3\2\2\2\u02d9\u02da\3\2\2\2\u02da"+
		"\u02e5\3\2\2\2\u02db\u02dc\7\u00b0\2\2\u02dc\u02dd\7,\2\2\u02dd\u02e2"+
		"\5\u0094K\2\u02de\u02df\7\5\2\2\u02df\u02e1\5\u0094K\2\u02e0\u02de\3\2"+
		"\2\2\u02e1\u02e4\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3\3\2\2\2\u02e3"+
		"\u02e6\3\2\2\2\u02e4\u02e2\3\2\2\2\u02e5\u02db\3\2\2\2\u02e5\u02e6\3\2"+
		"\2\2\u02e6\u02f1\3\2\2\2\u02e7\u02e8\7\u00b1\2\2\u02e8\u02e9\7,\2\2\u02e9"+
		"\u02ee\5\u0094K\2\u02ea\u02eb\7\5\2\2\u02eb\u02ed\5\u0094K\2\u02ec\u02ea"+
		"\3\2\2\2\u02ed\u02f0\3\2\2\2\u02ee\u02ec\3\2\2\2\u02ee\u02ef\3\2\2\2\u02ef"+
		"\u02f2\3\2\2\2\u02f0\u02ee\3\2\2\2\u02f1\u02e7\3\2\2\2\u02f1\u02f2\3\2"+
		"\2\2\u02f2\u02fd\3\2\2\2\u02f3\u02f4\7\u00af\2\2\u02f4\u02f5\7,\2\2\u02f5"+
		"\u02fa\5Z.\2\u02f6\u02f7\7\5\2\2\u02f7\u02f9\5Z.\2\u02f8\u02f6\3\2\2\2"+
		"\u02f9\u02fc\3\2\2\2\u02fa\u02f8\3\2\2\2\u02fa\u02fb\3\2\2\2\u02fb\u02fe"+
		"\3\2\2\2\u02fc\u02fa\3\2\2\2\u02fd\u02f3\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe"+
		"\u0300\3\2\2\2\u02ff\u0301\5\u00be`\2\u0300\u02ff\3\2\2\2\u0300\u0301"+
		"\3\2\2\2\u0301\u0307\3\2\2\2\u0302\u0305\7\63\2\2\u0303\u0306\7(\2\2\u0304"+
		"\u0306\5\u0094K\2\u0305\u0303\3\2\2\2\u0305\u0304\3\2\2\2\u0306\u0308"+
		"\3\2\2\2\u0307\u0302\3\2\2\2\u0307\u0308\3\2\2\2\u0308S\3\2\2\2\u0309"+
		"\u030b\5*\26\2\u030a\u0309\3\2\2\2\u030a\u030b\3\2\2\2\u030b\u030c\3\2"+
		"\2\2\u030c\u030d\5\\/\2\u030d\u030e\5R*\2\u030eU\3\2\2\2\u030f\u0310\b"+
		",\1\2\u0310\u0311\5X-\2\u0311\u031a\3\2\2\2\u0312\u0313\f\3\2\2\u0313"+
		"\u0315\t\4\2\2\u0314\u0316\5j\66\2\u0315\u0314\3\2\2\2\u0315\u0316\3\2"+
		"\2\2\u0316\u0317\3\2\2\2\u0317\u0319\5V,\4\u0318\u0312\3\2\2\2\u0319\u031c"+
		"\3\2\2\2\u031a\u0318\3\2\2\2\u031a\u031b\3\2\2\2\u031bW\3\2\2\2\u031c"+
		"\u031a\3\2\2\2\u031d\u0326\5\\/\2\u031e\u031f\7g\2\2\u031f\u0326\5\u008c"+
		"G\2\u0320\u0326\5\u0084C\2\u0321\u0322\7\3\2\2\u0322\u0323\5P)\2\u0323"+
		"\u0324\7\4\2\2\u0324\u0326\3\2\2\2\u0325\u031d\3\2\2\2\u0325\u031e\3\2"+
		"\2\2\u0325\u0320\3\2\2\2\u0325\u0321\3\2\2\2\u0326Y\3\2\2\2\u0327\u0329"+
		"\5\u0094K\2\u0328\u032a\t\5\2\2\u0329\u0328\3\2\2\2\u0329\u032a\3\2\2"+
		"\2\u032a\u032d\3\2\2\2\u032b\u032c\7B\2\2\u032c\u032e\t\6\2\2\u032d\u032b"+
		"\3\2\2\2\u032d\u032e\3\2\2\2\u032e[\3\2\2\2\u032f\u0330\7%\2\2\u0330\u0331"+
		"\7\u00b3\2\2\u0331\u0332\7\3\2\2\u0332\u0333\5\u0092J\2\u0333\u0334\7"+
		"\4\2\2\u0334\u033a\3\2\2\2\u0335\u0336\7\u0087\2\2\u0336\u033a\5\u0092"+
		"J\2\u0337\u0338\7\u00b4\2\2\u0338\u033a\5\u0092J\2\u0339\u032f\3\2\2\2"+
		"\u0339\u0335\3\2\2\2\u0339\u0337\3\2\2\2\u033a\u033c\3\2\2\2\u033b\u033d"+
		"\5\u008aF\2\u033c\u033b\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u0340\3\2\2"+
		"\2\u033e\u033f\7\u00b9\2\2\u033f\u0341\7\u0108\2\2\u0340\u033e\3\2\2\2"+
		"\u0340\u0341\3\2\2\2\u0341\u0342\3\2\2\2\u0342\u0343\7\u00b5\2\2\u0343"+
		"\u0350\7\u0108\2\2\u0344\u034e\7\'\2\2\u0345\u034f\5x=\2\u0346\u034f\5"+
		"\u00b4[\2\u0347\u034a\7\3\2\2\u0348\u034b\5x=\2\u0349\u034b\5\u00b4[\2"+
		"\u034a\u0348\3\2\2\2\u034a\u0349\3\2\2\2\u034b\u034c\3\2\2\2\u034c\u034d"+
		"\7\4\2\2\u034d\u034f\3\2\2\2\u034e\u0345\3\2\2\2\u034e\u0346\3\2\2\2\u034e"+
		"\u0347\3\2\2\2\u034f\u0351\3\2\2\2\u0350\u0344\3\2\2\2\u0350\u0351\3\2"+
		"\2\2\u0351\u0353\3\2\2\2\u0352\u0354\5\u008aF\2\u0353\u0352\3\2\2\2\u0353"+
		"\u0354\3\2\2\2\u0354\u0357\3\2\2\2\u0355\u0356\7\u00b8\2\2\u0356\u0358"+
		"\7\u0108\2\2\u0357\u0355\3\2\2\2\u0357\u0358\3\2\2\2\u0358\u035a\3\2\2"+
		"\2\u0359\u035b\5b\62\2\u035a\u0359\3\2\2\2\u035a\u035b\3\2\2\2\u035b\u035e"+
		"\3\2\2\2\u035c\u035d\7*\2\2\u035d\u035f\5\u0096L\2\u035e\u035c\3\2\2\2"+
		"\u035e\u035f\3\2\2\2\u035f\u038d\3\2\2\2\u0360\u0364\7%\2\2\u0361\u0363"+
		"\5^\60\2\u0362\u0361\3\2\2\2\u0363\u0366\3\2\2\2\u0364\u0362\3\2\2\2\u0364"+
		"\u0365\3\2\2\2\u0365\u0368\3\2\2\2\u0366\u0364\3\2\2\2\u0367\u0369\5j"+
		"\66\2\u0368\u0367\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u036a\3\2\2\2\u036a"+
		"\u036c\5\u0092J\2\u036b\u036d\5b\62\2\u036c\u036b\3\2\2\2\u036c\u036d"+
		"\3\2\2\2\u036d\u0377\3\2\2\2\u036e\u0374\5b\62\2\u036f\u0371\7%\2\2\u0370"+
		"\u0372\5j\66\2\u0371\u0370\3\2\2\2\u0371\u0372\3\2\2\2\u0372\u0373\3\2"+
		"\2\2\u0373\u0375\5\u0092J\2\u0374\u036f\3\2\2\2\u0374\u0375\3\2\2\2\u0375"+
		"\u0377\3\2\2\2\u0376\u0360\3\2\2\2\u0376\u036e\3\2\2\2\u0377\u037b\3\2"+
		"\2\2\u0378\u037a\5h\65\2\u0379\u0378\3\2\2\2\u037a\u037d\3\2\2\2\u037b"+
		"\u0379\3\2\2\2\u037b\u037c\3\2\2\2\u037c\u0380\3\2\2\2\u037d\u037b\3\2"+
		"\2\2\u037e\u037f\7*\2\2\u037f\u0381\5\u0096L\2\u0380\u037e\3\2\2\2\u0380"+
		"\u0381\3\2\2\2\u0381\u0383\3\2\2\2\u0382\u0384\5d\63\2\u0383\u0382\3\2"+
		"\2\2\u0383\u0384\3\2\2\2\u0384\u0387\3\2\2\2\u0385\u0386\7\62\2\2\u0386"+
		"\u0388\5\u0096L\2\u0387\u0385\3\2\2\2\u0387\u0388\3\2\2\2\u0388\u038a"+
		"\3\2\2\2\u0389\u038b\5\u00be`\2\u038a\u0389\3\2\2\2\u038a\u038b\3\2\2"+
		"\2\u038b\u038d\3\2\2\2\u038c\u0339\3\2\2\2\u038c\u0376\3\2\2\2\u038d]"+
		"\3\2\2\2\u038e\u038f\7\7\2\2\u038f\u0396\5`\61\2\u0390\u0392\7\5\2\2\u0391"+
		"\u0390\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u0393\3\2\2\2\u0393\u0395\5`"+
		"\61\2\u0394\u0391\3\2\2\2\u0395\u0398\3\2\2\2\u0396\u0394\3\2\2\2\u0396"+
		"\u0397\3\2\2\2\u0397\u0399\3\2\2\2\u0398\u0396\3\2\2\2\u0399\u039a\7\b"+
		"\2\2\u039a_\3\2\2\2\u039b\u03a9\5\u00caf\2\u039c\u039d\5\u00caf\2\u039d"+
		"\u039e\7\3\2\2\u039e\u03a3\5\u009eP\2\u039f\u03a0\7\5\2\2\u03a0\u03a2"+
		"\5\u009eP\2\u03a1\u039f\3\2\2\2\u03a2\u03a5\3\2\2\2\u03a3\u03a1\3\2\2"+
		"\2\u03a3\u03a4\3\2\2\2\u03a4\u03a6\3\2\2\2\u03a5\u03a3\3\2\2\2\u03a6\u03a7"+
		"\7\4\2\2\u03a7\u03a9\3\2\2\2\u03a8\u039b\3\2\2\2\u03a8\u039c\3\2\2\2\u03a9"+
		"a\3\2\2\2\u03aa\u03ab\7\16\2\2\u03ab\u03b0\5l\67\2\u03ac\u03ad\7\5\2\2"+
		"\u03ad\u03af\5l\67\2\u03ae\u03ac\3\2\2\2\u03af\u03b2\3\2\2\2\u03b0\u03ae"+
		"\3\2\2\2\u03b0\u03b1\3\2\2\2\u03b1\u03b6\3\2\2\2\u03b2\u03b0\3\2\2\2\u03b3"+
		"\u03b5\5h\65\2\u03b4\u03b3\3\2\2\2\u03b5\u03b8\3\2\2\2\u03b6\u03b4\3\2"+
		"\2\2\u03b6\u03b7\3\2\2\2\u03b7c\3\2\2\2\u03b8\u03b6\3\2\2\2\u03b9\u03ba"+
		"\7+\2\2\u03ba\u03bb\7,\2\2\u03bb\u03c0\5\u0094K\2\u03bc\u03bd\7\5\2\2"+
		"\u03bd\u03bf\5\u0094K\2\u03be\u03bc\3\2\2\2\u03bf\u03c2\3\2\2\2\u03c0"+
		"\u03be\3\2\2\2\u03c0\u03c1\3\2\2\2\u03c1\u03d4\3\2\2\2\u03c2\u03c0\3\2"+
		"\2\2\u03c3\u03c4\7d\2\2\u03c4\u03d5\7\60\2\2\u03c5\u03c6\7d\2\2\u03c6"+
		"\u03d5\7/\2\2\u03c7\u03c8\7-\2\2\u03c8\u03c9\7.\2\2\u03c9\u03ca\7\3\2"+
		"\2\u03ca\u03cf\5f\64\2\u03cb\u03cc\7\5\2\2\u03cc\u03ce\5f\64\2\u03cd\u03cb"+
		"\3\2\2\2\u03ce\u03d1\3\2\2\2\u03cf\u03cd\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0"+
		"\u03d2\3\2\2\2\u03d1\u03cf\3\2\2\2\u03d2\u03d3\7\4\2\2\u03d3\u03d5\3\2"+
		"\2\2\u03d4\u03c3\3\2\2\2\u03d4\u03c5\3\2\2\2\u03d4\u03c7\3\2\2\2\u03d4"+
		"\u03d5\3\2\2\2\u03d5e\3\2\2\2\u03d6\u03df\7\3\2\2\u03d7\u03dc\5\u0094"+
		"K\2\u03d8\u03d9\7\5\2\2\u03d9\u03db\5\u0094K\2\u03da\u03d8\3\2\2\2\u03db"+
		"\u03de\3\2\2\2\u03dc\u03da\3\2\2\2\u03dc\u03dd\3\2\2\2\u03dd\u03e0\3\2"+
		"\2\2\u03de\u03dc\3\2\2\2\u03df\u03d7\3\2\2\2\u03df\u03e0\3\2\2\2\u03e0"+
		"\u03e1\3\2\2\2\u03e1\u03e4\7\4\2\2\u03e2\u03e4\5\u0094K\2\u03e3\u03d6"+
		"\3\2\2\2\u03e3\u03e2\3\2\2\2\u03e4g\3\2\2\2\u03e5\u03e6\7V\2\2\u03e6\u03e8"+
		"\7i\2\2\u03e7\u03e9\7N\2\2\u03e8\u03e7\3\2\2\2\u03e8\u03e9\3\2\2\2\u03e9"+
		"\u03ea\3\2\2\2\u03ea\u03eb\5\u00c8e\2\u03eb\u03f4\7\3\2\2\u03ec\u03f1"+
		"\5\u0094K\2\u03ed\u03ee\7\5\2\2\u03ee\u03f0\5\u0094K\2\u03ef\u03ed\3\2"+
		"\2\2\u03f0\u03f3\3\2\2\2\u03f1\u03ef\3\2\2\2\u03f1\u03f2\3\2\2\2\u03f2"+
		"\u03f5\3\2\2\2\u03f3\u03f1\3\2\2\2\u03f4\u03ec\3\2\2\2\u03f4\u03f5\3\2"+
		"\2\2\u03f5\u03f6\3\2\2\2\u03f6\u03f7\7\4\2\2\u03f7\u0403\5\u00caf\2\u03f8"+
		"\u03fa\7\'\2\2\u03f9\u03f8\3\2\2\2\u03f9\u03fa\3\2\2\2\u03fa\u03fb\3\2"+
		"\2\2\u03fb\u0400\5\u00caf\2\u03fc\u03fd\7\5\2\2\u03fd\u03ff\5\u00caf\2"+
		"\u03fe\u03fc\3\2\2\2\u03ff\u0402\3\2\2\2\u0400\u03fe\3\2\2\2\u0400\u0401"+
		"\3\2\2\2\u0401\u0404\3\2\2\2\u0402\u0400\3\2\2\2\u0403\u03f9\3\2\2\2\u0403"+
		"\u0404\3\2\2\2\u0404i\3\2\2\2\u0405\u0406\t\7\2\2\u0406k\3\2\2\2\u0407"+
		"\u040b\5\u0082B\2\u0408\u040a\5n8\2\u0409\u0408\3\2\2\2\u040a\u040d\3"+
		"\2\2\2\u040b\u0409\3\2\2\2\u040b\u040c\3\2\2\2\u040cm\3\2\2\2\u040d\u040b"+
		"\3\2\2\2\u040e\u040f\5p9\2\u040f\u0410\7L\2\2\u0410\u0412\5\u0082B\2\u0411"+
		"\u0413\5r:\2\u0412\u0411\3\2\2\2\u0412\u0413\3\2\2\2\u0413\u041a\3\2\2"+
		"\2\u0414\u0415\7T\2\2\u0415\u0416\5p9\2\u0416\u0417\7L\2\2\u0417\u0418"+
		"\5\u0082B\2\u0418\u041a\3\2\2\2\u0419\u040e\3\2\2\2\u0419\u0414\3\2\2"+
		"\2\u041ao\3\2\2\2\u041b\u041d\7O\2\2\u041c\u041b\3\2\2\2\u041c\u041d\3"+
		"\2\2\2\u041d\u0432\3\2\2\2\u041e\u0432\7M\2\2\u041f\u0421\7P\2\2\u0420"+
		"\u0422\7N\2\2\u0421\u0420\3\2\2\2\u0421\u0422\3\2\2\2\u0422\u0432\3\2"+
		"\2\2\u0423\u0424\7P\2\2\u0424\u0432\7Q\2\2\u0425\u0427\7R\2\2\u0426\u0428"+
		"\7N\2\2\u0427\u0426\3\2\2\2\u0427\u0428\3\2\2\2\u0428\u0432\3\2\2\2\u0429"+
		"\u042b\7S\2\2\u042a\u042c\7N\2\2\u042b\u042a\3\2\2\2\u042b\u042c\3\2\2"+
		"\2\u042c\u0432\3\2\2\2\u042d\u042f\7P\2\2\u042e\u042d\3\2\2\2\u042e\u042f"+
		"\3\2\2\2\u042f\u0430\3\2\2\2\u0430\u0432\7\u0103\2\2\u0431\u041c\3\2\2"+
		"\2\u0431\u041e\3\2\2\2\u0431\u041f\3\2\2\2\u0431\u0423\3\2\2\2\u0431\u0425"+
		"\3\2\2\2\u0431\u0429\3\2\2\2\u0431\u042e\3\2\2\2\u0432q\3\2\2\2\u0433"+
		"\u0434\7U\2\2\u0434\u0442\5\u0096L\2\u0435\u0436\7\u00b5\2\2\u0436\u0437"+
		"\7\3\2\2\u0437\u043c\5\u00caf\2\u0438\u0439\7\5\2\2\u0439\u043b\5\u00ca"+
		"f\2\u043a\u0438\3\2\2\2\u043b\u043e\3\2\2\2\u043c\u043a\3\2\2\2\u043c"+
		"\u043d\3\2\2\2\u043d\u043f\3\2\2\2\u043e\u043c\3\2\2\2\u043f\u0440\7\4"+
		"\2\2\u0440\u0442\3\2\2\2\u0441\u0433\3\2\2\2\u0441\u0435\3\2\2\2\u0442"+
		"s\3\2\2\2\u0443\u0444\7\u0082\2\2\u0444\u045d\7\3\2\2\u0445\u0447\7\u00a1"+
		"\2\2\u0446\u0445\3\2\2\2\u0446\u0447\3\2\2\2\u0447\u0448\3\2\2\2\u0448"+
		"\u0449\t\b\2\2\u0449\u045e\7\u00ab\2\2\u044a\u044b\5\u0094K\2\u044b\u044c"+
		"\7[\2\2\u044c\u045e\3\2\2\2\u044d\u045e\7\u010c\2\2\u044e\u044f\7\u00ac"+
		"\2\2\u044f\u0450\7\u010d\2\2\u0450\u0451\7\u00ad\2\2\u0451\u0452\7\u00ae"+
		"\2\2\u0452\u045b\7\u010d\2\2\u0453\u0459\7U\2\2\u0454\u045a\5\u00caf\2"+
		"\u0455\u0456\5\u00c8e\2\u0456\u0457\7\3\2\2\u0457\u0458\7\4\2\2\u0458"+
		"\u045a\3\2\2\2\u0459\u0454\3\2\2\2\u0459\u0455\3\2\2\2\u045a\u045c\3\2"+
		"\2\2\u045b\u0453\3\2\2\2\u045b\u045c\3\2\2\2\u045c\u045e\3\2\2\2\u045d"+
		"\u0446\3\2\2\2\u045d\u044a\3\2\2\2\u045d\u044d\3\2\2\2\u045d\u044e\3\2"+
		"\2\2\u045e\u045f\3\2\2\2\u045f\u0460\7\4\2\2\u0460u\3\2\2\2\u0461\u0462"+
		"\7\3\2\2\u0462\u0463\5x=\2\u0463\u0464\7\4\2\2\u0464w\3\2\2\2\u0465\u046a"+
		"\5\u00caf\2\u0466\u0467\7\5\2\2\u0467\u0469\5\u00caf\2\u0468\u0466\3\2"+
		"\2\2\u0469\u046c\3\2\2\2\u046a\u0468\3\2\2\2\u046a\u046b\3\2\2\2\u046b"+
		"y\3\2\2\2\u046c\u046a\3\2\2\2\u046d\u046e\7\3\2\2\u046e\u0473\5|?\2\u046f"+
		"\u0470\7\5\2\2\u0470\u0472\5|?\2\u0471\u046f\3\2\2\2\u0472\u0475\3\2\2"+
		"\2\u0473\u0471\3\2\2\2\u0473\u0474\3\2\2\2\u0474\u0476\3\2\2\2\u0475\u0473"+
		"\3\2\2\2\u0476\u0477\7\4\2\2\u0477{\3\2\2\2\u0478\u047a\5\u00caf\2\u0479"+
		"\u047b\t\5\2\2\u047a\u0479\3\2\2\2\u047a\u047b\3\2\2\2\u047b}\3\2\2\2"+
		"\u047c\u047d\7\3\2\2\u047d\u0482\5\u0080A\2\u047e\u047f\7\5\2\2\u047f"+
		"\u0481\5\u0080A\2\u0480\u047e\3\2\2\2\u0481\u0484\3\2\2\2\u0482\u0480"+
		"\3\2\2\2\u0482\u0483\3\2\2\2\u0483\u0485\3\2\2\2\u0484\u0482\3\2\2\2\u0485"+
		"\u0486\7\4\2\2\u0486\177\3\2\2\2\u0487\u048a\5\u00caf\2\u0488\u0489\7"+
		"\u0089\2\2\u0489\u048b\7\u0108\2\2\u048a\u0488\3\2\2\2\u048a\u048b\3\2"+
		"\2\2\u048b\u0081\3\2\2\2\u048c\u048e\5\u008cG\2\u048d\u048f\5t;\2\u048e"+
		"\u048d\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u0490\3\2\2\2\u0490\u0491\5\u0088"+
		"E\2\u0491\u04a5\3\2\2\2\u0492\u0493\7\3\2\2\u0493\u0494\5P)\2\u0494\u0496"+
		"\7\4\2\2\u0495\u0497\5t;\2\u0496\u0495\3\2\2\2\u0496\u0497\3\2\2\2\u0497"+
		"\u0498\3\2\2\2\u0498\u0499\5\u0088E\2\u0499\u04a5\3\2\2\2\u049a\u049b"+
		"\7\3\2\2\u049b\u049c\5l\67\2\u049c\u049e\7\4\2\2\u049d\u049f\5t;\2\u049e"+
		"\u049d\3\2\2\2\u049e\u049f\3\2\2\2\u049f\u04a0\3\2\2\2\u04a0\u04a1\5\u0088"+
		"E\2\u04a1\u04a5\3\2\2\2\u04a2\u04a5\5\u0084C\2\u04a3\u04a5\5\u0086D\2"+
		"\u04a4\u048c\3\2\2\2\u04a4\u0492\3\2\2\2\u04a4\u049a\3\2\2\2\u04a4\u04a2"+
		"\3\2\2\2\u04a4\u04a3\3\2\2\2\u04a5\u0083\3\2\2\2\u04a6\u04a7\7e\2\2\u04a7"+
		"\u04ac\5\u0094K\2\u04a8\u04a9\7\5\2\2\u04a9\u04ab\5\u0094K\2\u04aa\u04a8"+
		"\3\2\2\2\u04ab\u04ae\3\2\2\2\u04ac\u04aa\3\2\2\2\u04ac\u04ad\3\2\2\2\u04ad"+
		"\u04af\3\2\2\2\u04ae\u04ac\3\2\2\2\u04af\u04b0\5\u0088E\2\u04b0\u0085"+
		"\3\2\2\2\u04b1\u04b2\5\u00caf\2\u04b2\u04bb\7\3\2\2\u04b3\u04b8\5\u0094"+
		"K\2\u04b4\u04b5\7\5\2\2\u04b5\u04b7\5\u0094K\2\u04b6\u04b4\3\2\2\2\u04b7"+
		"\u04ba\3\2\2\2\u04b8\u04b6\3\2\2\2\u04b8\u04b9\3\2\2\2\u04b9\u04bc\3\2"+
		"\2\2\u04ba\u04b8\3\2\2\2\u04bb\u04b3\3\2\2\2\u04bb\u04bc\3\2\2\2\u04bc"+
		"\u04bd\3\2\2\2\u04bd\u04be\7\4\2\2\u04be\u04bf\5\u0088E\2\u04bf\u0087"+
		"\3\2\2\2\u04c0\u04c2\7\'\2\2\u04c1\u04c0\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2"+
		"\u04c3\3\2\2\2\u04c3\u04c5\5\u00ccg\2\u04c4\u04c6\5v<\2\u04c5\u04c4\3"+
		"\2\2\2\u04c5\u04c6\3\2\2\2\u04c6\u04c8\3\2\2\2\u04c7\u04c1\3\2\2\2\u04c7"+
		"\u04c8\3\2\2\2\u04c8\u0089\3\2\2\2\u04c9\u04ca\7c\2\2\u04ca\u04cb\7p\2"+
		"\2\u04cb\u04cc\7\u00b6\2\2\u04cc\u04d0\7\u0108\2\2\u04cd\u04ce\7d\2\2"+
		"\u04ce\u04cf\7\u00b7\2\2\u04cf\u04d1\5<\37\2\u04d0\u04cd\3\2\2\2\u04d0"+
		"\u04d1\3\2\2\2\u04d1\u04fb\3\2\2\2\u04d2\u04d3\7c\2\2\u04d3\u04d4\7p\2"+
		"\2\u04d4\u04de\7\u00ba\2\2\u04d5\u04d6\7\u00bb\2\2\u04d6\u04d7\7\u00bc"+
		"\2\2\u04d7\u04d8\7,\2\2\u04d8\u04dc\7\u0108\2\2\u04d9\u04da\7\u00c0\2"+
		"\2\u04da\u04db\7,\2\2\u04db\u04dd\7\u0108\2\2\u04dc\u04d9\3\2\2\2\u04dc"+
		"\u04dd\3\2\2\2\u04dd\u04df\3\2\2\2\u04de\u04d5\3\2\2\2\u04de\u04df\3\2"+
		"\2\2\u04df\u04e5\3\2\2\2\u04e0\u04e1\7\u00bd\2\2\u04e1\u04e2\7\u00be\2"+
		"\2\u04e2\u04e3\7\u00bc\2\2\u04e3\u04e4\7,\2\2\u04e4\u04e6\7\u0108\2\2"+
		"\u04e5\u04e0\3\2\2\2\u04e5\u04e6\3\2\2\2\u04e6\u04ec\3\2\2\2\u04e7\u04e8"+
		"\7\u0087\2\2\u04e8\u04e9\7\u00bf\2\2\u04e9\u04ea\7\u00bc\2\2\u04ea\u04eb"+
		"\7,\2\2\u04eb\u04ed\7\u0108\2\2\u04ec\u04e7\3\2\2\2\u04ec\u04ed\3\2\2"+
		"\2\u04ed\u04f2\3\2\2\2\u04ee\u04ef\7\u00c1\2\2\u04ef\u04f0\7\u00bc\2\2"+
		"\u04f0\u04f1\7,\2\2\u04f1\u04f3\7\u0108\2\2\u04f2\u04ee\3\2\2\2\u04f2"+
		"\u04f3\3\2\2\2\u04f3\u04f8\3\2\2\2\u04f4\u04f5\7?\2\2\u04f5\u04f6\7\u00ef"+
		"\2\2\u04f6\u04f7\7\'\2\2\u04f7\u04f9\7\u0108\2\2\u04f8\u04f4\3\2\2\2\u04f8"+
		"\u04f9\3\2\2\2\u04f9\u04fb\3\2\2\2\u04fa\u04c9\3\2\2\2\u04fa\u04d2\3\2"+
		"\2\2\u04fb\u008b\3\2\2\2\u04fc\u04fd\5\u00caf\2\u04fd\u04fe\7\6\2\2\u04fe"+
		"\u0500\3\2\2\2\u04ff\u04fc\3\2\2\2\u04ff\u0500\3\2\2\2\u0500\u0501\3\2"+
		"\2\2\u0501\u0502\5\u00caf\2\u0502\u008d\3\2\2\2\u0503\u0504\5\u00caf\2"+
		"\u0504\u0505\7\6\2\2\u0505\u0507\3\2\2\2\u0506\u0503\3\2\2\2\u0506\u0507"+
		"\3\2\2\2\u0507\u0508\3\2\2\2\u0508\u0509\5\u00caf\2\u0509\u008f\3\2\2"+
		"\2\u050a\u0512\5\u0094K\2\u050b\u050d\7\'\2\2\u050c\u050b\3\2\2\2\u050c"+
		"\u050d\3\2\2\2\u050d\u0510\3\2\2\2\u050e\u0511\5\u00caf\2\u050f\u0511"+
		"\5v<\2\u0510\u050e\3\2\2\2\u0510\u050f\3\2\2\2\u0511\u0513\3\2\2\2\u0512"+
		"\u050c\3\2\2\2\u0512\u0513\3\2\2\2\u0513\u0091\3\2\2\2\u0514\u0519\5\u0090"+
		"I\2\u0515\u0516\7\5\2\2\u0516\u0518\5\u0090I\2\u0517\u0515\3\2\2\2\u0518"+
		"\u051b\3\2\2\2\u0519\u0517\3\2\2\2\u0519\u051a\3\2\2\2\u051a\u0093\3\2"+
		"\2\2\u051b\u0519\3\2\2\2\u051c\u051d\5\u0096L\2\u051d\u0095\3\2\2\2\u051e"+
		"\u051f\bL\1\2\u051f\u0520\78\2\2\u0520\u0528\5\u0096L\7\u0521\u0522\7"+
		":\2\2\u0522\u0523\7\3\2\2\u0523\u0524\5(\25\2\u0524\u0525\7\4\2\2\u0525"+
		"\u0528\3\2\2\2\u0526\u0528\5\u0098M\2\u0527\u051e\3\2\2\2\u0527\u0521"+
		"\3\2\2\2\u0527\u0526\3\2\2\2\u0528\u0531\3\2\2\2\u0529\u052a\f\4\2\2\u052a"+
		"\u052b\7\66\2\2\u052b\u0530\5\u0096L\5\u052c\u052d\f\3\2\2\u052d\u052e"+
		"\7\65\2\2\u052e\u0530\5\u0096L\4\u052f\u0529\3\2\2\2\u052f\u052c\3\2\2"+
		"\2\u0530\u0533\3\2\2\2\u0531\u052f\3\2\2\2\u0531\u0532\3\2\2\2\u0532\u0097"+
		"\3\2\2\2\u0533\u0531\3\2\2\2\u0534\u0536\5\u009cO\2\u0535\u0537\5\u009a"+
		"N\2\u0536\u0535\3\2\2\2\u0536\u0537\3\2\2\2\u0537\u0099\3\2\2\2\u0538"+
		"\u053a\78\2\2\u0539\u0538\3\2\2\2\u0539\u053a\3\2\2\2\u053a\u053b\3\2"+
		"\2\2\u053b\u053c\7;\2\2\u053c\u053d\5\u009cO\2\u053d\u053e\7\66\2\2\u053e"+
		"\u053f\5\u009cO\2\u053f\u0569\3\2\2\2\u0540\u0542\78\2\2\u0541\u0540\3"+
		"\2\2\2\u0541\u0542\3\2\2\2\u0542\u0543\3\2\2\2\u0543\u0544\7\67\2\2\u0544"+
		"\u0545\7\3\2\2\u0545\u054a\5\u0094K\2\u0546\u0547\7\5\2\2\u0547\u0549"+
		"\5\u0094K\2\u0548\u0546\3\2\2\2\u0549\u054c\3\2\2\2\u054a\u0548\3\2\2"+
		"\2\u054a\u054b\3\2\2\2\u054b\u054d\3\2\2\2\u054c\u054a\3\2\2\2\u054d\u054e"+
		"\7\4\2\2\u054e\u0569\3\2\2\2\u054f\u0551\78\2\2\u0550\u054f\3\2\2\2\u0550"+
		"\u0551\3\2\2\2\u0551\u0552\3\2\2\2\u0552\u0553\7\67\2\2\u0553\u0554\7"+
		"\3\2\2\u0554\u0555\5(\25\2\u0555\u0556\7\4\2\2\u0556\u0569\3\2\2\2\u0557"+
		"\u0559\78\2\2\u0558\u0557\3\2\2\2\u0558\u0559\3\2\2\2\u0559\u055a\3\2"+
		"\2\2\u055a\u055b\t\t\2\2\u055b\u0569\5\u009cO\2\u055c\u055e\7>\2\2\u055d"+
		"\u055f\78\2\2\u055e\u055d\3\2\2\2\u055e\u055f\3\2\2\2\u055f\u0560\3\2"+
		"\2\2\u0560\u0569\7?\2\2\u0561\u0563\7>\2\2\u0562\u0564\78\2\2\u0563\u0562"+
		"\3\2\2\2\u0563\u0564\3\2\2\2\u0564\u0565\3\2\2\2\u0565\u0566\7)\2\2\u0566"+
		"\u0567\7\16\2\2\u0567\u0569\5\u009cO\2\u0568\u0539\3\2\2\2\u0568\u0541"+
		"\3\2\2\2\u0568\u0550\3\2\2\2\u0568\u0558\3\2\2\2\u0568\u055c\3\2\2\2\u0568"+
		"\u0561\3\2\2\2\u0569\u009b\3\2\2\2\u056a\u056b\bO\1\2\u056b\u056f\5\u009e"+
		"P\2\u056c\u056d\t\n\2\2\u056d\u056f\5\u009cO\t\u056e\u056a\3\2\2\2\u056e"+
		"\u056c\3\2\2\2\u056f\u0585\3\2\2\2\u0570\u0571\f\b\2\2\u0571\u0572\t\13"+
		"\2\2\u0572\u0584\5\u009cO\t\u0573\u0574\f\7\2\2\u0574\u0575\t\f\2\2\u0575"+
		"\u0584\5\u009cO\b\u0576\u0577\f\6\2\2\u0577\u0578\7\u00a7\2\2\u0578\u0584"+
		"\5\u009cO\7\u0579\u057a\f\5\2\2\u057a\u057b\7\u00aa\2\2\u057b\u0584\5"+
		"\u009cO\6\u057c\u057d\f\4\2\2\u057d\u057e\7\u00a8\2\2\u057e\u0584\5\u009c"+
		"O\5\u057f\u0580\f\3\2\2\u0580\u0581\5\u00a2R\2\u0581\u0582\5\u009cO\4"+
		"\u0582\u0584\3\2\2\2\u0583\u0570\3\2\2\2\u0583\u0573\3\2\2\2\u0583\u0576"+
		"\3\2\2\2\u0583\u0579\3\2\2\2\u0583\u057c\3\2\2\2\u0583\u057f\3\2\2\2\u0584"+
		"\u0587\3\2\2\2\u0585\u0583\3\2\2\2\u0585\u0586\3\2\2\2\u0586\u009d\3\2"+
		"\2\2\u0587\u0585\3\2\2\2\u0588\u0589\bP\1\2\u0589\u0606\t\r\2\2\u058a"+
		"\u058c\7G\2\2\u058b\u058d\5\u00bc_\2\u058c\u058b\3\2\2\2\u058d\u058e\3"+
		"\2\2\2\u058e\u058c\3\2\2\2\u058e\u058f\3\2\2\2\u058f\u0592\3\2\2\2\u0590"+
		"\u0591\7J\2\2\u0591\u0593\5\u0094K\2\u0592\u0590\3\2\2\2\u0592\u0593\3"+
		"\2\2\2\u0593\u0594\3\2\2\2\u0594\u0595\7K\2\2\u0595\u0606\3\2\2\2\u0596"+
		"\u0597\7G\2\2\u0597\u0599\5\u0094K\2\u0598\u059a\5\u00bc_\2\u0599\u0598"+
		"\3\2\2\2\u059a\u059b\3\2\2\2\u059b\u0599\3\2\2\2\u059b\u059c\3\2\2\2\u059c"+
		"\u059f\3\2\2\2\u059d\u059e\7J\2\2\u059e\u05a0\5\u0094K\2\u059f\u059d\3"+
		"\2\2\2\u059f\u05a0\3\2\2\2\u05a0\u05a1\3\2\2\2\u05a1\u05a2\7K\2\2\u05a2"+
		"\u0606\3\2\2\2\u05a3\u05a4\7t\2\2\u05a4\u05a5\7\3\2\2\u05a5\u05a6\5\u0094"+
		"K\2\u05a6\u05a7\7\'\2\2\u05a7\u05a8\5\u00b2Z\2\u05a8\u05a9\7\4\2\2\u05a9"+
		"\u0606\3\2\2\2\u05aa\u05ab\7\u0088\2\2\u05ab\u05b4\7\3\2\2\u05ac\u05b1"+
		"\5\u0090I\2\u05ad\u05ae\7\5\2\2\u05ae\u05b0\5\u0090I\2\u05af\u05ad\3\2"+
		"\2\2\u05b0\u05b3\3\2\2\2\u05b1\u05af\3\2\2\2\u05b1\u05b2\3\2\2\2\u05b2"+
		"\u05b5\3\2\2\2\u05b3\u05b1\3\2\2\2\u05b4\u05ac\3\2\2\2\u05b4\u05b5\3\2"+
		"\2\2\u05b5\u05b6\3\2\2\2\u05b6\u0606\7\4\2\2\u05b7\u05b8\7`\2\2\u05b8"+
		"\u05b9\7\3\2\2\u05b9\u05bc\5\u0094K\2\u05ba\u05bb\7\u0092\2\2\u05bb\u05bd"+
		"\7B\2\2\u05bc\u05ba\3\2\2\2\u05bc\u05bd\3\2\2\2\u05bd\u05be\3\2\2\2\u05be"+
		"\u05bf\7\4\2\2\u05bf\u0606\3\2\2\2\u05c0\u05c1\7b\2\2\u05c1\u05c2\7\3"+
		"\2\2\u05c2\u05c5\5\u0094K\2\u05c3\u05c4\7\u0092\2\2\u05c4\u05c6\7B\2\2"+
		"\u05c5\u05c3\3\2\2\2\u05c5\u05c6\3\2\2\2\u05c6\u05c7\3\2\2\2\u05c7\u05c8"+
		"\7\4\2\2\u05c8\u0606\3\2\2\2\u05c9\u05ca\7\u0097\2\2\u05ca\u05cb\7\3\2"+
		"\2\u05cb\u05cc\5\u009cO\2\u05cc\u05cd\7\67\2\2\u05cd\u05ce\5\u009cO\2"+
		"\u05ce\u05cf\7\4\2\2\u05cf\u0606\3\2\2\2\u05d0\u0606\5\u00a0Q\2\u05d1"+
		"\u0606\7\u00a2\2\2\u05d2\u05d3\5\u00c8e\2\u05d3\u05d4\7\6\2\2\u05d4\u05d5"+
		"\7\u00a2\2\2\u05d5\u0606\3\2\2\2\u05d6\u05d7\7\3\2\2\u05d7\u05da\5\u0090"+
		"I\2\u05d8\u05d9\7\5\2\2\u05d9\u05db\5\u0090I\2\u05da\u05d8\3\2\2\2\u05db"+
		"\u05dc\3\2\2\2\u05dc\u05da\3\2\2\2\u05dc\u05dd\3\2\2\2\u05dd\u05de\3\2"+
		"\2\2\u05de\u05df\7\4\2\2\u05df\u0606\3\2\2\2\u05e0\u05e1\7\3\2\2\u05e1"+
		"\u05e2\5(\25\2\u05e2\u05e3\7\4\2\2\u05e3\u0606\3\2\2\2\u05e4\u05e5\5\u00c8"+
		"e\2\u05e5\u05f1\7\3\2\2\u05e6\u05e8\5j\66\2\u05e7\u05e6\3\2\2\2\u05e7"+
		"\u05e8\3\2\2\2\u05e8\u05e9\3\2\2\2\u05e9\u05ee\5\u0094K\2\u05ea\u05eb"+
		"\7\5\2\2\u05eb\u05ed\5\u0094K\2\u05ec\u05ea\3\2\2\2\u05ed\u05f0\3\2\2"+
		"\2\u05ee\u05ec\3\2\2\2\u05ee\u05ef\3\2\2\2\u05ef\u05f2\3\2\2\2\u05f0\u05ee"+
		"\3\2\2\2\u05f1\u05e7\3\2\2\2\u05f1\u05f2\3\2\2\2\u05f2\u05f3\3\2\2\2\u05f3"+
		"\u05f6\7\4\2\2\u05f4\u05f5\7X\2\2\u05f5\u05f7\5\u00c2b\2\u05f6\u05f4\3"+
		"\2\2\2\u05f6\u05f7\3\2\2\2\u05f7\u0606\3\2\2\2\u05f8\u05f9\5\u00c8e\2"+
		"\u05f9\u05fa\7\3\2\2\u05fa\u05fb\t\16\2\2\u05fb\u05fc\5\u0094K\2\u05fc"+
		"\u05fd\7\16\2\2\u05fd\u05fe\5\u0094K\2\u05fe\u05ff\7\4\2\2\u05ff\u0606"+
		"\3\2\2\2\u0600\u0606\5\u00caf\2\u0601\u0602\7\3\2\2\u0602\u0603\5\u0094"+
		"K\2\u0603\u0604\7\4\2\2\u0604\u0606\3\2\2\2\u0605\u0588\3\2\2\2\u0605"+
		"\u058a\3\2\2\2\u0605\u0596\3\2\2\2\u0605\u05a3\3\2\2\2\u0605\u05aa\3\2"+
		"\2\2\u0605\u05b7\3\2\2\2\u0605\u05c0\3\2\2\2\u0605\u05c9\3\2\2\2\u0605"+
		"\u05d0\3\2\2\2\u0605\u05d1\3\2\2\2\u0605\u05d2\3\2\2\2\u0605\u05d6\3\2"+
		"\2\2\u0605\u05e0\3\2\2\2\u0605\u05e4\3\2\2\2\u0605\u05f8\3\2\2\2\u0605"+
		"\u0600\3\2\2\2\u0605\u0601\3\2\2\2\u0606\u0611\3\2\2\2\u0607\u0608\f\6"+
		"\2\2\u0608\u0609\7\t\2\2\u0609\u060a\5\u009cO\2\u060a\u060b\7\n\2\2\u060b"+
		"\u0610\3\2\2\2\u060c\u060d\f\4\2\2\u060d\u060e\7\6\2\2\u060e\u0610\5\u00ca"+
		"f\2\u060f\u0607\3\2\2\2\u060f\u060c\3\2\2\2\u0610\u0613\3\2\2\2\u0611"+
		"\u060f\3\2\2\2\u0611\u0612\3\2\2\2\u0612\u009f\3\2\2\2\u0613\u0611\3\2"+
		"\2\2\u0614\u0621\7?\2\2\u0615\u0621\5\u00aaV\2\u0616\u0617\5\u00caf\2"+
		"\u0617\u0618\7\u0108\2\2\u0618\u0621\3\2\2\2\u0619\u0621\5\u00d0i\2\u061a"+
		"\u0621\5\u00a8U\2\u061b\u061d\7\u0108\2\2\u061c\u061b\3\2\2\2\u061d\u061e"+
		"\3\2\2\2\u061e\u061c\3\2\2\2\u061e\u061f\3\2\2\2\u061f\u0621\3\2\2\2\u0620"+
		"\u0614\3\2\2\2\u0620\u0615\3\2\2\2\u0620\u0616\3\2\2\2\u0620\u0619\3\2"+
		"\2\2\u0620\u061a\3\2\2\2\u0620\u061c\3\2\2\2\u0621\u00a1\3\2\2\2\u0622"+
		"\u0623\t\17\2\2\u0623\u00a3\3\2\2\2\u0624\u0625\t\20\2\2\u0625\u00a5\3"+
		"\2\2\2\u0626\u0627\t\21\2\2\u0627\u00a7\3\2\2\2\u0628\u0629\t\22\2\2\u0629"+
		"\u00a9\3\2\2\2\u062a\u062e\7F\2\2\u062b\u062d\5\u00acW\2\u062c\u062b\3"+
		"\2\2\2\u062d\u0630\3\2\2\2\u062e\u062c\3\2\2\2\u062e\u062f\3\2\2\2\u062f"+
		"\u00ab\3\2\2\2\u0630\u062e\3\2\2\2\u0631\u0632\5\u00aeX\2\u0632\u0635"+
		"\5\u00caf\2\u0633\u0634\7\u0081\2\2\u0634\u0636\5\u00caf\2\u0635\u0633"+
		"\3\2\2\2\u0635\u0636\3\2\2\2\u0636\u00ad\3\2\2\2\u0637\u0639\t\23\2\2"+
		"\u0638\u0637\3\2\2\2\u0638\u0639\3\2\2\2\u0639\u063a\3\2\2\2\u063a\u063d"+
		"\t\b\2\2\u063b\u063d\7\u0108\2\2\u063c\u0638\3\2\2\2\u063c\u063b\3\2\2"+
		"\2\u063d\u00af\3\2\2\2\u063e\u0642\7`\2\2\u063f\u0640\7a\2\2\u0640\u0642"+
		"\5\u00caf\2\u0641\u063e\3\2\2\2\u0641\u063f\3\2\2\2\u0642\u00b1\3\2\2"+
		"\2\u0643\u0644\7\u0086\2\2\u0644\u0645\7\u009c\2\2\u0645\u0646\5\u00b2"+
		"Z\2\u0646\u0647\7\u009e\2\2\u0647\u0666\3\2\2\2\u0648\u0649\7\u0087\2"+
		"\2\u0649\u064a\7\u009c\2\2\u064a\u064b\5\u00b2Z\2\u064b\u064c\7\5\2\2"+
		"\u064c\u064d\5\u00b2Z\2\u064d\u064e\7\u009e\2\2\u064e\u0666\3\2\2\2\u064f"+
		"\u0656\7\u0088\2\2\u0650\u0652\7\u009c\2\2\u0651\u0653\5\u00b8]\2\u0652"+
		"\u0651\3\2\2\2\u0652\u0653\3\2\2\2\u0653\u0654\3\2\2\2\u0654\u0657\7\u009e"+
		"\2\2\u0655\u0657\7\u009a\2\2\u0656\u0650\3\2\2\2\u0656\u0655\3\2\2\2\u0657"+
		"\u0666\3\2\2\2\u0658\u0663\5\u00caf\2\u0659\u065a\7\3\2\2\u065a\u065f"+
		"\7\u010d\2\2\u065b\u065c\7\5\2\2\u065c\u065e\7\u010d\2\2\u065d\u065b\3"+
		"\2\2\2\u065e\u0661\3\2\2\2\u065f\u065d\3\2\2\2\u065f\u0660\3\2\2\2\u0660"+
		"\u0662\3\2\2\2\u0661\u065f\3\2\2\2\u0662\u0664\7\4\2\2\u0663\u0659\3\2"+
		"\2\2\u0663\u0664\3\2\2\2\u0664\u0666\3\2\2\2\u0665\u0643\3\2\2\2\u0665"+
		"\u0648\3\2\2\2\u0665\u064f\3\2\2\2\u0665\u0658\3\2\2\2\u0666\u00b3\3\2"+
		"\2\2\u0667\u066c\5\u00b6\\\2\u0668\u0669\7\5\2\2\u0669\u066b\5\u00b6\\"+
		"\2\u066a\u0668\3\2\2\2\u066b\u066e\3\2\2\2\u066c\u066a\3\2\2\2\u066c\u066d"+
		"\3\2\2\2\u066d\u00b5\3\2\2\2\u066e\u066c\3\2\2\2\u066f\u0670\5\u00caf"+
		"\2\u0670\u0673\5\u00b2Z\2\u0671\u0672\7\u0089\2\2\u0672\u0674\7\u0108"+
		"\2\2\u0673\u0671\3\2\2\2\u0673\u0674\3\2\2\2\u0674\u00b7\3\2\2\2\u0675"+
		"\u067a\5\u00ba^\2\u0676\u0677\7\5\2\2\u0677\u0679\5\u00ba^\2\u0678\u0676"+
		"\3\2\2\2\u0679\u067c\3\2\2\2\u067a\u0678\3\2\2\2\u067a\u067b\3\2\2\2\u067b"+
		"\u00b9\3\2\2\2\u067c\u067a\3\2\2\2\u067d\u067e\5\u00caf\2\u067e\u067f"+
		"\7\13\2\2\u067f\u0682\5\u00b2Z\2\u0680\u0681\7\u0089\2\2\u0681\u0683\7"+
		"\u0108\2\2\u0682\u0680\3\2\2\2\u0682\u0683\3\2\2\2\u0683\u00bb\3\2\2\2"+
		"\u0684\u0685\7H\2\2\u0685\u0686\5\u0094K\2\u0686\u0687\7I\2\2\u0687\u0688"+
		"\5\u0094K\2\u0688\u00bd\3\2\2\2\u0689\u068a\7W\2\2\u068a\u068f\5\u00c0"+
		"a\2\u068b\u068c\7\5\2\2\u068c\u068e\5\u00c0a\2\u068d\u068b\3\2\2\2\u068e"+
		"\u0691\3\2\2\2\u068f\u068d\3\2\2\2\u068f\u0690\3\2\2\2\u0690\u00bf\3\2"+
		"\2\2\u0691\u068f\3\2\2\2\u0692\u0693\5\u00caf\2\u0693\u0694\7\'\2\2\u0694"+
		"\u0695\5\u00c2b\2\u0695\u00c1\3\2\2\2\u0696\u06c1\5\u00caf\2\u0697\u06ba"+
		"\7\3\2\2\u0698\u0699\7\u00b0\2\2\u0699\u069a\7,\2\2\u069a\u069f\5\u0094"+
		"K\2\u069b\u069c\7\5\2\2\u069c\u069e\5\u0094K\2\u069d\u069b\3\2\2\2\u069e"+
		"\u06a1\3\2\2\2\u069f\u069d\3\2\2\2\u069f\u06a0\3\2\2\2\u06a0\u06bb\3\2"+
		"\2\2\u06a1\u069f\3\2\2\2\u06a2\u06a3\t\24\2\2\u06a3\u06a4\7,\2\2\u06a4"+
		"\u06a9\5\u0094K\2\u06a5\u06a6\7\5\2\2\u06a6\u06a8\5\u0094K\2\u06a7\u06a5"+
		"\3\2\2\2\u06a8\u06ab\3\2\2\2\u06a9\u06a7\3\2\2\2\u06a9\u06aa\3\2\2\2\u06aa"+
		"\u06ad\3\2\2\2\u06ab\u06a9\3\2\2\2\u06ac\u06a2\3\2\2\2\u06ac\u06ad\3\2"+
		"\2\2\u06ad\u06b8\3\2\2\2\u06ae\u06af\t\25\2\2\u06af\u06b0\7,\2\2\u06b0"+
		"\u06b5\5Z.\2\u06b1\u06b2\7\5\2\2\u06b2\u06b4\5Z.\2\u06b3\u06b1\3\2\2\2"+
		"\u06b4\u06b7\3\2\2\2\u06b5\u06b3\3\2\2\2\u06b5\u06b6\3\2\2\2\u06b6\u06b9"+
		"\3\2\2\2\u06b7\u06b5\3\2\2\2\u06b8\u06ae\3\2\2\2\u06b8\u06b9\3\2\2\2\u06b9"+
		"\u06bb\3\2\2\2\u06ba\u0698\3\2\2\2\u06ba\u06ac\3\2\2\2\u06bb\u06bd\3\2"+
		"\2\2\u06bc\u06be\5\u00c4c\2\u06bd\u06bc\3\2\2\2\u06bd\u06be\3\2\2\2\u06be"+
		"\u06bf\3\2\2\2\u06bf\u06c1\7\4\2\2\u06c0\u0696\3\2\2\2\u06c0\u0697\3\2"+
		"\2\2\u06c1\u00c3\3\2\2\2\u06c2\u06c3\7Z\2\2\u06c3\u06d3\5\u00c6d\2\u06c4"+
		"\u06c5\7[\2\2\u06c5\u06d3\5\u00c6d\2\u06c6\u06c7\7Z\2\2\u06c7\u06c8\7"+
		";\2\2\u06c8\u06c9\5\u00c6d\2\u06c9\u06ca\7\66\2\2\u06ca\u06cb\5\u00c6"+
		"d\2\u06cb\u06d3\3\2\2\2\u06cc\u06cd\7[\2\2\u06cd\u06ce\7;\2\2\u06ce\u06cf"+
		"\5\u00c6d\2\u06cf\u06d0\7\66\2\2\u06d0\u06d1\5\u00c6d\2\u06d1\u06d3\3"+
		"\2\2\2\u06d2\u06c2\3\2\2\2\u06d2\u06c4\3\2\2\2\u06d2\u06c6\3\2\2\2\u06d2"+
		"\u06cc\3\2\2\2\u06d3\u00c5\3\2\2\2\u06d4\u06d5\7\\\2\2\u06d5\u06dc\t\26"+
		"\2\2\u06d6\u06d7\7_\2\2\u06d7\u06dc\7c\2\2\u06d8\u06d9\5\u0094K\2\u06d9"+
		"\u06da\t\26\2\2\u06da\u06dc\3\2\2\2\u06db\u06d4\3\2\2\2\u06db\u06d6\3"+
		"\2\2\2\u06db\u06d8\3\2\2\2\u06dc\u00c7\3\2\2\2\u06dd\u06e2\5\u00caf\2"+
		"\u06de\u06df\7\6\2\2\u06df\u06e1\5\u00caf\2\u06e0\u06de\3\2\2\2\u06e1"+
		"\u06e4\3\2\2\2\u06e2\u06e0\3\2\2\2\u06e2\u06e3\3\2\2\2\u06e3\u00c9\3\2"+
		"\2\2\u06e4\u06e2\3\2\2\2\u06e5\u06f5\5\u00ccg\2\u06e6\u06f5\7\u0103\2"+
		"\2\u06e7\u06f5\7S\2\2\u06e8\u06f5\7O\2\2\u06e9\u06f5\7P\2\2\u06ea\u06f5"+
		"\7Q\2\2\u06eb\u06f5\7R\2\2\u06ec\u06f5\7T\2\2\u06ed\u06f5\7L\2\2\u06ee"+
		"\u06f5\7M\2\2\u06ef\u06f5\7U\2\2\u06f0\u06f5\7}\2\2\u06f1\u06f5\7\u0080"+
		"\2\2\u06f2\u06f5\7~\2\2\u06f3\u06f5\7\177\2\2\u06f4\u06e5\3\2\2\2\u06f4"+
		"\u06e6\3\2\2\2\u06f4\u06e7\3\2\2\2\u06f4\u06e8\3\2\2\2\u06f4\u06e9\3\2"+
		"\2\2\u06f4\u06ea\3\2\2\2\u06f4\u06eb\3\2\2\2\u06f4\u06ec\3\2\2\2\u06f4"+
		"\u06ed\3\2\2\2\u06f4\u06ee\3\2\2\2\u06f4\u06ef\3\2\2\2\u06f4\u06f0\3\2"+
		"\2\2\u06f4\u06f1\3\2\2\2\u06f4\u06f2\3\2\2\2\u06f4\u06f3\3\2\2\2\u06f5"+
		"\u00cb\3\2\2\2\u06f6\u06fa\7\u0111\2\2\u06f7\u06fa\5\u00ceh\2\u06f8\u06fa"+
		"\5\u00d2j\2\u06f9\u06f6\3\2\2\2\u06f9\u06f7\3\2\2\2\u06f9\u06f8\3\2\2"+
		"\2\u06fa\u00cd\3\2\2\2\u06fb\u06fc\7\u0112\2\2\u06fc\u00cf\3\2\2\2\u06fd"+
		"\u06ff\7\u00a1\2\2\u06fe\u06fd\3\2\2\2\u06fe\u06ff\3\2\2\2\u06ff\u0700"+
		"\3\2\2\2\u0700\u071a\7\u010e\2\2\u0701\u0703\7\u00a1\2\2\u0702\u0701\3"+
		"\2\2\2\u0702\u0703\3\2\2\2\u0703\u0704\3\2\2\2\u0704\u071a\7\u010d\2\2"+
		"\u0705\u0707\7\u00a1\2\2\u0706\u0705\3\2\2\2\u0706\u0707\3\2\2\2\u0707"+
		"\u0708\3\2\2\2\u0708\u071a\7\u0109\2\2\u0709\u070b\7\u00a1\2\2\u070a\u0709"+
		"\3\2\2\2\u070a\u070b\3\2\2\2\u070b\u070c\3\2\2\2\u070c\u071a\7\u010a\2"+
		"\2\u070d\u070f\7\u00a1\2\2\u070e\u070d\3\2\2\2\u070e\u070f\3\2\2\2\u070f"+
		"\u0710\3\2\2\2\u0710\u071a\7\u010b\2\2\u0711\u0713\7\u00a1\2\2\u0712\u0711"+
		"\3\2\2\2\u0712\u0713\3\2\2\2\u0713\u0714\3\2\2\2\u0714\u071a\7\u010f\2"+
		"\2\u0715\u0717\7\u00a1\2\2\u0716\u0715\3\2\2\2\u0716\u0717\3\2\2\2\u0717"+
		"\u0718\3\2\2\2\u0718\u071a\7\u0110\2\2\u0719\u06fe\3\2\2\2\u0719\u0702"+
		"\3\2\2\2\u0719\u0706\3\2\2\2\u0719\u070a\3\2\2\2\u0719\u070e\3\2\2\2\u0719"+
		"\u0712\3\2\2\2\u0719\u0716\3\2\2\2\u071a\u00d1\3\2\2\2\u071b\u071c\t\27"+
		"\2\2\u071c\u00d3\3\2\2\2\u00e4\u00de\u00e3\u00ec\u00f0\u00f5\u00fa\u00fe"+
		"\u0105\u0113\u0130\u0134\u013b\u01af\u01b7\u01bf\u01c8\u01d4\u01d8\u01db"+
		"\u01e1\u01eb\u01f7\u01fc\u0202\u020e\u0210\u0215\u0219\u021e\u0223\u0226"+
		"\u022b\u022f\u0234\u0236\u023a\u0243\u024b\u0252\u0259\u0262\u0267\u0276"+
		"\u027d\u0280\u0287\u028b\u0291\u0299\u02a4\u02af\u02b6\u02bc\u02c2\u02cb"+
		"\u02cd\u02d6\u02d9\u02e2\u02e5\u02ee\u02f1\u02fa\u02fd\u0300\u0305\u0307"+
		"\u030a\u0315\u031a\u0325\u0329\u032d\u0339\u033c\u0340\u034a\u034e\u0350"+
		"\u0353\u0357\u035a\u035e\u0364\u0368\u036c\u0371\u0374\u0376\u037b\u0380"+
		"\u0383\u0387\u038a\u038c\u0391\u0396\u03a3\u03a8\u03b0\u03b6\u03c0\u03cf"+
		"\u03d4\u03dc\u03df\u03e3\u03e8\u03f1\u03f4\u03f9\u0400\u0403\u040b\u0412"+
		"\u0419\u041c\u0421\u0427\u042b\u042e\u0431\u043c\u0441\u0446\u0459\u045b"+
		"\u045d\u046a\u0473\u047a\u0482\u048a\u048e\u0496\u049e\u04a4\u04ac\u04b8"+
		"\u04bb\u04c1\u04c5\u04c7\u04d0\u04dc\u04de\u04e5\u04ec\u04f2\u04f8\u04fa"+
		"\u04ff\u0506\u050c\u0510\u0512\u0519\u0527\u052f\u0531\u0536\u0539\u0541"+
		"\u054a\u0550\u0558\u055e\u0563\u0568\u056e\u0583\u0585\u058e\u0592\u059b"+
		"\u059f\u05b1\u05b4\u05bc\u05c5\u05dc\u05e7\u05ee\u05f1\u05f6\u0605\u060f"+
		"\u0611\u061e\u0620\u062e\u0635\u0638\u063c\u0641\u0652\u0656\u065f\u0663"+
		"\u0665\u066c\u0673\u067a\u0682\u068f\u069f\u06a9\u06ac\u06b5\u06b8\u06ba"+
		"\u06bd\u06c0\u06d2\u06db\u06e2\u06f4\u06f9\u06fe\u0702\u0706\u070a\u070e"+
		"\u0712\u0716\u0719";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}