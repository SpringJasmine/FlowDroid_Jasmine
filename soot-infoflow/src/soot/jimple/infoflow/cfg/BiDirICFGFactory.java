/**
 * (c) Copyright 2013, Tata Consultancy Services & Ecole Polytechnique de Montreal
 * All rights reserved
 */
package soot.jimple.infoflow.cfg;

import soot.jimple.infoflow.InfoflowConfiguration.CallgraphAlgorithm;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

/**
 * Interface for all factories that can create bi-directional interprocedural
 * control flow graphs.
 * 可以创建双向过程间控制流图的所有工厂的接口。
 * 
 * @author Steven Arzt
 * @author Marc-Andre Laverdiere-Papineau
 *
 */
public interface BiDirICFGFactory {
	
    public IInfoflowCFG buildBiDirICFG(CallgraphAlgorithm callgraphAlgorithm,
    		boolean enableExceptionTracking);

}
