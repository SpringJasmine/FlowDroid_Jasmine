package soot.jimple.infoflow.threading;

import soot.jimple.infoflow.InfoflowConfiguration;
import soot.jimple.infoflow.solver.executors.InterruptableExecutor;

/**
 * Common interface for classes that can create instances of thread pool
 * 可以创建线程池实例的类的通用接口
 * executors
 * 
 * @author Steven Arzt
 *
 */
public interface IExecutorFactory {

	/**
	 * Creates a new executor object for spawning worker threads
	 * 为产生工作线程创建一个新的执行器对象
	 * 
	 * @param numThreads
	 *            The number of threads to use
	 * @param allowSetSemantics
	 *            True if the executor is allowed to skip new tasks if the same task
	 *            has already been scheduled before. False if the executor must
	 *            schedule all tasks it is given.
	 *            如果之前已经安排了相同的任务，则允许执行器跳过新任务，则为真。
	 *            如果 executor 必须安排它给定的所有任务，则为 False。
	 * @param config
	 *            The configuration of the data flow solver
	 * @return The generated executor
	 */
	public InterruptableExecutor createExecutor(int numThreads, boolean allowSetSemantics,
			InfoflowConfiguration config);

}
