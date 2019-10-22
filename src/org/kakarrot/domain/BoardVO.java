package org.kakarrot.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class BoardVO {
	private long bno;
	private String title,content,writer;
	private Date regdate,updatedate;
}
