package org.gooru.insights.api.controllers;

import javax.servlet.http.HttpServletResponse;

import org.gooru.insights.api.constants.ApiConstants;
import org.gooru.insights.api.constants.ApiConstants.modelAttributes;
import org.gooru.insights.api.models.ResponseParamDTO;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import flexjson.JSONSerializer;
import rx.Observable;

public class BaseController {
	
	
	@Deprecated
	public <M> ModelAndView getModel(ResponseParamDTO<M> data) {

		ModelAndView model = new ModelAndView(modelAttributes.VIEW_NAME.getAttribute());
		model.addObject(modelAttributes.RETURN_NAME.getAttribute() , new JSONSerializer().exclude(ApiConstants.EXCLUDE_CLASSES).deepSerialize(data));
		return model;
	}
	
	public <M> DeferredResult<M> getDeferredResult(Observable<M> peersObserver) {
		DeferredResult<M> defferedResponse = new DeferredResult<>();
		peersObserver.subscribe(m -> defferedResponse.setResult(m), e -> defferedResponse.setErrorResult(e));
		return defferedResponse;
	}
	
	public HttpServletResponse setAllowOrigin(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
		response.setHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE");
		return response;
	}
	
}
