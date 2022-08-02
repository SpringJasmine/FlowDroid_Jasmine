package soot.jimple.infoflow.memory;

/**
 * Interface that exposes special functions only required by FlowDroid's memory
 * management components
 * 公开仅 FlowDroid 的内存管理组件所需的特殊功能的接口
 * 
 * @author Steven Arzt
 *
 */
public interface IMemoryBoundedSolver {

	/**
	 * Interface that a memory-bounded solver can use to notify listeners of
	 * status changes
	 * 内存有限的解算器可以用来通知侦听器状态更改的接口
	 * 
	 * @author Steven Arzt
	 *
	 */
	public interface IMemoryBoundedSolverStatusNotification {

		/**
		 * Method that is called when the solver has received its first task
		 * 该方法在解算器接收到第一个任务时调用
		 * 
		 * @param solver
		 *            The solver that sends the notification
		 *            发送通知的解算器
		 */
		public void notifySolverStarted(IMemoryBoundedSolver solver);

		/**
		 * Method that is called when the solver has finished its last task
		 */
		public void notifySolverTerminated(IMemoryBoundedSolver solver);

	}

	/**
	 * Forces the solver to terminate its tasks and stop processing new tasks.
	 * This will kill the solver.
	 * 
	 * @param reason
	 *            The reason why the solver is terminated
	 */
	public void forceTerminate(ISolverTerminationReason reason);

	/**
	 * Checks whether this solver is terminated, either by forced termination,
	 * or because it has finished all of its work.
	 * 
	 * @return True if this solver is terminated, otherwise false
	 */
	boolean isTerminated();

	/**
	 * Checks whether this solver was killed before it could complete its tasks
	 * 
	 * @return True if this solver was killed before it could complete its
	 *         tasks, otherwise false
	 */
	boolean isKilled();

	/**
	 * In case this solver was killed before it could complete its task, this
	 * method returns the reason for the abortion. Otherwise, this method
	 * returns null.
	 * 如果此解算器在完成其任务之前被终止，则此方法将返回终止的原因。否则，此方法返回null。
	 * 
	 * @return The reason for the abortion in case the solver was killed,
	 *         otherwise null
	 *         流产原因以防解算器被杀，否则为空
	 */
	ISolverTerminationReason getTerminationReason();

	/**
	 * Resets the solver to its initial state after it has been forcefully
	 * terminated. After calling this method, the solver is expected to accept
	 * new tasks.
	 * 强制终止解算器后，将解算器重置为其初始状态。调用此方法后，解算器将接受新任务。
	 */
	void reset();

	/**
	 * Adds a new listener that will be notified of status changes in the solver
	 * 
	 * @param listener
	 *            The listener that will be notified when the status of the
	 *            solver changes
	 */
	void addStatusListener(IMemoryBoundedSolverStatusNotification listener);

}
