package com.taint.analysis.result;

import soot.jimple.infoflow.handlers.ResultsAvailableHandler;
import soot.jimple.infoflow.results.InfoflowResults;
import soot.jimple.infoflow.solver.cfg.IInfoflowCFG;

public class ResultAggreator implements ResultsAvailableHandler {

    private final InfoflowResults aggregatedResults = new InfoflowResults();
    private InfoflowResults lastResults = null;
    private IInfoflowCFG lastICFG = null;

    @Override
    public void onResultsAvailable(IInfoflowCFG cfg, InfoflowResults results) {
      this.aggregatedResults.addAll(results);
      this.lastResults = results;
      this.lastICFG = cfg;
    }

    /**
     * Gets all data flow results aggregated so far
     *
     * @return All data flow results aggregated so far
     */
    public InfoflowResults getAggregatedResults() {
      return this.aggregatedResults;
    }

    /**
     * Gets the total number of source-to-sink connections from the last partial
     * result that was added to this aggregator
     *
     * @return The results from the last run of the data flow analysis
     */
    public InfoflowResults getLastResults() {
      return this.lastResults;
    }

    /**
     * Clears the stored result set from the last data flow run
     */
    public void clearLastResults() {
      this.lastResults = null;
      this.lastICFG = null;
    }

    /**
     * Gets the ICFG that was returned together with the last set of data flow
     * results
     *
     * @return The ICFG that was returned together with the last set of data flow
     *         results
     */
    public IInfoflowCFG getLastICFG() {
      return this.lastICFG;
    }


}
