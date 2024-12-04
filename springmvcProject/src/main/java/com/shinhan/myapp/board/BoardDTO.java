package com.shinhan.myapp.board;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder @ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
	Long board_no;
	String title;
	String content;
	String writer;
	Date regdate;
	String pic;
}
