package com.mimacom.hackathon.flowable.heatmap;

import static spark.Spark.get;

import com.google.gson.Gson;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mimacom.hackathon.flowable.heatmap.model.HeatmapData;

public class FlowableHeatmapRest {
	private static final String PROCESS_ID_PARAM = ":processId";
	private static String HEATMAP_DATA_PATH = "/flowableHeatmapData/" + PROCESS_ID_PARAM;

	private final FlowableRestClient flowableRestClient;

	public FlowableHeatmapRest(FlowableRestClient flowableRestClient) {
		this.flowableRestClient = flowableRestClient;
	}

	public void start() {
		Gson gson = new Gson();
		get(HEATMAP_DATA_PATH, "application/json", (req, res) -> getHeatmapData(req.params(PROCESS_ID_PARAM)), gson::toJson);
	}

	private HeatmapData getHeatmapData(String pid) throws UnirestException {
		return new HeatmapDataExtractor().provide(flowableRestClient.getBpmnXml(pid), flowableRestClient::getSidToTotal);
	}
}
