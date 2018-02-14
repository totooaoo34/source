import javax.xml.crypto.Data;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 *我的数据类 
 **/
public class DataServer {
	//// 艺询的资料
	static String TvName[] = { "2015年3月下旬起在北京保利国际拍卖有限公司(以下称“保利公司”)展出的齐白石《山水十二条屏》",
		                       "蛋壳也能玩成艺术品 蛋壳也能玩成艺术品 蛋壳也能玩成艺术品 蛋壳也能玩成艺术品",
		                       "2015年武汉春季文物艺术品博览会暨第四届全国古玩城联合展销会即将在武汉古玩城盛大开幕",
		                       "充电器中的艺术品 MOMAX公牛5 USB充电器上市 丰富的数码产品让我们的生活更加便利", 
		                       "明式家具:可传世的艺术品明式家具楚天金报讯红木鉴赏栏目主持:湖北省传统家具委员会执行会长",
		                       "让艺术品走出展馆,走进生活,把高雅艺术带到普通老百姓的身边,尽管经费困难,万沛的梦想仍如当初那般坚定", 
		                       "并且,“读万卷书、看万卷画”的资深鉴定专家的日趋高龄化,给鉴定领域工作带来的困境,成为艺术品鉴定领域迫切需要解决的重大问题之一", 
		                       "刘益谦自辩:我没抵押一件艺术品 在中纪委官网发文抨击“雅贿”的背景下,今年3月,刘益谦两度高调参与竞拍。他向记者表示:在中国,银行就没有艺术品抵押业务", 
		                       "改革开放的大潮使中国艺术品市场获得了全面复苏,逐步走向兴盛繁荣。艺术品拍卖与收藏走向生活,商品化、消费化、金融化似乎已经是无", 
		                       "2015年过去近一季,2014年中国文物与艺术品市场的数据才刚刚出台,相关机构、人士虽然付出了许多的心血汗水,但是,回头望去:平和又一年",
		                       "目前,中国的艺术品市场,对于藏家来说,有好的一面:如果把泡沫、水分挤掉了,正是收藏的好时机。有鉴于此,藏家需要像安思远一样,和艺术品朝夕相对,多一点从艺术品"};
	    
    ////艺询的资料
	static String TvImage[] = { "a1.png", "a2.png", "a3.png", "a4.png", "a5.png", "a6.png",
		"a7.png", "a9.png", "a10.png", "a11.png", "a12.png"};
	
	
	/// 艺展的视频
	static String TvMovie[] = { "1.mp4", "2.mp4", "3.mp4", "4.mp4", "1.mp4", "3.mp4",
		"1.mp4", "2.mp4", "3.mp4", "4.mp4", "1.mp4", "2.mp4", "3.mp4", "4.mp4",
		"1.mp4", "2.mp4", "3.mp4", "4.mp4","1.mp4", "2.mp4", "3.mp4", "4.mp4","1.mp4", "2.mp4", "3.mp4", "4.mp4","2.mp4"};
	
	
	
	 /// 艺术历史的名字
	static String  Calendername[]={"讲述两室同堂","蛋壳是如何成为艺术品的","古老的文物","时尚的艺术品","明朝的椅子","油画的故事","讲述两室同堂","蛋壳是如何成为艺术品的","古老的文物","时尚的艺术品","明朝的椅子","油画的故事"};
	/// 艺术历史的资料
	 static String CalenderTel[]={"现藏台北故宫博物院","英国王室之宝","先保存在北京圆明园西洋楼海晏堂","藏于湖北省博物馆","现藏武汉湖北省博物馆","杭州文物考古研究所","现藏台北故宫博物院","英国王室之宝","先保存在北京圆明园西洋楼海晏堂","藏于湖北省博物馆","现藏武汉湖北省博物馆","杭州文物考古研究所"};
	/// 艺术历史的图片
	static String CalenderImages[]={"y1.png","y2.png","y3.png","y4.png","y5.png","y6.png","y1.png","y2.png","y3.png","y4.png","y5.png","y6.png"};
	
	
	/// 艺视图片
	static String VideoImages[]={"v1.jpg","v2.jpg","v3.jpg","v4.jpg","v1.jpg","v2.jpg","v3.jpg","v4.jpg","v1.jpg","v2.jpg","v3.jpg","v4.jpg"};
	static String VideoTel[]={ "郭润文,成子君油画亮相美丽国际艺术俱乐部实施计划实话实说","在当代2014年中中国油画所属的俱乐部日渐增多，越来越多的俱乐部加入到当前的艺术的潮流中","中国的油画将走向水解化,越来越都的中国的油画家将目光投向了国外","李寅生《神工》画集首发式在国博举行",
		                       "郭润文,成子君油画亮相美丽国际艺术俱乐部实施计划实话实说","在当代2014年中中国油画所属的俱乐部日渐增多，越来越多的俱乐部加入到当前的艺术的潮流中","中国的油画将走向水解化,越来越都的中国的油画家将目光投向了国外","李寅生《神工》画集首发式在国博举行",
		                       "郭润文,成子君油画亮相美丽国际艺术俱乐部实施计划实话实说","在当代2014年中中国油画所属的俱乐部日渐增多，越来越多的俱乐部加入到当前的艺术的潮流中","中国的油画将走向水解化,越来越都的中国的油画家将目光投向了国外","李寅生《神工》画集首发式在国博举行"};
	/// 艺视的标题
	static public String getMovieData(){
		 JSONObject root=new JSONObject();
		 JSONArray array=new JSONArray();
		 
		 for (int i = 0; i < TvName.length; i++) {
			 JSONObject data=new JSONObject();
			 data.put("name", TvName[i]);
			 data.put("imageUrl", TvImage[i]);
			 data.put("movie", TvMovie[i]);
		
			 data.put("CaName", Calendername[i]);
			 data.put("tel", CalenderTel[i]);
			 data.put("Images", CalenderImages[i]);
			 
			 data.put("videotel", VideoTel[i]);
			 data.put("videoimages", VideoImages[i]);
			 array.add(data);
		}
		 root.put("list", array);
		 
		return root.toString();
		 
	}

}
