package soot.jimple.infoflow.memory;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.jimple.infoflow.collect.ConcurrentHashSet;
import soot.jimple.infoflow.memory.MemoryWarningSystem.OnMemoryThresholdReached;
import soot.jimple.infoflow.memory.reasons.OutOfMemoryReason;
import soot.jimple.infoflow.results.InfoflowResults;

/**
 * FlowDroid's implementation of a handler for the memory warning system
 * FlowDroid 的内存警告系统处理程序的实现
 * 
 * @author Steven Arzt
 *
 */
public class FlowDroidMemoryWatcher {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private final MemoryWarningSystem warningSystem = new MemoryWarningSystem();

	private final Set<IMemoryBoundedSolver> solvers = new ConcurrentHashSet<>();
	private final InfoflowResults results;
	private ISolversTerminatedCallback terminationCallback = null;

	/**
	 * Creates a new instance of the {@link FlowDroidMemoryWatcher} class
	 */
	public FlowDroidMemoryWatcher() {
		this(null);
	}

	/**
	 * Creates a new instance of the {@link FlowDroidMemoryWatcher} class
	 * 
	 * @param threshold The threshold at which to abort the workers
	 */
	public FlowDroidMemoryWatcher(double threshold) {
		this(null, threshold);
	}

	/**
	 * Creates a new instance of the {@link FlowDroidMemoryWatcher} class
	 * 
	 * @param res The result object in which to register any abortions
	 */
	public FlowDroidMemoryWatcher(InfoflowResults res) {
		this(res, 0.9d);
	}

	/**
	 * Creates a new instance of the {@link FlowDroidMemoryWatcher} class
	 * 创建 {@link FlowDroidMemoryWatcher} 类的新实例
	 * 
	 * @param res       The result object in which to register any abortions
	 *                  在其中注册任何流产的结果对象
	 * @param threshold The threshold at which to abort the workers
	 *                  中止worker的阈值
	 */
	public FlowDroidMemoryWatcher(InfoflowResults res, double threshold) {
		// Register ourselves in the warning system
		//在警告系统中注册我们自己
		warningSystem.addListener(new OnMemoryThresholdReached() {

			@Override
			public void onThresholdReached(long usedMemory, long maxMemory) {
				// Add the incident to the result object
				//将事件添加到结果对象
				if (results != null)
					results.addException("Memory threshold reached");//已达到内存阈值

				// We stop the data flow analysis
				//我们停止数据流分析
				forceTerminate();
				logger.warn("Running out of memory, solvers terminated");//内存不足，求解器终止
				if (terminationCallback != null)
					terminationCallback.onSolversTerminated();
			}

		});
//		System.out.println("threshold = " + threshold);//threshold = 0.9
		warningSystem.setWarningThreshold(threshold);
		this.results = res;
	}

	/**
	 * Adds a solver that shall be terminated when the memory threshold is reached
	 * 
	 * @param solver A solver that shall be terminated when the memory threshold is
	 *               reached
	 */
	public void addSolver(IMemoryBoundedSolver solver) {
		this.solvers.add(solver);
	}

	/**
	 * Removes the given solver from the watch list. The given solver will no longer
	 * ne notified when the memory threshold is reached.
	 * 
	 * @param solver The solver to remove from the watch list
	 * @return True if the given solver was found in the watch list, otherwise false
	 */
	public boolean removeSolver(IMemoryBoundedSolver solver) {
		return this.solvers.remove(solver);
	}

	/**
	 * Clears the list of solvers registered with this memory watcher
	 * 清除使用此内存观察器注册的求解器列表
	 */
	public void clearSolvers() {
		this.solvers.clear();
	}

	/**
	 * Shuts down the memory watcher and frees all resources associated with it
	 */
	public void close() {
		clearSolvers();
		warningSystem.close();
	}

	/**
	 * Forces the termination of all registered solvers
	 * 强制终止所有注册的求解器
	 */
	public void forceTerminate() {
		Runtime runtime = Runtime.getRuntime();
		long usedMem = runtime.totalMemory() - runtime.freeMemory();
		forceTerminate(new OutOfMemoryReason(usedMem));
	}

	/**
	 * Forces the termination of all registered solvers
	 */
	public void forceTerminate(ISolverTerminationReason reason) {
		for (IMemoryBoundedSolver solver : solvers)
			solver.forceTerminate(reason);
	}

	/**
	 * Sets a callback that shall be invoked when the solvers have been terminated
	 * due to memory exhaustion
	 * 
	 * @param terminationCallback The callback to invoke when the solvers have been
	 *                            terminated due to memory exhaustion
	 */
	public void setTerminationCallback(ISolversTerminatedCallback terminationCallback) {
		this.terminationCallback = terminationCallback;
	}

}
