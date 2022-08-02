package com.taint.analysis.infoflow;


import soot.SootMethod;
import soot.jimple.infoflow.IInfoflow;
import soot.jimple.infoflow.sourcesSinks.manager.ISourceSinkManager;

public interface IMyInfoFlow extends IInfoflow {
   void runAnalysis(final ISourceSinkManager sourcesSinks, SootMethod entryPoint);

}
