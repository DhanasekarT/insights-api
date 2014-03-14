/*******************************************************************************
 * UserCredential.java
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
import java.util.List;
import java.util.Map;

public class UserCredential implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7571980092817997801L;


	private String organizationNfsInternalPath;
	
	private String organizationNfsRealPath;
	
	private String organizationUid;

	private String userUid;

	private String defaultGroupUid;

	private String partyPermitsAsString;

	private String[] partyPermits;
	
	private List<String> operationAuthorities;

	private String orgPermitsAsString;

	private String[] orgPermits;

	private String key;

	private String token;
	
	private Integer apiKeySearchLimit;
	
	private Boolean isAdminAccessContent;
	
	private String primaryOrganizatoinUid;
	
	private List<String> partyOperations;
	
	private List<String> subOrganizationUids;
	
	private String subOrganizationUidsString;
	
	private String taxonomyPreference;
	
	private String organizationCdnDirectPath;
	
	private Map<String, String> error;
	
	private Map<String, Map<String, String>> meta;
	
	private String sharedSecretKey;
	
	private String storedSecretKey;

	public String getOrganizationUid() {
		return organizationUid;
	}

	public void setOrganizationUid(String organizationUid) {
		this.organizationUid = organizationUid;
	}

	public String getUserUid() {
		return userUid;
	}

	public void setUserUid(String userUid) {
		this.userUid = userUid;
	}

	public String getDefaultGroupUid() {
		return defaultGroupUid;
	}

	public void setDefaultGroupUid(String defaultGroupUid) {
		this.defaultGroupUid = defaultGroupUid;
	}

	public String getPartyPermitsAsString() {
		return partyPermitsAsString;
	}

	public void setPartyPermitsAsString(String partyPermitsAsString) {
		this.partyPermitsAsString = partyPermitsAsString;
	}

	public String[] getPartyPermits() {
		return partyPermits;
	}

	public void setPartyPermits(String[] partyPermits) {
		this.partyPermits = partyPermits;
	}

	public String getOrgPermitsAsString() {
		return orgPermitsAsString;
	}

	public void setOrgPermitsAsString(String orgPermitsAsString) {
		this.orgPermitsAsString = orgPermitsAsString;
	}

	public String[] getOrgPermits() {
		return orgPermits;
	}

	public void setOrgPermits(String[] orgPermits) {
		this.orgPermits = orgPermits;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<String> getOperationAuthorities() {
		return operationAuthorities;
	}

	public void setOperationAuthorities(List<String> operationAuthorities) {
		this.operationAuthorities = operationAuthorities;
	}

	public String getOrganizationNfsInternalPath() {
		return organizationNfsInternalPath;
	}

	public void setOrganizationNfsInternalPath(String organizationNfsInternalPath) {
		this.organizationNfsInternalPath = organizationNfsInternalPath;
	}

	public String getOrganizationNfsRealPath() {
		return organizationNfsRealPath;
	}

	public void setOrganizationNfsRealPath(String organizationNfsRealPath) {
		this.organizationNfsRealPath = organizationNfsRealPath;
	}

	public Integer getApiKeySearchLimit() {
		return apiKeySearchLimit;
	}

	public void setApiKeySearchLimit(Integer apiKeySearchLimit) {
		this.apiKeySearchLimit = apiKeySearchLimit;
	}

	public Boolean getIsAdminAccessContent() {
		return isAdminAccessContent;
	}

	public void setIsAdminAccessContent(Boolean isAdminAccessContent) {
		this.isAdminAccessContent = isAdminAccessContent;
	}

	public String getPrimaryOrganizatoinUid() {
		return primaryOrganizatoinUid;
	}

	public void setPrimaryOrganizatoinUid(String primaryOrganizatoinUid) {
		this.primaryOrganizatoinUid = primaryOrganizatoinUid;
	}

	public void setPartyOperations(List<String> partyOperations) {
		this.partyOperations = partyOperations;
	}

	public List<String> getPartyOperations() {
		return partyOperations;
	}

	public void setSubOrganizationUids(List<String> subOrganizationUids) {
		this.subOrganizationUids = subOrganizationUids;
	}

	public List<String> getSubOrganizationUids() {
		return subOrganizationUids;
	}

	public void setSubOrganizationUidsString(String subOrganizationUidsString) {
		this.subOrganizationUidsString = subOrganizationUidsString;
	}

	public String getSubOrganizationUidsString() {
		return subOrganizationUidsString;
	}

	public void setTaxonomyPreference(String taxonomyPreference) {
		this.taxonomyPreference = taxonomyPreference;
	}

	public String getTaxonomyPreference() {
		return taxonomyPreference;
	}

	public void setOrganizationCdnDirectPath(String organizationCdnDirectPath) {
		this.organizationCdnDirectPath = organizationCdnDirectPath;
	}

	public String getOrganizationCdnDirectPath() {
		return organizationCdnDirectPath;
	}

	public void setError(Map<String, String> error) {
		this.error = error;
	}

	public Map<String, String> getError() {
		return error;
	}

	public void setMeta(Map<String, Map<String, String>> meta) {
		this.meta = meta;
	}

	public Map<String, Map<String, String>> getMeta() {
		return meta;
	}

	public void setSharedSecretKey(String sharedSecretKey) {
		this.sharedSecretKey = sharedSecretKey;
	}

	public String getSharedSecretKey() {
		return sharedSecretKey;
	}

	public void setStoredSecretKey(String storedSecretKey) {
		this.storedSecretKey = storedSecretKey;
	}

	public String getStoredSecretKey() {
		return storedSecretKey;
	}
}
