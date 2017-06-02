package com.example;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.entity.TestJsonModel;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = DemoApplication.class)
public class DemoApplicationTests {

//	@Test
//	public void contextLoads() {
//		
//	}	117076
//	呜喔呜。在 
	/**
	 * 
	 * def getHtml(url):
    page = urllib.urlopen(url)
    html = page.read()
    return htmlcc


def getImg(html):
    reg = r'src="(.+?\.png)"'
    imgre = re.compile(reg)
    imglist = re.findall(imgre, html)
    return imglist


url = 'http://tieba.baidu.com/p/2460150866'
jdurl = "http://channel.jd.com/fashion.html"
	 * 
	 * @param args
	 * @throws Exception 
	 */
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//		HZSiInterface instance = HZSiInterface.INSTANCE;
//		int init = HZSiInterface.INSTANCE.INIT();
//		System.out.println(System.getProperty("java.library.path"));
//		System.out.println(init);
//		int i = VideoInput.INSTANCE.CreateVideoInput();
//		System.out.println(i);
//		
//		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//		Date parse = s.parse("2018-05-23");
//		System.out.println(new java.sql.Date(parse.getTime()));
//		
//		new Thread(new Runnable() {
//			public void run() {
//				System.out.println("hahaha");
//			}
//		}).start();
//		
//		int i = 0;
//		System.out.println("----------");
//		int j = i++;
//		TestController tc = new TestController();
//		try {
//			Class<?> forName = Class.forName(tc.getClass().getName());
//			Object obj = forName.newInstance();
//			Method[] declaredMethods = forName.getDeclaredMethods();
//			for (Method method : declaredMethods) {
//				String name = method.getName();
//				if("reflectMethod".equals(name)){
//					System.out.println(method.invoke(obj, null));
//				}
//				
//			}
////			
////			Method method = forName.getMethod("reflectMethod", null);
////			method.invoke(forName, null);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String host = "localhost";
//		int port = 8888;
//		try {
//			Socket socket = new Socket(host, port);
//			OutputStream os = socket.getOutputStream();
//			InputStream is = socket.getInputStream();
//			
//			int temp = 0;
//			int len ;
//			byte[] bytes = new byte[1024];
//			while((len = is.read(bytes))!= -1){
//				os.write(bytes,0,len);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		String str = "60810154539-8140-3268^1^8140|8801206861|201608101540|IBSJS0020|1|20160810153600|20160810154539-8140-3268|2.3|0.0|2.3|0.0|2.3|0.0|0.0|0.0|2.3|0.0|2000.0|1997.7|0|0.0|0.0|0.0|0.0|20160810155517|20160810130659-8140-00000621-6643|201608101554321470|0.0|0.0|0.0|0.0|0.0|0.0|0.0|0.0||0.0|0.0|0.0|2.3|0.0|0.0|0.0|0.0|0.0|0.0|0.0|0|^0|||^";
//		String[] strs = str.split("\\^");
//		for (int i = 0; i<strs.length;i++) {
//			if(i==2){
//				System.out.println(strs[i]);
//				String[] items = strs[i].split("\\|");
//				for (int j = 0;j<items.length;j++) {
//					System.out.println(items[j]);
//				}
//				System.out.println("共有【"+items.length+"】项");
//			}
//		}
//		String str= "ddkk.jpg";
//		System.out.println(str.substring(str.lastIndexOf(".")+1).toUpperCase());
//		if("BMP、JPG、JPEG、PNG、GIF".contains(str.substring(str.lastIndexOf(".")+1).toUpperCase()))
//			System.err.println("true");
		
//		BigDecimal max = new BigDecimal(2);
//		BigDecimal min = new BigDecimal(1);
//		if(max.compareTo(min) == -1){
//			System.out.println("2323232323232323");
//		}
		
		//kqng kngf kqng ,wygd gdrn rtfp vb kb .fuxk rqry lt .je gd e gk kcg .
//		        Map<Number, String> map1 = new HashMap<Number, String>();  
//		        Map<Number, String> map2 = new HashMap<Number, String>();  
//		          
//		        map1.put(1, "a");  
//		        map1.put(2, "b");  
//		        map1.put(3, "c");  
//		        map1.put(4, "d");  
//		        map1.put(5, "e");  
//		          
//		        map2.put(1, "g");  
//		        map2.put(2, "f");  
//		        map2.put(3, "c");  
//		        map2.put(4, "t");  
//		        map2.put(5, "e");  
//		          
//		        boolean isEquals = false;  
//		          
//		        for(Object o : map1.keySet()){  
//		            isEquals = map2.containsKey(o);  
//		            if(isEquals){  
//		                isEquals = map1.get(o).equals(map2.get(o));  
//		            }  
//		            if(isEquals){  
//		                map2.remove(o);  
//		            }  
//		        }  
//		        for(Object o : map2.keySet()){  
//		            System.out.println(o.toString() + ":" + map2.get(o));  
//		        }  
		
		
//		Map<Integer, String> map = new HashMap<>();
//		map.put(1, "22");
//		map.put(1, "33");
//		System.out.println(map.size());
//		Process exec = Runtime.getRuntime().exec("python ");
//		Runtime runtime = Runtime.getRuntime();
//		BufferedReader in = new BufferedReader(new InputStreamReader(
//				exec.getInputStream()));
//		String line;
//		while ((line = in.readLine()) != null) {
//			System.out.println(line);
//		}
//		in.close();
//		exec.waitFor();
//		String htmlStr = "sdf dsf sdf <img src='http://hs-album.oss.aliyuncs.com/static/45/b8/56/image/20161017/20161017172458_40828.jpg'  />sdf sdf sdf";
//		List<String> imgStr = getImgStr(htmlStr);
//		System.out.println(imgStr);
		
//		File file = new File("D:\\test_.txt");
//		byte[] pic = UploadUtils.getBytesFromFile(file);
//		String uploadPic = UploadUtils.uploadPic(pic, "test_.txt", (long)pic.length);
//		int deletePic = UploadUtils.deletePic("M00/00/00/wKhQg1ghZYaAVyYLAAAAITyMHIs814.txt");
//		System.out.println(deletePic);
//		byte[] download = UploadUtils.download("M00/00/00/wKhQg1ghN02ACq9RAADvxVfoiJo359.jpg");
//		UploadUtils.byte2File(download, "d:/", null);
		//M00/00/00/wKhQg1ghN02ACq9RAADvxVfoiJo359.jpg
		//// group1/M00/00/00/wAnIhlbeQCuAMedMAABEBMZLKCQ210.jpg
		
//		String str  = "group1/M00/00/00/wAnIhlbeQCuAMedMAABEBMZLKCQ210.jpg";
//		String group = str.substring(0, str.indexOf("/"));
//		System.out.println(group);
//		System.out.println(str.replace(group+"/", ""));
		
//		String beforeUrl1 = "http://localhost:8080/o2o/order/chooseTicket?goodsIds=32&elecIds=2";
//		String beforeUrl = "http://localhost:8080/o2o/order/chooseTicket?goodsId=1005&goodsQty=2&dliMethod=2&payMethod=2";
//		beforeUrl = StringUtils.removeRequestParam(beforeUrl, "elecIds");
//		System.out.println(beforeUrl);
//		
//		String[] names = {"o2o","zhuanshu","001", "01", "002", "011", "012",
//				"013", "仓库盘点", "会员管理", "库房管理", "零售前台", 
//				"首页最新副本01_spec", "通讯录", "统计分析", "系统设置", "员工考勤", "在线培训", "在线销售"}; 
//		for (String  name : names) {
//			File file = new File("D:\\resources\\o2o\\img\\app\\"+name+".png");
//			byte[] pic = UploadUtils.getBytesFromFile(file);
//			String uploadPic = UploadUtils.uploadPic(pic, name+".png", (long)pic.length);
//			System.out.println("name :" + name+".png" + "    url :" + uploadPic);
//		}
		
//		int deletePic = UploadUtils.deletePic("M00/00/00/wKhQhVh-4I6AVkCEAAALE4HLIr4618.png");
//		System.out.println(deletePic);
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date parse = format.parse("2016-11-18 11:34:37");
//		Date endTime = new Date(new Date().getTime() - Integer.valueOf(7) * 24 * 60 * 60 * 1000);
//		long time = parse.getTime() - endTime.getTime();
//		if(time<0)
		
//		ConcurrentLinkedQueue<String> s = new ConcurrentLinkedQueue<>();
//		s.add("ss");
//		s.offer("offer");
//		s.poll();
//		System.out.println(s.toString());
//		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//		for (StackTraceElement stackTraceElement : stackTrace) {
//			System.out.println(stackTraceElement.toString());
//			
//		}
//		MDC.put("mdc_key", "mdc_value");
//		System.out.println(MDC.get("mdc_key"));
//		BigDecimal a = new BigDecimal(15);
//		BigDecimal b = new BigDecimal(32);
//		System.out.println(b.divideToIntegralValue(a));
		
//		DemoApplicationTests t = new DemoApplicationTests();
//		t.sendTemplate("dsdsdsdss", new BigDecimal(3), new BigDecimal(232), "moblie", new Date());
//		String s = "hhh";
//		switch (s) {
//		case "hhh":
//			System.out.println(s);
//			break;
//		case "hh":
//			System.out.println(s);
//			
//
//		default:
//			break;
//		}
//		if(signInQty%5 == 4){
//		int remainderDays = signInQty%daysQty == 0 ? daysQty : (daysQty-signInQty%daysQty);
//		int  signInQty = 5;
//		
//		Socket socket = new Socket();
//		socket.setReuseAddress(true);
		
//		Instant instant1 = Instant.now();
//		System.out.println(instant1);
//		Thread.sleep(1000);
//		 Instant instant = Instant.now();
//		long diffAsMinutes =instant.periodUntil(instant1, ChronoUnit.MINUTES); // 方法1 
//		long diffAsMinutes = ; // 方法2
//		System.out.println(ChronoUnit.SECONDS.between(instant1, instant) + "秒");
//		LocalDateTime localDateTime = LocalDateTime.now(); 
//		System.out.println(localDateTime.toLocalDate());
//		System.out.println(localDateTime.toLocalTime());
//		//当前时间加上25小时３分钟 
//		LocalDateTime inTheFuture = localDateTime.plusHours(25).plusMinutes(3); 
//		// 同样也可以用在localTime和localDate中 
//		System.out.println(localDateTime.toLocalTime().plusHours(25).plusMinutes(3)); 
//		System.out.println(localDateTime.toLocalDate().plusMonths(2)); 
//		// 也可以使用实现TemportalAmount接口的Duration类和Period类 
//		System.out.println(localDateTime.toLocalTime().plus(Duration.ofHours(25).plusMinutes(3))); 
//		System.out.println(localDateTime.toLocalDate().plus(Period.ofMonths(2)));
//		String s = null;
//		List<String> list = new ArrayList<>();
//		list.add(s);
//		System.out.println(list);
//		System.out.println(list.get(0));
		Random r = new Random();
		System.out.println(r.nextLong());
		
	}
	
	public static boolean isNumeric(String str){ 
	    Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches();    
	 } 
	
	public void test(BigDecimal a){
		a = new BigDecimal(20);
	}
	
	public void sendTemplate(String openid, Object...args ) {
		  for(int i=0;i<args.length;i++){
			  if(args[i] instanceof String){
				  
			  }
			  System.out.println(args[i]);
		  }
	}
	
	
	/**
     * 得到网页中图片的地址
      */
    public static List<String> getImgStr(String htmlStr){   
         String img="";   
         Pattern p_image;   
         Matcher m_image;   
         List<String> pics = new ArrayList<String>();

    //     String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址  

           String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>"; 
         p_image = Pattern.compile 
                 (regEx_img,Pattern.CASE_INSENSITIVE);   
        m_image = p_image.matcher(htmlStr); 
        while(m_image.find()){   
             img = img + "," + m_image.group();   
            // Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //匹配src

            Matcher m  = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);

             while(m.find()){
                 pics.add(m.group(1));
             }
         }   
            return pics;   
     }  
    
//    public static Boolean isAdmin(UserRole role){
//    	return role.equals(UserRole.ADMIN);
//    }
}









