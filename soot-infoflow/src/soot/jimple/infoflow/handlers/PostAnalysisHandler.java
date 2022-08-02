package soot.jimple.infoflow.handlers;

import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

/**
 * Handler that allows clients to execute certain tasks after the data flow
 * analysis has run. Clients can then modify the results before they are
 * returned to the ResultsAvailableHandler callbacks.
 * 
 * @author Steven Arzt
 *
 */
public interface PostAnalysisHandler {
	
	/**
	 * This method is called after the data flow analysis has finished.
	 * 此方法在数据流分析完成后调用。
	 * @param results The data flow results
	 *                数据流结果
	 * @param cfg The interprocedural data flow graph
	 *            过程间数据流图
	 * @return The new data flow results, potentially changed by the client
	 * 新的数据流结果可能会被客户端更改
	 */
	public InfoflowResults onResultsAvailable(InfoflowResults results,
			IInfoflowCFG cfg);

}
