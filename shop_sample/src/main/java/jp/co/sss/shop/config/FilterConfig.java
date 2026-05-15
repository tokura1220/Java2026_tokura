package jp.co.sss.shop.config;

//11章 ソースコード11-6 作成
/** 注意 **
他のサンプルプログラムの動作に影響を及ぼすため、「@Configuration」をコメントアウトしています。
動作確認をする際は、@Configurationを有効にしてください。

**/


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jp.co.sss.shop.filter.Message02Filter;
import jp.co.sss.shop.filter.Message03Filter;

//TODO ※@Configurationの部分のコメントを外すと動作します。
//TODO ※他のサンプルコードの動作に影響するため、コメントアウトしています。
//@Configuration
public class FilterConfig implements WebMvcConfigurer {
	@Bean
	public FilterRegistrationBean<Message02Filter> configMessage02Filter() {
		FilterRegistrationBean<Message02Filter> bean = new FilterRegistrationBean<Message02Filter>();

		bean.setFilter(new Message02Filter());
		bean.setOrder(2);
		return bean;
	}

	@Bean
	public FilterRegistrationBean<Message03Filter> configMessage03Filter() {
		FilterRegistrationBean<Message03Filter> bean = new FilterRegistrationBean<Message03Filter>();

		bean.setFilter(new Message03Filter());
		bean.setOrder(1);
		return bean;
	}
}
