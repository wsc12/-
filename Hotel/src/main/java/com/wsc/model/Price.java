package com.wsc.model;

public class Price {
			private Integer id;
			private String startDate; 
			private String endDate;
			private Float price;
			private Float discount;
			private Float lastPrice;
			private Integer kid;
			private Kind kd;
			public Kind getKd() {
				return kd;
			}
			public void setKd(Kind kd) {
				this.kd = kd;
			}
			public Integer getKid() {
				return kid;
			}
			public void setKid(Integer kid) {
				this.kid = kid;
			}
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}
			public String getStartDate() {
				return startDate;
			}
			public void setStartDate(String startDate) {
				this.startDate = startDate;
			}
			public String getEndDate() {
				return endDate;
			}
			public void setEndDate(String endDate) {
				this.endDate = endDate;
			}
			public Float getPrice() {
				return price;
			}
			public void setPrice(Float price) {
				this.price = price;
			}
			public Float getDiscount() {
				return discount;
			}
			public void setDiscount(Float discount) {
				this.discount = discount;
			}
			public Float getLastPrice() {
				return lastPrice;
			}
			public void setLastPrice(Float lastprice) {
				this.lastPrice = lastprice;
			}
			
}
