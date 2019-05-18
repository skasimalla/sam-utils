package com.Sam.Util;

/**
 * @author Samuel Kasimalla
 *
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SolrUtil {
	private static String LABEL = "label";
	private static String VALUE = "value";

	public static void main(String[] args) {
		new SolrUtil().index(null);
	}

	static Logger logger = LoggerFactory.getLogger(SolrUtil.class);
	static StringBuffer sb = new StringBuffer();

	public String index(String accessToken) {
		String str;
		try {
			if (accessToken == null)
				accessToken = FileUtil.getInstance().getProp("accessToken");
			String baseUrl = FileUtil.getInstance().getProp("baseUrl");
			String api = FileUtil.getInstance().getProp("api");
			String deleteByQuery = "*:*";
			String accessTokenArg = "?access_token=" + accessToken;
			HashMap<String, String> hm = new HashMap<String, String>();
			HashMap<String, String> hm2 = new HashMap<String, String>();
			ArrayList al = new ArrayList();
			JSONParser jp = new JSONParser();
			HttpSolrClient sc = new HttpSolrClient.Builder(baseUrl).build();
			sc.deleteByQuery(deleteByQuery);
			sc.commit();
		
			String localAPIString = URLUtil.getInstance().readUrl(localAPI + accessTokenArg);
			JSONArray ja = (JSONArray) jp.parse(localizationAPIString);
			logStringBufferAndReturn("chkpt2" + ja.size());
		
			for (String lang : hm.keySet()) {
				logStringBufferAndReturn("Running for lang " + lang);
			
						SolrInputDocument si = new SolrInputDocument();
						JSONObject jo = (JSONObject) ja1.get(i);
						si.addField("id", jo.get("id"));
						si.addField("2", jo.get("keywords"));
						List<String> li = new ArrayList<String>();
						//For multiple values in a field
						for (int j = 0; j < ja2.size(); j++) {
							JSONObject jo211 = (JSONObject) ja2.get(j);
							JSONObject jo2111 = (JSONObject) jo211.get(LABEL);
							String elementKey = jo2111.get("localKey").toString();
							si.addField("all_elements", hm2.get(lang + "^^" + elementKey));
						}
						sc.add(si);
						if (i % 100 == 0)
							sc.commit();
					}
				} catch (SolrServerException e) {
					e.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				sc.commit();
			}
		} catch (IOException | SolrServerException | ParseException e) {
			e.printStackTrace();
		}
		JSONObject joReturn = new JSONObject();
		joReturn.put("return", sb.toString());
		return joReturn.toString();
	}

	static String logStringBufferAndReturn(String str) {
		logger.info(str);
		System.out.println(str);
		sb.append(str + "\n");
		return str;
	}

	static String getListOfValues(HashMap hm, String lang, String key) {
		return (String) hm.get(lang + "^^" + key);
	}
}
