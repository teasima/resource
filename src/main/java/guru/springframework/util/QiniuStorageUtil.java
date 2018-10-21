package guru.springframework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;

public class QiniuStorageUtil {

	public static String ACCESS_KEY = "OfgshFkN1ZcaHMOiAHBwND0kQpAkaQ9zWLXe_Fv7";
	
	public static final String SECRET_KEY = "J11s9NvfyKUsbBsMBXlU7HQ9v7wAboz0LSP7Ww57";
	
	public static final String LIANAO_DOMAIN = "szlianao.qiniudn.com";
	
	public static final String DEFAUT_BUCKET = "szlianao";
	
	public static final PutExtra extra = new PutExtra();
	
	public static final GetPolicy getPolicy = new GetPolicy();
	
	public static Mac mac;
	
	static {
		getMac();
	}
	
	public static synchronized Mac getMac(){
		if(mac != null){
			return mac;
		}
		Config.ACCESS_KEY = ACCESS_KEY;
		Config.SECRET_KEY = SECRET_KEY;
		mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		return mac;
	}
	
	public static String getUptoken(String bucketName){
		PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken="";
		try {
			uptoken = putPolicy.token(mac);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return uptoken;
	}
	
	public static String upload(String bucketName, String localFile){
		String uptoken = getUptoken(bucketName);
		PutRet ret = IoApi.putFile(uptoken, null, localFile, extra);
		if(ret.ok()){
			return ret.getKey();
		}
		return null;
	}
	
	public static String upload(InputStream inputStream){
		return upload(DEFAUT_BUCKET, inputStream);
	}
	
	public static String upload(String bucketName, InputStream inputStream){
		String uptoken = getUptoken(bucketName);
		PutRet ret = IoApi.Put(uptoken, null, inputStream, extra);
		if(ret.ok()){
			return ret.getKey();
		}
		return null;
	}
 
	/**
	 * http://developer.qiniu.com/docs/v6/api/reference/fop/image/imageview2.html
	 * 七牛格式输出图片处理
	 * @param key
	 * @return
	 */
    public static String getImageURL(String key){
        String baseUrl = "";
		try {
			// baseUrl = URLUtils.makeBaseUrl(LIANAO_DOMAIN, key);
			// return getPolicy.makeRequest(baseUrl, mac);
			return "http://"+LIANAO_DOMAIN+"/"+key;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }

    
	public static void main(String[] args) throws Exception{
		// uploadLocalFile("szlianao", "C://1.jpg");
		File file = new File("C://Users//hp//Pictures//a.jpg");
		InputStream fis = new FileInputStream(file);
		String code = upload("szlianao", fis);
		System.out.println();
		fis.close();
		System.out.println(getImageURL(code));
	}
}
