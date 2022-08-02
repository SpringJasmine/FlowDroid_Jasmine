package com.taint.analysis.infoflow;

import com.taint.analysis.sourceandsink.EntryPointManager;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import soot.SootMethod;
import soot.jimple.infoflow.Infoflow;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;
import soot.jimple.infoflow.sourcesSinks.manager.ISourceSinkManager;

public class MyInfoFlow extends Infoflow implements IMyInfoFlow  {

  public MyInfoFlow(){
    super(null,false,null);
  }
  @Override
  public void runAnalysis(ISourceSinkManager sourcesSinks, SootMethod entryPoint) {
    super.runAnalysis(sourcesSinks);
  }

  protected Collection<SootMethod> getMethodsForSeeds(IInfoflowCFG icfg) {
    List<SootMethod> seeds = new LinkedList<SootMethod>();
    // If we have a callgraph, we retrieve the reachable methods. Otherwise,
    // we have no choice but take all application methods as an
    // approximation
    EntryPointManager manager = new EntryPointManager();
    manager.loadJavaEntryPoints();
    List<SootMethod> methods= manager.getEntryPoints();
    seeds.addAll(methods);
    return seeds;
  }
}
