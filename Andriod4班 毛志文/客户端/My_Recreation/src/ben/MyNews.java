package ben;

/// �ҵ���Ѹ�� ���ҵĵ�һ�����������
public class MyNews {
 public int id;
 public String Images;    /// ���ŵ�ͼƬ
 public String Name;     ///  ���ŵı���
 public String Time;    ///   ���ŵ�ʱ��
 public String Content;///    ���ŵ�����
 public String moviePath;
 
 public String CalendaerImagses;/// ������ʷ��ͼƬ
 public String CalendaerTel;   ////������ʷ�ĵص�
 public String CalendaerName;/// ������ʷ������
 
 
 public String VideoImages;/// ������Ƶ��ͼƬ
 public String VideoTel;///    ������Ƶ�ı���
 
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
