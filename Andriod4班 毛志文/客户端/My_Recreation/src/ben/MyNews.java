package ben;

/// 我的艺迅类 是我的第一个主界面的类
public class MyNews {
 public int id;
 public String Images;    /// 新闻的图片
 public String Name;     ///  新闻的标题
 public String Time;    ///   新闻的时间
 public String Content;///    新闻的内容
 public String moviePath;
 
 public String CalendaerImagses;/// 艺术历史的图片
 public String CalendaerTel;   ////艺术历史的地点
 public String CalendaerName;/// 艺术历史的名字
 
 
 public String VideoImages;/// 艺术视频的图片
 public String VideoTel;///    艺术视频的标题
 
 public MyNews(){}
 public MyNews(String Images,String Name,String Time,String Content,String moviePath,
		       String CalendaerImagses,String CalendaerTel,String CalendaerName,
		       String VideoImages,String VideoTel){
	 this.Images=Images;
	 this.Name=Name;
	 this.Time=Time;
	 this.Content=Content;
	 this.moviePath=moviePath;
	 this.CalendaerImagses=CalendaerImagses;
	 this.CalendaerTel=CalendaerTel;
	 this.CalendaerName=CalendaerName;
	 this.VideoImages=VideoImages;
	 this.VideoTel=VideoTel;
 }
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getImages() {
	return Images;
}
public void setImages(String images) {
	Images = images;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getTime() {
	return Time;
}
public void setTime(String time) {
	Time = time;
}
public String getContent() {
	return Content;
}
public void setContent(String content) {
	Content = content;
}
public String getMoviePath() {
	return moviePath;
}
public void setMoviePath(String moviePath) {
	this.moviePath = moviePath;
}
public String getCalendaerImagses() {
	return CalendaerImagses;
}
public void setCalendaerImagses(String calendaerImagses) {
	CalendaerImagses = calendaerImagses;
}
public String getCalendaerTel() {
	return CalendaerTel;
}
public void setCalendaerTel(String calendaerTel) {
	CalendaerTel = calendaerTel;
}
public String getCalendaerName() {
	return CalendaerName;
}
public void setCalendaerName(String calendaerName) {
	CalendaerName = calendaerName;
}
public String getVideoImages() {
	return VideoImages;
}
public void setVideoImages(String videoImages) {
	VideoImages = videoImages;
}
public String getVideoTel() {
	return VideoTel;
}
public void setVideoTel(String videoTel) {
	VideoTel = videoTel;
}
 
 
 
 


}
