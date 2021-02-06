package tn.booky.corp.services;
import java.io.File;
import java.io.IOException;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
/**
 * @author gharbimedaziz
 */
public class UploadToCloudinary {
	Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "dreevo-cloud",
			"api_key", "593145193212868",
			"api_secret", "ZGzJwvMk_Hp3a6FhZ7gdFg_f3TU"));
	
	public void uploadImage(String imageUrl) throws IOException{
		File file = new File(imageUrl);
		cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	}
}
