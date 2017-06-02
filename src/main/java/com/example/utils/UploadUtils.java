package com.example.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;



public class UploadUtils {

	// 上传图片
	public static String uploadPic(byte[] pic, String name, Long size) throws Exception {

		// 扩展名
		String ext = name.substring(name.lastIndexOf(".")+1);
		String exts = "BMP、JPG、JPEG、PNG、GIF";
		if (!exts.contains(ext.toUpperCase())) {
//			throw new Exception("图片格式不支持");
		}
		// 上传图片
		NameValuePair[] meta_list = new NameValuePair[3];
		meta_list[0] = new NameValuePair("filename", name);
		meta_list[1] = new NameValuePair("fileext", ext);
		meta_list[2] = new NameValuePair("filesize", String.valueOf(size));
		StorageClient1 storageClient1 = getStorageClient();
		String path1 = storageClient1.upload_file1(pic, ext, meta_list);
		System.out.println(path1);
		String path = path1.substring(path1.indexOf("/") + 1);
		System.out.println(path);
		return path;
	}
	
	public static byte[] download(String name) throws Exception {
		StorageClient1 storageClient1 = getStorageClient();
		FileInfo get_file_info = storageClient1.get_file_info("", "");
		byte[] download_file = storageClient1.download_file("group1", name);
		return download_file;
	}

	/**
	 * 删除图片
	 * 
	 * @param str
	 * @return 0 删除成功 非0失败 -1字符串为空	
	 */
	public static int deletePic(String str) {
		StorageClient1 storageClient1 = getStorageClient();
		int i = 1;
		// group1/M00/00/00/wAnIhlbeQCuAMedMAABEBMZLKCQ210.jpg
		// String group_name = substring.substring(0,substring.indexOf("/"));
		// String remote_filename =
		// substring.substring(substring.indexOf("/")+1);
		try {
			i = storageClient1.delete_file("group1", str);
		} catch (IOException | MyException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public static void closeTrackerServer(StorageClient1 storageClient1){
		try {
			storageClient1.getTrackerServer().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static StorageClient1 getStorageClient() {
		
		// 连接tracker
		TrackerServer trackerServer = null;
		try {
			// 流
//			ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
//			ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
			ClientGlobal.init("");
			
			// 连接tracker的客户端
			TrackerClient trackerClient = new TrackerClient();
			trackerServer = trackerClient.getConnection();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		}

		StorageServer storageServer = null;
		// 连接stoage
		return new StorageClient1(trackerServer, storageServer);
	}
	
	//获取文件的字节数
			public static byte[] getBytesFromFile(File file) {  
		        byte[] ret = null;  
		        try {  
		            if (file == null) {  
		                // log.error("helper:the file is null!");  
		                return null;  
		            }  
		            FileInputStream in = new FileInputStream(file);  
		            ByteArrayOutputStream out = new ByteArrayOutputStream(4096);  
		            byte[] b = new byte[4096];  
		            int n;  
		            while ((n = in.read(b)) != -1) {  
		                out.write(b, 0, n);  
		            }  
		            in.close();  
		            out.close();  
		            ret = out.toByteArray();  
		        } catch (IOException e) {  
		            // log.error("helper:get bytes from file process error!");  
		            e.printStackTrace();  
		        }  
		        return ret;  
		    }
			
			 @SuppressWarnings("resource")
			public static Long getFileSizes(File f) throws Exception{//取得文件大小
			       long s=0;
			       if (f.exists()) {
			           FileInputStream fis = null;
			           fis = new FileInputStream(f);
			          s= fis.available();
			       } else {
			           f.createNewFile();
			           System.out.println("文件不存在");
			       }
			       return s;
			    }	
			 
			 /**
			  * 构造一个文件 
			  * @param buf
			  * @param filePath
			  * @param fileName
			  * @return
			  */
			 public static File byte2File(byte[] buf, String filePath, String fileName)  
			    {  
			        BufferedOutputStream bos = null;  
			        FileOutputStream fos = null;  
			        File file = null;  
			        try  
			        {  
			            File dir = new File(filePath);  
			            if (!dir.exists() && dir.isDirectory())  
			            {  
			                dir.mkdirs();  
			            }  
			            if(org.springframework.util.StringUtils.isEmpty(fileName)){
			            	fileName = UUID.randomUUID().toString()+".jpg";
			            }
			            file = new File(filePath + File.separator + fileName);  
			            fos = new FileOutputStream(file);  
			            bos = new BufferedOutputStream(fos);  
			            bos.write(buf);  
			            return file;
			        }  
			        catch (Exception e)  
			        {  
			            e.printStackTrace();  
			        }  
			        finally  
			        {  
			            if (bos != null)  
			            {  
			                try  
			                {  
			                    bos.close();  
			                }  
			                catch (IOException e)  
			                {  
			                    e.printStackTrace();  
			                }  
			            }  
			            if (fos != null)  
			            {  
			                try  
			                {  
			                    fos.close();  
			                }  
			                catch (IOException e)  
			                {  
			                    e.printStackTrace();  
			                }  
			            }  
			        }
			        return null;
			    }
			 
}
