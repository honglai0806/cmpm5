package model;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.User;

public class RestFB {
	
	public static String getToken(final String code) throws ClientProtocolException, IOException {
		String link = String.format(Constants.FACEBOOK_LINK_GET_TOKEN, Constants.FACEBOOK_APP_ID, Constants.FACEBOOK_APP_SECRET, Constants.FACEBOOK_REDIRECT_URL, code);
		String response = Request.Get(link).execute().returnContent().asString();
		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		//9. trả về mã chuỗi truy cập AccessToken
		return accessToken;
	}
	
	public static User getUserInfo(String accessToken) {
		//11. Tạo kết nối mã truy cập và mã bảo mật ứng dụng:DefaultFacebookClient(accessToken, Constants.FACEBOOK_APP_
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken, Constants.FACEBOOK_APP_SECRET, Version.LATEST);
		//12. Tìm kiếm User "me" trong session và trả về:
		return facebookClient.fetchObject("me", User.class);
	}

}
