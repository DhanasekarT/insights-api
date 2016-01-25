package org.gooru.insights.api.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gooru.insights.api.constants.ApiConstants;
import org.gooru.insights.api.models.ResponseParamDTO;
import org.gooru.insights.api.services.ClassV2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;

import rx.Observable;

@RestController
@RequestMapping(value="/v2/")
public class ClassV2Controller extends BaseController {

	@Autowired
	private ClassV2Service classService;

	private ClassV2Service getClassService() {
		return classService;
	}
	
	@RequestMapping(value = "/class/{classGooruId}/user/{userUid}/current/location", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public ModelAndView getUserCurrentLocationInLesson(HttpServletRequest request, 
			@PathVariable(value ="classGooruId") String classGooruId,
			@PathVariable(value="userUid") String userUid,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getUserCurrentLocationInLesson(userUid, classGooruId));
	}
	
	@RequestMapping(value = "/class/{classGooruId}/course/{courseGooruId}/peers", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public DeferredResult<ResponseParamDTO<Map<String, Object>>> getCoursePeers(HttpServletRequest request, 
			@PathVariable(value ="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		Observable<ResponseParamDTO<Map<String, Object>>> peersObserver = getClassService().getUserPeers(classGooruId, courseGooruId, null, null, ApiConstants.UNIT);
		DeferredResult<ResponseParamDTO<Map<String, Object>>> defferedResponse = new DeferredResult<>();
		peersObserver.subscribe(m -> defferedResponse.setResult(m), e -> defferedResponse.setErrorResult(e));
		return defferedResponse;
	}
	
	@RequestMapping(value = "/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/peers", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public DeferredResult<ResponseParamDTO<Map<String, Object>>> getUnitPeers(HttpServletRequest request, 
			@PathVariable(value ="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId,
			@PathVariable(value="unitGooruId") String unitGooruId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		Observable<ResponseParamDTO<Map<String, Object>>> peersObserver = getClassService().getUserPeers(classGooruId, courseGooruId, unitGooruId, null, ApiConstants.LESSON);
		DeferredResult<ResponseParamDTO<Map<String, Object>>> defferedResponse = new DeferredResult<>();
		peersObserver.subscribe(m -> defferedResponse.setResult(m), e -> defferedResponse.setErrorResult(e));
		return defferedResponse;
	}
	
	@RequestMapping(value = "/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGooruId}/peers", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public DeferredResult<ResponseParamDTO<Map<String, Object>>> getLessonPeers(HttpServletRequest request, 
			@PathVariable(value ="classGooruId") String classGooruId,
			@PathVariable(value="courseGooruId") String courseGooruId,
			@PathVariable(value="unitGooruId") String unitGooruId,
			@PathVariable(value="lessonGooruId") String lessonGooruId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		Observable<ResponseParamDTO<Map<String, Object>>> peersObserver = getClassService().getUserPeers(classGooruId, courseGooruId, unitGooruId, lessonGooruId, ApiConstants.CONTENT);
		DeferredResult<ResponseParamDTO<Map<String, Object>>> defferedResponse = new DeferredResult<>();
		peersObserver.subscribe(m -> defferedResponse.setResult(m), e -> defferedResponse.setErrorResult(e));
		return defferedResponse;
	}
	
	@RequestMapping(value = "{collectionType}/{contentGooruId}/user/{userUId}/session/{sessionId}/status", method = {RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getSessionStatus(HttpServletRequest request, @PathVariable(value = "userUId") String userUId,
			@PathVariable(value = "sessionId") String sessionId,
			@PathVariable(value = "contentGooruId") String contentGooruId,
			@PathVariable(value = "collectionType") String collectionType, HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getSessionStatus(contentGooruId, userUId, sessionId));
	}
	
	@RequestMapping(value="/{collectionType}/{contentGooruId}/sessions",method ={ RequestMethod.GET,RequestMethod.POST})
	//TODO @AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getUserSessions(HttpServletRequest request, 
			@RequestParam(value="classGooruId", required = false) String classGooruId,
			@RequestParam(value="courseGooruId", required = false) String courseGooruId, 
			@RequestParam(value="unitGooruId", required = false) String unitGooruId, 
			@RequestParam(value="lessonGooruId", required = false) String lessonGooruId,
			@PathVariable(value="collectionType") String collectionType, 
			@PathVariable(value="contentGooruId") String contentGooruId,
			@RequestParam(value="userUid", required = true) String userUid,
			HttpServletResponse response) throws Exception{
		setAllowOrigin(response);
		return getModel(getClassService().getUserSessions(classGooruId, courseGooruId, unitGooruId, lessonGooruId, contentGooruId, collectionType, userUid));
	}
	
	@RequestMapping(value="/{collectionType}/{contentGooruId}/user/{userUid}",method ={ RequestMethod.GET,RequestMethod.POST})
	// TODO @AuthorizeOperations(operations =  InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	@ResponseBody
	public ModelAndView getSummaryData(HttpServletRequest request, 
			@PathVariable(value="collectionType") String collectionType, @PathVariable(value="userUid") String userUid, 
			@RequestParam(value="sessionId", required = false) String sessionId, @RequestParam(value="classGooruId", required = false) String classGooruId,
			@RequestParam(value="courseGooruId", required = false) String courseGooruId, @RequestParam(value="unitGooruId", required = false) String unitGooruId, 
			@RequestParam(value="lessonGooruId", required = false) String lessonGooruId, @PathVariable(value="contentGooruId") String contentGooruId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getSummaryData(classGooruId, courseGooruId, unitGooruId, lessonGooruId, contentGooruId, sessionId, userUid, collectionType));
	}

	@RequestMapping(value = "/class/{classGooruId}/course/{courseGooruId}/performance", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public DeferredResult<ResponseParamDTO<Map<String, Object>>> getCoursePerformance(HttpServletRequest request, 
			@PathVariable(value ="classGooruId") String classGooruId,
			@PathVariable(value = "courseGooruId") String courseGooruId,
			@RequestParam(value = "userUid", required = false) String userUid,
			@RequestParam(value = "collectionType", required = true) String collectionType,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		Observable<ResponseParamDTO<Map<String, Object>>> performanceObserver = getClassService().getPerformance(classGooruId, courseGooruId, null, null, userUid, collectionType, ApiConstants.UNIT);
		DeferredResult<ResponseParamDTO<Map<String, Object>>> defferedResponse = new DeferredResult<>();
		performanceObserver.subscribe(m -> defferedResponse.setResult(m), e -> defferedResponse.setErrorResult(e));
		return defferedResponse;
	}
	
	@RequestMapping(value = "/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/performance", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public DeferredResult<ResponseParamDTO<Map<String, Object>>> getUnitPerformance(HttpServletRequest request, 
			@PathVariable(value ="classGooruId") String classGooruId,
			@PathVariable(value = "courseGooruId") String courseGooruId,
			@PathVariable(value = "unitGooruId") String unitGooruId,
			@RequestParam(value = "userUid", required = false) String userUid,
			@RequestParam(value = "collectionType", required = true) String collectionType,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		Observable<ResponseParamDTO<Map<String, Object>>> performanceObserver = getClassService().getPerformance(classGooruId, courseGooruId, unitGooruId, null, userUid, collectionType, ApiConstants.LESSON);
		DeferredResult<ResponseParamDTO<Map<String, Object>>> defferedResponse = new DeferredResult<>();
		performanceObserver.subscribe(m -> defferedResponse.setResult(m), e -> defferedResponse.setErrorResult(e));
		return defferedResponse;
	}
	
	@RequestMapping(value = "/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGooruId}/performance", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public DeferredResult<ResponseParamDTO<Map<String, Object>>> getLessonPerformance(HttpServletRequest request, 
			@PathVariable(value = "classGooruId") String classGooruId,
			@PathVariable(value = "courseGooruId") String courseGooruId,
			@PathVariable(value = "unitGooruId") String unitGooruId,
			@PathVariable(value = "lessonGooruId") String lessonGooruId,
			@RequestParam(value = "userUid", required = false) String userUid,
			@RequestParam(value = "collectionType", required = true) String collectionType, 
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		Observable<ResponseParamDTO<Map<String, Object>>> performanceObserver = getClassService().getPerformance(classGooruId, courseGooruId, unitGooruId, lessonGooruId, userUid, collectionType, ApiConstants.CONTENT);
		DeferredResult<ResponseParamDTO<Map<String, Object>>> defferedResponse = new DeferredResult<>();
		performanceObserver.subscribe(m -> defferedResponse.setResult(m), e -> defferedResponse.setErrorResult(e));
		return defferedResponse;
	}
	
	@RequestMapping(value = "/class/{classGooruId}/course/{courseGooruId}/unit/{unitGooruId}/lesson/{lessonGooruId}/{collectionType}/{contentGooruId}/performance", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public DeferredResult<ResponseParamDTO<Map<String, Object>>> getAllStudentContentPerformance(HttpServletRequest request, 
			@PathVariable(value = "classGooruId") String classGooruId,
			@PathVariable(value = "courseGooruId") String courseGooruId,
			@PathVariable(value = "unitGooruId") String unitGooruId,
			@PathVariable(value = "lessonGooruId") String lessonGooruId,
			@PathVariable(value = "contentGooruId") String contentGooruId,
			@PathVariable(value = "collectionType") String collectionType,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		Observable<ResponseParamDTO<Map<String, Object>>> performanceObserver = getClassService().getAllStudentPerformance(classGooruId, courseGooruId, unitGooruId, lessonGooruId, contentGooruId, collectionType);
		DeferredResult<ResponseParamDTO<Map<String, Object>>> defferedResponse = new DeferredResult<>();
		performanceObserver.subscribe(m -> defferedResponse.setResult(m), e -> defferedResponse.setErrorResult(e));
		return defferedResponse;
	}
	
	@RequestMapping(value = "/user/{userUid}/taxonomy/subject/{subjectId}/mastery", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public ModelAndView getUserSubjectMastery(HttpServletRequest request, 
			@PathVariable(value = "userUid") String userUid, @PathVariable(value = "subjectId") String subjectId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getStudentTaxonomyPerformance(userUid, subjectId, null, null, null, null, null, 1));
	}
	
	@RequestMapping(value = "/user/{userUid}/taxonomy/subject/{subjectId}/course/{courseId}/mastery", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public ModelAndView getUserCourseMastery(HttpServletRequest request, 
			@PathVariable(value = "userUid") String userUid, @PathVariable(value = "subjectId") String subjectId,
			@PathVariable(value = "courseId") String courseId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getStudentTaxonomyPerformance(userUid, subjectId, courseId, null, null, null, null, 2));
	}
	
	@RequestMapping(value = "/user/{userUid}/taxonomy/subject/{subjectId}/course/{courseId}/domain/{domainId}/mastery", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public ModelAndView getUserDomainMastery(HttpServletRequest request, 
			@PathVariable(value = "userUid") String userUid, @PathVariable(value = "subjectId") String subjectId,
			@PathVariable(value = "courseId") String courseId, @PathVariable(value = "domainId") String domainId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getStudentTaxonomyPerformance(userUid, subjectId, courseId, domainId, null, null, null, 3));
	}
	
	@RequestMapping(value = "/user/{userUid}/taxonomy/subject/{subjectId}/course/{courseId}/domain/{domainId}/subdomain/{subdomainId}/mastery", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public ModelAndView getUserSubDomainMastery(HttpServletRequest request, 
			@PathVariable(value = "userUid") String userUid, @PathVariable(value = "subjectId") String subjectId,
			@PathVariable(value = "courseId") String courseId, @PathVariable(value = "domainId") String domainId,
			@PathVariable(value = "subdomainId") String subdomainId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getStudentTaxonomyPerformance(userUid, subjectId, courseId, domainId, subdomainId, null, null, 4));
	}
	
	@RequestMapping(value = "/user/{userUid}/taxonomy/subject/{subjectId}/course/{courseId}/domain/{domainId}/subdomain/{subdomainId}/standards/{standardsId}/mastery", method = { RequestMethod.GET, RequestMethod.POST })
	//TODO @AuthorizeOperations(operations =InsightsOperationConstants.OPERATION_INSIHGHTS_REPORTS_VIEWS)
	public ModelAndView getUserStandardsMastery(HttpServletRequest request, 
			@PathVariable(value = "userUid") String userUid, @PathVariable(value = "subjectId") String subjectId,
			@PathVariable(value = "courseId") String courseId, @PathVariable(value = "domainId") String domainId,
			@PathVariable(value = "subdomainId") String subdomainId, @PathVariable(value = "standardsId") String standardsId,
			HttpServletResponse response) throws Exception {
		setAllowOrigin(response);
		return getModel(getClassService().getStudentTaxonomyPerformance(userUid, subjectId, courseId, domainId, subdomainId, standardsId, null, 5));
	}
	
}