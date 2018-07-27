package au.com.beutii.testframework.cucumber;

import java.util.HashMap;

import au.com.beutii.testframework.selenium.base.BasePageObject;

/**
 * Use ContextStorage.getThreadLocalInstance() in all steps to wire a shared object storage. 
 * The storage is used to pass information between steps.
 * @author r01
 *
 */
public class ContextStorage {
	
	private final HashMap<String,Object> storage = new HashMap<String,Object>();
	private static ThreadLocal<ContextStorage> threadLocalContext = new ThreadLocal<ContextStorage>(){
		@Override protected ContextStorage initialValue(){
			System.out.println("initialising thread local context for thread:"+Thread.currentThread().getName());
			return new ContextStorage();
		}
	};
	
	private ContextStorage(){}
	
	public static ContextStorage getThreadLocalInstance(){
		return threadLocalContext.get();
	}
	
	/**
	 * Store object in a thread local storage
	 * @param id - case insensetive
	 * @param obj
	 */
	public void put(String id, Object obj){
		storage.put(id.toUpperCase(), obj);
	}
	
	/**
	 * Retrieve an object from storage
	 * @param id - case insensetive
	 * @return object of requested type or null for a wrong type or empty object
	 */
	public Object get(String id){
		return storage.get(id.toUpperCase());
	}
	
	@SuppressWarnings("unchecked")
	public <V> V get(String id, Class<V> clazz){
		Object obj=get(id);
		if(obj==null || clazz.isAssignableFrom(obj.getClass())){
			return (V)obj;
		}
		System.err.println("Object type "+obj.getClass().getSimpleName()+" doesn't match with requested type "+clazz.getSimpleName());
		return null;
	}
	
	/**
	 * Empty storage. Ideally should be used once before test execution.
	 */
	public ContextStorage clearStorage(){
		storage.clear();
		return this;
	}

	/**
	 * Saves PageObject to context with id defined by class name
	 * @param pageObjectClass
	 * @return
	 */
	public <T extends BasePageObject> T get(Class<T> pageObjectClass){
		return get(pageObjectClass.getSimpleName(), pageObjectClass);
	}
	
	/**
	 * retrieves PageObject from context by class name
	 * @param pageObject
	 */
	public <T extends BasePageObject> T put(T pageObject){
		put(pageObject.getClass().getSimpleName(), pageObject);
		return pageObject;
	}
}
