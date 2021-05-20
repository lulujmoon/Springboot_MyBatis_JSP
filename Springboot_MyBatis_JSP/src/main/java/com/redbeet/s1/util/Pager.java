package com.redbeet.s1.util;

public class Pager {

	private Long curPage;
	private Long perPage;
	
	private Long startRow;
	
	private Long perBlock;
	private Long startNum;
	private Long lastNum;
	
	private boolean pre;
	private boolean next;
	
	private String kind;
	private String search;
	

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		if(search==null) {
			search="";
		}
		this.search = search;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}
	
	
	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getCurPage() {
		if(this.curPage == null||this.curPage==0) {
			this.curPage=1L;
		}
		return curPage;
	}

	public void setCurPage(Long curPage) {
		if(curPage == null||curPage==0) {
			curPage=1L;
		}
		this.curPage = curPage;
	}

	public Long getPerPage() {
		return perPage;
	}

	public void setPerPage(Long perPage) {
		if(this.perPage == null||this.perPage==0) {
			this.perPage=10L;
		}
		this.perPage = perPage;
	}

	public Long getStartRow() {
		return startRow;
	}

	public Pager() {
		this.perBlock = 5L;
		this.perPage = 10L;
	}
	
	public void makeRow() {
		this.startRow = (this.getCurPage()-1)*this.getPerPage();
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	
	public void makeNum(Long totalCount) {
		//1. totalCount
		//2. totalCount를 이용해서 totalPage 수 구하기
		long totalPage = totalCount/this.perPage;
		if(totalCount%this.perPage!=0) {
			totalPage++;
		}
		//3. totalPage를 이용해서 totalBlock 수 구하기
		long totalBlock = totalPage/this.perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		//4. curPage를 이용해서 curBlock 구하기
		Long curBlock = this.getCurPage()/this.perBlock;
		if(this.curPage%perBlock!=0) {
			curBlock++;
		}
		//5. curBlock을 이용해서 startNum, lastNum 구하기
		this.startNum=(curBlock-1)*this.perBlock+1;
		this.lastNum = curBlock*this.perBlock;
		//6. 첫번째와 마지막 블럭 처리
		this.pre = true;
		this.next = true;
		if(curBlock == totalBlock) {
			lastNum = totalPage;
			this.next=false;
		}
		if(curBlock == 1) {
			this.pre = false;
		}
		
	}

	
}
