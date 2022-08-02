package soot.jimple.infoflow.data.pathBuilders;

import java.util.Set;

import soot.jimple.infoflow.data.AbstractionAtSink;
import soot.jimple.infoflow.memory.IMemoryBoundedSolver;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.results.ResultSinkInfo;
import soot.jimple.infoflow.results.ResultSourceInfo;

/**
 * Common interface for all path construction algorithms. These algorithms
 * reconstruct the path from the sink to the source.
 * 所有路径构造算法的公共接口。这些算法重建了从sink到source的路径。
 *  
 * @author Steven Arzt
 */
public interface IAbstractionPathBuilder extends IMemoryBoundedSolver {
	
	/**
	 * Callback interface that is triggered whenever a path builder has
	 * computed a result value
	 */
	public interface OnPathBuilderResultAvailable {
		
		/**
		 * Method that is called when a new source-to-sink mapping is available
		 * @param source The source from which the data flow originates
		 * @param sink The sink at which the data flow ends
		 * @return True if the data analysis shall
		 */
		public void onResultAvailable(ResultSourceInfo source, ResultSinkInfo sink);
		
	}
	
	/**
	 * Computes the path of tainted data between the source and the sink
	 * 计算source和sink之间受污染数据的路径
	 * @param res The data flow tracker results
	 *            数据流跟踪器结果
	 */
	public void computeTaintPaths(final Set<AbstractionAtSink> res);
	
	/**
	 * Gets the constructed result paths
	 * 获取构造的结果路径
	 * @return The constructed result paths
	 */
	public InfoflowResults getResults();
	
	/**
	 * Adds a handler that gets called when the path reconstructor has
	 * found a new source-to-sink connection
	 * @param handler The handler to add
	 */
	public void addResultAvailableHandler(OnPathBuilderResultAvailable handler);
	
	/**
	 * Incrementally runs the path builder after some paths have already been
	 * computed. This method is usually called after the taint propagation has
	 * finished when incremental path building has been used in between.
	 * 在已经计算了一些路径之后，以增量方式运行路径生成器。此方法通常在污染传播完成后调用，其间使用增量路径构建。
	 */
	public void runIncrementalPathCompuation();
	
}
