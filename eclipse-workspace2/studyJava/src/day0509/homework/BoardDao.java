package day0509.homework;

import java.util.*;

import day0509.Customer;

public class BoardDao {
	private List<Board> list = new ArrayList<>();

	BoardDao(){
		list.add(new Board("제목1","내용1"));
		list.add(new Board("제목2","내용2"));
		list.add(new Board("제목3","내용3"));
	}
	public List<Board> getBoardList() {
		return list;
	}
}
