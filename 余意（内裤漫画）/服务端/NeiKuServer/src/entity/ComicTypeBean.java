package entity;

public class ComicTypeBean {
	public Integer typesId;
	
	public String typeFmImgUrl;
	
	public String typeName;
	
	public Integer foreignId;
	
	
	
	public Integer getTypesId() {
		return typesId;
	}



	public void setTypesId(Integer typesId) {
		this.typesId = typesId;
	}



	public String getTypeFmImgUrl() {
		return typeFmImgUrl;
	}



	public void setTypeFmImgUrl(String typeFmImgUrl) {
		this.typeFmImgUrl = typeFmImgUrl;
	}



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public Integer getForeignId() {
		return foreignId;
	}



	public void setForeignId(Integer foreignId) {
		this.foreignId = foreignId;
	}



	@Override
	public String toString() {
		return "ComicTypeBean [foreignId=" + foreignId + ", typeFmImgUrl="
				+ typeFmImgUrl + ", typeName=" + typeName + ", typesId="
				+ typesId + "]";
	}

	
	
}
