package com.doublechaintech.uxs.product;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.uxs.UxsObjectPlainCustomSerializer;
public class ProductSerializer extends UxsObjectPlainCustomSerializer<Product>{

	@Override
	public void serialize(Product product, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, product, provider);
		
	}
}


