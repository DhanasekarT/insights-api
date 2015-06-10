package org.gooru.insights.api.repository;

import java.util.List;
import java.util.Map;

public interface ClassRepository {

	List<Object[]> getSession(long parentId, long collectionId, String userUid);

	Long getContentId(String contentGooruOid);
	
	List<Map<String, Object>> getCollectionAggregatedDataByAllSession(long parentId,long collectionId);
	
	List<Map<String, Object>> getCollectionSessionData(long parentId,long collectionId,long sessionId);
	
	List<Map<String, Object>> getResourceSessionData(long parentId, long collectionId, long sessionId);		

	List<Map<String, Object>> getResourceAggregatedDataByAllSession(long parentId, long collectionId);
	
}
