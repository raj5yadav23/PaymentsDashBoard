package main.java.util;

import lombok.Getter;

public class Path {
	
	public static class Web {
		@Getter public static final String TEST_PAGE="/test";
        @Getter public static final String INDEX_PAGE = "/index";
        @Getter public static final String PRIORITY_PAYMENT_PAGE = "/priorityPayment";
        @Getter public static final String CUSTOMER_TRANSFER_PAGE = "/customerTransfer";
        
    }
	
	public static class Templates {
		
		public static final String TEST_PAGE="/velocity/test.vm";
		public static final String INDEX_PAGE="/velocity/index.vm";
		public static final String PRIORITY_PAYMENT_PAGE="/velocity/priorityPayment.vm";
		public static final String CUSTOMER_TRANSFER_PAGE="/velocity/customerTransfer.vm";
	}

}
