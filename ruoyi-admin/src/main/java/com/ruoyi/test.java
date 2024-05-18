package com.ruoyi;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.lang.Thread;
import org.apache.commons.lang3.StringUtils;


public class test {
    //u_key
    public static String ukey;
    //s_key
    public static String sKey="udycfyhgx457k23l";
    //账号
    public static String account="yagao321";
    //密码
    public static String pwd="yagao321";

    //DY用户Uid
    public static String uId="1979601831854679";
    //DY用户sec_uid
    public static String secUid="MS4wLjABAAAA-tcIAqFMpY2zKiWDUUA2AEZCmgwNjbxg79MywZB_d0-nLQfsSrofY2xb89BWVyZt";
    public static String businessId="2";
    public static String shieldSoStatus="0";
    public static String onlyTw="0";

	public static void main(String[] args) throws IOException {
        ukey = getUKey();
        if (StringUtils.isNotBlank(ukey)){
            getRelation();
            String jsonString =  getTask(uId,businessId,secUid,shieldSoStatus,onlyTw);
            //Thread.sleep(5000);
            if (StringUtils.isNotBlank(jsonString)){
                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(jsonString);

                if ("200".equals(rootNode.get("code").asText())) {
                    //走DY协议进行关注操作
                    //Do something...
                    JsonNode dataNode = rootNode.get("data");
                    String orderId = dataNode.get("orderId").asText();
                    submitTask(orderId,"0");
                } else {
                    System.out.println("Error, response code:" + rootNode.get("code").asText());
                }
            }
        }
	}

    /**
     * 获取u_key
     * @return
     * @throws IOException
     */
    static String getUKey() throws IOException {
            URL url = new URL(String.format("http://task.06km.com/task-api/s/user/apiKey?account=%s&pwd=%s",account,pwd));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            // 发送GET请求
            connection.setRequestMethod("GET");

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                String jsonString = response.toString();
                System.out.println(jsonString);

                if (jsonString == null || jsonString.isEmpty()) {
                    throw new IOException("Error");
                }

                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(jsonString);

                return rootNode.get("data").asText();

    }

    /**
     * 获取用户关系
     * @throws IOException
     */
	static void getRelation() throws IOException {
		// 创建URL对象
		URL url = new URL(String.format("http://task.06km.com/task-api/s/user/relation/ukey?uKey=%s",ukey));
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Accept", "application/json");
		// 发送GET请求
		connection.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder response = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		reader.close();
		System.out.println(response);
	}

	/**
	 * @desc 获取任务
	 * @throws IOException
	 */
	//获取任务
	static String getTask(String uid,String businessId,String secUid,String shieldSoStatus,String onlyTw) throws IOException {
		// 创建URL对象
		URL url = new URL(String.format("http://task.06km.com/task-api/s/task/get?uid=%s&businessId=%s&secUid=%s&shieldSoStatus=%s&onlyTw=%s",uid,businessId,secUid,shieldSoStatus,onlyTw));
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("u_key", ukey);
		connection.setRequestProperty("s_key", sKey);
		// 发送GET请求
		connection.setRequestMethod("GET");
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder response = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		reader.close();
		System.out.println(response);
        return response.toString();
	}

	/**
	 * @desc 提交任务
	 *
	 */
	static void submitTask(String orderId, String isHs) throws IOException {
		// 创建URL对象
		URL url = new URL("http://task.06km.com/task-api/s/task/submit");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("u_key", ukey);
		connection.setRequestProperty("s_key", sKey);
		// 发送POST请求
		connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
		String requestBody = "{\"orderId\": \""+orderId+"\", \"isHs\": "+isHs+"}";
		out.writeBytes(requestBody);

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder response = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		reader.close();
		System.out.println(response.toString());
	}
}
