
package com.doublechaintech.uxs.pricefilter;
import com.doublechaintech.uxs.CommonTokens;
import java.util.Map;
public class PriceFilterTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="priceFilter";
	
	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){
		
		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner? 
			return false; 
		}
		
 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.			
 			return true;
 		}
 		
 		return false;
	
	}
	protected PriceFilterTokens(){
		//ensure not initialized outside the class
	}
	
	public PriceFilterTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}
	
	public static PriceFilterTokens mergeAll(String [] tokens){
		
		return allTokens().merge(tokens);
	}
	
	protected PriceFilterTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}
	
	
	public static PriceFilterTokens start(){
		return new PriceFilterTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}
	
	protected static PriceFilterTokens allTokens(){
		
		return start()
			.withProfile();
	
	}
	public static PriceFilterTokens withoutListsTokens(){
		
		return start()
			.withProfile();
	
	}
	
	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	protected static final String PROFILE = "profile";
	public String getProfile(){
		return PROFILE;
	}
	public PriceFilterTokens withProfile(){		
		addSimpleOptions(PROFILE);
		return this;
	}
	
	
	
	public  PriceFilterTokens searchEntireObjectText(String verb, String value){
		
		return this;
	}
}

