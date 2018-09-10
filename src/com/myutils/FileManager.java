package com.myutils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *  上传文件工具类
 */
public class FileManager {
	/**
	 * 构造方法
	 */
	public FileManager() {
		super();
	}

	/**
	 *  格式化图片数组
	 */
	public static String[] formatArrStr(String string[],String startStr ){
		
		if(string == null || "".equals(string[0])){
			return null;
		}
		
		for (int i = 0; i < string.length; i++) {
			String str = string[i].replaceAll("\\\\", "/");
			int index =str.indexOf(startStr);
			string[i]=str.substring(index);
		}
		
		return string;
	}
	
	
	/**
	 *  上传文件
	 */
	public static String myUpLoadFile(HttpSession session,String path,File picture[],String pictureFileName[]){
		
		String filepath = (String) session.getAttribute("zhengjianfilepath");
//		判断得到的路径是否为空
		if(filepath==null){
			filepath="";
		}
		
		try {
			for (int i = 0; i < picture.length; i++) {
				String filename = System.currentTimeMillis()+pictureFileName[i];
				filepath=filepath+ path+"/"+filename+",";
				FileUtils.copyFile(picture[i], new File(path,filename));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	/**
	 *  上传单个文件
	 */
	public static String singleUploadFile(File file , String fileName, String path ,Long currentTime){
		
		String filePath="#";
		if(file != null){
			filePath=path+"\\"+currentTime+fileName;
			
			try {
				FileUtils.copyFile( file, new File(path,currentTime+fileName) );
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return filePath;
	}
	
	/**
	 *  删除文件
	 */
	public static boolean deleteFile(String filepath){
		boolean flag =false;
		File file = new File(filepath);
		if(file.isFile() && file.exists()){
			file.delete();
			flag=true;
		}
		return flag;
	}
	
	/**
	 *  删除文件数组
	 */
	public static void deleteFileArr(String filepath[]){
		
		for (int i = 0; i < filepath.length; i++) {
			File file = new File(filepath[i]);
			if(file.isFile() && file.exists()){
				file.delete();
			}
		}
	}
	
	/**
	 *  删除和添加图片路径
	 */
	public static String deleteAndAddPicturePath(String pictureArr[], List<String> addpicturelist, List<String> deletepicturelist){
		for (int i = 0; i < pictureArr.length; i++) {
			for (int j = 0; j < deletepicturelist.size(); j++) {
				if(pictureArr[i].equals(deletepicturelist.get(j))){
					pictureArr[i]="isnull";
				}
			}
		}
//		删除文件
		for (int i = 0; i < deletepicturelist.size(); i++) {
			deleteFile(deletepicturelist.get(i));
		}
//		创建对象,往里添加路径
		String tupianpath="";
		for (int i = 0; i < pictureArr.length; i++) {
			if("isnull".equals(pictureArr[i]) || "".equals(pictureArr[i]) || pictureArr[i]==null){
				continue;
			}
//			注意最后要添加逗号
			tupianpath=tupianpath+pictureArr[i]+",";
		}
		for (int i = 0; i < addpicturelist.size(); i++) {
//			因为该集合里已经添加逗号所以不用添加
			tupianpath=tupianpath+addpicturelist.get(i);
		}
		return tupianpath;
	}
	
	/**
	 *  格式化文件路径
	 */
	public static String formatFilePath(String path){
		if("#".equals(path) || path == null){
			return path;
		}
		
		path= path.replaceAll("\\\\", "/");
		int index =path.indexOf("uploads");

		return path.substring(index);
	}
	
	/**
	 *  删除upload路径的文件
	 */
	public static void deleteUpLoadFile(String str){
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getRealPath("/");
		str = str.replaceAll("/","\\\\") ;
		
		path = path+ str;
		File file = new File(path);
		if(file.isFile() && file.exists()){
			file.delete();
		}
	}
	
}
