package com.mimacom.hackathon.flowable.heatmap;

import static java.lang.System.out;
import static org.apache.log4j.BasicConfigurator.configure;
import static org.apache.log4j.Level.INFO;
import static org.apache.log4j.Logger.getRootLogger;

public class FlowableHeatmapRestApp {

	public static void main(String[] args) {
		configure();
		getRootLogger().setLevel(INFO);

		out.println("Flowable Heatmap Rest endpoint");
		out.println();
		if (args.length == 3) {
			new FlowableHeatmapRest(new FlowableRestClient(args[0], args[1], args[2])).start();
		} else {
			out.println("Provides REST endpoint which fetches heatmap data of a Flowable process based on its historic activity.");
			out.println();
			out.println("Usage: java -jar flowable-heatmap-rest.jar [user] [password] [flowable-rest-path]");
			out.println("       http://localhost:4567/flowableHeatmapData/{processId}");
			out.println("       e.g. java -jar flowable-heatmap-rest.jar admin test http://localhost:8080/flowable-rest/service");
			out.println("            http://localhost:4567/flowableHeatmapData/simple-process:2:8a6d9178-6f16-11e8-b145-9215f1035995");

		}
	}
}
