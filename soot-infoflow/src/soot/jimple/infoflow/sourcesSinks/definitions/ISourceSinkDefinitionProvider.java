package soot.jimple.infoflow.sourcesSinks.definitions;

import java.util.Set;

/**
 * Common interface for all classes that support loading source and sink
 * definitions
 * 支持加载source和sink定义的所有类的通用接口
 * 
 * @author Steven Arzt
 *
 */
public interface ISourceSinkDefinitionProvider {

	/**
	 * Gets a set of all sources registered in the provider
	 * 
	 * @return A set of all sources registered in the provider
	 */
	public Set<? extends ISourceSinkDefinition> getSources();

	/**
	 * Gets a set of all sinks registered in the provider
	 * 
	 * @return A set of all sinks registered in the provider
	 */
	public Set<? extends ISourceSinkDefinition> getSinks();

	/**
	 * Gets all methods for which there are source/sink definitions
	 * 
	 * @return A set containing all methods for which there is a source/sink
	 *         definition. This also includes methods explicitly labeled as
	 *         "neither".
	 */
	public Set<? extends ISourceSinkDefinition> getAllMethods();

}
