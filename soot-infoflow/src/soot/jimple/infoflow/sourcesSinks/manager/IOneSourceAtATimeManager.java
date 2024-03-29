package soot.jimple.infoflow.sourcesSinks.manager;

/**
 * Interface for source/sink managers that support calculating data flows with
 * one source at a time
 * source/sink管理器接口，支持一次使用一个source计算数据流
 * 
 * @author Steven Arzt
 *
 */
public interface IOneSourceAtATimeManager {
	
	/**
	 * Sets whether this source/sink manager shall run with one source at a time
	 * instead of all of them together
	 * @param enabled True to return only one source at a time and hide all other
	 * ones, otherwise false
	 */
	public void setOneSourceAtATimeEnabled(boolean enabled);
	
	/**
	 * Gets whether this source/sink manager shall run with one source at a time
	 * instead of all of them together
	 * @return True to return only one source at a time and hide all other ones,
	 * otherwise false
	 */
	public boolean isOneSourceAtATimeEnabled();
	
	/**
	 * Resets the iterator. This means that the source/sink manager starts again
	 * with the first source.
	 * 重置迭代器。这意味着source/sink管理器再次从第一个source开始。
	 */
	public void resetCurrentSource();
	
	/**
	 * Advances the iterator to the next source.
	 */
	public void nextSource();
	
	/**
	 * Checks whether there is another source with which to run the data flow
	 * analysis
	 * @return True if there is another source with which to run the data flow
	 * analysis, otherwise false
	 */
	public boolean hasNextSource();

}
