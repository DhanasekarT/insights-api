/*******************************************************************************
 * RequestParamsDTO.java
 * insights-read-api
 * Created by Gooru on 2014
 * Copyright (c) 2014 Gooru. All rights reserved.
 * http://www.goorulearning.org/
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package org.gooru.insights.api.models;

import java.io.Serializable;
import org.gooru.insights.api.models.*;

public class RequestParamsDTO implements Serializable {

	private static final long serialVersionUID = -2840599796987757919L;

	private String fields;
	
	RequestParamsPaginationDTO paginate;
	
	RequestParamsFiltersDTO filters;
	
	RequestParamsSearchDTO search;
	
	private String groupBy;

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public RequestParamsFiltersDTO getFilters() {
		return filters;
	}

	public void setFilters(RequestParamsFiltersDTO filters) {
		this.filters = filters;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public RequestParamsPaginationDTO getPaginate() {
		return paginate;
	}

	public void setPaginate(RequestParamsPaginationDTO paginate) {
		this.paginate = paginate;
	}

	public RequestParamsSearchDTO getSearch() {
		return search;
	}

	public void setSearch(RequestParamsSearchDTO search) {
		this.search = search;
	}
	
	
	
}
