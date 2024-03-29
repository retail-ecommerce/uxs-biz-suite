package com.doublechaintech.uxs.rating;
import com.doublechaintech.uxs.BaseForm;
import com.doublechaintech.uxs.genericform.GenericForm;
import com.doublechaintech.uxs.formfield.FormField;
import com.doublechaintech.uxs.formaction.FormAction;
import com.doublechaintech.uxs.formmessage.FormMessage;
import com.doublechaintech.uxs.formfieldmessage.FormFieldMessage;



public class RatingForm extends BaseForm {
	
	
	public RatingForm withTitle(String title){
		this.setId(System.currentTimeMillis()+"");
		this.setTitle(title);
		return this;
	}
	
	
	

	public RatingForm ratingIdField(String parameterName, String initValue){
		FormField field = idFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RatingForm ratingIdField(String initValue){
		return ratingIdField("ratingId",initValue);
	}
	public RatingForm ratingIdField(){
		return ratingIdField("ratingId","");
	}


	public RatingForm userIdField(String parameterName, String initValue){
		FormField field = userIdFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RatingForm userIdField(String initValue){
		return userIdField("userId",initValue);
	}
	public RatingForm userIdField(){
		return userIdField("userId","");
	}


	public RatingForm productIdField(String parameterName, String initValue){
		FormField field = productIdFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RatingForm productIdField(String initValue){
		return productIdField("productId",initValue);
	}
	public RatingForm productIdField(){
		return productIdField("productId","");
	}


	public RatingForm scoreField(String parameterName, String initValue){
		FormField field = scoreFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RatingForm scoreField(String initValue){
		return scoreField("score",initValue);
	}
	public RatingForm scoreField(){
		return scoreField("score","");
	}


	public RatingForm updateTimeField(String parameterName, String initValue){
		FormField field = updateTimeFromRating(parameterName, initValue);		
		this.addFormField(field);
		return this;
	}
	
	public RatingForm updateTimeField(String initValue){
		return updateTimeField("updateTime",initValue);
	}
	public RatingForm updateTimeField(){
		return updateTimeField("updateTime","");
	}

	
	


	public RatingForm profileIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  idFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm profileIdFieldOfProfile(String initValue){
		return profileIdFieldOfProfile("profileId",initValue);
	}
	public RatingForm profileIdFieldOfProfile(){
		return profileIdFieldOfProfile("profileId","");
	}


	public RatingForm nameFieldOfProfile(String parameterName, String initValue){
		FormField field =  nameFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm nameFieldOfProfile(String initValue){
		return nameFieldOfProfile("name",initValue);
	}
	public RatingForm nameFieldOfProfile(){
		return nameFieldOfProfile("name","");
	}


	public RatingForm platformIdFieldOfProfile(String parameterName, String initValue){
		FormField field =  platformIdFromProfile(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm platformIdFieldOfProfile(String initValue){
		return platformIdFieldOfProfile("platformId",initValue);
	}
	public RatingForm platformIdFieldOfProfile(){
		return platformIdFieldOfProfile("platformId","");
	}


	public RatingForm productIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  idFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm productIdFieldOfProduct(String initValue){
		return productIdFieldOfProduct("productId",initValue);
	}
	public RatingForm productIdFieldOfProduct(){
		return productIdFieldOfProduct("productId","");
	}


	public RatingForm nameFieldOfProduct(String parameterName, String initValue){
		FormField field =  nameFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm nameFieldOfProduct(String initValue){
		return nameFieldOfProduct("name",initValue);
	}
	public RatingForm nameFieldOfProduct(){
		return nameFieldOfProduct("name","");
	}


	public RatingForm parentCategoryIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  parentCategoryIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm parentCategoryIdFieldOfProduct(String initValue){
		return parentCategoryIdFieldOfProduct("parentCategoryId",initValue);
	}
	public RatingForm parentCategoryIdFieldOfProduct(){
		return parentCategoryIdFieldOfProduct("parentCategoryId","");
	}


	public RatingForm brandIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  brandIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm brandIdFieldOfProduct(String initValue){
		return brandIdFieldOfProduct("brandId",initValue);
	}
	public RatingForm brandIdFieldOfProduct(){
		return brandIdFieldOfProduct("brandId","");
	}


	public RatingForm productCoverImageFieldOfProduct(String parameterName, String initValue){
		FormField field =  productCoverImageFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm productCoverImageFieldOfProduct(String initValue){
		return productCoverImageFieldOfProduct("productCoverImage",initValue);
	}
	public RatingForm productCoverImageFieldOfProduct(){
		return productCoverImageFieldOfProduct("productCoverImage","");
	}


	public RatingForm originFieldOfProduct(String parameterName, String initValue){
		FormField field =  originFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm originFieldOfProduct(String initValue){
		return originFieldOfProduct("origin",initValue);
	}
	public RatingForm originFieldOfProduct(){
		return originFieldOfProduct("origin","");
	}


	public RatingForm catalogIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  catalogIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm catalogIdFieldOfProduct(String initValue){
		return catalogIdFieldOfProduct("catalogId",initValue);
	}
	public RatingForm catalogIdFieldOfProduct(){
		return catalogIdFieldOfProduct("catalogId","");
	}


	public RatingForm remarkFieldOfProduct(String parameterName, String initValue){
		FormField field =  remarkFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm remarkFieldOfProduct(String initValue){
		return remarkFieldOfProduct("remark",initValue);
	}
	public RatingForm remarkFieldOfProduct(){
		return remarkFieldOfProduct("remark","");
	}


	public RatingForm lastUpdateTimeFieldOfProduct(String parameterName, String initValue){
		FormField field =  lastUpdateTimeFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm lastUpdateTimeFieldOfProduct(String initValue){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime",initValue);
	}
	public RatingForm lastUpdateTimeFieldOfProduct(){
		return lastUpdateTimeFieldOfProduct("lastUpdateTime","");
	}


	public RatingForm platformIdFieldOfProduct(String parameterName, String initValue){
		FormField field =  platformIdFromProduct(parameterName, initValue);
		this.addFormField(field);	
		return this;
	}
	
	public RatingForm platformIdFieldOfProduct(String initValue){
		return platformIdFieldOfProduct("platformId",initValue);
	}
	public RatingForm platformIdFieldOfProduct(){
		return platformIdFieldOfProduct("platformId","");
	}

	


	

	
 	public RatingForm transferToAnotherUserAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherUser/ratingId/");
		this.addFormAction(action);
		return this;
	}

 	
 	public RatingForm transferToAnotherProductAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("transferToAnotherProduct/ratingId/");
		this.addFormAction(action);
		return this;
	}

 

	public RatingForm showAction(){
		FormAction action = new FormAction();
		action.setLabel("显示");
		action.setLocaleKey("show");
		action.setUrl("genericFormManager/show/title/desc/");
		this.addFormAction(action);
		return this;
	}
	
	
}


