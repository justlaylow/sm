package com.tl.sm.util;

import java.util.List;

public class PageBean<T> {
	//已知数据
	private int pageNum; //当前页，从请求那边传过来
	private int pageSize; //每页显示的数据条数
	private int totalRecord; //总的记录条数，查询数据库得到的数据
	
	//需要计算的属性
	private int totalPage; //总页数，通过totalRecord和pageSize计算可以得来
	
	//开始索引,也就是我们在数据库中从第几行数据开始拿，有了startIndex和pageSize
	//就知道了数据库分页语句的两个数据，就能获得每页需要显示的数据了
	private int startIndex;
	
	//将每页要显示的数据放在list集合中
	private List<T> list;
	
	//分页显示的页数，比如在页面上显示1,2,3,4,5页start就为1,end就为5,这个也是计算得到的
	private int start;
	private int end;
	
	//通过pageNum,pageSize,totalRecord计算得来totalPage和startIndex
	//构造方法中将pageNum,pageSize,totalRecord获得
	public PageBean(int pageNum,int pageSize,int totalRecord) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		//totalPage总页数
		if(totalRecord%pageSize == 0) {
			//说明整除,正好每页显示pageSize条数据,没有多余一页要显示少于pageSzie条数据的
			this.totalPage  =totalRecord/pageSize;
		}else {
			//不整除,就要再加一页,用来显示余出来的数据
			this.totalPage  =totalRecord/pageSize+1;
		}
		
		//开始索引
		this.startIndex = (pageNum-1)*pageSize+1;
		
		//显示5页，这里可以自己设置，想要显示几页就自己通过下面的算法修改
		this.start = 1;
		this.end = 5;
		
		//显示页数的算法
		if(totalPage <= 5) {
			//总页数小于5,那么end就为总页数的值了
			this.end = this.totalPage;
		}else {
			//总页数大于5,那么就要根据当前是第几页,来判断start和end为多少了
			this.start = pageNum-2;
			this.end = pageNum+2;
			
			if(start <= 0) {
				//如果当前页是第一页或者第二页,那么就不符合这个规则
				this.start = 1;
				this.end = 5;
			}
			if(end>this.totalPage) {
				//如果当前页是倒数第二页或则最后一页,也同样不符合规则
				this.end = totalPage;
				this.start = end - 4;
			}
		}
		
	}

	//set,get方法
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
	
}
