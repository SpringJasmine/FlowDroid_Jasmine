package soot.jimple.infoflow.results;

import java.util.ArrayList;

public class PathInfo {
    private ResultSourceInfo startStmt;
    private ResultSinkInfo endStmt;
    private ArrayList<ResultSourceInfo> path;

    public PathInfo(ResultSourceInfo startStmt, ResultSinkInfo endStmt, ArrayList<ResultSourceInfo> path) {
        this.startStmt = startStmt;
        this.endStmt = endStmt;
        this.path = path;
    }

    public ResultSourceInfo getStartStmt() {
        return startStmt;
    }

    public void setStartStmt(ResultSourceInfo startStmt) {
        this.startStmt = startStmt;
    }

    public ResultSinkInfo getEndStmt() {
        return endStmt;
    }

    public void setEndStmt(ResultSinkInfo endStmt) {
        this.endStmt = endStmt;
    }

    public ArrayList<ResultSourceInfo> getPath() {
        return path;
    }

    public void setPath(ArrayList<ResultSourceInfo> path) {
        this.path = path;
    }
}
