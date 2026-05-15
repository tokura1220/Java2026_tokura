package jp.co.sss.shop.filter;

//11章 ソースコード11-1 作成
/** 注意 **
他のサンプルプログラムの動作に影響を及ぼすため、「@Component」をコメントアウトしています。
動作確認をする際は、@Componetを有効にしてください。

**/

import java.io.IOException;

//import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO ※@Componentの部分のコメントを外すと動作します。
//TODO ※他のサンプルコードの動作に影響するため、コメントアウトしています。
//@Component
public class Message01Filter extends HttpFilter {
     @Override
     public void doFilter(
          HttpServletRequest request, HttpServletResponse response, FilterChain chain)
             throws IOException, ServletException {
         System.out.println("Done Message01Filter");
         chain.doFilter(request, response);
     }
}
