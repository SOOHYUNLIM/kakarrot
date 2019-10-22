package org.kakarrot.domain;

import lombok.extern.log4j.Log4j;

@Log4j
public class Paging {
	private int page, amount;

	public Paging() {
		this.page = 1;
		this.amount = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			log.info("잘못된 페이지 번호");
			return;
		}
		this.page = page;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
