package com.nexential.crud.pageSettings;

import org.springframework.data.domain.Sort;


public class PageSettings {


    private int page;

    private int elementPerPage;




	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getElementPerPage() {
		return elementPerPage;
	}

	public void setElementPerPage(int elementPerPage) {
		this.elementPerPage = elementPerPage;
	}

    
}
