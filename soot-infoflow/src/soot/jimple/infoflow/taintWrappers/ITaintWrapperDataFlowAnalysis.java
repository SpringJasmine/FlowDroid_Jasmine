package soot.jimple.infoflow.taintWrappers;

/**
 * Common interface for all data flow analyses that support taint wrappers
 * 支持污点包装器的所有数据流分析的通用接口
 * 
 * @author Steven Arzt
 *
 */
public interface ITaintWrapperDataFlowAnalysis {

	/**
	 * Sets the taint wrapper to be used for propagating taints over unknown
	 * (library) callees. If this value is null, no taint wrapping is used.
	 * 设置污点包装器，用于在未知（库）被调用者上传播污点。 如果此值为空，则不使用污点包装。
	 * 
	 * @param taintWrapper
	 *            The taint wrapper to use or null to disable taint wrapping
	 */
	public void setTaintWrapper(ITaintPropagationWrapper taintWrapper);

	/**
	 * Gets the taint wrapper to be used for propagating taints over unknown
	 * (library) callees. If this value is null, no taint wrapping is used.
	 * 获取用于在未知（库）被调用者上传播污点的污点包装器。如果此值为空，则不使用污点包装。
	 * 
	 * @return The taint wrapper to use or null if taint wrapping is disabled
	 */
	public ITaintPropagationWrapper getTaintWrapper();

}
