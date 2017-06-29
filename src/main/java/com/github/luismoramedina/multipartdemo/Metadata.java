package com.github.luismoramedina.multipartdemo;

/**
 * @author luismoramedina
 */
public class Metadata {
	private Integer size;

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Metadata{");
		sb.append("size=").append(size);
		sb.append('}');
		return sb.toString();
	}
}
