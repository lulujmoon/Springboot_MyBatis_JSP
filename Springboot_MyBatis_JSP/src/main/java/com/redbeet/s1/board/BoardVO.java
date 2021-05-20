package com.redbeet.s1.board;

import java.sql.Date;
import java.util.List;

import lombok.Data;

/*
@Getter									//getter 메서드
@Setter									//setter 메서드
@ToString								//toString override
@NoArgsConstructor						//default 생성자
@AllArgsConstructor						//매개변수가 있는 생성자
@EqualsAndHashCode						//equals 메서드와 hash 메서드 override
@RequiredArgsConstructor				//필수 매개변수만 있는 생성자
*/

@Data									//lombok의 모든 annotation 선언
public class BoardVO {

	private long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private long hit;

}
