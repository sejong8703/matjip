package com.matjip.bean;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ReplyBean {
		@NotBlank
		private int no;
		
		@NotBlank
		private int qna_idx;
		
		@NotBlank
		private String reply;
		
		@NotBlank
		private String user_id;
		
		private String resdate;
}
