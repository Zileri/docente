package upeu.g1.rest.legajo.controller;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ErrorMensaje {

	private String code;
	private List<Map<String, String>> messages;
	
}
