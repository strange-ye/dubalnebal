//package com.strangeye.dubalnebal.controller;
//
//import io.swagger.annotations.ApiOperation;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.*;
//import java.net.MalformedURLException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@RestController
//public class ImageController {
//
//	@GetMapping(value="/image/view", produces= MediaType.IMAGE_PNG_VALUE)
//	public @ResponseBody byte[] getImage(@RequestParam("file_time") String fileTime, // yyyymmdd_HHmmssZ
//										 @RequestParam("value") String value) // A
//			throws IOException{
//		FileInputStream fis = null;
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//		String[] fileAr = fileTime.split("_");
//		String filePath = fileAr[0];
//
//		String fileDir = "C:Users/sangholee/Github/dubalnebal/src/main/resources/static/files" + // 파일경로
//
//		try{
//			fis = new FileInputStream(fileDir);
//		} catch(FileNotFoundException e){
//			e.printStackTrace();
//		}
//
//		int readCount = 0;
//		byte[] buffer = new byte[1024];
//		byte[] fileArray = null;
//
//		try{
//			while((readCount = fis.read(buffer)) != -1){
//				baos.write(buffer, 0, readCount);
//			}
//			fileArray = baos.toByteArray();
//			fis.close();
//			baos.close();
//		} catch(IOException e){
//			throw new RuntimeException("File Error");
//		}
//		return fileArray;
//	}
//}
//
////
////@RestController
////@RequestMapping("/api")
////public class ImageController {
////	private static final String IMAGE_DIRECTORY = "/Users/sangholee/Github/dubalnebal/src/main/resources/static.files";
////
////	// feed image 반환하기
////	@ApiOperation(value = "feed image 조회 ", notes = "feed Image를 반환합니다. 못찾은경우 기본 image를 반환합니다.")
////	@GetMapping(value = "image/{imagename}", produces = MediaType.IMAGE_JPEG_VALUE)
////	public ResponseEntity<byte[]> userSearch(@PathVariable("imagename") String imagename) throws IOException {
////		InputStream imageStream = new FileInputStream("C://images/feed/" + imagename);
////		byte[] imageByteArray = IOUtils..(imageStream);
////		imageStream.close();
////		return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
////	}
//////	@GetMapping("/images/{filename}")
//////	public ResponseEntity<Resource> serveImage(@PathVariable String filename) {
//////		try {
//////			Path imagePath = Paths.get(IMAGE_DIRECTORY).resolve(filename);
//////			Resource imageResource = new UrlResource(imagePath.toUri());
//////
//////			if (imageResource.exists() && imageResource.isReadable()) {
//////				HttpHeaders headers = new HttpHeaders();
//////				headers.setContentType(MediaType.); // 이미지 파일의 타입에 맞게 설정합니다.
//////
//////				return ResponseEntity.ok()
//////						.headers(headers)
//////						.body(imageResource);
//////			}
//////		} catch (MalformedURLException e) {
//////			e.printStackTrace();
//////		}
//////
//////		return ResponseEntity.notFound().build();
//////	}
////}