package edu.umich.umms.profile.marshalling;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class XJaxbJacksonObjectMapper extends ObjectMapper {

	public XJaxbJacksonObjectMapper() {
		final AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
		super.getDeserializationConfig()
				.setAnnotationIntrospector(introspector);
		super.getSerializationConfig().setAnnotationIntrospector(introspector);
	}

}
