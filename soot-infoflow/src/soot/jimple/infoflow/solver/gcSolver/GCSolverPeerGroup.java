package soot.jimple.infoflow.solver.gcSolver;

import soot.jimple.infoflow.solver.SolverPeerGroup;

/**
 * Specialized solver peer group for garbage-collecting solvers
 * 垃圾收集求解器的专业求解器对等组
 * 
 * @author Steven Arzt
 *
 */
public class GCSolverPeerGroup extends SolverPeerGroup {

	private GarbageCollectorPeerGroup gcPeerGroup = null;

	public GCSolverPeerGroup() {
	}

	/**
	 * Creates the peer group for the garbage collectors
	 * 
	 * @return The garbage collector peer group
	 */
	public GarbageCollectorPeerGroup getGCPeerGroup() {
		if (gcPeerGroup == null)
			gcPeerGroup = new GarbageCollectorPeerGroup();
		return gcPeerGroup;
	}

}
