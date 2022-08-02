package soot.jimple.infoflow.handlers;

/**
 * Handler that allows clients to execute certain tasks before the actual data
 * flow analysis is executed.
 * 
 * @author Steven Arzt
 *
 */
public interface PreAnalysisHandler {
	
	/**
	 * This method is called before the callgraph is constructed
	 * 在构造调用图之前调用此方法
	 */
	public void onBeforeCallgraphConstruction();
	
	/**
	 * This method is called after the callgraph has been constructed, but
	 * before the actual data flow analysis is carried out.
	 * 在构造调用图之后但在执行实际数据流分析之前调用此方法。
	 */
	public void onAfterCallgraphConstruction();

}
