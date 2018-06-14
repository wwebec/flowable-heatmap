package com.mimacom.hackathon.flowable.heatmap;

import static com.mashape.unirest.http.Unirest.get;

import com.mashape.unirest.http.exceptions.UnirestException;

public class FlowableRestClient {
	private static final String PROCESS_ID_PARAM = "processId";
	private static final String BPMN_XML_PATH = "%s/repository/process-definitions/{" + PROCESS_ID_PARAM + "}/resourcedata";

	private static final String ACTIVITY_ID_PARAM = "activityId";
	private static final String HISTORIC_ACTIVITY_INSTANCES_PATH = "%s/history/historic-activity-instances?activityId={" + ACTIVITY_ID_PARAM + "}";
	private static final String TOTAL_IDX = "total";

	private final String user;
	private final String password;
	private final String restPath;

	public FlowableRestClient(String user, String password, String restPath) {
		this.user = user;
		this.password = password;
		this.restPath = restPath;
	}

	public int getSidToTotal(String sid) {
		try {
			return get(String.format(HISTORIC_ACTIVITY_INSTANCES_PATH, restPath))
					.routeParam(ACTIVITY_ID_PARAM, sid)
					.basicAuth(user, password)
					.asJson()
					.getBody()
					.getObject()
					.getInt(TOTAL_IDX);
		} catch (UnirestException e) {
			return 0;
		}
	}

	public String getBpmnXml(String processId) throws UnirestException {
		return get(String.format(BPMN_XML_PATH,restPath))
				.routeParam(PROCESS_ID_PARAM, processId)
				.basicAuth(user, password)
				.asString().getBody();
	}
}
