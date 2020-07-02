package com.NetSet.NetSet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ProductPicture {
	
	@Id
    @GeneratedValue
    private Integer id;
	
    private String filetype;

    private String filename;

    @Lob
    private  byte[] data;

	public ProductPicture(String filetype, String filename, byte[] data) {
		super();
		this.filetype = filetype;
		this.filename = filename;
		this.data = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
    
    

}
